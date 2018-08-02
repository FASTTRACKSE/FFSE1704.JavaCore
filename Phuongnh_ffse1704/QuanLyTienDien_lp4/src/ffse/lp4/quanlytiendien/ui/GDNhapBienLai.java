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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ffse.lp4.quanlytiendien.dao.QuanLyTienDienDAO;
import ffse.lp4.quanlytiendien.entity.KhachHang;

public class GDNhapBienLai extends JFrame {
	private JComboBox<String>cbQuan;
	private JComboBox<String>cbPhuong;
	JButton btKTDS;
	JButton btKTBL;
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
	 DefaultTableModel model;
	  Calendar cal = new GregorianCalendar();
	  JLabel label;
	  JPanel pnCalendar ; 
	
	QuanLyTienDienDAO tienDienDao;

	public GDNhapBienLai(String tieude) {
		super();
		addControls();
		conect();

	}
	public void conect() {
		tienDienDao = new QuanLyTienDienDAO();
		tienDienDao.getConnect("localhost", "quanlytiendien", "phuongadmin","phuong321");

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
		
		cbQuan = new JComboBox<String>();
		cbQuan.addItem("Tất cả Khách Hàng");
		cbQuan.addItem("Khu Vực");
		cbQuan.addItem("Khu Vực Cụ Thể");
		cbQuan.setPreferredSize(new Dimension(220, 21));
		pnA4.add(lblQuan);
		pnA4.add(cbQuan);

		// *******

		pnLeft.add(pnA1);
		pnLeft.add(pnA2);
		pnLeft.add(pnA3);
		pnLeft.add(pnA4);

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
		cbPhuong = new JComboBox<String>();
		cbPhuong.addItem("Tất cả Khách Hàng");
		cbPhuong.addItem("Khu Vực");
		cbPhuong.addItem("Khu Vực Cụ Thể");
		cbPhuong.setPreferredSize(new Dimension(220, 21));
		pnB4.add(lblPhuong);
		pnB4.add(cbPhuong);

		// *******

		pnRight.add(pnB1);
		pnRight.add(pnB2);
		pnRight.add(pnB3);
		pnRight.add(pnB4);

		pnCenterCon.add(pnLeft);
		pnCenterCon.add(pnRight);
		pnCenter.add(pnCenterCon);
		pnCenter.add(pnDuoi);

		// ****** tạo panel phải chứa hai button
		JPanel pnBTL = new JPanel();
		pnBTL.setPreferredSize(new Dimension(178, 600));
		JLabel pnPlace1 = new JLabel("              ");
		JLabel pnPlace2 = new JLabel("              ");
		JLabel pnPlace3 = new JLabel("              ");
		JLabel pnPlace4 = new JLabel("              ");
		JLabel pnPlace5 = new JLabel("              ");
		JLabel pnPlace6 = new JLabel("              ");
		pnBTL.setLayout(new BoxLayout(pnBTL, BoxLayout.Y_AXIS));
		btKTDS = new JButton("");
		ImageIcon iconDSKH = new ImageIcon(
				new ImageIcon("icon/danhsach.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel dSKhachHang = new JLabel(iconDSKH);
		btKTDS.add(dSKhachHang);
		btKTDS.setMargin(new Insets(8, 60, 8, 60));
		btKTDS.addActionListener(actionListener);

		btKTBL = new JButton("");
		ImageIcon iconThongKe = new ImageIcon(
				new ImageIcon("icon/thongke.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel thongKe = new JLabel(iconThongKe);
		btKTBL.add(thongKe);
		btKTBL.addActionListener(actionListener);
		btKTBL.setMargin(new Insets(8, 60, 8, 60));

		pnBTL.add(pnPlace1);
		pnBTL.add(pnPlace3);
		pnBTL.add(pnPlace4);
		pnBTL.add(btKTDS);
		pnBTL.add(pnPlace2);
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

		btHome = new JButton("Home");
		ImageIcon iconHome = new ImageIcon(
				new ImageIcon("icon/home.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel home = new JLabel(iconHome);
		btHome.add(home);
		btHome.setMargin(new Insets(8, 60, 8, 60));
		btHome.addActionListener(actionListener);

		btExit = new JButton("");
		ImageIcon iconExit = new ImageIcon(
				new ImageIcon("icon/exit.png").getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH));
		JLabel exit = new JLabel(iconExit);
		btExit.add(exit);
		btExit.addActionListener(actionListener);
		btExit.setMargin(new Insets(8, 60, 8, 60));

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
		dm.addColumn("Quận");
		dm.addColumn("Phường");
		dm.addColumn("Email");
		dm.addColumn("Số ĐT");
		dm.addColumn("Mã công tơ");
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
		//tạo panel chứa calendar
		 label = new JLabel();
		    label.setHorizontalAlignment(SwingConstants.CENTER);
		 
		    JButton b1 = new JButton("<-");
		    b1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.MONTH, -1);
		        updateMonth();
		      }
		    });
		 
		    JButton b2 = new JButton("->");
		    b2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.MONTH, +1);
		        updateMonth();
		      }
		    });
		 
		    JPanel panel = new JPanel();
		    panel.setLayout(new BorderLayout());
		    panel.add(b1,BorderLayout.WEST);
		    panel.add(label,BorderLayout.CENTER);
		    panel.add(b2,BorderLayout.EAST);
		 
		 
		    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		    model = new DefaultTableModel(null,columns);
		    JTable table = new JTable(model);
		    JScrollPane pane = new JScrollPane(table);
		 
		    this.add(panel,BorderLayout.NORTH);
		    this.add(pane,BorderLayout.CENTER);
		 
		    this.updateMonth();
		 
		  }
		 
		  void updateMonth() {
		    cal.set(Calendar.DAY_OF_MONTH, 1);
		    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		    int year = cal.get(Calendar.YEAR);
		    label.setText(month + " " + year);
		 
		    int startDay = cal.get(Calendar.DAY_OF_WEEK);
		    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		 
		    model.setRowCount(0);
		    model.setRowCount(weeks);
		 
		    int i = startDay-1;
		    for(int day=1;day<=numberOfDays;day++){
		      model.setValueAt(day, i/7 , i%7 );    
		      i = i + 1;
		    }
		   
	}
	
	public void nhapThongTin() {
		String maKhachHang = txtMaKH.getText();
		String tenKhachHang = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String quan = cbQuan.getSelectedItem().toString();
		String email = txtEmail.getText();
		String soDT = txtSDT.getText();
		String maCongTo = txtMaCongTo.getText();
		String phuong = cbPhuong.getSelectedItem().toString();
		dm.addRow(new String[] { maKhachHang,tenKhachHang,diaChi,quan,email,soDT,maCongTo,phuong});
		QuanLyTienDienDAO.add(new KhachHang(maKhachHang,tenKhachHang,diaChi,quan,email,soDT,maCongTo,phuong));
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
			if (e.getSource() == btHome) {
				GDHome home = new GDHome("Home");
				home.showWindow();
				setVisible(false);
			}
			if (e.getSource() == btExit) {
				System.exit(0);
			}
			if (e.getSource() == btThem) {
				nhapThongTin();
			}

		}
	};

	// public void itemStateChanged(ItemEvent event) {
	// if (event.getStateChange() == ItemEvent.SELECTED) {
	// Object item = event.getItem();
	// // do something with object
	// }
	// }

	public void showWindow() {
		this.setSize(1000, 600);
		this.setTitle("Swing Calandar");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
