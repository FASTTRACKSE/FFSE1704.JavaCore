package ffse.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;

import ffse.dao.SinhVienDAO;
import ffse.entyti.SinhVien;

public class SVUI extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel pnlist;
	JPanel pnpass;
	JPanel pnUserInfo;
	JPanel pntuoi;
	JPanel pnlistGender;

	private JLabel lblTitle;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblpass;
	private JTextField txtpass;
	private JLabel lbltuoi;
	private JTextField txttuoi;

	private JButton btnthem;
	private JButton btnSua;
	private JButton btnXoa;// has - a
	private JButton btnReset;
	private JButton btnExit;
	private JButton btnHome;
	private JButton btnActionThem;
	private JButton btnActionSua;
	private JButton btnActionXoa;
	DefaultTableModel dm;
	JTable tbl;
	JComboBox<String> classs;
	JRadioButton gender1;
	JRadioButton gender2;

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

			String lopSV = (String) tbl.getValueAt(row, 1);
			classs.setSelectedItem(lopSV);

			String maSV = (String) tbl.getValueAt(row, 0);
			txtpass.setText(maSV);

			String tenSV = (String) tbl.getValueAt(row, 2);
			txtUser.setText(tenSV);

			String tuoiSV = (String) tbl.getValueAt(row, 3);
			txttuoi.setText(tuoiSV);

			String gioiTinhSV = (String) tbl.getValueAt(row, 4);
			if (gioiTinhSV.equals("Nam")) {
				gender1.setSelected(true);
			} else {
				gender2.setSelected(true);
			}

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
		pnlist = new JPanel();
		JLabel lblclass = new JLabel("Lớp");
		classs = new JComboBox<String>();
		classs.addItem("FFSE 1701");
		classs.addItem("FFSE 1702");
		classs.addItem("FFSE 1703");
		classs.addItem("FFSE 1704");
		classs.addItem("FFSE 1801");
		pnlist.add(lblclass);
		pnlist.add(classs);
		pnlist.setVisible(false);

		// Tạo panel pass chứa dòng chữ mã sinh viên và textbox mã sinh viên
		pnpass = new JPanel();
		lblpass = new JLabel("Mã sinh viên");
		txtpass = new JTextField(20);
		pnpass.add(lblpass);
		pnpass.add(txtpass);
		pnTitle.add(lblTitle);
		txtpass.setEnabled(false);
		pnpass.setVisible(false);

		// Tạo panel User chứa dòng chữ tên sinh viên
		pnUserInfo = new JPanel();
		lblUser = new JLabel("Tên Sinh Viên");
		txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);
		txtUser.setEnabled(false);
		pnUserInfo.setVisible(false);

		// Tạo panel pass chứa dòng chữ tuổi sinh viên và textbox tuổi sinh viên
		pntuoi = new JPanel();
		lbltuoi = new JLabel("Tuổi Sinh Viên");
		txttuoi = new JTextField(20);
		pntuoi.add(lbltuoi);
		pntuoi.add(txttuoi);
		pnTitle.add(lblTitle);
		txttuoi.setEnabled(false);
		pntuoi.setVisible(false);

		// tao box gender
		pnlistGender = new JPanel();
		JLabel lblGender = new JLabel("Giới tính");
		gender1 = new JRadioButton("Nam");
		gender2 = new JRadioButton("Nữ");
		ButtonGroup gd = new ButtonGroup();
		gd.add(gender1);
		gd.add(gender2);
		pnlistGender.add(lblGender);
		pnlistGender.add(gender1);
		pnlistGender.add(gender2);
		pnlistGender.setVisible(false);

		// tao panel chua cac button menu
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btnthem = new JButton("THÊM");
		btnthem.setForeground(Color.BLUE);
		pnBox.add(btnthem);
		btnthem.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// tao button Sửa
		btnSua = new JButton("SỬA");
		btnSua.setForeground(Color.RED);
		pnBox.add(btnSua);
		btnSua.addActionListener(actionListener);
		JLabel pnkc2 = new JLabel("        ");
		pnBox.add(pnkc2);

		// tao button XÓA
		btnXoa = new JButton("XÓA");
		btnXoa.setForeground(Color.GREEN);
		pnBox.add(btnXoa);
		btnXoa.addActionListener(actionListener);
		JLabel pnkc3 = new JLabel("        ");
		pnBox.add(pnkc3);

		// tao button thoát
		btnExit = new JButton("THOÁT");
		btnExit.setForeground(Color.ORANGE);
		pnBox.add(btnExit);
		btnExit.addActionListener(actionListener);

		// tao panel chua cac button action
		JPanel pnButtonAction = new JPanel();
		// tao button thực hiện them
		btnActionThem = new JButton("Thêm");
		pnButtonAction.add(btnActionThem);
		btnActionThem.addActionListener(actionListener);
		btnActionThem.setVisible(false);
		JLabel pnkc6 = new JLabel("        ");
		pnButtonAction.add(pnkc6);
		btnActionThem.setVisible(false);

		// tao button thực hiện sua
		btnActionSua = new JButton("Sửa");
		pnButtonAction.add(btnActionSua);
		btnActionSua.addActionListener(actionListener);
		btnActionSua.setVisible(false);
		pnButtonAction.add(pnkc6);
		btnActionSua.setVisible(false);

		// tao button thực hiện xoa
		btnActionXoa = new JButton("Xóa");
		pnButtonAction.add(btnActionXoa);
		btnActionXoa.addActionListener(actionListener);
		btnActionXoa.setVisible(false);
		pnButtonAction.add(pnkc6);
		btnActionXoa.setVisible(false);

		// tao button Reset
		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.GRAY);
		pnButtonAction.add(btnReset);
		btnReset.addActionListener(actionListener);
		JLabel pnkc4 = new JLabel("        ");
		pnButtonAction.add(pnkc4);
		btnReset.setVisible(false);

		// tao button home
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.ORANGE);
		pnButtonAction.add(btnHome);
		btnHome.addActionListener(actionListener);
		btnHome.setVisible(false);
		JLabel pnkc5 = new JLabel(" ");
		pnButtonAction.add(pnkc5);

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
		pnMain.add(pnButtonAction);
		pnMain.add(pnKCduoi);
		pnMain.add(sc);
		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnthem) {
				// nhapThongTin();

				pnlist.setVisible(true);
				pnUserInfo.setVisible(true);
				pnpass.setVisible(true);
				pntuoi.setVisible(true);
				pnlistGender.setVisible(true);

				txtUser.setEnabled(true);
				txtpass.setEnabled(true);
				txttuoi.setEnabled(true);

				btnthem.setEnabled(false);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnReset.setVisible(true);
				btnActionThem.setVisible(true);
				btnHome.setVisible(true);

			}
			if (e.getSource() == btnSua) {

				pnlist.setVisible(true);
				pnUserInfo.setVisible(true);
				pnpass.setVisible(true);
				pntuoi.setVisible(true);
				pnlistGender.setVisible(true);

				txtUser.setEnabled(true);
				txtpass.setEnabled(false);
				txttuoi.setEnabled(true);

				btnthem.setEnabled(false);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnReset.setVisible(true);
				btnActionSua.setVisible(true);
				btnHome.setVisible(true);
			}
			if (e.getSource() == btnXoa) {
				btnthem.setEnabled(false);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);

				btnActionXoa.setVisible(true);
				btnHome.setVisible(true);

			}
			if (e.getSource() == btnReset) {
				reset();
			}
			if (e.getSource() == btnExit) {
				int ret = JOptionPane.showConfirmDialog(null, "Thoát hả?", "Thoát", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
			if (e.getSource() == btnActionThem) {

				nhapThongTin();

			}
			if (e.getSource() == btnActionXoa) {
				int ret = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					xoaThongTin();
				}

			}
			if (e.getSource() == btnActionSua) {
				suaThongTin();

			}
			if (e.getSource() == btnHome) {

				pnlist.setVisible(false);
				pnUserInfo.setVisible(false);
				pnpass.setVisible(false);
				pntuoi.setVisible(false);
				pnlistGender.setVisible(false);

				btnthem.setEnabled(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);

				btnReset.setVisible(false);
				btnActionThem.setVisible(false);
				btnActionSua.setVisible(false);
				btnActionXoa.setVisible(false);
				btnHome.setVisible(false);
			}

		}
	};

	public String gioiTinh() {
		String gender;
		if (gender1.isSelected()) {
			gender = "Nam";
		} else {
			gender = "Nữ";
		}
		return gender;
	}

	public void nhapThongTin() {

		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtpass.getText();
		String lopSinhVien = classs.getSelectedItem().toString();
		String tuoiSinhVien = txttuoi.getText();
		String gioiTinhSinhVien = gioiTinh();
		sinhVienDAO.add(new SinhVien(lopSinhVien, maSinhVien, tenSinhVien, tuoiSinhVien, gioiTinhSinhVien));
		dm.addRow(new String[] { maSinhVien, lopSinhVien, tenSinhVien, tuoiSinhVien, gioiTinhSinhVien });
	}

	public void suaThongTin() {
		String tenSinhVien = txtUser.getText();
		String maSinhVien = txtpass.getText();
		String lopSinhVien = classs.getSelectedItem().toString();
		String tuoiSinhVien = txttuoi.getText();
		String gioiTinhSinhVien = gioiTinh();
		SinhVien sv = new SinhVien(lopSinhVien, maSinhVien, tenSinhVien, tuoiSinhVien, gioiTinhSinhVien);
		sinhVienDAO.update(sv);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSinhVien, row, 0);
		tbl.setValueAt(lopSinhVien, row, 1);
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
		if (btnActionSua.isVisible()==true) {
			txtUser.setText("");
			txttuoi.setText("");
		}
		if (btnActionThem.isVisible()==true) {
			txtUser.setText("");
			txtpass.setText("");
			txttuoi.setText("");
		}
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
