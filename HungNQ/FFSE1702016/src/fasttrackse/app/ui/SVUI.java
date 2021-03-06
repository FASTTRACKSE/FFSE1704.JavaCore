package fasttrackse.app.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

import fasttrackse.app.dao.SinhVienDAO;
import fasttrackse.app.entity.SinhVien;

public class SVUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblpass;
	private JTextField txtpass;
	private JLabel lbltuoi;
	private JTextField txttuoi;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;// has - a
	private JButton btn4;
	private JButton btn5;
	DefaultTableModel dm;
	JTable tbl;
	JComboBox<String> classs;
	JComboBox<String> gender;

	public static SinhVienDAO sinhVienDAO = new SinhVienDAO();
	public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

	public SVUI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
	}

	public void addEvent() {
		tbl.addMouseListener(tblUserClick);
	}

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

			String maSV = (String) tbl.getValueAt(row, 0);
			txtpass.setText(maSV);

			String tenSV = (String) tbl.getValueAt(row, 2);
			txtUser.setText(tenSV);

			String tuoiSV = (String) tbl.getValueAt(row, 3);
			txttuoi.setText(tuoiSV);
		}
	};

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ quản lý sinh viên fasttrack se
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Quản lý sinh viên FastTrack SE");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// tao box class
		JPanel pnlist = new JPanel();
		JLabel lblclass = new JLabel("Lớp");
		classs = new JComboBox<String>();
		classs.addItem("FFSE 1701");
		classs.addItem("FFSE 1702");
		classs.addItem("FFSE 1703");
		classs.addItem("FFSE 1704");
		classs.addItem("FFSE 1801");
		pnlist.add(lblclass);
		pnlist.add(classs);

		// Tạo panel pass chứa dòng chữ mã sinh viên và textbox mã sinh viên
		JPanel pnpass = new JPanel();
		lblpass = new JLabel("Mã sinh viên");
		txtpass = new JTextField(20);
		pnpass.add(lblpass);
		pnpass.add(txtpass);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ tên sinh viên
		JPanel pnUserInfo = new JPanel();
		lblUser = new JLabel("Tên Sinh Viên");
		txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ tuổi sinh viên và textbox tuổi sinh viên
		JPanel pntuoi = new JPanel();
		lbltuoi = new JLabel("Tuổi Sinh Viên");
		txttuoi = new JTextField(20);
		pntuoi.add(lbltuoi);
		pntuoi.add(txttuoi);
		pnTitle.add(lblTitle);

		// tao box gender
		JPanel pnlistGender = new JPanel();
		JLabel lblGender = new JLabel("Giới tính");
		gender = new JComboBox<String>();
		gender.addItem("Nam");
		gender.addItem("Nữ");
		pnlistGender.add(lblGender);
		pnlistGender.add(gender);

		// tao button Thêm
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btn1 = new JButton("THÊM");
		btn1.setForeground(Color.BLUE);
		pnBox.add(btn1);
		btn1.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// tao button Sửa
		btn2 = new JButton("SỬA");
		btn2.setForeground(Color.RED);
		pnBox.add(btn2);
		btn2.addActionListener(actionListener);
		JLabel pnkc2 = new JLabel("        ");
		pnBox.add(pnkc2);

		// tao button XÓA
		btn3 = new JButton("XÓA");
		btn3.setForeground(Color.GREEN);
		pnBox.add(btn3);
		btn3.addActionListener(actionListener);
		JLabel pnkc3 = new JLabel("        ");
		pnBox.add(pnkc3);

		// tao button Reset
		btn4 = new JButton("RESET");
		btn4.setForeground(Color.GRAY);
		pnBox.add(btn4);
		btn4.addActionListener(actionListener);
		JLabel pnkc4 = new JLabel("        ");
		pnBox.add(pnkc4);

		// tao button thoát
		btn5 = new JButton("THOÁT");
		btn5.setForeground(Color.ORANGE);
		pnBox.add(btn5);
		btn5.addActionListener(actionListener);

		JPanel pnKCduoi = new JPanel();

		// table
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Lớp");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Giới Tính");
		this.getTable();
		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnlist);
		pnMain.add(pnpass);
		pnMain.add(pnUserInfo);
		pnMain.add(pntuoi);
		pnMain.add(pnlistGender);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		pnMain.add(sc);
		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn1) {
				nhapThongTin();
			}
			if (e.getSource() == btn2) {
				suaThongTin();
			}
			if (e.getSource() == btn3) {
				xoaThongTin();
			}
			if (e.getSource() == btn4) {
				reset();
			}
			if (e.getSource() == btn5) {
				int ret = JOptionPane.showConfirmDialog(null, "Thoát hả?", "Thoát", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		}
	};

	public void nhapThongTin() {

		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtpass.getText();
		String lopSinhVien = classs.getSelectedItem().toString();
		String tuoiSinhVien = txttuoi.getText();
		String gioiTinhSinhVien = gender.getSelectedItem().toString();
		sinhVienDAO.add(new SinhVien(lopSinhVien, maSinhVien, tenSinhVien, tuoiSinhVien, gioiTinhSinhVien));
		dm.addRow(new String[] { maSinhVien, lopSinhVien, tenSinhVien, tuoiSinhVien, gioiTinhSinhVien });
	}

	public void suaThongTin() {
		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtpass.getText();
		String lopSinhVien = classs.getSelectedItem().toString();
		String tuoiSinhVien = txttuoi.getText();
		String gioiTinhSinhVien = gender.getSelectedItem().toString();
		SinhVien sv = new SinhVien(lopSinhVien, maSinhVien, tenSinhVien, tuoiSinhVien, gioiTinhSinhVien);
		sinhVienDAO.update(sv);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSinhVien, row, 0);
		tbl.setValueAt(tenSinhVien, row, 2);
		tbl.setValueAt(tuoiSinhVien, row, 3);
		tbl.setValueAt(gioiTinhSinhVien, row, 4);

	}

	public void xoaThongTin() {
		String maSinhVien = txtpass.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			dm.removeRow(rows[i] - i);
			sinhVienDAO.delete(maSinhVien);
		}
	}

	public void reset() {
		txtUser.setText("");
		txtpass.setText("");
		txttuoi.setText("");
	}

	public void getTable() {
		arr = sinhVienDAO.getDSKSinhVien();
		for (int i = 0; i < arr.size(); i++) {
			dm.addRow(new String[] { arr.get(i).getMaSinhVien(), arr.get(i).getLopSinhVien(),
					arr.get(i).getTenSinhVien(), arr.get(i).getTuoiSinhVien(), arr.get(i).getGioiTinhSinhVien() });
		}
	}

	public void showWindow() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}