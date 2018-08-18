package ffse.lp4.quanlytiendien.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import ffse.lp4.quanlytiendien.dao.BienLaiModel;
import ffse.lp4.quanlytiendien.entity.BienLai;
import ffse.lp4.quanlytiendien.entity.QuanPhuong;

public class GDNhapBienLai extends JFrame {
	JButton btKTDS;
	JButton btCSDS;
	JButton btKTBL;
	JButton btHome;
	JButton btExit;
	JButton btThem;
	JButton btThemBL;
	JButton btTimKiem;
	JButton btSua;
	JButton btXoa;
	JButton btReset;
	JTextField txtCSCu;
	JTextField txtCSMoi;
	JTextField txtMCT;
	JTextField txtHoTen;
	JTextField txtMaKH;
	JTextField txtDiaChi;
	JTextField txtNM;
	JTextField txtShowMKH;
	JTextField txtShowTKH;
	JTextField txtShowDC;
	JTextField txtShowSDT;
	JTextField txtShowMCTCu;
	JTextField txtNgayNhap;
	JLabel lblNM;
	DefaultTableModel dm;
	JTable tbl;
	DefaultTableModel model;
	JLabel label;
	JPanel pnCalendar;
	BienLaiModel bienLaiModel = new BienLaiModel();
	JPanel pnNgayNhap;
	JMonthChooser jmc;
	JYearChooser jyc;
	JPanel pnChuKy;
	JPanel pnA1;
	JPanel pnA2;
	JPanel pnA3;
	JPanel pnA4;
	JPanel pnA5;
	JPanel pnA6;
	JPanel pnA7;
	JPanel pnA8;
	JPanel pnA9;

	BienLaiModel bienLaiDao;
	ArrayList<BienLai> dSBL = new ArrayList<BienLai>();
	String smactKH;
	String shotenKH;
	String sdiachiKH;
	String ssdtKH;
	String maCT;
	String ngayNhap;
	String thangNhap;
	String namNhap;
	int chisoctmoicheck;

	int chiSoCTCu;
	int tienDien;
	int chiSoCT;
	int chiSoMoi;
	String stringChiSoCT;
	String schisoCTcu;
	String chukycheck ;
	String sthangnhapKH;
	String snamnhapKH;
	String chuKy;
	JPanel pnLeft;
	Date date;

	public GDNhapBienLai(String tieude) {
		super("Nhập biên lai");
		addControls();
		conect();

	}

	public void conect() {
		bienLaiDao = new BienLaiModel();
		bienLaiDao.getConnect("localhost", "quanlytiendien", "phuongadmin", "phuong321");

	}

	static Connection connn = (Connection) ffse.lp4.quanlytiendien.dao.BienLaiModel.getConnect("localhost",
			"quanlytiendien", "phuongadmin", "phuong321");

	public Connection getConn() {
		return connn;
	}

	public void setConn(Connection conn) {
		this.connn = conn;
	}

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			connn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void addControls() {
		if (connn != null) {
		} else {
			System.out.println(0);
		}
		Container con = getContentPane();

		// ****** tạo panel chứa tittle********//
		JPanel pntt = new JPanel();
		ImageIcon iconlogo = new ImageIcon(
				new ImageIcon("icon/logo.gif").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		JLabel logo = new JLabel(iconlogo);
		pntt.add(logo);
		pntt.setPreferredSize(new Dimension(500, 90));
		JLabel lbltt = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ TIÊU THỤ ĐIỆN");
		pntt.add(lbltt);
		Font font = new Font("Courier New", Font.BOLD, 25);
		lbltt.setFont(font);

		// **** tạo các button thêm sửa xóa
		btThem = new JButton();
		btThem.setPreferredSize(new Dimension(100, 50));
		ImageIcon iconThem = new ImageIcon(
				new ImageIcon("icon/them.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		iconThem.setImageObserver(btThem);
		JLabel them = new JLabel(iconThem);
		JLabel lblthem = new JLabel("            Thêm");

		btThem.add(lblthem);
		btThem.add(them);
		btSua = new JButton("");
		ImageIcon iconSua = new ImageIcon(
				new ImageIcon("icon/sua.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));

		JLabel sua = new JLabel(iconSua);
		JLabel lblsua = new JLabel("            Sửa");

		btSua.add(lblsua);
		btSua.add(sua);
		btXoa = new JButton("");
		ImageIcon iconXoa = new ImageIcon(
				new ImageIcon("icon/xoa.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		JLabel xoa = new JLabel(iconXoa);
		JLabel lblxoa = new JLabel("              Xóa");

		btXoa.add(xoa);
		btXoa.add(lblxoa);
		btReset = new JButton("");
		ImageIcon iconReset = new ImageIcon(
				new ImageIcon("icon/reset.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		JLabel reset = new JLabel(iconReset);
		JLabel lblReset = new JLabel("            Reset");

		btReset.add(reset);
		btReset.add(lblReset);
		JPanel pnDuoi = new JPanel();
		pnDuoi.setBackground(Color.GRAY);
		pnDuoi.setLayout(new BoxLayout(pnDuoi, BoxLayout.X_AXIS));
		pnDuoi.setPreferredSize(new Dimension(500, 50));
		pnDuoi.add(btThem);
		pnDuoi.add(btSua);
		pnDuoi.add(btXoa);
		pnDuoi.add(btReset);
		btThem.addActionListener(actionListener);
		btSua.addActionListener(actionListener);
		btXoa.addActionListener(actionListener);
		btReset.addActionListener(actionListener);

		// ****** tạo panel giữa chứa các ô nhập

		JPanel pnCenter = new JPanel();

		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(500, 200));

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setBackground(Color.BLACK);
		pnCenterCon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Nhâp dữ liệu:"));
		// pnCenterCon.setBorder(BorderFactory.createEmptyBorder());
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.X_AXIS));

		// chia ra hai panel đối xứng

		// ******* panel Trái
		pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.setPreferredSize(new Dimension(200, 150));

		JPanel pnPlaces = new JPanel();
		JLabel lblPlaces = new JLabel("   ");
		pnPlaces.add(lblPlaces);
		pnPlaces.setPreferredSize(new Dimension(20, 5));

		JLabel lblMaCongTo = new JLabel("MCT:");

		txtMCT = new JTextField(14);
		btTimKiem = new JButton("");
		ImageIcon iconTimKiem = new ImageIcon(
				new ImageIcon("icon/timkiem.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		iconThem.setImageObserver(btThem);
		JLabel timKiem = new JLabel(iconTimKiem);
		btTimKiem.add(timKiem);
		btTimKiem.addActionListener(btnTimKiemEvents);

		JLabel lblCSCu = new JLabel("CS Cũ:   ");
		txtCSCu = new JTextField(21);

		JLabel lblCSMoi = new JLabel("CS Mới:  ");
		txtCSMoi = new JTextField(22);

		JLabel lblMKH = new JLabel("Mã KH:  ");
		txtShowMKH = new JTextField(10);
		JLabel lblTenKH = new JLabel("Tên KH:  ");
		txtShowTKH = new JTextField(10);
		JLabel lblDiaChi = new JLabel("Địa chỉ:  ");
		txtShowDC = new JTextField(10);
		JLabel lblSDT = new JLabel("Số ĐT:  ");
		txtShowSDT = new JTextField(10);

		btThemBL = new JButton("");
		ImageIcon iconThemBL = new ImageIcon(
				new ImageIcon("icon/them.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		iconThem.setImageObserver(btThem);
		JLabel ThemBL = new JLabel(iconThemBL);
		JLabel themMoi = new JLabel("     Thêm mới Biên lai");
		btThemBL.add(ThemBL);
		btThemBL.add(themMoi);
		btThemBL.addActionListener(actionListener);

		pnA1 = new JPanel();
		pnA1.setPreferredSize(new Dimension(40, 5));
		pnA1.add(lblMaCongTo);
		pnA1.add(txtMCT);
		pnA1.add(btTimKiem);
		pnA2 = new JPanel();
		pnA2.setPreferredSize(new Dimension(40, 5));
		pnA2.add(lblCSCu);
		pnA2.add(txtCSCu);

		pnNgayNhap = new JPanel();
		txtNM = new JTextField(6);
		lblNM = new JLabel("Ngày nhập: ");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = new Date();
		txtNM.setText(dateFormat.format(date));
		pnNgayNhap.add(lblNM);
		pnNgayNhap.add(txtNM);
		pnNgayNhap.setVisible(false);
		txtNM.setEnabled(false);
		pnNgayNhap.setPreferredSize(new Dimension(100, 5));

		pnChuKy = new JPanel();
		pnChuKy.setPreferredSize(new Dimension(100, 5));
		JLabel lblMonth = new JLabel("Chu kì nhập");
		lblMonth.setPreferredSize(new Dimension(100, 15));

		jmc = new JMonthChooser();
		jyc = new JYearChooser();
		pnChuKy.add(lblMonth);
		pnChuKy.add(jmc);
		pnChuKy.add(jyc);
		pnChuKy.setVisible(false);

		pnA3 = new JPanel();
		pnA3.setPreferredSize(new Dimension(40, 5));
		pnA3.add(lblCSMoi);
		pnA3.add(txtCSMoi);

		pnA5 = new JPanel();
		pnA5.add(lblMKH);
		pnA5.add(txtShowMKH);
		pnA6 = new JPanel();
		pnA6.add(lblTenKH);
		pnA6.add(txtShowTKH);
		pnA7 = new JPanel();
		pnA7.add(lblDiaChi);
		pnA7.add(txtShowDC);
		pnA8 = new JPanel();
		pnA8.add(lblSDT);
		pnA8.add(txtShowSDT);

		pnA4 = new JPanel();
		pnA4.add(btThemBL);

		txtCSCu.setEnabled(false);
		txtCSMoi.setEnabled(false);

		pnA3.setVisible(false);
		pnA5.setVisible(false);
		pnA6.setVisible(false);
		pnA7.setVisible(false);
		pnA8.setVisible(false);
		pnA2.setVisible(false);
		pnA4.setVisible(false);
		
		txtCSCu.setEnabled(false);
		txtShowDC.setEnabled(false);
		txtShowTKH.setEnabled(false);
		txtShowMKH.setEnabled(false);
		txtShowSDT.setEnabled(false);

		// *******

		pnLeft.add(pnPlaces);
		pnLeft.add(pnA1);
		pnLeft.add(pnNgayNhap);
		pnLeft.add(pnChuKy);
		pnLeft.add(pnA3);
		pnLeft.add(pnA5);
		pnLeft.add(pnA6);
		pnLeft.add(pnA7);
		pnLeft.add(pnA8);
		pnLeft.add(pnA2);
		pnLeft.add(pnA4);

		pnCenterCon.add(pnLeft);
		pnCenter.add(pnCenterCon);
		pnCenter.add(pnDuoi);

		// ****** tạo panel phải chứa hai button
		JPanel pnBTL = new JPanel();
		pnBTL.setPreferredSize(new Dimension(180, 600));
		JLabel pnPlace1 = new JLabel("              ");
		JLabel pnPlace2 = new JLabel("              ");
		JLabel pnPlace3 = new JLabel("              ");
		JLabel pnPlace4 = new JLabel("              ");
		JLabel pnPlace5 = new JLabel("              ");
		JLabel pnPlace6 = new JLabel("              ");
		pnBTL.setLayout(new BoxLayout(pnBTL, BoxLayout.Y_AXIS));

		btCSDS = new JButton("");
		btCSDS.setPreferredSize(new Dimension(110, 50));
		ImageIcon iconCSDS = new ImageIcon(
				new ImageIcon("icon/csdanhsach.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblCSDS = new JLabel("                 Chỉnh sửa DSKH");
		JLabel chinhsua = new JLabel(iconCSDS);
		btCSDS.add(chinhsua);
		btCSDS.add(lblCSDS);
		btCSDS.setMargin(new Insets(8, 0, 8, 28));
		btCSDS.addActionListener(actionListener);

		btKTDS = new JButton("");
		ImageIcon iconDSKH = new ImageIcon(
				new ImageIcon("icon/tracuukh.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblDSKH = new JLabel("                    Kiểm Tra DSKH");
		JLabel dSKhachHang = new JLabel(iconDSKH);
		btKTDS.add(dSKhachHang);
		btKTDS.add(lblDSKH);
		btKTDS.setMargin(new Insets(8, 0, 8, 26));
		btKTDS.addActionListener(actionListener);

		btKTBL = new JButton("");
		ImageIcon iconThongKe = new ImageIcon(
				new ImageIcon("icon/thongke.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblThongKe = new JLabel("                 Thống kê báo cáo");
		JLabel thongKe = new JLabel(iconThongKe);
		btKTBL.add(thongKe);
		btKTBL.add(lblThongKe);
		btKTBL.addActionListener(actionListener);
		btKTBL.setMargin(new Insets(8, 0, 8, 22));

		pnBTL.add(pnPlace1);
		pnBTL.add(pnPlace2);
		pnBTL.add(btCSDS);
		pnBTL.add(pnPlace3);
		pnBTL.add(pnPlace4);
		pnBTL.add(btKTDS);
		pnBTL.add(pnPlace5);
		pnBTL.add(pnPlace6);
		pnBTL.add(btKTBL);

		// ****** tạo panel Trái chứa hai button
		JPanel pnBTR = new JPanel();
		pnBTR.setPreferredSize(new Dimension(175, 600));
		JLabel pnPlacea = new JLabel("              ");
		JLabel pnPlaceb = new JLabel("              ");
		JLabel pnPlacec = new JLabel("              ");
		JLabel pnPlaced = new JLabel("              ");
		JLabel pnPlacee = new JLabel("              ");
		JLabel pnPlaceg = new JLabel("              ");

		pnBTR.setLayout(new BoxLayout(pnBTR, BoxLayout.Y_AXIS));

		btHome = new JButton("");
		ImageIcon iconHome = new ImageIcon(
				new ImageIcon("icon/home.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblHome = new JLabel("                    Home");
		JLabel home = new JLabel(iconHome);
		btHome.add(home);
		btHome.add(lblHome);
		btHome.setMargin(new Insets(8, 10, 8, 65));
		btHome.addActionListener(actionListener);

		btExit = new JButton("");
		ImageIcon iconExit = new ImageIcon(
				new ImageIcon("icon/exit.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblExit = new JLabel("                      Exit");
		JLabel exit = new JLabel(iconExit);
		btExit.add(exit);
		btExit.add(lblExit);
		btExit.addActionListener(actionListener);
		btExit.setMargin(new Insets(8, 10, 8, 71));

		pnBTR.add(pnPlacea);
		pnBTR.add(pnPlaceb);
		pnBTR.add(pnPlacec);
		pnBTR.add(btHome);
		pnBTR.add(pnPlaced);
		pnBTR.add(pnPlacee);
		pnBTR.add(pnPlaceg);
		pnBTR.add(btExit);
		// ***** tạo panel chứa table
		dm = new DefaultTableModel();
		dm.addColumn("Mã công tơ");
		dm.addColumn("Ngày Nhập");
		dm.addColumn("Chu kỳ");
		dm.addColumn("Chỉ số");
		dm.addColumn("Thành tiền");
		tbl = new JTable(dm);
		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		pntt.setBackground(Color.CYAN);
		pnBorder.add(pntt, BorderLayout.NORTH);

		JPanel pnTB = new JPanel();
		pnTB.setLayout(new BoxLayout(pnTB, BoxLayout.Y_AXIS));
		pnTB.setPreferredSize(new Dimension(900, 200));
		pnTB.add(sc);
		pnBorder.add(pnTB, BorderLayout.SOUTH);

		pnBTR.setBackground(Color.GRAY);
		pnBorder.add(pnBTL, BorderLayout.WEST);

		pnBTL.setBackground(Color.GRAY);
		pnBorder.add(pnBTR, BorderLayout.EAST);

		pnCenter.setBackground(Color.GRAY);
		pnBorder.add(pnCenter, BorderLayout.CENTER);// ok !

		con.add(pnBorder);

		txtShowMCTCu = new JTextField();

		///////// ************************************************************************************************

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btKTDS) {
				GDDSKhachHang dSKhachHang = new GDDSKhachHang("Danh Sách Khách Hàng");
				dSKhachHang.showWindow();
				setVisible(false);

			}
			if (e.getSource() == btKTBL) {
				GDBienLai bienLai = new GDBienLai("Thống Kê Biên Lai");
				bienLai.showWindow();
				setVisible(false);
			}
			if (e.getSource() == btCSDS) {
				GDChinh cSDanhSach = new GDChinh("Thống Kê Biên Lai");
				cSDanhSach.showWindow();
				setVisible(false);
			}
			if (e.getSource() == btHome) {
				GDHome home = new GDHome("Home");
				home.showWindow();
				setVisible(false);
			}
			if (e.getSource() == btExit) {
				System.exit(0);
			}
			if (e.getSource() == btThemBL) {
				pnA1.setVisible(true);
				pnA3.setVisible(true);
				pnA5.setVisible(false);
				pnA6.setVisible(false);
				pnA7.setVisible(false);
				pnA8.setVisible(false);
				pnA2.setVisible(true);

				txtCSMoi.setEnabled(true);
				pnNgayNhap.setVisible(true);
				pnChuKy.setVisible(true);
				btThemBL.setVisible(false);
				btTimKiem.setVisible(false);

			}
			if (e.getSource() == btThem) {
				pnA1.setVisible(true);
				pnA2.setVisible(false);
				pnA3.setVisible(false);
				pnA4.setVisible(false);
				pnA5.setVisible(false);
				pnA6.setVisible(false);
				pnA7.setVisible(false);
				pnA8.setVisible(false);
				btThemBL.setVisible(false);
				pnNgayNhap.setVisible(false);
				btTimKiem.setVisible(true);
				pnChuKy.setVisible(false);
//				xoaTable();
				add();
			}if (e.getSource() == btXoa) {
				xoaTable();
			}if (e.getSource() == btSua) {
				pnA1.setVisible(true);
				pnA3.setVisible(true);
				pnA5.setVisible(false);
				pnA6.setVisible(false);
				pnA7.setVisible(false);
				pnA8.setVisible(false);
				pnA2.setVisible(true);

				txtCSMoi.setEnabled(true);
				pnNgayNhap.setVisible(true);
				pnChuKy.setVisible(true);
				btThemBL.setVisible(false);
				btTimKiem.setVisible(false);
				suaThongTin();
				
			}

		}
	};
	ActionListener btnTimKiemEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				pnA1.setVisible(false);
				pnA3.setVisible(false);

				pnA5.setVisible(true);
				pnA6.setVisible(true);
				pnA7.setVisible(true);
				pnA8.setVisible(true);
				pnA2.setVisible(true);
				pnA4.setVisible(true);

				
				search();
				showThongTin();
				

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	};
	

	private int chisoctcucheck;	public void noMatching() {
		pnA1.setVisible(true);
		pnA2.setVisible(false);
		pnA3.setVisible(false);
		pnA4.setVisible(false);
		pnA5.setVisible(false);
		pnA6.setVisible(false);
		pnA7.setVisible(false);
		pnA8.setVisible(false);
		btThemBL.setVisible(false);
		pnNgayNhap.setVisible(false);
		btTimKiem.setVisible(true);
		pnChuKy.setVisible(false);
		
	}

	public void nhap() {
		maCT = txtMCT.getText();
//		System.out.println(maCT);

		stringChiSoCT = txtCSMoi.getText();
		chiSoMoi = Integer.parseInt(stringChiSoCT);

		ngayNhap = txtNM.getText();

		DateFormat MM = new SimpleDateFormat("MM");

		thangNhap = MM.format(date);

		DateFormat yyyy = new SimpleDateFormat("yyyy");

		namNhap = yyyy.format(date);

		chiSoCTCu = Integer.parseInt(schisoCTcu);

		chiSoCT = chiSoMoi - chiSoCTCu;

	}

	public void search() throws SQLException {

		if (!checkMaCT(txtCSMoi.getText())) {

			try {

				String str = txtMCT.getText();
				PreparedStatement st = connn.prepareStatement(
						"SELECT khachhang.MaKhachHang, khachhang.TenKhachHang , khachhang.DiaChi, khachhang.SDT , bienlai.ChiSoMoi, bienlai.Thang, bienlai.Nam FROM khachhang INNER JOIN bienlai ON khachhang.MaCongTo = bienlai.MaCongTo WHERE bienlai.MaCongTo=? order by Date DESC limit 1");

				st.setString(1, str);
				System.out.println(st);

				ResultSet rs = st.executeQuery();

				if (rs.next()) {

					chiSoCTCu = rs.getInt(5);

					schisoCTcu = String.valueOf(chiSoCTCu);
					smactKH = rs.getString(1);
					System.out.println(smactKH);

					shotenKH = rs.getString(2);

					sdiachiKH = rs.getString(3);

					ssdtKH = rs.getString(4);

					sthangnhapKH = rs.getString(6);

					snamnhapKH = rs.getString(7);

					chuKy = sthangnhapKH + "-" + snamnhapKH;

					txtShowMKH.setText(smactKH);

					txtShowTKH.setText(shotenKH);

					txtShowDC.setText(sdiachiKH);

					txtShowSDT.setText(ssdtKH);

					txtCSCu.setText(schisoCTcu);

				} else {

					String str1 = txtMCT.getText();
					PreparedStatement st1 = connn.prepareStatement(
							"SELECT khachhang.MaKhachHang, khachhang.TenKhachHang, khachhang.DiaChi, khachhang.SDT FROM khachhang WHERE MaCongTo=?");
					st1.setString(1, str1);
					System.out.println(st1);

					ResultSet rs1 = st1.executeQuery();
					if (rs1.next()) {

						schisoCTcu = "0";
						txtCSCu.setText(schisoCTcu);
						smactKH = rs1.getString(1);

						shotenKH = rs1.getString(2);

						sdiachiKH = rs1.getString(3);

						ssdtKH = rs1.getString(4);

						chuKy = "Chưa Có";

						txtShowMKH.setText(smactKH);

						txtShowTKH.setText(shotenKH);

						txtShowDC.setText(sdiachiKH);

						txtShowSDT.setText(ssdtKH);

						txtShowMCTCu.setText(schisoCTcu);

					} else {
						JOptionPane.showMessageDialog(null, "Mã công tơ không tồn tại ! vui lòng nhập lại  ");
						noMatching();
					}

				}
			} catch (Exception ex) {

				System.out.println(ex);

			}
		}
	}

	public static boolean checkMaCT(String maCT) throws SQLException {
		ResultSet maCTKH = BienLaiModel.getMaCT();
		while (maCTKH.next()) {
			if (maCT.equals(maCTKH.getString("MaCongTo"))) {
				return true;
			}
		}
		return false;
	}

	public void add() {
		nhap();
		maCT = txtMCT.getText();
		System.out.println(maCT);
		int kw0to50 = 77450;
		int kw50to100 = kw0to50 + 80000;
		int kw100to200 = kw50to100 + 185800;
		int kw200to300 = kw100to200 + 2340000;
		int kw300to400 = kw200to300 + 261500;

		if (chiSoCT < 50) {
			tienDien = chiSoCT * 1549;
		} else if (chiSoCT > 50 && chiSoCT < 100) {
			tienDien = kw0to50 + (chiSoCT * 1600);
		} else if (chiSoCT > 100 && chiSoCT < 200) {
			tienDien = kw50to100 + (chiSoCT * 1858);
		} else if (chiSoCT > 200 && chiSoCT < 300) {
			tienDien = kw100to200 + (chiSoCT * 2340);
		} else if (chiSoCT > 300 && chiSoCT < 400) {
			tienDien = kw200to300 + (chiSoCT * 2615);
		} else if (chiSoCT > 400) {
			tienDien = kw300to400 + (chiSoCT * 2710);
		} else {
			JOptionPane.showMessageDialog(null, "");
		}

		String stringtiendien = String.valueOf(tienDien);
		nhap();

		dm.addRow(new String[] { maCT, ngayNhap, chuKy, stringChiSoCT, stringtiendien });
		bienLaiModel.addBL(new BienLai(maCT, thangNhap, namNhap, ngayNhap, chuKy, chiSoCT, tienDien));

	}
	

	public void xoaThongTin() {
		maCT = txtMCT.getText();
		ngayNhap = txtNM.getText();
		int ret = JOptionPane.showConfirmDialog(null, "Xóa khách hàng này", "Xóa", JOptionPane.YES_NO_OPTION);

		if (ret == JOptionPane.YES_OPTION) {
			String maCongTo = txtMCT.getText();
			int[] rows = tbl.getSelectedRows();
			for (int i = 0; i < rows.length; i++) {
				dm.removeRow(rows[i] - i);
				bienLaiDao.deleteBL(maCongTo);
			}
		}
	}

	public void showThongTin() {
		if (dm.getRowCount() > 0) {
			for (int i = dm.getRowCount() - 1; i > -1; i--) {
				dm.removeRow(i);
			}
		}
		dSBL = bienLaiModel.getDSBienLai();
		for (int i = 0; i < dSBL.size(); i++) {
			String stringchisoctmoi = String.valueOf(dSBL.get(i).getChiSoMoi());
			String stringtiendien = String.valueOf(dSBL.get(i).getTienDien());
			dm.addRow(new String[] { dSBL.get(i).getMaCongTo(), dSBL.get(i).getNgayNhap(), dSBL.get(i).getChuKy(),
					stringchisoctmoi, stringtiendien });

		}

	}
	

	public void xoaTable() {
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			dm.removeRow(rows[i] - i);
		}
		
	}
	
	
	
	 public void suaThongTin() {
		 nhap();

		maCT = txtMCT.getText();
		ngayNhap = txtNM.getText();
		chiSoCT = chiSoMoi - chiSoCTCu;

		ngayNhap = txtNM.getText();

		DateFormat MM = new SimpleDateFormat("MM");

		thangNhap = MM.format(date);

		DateFormat yyyy = new SimpleDateFormat("yyyy");

		namNhap = yyyy.format(date);

		chiSoMoi = Integer.parseInt(txtCSMoi.getText());
		chuKy = chukycheck;
		stringChiSoCT = String.valueOf(chiSoMoi);

		int kw0to50 = 77450;
		int kw50to100 = kw0to50 + 80000;
		int kw100to200 = kw50to100 + 185800;
		int kw200to300 = kw100to200 + 2340000;
		int kw300to400 = kw200to300 + 261500;

		if (chiSoCT < 50) {
			tienDien = chiSoCT * 1549;
		} else if (chiSoCT > 50 && chiSoCT < 100) {
			tienDien = kw0to50 + (chiSoCT * 1600);
		} else if (chiSoCT > 100 && chiSoCT < 200) {
			tienDien = kw50to100 + (chiSoCT * 1858);
		} else if (chiSoCT > 200 && chiSoCT < 300) {
			tienDien = kw100to200 + (chiSoCT * 2340);
		} else if (chiSoCT > 300 && chiSoCT < 400) {
			tienDien = kw200to300 + (chiSoCT * 2615);
		} else if (chiSoCT > 400) {
			tienDien = kw300to400 + (chiSoCT * 2710);
		}
		else {
			JOptionPane.showMessageDialog(null, "Lỗi tính tiền điện !!!");
		}
		
		
		if(chiSoMoi<0) {
			JOptionPane.showMessageDialog(null, "Mã CT mới phải lớn hơn mã CT cũ !!!");
		}else {
		String stringtiendien = String.valueOf(tienDien);
		
		BienLai bl = new BienLai(maCT, ngayNhap, thangNhap, namNhap, chuKy, chiSoMoi, tienDien);

		bienLaiDao.updateBL(bl);
		int row = tbl.getSelectedRow();
		tbl.setValueAt(maCT, row, 0);
		tbl.setValueAt(ngayNhap, row, 1);
		tbl.setValueAt(chuKy, row, 2);
		tbl.setValueAt(stringChiSoCT, row, 3);
		tbl.setValueAt(stringtiendien, row, 4);
		}
	 }

		public void checkEdit() throws SQLException {
			String str = maCT;
			PreparedStatement st = connn.prepareStatement(
					"SELECT chisoCT , chukyKH FROM bienlai WHERE mactKH=? order by ngaynhapKH DESC limit 1");

			st.setString(1, str);
			System.out.println(st);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				chisoctmoicheck = rs.getInt(1);
				chukycheck = rs.getString(2);

				System.out.println(chisoctmoicheck);
				chiSoMoi = chiSoMoi;
				if (chisoctmoicheck == chiSoMoi) {

					System.out.println("bằng nhau");
					btSua.setVisible(true);
				} else {
					btSua.setVisible(false);
					System.out.println("đéo nhau");
				}
			}
			String str1 = maCT;
			PreparedStatement st1 = connn.prepareStatement(
					"SELECT chisoCT FROM bienlai WHERE mactKH=? order by ngaynhapKH DESC limit 1 OFFSET 1");

			st1.setString(1, str1);
			System.out.println(st1);
			ResultSet rs1 = st1.executeQuery();
			if (rs1.next()) {
				chisoctcucheck = rs1.getInt(1);
				System.out.println(chisoctcucheck);
			}
		}

	
	public void resetNhap() {
		txtMCT.setText("");
		txtCSMoi.setText("");
		txtCSCu.setText("");

	}

	public void showWindow() {
		this.setSize(1000, 700);
		this.setTitle("Swing Calandar");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
