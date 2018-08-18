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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

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

public class GDChinh extends JFrame {

	JComboBox<QuanPhuong> cbQuan;
	JComboBox<QuanPhuong> cbPhuong;
	JButton btKTDS;
	JButton btKTBL;
	JButton btNBL;
	JButton btHome;
	JButton btExit;
	JButton btThem;
	JButton btSua;
	JButton btXoa;
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
	String tieuchi;

	KhachHangModel tienDienDao;
	ArrayList<KhachHang> dSKH = new ArrayList<KhachHang>();
	ArrayList<QuanPhuong> dSPhuong = new ArrayList<QuanPhuong>();

	public GDChinh(String tieude) {
		super("Chỉnh sửa thông tin khách hàng");
		conect();
		addControls();
		addEvent();
		 inThongTin();

	}

	public void conect() {
		tienDienDao = new KhachHangModel();
		tienDienDao.getConnect("localhost", "quanlytiendien", "phuongadmin", "phuong321");

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

			String maKH = (String) tbl.getValueAt(row, 0);
			txtMaKH.setText(maKH);

			String tenKH = (String) tbl.getValueAt(row, 1);
			txtTen.setText(tenKH);

			String diaChi = (String) tbl.getValueAt(row, 2);
			txtDiaChi.setText(diaChi);

			String maCongTo = (String) tbl.getValueAt(row, 3);
			txtMaCongTo.setText(maCongTo);

			String email = (String) tbl.getValueAt(row, 4);
			txtEmail.setText(email);

			String sDT = (String) tbl.getValueAt(row, 5);
			txtSDT.setText(sDT);
			
			String quan = (String) tbl.getValueAt(row, 6);
			cbQuan.setSelectedItem(quan);
			
			String phuong = (String) tbl.getValueAt(row, 7);
			cbPhuong.setSelectedItem(phuong);

		}
	};

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
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.setPreferredSize(new Dimension(200, 150));

		JLabel lblMaKH = new JLabel("Mã KH:");
		txtMaKH = new JTextField(20);

		JLabel lblTen = new JLabel("Họ tên:");
		txtTen = new JTextField(20);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		txtDiaChi = new JTextField(20);

		JLabel lblPhuong = new JLabel("Phường:");
		txtPhuong = new JTextField(20);

		JLabel lblQuan = new JLabel("Quận:  ");
		txtQuan = new JTextField(20);

		JLabel lblSDT = new JLabel("SĐT:   ");
		txtSDT = new JTextField(20);

		JLabel lblEmail = new JLabel("Email:  ");
		txtEmail = new JTextField(20);

		JLabel lblMaCongTo = new JLabel("MCT:");
		txtMaCongTo = new JTextField(20);

		JPanel pnA1 = new JPanel();
		pnA1.setPreferredSize(new Dimension(40, 5));
		pnA1.add(lblMaKH);
		pnA1.add(txtMaKH);
		JPanel pnA2 = new JPanel();
		pnA2.setPreferredSize(new Dimension(40, 5));
		pnA2.add(lblTen);
		pnA2.add(txtTen);
		JPanel pnA3 = new JPanel();
		pnA3.setPreferredSize(new Dimension(40, 5));
		pnA3.add(lblDiaChi);
		pnA3.add(txtDiaChi);
		JPanel pnA4 = new JPanel();
		pnA4.setPreferredSize(new Dimension(40, 5));

		cbQuan = new JComboBox();
		ArrayList<QuanPhuong> tenQuan = new ArrayList<QuanPhuong>();
		tenQuan = tienDienDao.getQuanKH();
		for (QuanPhuong x : tenQuan) {
			cbQuan.addItem(x);
		}
		cbQuan.setPreferredSize(new Dimension(220, 21));
		cbQuan.addItemListener(chonQuan);
		pnA4.add(lblQuan);
		pnA4.add(cbQuan);
		// cbQuan.addActionListener(eventQuan1);

		// lay thong tin cac quan trong database

		// set data cho combobox quan

		// ****** panel phải
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		pnRight.setPreferredSize(new Dimension(200, 150));

		JPanel pnB1 = new JPanel();
		pnB1.setPreferredSize(new Dimension(40, 5));
		pnB1.add(lblEmail);
		pnB1.add(txtEmail);
		JPanel pnB2 = new JPanel();
		pnB2.setPreferredSize(new Dimension(40, 5));
		pnB2.add(lblSDT);
		pnB2.add(txtSDT);
		JPanel pnB3 = new JPanel();
		pnB3.setPreferredSize(new Dimension(40, 5));
		pnB3.add(lblMaCongTo);
		pnB3.add(txtMaCongTo);
		JPanel pnB4 = new JPanel();
		pnB4.setPreferredSize(new Dimension(40, 5));
		cbPhuong = new JComboBox();
		// cbPhuong.addItem("Chọn phường");
		cbPhuong.setPreferredSize(new Dimension(220, 21));
		loadDataPhuong();
		pnB4.add(lblPhuong);
		pnB4.add(cbPhuong);
		// cbPhuong.addActionListener(chonPhuong);

		// *******

		pnLeft.add(pnA1);
		pnLeft.add(pnA2);
		pnLeft.add(pnA3);
		pnLeft.add(pnB3);

		// *******

		pnRight.add(pnB1);
		pnRight.add(pnB2);
		pnRight.add(pnA4);
		pnRight.add(pnB4);

		pnCenterCon.add(pnLeft);
		pnCenterCon.add(pnRight);
		pnCenter.add(pnCenterCon);
		pnCenter.add(pnDuoi);

		// ****** tạo panel Trái chứa hai button
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
		btKTDS.setMargin(new Insets(8, 0, 8, 26));
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
		pnBTL.add(btKTDS);
		pnBTL.add(pnPlace2);
		pnBTL.add(pnPlace5);
		pnBTL.add(btKTBL);
		pnBTL.add(pnPlace4);
		pnBTL.add(pnPlace6);
		pnBTL.add(btNBL);

		// ****** tạo panel Phải chứa hai button
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

		con.add(pnBorder);

	}

	public void nhapThongTin() {
		 String maKhachHang = txtMaKH.getText();
		 String tenKhachHang = txtTen.getText();
		 String diaChi = txtDiaChi.getText();
		 int idquan = ((QuanPhuong)cbQuan.getSelectedItem()).getId();
		 int idphuong = ((QuanPhuong) cbPhuong.getSelectedItem()).getId();
		 String email = txtEmail.getText();
		 String soDT = txtSDT.getText();
		 String maCongTo = txtMaCongTo.getText();
		 String phuong = cbPhuong.getSelectedItem().toString();
		 String quan = cbQuan.getSelectedItem().toString();
		 dm.addRow(new String[] { maKhachHang, tenKhachHang, diaChi, maCongTo, email,
		 soDT,quan, phuong});
		 tienDienDao.add(new KhachHang(maKhachHang, tenKhachHang, diaChi, maCongTo,
		 email, soDT,idquan ,idphuong));
	}

	public void suaThongTin() {
		 String maKhachHang = txtMaKH.getText();
		 String tenKhachHang = txtTen.getText();
		 String diaChi = txtDiaChi.getText();
		 String email = txtEmail.getText();
		 String soDT = txtSDT.getText();
		 String maCongTo = txtMaCongTo.getText();
		 int idquan = ((QuanPhuong) cbQuan.getSelectedItem()).getId();
		 int idphuong = ((QuanPhuong) cbPhuong.getSelectedItem()).getId();
		 String phuong = cbPhuong.getSelectedItem().toString();
		 String quan = cbQuan.getSelectedItem().toString();
		 tienDienDao.update(new KhachHang(maKhachHang, tenKhachHang, diaChi, maCongTo,
		 email, soDT,idquan ,idphuong));
		 int row = tbl.getSelectedRow();
		 tbl.setValueAt(tenKhachHang, row, 1);
		 tbl.setValueAt(diaChi, row, 2);
		 tbl.setValueAt(maCongTo, row, 3);
		 tbl.setValueAt(email, row, 4);
		 tbl.setValueAt(soDT, row, 5);
		 tbl.setValueAt(quan, row, 6);
		 tbl.setValueAt(phuong, row, 7);
	}

	 public void inThongTin() {
	 dSKH = tienDienDao.getDSKhachHang();
	 dSPhuong = tienDienDao.getQuanKH();
//	 dSPhuong = tienDienDao.getPhuongKH();
	 for (int i = 0; i < dSKH.size(); i++) {
	 dm.addRow(new String[] { dSKH.get(i).getMaKH(), dSKH.get(i).getTenKH(),
	 dSKH.get(i).getDiaChi(),
	 dSKH.get(i).getMaCongTo(), dSKH.get(i).getEmail(), dSKH.get(i).getsDT(),
					KhachHangModel.getNameQuan(dSKH.get(i).getMaQuan()),
							KhachHangModel.getNamePhuong(dSKH.get(i).getMaPhuong()) });
	
	 }
	 }


	public void xoaThongTin() {
		String maKhachHang = txtMaKH.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			dm.removeRow(rows[i] - i);
			tienDienDao.delete(maKhachHang);
		}
	}

	ActionListener actionListener = new ActionListener() {// phan code giao dien do nam dau em
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
			if (e.getSource() == btNBL) {
				GDNhapBienLai nhapBienLai = new GDNhapBienLai("Thống Kê Biên Lai");
				nhapBienLai.showWindow();
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
			if (e.getSource() == btHome) {
				GDHome home = new GDHome("Home");
				home.showWindow();
				setVisible(false);
			}
			if (e.getSource() == btExit) {
				// inThongTin();

			}
			if (e.getSource() == btThem) {
				nhapThongTin();
			}
			if (e.getSource() == btSua) {
				suaThongTin();
			}
			if (e.getSource() == btXoa) {
				xoaThongTin();
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
	// private void addComboBoxCounty(ResultSet county, JComboBox<String> cb) throws
	// SQLException {
	// while (county.next()) {
	//// cbQuan.addItem(cb);
	//
	// cb.addItem(county.getString("tenquan"));
	// }
	// }
	//
	// private void addComboBoxWard(ResultSet wardList, JComboBox<Quan> cb) throws
	// SQLException {
	// while (wardList.next()) {
	//// cb.addItem(wardList.getString("tenphuong"));
	// }
	// }

	public void showWindow() {
		this.setSize(1000, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
