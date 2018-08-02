package atm_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Customer_CRUD extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton add , update;
	JButton edit = new JButton("SỬA");
	JButton delete = new JButton("XÓA");
	JButton reset = new JButton("RESET");
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txtMa, txtTen, txtPhuong, txtDiaChi, txtSDT, txtEmail, txtSothe, txtSTK_NH, txtPhone, txtSoDu, txtMaPin;
	JComboBox setPhuong, setquan;
	DefaultTableModel dm ;
	JTable tbl;
	ActionListener chucnangkhaccl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};

	ActionListener thoatcl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener addClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener editClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener deleteClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener resetClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};

	MouseListener tblUserClick = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}
	};
	
	

	public void addEvents() {
		// btnchange_pass.addActionListener(changePassClick);
		chucnangkhac.addActionListener(chucnangkhaccl);
		thoat.addActionListener(thoatcl);
		add.addActionListener(addClick);
		edit.addActionListener(editClick);
		delete.addActionListener(deleteClick);
		reset.addActionListener(resetClick);
		tbl.addMouseListener(tblUserClick);

		// tbl.addMouseListener(tblUserClick);
	}

	public Customer_CRUD(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnNorth=new JPanel();
		pnNorth.setBackground(Color.blue);
		JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		right.setForeground(Color.red);
		pnNorth.add(right);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		

		// phân footer
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.BLUE);
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
		pnSouth.setPreferredSize(new Dimension(200, 150));
		
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần trái màn hình
		JPanel pnWest = new JPanel();
		pnWest.setPreferredSize(new Dimension(200, 50));
		pnWest.setBackground(Color.white);
		// west con
		JPanel pnWestcon = new JPanel();
		// pnWestcon.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		pnWestcon.setPreferredSize(new Dimension(200, 200));
		pnWestcon.setBackground(Color.green);
		JLabel kc1 = new JLabel("                                                      ");
		JLabel kc2 = new JLabel("                                                      ");
		JLabel kc3 = new JLabel("                                                      ");
		JLabel kc4 = new JLabel("                                                      ");
		pnWestcon.add(kc1);
		pnWestcon.add(kc2);
		pnWestcon.add(chucnangkhac);
		thoat.setMargin(new Insets(10, 20, 10, 20));
		chucnangkhac.setMargin(new Insets(10, 20, 10, 20));
		chucnangkhac.setBackground(Color.RED);
		thoat.setBackground(Color.RED);
		pnWestcon.add(kc3);
		pnWestcon.add(kc4);

		pnWestcon.add(thoat);

		pnWest.add(pnWestcon);

		pnBorder.add(pnWest, BorderLayout.WEST);

		// phần bên phải
//		JPanel pnEast = new JPanel();
//
//		pnEast.setBackground(Color.BLUE);
//		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần giữa
		JPanel pnCenter = new JPanel();
		//pnCenter.setBackground(Color.YELLOW);
		//pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(400, 200));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.X_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 300));
		JPanel pnMaKH = new JPanel();
		JLabel lblMaKH = new JLabel("MÃ KHÁCH HÀNG:");
		lblMaKH.setForeground(Color.blue);
		pnMaKH.setOpaque(false);
		// lblMaKH.setPreferredSize(new Dimension(80, 10));
		txtMa = new JTextField(15);
		txtMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaKH.add(lblMaKH);
		pnMaKH.add(txtMa);

		// pnCentercon.add(pnMaKH);

		// tên KH
		JPanel pnTen = new JPanel();
		JLabel lblTen = new JLabel("TÊN KHÁCH HÀNG:");
		lblTen.setForeground(Color.blue);
		// lblMaKH.setPreferredSize(new Dimension(80, 10));
		txtTen = new JTextField(15);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		// pnCentercon.add(pnTen);

		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setOpaque(false);
		JLabel lbldiachi = new JLabel("       ĐỊA CHỈ NHÀ:");
		lbldiachi.setPreferredSize(lblTen.getPreferredSize());
		lbldiachi.setForeground(Color.blue);
		txtDiaChi = new JTextField(15);
		txtDiaChi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnDiaChi.add(lbldiachi);
		pnDiaChi.add(txtDiaChi);

		// pnCentercon.add(pnDiaChi);

		// tạo lưới cho quận
		// JPanel pnCenterCon2 = new JPanel();
		// JLabel lblMS = new JLabel(" CHỌN QUẬN: ");
		// DefaultListModel fruitsName = new DefaultListModel();
		//
		// fruitsName.addElement("HOÀNG SA");
		// fruitsName.addElement("CẨM LỆ");
		// fruitsName.addElement("HÒA VANG");
		// fruitsName.addElement("THANH KHÊ");
		// fruitsName.addElement("SƠN TRÀ");
		// fruitsName.addElement("NGŨ HÀNH SƠN");
		// fruitsName.addElement("LIÊN CHIỂU");
		// fruitsName.addElement("HẢI CHÂU");
		//
		// final JList fruitList = new JList(fruitsName);
		// fruitList.setSelectionBackground(Color.RED);
		// fruitList.setSelectionForeground(Color.WHITE);
		//
		// fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// fruitList.setSelectedIndex(0);
		// fruitList.setVisibleRowCount(3);
		//
		// JScrollPane fruitListScrollPane = new JScrollPane(fruitList);
		// fruitListScrollPane.setPreferredSize(new Dimension(225, 50));
		// pnCenterCon2.add(lblMS);
		// pnCenterCon2.add(fruitListScrollPane);
		// pnCentercon.add(pnCenterCon2);

		// chon quận
		JPanel pnquan = new JPanel();
		pnquan.setPreferredSize(new Dimension(100, 20));
		JLabel lblquan = new JLabel("CHỌN QUẬN:  ");
		lblquan.setForeground(Color.BLUE);
		setquan = new JComboBox<String>();
		setquan.setPreferredSize(new Dimension(100, 20));

		setquan.addItem("HOÀNG SA");
		setquan.addItem("CẨM LỆ");
		setquan.addItem("HÒA VANG");
		setquan.addItem("THANH KHÊ");
		setquan.addItem("SƠN TRÀ");
		setquan.addItem("NGŨ HÀNH SƠN");
		setquan.addItem("LIÊN CHIỂU");
		setquan.addItem("HẢI CHÂU");
		// setquan.addItem("HẢI CHÂU");

		pnquan.add(lblquan);
		pnquan.add(setquan);

		// pnCentercon.add(pnquan);

		// chọn PHƯỜNG
		JPanel pnPhuong = new JPanel();
		pnPhuong.setPreferredSize(new Dimension(100, 20));
		JLabel lblPhuong = new JLabel("CÁC PHƯỜNG:  ");
		lblPhuong.setForeground(Color.BLUE);
		setPhuong = new JComboBox<String>();
		setPhuong.setPreferredSize(new Dimension(100, 20));

		setPhuong.addItem("Hòa An");
		setPhuong.addItem("Hòa Phát");
		setPhuong.addItem("Hòa Thọ Đông");
		setPhuong.addItem("Hòa Xuân");
		setPhuong.addItem("Hòa Cường Bắc");
		setPhuong.addItem("Hòa Cường Nam");
		setPhuong.addItem("Hòa Bắc");
		setPhuong.addItem("Hòa Châu");
		setPhuong.addItem("Hòa Khương");
		// setPhuong.addItem("Hòa Khương");
		// setPhuong.addItem("Hòa Khương");
		pnPhuong.add(lblPhuong);
		pnPhuong.add(setPhuong);
		// pnPhuong.add(setPhuong);
		// pnCentercon.add(pnPhuong);

		// chọn số đts
		JPanel pnPhone = new JPanel();
		pnPhone.setOpaque(false);
		JLabel nanePhone = new JLabel("        ĐIỆN THOẠI :");
		nanePhone.setForeground(Color.BLUE);
		nanePhone.setPreferredSize(lblTen.getPreferredSize());
		txtPhone = new JTextField(15);
		txtPhone.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnPhone.add(nanePhone);
		pnPhone.add(txtPhone);
		// pnCentercon.add(pnPhone);

		// email
		JPanel pnEmail = new JPanel();
		pnEmail.setOpaque(false);
		JLabel naneEmail = new JLabel("           EMAIL : ");
		naneEmail.setForeground(Color.BLUE);
		naneEmail.setPreferredSize(lblTen.getPreferredSize());
		txtEmail = new JTextField(15);
		txtEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEmail.add(naneEmail);
		pnEmail.add(txtEmail);
		// pnCentercon.add(pnEmail);
		// số tài khoản ngân hàng
		JPanel pnSoThe = new JPanel();
		pnSoThe.setOpaque(false);
		JLabel naneSoThe = new JLabel("    SỐ THẺ ATM :");
		naneSoThe.setForeground(Color.BLUE);
		naneSoThe.setPreferredSize(lblTen.getPreferredSize());
		txtSothe = new JTextField(15);
		txtSothe.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnSoThe.add(naneSoThe);
		pnSoThe.add(txtSothe);
		// pnCentercon.add(pnSoThe);

		JPanel pnTK = new JPanel();
		pnTK.setOpaque(false);
		JLabel naneTK = new JLabel("SỐ TK NGÂN HÀNG :");
		naneTK.setForeground(Color.BLUE);
		txtSTK_NH = new JTextField(15);
		txtSTK_NH.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTK.add(naneTK);
		pnTK.add(txtSTK_NH);

		JPanel pnSoDu = new JPanel();
		pnSoDu.setOpaque(false);
		JLabel naneSoDu = new JLabel("     SỐ DƯ :");
		naneSoDu.setForeground(Color.BLUE);
		naneSoDu.setPreferredSize(lblTen.getPreferredSize());
		txtSoDu = new JTextField(15);
		txtSoDu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnSoDu.add(naneSoDu);
		pnSoDu.add(txtSoDu);

		JPanel pnMaPin = new JPanel();
		pnMaPin.setOpaque(false);
		JLabel naneMaPin = new JLabel("      MÃ PIN :");
		naneMaPin.setForeground(Color.BLUE);
		naneMaPin.setPreferredSize(lblTen.getPreferredSize());
		txtMaPin = new JTextField(15);
		txtMaPin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaPin.add(naneMaPin);
		pnMaPin.add(txtMaPin);
		//ảnh thêm sửa xóa
		ImageIcon update = new ImageIcon(
				new ImageIcon("image/add.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		add= new JButton("THÊM",update);
		
		ImageIcon update1 = new ImageIcon(
				new ImageIcon("image/edit.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		edit= new JButton("SỬA",update1);
		
		ImageIcon update2 = new ImageIcon(
				new ImageIcon("image/xoa.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		delete= new JButton("XÓA",update2);
		
		ImageIcon update3 = new ImageIcon(
				new ImageIcon("image/reset.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		reset= new JButton("RESET",update3);

		JPanel pnCenterleft = new JPanel();
		pnCenterleft.setPreferredSize(new Dimension(150, 50));
		pnCenterleft.setLayout(new BoxLayout(pnCenterleft, BoxLayout.Y_AXIS));
		pnCenterleft.add(pnMaKH);
		pnCenterleft.add(pnTen);
		pnCenterleft.add(pnDiaChi);
		pnCenterleft.add(pnEmail);
		pnCenterleft.add(pnPhone);
		
		JPanel pnCenterRight = new JPanel();
		pnCenterRight.setPreferredSize(new Dimension(150, 50));
		pnCenterRight.setLayout(new BoxLayout(pnCenterRight, BoxLayout.Y_AXIS));
		pnCenterRight.add(pnquan);
		pnCenterRight.add(pnPhuong);
		pnCenterRight.add(pnSoDu);
		pnCenterRight.add(pnMaPin);
		pnCenterRight.add(pnSoThe);

		pnCentercon.add(pnCenterleft);
		pnCentercon.add(pnCenterRight);

		//
		pnCenter.add(pnCentercon);
		JLabel kc22 = new JLabel("           ");
		JLabel kc23 = new JLabel("           ");
		JLabel kc24 = new JLabel("           ");
		JLabel kc25 = new JLabel("           ");
		JLabel kc26 = new JLabel("           ");
		JLabel kc27 = new JLabel("   ");
		JLabel kc28 = new JLabel("  ");
		JLabel kc29 = new JLabel("  ");
		JLabel kc30 = new JLabel("  ");
		add.setMargin(new Insets(10, 20, 10, 20));
		edit.setMargin(new Insets(10, 20, 10, 20));
		delete.setMargin(new Insets(10, 20, 10, 20));
		reset.setMargin(new Insets(10, 20, 10, 20));
		
		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
//		add.setBackground(Color.GREEN);
//		edit.setBackground(Color.BLUE);
//		delete.setBackground(Color.RED);
//		reset.setBackground(Color.CYAN);
		pnbutton.add(add);
		pnbutton.add(kc22);
		
		pnbutton.add(edit);
		pnbutton.add(kc23);
		pnbutton.add(delete);
		pnbutton.add(kc24);
		pnbutton.add(reset);
//		pnCentercon.add(pnbutton);
		pnCenter.add(pnbutton);
		//pnCenter.add(pnCentercon);

		//JPanel pnActions =new JPanel();
		dm = new DefaultTableModel();
		
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Quận");
		dm.addColumn("Phường");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Số điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Số mã thẻ ATM");
		dm.addColumn("Số TK Ngân Hàng");
		dm.addColumn("Mã pin");
		//this.getTable();
		
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);
		// add thông tin vào pncenter con
		pnSouth.add(sc);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		con.add(pnBorder);
	}
}
