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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlymayatm.quanly.dao.QuanLyGiaoDichDAO;
import fasttrackse.quanlymayatm.quanly.dao.QuanLyKhachHangDAO;
import fasttrackse.quanlymayatm.quanly.dao.QuanLyMayATMDAO;
import fasttrackse.quanlymayatm.quanly.dao.TinhThanhPhoDAO;
import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanHuyen;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyGiaoDich;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyKhachHang;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyMayATM;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;
import fasttrackse.quanlymayatm.quanly.entity.TinhTrangMayATM;

/**
 * @author QuangDai
 *
 */

public class QuanLyTheATMUI extends JPanel {
	JLabel JLabelMaMay = new JLabel("Mã Máy: "), JLabelViTri = new JLabel("Vị Trí: "),
			JLabelTinhTrang = new JLabel("Tình Trạng: "), JLabelTongTien = new JLabel("Tổng Tiền: ");

	JTextField TimKiem = new JTextField(20), MaMay = new JTextField(20), ViTri = new JTextField(20),
			TongTien = new JTextField(20);

	JButton ThenButton = new JButton("Thêm Mới"), SuaButton = new JButton("Sữa"), XoaButton = new JButton("Xóa"),
			ThucHienButton = new JButton("Thực Hiện"), HuyButton = new JButton("Hủy"),
			TimKiemButton = new JButton("Tìm Kiếm");

	JPanel pnMain = new JPanel(), pnThongTin = new JPanel(), pnDSMay = new JPanel(), pnThongTinMay = new JPanel(),
			pnDanhSachGiaoDich = new JPanel();

	DefaultTableModel QLKhachHangTable = new DefaultTableModel(), DSGiaoDichtable = new DefaultTableModel();
	JTable tableDSKH, tableDSGiaoDich;

	public static QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	public static ArrayList<QuanLyKhachHang> arr = new ArrayList<QuanLyKhachHang>();

	public QuanLyTheATMUI() {
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		/*
		// Phần hiển thị thông tin máy
		pnThongTin.setPreferredSize(new Dimension(900, 350));
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.X_AXIS));
		// Phần danh sách máy trong JPanel Thông Tin
		pnDSMay.setBorder(BorderFactory.createRaisedBevelBorder());
		pnDSMay.setLayout(new GridBagLayout());

		// JTable danh sách thẻ
		QLKhachHangTable.addColumn("");
		QLKhachHangTable.addColumn("");
		QLKhachHangTable.addColumn("");
		QLKhachHangTable.addColumn("");
		QLKhachHangTable.addColumn("");
		QLKhachHangTable.addColumn("");
		// this.getTableDSKH();
		tableDSKH = new JTable(QLKhachHangTable);
		tableDSKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pnDanhSach = new JScrollPane(tableDSKH);
		pnDanhSach.setPreferredSize(new Dimension(400, 200));
		addItem(pnDSMay, pnDanhSach, 0, 3, 4, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách máy
		Border borderDSMay = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSMay = BorderFactory.createTitledBorder(borderDSMay, "Danh Sách Khách Hàng");
		pnDSMay.setBorder(borderTitleDSMay);
		// Phần thông tin máy trong JPanel Thông Tin
		pnThongTinMay.setBorder(BorderFactory.createRaisedBevelBorder());
		pnThongTinMay.setLayout(new GridBagLayout());
		// add Label
		addItem(pnDSMay, TimKiem, 0, 0, 1, 1, GridBagConstraints.WEST);
		// add button
		addItem(pnDSMay, TimKiemButton, 1, 0, 1, 1, GridBagConstraints.WEST);
		// add Label vào pnThongTinMay
		addItem(pnThongTinMay, JLabelMaMay, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, JLabelViTri, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, JLabelTinhTrang, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, JLabelTongTien, 0, 3, 1, 1, GridBagConstraints.WEST);
		// add TextField vào pnThongTinMay
		addItem(pnThongTinMay, MaMay, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, ViTri, 1, 1, 1, 1, GridBagConstraints.WEST);

		addItem(pnThongTinMay, TongTien, 1, 3, 1, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao thông tin máy
		Border borderTTMay = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleTTMay = BorderFactory.createTitledBorder(borderTTMay, "Thông Tin Thẻ");
		pnThongTinMay.setBorder(borderTitleTTMay);
		// add pnDSMay, pnThongTinMay vào pnThongTin
		pnThongTin.add(pnDSMay);
		pnThongTin.add(pnThongTinMay);
		//
		
		// JTable danh sách giao dịch
		DSGiaoDichtable.addColumn("Mã Khách Hàng");
		DSGiaoDichtable.addColumn("Tên Khách Hàng");
		DSGiaoDichtable.addColumn("Số CMND");
		DSGiaoDichtable.addColumn("Năm Sinh");
		DSGiaoDichtable.addColumn("Giới Tính");
		DSGiaoDichtable.addColumn("Địa Chỉ");
		this.getTableDSKhachHang();
		tableDSGiaoDich = new JTable(DSGiaoDichtable);
		tableDSKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pnDanhSachGD = new JScrollPane(tableDSGiaoDich);
		pnDanhSachGD.setPreferredSize(new Dimension(900, 350));
		// Tạo đường viền bao danh sách giao dịch
		Border borderDSGD = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSGD = BorderFactory.createTitledBorder(borderDSGD, "Danh Sách Thẻ ATM");
		pnDanhSachGD.setBorder(borderTitleDSGD);
		//
		pnMain.add(pnDanhSachGD);
		pnMain.add(pnThongTin);

		this.add(pnMain);
		addEvent();*/
	}

	public void getTableDSKhachHang() {
		arr = QuanLyKhachHangDAO.getDSKhachHang();
		for (int i = 0; i < arr.size(); i++) {
			DSGiaoDichtable.addRow(new String[] { arr.get(i).getMaKH(), arr.get(i).getTenKH(), arr.get(i).getSoCMND(),
					arr.get(i).getNamSinh(), arr.get(i).getGioiTinh(), arr.get(i).getDiaChi() });
		}
	}

	public void addEvent() {
		tableDSKH.addMouseListener(tableDSKHClick);
		TimKiemButton.addActionListener(TimKiemButtonClick);
	}

	MouseListener tableDSKHClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			loadDataTheATM();
		}
	};

	ActionListener TimKiemButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String tk = TimKiem.getText();
			QuanLyKhachHangDAO.timkiem(tk);
			QLKhachHangTable.setRowCount(0);
			arr = QuanLyKhachHangDAO.timkiem(tk);
			for (int i = 0; i < arr.size(); i++) {
				QLKhachHangTable
						.addRow(new String[] { arr.get(i).getMaKH(), arr.get(i).getTenKH(), arr.get(i).getSoCMND(),
								arr.get(i).getNamSinh(), arr.get(i).getGioiTinh(), arr.get(i).getDiaChi() });
			}
		}
	};

	public void loadDataTheATM() {
	/*	String maKH = (String) tableDSKH.getValueAt(row, 0);
		QuanLyGiaoDichDAO.timkiem(mamay);
		System.out.println(mamay);
		DSGiaoDichtable.setRowCount(0);
		mayatm = QuanLyGiaoDichDAO.timkiem(mamay);
		for (int i = 0; i < mayatm.size(); i++) {
			DSGiaoDichtable
					.addRow(new String[] { mayatm.get(i).getMaGD(), mayatm.get(i).getMaMay(), mayatm.get(i).getMaKH(),
							mayatm.get(i).getMaThe(), mayatm.get(i).getSoTien(), mayatm.get(i).getLoaiGD() });
		}*/
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
