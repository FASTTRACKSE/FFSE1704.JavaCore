package fasttrackse.javacore.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.javacore.dao.DBMaSach;
import fasttrackse.javacore.dao.DBQuanLiBanDoc;
import fasttrackse.javacore.dao.DBThuVien;
import fasttrackse.javacore.dao.DBTinh;
import fasttrackse.javacore.entity.QuanLiDiaChi;
import fasttrackse.javacore.entity.QuanLiMuonTra;
import fasttrackse.javacore.entity.QuanLiPhuong1;
import fasttrackse.javacore.entity.QuanLiSach;
import fasttrackse.javacore.entity.QuanLiTenSach;
import fasttrackse.javacore.entity.QuanLiTheLoaiSach;
import fasttrackse.javacore.entity.QuanLiThongTinBanDoc1;
import fasttrackse.javacore.entity.QuanLiThongTinQuan1;

public class QuanLiThuVienUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnADD, btnEDIT, btnDELETE, btnOUT, btnQuanLiSach, btnQuanLiBanDoc, btnQuanLiMuonTra, btnBaoCaoThongKe,
			btntimkiem, btnBack, btnCancel, btnADD1, btnEDIT1, btnDELETE1, btnOUT1, btnBack1, btnCancel1;
	JMenuItem login, ketnoi, ketnoicsdl, docgia, ttvs, tths, ttpt, ttchupt, thetv, tkhs, ltdg, trasach, tkchucupt,
			thongkehs, dn, tr, td, dp, phdl, thoatra, tk, tkt, thongkept, tkesach, muonsach;
	JTable tblQuanLiSach, tblQuanLiBanDoc, tblQuanLiMuonTra;
	JLabel lblMaTV, lblName, lblDiaChi, lblPhuong, lblQuan, lblTinh, lblSdt, lblEmail, lblMaGD, lblMaSach, lblNgayMuon,
			lblNgayTra, lblTenSach, lblTacGia, lblNXB, lblTheLoaiSach, lblNamXB,lblMaSach1,lblTheLoaiSach1,lblTenSach1;
	JScrollPane sc1, sc, sc2;
	JPanel pnTimKiem, pnCenter, pnTable1, pnTable, pnTable2, pnMaTV, pnName, pnDiaChi, pnPhuong, pnQuan, pnTinh, pnSdt,
			pnEmail, pnAdd, pnMaGD, pnMaSach, pnNgayMuon, pnNgayTra
			, pnTenSach, pnTacGia, pnNXB, pnTheLoaiSach, pnNamXB,pnTheLoaiSach1,pnTenSach1
			;
	DefaultTableModel tableQuanSach, tableQuanLiBanDoc, tablequanLiSach;
	JMenuBar bar;
	JPanel pnMain1;
	JMenu muonSach, action, quanLiSach;
	JTextField txtTimKiem, txtMaGD, txtMaSach, txtNgayMuon, txtNgayTra, txtTenSach, txtTacGia, txtNXB, txtTheLoaiSach,
			txtNamXB;
	JTextField txtMaTV, txtName, txtDiaChi, txtSdt, txtEmail;
	DBThuVien thuVienDAO = new DBThuVien();
	DBQuanLiBanDoc banDocDAO = new DBQuanLiBanDoc();
	DBMaSach muonTraDAO = new DBMaSach();
	DBTinh dBTinh = new DBTinh();
	DBThuVien theLoai = new DBThuVien();
	Statement stm;
	ArrayList<QuanLiDiaChi> dsTinh = new ArrayList<QuanLiDiaChi>();
	ArrayList<QuanLiPhuong1> dsPhuong = new ArrayList<QuanLiPhuong1>();
	ArrayList<QuanLiThongTinQuan1> dsQuan = new ArrayList<QuanLiThongTinQuan1>();
	ArrayList<QuanLiSach> dsSach = new ArrayList<QuanLiSach>();
	ArrayList<QuanLiThongTinBanDoc1> dsBanDoc = new ArrayList<QuanLiThongTinBanDoc1>();
	ArrayList<QuanLiMuonTra> dsMuonTra = new ArrayList<QuanLiMuonTra>();
	ArrayList<QuanLiTheLoaiSach> dsTheLoai = new ArrayList<QuanLiTheLoaiSach>();
	ArrayList<QuanLiTheLoaiSach> dsTheLoai1 = new ArrayList<QuanLiTheLoaiSach>();
	ArrayList<QuanLiTenSach> dsTenSach = new ArrayList<QuanLiTenSach>();
	JComboBox<QuanLiThongTinQuan1> tenQuan;
	JComboBox<QuanLiDiaChi> tenTinh;
	JComboBox<QuanLiPhuong1> tenPhuong;
	JComboBox<QuanLiTheLoaiSach> theLoaiSach;
	JComboBox<QuanLiTheLoaiSach> theLoaiSach1;
	JComboBox<QuanLiTenSach> tenSach;

	DBQuanLiBanDoc doc = new DBQuanLiBanDoc();
	DBThuVien sach = new DBThuVien();

	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			QuanLiPhuong1 itemD1 = (QuanLiPhuong1) tenPhuong.getSelectedItem();
			String id1 = itemD1.getId();
			//
			// String TenPhuong = tenPhuong.getSelectedItem().toString();
			//
			// String TenQuan = tenQuan.getSelectedItem().toString();
			//
			// String TenTinh = tenTinh.getSelectedItem().toString();

			doc.add(new QuanLiThongTinBanDoc1(txtMaTV.getText(), txtName.getText(), txtDiaChi.getText(), id1,
					txtSdt.getText(), txtEmail.getText()));
			/*
			 * tableQuanLiBanDoc.addRow(new String[] { txtMaTV.getText(), txtName.getText(),
			 * txtDiaChi.getText(), TenPhuong, TenQuan, TenTinh, txtSdt.getText(),
			 * txtEmail.getText() });
			 */
		}
	};

	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String MaTV = txtMaTV.getText();
			String TenTV = txtName.getText();
			String DiaChi = txtDiaChi.getText();
			String Sdt = txtSdt.getText();
			String Email = txtEmail.getText();
			doc.edit(new QuanLiThongTinBanDoc1(TenTV, DiaChi, Sdt, Email, MaTV));
		}
	};

	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Thoat ha?", "Thoat", JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	};
	ActionListener btnCancelClick = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			doc.delete(txtMaTV.getText());
		}
	};

	ActionListener btnOutClick = new ActionListener() {

		public void actionPerformed(ActionEvent e) {

		}
	};

	ActionListener btnAdd1Click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			QuanLiTheLoaiSach itemD2 = (QuanLiTheLoaiSach) theLoaiSach.getSelectedItem();
			String id2 = itemD2.getId();
			sach.add(new QuanLiSach(txtMaSach.getText(), txtTenSach.getText(), txtTacGia.getText(), txtNXB.getText(),
					id2, txtNamXB.getText()));

		}
	};

	ActionListener btnEdit1Click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String MaSach = txtMaSach.getText();
			String TenSach = txtTenSach.getText();
			String TacGia = txtTacGia.getText();
			String NXB = txtNXB.getText();
			sach.edit(new QuanLiSach(TenSach, TacGia, NXB, MaSach));
		}
	};

	ActionListener btnCancel1Click = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			sach.delete(txtMaSach.getText());
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

			int row = tblQuanLiBanDoc.getSelectedRow();
			String s = (String) tblQuanLiBanDoc.getValueAt(row, 1);
			txtMaTV.setText(s);
			String x = (String) tblQuanLiBanDoc.getValueAt(row, 2);
			txtName.setText(x);
			String z = (String) tblQuanLiBanDoc.getValueAt(row, 3);
			txtDiaChi.setText(z);
			String a = (String) tblQuanLiBanDoc.getValueAt(row, 7);
			txtSdt.setText(a);
			String b = (String) tblQuanLiBanDoc.getValueAt(row, 8);
			txtEmail.setText(b);
			String c = (String) tblQuanLiBanDoc.getValueAt(row, 4);
			tenPhuong.setSelectedItem(c);
			String d = (String) tblQuanLiBanDoc.getValueAt(row, 5);
			tenQuan.setSelectedItem(d);
			String f = (String) tblQuanLiBanDoc.getValueAt(row, 6);
			tenTinh.setSelectedItem(f);

		}
	}

	;
	MouseListener tblUserClick1 = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseClicked(MouseEvent e) {

			int row = tblQuanLiSach.getSelectedRow();
			String s = (String) tblQuanLiSach.getValueAt(row, 1);
			txtMaSach.setText(s);
			String x = (String) tblQuanLiSach.getValueAt(row, 2);
			txtTenSach.setText(x);
			String z = (String) tblQuanLiSach.getValueAt(row, 3);
			txtTacGia.setText(z);
			String a = (String) tblQuanLiSach.getValueAt(row, 4);
			txtNXB.setText(a);
			String b = (String) tblQuanLiSach.getValueAt(row, 5);
			theLoaiSach.setSelectedItem(b);
			String c = (String) tblQuanLiSach.getValueAt(row, 6);
			txtNamXB.setText(c);

		}
	}

	;

	public QuanLiThuVienUI(String title) {
		super(title);
		connectDB();
		addControls();
		addEvents();
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();

		JPanel pnMain = new JPanel();

		barMenu();
		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Quản Lý Thư Viện");
		Font fontTitle = new Font("Serif", Font.BOLD | Font.ITALIC, 30);
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnCenter = new JPanel();
		pnTimKiem = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnTimKiem.setBackground(Color.PINK);
		// pnTimKiem.setVisible(false);
		ImageIcon iconsearch = new ImageIcon(
				new ImageIcon("img/cacvu10.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btntimkiem = new JButton("Tìm Kiếm", iconsearch);
		btntimkiem.addActionListener(actionListener);
		pnTimKiem.add(btntimkiem);

		txtTimKiem = new JTextField(20);
		pnTimKiem.add(txtTimKiem);
		pnMain.add(pnTimKiem);
		ImageIcon iconTrangchu = new ImageIcon(
				new ImageIcon("img/cacvu.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnQuanLiSach = new JButton("Quản Lý Sách", iconTrangchu);
		btnQuanLiSach.setBackground(Color.WHITE);
		pnTimKiem.add(btnQuanLiSach);
		ImageIcon iconTrangchu1 = new ImageIcon(
				new ImageIcon("img/cacvu2.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnQuanLiBanDoc = new JButton("Quản Lý Thông Tin Bạn Đọc", iconTrangchu1);
		btnQuanLiBanDoc.addActionListener(actionListener);
		btnQuanLiBanDoc.setBackground(Color.WHITE);
		pnTimKiem.add(btnQuanLiBanDoc);
		ImageIcon iconTrangchu2 = new ImageIcon(
				new ImageIcon("img/cacvu3.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnQuanLiMuonTra = new JButton("Quản Lý Mượn Trả Sách", iconTrangchu2);
		btnQuanLiMuonTra.setBackground(Color.WHITE);
		btnQuanLiMuonTra.addActionListener(actionListener);
		pnTimKiem.add(btnQuanLiMuonTra);
		/*
		 * ImageIcon iconTrangchu3 = new ImageIcon( new
		 * ImageIcon("img/cacvu11.png").getImage().getScaledInstance(20, 20,
		 * Image.SCALE_SMOOTH));
		 * 
		 * btnBaoCaoThongKe = new JButton("Báo Cáo Thống Kê", iconTrangchu3);
		 * btnBaoCaoThongKe.setBackground(Color.WHITE); pnTimKiem.add(btnBaoCaoThongKe);
		 */
		pnMain.add(pnTimKiem);
		pnMain.add(pnCenter);
		// Tạo panel User chứa dòng chữ pass và textbox pass
		ImageIcon iconadd = new ImageIcon(
				new ImageIcon("img/cacvu4.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnADD = new JButton("Thêm", iconadd);
		btnADD.addActionListener(actionListener);

		ImageIcon iconadd1 = new ImageIcon(
				new ImageIcon("img/cacvu4.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnADD1 = new JButton("Thêm", iconadd1);
		btnADD1.addActionListener(actionListener);
		btnADD1.setVisible(false);

		ImageIcon iconedit = new ImageIcon(
				new ImageIcon("img/cacvu7.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnEDIT = new JButton("Sửa", iconedit);
		btnEDIT.addActionListener(actionListener);

		ImageIcon iconedit1 = new ImageIcon(
				new ImageIcon("img/cacvu7.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnEDIT1 = new JButton("Sửa", iconedit1);
		btnEDIT1.addActionListener(actionListener);
		btnEDIT1.setVisible(false);

		ImageIcon icondelete = new ImageIcon(
				new ImageIcon("img/cacvu8.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnDELETE = new JButton("Xóa", icondelete);
		ImageIcon iconread = new ImageIcon(
				new ImageIcon("img/cacvu9.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnOUT = new JButton("Xem", iconread);

		ImageIcon iconback = new ImageIcon(
				new ImageIcon("img/lzthanh1.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnBack = new JButton("Back", iconback);
		btnBack.addActionListener(actionListener);
		btnBack.setVisible(false);

		ImageIcon iconcancel = new ImageIcon(
				new ImageIcon("img/cacvu13.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnCancel = new JButton("Cancel", iconcancel);
		btnCancel.addActionListener(actionListener);
		btnCancel.setVisible(false);

		ImageIcon iconcancel1 = new ImageIcon(
				new ImageIcon("img/cacvu13.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		btnCancel1 = new JButton("Cancel", iconcancel1);
		btnCancel1.addActionListener(actionListener);
		btnCancel1.setVisible(false);

		JPanel pnActions = new JPanel();
		pnActions.add(btnADD);
		pnActions.add(btnADD1);
		pnActions.add(btnEDIT);
		pnActions.add(btnEDIT1);
		pnActions.add(btnDELETE);
		pnActions.add(btnOUT);
		pnActions.add(btnCancel);
		pnActions.add(btnCancel1);
		pnActions.add(btnBack);

		tableQuanSach = new DefaultTableModel();

		tableQuanSach.addColumn("ID");
		tableQuanSach.addColumn("Mã Sách");
		tableQuanSach.addColumn("Tên Sách");
		tableQuanSach.addColumn("Tác Giả");
		tableQuanSach.addColumn("NXB");
		tableQuanSach.addColumn("Thể Loại Sách");
		tableQuanSach.addColumn("Năm Xuất Bản");

		tblQuanLiSach = new JTable(tableQuanSach);
		sc = new JScrollPane(tblQuanLiSach);

		javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Quản Lý Sách");
		sc.setBorder(borderTitle);
		// add vào table
		dsSach = thuVienDAO.getDSSach();

		for (int i = 0; i < dsSach.size(); i++) {
			tableQuanSach.addRow(new String[] { String.valueOf(i + 1), dsSach.get(i).getMaSach(),
					dsSach.get(i).getTenSach(), dsSach.get(i).getTacGia(), dsSach.get(i).getNXB(),
					dsSach.get(i).getTheLoaiSach(), dsSach.get(i).getNamXB() });
		}
		// add main panel vào container

		DefaultTableModel tableQuanLiBanDoc = new DefaultTableModel();
		tableQuanLiBanDoc.addColumn("ID");
		tableQuanLiBanDoc.addColumn("Mã TV");
		tableQuanLiBanDoc.addColumn("Họ và Tên");
		tableQuanLiBanDoc.addColumn("Địa Chỉ Nhà");
		tableQuanLiBanDoc.addColumn("Phường");
		tableQuanLiBanDoc.addColumn("Quận");
		tableQuanLiBanDoc.addColumn("Tỉnh/Thành Phố");
		tableQuanLiBanDoc.addColumn("Số ĐT");
		tableQuanLiBanDoc.addColumn("Email");

		tblQuanLiBanDoc = new JTable(tableQuanLiBanDoc);
		sc1 = new JScrollPane(tblQuanLiBanDoc);
		pnTable1 = new JPanel();
		javax.swing.border.Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Quản Lý Thông Tin Bạn Đọc");
		dsBanDoc = banDocDAO.getDSBanDoc();
		for (int i = 0; i < dsBanDoc.size(); i++) {
			tableQuanLiBanDoc
					.addRow(new String[] { String.valueOf(i + 1), dsBanDoc.get(i).getMaTV(), dsBanDoc.get(i).getTenTV(),
							dsBanDoc.get(i).getDiaChi(), dsBanDoc.get(i).getPhuong(), dsBanDoc.get(i).getQuan(),
							dsBanDoc.get(i).getTinh(), dsBanDoc.get(i).getSdt(), dsBanDoc.get(i).getEmail() });
		}
		sc1.setBorder(borderTitle1);
		sc1.setVisible(false);

		DefaultTableModel tablequanLiSach = new DefaultTableModel();
		tablequanLiSach.addColumn("ID");
		tablequanLiSach.addColumn("Mã GD");
		tablequanLiSach.addColumn("Mã Thành Viên");
		tablequanLiSach.addColumn("Ngày Mượn");
		
		tablequanLiSach.addColumn("Mã Sách");
		tablequanLiSach.addColumn("Trạng Thái");

		tblQuanLiMuonTra = new JTable(tablequanLiSach);
		sc2 = new JScrollPane(tblQuanLiMuonTra);
		pnTable2 = new JPanel();
		javax.swing.border.Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Quản Lý Mượn Trả Sách");
		dsMuonTra = muonTraDAO.getList();
		for (int i = 0; i < dsMuonTra.size(); i++) {
			tablequanLiSach
					.addRow(new String[] { String.valueOf(i + 1), dsMuonTra.get(i).getMaGD(), dsMuonTra.get(i).getMaTV(),
							dsMuonTra.get(i).getNgayMuon(), dsMuonTra.get(i).getMaSach(), dsMuonTra.get(i).getTrangThai() });
		}
		sc2.setBorder(borderTitle2);
		sc2.setVisible(false);

		
		
		// Thêm Quản Lí Thông tin bạn đọc
		pnMaTV = new JPanel();
		lblMaTV = new JLabel("Mã Thành Viên  ");
		txtMaTV = new JTextField(20);
		pnMaTV.add(lblMaTV);
		pnMaTV.add(txtMaTV);
		pnMaTV.setVisible(false);

		pnName = new JPanel();
		lblName = new JLabel("Họ và Tên TV     ");
		txtName = new JTextField(20);
		pnName.add(lblName);
		pnName.add(txtName);
		pnName.setVisible(false);

		pnDiaChi = new JPanel();
		lblDiaChi = new JLabel("Địa Chỉ Nhà       ");
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnDiaChi.setVisible(false);

		pnPhuong = new JPanel();
		lblPhuong = new JLabel("Phường             ");
		tenPhuong = new JComboBox<QuanLiPhuong1>();

		/*
		 * for (int i = 0; i < dsPhuong.size(); i++) {
		 * tenPhuong.addItem(dsPhuong.get(i).getTenPhuong()); }
		 */
		pnPhuong.add(lblPhuong);
		pnPhuong.add(tenPhuong);
		pnPhuong.setVisible(false);

		pnQuan = new JPanel();
		lblQuan = new JLabel("Quận                  ");
		tenQuan = new JComboBox<QuanLiThongTinQuan1>();
		/*
		 * dsQuan = dBTinh.getListQuan(); for (int i = 0; i < dsQuan.size(); i++) {
		 * tenQuan.addItem(dsQuan.get(i).getTenQuan()); }
		 */

		pnQuan.add(lblQuan);
		pnQuan.add(tenQuan);
		pnQuan.setVisible(false);

		pnTinh = new JPanel();

		tenTinh = new JComboBox<QuanLiDiaChi>();
		dsTinh = dBTinh.getList();
		for (QuanLiDiaChi x : dsTinh) {
			tenTinh.addItem(x);
		}

		lblTinh = new JLabel("Tỉnh/Thành Phố");
		/*
		 * JTextField txtTinh = new JTextField(20);
		 * 
		 */

		pnTinh.add(lblTinh);
		pnTinh.add(tenTinh);
		pnTinh.setVisible(false);

		pnSdt = new JPanel();
		lblSdt = new JLabel("Điện Thoại        ");
		txtSdt = new JTextField(20);
		pnSdt.add(lblSdt);
		pnSdt.add(txtSdt);
		pnSdt.setVisible(false);

		pnEmail = new JPanel();
		lblEmail = new JLabel("Email                 ");
		txtEmail = new JTextField(20);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnEmail.setVisible(false);

		// tHUÊ SÁCH
		pnMaGD = new JPanel();
		lblMaGD = new JLabel("Mã Giao Dịch  ");
		txtMaGD = new JTextField(20);
		pnMaGD.add(lblMaGD);
		pnMaGD.add(txtMaGD);
		pnMaGD.setVisible(false);

		pnMaTV = new JPanel();
		lblMaTV = new JLabel("Mã Thành Viên   ");
		txtMaTV = new JTextField(20);
		pnMaTV.add(lblMaTV);
		pnMaTV.add(txtMaTV);

		pnMaSach = new JPanel();
		lblMaSach = new JLabel("Mã Sách        ");
		txtMaSach = new JTextField(20);
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);
		pnMaSach.setVisible(false);

		pnNgayMuon = new JPanel();
		lblNgayMuon = new JLabel("Ngày Mượn     ");
		txtNgayMuon = new JTextField(20);
		pnNgayMuon.add(lblNgayMuon);
		pnNgayMuon.add(txtNgayMuon);

		pnNgayTra = new JPanel();
		lblNgayTra = new JLabel("Ngày Trả      ");
		txtNgayTra = new JTextField(20);
		pnNgayTra.add(lblNgayTra);
		pnNgayTra.add(txtNgayTra);

		pnTenSach = new JPanel();
		lblTenSach = new JLabel("Tên Sách      ");
		txtTenSach = new JTextField(20);
		pnTenSach.add(lblTenSach);
		pnTenSach.add(txtTenSach);
		pnTenSach.setVisible(false);

		pnTacGia = new JPanel();
		lblTacGia = new JLabel("Tác Giả      ");
		txtTacGia = new JTextField(20);
		pnTacGia.add(lblTacGia);
		pnTacGia.add(txtTacGia);
		pnTacGia.setVisible(false);

		pnNXB = new JPanel();
		lblNXB = new JLabel("Nhà Xuất Bản      ");
		txtNXB = new JTextField(20);
		pnNXB.add(lblNXB);
		pnNXB.add(txtNXB);
		pnNXB.setVisible(false);

		pnTheLoaiSach = new JPanel();
		theLoaiSach = new JComboBox<QuanLiTheLoaiSach>();
		dsTheLoai = theLoai.getList();
		for (QuanLiTheLoaiSach x : dsTheLoai) {
			theLoaiSach.addItem(x);
		}
		lblTheLoaiSach = new JLabel("Thể Loại Sách      ");
		/*
		 * JTextField txtTinh = new JTextField(20);
		 * 
		 */
		pnTheLoaiSach.add(lblTheLoaiSach);
		pnTheLoaiSach.add(theLoaiSach);
		pnTheLoaiSach.setVisible(false);

		pnNamXB = new JPanel();
		lblNamXB = new JLabel("Năm Xuất Bản      ");
		txtNamXB = new JTextField(20);
		pnNamXB.add(lblNamXB);
		pnNamXB.add(txtNamXB);
		pnNamXB.setVisible(false);

		// Tạp main1 để add Thuê sách
		pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		pnMain1.add(pnMaGD);
		pnMain1.add(pnMaTV);
		pnMaTV.setVisible(false);
		pnMain1.add(pnMaSach);
		pnMain1.add(pnNgayMuon);
		pnMain1.add(pnNgayTra);
		pnMain1.setVisible(false);
		
		

		pnTheLoaiSach1 = new JPanel();
		theLoaiSach1 = new JComboBox<QuanLiTheLoaiSach>();
		dsTheLoai1 = theLoai.getList();
		for (QuanLiTheLoaiSach x : dsTheLoai1) {
			theLoaiSach1.addItem(x);
		}
		lblTheLoaiSach1 = new JLabel("Thể Loại Sách      ");
		/*
		 * JTextField txtTinh = new JTextField(20);
		 * 
		 */
		pnTheLoaiSach1.add(lblTheLoaiSach1);
		pnTheLoaiSach1.add(theLoaiSach1);
		pnTheLoaiSach1.setVisible(false);


		pnTenSach1 = new JPanel();
		
		 tenSach = new JComboBox<QuanLiTenSach>();

		
		lblTheLoaiSach1 = new JLabel("Tên Sách      ");
		/*
		 * JTextField txtTinh = new JTextField(20);
		 * 
		 */
		pnTenSach1.add(lblTheLoaiSach1);
		pnTenSach1.add(tenSach);
		pnTenSach1.setVisible(false);

		

		// Kết Thúc Thêm thông tin bạn đọc

		hideButton();
		pnMain.add(pnActions);
		pnMain.add(pnTenSach);
		pnMain.add(pnMaSach);
		pnMain.add(pnTenSach1);
		pnMain.add(pnTacGia);
		pnMain.add(pnNXB);
		pnMain.add(pnTheLoaiSach);
		pnMain.add(pnTheLoaiSach1);
		pnMain.add(pnNamXB);
		pnMain.add(sc);
		pnMain.add(pnMaTV);
		pnMain.add(pnName);
		pnMain.add(pnDiaChi);
		pnMain.add(pnPhuong);
		pnMain.add(pnQuan);
		pnMain.add(pnTinh);
		pnMain.add(pnSdt);
		pnMain.add(pnEmail);
		pnMain.add(pnMain1);
		pnMain.add(sc1);
		pnMain.add(pnTable1);
		pnMain.add(sc2);
		pnMain.add(pnTable2);

		con.add(pnMain);
	}

	// Adđ event
	public void addEvents() {
		btnADD.addActionListener(btnAddClick);
		btnADD1.addActionListener(btnAdd1Click);
		btnEDIT.addActionListener(btnEditClick);
		btnEDIT1.addActionListener(btnEdit1Click);
		btnDELETE.addActionListener(btnDeleteClick);
		btnCancel.addActionListener(btnCancelClick);
		btnCancel1.addActionListener(btnCancel1Click);
		tblQuanLiBanDoc.addMouseListener(tblUserClick);
		// btnImport.addActionListener(btnImportClick);
		tblQuanLiSach.addMouseListener(tblUserClick1);
		// tenTinh.addActionListener(chonTinh);

		tenTinh.addItemListener(chonTinh);
		tenQuan.addItemListener(chonQuan);
		tenSach.addItemListener(chonTheLoai);

	}

	ActionListener actionListener = new ActionListener() {
		@Override

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnQuanLiBanDoc) {
				// nhapThongTin();

				btnQuanLiSach.setVisible(false);
				btnQuanLiBanDoc.setVisible(false);
				btnQuanLiMuonTra.setVisible(false);
				sc.setVisible(false);
				sc1.setVisible(true);
				showButton();
				btnBack.setVisible(true);
				

			}
			if (e.getSource() == btnBack) {
				// nhapThongTin();
				pnMain1.setVisible(false);
				pnTimKiem.setVisible(true);
				btnQuanLiSach.setVisible(true);
				btnQuanLiBanDoc.setVisible(true);
				btnADD1.setVisible(false);
				btnEDIT1.setVisible(false);
				btnCancel1.setVisible(false);
				btnQuanLiMuonTra.setVisible(true);
				hideButton();
				sc.setVisible(true);
				sc1.setVisible(false);
				sc2.setVisible(false);
				btnBack.setVisible(false);
				pnMaTV.setVisible(false);
				pnName.setVisible(false);
				pnDiaChi.setVisible(false);
				pnPhuong.setVisible(false);
				pnQuan.setVisible(false);
				pnTinh.setVisible(false);
				pnSdt.setVisible(false);
				pnEmail.setVisible(false);
				btnCancel.setVisible(false);
				pnTenSach.setVisible(false);
				pnMaSach.setVisible(false);
				pnTacGia.setVisible(false);
				pnNXB.setVisible(false);
				pnTheLoaiSach.setVisible(false);
				pnNamXB.setVisible(false);
				
			}
			if (e.getSource() == btnQuanLiMuonTra) {
				// nhapThongTin();

				btnQuanLiSach.setVisible(false);
				btnQuanLiBanDoc.setVisible(false);
				btnQuanLiMuonTra.setVisible(false);
				showButton();
				sc.setVisible(false);
				sc1.setVisible(false);
				sc2.setVisible(true);
				btnBack.setVisible(true);
				
			}
			if (e.getSource() == docgia) {
				// nhapThongTin();
				pnTimKiem.setVisible(false);
				btnADD.setVisible(true);
				btnADD1.setVisible(false);
				btnEDIT.setVisible(true);
				btnEDIT1.setVisible(false);

				btnDELETE.setVisible(false);
				btnOUT.setVisible(false);
				sc.setVisible(false);
				sc1.setVisible(true);
				sc2.setVisible(false);
				btnBack.setVisible(true);
				pnMaTV.setVisible(true);
				pnName.setVisible(true);
				pnDiaChi.setVisible(true);
				pnPhuong.setVisible(true);
				pnQuan.setVisible(true);
				pnTinh.setVisible(true);
				pnSdt.setVisible(true);
				pnEmail.setVisible(true);
				btnCancel.setVisible(true);
				btnCancel1.setVisible(false);
				pnMaGD.setVisible(false);
				pnMaSach.setVisible(false);
				pnNgayMuon.setVisible(false);
				pnNgayTra.setVisible(false);
				pnTenSach.setVisible(false);
				pnTacGia.setVisible(false);
				pnNXB.setVisible(false);
				pnTheLoaiSach.setVisible(false);
				pnNamXB.setVisible(false);
		
			}
			if (e.getSource() == thoatra) {
				int ret = JOptionPane.showConfirmDialog(null, "Thoát hả?", "Thoát", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			if (e.getSource() == btntimkiem) {

				/*
				 * tableQuanSach.addRow(new String[] {sachID.getMaSach(), sachID.getTenSach(),
				 * sachID.getTacGia(), sachID.getNXB(), sachID.getTheLoaiSach(),
				 * sachID.getNamXB() });
				 */

			}
			if (e.getSource() == ttvs) {
				btnQuanLiSach.setVisible(false);
				btnQuanLiBanDoc.setVisible(false);
				btnADD1.setVisible(true);
				btnADD.setVisible(false);
				btnCancel.setVisible(false);
				btnCancel1.setVisible(true);
				btnEDIT.setVisible(false);
				btnEDIT1.setVisible(true);
				btnQuanLiMuonTra.setVisible(false);
				pnTimKiem.setVisible(false);
				sc1.setVisible(false);
				sc2.setVisible(false);
				sc.setVisible(true);
				pnMaGD.setVisible(false);
				pnMaTV.setVisible(false);
				pnMain1.setVisible(true);
				btnBack.setVisible(true);
				pnName.setVisible(false);
				pnDiaChi.setVisible(false);
				pnPhuong.setVisible(false);
				pnQuan.setVisible(false);
				pnTinh.setVisible(false);
				pnSdt.setVisible(false);
				pnEmail.setVisible(false);
				pnMaSach.setVisible(false);
				pnNgayMuon.setVisible(false);
				pnNgayTra.setVisible(false);
				pnTenSach.setVisible(true);
				pnMaSach.setVisible(true);
				pnTacGia.setVisible(true);
				pnNXB.setVisible(true);
				pnTheLoaiSach.setVisible(true);
				pnNamXB.setVisible(true);
			
			}

			if (e.getSource() == muonsach) {
				btnQuanLiSach.setVisible(false);
				btnQuanLiBanDoc.setVisible(false);
				btnQuanLiMuonTra.setVisible(false);
				btnEDIT.setVisible(false);
               
				btnADD.setVisible(false);
				btnCancel.setVisible(false);
				btnEDIT1.setVisible(false);

				btnADD1.setVisible(false);
				btnCancel1.setVisible(false);
				btnDELETE.setVisible(false);
				pnTimKiem.setVisible(false);
				sc.setVisible(false);
				sc1.setVisible(false);
				sc2.setVisible(true);
				pnMaGD.setVisible(true);
				pnMaTV.setVisible(true);
				pnMain1.setVisible(true);
				btnBack.setVisible(true);
				pnName.setVisible(false);
				pnDiaChi.setVisible(false);
				pnPhuong.setVisible(false);
				pnQuan.setVisible(false);
				pnTinh.setVisible(false);
				pnSdt.setVisible(false);
				pnEmail.setVisible(false);
				pnMaSach.setVisible(false);
				pnNgayMuon.setVisible(true);
				pnNgayTra.setVisible(true);
				pnTenSach.setVisible(false);
				pnTacGia.setVisible(false);
				pnNXB.setVisible(false);
				pnTheLoaiSach.setVisible(false);
				pnNamXB.setVisible(false);
				pnTheLoaiSach1.setVisible(true);
				pnTenSach1.setVisible(true);
				
			}

			if (e.getSource() == ketnoicsdl) {
				connectDB();
			}
			if (e.getSource() == ketnoi) {
				disconnectDB();
			}
		}
	};

	public void hideButton() {
		btnADD.setVisible(false);
		btnEDIT.setVisible(false);
		btnDELETE.setVisible(false);
		btnOUT.setVisible(false);
	}

	public void showButton() {
		btnADD.setVisible(true);
		btnEDIT.setVisible(true);
		btnDELETE.setVisible(true);
		btnOUT.setVisible(true);
	}

	// Menu
	public void barMenu() {
		bar = new JMenuBar();
		setJMenuBar(bar);
		// menu háº¹ thong
		action = new JMenu("Menu");

		action.setIcon(new ImageIcon(((new ImageIcon("img/lzthanh.png")).getImage()).getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH)));
		bar.add(action);
		action.addActionListener(actionListener);
		// muc con he thong
		ketnoicsdl = new JMenuItem("Ket noi CSDL");
		action.add(ketnoicsdl);
		ketnoicsdl.setIcon(new ImageIcon(((new ImageIcon("img/connect.png")).getImage()).getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH)));

		login = new JMenuItem("Login");
		action.add(login);
		login.setIcon(new ImageIcon(
				((new ImageIcon("img/login.png")).getImage()).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		ketnoicsdl.addActionListener(actionListener);
		action.addSeparator();
		ketnoi = new JMenuItem("Ngắt Kết Nối");
		action.add(ketnoi);
		ketnoi.setIcon(new ImageIcon(((new ImageIcon("img/disconnect.png")).getImage()).getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH)));
		ketnoi.addActionListener(actionListener);
		action.addSeparator();
		thoatra = new JMenuItem("Exit");
		action.add(thoatra);
		thoatra.setIcon(new ImageIcon(
				((new ImageIcon("img/exit.png")).getImage()).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		thoatra.addActionListener(actionListener);
		// menu nhap lieu
		action = new JMenu("Thêm");
		action.setIcon(new ImageIcon(
				((new ImageIcon("img/cacvu4.png")).getImage()).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		bar.add(action);
		action.addActionListener(actionListener);
		// muc con nhap lieu
		docgia = new JMenuItem("Nhập Thông Tin Về Độc Giả");
		action.add(docgia);
		docgia.setIcon(new ImageIcon(((new ImageIcon("img/Readers.png")).getImage()).getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH)));
		docgia.addActionListener(actionListener);

		action.addSeparator();
		ttvs = new JMenuItem("Nhập Thông Tin Sách");
		action.add(ttvs);
		ttvs.setIcon(new ImageIcon(((new ImageIcon("img/writebook.png")).getImage()).getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH)));
		ttvs.addActionListener(actionListener);

		// menu Mượn Trả
		action = new JMenu("Mượn Trả Sách");
		bar.add(action);
		action.setIcon(new ImageIcon(
				((new ImageIcon("img/book.png")).getImage()).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		action.addActionListener(actionListener);
		muonsach = new JMenuItem("Mượn Sách");
		action.add(muonsach);
		muonsach.addActionListener(actionListener);

		trasach = new JMenuItem("Trả Sách");
		action.add(trasach);
		trasach.addActionListener(actionListener);
		// Quản Lí Sách4

		quanLiSach = new JMenu("Quản Lí Sách");
		bar.add(quanLiSach);
		quanLiSach.setIcon(new ImageIcon(
				((new ImageIcon("img/book.png")).getImage()).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		quanLiSach.addActionListener(actionListener);

		// menu thong ke
		action = new JMenu("Thống Kê");
		action.setIcon(new ImageIcon(((new ImageIcon("img/cacvu11.png")).getImage()).getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH)));
		bar.add(action);
		action.addActionListener(actionListener);
		// muc con thong ke
		tkesach = new JMenuItem("Thong Ke Sach");
		action.add(tkesach);
		tkesach.addActionListener(actionListener);
		tk = new JMenuItem("Thong Ke DG");
		action.add(tk);
		tk.addActionListener(actionListener);
		tkt = new JMenuItem("Thong Ke the DG");
		action.add(tkt);
		tkt.addActionListener(actionListener);
		/* ket thuc menu */
	}

	public void connectDB() {
		DBThuVien.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		if (DBThuVien.getConn() != null) {

		}
		DBQuanLiBanDoc.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		if (DBQuanLiBanDoc.getConn() != null) {

		}
		DBTinh.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		if (DBTinh.getConn() != null) {

		}DBMaSach.getConnect("localhost", "test", "qlkhjava", "qlkhjava123");
		if (DBMaSach.getConn() != null) {

		}
		else {
			JOptionPane.showMessageDialog(null, "Kết Nối Thất Bại!");
		}
	}

	public void disconnectDB() {
		try {
			DBThuVien.getConn().isClosed();
			JOptionPane.showMessageDialog(null, "Ngắt Kết Nối Thành Công!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Chưa kết nối!");
		}
	}

	ItemListener chonTinh = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (ItemEvent.SELECTED == e.getStateChange()) {
				selectQuan();
			}
		}
	};

	public void selectQuan() {
		dsQuan.clear();
		int itemCount = tenQuan.getItemCount();
		for (int i = 0; i < itemCount; i++) {
			tenQuan.removeItemAt(0);
		}
		QuanLiDiaChi itemD = (QuanLiDiaChi) tenTinh.getSelectedItem();
		String id = itemD.getId();
		dsQuan = dBTinh.getListQuan(id);
		for (QuanLiThongTinQuan1 o : dsQuan) {
			tenQuan.addItem(o);
		}
	}

	ItemListener chonQuan = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (ItemEvent.SELECTED == e.getStateChange()) {
				selectPhuong();
			}
		}
	};

	public void selectPhuong() {
		dsPhuong.clear();
		int itemCount1 = tenPhuong.getItemCount();
		for (int i = 0; i < itemCount1; i++) {
			tenPhuong.removeItemAt(0);
		}
		QuanLiThongTinQuan1 itemD1 = (QuanLiThongTinQuan1) tenQuan.getSelectedItem();
		String id1 = itemD1.getId();
		dsPhuong = dBTinh.getListPhuong(id1);
		for (QuanLiPhuong1 x : dsPhuong) {
			tenPhuong.addItem(x);
		}
	}

	ItemListener chonTheLoai = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (ItemEvent.SELECTED == e.getStateChange()) {
				selectSach();
			}
		}
	};

	public void selectSach() {
		dsTenSach.clear();
		int itemCount = tenSach.getItemCount();
		for (int i = 0; i < itemCount; i++) {
			tenSach.removeItemAt(0);
		}
		QuanLiTheLoaiSach itemD = (QuanLiTheLoaiSach) theLoaiSach1.getSelectedItem();
		String idTheLoai = itemD.getId();
		dsTenSach = muonTraDAO.getSach(idTheLoai);
		for (QuanLiTenSach s : dsTenSach) {
			tenSach.addItem(s);
		}
	}

	//
	public void showWindow() {
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}






//
//
//boolean loiThemSach = false;
//int count = chonSach.size() + 1;
//String soLuong = String.valueOf(count);
//for (int i = 0; i < chonSach.size(); i++) {
//
//	if (chonSach.size() == 3) {
//		JOptionPane.showMessageDialog(null, "Số sách cho mượn đạt tối đa");
//		loiThemSach = true;
//		break;
//	} else {
//		if (chonSach.get(i).getTenSach().equals(tenSach)) {
//			JOptionPane.showMessageDialog(null, "Sách đã được chọn từ trước");
//			loiThemSach = true;
//			break;
//		}
//	}
//
//}
//
//if (!loiThemSach) {
//	chonSach.add(new ChonSach(maSach, tenSach));
//	fruitsName.addElement(tenSach);
//	txtSL.setText(soLuong);
//}
//










