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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ffse.lp4.quanlytiendien.dao.KhachHangModel;
import ffse.lp4.quanlytiendien.entity.KhachHang;
import ffse.lp4.quanlytiendien.entity.QuanPhuong;

public class GDBienLai extends JFrame {
	private JComboBox<String> kh;
	private JComboBox<String> tg;
	private JComboBox<String> nam;
	private JComboBox<String> chuky;
	JButton btKTDS;
	JButton btCSDS;
	JButton btNBL;
	JButton btHome;
	JButton btExit;
	JButton btApDung;
	JButton btReset;
	DefaultTableModel dm;
	JTable tbl;
	String tieuchi;
	String thoiGian;
	JTextField txtPhuong;
	JTextField txtQuan;
	JPanel pnQuanPhuong;
	JPanel pnB4;
	JPanel pnB3;
	JPanel pnB2;
	private JComboBox<QuanPhuong>cbQuan;
	private JComboBox<QuanPhuong>cbPhuong;
	KhachHangModel tienDienDao;
	ArrayList<KhachHang> dSKH = new ArrayList<KhachHang>();
	ArrayList<QuanPhuong> dSPhuong = new ArrayList<QuanPhuong>();
	public GDBienLai(String tieude) {
		super("Thống Kê Biên Lai");
		this.conect();
		this.addControls();

	}

	public void conect() {
		tienDienDao = new KhachHangModel();
		tienDienDao.getConnect("localhost", "quanlytiendien", "phuongadmin", "phuong321");


	}

	public void addControls() {

		Container con = getContentPane();
		// JPanel pnBorder = new JPanel();
		// pnBorder.setLayout(new BorderLayout());
		//
		//
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
		btApDung = new JButton();
		btApDung.setPreferredSize(new Dimension(100, 50));
		ImageIcon iconApDung = new ImageIcon(
				new ImageIcon("icon/apply.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
		JLabel apDung = new JLabel(iconApDung);
		JLabel lblApDung = new JLabel("            Áp dụng");
		btApDung.add(apDung);
		btApDung.add(lblApDung);

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
		pnDuoi.add(btApDung);
		pnDuoi.add(btReset);

		// ****** tạo panel giữa chứa các ô nhập
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(540, 200));

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Nhâp dữ liệu:"));
		pnCenterCon.setBackground(Color.BLACK);
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.X_AXIS));

		// chia ra hai panel đối xứng

		// ******* panel Trái

		JLabel lblKhachHang= new JLabel("Khách Hàng:");

		JLabel lblThoiGian = new JLabel("Thời Gian:");
		
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
//		pnLeft.setPreferredSize(new Dimension(540, 150));
		JPanel pnA4 = new JPanel();
		pnA4.setPreferredSize(new Dimension(40, 5));
		kh = new JComboBox<String>();
		kh.setPreferredSize(new Dimension(220, 21));
		kh.addItem("Tất cả Khách Hàng");
		kh.addItem("Khu vực");
		kh.addItem("Khách hàng cụ thể");
		kh.addActionListener(chonTheoTieuChi);
		pnA4.add(lblKhachHang);
		pnA4.add(kh);
		JLabel lblPhuong = new JLabel("Phường:");
		JLabel lblQuan = new JLabel("Quận:  ");
		
		
		
		
		pnQuanPhuong = new JPanel();
		pnQuanPhuong.setLayout(new BoxLayout(pnQuanPhuong, BoxLayout.Y_AXIS));
		JPanel pnA3 = new JPanel();
		pnA3.setPreferredSize(new Dimension(40, 5));
		cbQuan = new JComboBox();
		ArrayList<QuanPhuong> tenQuan = new ArrayList<QuanPhuong>();
		tenQuan = tienDienDao.getQuanKH();
		for (QuanPhuong x : tenQuan) {
			cbQuan.addItem(x);
		}
		cbQuan.setPreferredSize(new Dimension(220, 21));
		cbQuan.addItemListener(chonQuan);
		pnA3.add(lblQuan);
		pnA3.add(cbQuan);
		
		
		JPanel pnA2 = new JPanel();
		pnA2.setPreferredSize(new Dimension(40, 5));
		cbPhuong = new JComboBox();
		// cbPhuong.addItem("Chọn phường");
		cbPhuong.setPreferredSize(new Dimension(220, 21));
		loadDataPhuong();
		pnA2.add(lblPhuong);
		pnA2.add(cbPhuong);
		pnQuanPhuong.add(pnA2);
		pnQuanPhuong.add(pnA3);
		
		pnLeft.add(pnA4);
		pnLeft.add(pnQuanPhuong);
		
		

		// *******

		// ****** panel phải

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
//		pnRight.setPreferredSize(new Dimension(540, 150));
		pnB4 = new JPanel();
		pnB4.setPreferredSize(new Dimension(40, 5));
		tg = new JComboBox<String>();
		tg.setPreferredSize(new Dimension(220, 21));
		tg.addItem("Theo năm");
		tg.addItem("Theo khoảng thời gian");
		tg.addItem("Theo kì (tháng-năm)");
		tg.addActionListener(chonTheoTieuChi);
		pnB4.add(lblThoiGian);
		pnB4.add(tg);
		pnB4.setVisible(false);
		pnRight.add(pnB4);
		
		JLabel lblNam = new JLabel("Chọn Năm");
		pnB3 =new JPanel();
		pnB3.setPreferredSize(new Dimension(40, 5));
		nam = new JComboBox<String>();
		nam.setPreferredSize(new Dimension(220, 21));
		nam.addItem("2000");
		nam.addItem("2001");
		nam.addItem("2002");
		nam.addItem("2003");
		nam.addItem("2004");
		nam.addItem("2005");
		nam.addItem("2006");
		nam.addItem("2007");
		nam.addItem("2008");
		nam.addItem("2009");
		nam.addItem("2010");
		nam.addItem("2011");
		nam.addItem("2012");
		nam.addItem("2013");
		nam.addItem("2014");
		nam.addItem("2015");
		nam.addItem("2016");
		nam.addItem("2017");
		nam.addItem("2018");
		nam.addItem("2019");
		nam.addItem("2020");
		nam.addItem("2021");
		nam.addItem("2022");
		nam.addItem("2023");
		nam.addItem("2024");
		pnB3.add(lblNam);
		pnB3.add(nam);
		pnB3.setVisible(false);
		pnRight.add(pnB3);
		// *******

		pnCenterCon.add(pnLeft);
		pnCenterCon.add(pnRight);
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
		
		btKTDS = new JButton("");
		ImageIcon iconDSKH = new ImageIcon(
				new ImageIcon("icon/tracuukh.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblDSKH = new JLabel("                    Kiểm Tra DSKH");
		JLabel dSKhachHang = new JLabel(iconDSKH);
		btKTDS.add(dSKhachHang);
		btKTDS.add(lblDSKH);
		btKTDS.setMargin(new Insets(8, 0, 8, 27));
		btKTDS.addActionListener(actionListener);
		
		
		btNBL = new JButton("");
		ImageIcon iconNhapBL = new ImageIcon(
				new ImageIcon("icon/nhapbl.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblNhapBL = new JLabel("                Nhập thông tin tiêu thụ");
		JLabel nhapBL = new JLabel(iconNhapBL);
		btNBL.add(nhapBL);
		btNBL.add(lblNhapBL);
		btNBL.setMargin(new Insets(8, 0, 8, 0));
		btNBL.addActionListener(actionListener);
		

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

		pnBTL.add(pnPlace1);
		pnBTL.add(pnPlace3);
		pnBTL.add(btKTDS);
		pnBTL.add(pnPlace2);
		pnBTL.add(pnPlace5);
		pnBTL.add(btCSDS);
		pnBTL.add(pnPlace4);
		pnBTL.add(pnPlace6);
		pnBTL.add(btNBL);

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
		dm.addColumn("Mã Khách Hàng");
		dm.addColumn("Họ Tên");
		dm.addColumn("Địa Chỉ");
		dm.addColumn("Thời Gian Nhập");
		dm.addColumn("Biên Lai");
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
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		getContentPane().add(pnBorder);
		
		pnQuanPhuong.setVisible(false);

				
			}
		

	
	

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btKTDS) {
				GDDSKhachHang dSKhachHang = new GDDSKhachHang("Danh Sách Khách Hàng");
				dSKhachHang.showWindow();
				setVisible(false);
			}
			if (e.getSource() == btCSDS) {
				GDChinh chinhSua = new GDChinh("Chỉnh Sửa Danh Sách");
				chinhSua.showWindow();
				setVisible(false);

			}
			if (e.getSource() == btNBL) {
				GDNhapBienLai nhapBL = new GDNhapBienLai("Chỉnh Sửa Danh Sách");
				nhapBL.showWindow();
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

		}
	};
	ActionListener chonTheoTieuChi = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object selectedObject = kh.getSelectedItem();
			tieuchi = (String) selectedObject;
			Object selectedObject1 =tg.getSelectedItem();
			thoiGian = (String) selectedObject1;
			if (tieuchi == "Tất cả Khách Hàng") {
				//showTatCaBienLaig();
			}
			tieuchi = (String) selectedObject;
			if (tieuchi == "Khu vực") {
				pnQuanPhuong.setVisible(true);
				pnB4.setVisible(true);
//				cbPhuong.setVisible(true);
//				cbPhuong.setVisible(true);
			 
			}
			
				if(thoiGian =="Theo khoảng thời gian") {
					pnB3.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
				 }
				
			if (tieuchi == "Khu vực") {
				if(thoiGian =="Theo kì (tháng-năm)") {
//					cbQuan.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
				}
			}
			if (tieuchi == "Khách hàng cụ thể") {
				if(thoiGian =="Theo năm") {
//					cbQuan.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
				}
			}
			if (tieuchi == "Khách hàng cụ thể") {
				if(thoiGian =="Theo kì (tháng-năm)") {
//					cbQuan.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
				}
			}
			if (tieuchi == "Khách hàng cụ thể") {
				if(thoiGian =="Theo Khoảng Thời Gian") {
//					cbQuan.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
//					cbPhuong.setVisible(true);
				}
			}
		}
		};
		ItemListener chonQuan = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					loadDataPhuong();
				}
			}
		};

		public void loadDataPhuong() {
			dSPhuong.clear();
			int itemPhuong = cbPhuong.getItemCount();
			for (int i = 0; i < itemPhuong; i++) {
				cbPhuong.removeItemAt(0);

			}
			QuanPhuong itemID = (QuanPhuong) cbQuan.getSelectedItem();
			int iD = itemID.getId();
			dSPhuong = tienDienDao.getPhuongKH(iD);
			for (QuanPhuong o : dSPhuong) {
				cbPhuong.addItem(o);
			}
		}

	// public void itemStateChanged(ItemEvent event) {
	// if (event.getStateChange() == ItemEvent.SELECTED) {
	// Object item = event.getItem();
	// // do something with object
	// }
	// }

	public void showWindow() {
		this.setSize(1000, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

