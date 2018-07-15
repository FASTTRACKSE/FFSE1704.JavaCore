package fasttrackse.loginapp.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.loginapp.dao.AppDAO;
import fasttrackse.loginapp.entity.SinhVien;

public class LoginUI extends JFrame implements Serializable {
	JButton btnLogin = new JButton("Nhập");
	JButton btnHien = new JButton("Hiện");
	JButton btnThem = new JButton("Thêm");
	JButton btnSua = new JButton("Sửa");
	JButton btnXoa = new JButton("Xóa");
	JButton btnThoat = new JButton("Thoát");
	JButton btnNhap = new JButton("Nhập");
	JTextField txtTen = new JTextField(20);
	JTextField txtGioiTinh = new JTextField(20);
	JTextField txtTuoi = new JTextField(20);
	JTextField txtMaSV = new JTextField(20);
	JTextField txtLop = new JTextField(20);

	JRadioButton rad1, rad2;
	JComboBox cbo;
	private DefaultTableModel dm = new DefaultTableModel(new Object[] { "Lớp", "Mã", "Tên", "Tuổi", "Giới Tính" }, 0);
	JTable table = new JTable(dm);
	final JTable tbl = new JTable(dm);
	JScrollPane sc = new JScrollPane(tbl);
	JPanel pnLopGT = new JPanel();
	public static AppDAO SinhVienDAO = new AppDAO();
	public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

	ActionListener btnHienClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// JOptionPane.showMessageDialog(null, "Danh sách sinh viên!");
			HienDanhSach();
		}
	};

	ActionListener btnXoaClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			XoaMember();
		}
	};

	ActionListener btnThoatClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	ActionListener btLoginClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ShowMessageHello();
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

			String s = (String) tbl.getValueAt(row, 1);

			txtTen.setText(s);
		}
	};

	public void ShowMessageHello() {
		JOptionPane.showMessageDialog(null, "Xin chào bạn " + txtTen.getText() + "! Login thành công!!!");
	}

	public void HienDanhSach() {
		arr = SinhVienDAO.getDSKSinhVien();
		for (int i = 0; i < arr.size(); i++) {
			dm.addRow(new String[] { arr.get(i).getLopSinhVien(), arr.get(i).getMaSinhVien(),
					arr.get(i).getTenSinhVien(), arr.get(i).getTuoiSinhVien(), arr.get(i).getGioiTinhSinhVien() });
		}
	}
	
	public void XoaMember() {
		arr = SinhVienDAO.getDSKSinhVien();
		int row = tbl.getSelectedRow();
		String s = (String) tbl.getValueAt(row, 1);
		
	}

	public LoginUI(String title) {
		super(title);
		connectDB();
		addControls();
		addEvents();
	}

	public void connectDB() {
		SinhVienDAO = new AppDAO();
		SinhVienDAO.getConnect("localhost", "sinhvien", "boll", "12345");
		if (SinhVienDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên!");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JLabel lblBo = new JLabel("Chọn lớp: ");
		JPanel pnbo = new JPanel();
		Font fontBo = new Font("Class", Font.BOLD, 15);
		lblBo.setFont(fontBo);
		pnbo.add(lblBo);
		cbo = new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		add(cbo);
		String arr[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };

		pnbo.add(cbo);

		// Tạo panel Mã sinh viên chứa dòng chữ pass và textbox pass
		JPanel pnMaSV = new JPanel();
		JLabel lblMaSV = new JLabel("Mã Sinh Viên:");
		pnMaSV.add(lblMaSV);
		pnMaSV.add(txtMaSV);

		// Panel tên
		JPanel pnTenSV = new JPanel();
		JLabel lblTen = new JLabel("Tên Sinh Viên:");
		pnTenSV.add(lblTen);
		pnTenSV.add(txtTen);

		JPanel pnTuoi = new JPanel();
		JLabel lblTuoi = new JLabel("Tuổi Sinh Viên:");
		// JTextField txtNamSinh = new JTextField(20);
		pnTuoi.add(lblTuoi);
		pnTuoi.add(txtTuoi);

		// RADIO BUTTON
		JPanel pnGroup = new JPanel();
		pnGroup.setLayout(new BoxLayout(pnGroup, BoxLayout.X_AXIS));
		Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "Giới Tính");
		pnGroup.setBorder(titlebor);
		rad1 = new JRadioButton("Nam");
		rad2 = new JRadioButton("Nữ");

		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		pnGroup.add(rad1);
		pnGroup.add(rad2);
		add(pnGroup);

		// Nhét lớp và giới tính vào panel lớn
		pnLopGT.add(pnbo);
		pnLopGT.add(pnGroup);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnActions = new JPanel();

		// Tạo các ô bấm
		pnActions.add(btnLogin);
		pnActions.add(btnHien);
		pnActions.add(btnThem);
		pnActions.add(btnSua);
		pnActions.add(btnXoa);
		pnActions.add(btnThoat);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnLopGT);
		pnMain.add(pnMaSV);
		pnMain.add(pnTenSV);
		pnMain.add(pnTuoi);
		pnMain.add(pnActions);
		pnMain.add(sc);

		con.add(pnMain);
	}

	public String gioitinh() {
		String gioitinhh;
		if (rad1.isSelected()) {

			return gioitinhh = "Nam";
		} else if (rad2.isSelected()) {
			return gioitinhh = "Nữ";
		} else {
			return gioitinhh = "null";
		}
	}

	public void nhapThongTin() {
		String maSV = txtMaSV.getText();
		String tenSV = txtTen.getText();
		String lopSV = cbo.getSelectedItem().toString();
		String tuoiSV = txtTuoi.getText();
		String gioitinhSV = gioitinh();
		SinhVienDAO.add(new SinhVien(maSV, tenSV, lopSV, tuoiSV, gioitinhSV));
		String[] row = { maSV, tenSV, lopSV, tuoiSV, gioitinhSV };
		dm.addRow(row);
	}

	public void addEvents() {
		btnLogin.addActionListener(btLoginClick);
		btnHien.addActionListener(btnHienClick);
		btnThoat.addActionListener(btnThoatClick);
		btnXoa.addActionListener(btnXoaClick);
		tbl.addMouseListener(tblUserClick);
		btnThem.addActionListener(evenThem);
	}

	ActionListener evenThem = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			nhapThongTin();
		}
	};

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}