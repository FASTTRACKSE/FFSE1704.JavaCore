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

public class GDDSKhachHang extends JFrame {
	private JComboBox<QuanPhuong> cbQuan;
	private JComboBox<QuanPhuong> cbPhuong;
	JButton btCSDS;
	JButton btKTBL;
	JButton btNBL;
	JButton btHome;
	JButton btExit;
	JButton btApDung;
	JButton btReset;
	JTextField txtMaKH;
	JTextField txtDiaChi;
	JTextField txtPhuong;
	JTextField txtQuan;
	JTextField txtSDT;
	JTextField txtEmail;
	JTextField txtMaCongTo;
	JTextField txtTen;
	DefaultTableModel dm;
	JTable tbl;
	JPanel pnA4;
	JPanel pnB4;
	KhachHangModel tienDienDao;
	ArrayList<KhachHang> dSKH = new ArrayList<KhachHang>();
	ArrayList<QuanPhuong> dSPhuong = new ArrayList<QuanPhuong>();

	public GDDSKhachHang(String tieude) {
		super("Kiểm tra thông tin khách hàng");
		this.conect();
		this.addControls();

	}

	public void conect() {
		tienDienDao = new KhachHangModel();
		tienDienDao.getConnect("localhost", "quanlytiendien", "phuongadmin", "phuong321");

	}

	public void addControls() {

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
		btApDung = new JButton();
		btApDung.setPreferredSize(new Dimension(100, 50));
		ImageIcon iconApDung = new ImageIcon(
				new ImageIcon("icon/apply.png").getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH));
		JLabel apDung = new JLabel(iconApDung);
		JLabel lblApDung = new JLabel("            Áp dụng");
		btApDung.add(apDung);
		btApDung.add(lblApDung);
		btApDung.addActionListener(actionListener);

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
		pnCenter.setPreferredSize(new Dimension(500, 200));

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Nhâp dữ liệu:"));
		pnCenterCon.setBackground(Color.BLACK);
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.X_AXIS));

		// chia ra hai panel đối xứng

		// ******* panel Trái

		JLabel lblPhuong = new JLabel("Phường:");
		txtPhuong = new JTextField(20);

		JLabel lblQuan = new JLabel("Quận:  ");
		txtQuan = new JTextField(20);

		pnA4 = new JPanel();
		cbQuan = new JComboBox();
		ArrayList<QuanPhuong> tenQuan = new ArrayList<QuanPhuong>();
		tenQuan = tienDienDao.getQuanKH();
		for (QuanPhuong x : tenQuan) {
			cbQuan.addItem(x);
		}
		cbQuan.setPreferredSize(new Dimension(220, 21));
		cbQuan.addItemListener(chonQuan);
		cbQuan.setPreferredSize(new Dimension(220, 21));
		cbQuan.addItemListener(chonQuan);
		pnA4.add(lblQuan);
		pnA4.add(cbQuan);

		// *******

		// ****** panel phải

		pnB4 = new JPanel();
		cbPhuong = new JComboBox();

		cbPhuong.setPreferredSize(new Dimension(220, 21));
		loadDataPhuong();
		pnB4.add(lblPhuong);
		pnB4.add(cbPhuong);
		// *******

		pnCenterCon.add(pnA4);
		pnCenterCon.add(pnB4);
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

		btNBL = new JButton("");
		ImageIcon iconNhapBL = new ImageIcon(
				new ImageIcon("icon/nhapbl.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel lblNhapBL = new JLabel("                Nhập thông tin tiêu thụ");
		JLabel nhapBL = new JLabel(iconNhapBL);
		btNBL.add(nhapBL);
		btNBL.add(lblNhapBL);
		btNBL.setMargin(new Insets(8, 0, 8, 0));
		btNBL.addActionListener(actionListener);

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
		pnBTL.add(pnPlace3);
		pnBTL.add(btCSDS);
		pnBTL.add(pnPlace2);
		pnBTL.add(pnPlace5);
		pnBTL.add(btKTBL);
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
		dm.addColumn("Mã công tơ");
		dm.addColumn("Email");
		dm.addColumn("Số ĐT");
		dm.addColumn("Quận");
		dm.addColumn("Phường");
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

		con.add(pnBorder);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btCSDS) {
				GDChinh cSDanhSach = new GDChinh("Chỉnh Sửa Danh Sách");
				cSDanhSach.showWindow();
				setVisible(false);

			}
			if (e.getSource() == btKTBL) {
				GDBienLai bienLai = new GDBienLai("Thống Kê Biên Lai");
				bienLai.showWindow();
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
			if (e.getSource() == btApDung) {
				seachAndInKH();
			}
			if (e.getSource() == btExit) {
				System.exit(0);
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

	public void seachAndInKH() {
		 dSKH = tienDienDao.getDSKhachHangTheoQuanPhuong();
		 for (int i = 0; i < dSKH.size(); i++) {
		 dm.addRow(new String[] { dSKH.get(i).getMaKH(), dSKH.get(i).getTenKH(),
		 dSKH.get(i).getDiaChi(),
		 dSKH.get(i).getMaCongTo(), dSKH.get(i).getEmail(), dSKH.get(i).getsDT(),
		 KhachHangModel.getNameQuan(dSKH.get(i).getMaQuan()),
		 KhachHangModel.getNamePhuong(dSKH.get(i).getMaPhuong()) });
		 System.out.println("ok!");
		 }

	}

//	public void getTable() {
//		
//		 dSKH = tienDienDao.getDSKhachHangTheoQuanPhuong();
//		 for (int i = 0; i < dSKH.size(); i++) {
//		 dm.addRow(new String[] { dSKH.get(i).getMaKH(), dSKH.get(i).getTenKH(),
//		 dSKH.get(i).getDiaChi(),
//		 dSKH.get(i).getMaCongTo(), dSKH.get(i).getEmail(), dSKH.get(i).getsDT(),
//		 KhachHangModel.getNameQuan(dSKH.get(i).getMaQuan()),
//		 KhachHangModel.getNamePhuong(dSKH.get(i).getMaPhuong()) });
//		
//		
//		 }
//	}

	public void showWindow() {
		this.setSize(1000, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
