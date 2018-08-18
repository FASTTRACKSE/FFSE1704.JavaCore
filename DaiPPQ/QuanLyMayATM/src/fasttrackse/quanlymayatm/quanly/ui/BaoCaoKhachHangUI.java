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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlymayatm.quanly.dao.QuanLyKhachHangDAO;
import fasttrackse.quanlymayatm.quanly.dao.QuanLyMayATMDAO;
import fasttrackse.quanlymayatm.quanly.dao.TinhThanhPhoDAO;
import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanHuyen;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyKhachHang;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;

/**
 * @author QuangDai
 *
 */
public class BaoCaoKhachHangUI extends JPanel {
	JLabel JLabelTinhThanhPho = new JLabel("Tỉnh / Thành Phố: "), JLabelQuanHuyen = new JLabel("Quận / Huyện: "),
			JLabelPhuongXa = new JLabel("Phường / Xã: ");

	JComboBox CBBTinhThanhPho = new JComboBox<TinhThanhPho>(), CBBQuanHuyen = new JComboBox<QuanHuyen>(),
			CBBPhuongXa = new JComboBox<PhuongXa>();

	JPanel pnMain = new JPanel();

	JButton CapNhapButton = new JButton("Cập Nhập");

	DefaultTableModel DSKhachhangtable = new DefaultTableModel();
	JTable tableDSKhachHang;

	public static QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	public static ArrayList<QuanLyKhachHang> arr = new ArrayList<QuanLyKhachHang>();

	public static TinhThanhPhoDAO tinhThanhPhoDAO = new TinhThanhPhoDAO();
	public static ArrayList<TinhThanhPho> tinhtp = new ArrayList<TinhThanhPho>();
	public static ArrayList<QuanHuyen> quanhuyen = new ArrayList<QuanHuyen>();
	public static ArrayList<PhuongXa> phuongxa = new ArrayList<PhuongXa>();

	public BaoCaoKhachHangUI() {
		// Phần hiển thị thông tin máy
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		// Phần danh sách máy trong JPanel Thông Tin
		pnMain.setBorder(BorderFactory.createRaisedBevelBorder());
		pnMain.setLayout(new GridBagLayout());
		// add Label vào pnDSMay
		addItem(pnMain, JLabelTinhThanhPho, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnMain, JLabelQuanHuyen, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnMain, JLabelPhuongXa, 0, 2, 1, 1, GridBagConstraints.WEST);
		// add ComboBox vào pnDSMay
		tinhtp = tinhThanhPhoDAO.getDSTinhThanhPho();
		for (int i = 0; i < tinhtp.size(); i++) {
			CBBTinhThanhPho.addItem(tinhtp.get(i));
		}
		CBBTinhThanhPho.addItemListener(chonTinh);
		CBBTinhThanhPho.setPreferredSize(new Dimension(200, 20));
		addItem(pnMain, CBBTinhThanhPho, 1, 0, 1, 1, GridBagConstraints.WEST);
		//
		CBBQuanHuyen.setPreferredSize(new Dimension(200, 20));
		addItem(pnMain, CBBQuanHuyen, 1, 1, 1, 1, GridBagConstraints.WEST);
		CBBQuanHuyen.addItemListener(chonQuan);
		//
		CBBPhuongXa.setPreferredSize(new Dimension(200, 20));
		addItem(pnMain, CBBPhuongXa, 1, 2, 1, 1, GridBagConstraints.WEST);
		CBBQuanHuyen.addItemListener(chonPhuong);

		// JTable danh sách khách hàng
		DSKhachhangtable.addColumn("Mã Khách Hàng");
		DSKhachhangtable.addColumn("Tên Khách Hàng");
		DSKhachhangtable.addColumn("Số CMND");
		DSKhachhangtable.addColumn("Năm Sinh");
		DSKhachhangtable.addColumn("Giới Tính");
		DSKhachhangtable.addColumn("Địa Chỉ");
		DSKhachhangtable.addColumn("Email");
		DSKhachhangtable.addColumn("Số Điện Thoại");
		DSKhachhangtable.addColumn("Số Tài Khoản");
		DSKhachhangtable.addColumn("Số Dư");
		// this.getTable();
		tableDSKhachHang = new JTable(DSKhachhangtable);
		tableDSKhachHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pnDanhSachKhachHang = new JScrollPane(tableDSKhachHang);
		pnDanhSachKhachHang.setPreferredSize(new Dimension(900, 500));
		addItem(pnMain, pnDanhSachKhachHang, 0, 3, 2, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách khach hang
		Border borderDSKH = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSKH = BorderFactory.createTitledBorder(borderDSKH, "Danh Sách Khách Hàng");
		pnMain.setBorder(borderTitleDSKH);
		//
		this.add(pnMain);
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

	ItemListener chonPhuong = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadDataDSMay();
			}
		}
	};

	public void loadDataDSMay() {
		String tinhTP = CBBTinhThanhPho.getSelectedItem().toString();
		int idTP = CBBTinhThanhPho.getSelectedIndex() + 1;
		String idTinhThanhpho = String.valueOf(idTP);

		String quanHuyen = CBBQuanHuyen.getSelectedItem().toString();
		int idQH = CBBQuanHuyen.getSelectedIndex() + 1;
		String idQuanHuyen = String.valueOf(idQH);

		String phuongXa = CBBPhuongXa.getSelectedItem().toString();
		int idPX = CBBPhuongXa.getSelectedIndex() + 1;
		String idPhuongXa = String.valueOf(idPX);

		QuanLyMayATMDAO.timkiem(idTP, idQH, idPX);
		DSKhachhangtable.setRowCount(0);
		arr = QuanLyKhachHangDAO.timkiem(idTP, idQH, idPX);
		for (int i = 0; i < arr.size(); i++) {
			DSKhachhangtable.addRow(new String[] { arr.get(i).getMaKH(), arr.get(i).getTenKH(), arr.get(i).getSoCMND(),
					arr.get(i).getNamSinh(), arr.get(i).getGioiTinh(), arr.get(i).getDiaChi(), arr.get(i).getEmail(),
					arr.get(i).getSoDT(), arr.get(i).getSoTaiKhoang(), arr.get(i).getSoDu() });
		}
	}

	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.insets = new Insets(5, 30, 10, 10);
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c, gc);
	}
}
