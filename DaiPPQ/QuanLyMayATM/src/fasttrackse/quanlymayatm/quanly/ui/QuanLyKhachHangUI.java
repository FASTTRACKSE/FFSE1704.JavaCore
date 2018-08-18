/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.quanly.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fasttrackse.quanlymayatm.quanly.dao.QuanLyKhachHangDAO;
import fasttrackse.quanlymayatm.quanly.dao.TinhThanhPhoDAO;
import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanHuyen;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyKhachHang;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;

/**
 * @author QuangDai
 *
 */
public class QuanLyKhachHangUI extends JPanel {

	protected static final String diaChi = null;

	JLabel JLabelMaKH = new JLabel("Mã Khách Hàng: "), JLabelTenKH = new JLabel("Tên Khách Hàng: "),
			JLabelSoCMND = new JLabel("Số CMND: "), JLabelNanSinh = new JLabel("Năm Sinh: "),
			JLabelGioiTinh = new JLabel("Giới Tính: "), JLabelTinhThanhPho = new JLabel("Tỉnh / Thành Phố: "),
			JLabelQuanHuyen = new JLabel("Quận / Huyện: "), JLabelPhuongXa = new JLabel("Phường / Xã: "),
			JLabelDiaChi = new JLabel("Địa Chỉ: "), JLabelEmail = new JLabel("Email: "),
			JLabelSoDienThoai = new JLabel("Số Điện THoại: "), JLabelSoTaiKhoang = new JLabel("Số Tài Khoảng: "),
			JLabelMaTheATM = new JLabel("Mã Thẻ ATM: "), JLabelPIN = new JLabel("PIN: "),
			JLabelSoDu = new JLabel("Số Dư: ");

	JTextField MaKH = new JTextField(20), TenKH = new JTextField(20), SoCMND = new JTextField(20),
			NamSinh = new JTextField(20), GioiTinh = new JTextField(20), DiaChi = new JTextField(20),
			Email = new JTextField(20), SoDienThoai = new JTextField(20), SoTaiKhoang = new JTextField(20),
			PIN = new JTextField(20), SoDu = new JTextField(20), MaTheATM = new JTextField(20),
			TimKiem = new JTextField(20);

	JComboBox CBBTinhThanhPho = new JComboBox<TinhThanhPho>(), CBBQuanHuyen = new JComboBox<QuanHuyen>(),
			CBBPhuongXa = new JComboBox<PhuongXa>();

	JPanel pnMain = new JPanel(), pnThongTin = new JPanel(), pnDanhSach = new JPanel(), pnThem = new JPanel(),
			pnHuy = new JPanel();

	JButton ThenButton = new JButton("Thêm Mới"), SuaButton = new JButton("Sữa"), XoaButton = new JButton("Xóa"),
			ThucHienButton = new JButton("Thực Hiện"), HuyButton = new JButton("Hủy"),
			TimKiemButton = new JButton("Tìm Kiếm");

	JRadioButton radNam, radNu;

	DefaultTableModel QLKhachHangTable = new DefaultTableModel();
	JTable table;
	
	public static QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	public static ArrayList<QuanLyKhachHang> arr = new ArrayList<QuanLyKhachHang>();

	public static TinhThanhPhoDAO tinhThanhPhoDAO = new TinhThanhPhoDAO();
	public static ArrayList<TinhThanhPho> tinhtp = new ArrayList<TinhThanhPho>();
	public static ArrayList<QuanHuyen> quanhuyen = new ArrayList<QuanHuyen>();
	public static ArrayList<PhuongXa> phuongxa = new ArrayList<PhuongXa>();
	
	public QuanLyKhachHangUI() {
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Phần hiển thị thông tin khách hàng
		pnThongTin.setPreferredSize(new Dimension(900, 400));
		pnThongTin.setBorder(BorderFactory.createRaisedBevelBorder());
		pnThongTin.setLayout(new GridBagLayout());
		// add Label vào pnThongTin
		addItem(pnThongTin, JLabelMaKH, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelTenKH, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelSoCMND, 2, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelNanSinh, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelGioiTinh, 2, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelDiaChi, 0, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelTinhThanhPho, 0, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelQuanHuyen, 0, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelPhuongXa, 2, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelEmail, 0, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelSoDienThoai, 2, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelSoTaiKhoang, 0, 7, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelSoDu, 2, 7, 1, 1, GridBagConstraints.WEST);

		// add TextField, ComboBox vào pnThongTin
		addItem(pnThongTin, MaKH, 1, 0, 1, 1, GridBagConstraints.WEST);
		MaKH.setEnabled(false);
		addItem(pnThongTin, TenKH, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, SoCMND, 3, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, NamSinh, 1, 2, 1, 1, GridBagConstraints.WEST);
		// tao box gender cho giới tính khách hàng
		JPanel pnlistGender = new JPanel();
		pnlistGender.setLayout(new BoxLayout(pnlistGender, BoxLayout.X_AXIS));
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		ButtonGroup group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		pnlistGender.add(radNam);
		pnlistGender.add(radNu);
		add(pnlistGender);
		radNam.setSelected(true);
		//
		addItem(pnThongTin, pnlistGender, 3, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, DiaChi, 1, 3, 2, 1, GridBagConstraints.WEST);
		// add DS Tinh, TP vào ComboBox TinhThanhPho
		tinhtp = tinhThanhPhoDAO.getDSTinhThanhPho();
		for (int i = 0; i < tinhtp.size(); i++) {
			CBBTinhThanhPho.addItem(tinhtp.get(i));
		}
		CBBTinhThanhPho.addItemListener(chonTinh);
		CBBTinhThanhPho.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBTinhThanhPho, 1, 4, 1, 1, GridBagConstraints.WEST);
		//
		CBBQuanHuyen.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBQuanHuyen, 1, 5, 1, 1, GridBagConstraints.WEST);
		CBBQuanHuyen.addItemListener(chonQuan);
		//
		CBBPhuongXa.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBPhuongXa, 3, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, Email, 1, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, SoDienThoai, 3, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, SoTaiKhoang, 1, 7, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, SoDu, 3, 7, 1, 1, GridBagConstraints.WEST);

		// Add button vào pnThem
		addItem(pnThem, ThenButton, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThem, SuaButton, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThem, XoaButton, 2, 0, 1, 1, GridBagConstraints.WEST);
		// Add button vào pnHuy
		addItem(pnHuy, ThucHienButton, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnHuy, HuyButton, 2, 0, 1, 1, GridBagConstraints.WEST);
		pnHuy.setVisible(false);
		// Add pnThem, pnHuy vào pnThongTin
		addItem(pnThongTin, pnThem, 1, 9, 1, 1, GridBagConstraints.EAST);
		addItem(pnThongTin, pnHuy, 1, 9, 1, 1, GridBagConstraints.EAST);

		// Tạo đường viền bao thông tin chi tiết khách hàng
		Border borderTTKhachHang = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleTTKhachHang = BorderFactory.createTitledBorder(borderTTKhachHang,
				"Thông Tin Khách Hàng");
		pnThongTin.setBorder(borderTitleTTKhachHang);
		// Kết thút phần thông tin chi tiết

		// DS khách hàng
		pnDanhSach.setBorder(BorderFactory.createRaisedBevelBorder());
		pnDanhSach.setLayout(new GridBagLayout());
		addItem(pnDanhSach, TimKiem, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnDanhSach, TimKiemButton, 1, 0, 1, 1, GridBagConstraints.WEST);
		// JTable danh sách khách hàng
		QLKhachHangTable.addColumn("Mã Khách Hàng");
		QLKhachHangTable.addColumn("Tên Khách Hàng");
		QLKhachHangTable.addColumn("Số CMND");
		QLKhachHangTable.addColumn("Năm Sinh");
		QLKhachHangTable.addColumn("Giới Tính");
		QLKhachHangTable.addColumn("Địa Chỉ");
		QLKhachHangTable.addColumn("Tỉnh / Thành Phố");
		QLKhachHangTable.addColumn("Quận / Huyện");
		QLKhachHangTable.addColumn("Phường / Xã");
		QLKhachHangTable.addColumn("Email");
		QLKhachHangTable.addColumn("Số Điện Thoại");
		QLKhachHangTable.addColumn("Số Tài Khoản");
		QLKhachHangTable.addColumn("Số Dư");
		this.getTable();
		table = new JTable(QLKhachHangTable);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pnDanhSachKH = new JScrollPane(table);
		pnDanhSachKH.setPreferredSize(new Dimension(900, 280));
		addItem(pnDanhSach, pnDanhSachKH, 0, 1, 2, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách khách hàng
		Border borderDSKhachHang = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSKhachHang = BorderFactory.createTitledBorder(borderDSKhachHang,
				"Danh Sách Khách Hàng");
		pnDanhSach.setBorder(borderTitleDSKhachHang);

		// add pnThongTin, pnButton vào pnMainNorth
		pnMain.add(pnThongTin);
		pnMain.add(pnDanhSach);

		// add myTabled vào container
		this.add(pnMain);
		addEvent();
	}

	public void getTable() {
		arr = QuanLyKhachHangDAO.getDSKhachHang();
		for (int i = 0; i < arr.size(); i++) {
			QLKhachHangTable.addRow(new String[] { arr.get(i).getMaKH(), arr.get(i).getTenKH(), arr.get(i).getSoCMND(),
					arr.get(i).getNamSinh(), arr.get(i).getGioiTinh(), arr.get(i).getDiaChi(), arr.get(i).getThanhPho(),
					arr.get(i).getQuan(), arr.get(i).getPhuong(), arr.get(i).getEmail(), arr.get(i).getSoDT(),
					arr.get(i).getSoTaiKhoang(), arr.get(i).getSoDu() });
		}
	}

	public void addEvent() {
		table.addMouseListener(tableUserClick);

		ThenButton.addActionListener(ThenButtonClick);
		SuaButton.addActionListener(SuaButtonClick);
		XoaButton.addActionListener(XoaButtonClick);
		ThucHienButton.addActionListener(ThucHienButtonClick);
		HuyButton.addActionListener(HuyButtonClick);

		TimKiemButton.addActionListener(TimKiemButtonClick);
	}

	MouseListener tableUserClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			if (pnThem.isVisible() == true) {
				int row = table.getSelectedRow();

				String maKH = (String) table.getValueAt(row, 0);
				MaKH.setText(maKH);
				MaKH.setEnabled(false);

				String tenKH = (String) table.getValueAt(row, 1);
				TenKH.setText(tenKH);

				String soCMND = (String) table.getValueAt(row, 2);
				SoCMND.setText(soCMND);

				String namSinh = (String) table.getValueAt(row, 3);
				NamSinh.setText(namSinh);

				String GioiTinh = (String) table.getValueAt(row, 4);
				if (GioiTinh.equals("Nam")) {
					radNam.setSelected(true);
				} else if (GioiTinh.equals("Nữ")) {
					radNu.setSelected(true);
				}

				String diaChi = (String) table.getValueAt(row, 5);
				DiaChi.setText(diaChi);

				Object tinhTP = (Object) table.getValueAt(row, 6);
				tinhtp = TinhThanhPhoDAO.getDSTinhThanhPho();
				for (int i = 0; i < tinhtp.size(); i++) {
					if (tinhTP.equals(tinhtp.get(i).getTenTP())) {
						CBBTinhThanhPho.setSelectedIndex(i);
					}
				}

				Object quanHuyen = (Object) table.getValueAt(row, 7);
				TinhThanhPho itemTinh = (TinhThanhPho) CBBTinhThanhPho.getSelectedItem();
				int idTinh = itemTinh.getMaTP();
				quanhuyen = TinhThanhPhoDAO.getDSQuanHuyen(idTinh);
				for (int j = 0; j < quanhuyen.size(); j++) {
					if (quanHuyen.equals(quanhuyen.get(j).getTenQuan())) {
						CBBQuanHuyen.setSelectedIndex(j);
					}
				}

				Object phuongXa = (Object) table.getValueAt(row, 8);
				QuanHuyen itemQuan = (QuanHuyen) CBBQuanHuyen.getSelectedItem();
				int idQuan = itemQuan.getMaQuan();
				phuongxa = TinhThanhPhoDAO.getDSPhuongXa(idQuan);
				for (int k = 0; k < phuongxa.size(); k++) {
					if (phuongXa.equals(phuongxa.get(k).getTenPhuong())) {
						CBBPhuongXa.setSelectedIndex(k);
					}
				}

				String email = (String) table.getValueAt(row, 9);
				Email.setText(email);

				String soDT = (String) table.getValueAt(row, 10);
				SoDienThoai.setText(soDT);

				String soTK = (String) table.getValueAt(row, 11);
				SoTaiKhoang.setText(soTK);

				String soDu = (String) table.getValueAt(row, 12);
				SoDu.setText(soDu);
			}
		}
	};

	ActionListener ThenButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			pnThem.setVisible(false);
			pnHuy.setVisible(true);

			MaKH.setText("");
			TenKH.setText("");
			SoCMND.setText("");
			NamSinh.setText("");
			GioiTinh.setText("");
			DiaChi.setText("");
			Email.setText("");
			SoDienThoai.setText("");
			SoTaiKhoang.setText("");
			PIN.setText("");
			SoDu.setText("");
		}
	};

	ActionListener SuaButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			suaThongTinKH();
		}
	};

	ActionListener XoaButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			xoaThongTinKH();
		}
	};

	ActionListener ThucHienButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			themMoiKH();
			pnThem.setVisible(true);
			pnHuy.setVisible(false);
			
			MaKH.setText("");
			TenKH.setText("");
			SoCMND.setText("");
			NamSinh.setText("");
			GioiTinh.setText("");
			DiaChi.setText("");
			Email.setText("");
			SoDienThoai.setText("");
			SoTaiKhoang.setText("");
			PIN.setText("");
			SoDu.setText("");
		}
	};

	ActionListener HuyButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			pnThem.setVisible(true);
			pnHuy.setVisible(false);

			MaKH.setText("");
			TenKH.setText("");
			SoCMND.setText("");
			NamSinh.setText("");
			GioiTinh.setText("");
			DiaChi.setText("");
			Email.setText("");
			SoDienThoai.setText("");
			SoTaiKhoang.setText("");
			PIN.setText("");
			SoDu.setText("");

		}
	};
	//--
	ActionListener TimKiemButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String tk = TimKiem.getText();
			QuanLyKhachHangDAO.timkiem(tk);
			QLKhachHangTable.setRowCount(0);
			arr = QuanLyKhachHangDAO.timkiem(tk);
			for (int i = 0; i < arr.size(); i++) {
				QLKhachHangTable.addRow(new String[] { arr.get(i).getMaKH(), arr.get(i).getTenKH(), arr.get(i).getSoCMND(),
						arr.get(i).getNamSinh(), arr.get(i).getGioiTinh(), arr.get(i).getDiaChi(), arr.get(i).getThanhPho(),
						arr.get(i).getQuan(), arr.get(i).getPhuong(), arr.get(i).getEmail(), arr.get(i).getSoDT(),
						arr.get(i).getSoTaiKhoang(), arr.get(i).getSoDu() });
			}	
		}
	};
	//--
	// thêm mới máy ATM
	public void themMoiKH() {
		String tenKH = TenKH.getText();
		String soCMND = SoCMND.getText();
		String namSinh = NamSinh.getText();
		String gioiTinh = gioiTinh();

		String diaChi = DiaChi.getText();
		String thanhPho = CBBTinhThanhPho.getSelectedItem().toString();
		int idTTP = CBBTinhThanhPho.getSelectedIndex() + 1;
		String idTinhThanhpho = String.valueOf(idTTP);

		String quan = CBBQuanHuyen.getSelectedItem().toString();
		int idQH = CBBQuanHuyen.getSelectedIndex() + 1;
		String idQuanHuyen = String.valueOf(idQH);

		String phuong = CBBPhuongXa.getSelectedItem().toString();
		int idPX = CBBPhuongXa.getSelectedIndex() + 1;
		String idPhuongXa = String.valueOf(idPX);

		String email = Email.getText();
		String soDT = SoDienThoai.getText();
		String soTaiKhoang = SoTaiKhoang.getText();
		String soDu = SoDu.getText();
		
		QuanLyKhachHangDAO.add(new QuanLyKhachHang(tenKH, soCMND, namSinh, gioiTinh, diaChi, idTinhThanhpho, idQuanHuyen, idPhuongXa, email, soDT, soTaiKhoang, soDu));
		QLKhachHangTable.setRowCount(0);
		this.getTable();
	}

	// sửa thông tin khách hàng
	public void suaThongTinKH() {
		String maKH = MaKH.getText();
		String tenKH = TenKH.getText();
		String soCMND = SoCMND.getText();
		String namSinh = NamSinh.getText();
		String gioiTinh = gioiTinh();

		String diaChi = DiaChi.getText();
		String thanhPho = CBBTinhThanhPho.getSelectedItem().toString();
		int idTTP = CBBTinhThanhPho.getSelectedIndex() + 1;
		String idTinhThanhpho = String.valueOf(idTTP);

		String quan = CBBQuanHuyen.getSelectedItem().toString();
		int idQH = CBBQuanHuyen.getSelectedIndex() + 1;
		String idQuanHuyen = String.valueOf(idQH);

		String phuong = CBBPhuongXa.getSelectedItem().toString();
		int idPX = CBBPhuongXa.getSelectedIndex() + 1;
		String idPhuongXa = String.valueOf(idPX);

		String email = Email.getText();
		String soDT = SoDienThoai.getText();
		String soTaiKhoang = SoTaiKhoang.getText();
		String soDu = SoDu.getText();

		QuanLyKhachHang id = new QuanLyKhachHang(maKH, tenKH, soCMND, namSinh, gioiTinh, diaChi, idTinhThanhpho,
				idQuanHuyen, idPhuongXa, email, soDT, soTaiKhoang, soDu);
		QuanLyKhachHangDAO.update(id);

		int row = table.getSelectedRow();
		table.setValueAt(maKH, row, 0);
		table.setValueAt(tenKH, row, 1);
		table.setValueAt(soCMND, row, 2);
		table.setValueAt(namSinh, row, 3);
		table.setValueAt(gioiTinh, row, 4);
		table.setValueAt(diaChi, row, 5);
		table.setValueAt(thanhPho, row, 6);
		table.setValueAt(quan, row, 7);
		table.setValueAt(phuong, row, 8);
		table.setValueAt(email, row, 9);
		table.setValueAt(soDT, row, 10);
		table.setValueAt(soTaiKhoang, row, 11);
		table.setValueAt(soDu, row, 12);

	}

	public String gioiTinh() {
		String gender;
		if (radNam.isSelected()) {
			gender = "Nam";
		} else {
			gender = "Nữ";
		}
		return gender;
	}

	// xóa thông tin máy ATM
	public void xoaThongTinKH() {
		String maMay = MaKH.getText();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			QuanLyKhachHangDAO.delete(maMay);
			QLKhachHangTable.removeRow(rows[i] - i);
		}
	}

	// khi chọn tỉnh, thành phố sẽ ra các quận, huyện
	ItemListener chonTinh = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadDataQuanHuyen();
			}
		}
	};

	public void loadDataQuanHuyen() {
		tinhtp.clear();
		CBBQuanHuyen.removeAllItems();
		CBBPhuongXa.removeAllItems();

		TinhThanhPho item = (TinhThanhPho) CBBTinhThanhPho.getSelectedItem();
		int id = item.getMaTP();
		quanhuyen = TinhThanhPhoDAO.getDSQuanHuyen(id);
		for (QuanHuyen o : quanhuyen) {
			CBBQuanHuyen.addItem(o);
		}
	}

	// khi chọn quận, huyện sẽ ra các phường, xã
	ItemListener chonQuan = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadDataPhuongXa();
			}
		}
	};

	public void loadDataPhuongXa() {
		phuongxa.clear();
		CBBPhuongXa.removeAllItems();

		TinhThanhPho item = (TinhThanhPho) CBBTinhThanhPho.getSelectedItem();
		int idTP = item.getMaTP();
		QuanHuyen itemQH = (QuanHuyen) CBBQuanHuyen.getSelectedItem();
		int idQH = itemQH.getMaQuan();
		phuongxa = TinhThanhPhoDAO.getDSPhuongXa(idTP, idQH);
		for (PhuongXa o : phuongxa) {
			CBBPhuongXa.addItem(o);
		}
	}

	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.insets = new Insets(5, 30, 5, 5);
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c, gc);
	}
}
