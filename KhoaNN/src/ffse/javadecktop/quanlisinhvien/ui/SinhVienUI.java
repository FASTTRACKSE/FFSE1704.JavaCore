package ffse.javadecktop.quanlisinhvien.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ffse.javadecktop.quanlisinhvien.dao.*;
import ffse.javadecktop.quanlisinhvien.entyti.SinhVien;
import javafx.scene.layout.Border;


public class SinhVienUI extends JFrame {
	/**
	 * 
	 */
	JLabel lblTitle;
	DefaultTableModel table = new DefaultTableModel();
	JTextField txtUser = new JTextField(20);
	JTextField txtCode = new JTextField(20);
	JTextField txtArg = new JTextField(20);
	JButton btnadd = new JButton("Thêm ");
	JButton btnedit = new JButton("Sửa ");
	JButton btndelete = new JButton("Xóa ");
	JButton btnexit = new JButton("Thoát ");
	JButton btnimport = new JButton("Nhập ");
	JTable tbl;
	JRadioButton rad1, rad2;
	JComboBox<String> cbo = new JComboBox<String>();
	public static SinhVienDAO sinhVienDAO = new SinhVienDAO();
	public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

	MouseListener tblUserClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			txtCode.setEditable(false);
			int row = tbl.getSelectedRow();
			String maSV = (String) tbl.getValueAt(row, 0);
			txtCode.setText(maSV);
			String lopSV = (String) tbl.getValueAt(row, 1);
			cbo.setSelectedItem(lopSV);

			String tenSinhVien = (String) tbl.getValueAt(row, 2);
			txtUser.setText(tenSinhVien);

			String gtSV = (String) tbl.getValueAt(row, 3);
			if (gtSV.equals("Nam")) {
				rad1.setSelected(true);
			} else {
				rad2.setSelected(true);
			}

			String tuoiSinhVien = (String) tbl.getValueAt(row, 4);
			txtArg.setText(tuoiSinhVien);
		}
	};

	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "YES", "NO", JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		}
	};
	ActionListener btAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (txtCode.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin ");
			} else {
				themSinhVien();
			}

		}
	};
	ActionListener btdeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtCode.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin ");
			} else {
				xoaSinhVien();

			}

		}
	};
	ActionListener bteditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtCode.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin ");
			} else {
				suaSinhVien();
			}

		}
	};
	ActionListener btimportClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nhapSinhVien();
			txtCode.setEditable(true);
			JOptionPane.showMessageDialog(null, "Bạn muốn nhập thông tin");

		}
	};
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void themSinhVien() {
		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtCode.getText();
		String lopSinhVien = cbo.getSelectedItem().toString();
		String tuoiSinhVien = txtArg.getText();
		String gioiTinh = gioiTinh();
		sinhVienDAO.add(new SinhVien(maSinhVien, lopSinhVien, tenSinhVien, gioiTinh, tuoiSinhVien));
		table.addRow(new String[] { maSinhVien, lopSinhVien, tenSinhVien, gioiTinh, tuoiSinhVien });
	}

	public void xoaSinhVien() {
		String maSV = txtCode.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			sinhVienDAO.delete(maSV);
			table.removeRow(rows[i] - i);

		}
	}

	public void suaSinhVien() {
		String maSinhVien = txtCode.getText();
		String lopSinhVien = cbo.getSelectedItem().toString();
		String tenSinhVien = txtUser.getText();
		String gioiTinh = gioiTinh();
		String tuoiSinhVien = txtArg.getText();

		SinhVien sv = new SinhVien(maSinhVien, lopSinhVien, tenSinhVien, gioiTinh, tuoiSinhVien);

		sinhVienDAO.edit(sv);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSinhVien, row, 0);
		tbl.setValueAt(lopSinhVien, row, 1);
		tbl.setValueAt(tenSinhVien, row, 2);
		tbl.setValueAt(gioiTinh, row, 3);
		tbl.setValueAt(tuoiSinhVien, row, 4);

	}

	public void getTable() {
		arr = sinhVienDAO.getDSSinhVien();
		for (int i = 0; i < arr.size(); i++) {

			table.addRow(new String[] { arr.get(i).getMaSinhVien(), arr.get(i).getLopSinhVien(),
					arr.get(i).getTenSinhVien(), arr.get(i).getGioiTinhSinhVien(), arr.get(i).getTuoiSinhVien() });
		}
	}

	public void nhapSinhVien() {
		txtCode.setText("");
		txtUser.setText("");
		txtArg.setText("");
	}

	public String gioiTinh() {
		String GioiTinh;
		if (rad1.isSelected()) {
			return GioiTinh = "Nam";
		} else if (rad2.isSelected()) {
			return GioiTinh = "Nữ";
		} else {
			return GioiTinh = "null";
		}
	}
	public void addConTrol() {

		// tạo container
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnCob = new JPanel();
		JLabel lblCob = new JLabel("Lớp");
		
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		pnCob.add(lblCob);
		pnCob.add(cbo);

		// tiêu đề
		JPanel pnTitle = new JPanel();		
		lblTitle = new JLabel("Chương Trình Quản Lý Sinh Viên  ");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User Nhập thông tin sinh viên
		JPanel pnCodeInfo = new JPanel();
		JLabel lblCode = new JLabel("Mã sinh viên:");
		pnCodeInfo.add(lblCode);
		pnCodeInfo.add(txtCode);

		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("Tên sinh viên:");
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);

		JPanel pnArgInfo = new JPanel();
		JLabel lblArg = new JLabel("Tuổi sinh viên:");
		pnArgInfo.add(lblArg);
		pnArgInfo.add(txtArg);

		// giới tính sinh viên
		JPanel pnGroup = new JPanel();
		pnGroup.setLayout(new BoxLayout(pnGroup, BoxLayout.X_AXIS));
		javax.swing.border.Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		TitledBorder titlebor = new TitledBorder(raisedBevel, "Giới tính");
		pnGroup.setBorder(titlebor);
		rad1 = new JRadioButton("Nam");
		rad2 = new JRadioButton("Nữ");

		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		pnGroup.add(rad1);
		pnGroup.add(rad2);
		add(pnGroup);

		// tạo button
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		
		JLabel lbkc = new JLabel("        ");
		JLabel lbkc1 = new JLabel("        ");
		JLabel lbkc2 = new JLabel("        ");
		JLabel lbkc3 = new JLabel("        ");
		JLabel lbkc4 = new JLabel("        ");
		JLabel lbkc5 = new JLabel("        ");

		pnBox.add(btnadd);
		pnBox.add(lbkc);
		pnBox.add(btnedit);
		pnBox.add(lbkc1);
		pnBox.add(btndelete);
		pnBox.add(lbkc2);
		pnBox.add(btnexit);
		pnBox.add(lbkc3);
		pnBox.add(btnimport);

		// tạo bảng table

		table.addColumn("Mã");
		table.addColumn("Lớp");
		table.addColumn("Tên");
		table.addColumn("Giới Tính");
		table.addColumn("Tuổi");
		this.getTable();
		tbl = new JTable(table);
		JScrollPane sc = new JScrollPane(tbl);

		// thêm vào main
		pnMain.add(pnTitle);
		pnMain.add(pnCob);
		pnMain.add(pnCodeInfo);
		pnMain.add(pnUserInfo);
		pnMain.add(pnArgInfo);
		pnMain.add(pnGroup);
		pnMain.add(lbkc5);
		pnMain.add(pnBox);
		pnMain.add(lbkc4);
		pnMain.add(sc);
		con.add(pnMain);
	}

	public void addEvents() {
		tbl.addMouseListener(tblUserClick);
		btnexit.addActionListener(btnExitClick);
		btnadd.addActionListener(btAddClick);
		btndelete.addActionListener(btdeleteClick);
		btnedit.addActionListener(bteditClick);
		btnimport.addActionListener(btimportClick);
	}

	public SinhVienUI(String title) {
		super(title);
		addConTrol();
		addEvents();
	}

	public void showView() {
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
