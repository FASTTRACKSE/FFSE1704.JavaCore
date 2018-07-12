package fasttrackse.java.until;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ChuongTrinhQuanLySinhVienUI extends JFrame {
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
	JComboBox<String> cbo = new JComboBox<String>();

	// sự kiện Click thoát chương trình
	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
			
		}
	};
	ActionListener btAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			themSinhVien();
			

		}
	};
	ActionListener btdeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			xoaSinhVien();
			

		}
	};
	ActionListener bteditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			suaSinhVien();
			
		}
	};
	ActionListener btimportClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nhapSinhVien();
			JOptionPane.showMessageDialog(null, "Bạn muốn nhập thông tin");

		}
	};
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

			int row = tbl.getSelectedRow();
			String lopSV = (String) tbl.getValueAt(row, 1);
			txtCode.setText(lopSV);
			String maSV = (String) tbl.getValueAt(row, 0);
			txtCode.setText(maSV);

			String tenSinhVien = (String) tbl.getValueAt(row, 2);
			txtUser.setText(tenSinhVien);

			String tuoiSinhVien = (String) tbl.getValueAt(row, 3);
			txtArg.setText(tuoiSinhVien);
		}
	};
	

	public void themSinhVien() {
		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtCode.getText();
		String lopSinhVien = cbo.getSelectedItem().toString();
		String tuoiSinhVien = txtArg.getText();

		table.addRow(new String[] { maSinhVien, lopSinhVien, tenSinhVien, tuoiSinhVien });
	}
	public void xoaSinhVien() {
		
		int[] rows = tbl.getSelectedRows();
		   for(int i=0;i<rows.length;i++){
		     table.removeRow(rows[i]-i);
		     
		   }
	}
	public void suaSinhVien() {
		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtCode.getText();
		String lopSinhVien = cbo.getSelectedItem().toString();
		String tuoiSinhVien = txtArg.getText();
		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSinhVien,row, 0);
		tbl.setValueAt(lopSinhVien,row, 1);
		tbl.setValueAt(tenSinhVien,row, 2);
		tbl.setValueAt(tuoiSinhVien,row, 3);
	
	}
	public void nhapSinhVien() {
		txtCode.setText("");
		txtUser.setText("");
		txtArg.setText("");
	}
	public void addConTrol() {

		// tạo container
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnCob = new JPanel();
		JLabel lblCob = new JLabel("Lớp");
		lblCob.setForeground(Color.BLUE);
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		pnCob.add(lblCob);
		pnCob.add(cbo);

		// tiêu đề
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.LIGHT_GRAY);
		lblTitle = new JLabel("Chương Trình Quản Lý Sinh Viên fasttrack SE ");
		lblTitle.setForeground(Color.RED);
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

		// tạo button
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btnadd.setForeground(Color.RED);
		btnedit.setForeground(Color.GREEN);
		btndelete.setForeground(Color.PINK);
		btnexit.setForeground(Color.BLUE);
		btnimport.setForeground(Color.ORANGE);

		JLabel lbkc = new JLabel("        ");
		JLabel lbkc1 = new JLabel("        ");
		JLabel lbkc2 = new JLabel("        ");
		JLabel lbkc3 = new JLabel("        ");

		pnBox.add(btnadd);
		pnBox.add(lbkc);
		pnBox.add(btnedit);
		pnBox.add(lbkc1);
		pnBox.add(btndelete);
		pnBox.add(lbkc2);
		pnBox.add(btnexit);
		pnBox.add(lbkc3);
		pnBox.add(btnimport);
		JLabel lbkc4 = new JLabel("        ");

		// tạo bảng table
		
		table.addColumn("Mã");
		table.addColumn("Lớp");
		table.addColumn("Tên");
		table.addColumn("Tuổi");
		tbl = new JTable(table);
		JScrollPane sc = new JScrollPane(tbl);

		// thêm vào main
		pnMain.add(pnTitle);
		pnMain.add(pnCob);
		pnMain.add(pnCodeInfo);
		pnMain.add(pnUserInfo);
		pnMain.add(pnArgInfo);
		pnMain.add(pnBox);
		pnMain.add(lbkc4);
		pnMain.add(sc);
		con.add(pnMain);
	}

	public void addEvents() {
		tbl.addMouseListener(tblUserClick);
		btnexit.addActionListener(btnExitClick);
		btnadd.addActionListener( btAddClick );
		btndelete.addActionListener( btdeleteClick );
		btnedit.addActionListener( bteditClick );
		btnimport.addActionListener(btimportClick);
	}
	
	public ChuongTrinhQuanLySinhVienUI(String title) {
		super(title);
		addConTrol();
		addEvents();
	}

	public void showView() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
