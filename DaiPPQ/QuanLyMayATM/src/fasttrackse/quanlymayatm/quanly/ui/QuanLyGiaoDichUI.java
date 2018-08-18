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
import fasttrackse.quanlymayatm.quanly.dao.QuanLyMayATMDAO;
import fasttrackse.quanlymayatm.quanly.dao.TinhThanhPhoDAO;
import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanHuyen;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyGiaoDich;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyMayATM;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;
import fasttrackse.quanlymayatm.quanly.entity.TinhTrangMayATM;

/**
 * @author QuangDai
 *
 */

public class QuanLyGiaoDichUI extends JPanel {
	JLabel JLabelMaMay = new JLabel("Mã Máy: "), JLabelViTri = new JLabel("Vị Trí: "),
			JLabelTinhThanhPho = new JLabel("Tỉnh / Thành Phố: "), JLabelQuanHuyen = new JLabel("Quận / Huyện: "),
			JLabelPhuongXa = new JLabel("Phường / Xã: "), JLabelTinhTrang = new JLabel("Tình Trạng: "),
			JLabelTongTien = new JLabel("Tổng Tiền: ");

	JTextField MaMay = new JTextField(20), ViTri = new JTextField(20), TongTien = new JTextField(20);

	JComboBox CBBTKTinhThanhPho = new JComboBox<TinhThanhPho>(), CBBTKQuanHuyen = new JComboBox<QuanHuyen>(),
			CBBTKPhuongXa = new JComboBox<PhuongXa>(), CBBTinhTrang = new JComboBox<TinhTrangMayATM>();

	JPanel pnMain = new JPanel(), pnThongTin = new JPanel(), pnDSMay = new JPanel(), pnThongTinMay = new JPanel(),
			pnDanhSachGiaoDich = new JPanel();

	DefaultTableModel DSMaytable = new DefaultTableModel(), DSGiaoDichtable = new DefaultTableModel();
	JTable tableDSMay, tableDSGiaoDich;

	public static QuanLyMayATMDAO quanLyMayATMDAO = new QuanLyMayATMDAO();
	public static ArrayList<QuanLyMayATM> qlatm = new ArrayList<QuanLyMayATM>();
	public static ArrayList<TinhTrangMayATM> tinhtrangmayatm = new ArrayList<TinhTrangMayATM>();

	public static TinhThanhPhoDAO tinhThanhPhoDAO = new TinhThanhPhoDAO();
	public static ArrayList<TinhThanhPho> tinhtp = new ArrayList<TinhThanhPho>();
	public static ArrayList<QuanHuyen> quanhuyen = new ArrayList<QuanHuyen>();
	public static ArrayList<PhuongXa> phuongxa = new ArrayList<PhuongXa>();

	public static QuanLyGiaoDichDAO quanLyGiaoDichDAO = new QuanLyGiaoDichDAO();
	public static ArrayList<QuanLyGiaoDich> mayatm = new ArrayList<QuanLyGiaoDich>();

	public QuanLyGiaoDichUI() {
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Phần hiển thị thông tin máy
		pnThongTin.setPreferredSize(new Dimension(900, 350));
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.X_AXIS));
		// Phần danh sách máy trong JPanel Thông Tin
		pnDSMay.setBorder(BorderFactory.createRaisedBevelBorder());
		pnDSMay.setLayout(new GridBagLayout());
		// add Label vào pnDSMay
		addItem(pnDSMay, JLabelTinhThanhPho, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnDSMay, JLabelQuanHuyen, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnDSMay, JLabelPhuongXa, 0, 2, 1, 1, GridBagConstraints.WEST);
		// add DS Tinh, TP vào ComboBox TinhThanhPho
		tinhtp = tinhThanhPhoDAO.getDSTinhThanhPho();
		for (int i = 0; i < tinhtp.size(); i++) {
			CBBTKTinhThanhPho.addItem(tinhtp.get(i));
		}
		CBBTKTinhThanhPho.addItemListener(chonTinh);
		CBBTKTinhThanhPho.setPreferredSize(new Dimension(200, 20));
		//
		addItem(pnDSMay, CBBTKTinhThanhPho, 1, 0, 1, 1, GridBagConstraints.WEST);
		CBBTKQuanHuyen.setPreferredSize(new Dimension(200, 20));
		addItem(pnDSMay, CBBTKQuanHuyen, 1, 1, 1, 1, GridBagConstraints.WEST);
		CBBTKQuanHuyen.addItemListener(chonQuan);
		//
		CBBTKPhuongXa.setPreferredSize(new Dimension(200, 20));
		addItem(pnDSMay, CBBTKPhuongXa, 1, 2, 1, 1, GridBagConstraints.WEST);
		CBBTKPhuongXa.addItemListener(chonPhuong);
		// JTable danh sách máy
		DSMaytable.addColumn("Mã Máy");
		DSMaytable.addColumn("Vị Trí");
		DSMaytable.addColumn("Tình Trạng");
		DSMaytable.addColumn("Tổng Tiền");
		tableDSMay = new JTable(DSMaytable);
		JScrollPane pnDanhSach = new JScrollPane(tableDSMay);
		pnDanhSach.setPreferredSize(new Dimension(400, 200));
		addItem(pnDSMay, pnDanhSach, 0, 3, 4, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách máy
		Border borderDSMay = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSMay = BorderFactory.createTitledBorder(borderDSMay, "Danh Sách Máy");
		pnDSMay.setBorder(borderTitleDSMay);
		// Phần thông tin máy trong JPanel Thông Tin
		pnThongTinMay.setBorder(BorderFactory.createRaisedBevelBorder());
		pnThongTinMay.setLayout(new GridBagLayout());
		// add Label vào pnThongTinMay
		addItem(pnThongTinMay, JLabelMaMay, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, JLabelViTri, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, JLabelTinhTrang, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, JLabelTongTien, 0, 3, 1, 1, GridBagConstraints.WEST);
		// add TextField vào pnThongTinMay
		addItem(pnThongTinMay, MaMay, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, ViTri, 1, 1, 1, 1, GridBagConstraints.WEST);
		// add DS tình trạng vào ComboBox TinhThanhPho
		tinhtrangmayatm = QuanLyMayATMDAO.getDSTinhTrangMayATM();
		for (int i = 0; i < tinhtrangmayatm.size(); i++) {
			CBBTinhTrang.addItem(tinhtrangmayatm.get(i));
		}
		CBBTinhTrang.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTinMay, CBBTinhTrang, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTinMay, TongTien, 1, 3, 1, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao thông tin máy
		Border borderTTMay = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleTTMay = BorderFactory.createTitledBorder(borderTTMay, "Thông Tin Máy");
		pnThongTinMay.setBorder(borderTitleTTMay);
		// add pnDSMay, pnThongTinMay vào pnThongTin
		pnThongTin.add(pnDSMay);
		pnThongTin.add(pnThongTinMay);
		//
		// JTable danh sách giao dịch
		DSGiaoDichtable.addColumn("Mã Giao Dịch");
		DSGiaoDichtable.addColumn("Mã Máy");
		DSGiaoDichtable.addColumn("Tên Khách hàng");
		DSGiaoDichtable.addColumn("Mã Thẻ");
		DSGiaoDichtable.addColumn("Số Tiền");
		DSGiaoDichtable.addColumn("Loại Giao Dịch");
		// this.getTableDSGiaoDich();
		tableDSGiaoDich = new JTable(DSGiaoDichtable);
		JScrollPane pnDanhSachGD = new JScrollPane(tableDSGiaoDich);
		pnDanhSachGD.setPreferredSize(new Dimension(900, 350));
		// Tạo đường viền bao danh sách giao dịch
		Border borderDSGD = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSGD = BorderFactory.createTitledBorder(borderDSGD, "Danh Sách Giao Dich");
		pnDanhSachGD.setBorder(borderTitleDSGD);
		//
		pnMain.add(pnThongTin);
		pnMain.add(pnDanhSachGD);
		this.add(pnMain);
		addEvent();
	}

	public void getTableDSMay() {
		qlatm = QuanLyMayATMDAO.getDSMayATM();
		for (int i = 0; i < qlatm.size(); i++) {
			DSMaytable.addRow(new String[] { qlatm.get(i).getMaMay(), qlatm.get(i).getViTri(),
					qlatm.get(i).getTinhTrang(), qlatm.get(i).getTongTien() });
		}
	}

	public void addEvent() {
		tableDSMay.addMouseListener(tableDSMayClick);
	}

	MouseListener tableDSMayClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			int row = tableDSMay.getSelectedRow();

			String maMay = (String) tableDSMay.getValueAt(row, 0);
			MaMay.setText(maMay);

			String viTri = (String) tableDSMay.getValueAt(row, 1);
			ViTri.setText(viTri);

			Object tinhTrangMay = (Object) DSMaytable.getValueAt(row, 2);
			tinhtrangmayatm = QuanLyMayATMDAO.getDSTinhTrangMayATM();
			for (int i = 0; i < tinhtrangmayatm.size(); i++) {
				if (tinhTrangMay.equals(tinhtrangmayatm.get(i).getMoTa())) {
					CBBTinhTrang.setSelectedIndex(i);
				}
			}

			String tongTien = (String) tableDSMay.getValueAt(row, 3);
			TongTien.setText(tongTien);
			
			loadDataGiaoDich();
		}
	};
	
	public void loadDataGiaoDich() {
		String mamay = MaMay.getText();
		QuanLyGiaoDichDAO.timkiem(mamay);
		System.out.println(mamay);
		DSGiaoDichtable.setRowCount(0);
		mayatm = QuanLyGiaoDichDAO.timkiem(mamay);
		for (int i = 0; i < mayatm.size(); i++) {
			DSGiaoDichtable.addRow(new String[] { mayatm.get(i).getMaGD(), mayatm.get(i).getMaMay(),
					mayatm.get(i).getMaKH(), mayatm.get(i).getMaThe(), mayatm.get(i).getSoTien(),
					mayatm.get(i).getLoaiGD()});
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
		CBBTKQuanHuyen.removeAllItems();
		CBBTKPhuongXa.removeAllItems();

		TinhThanhPho item = (TinhThanhPho) CBBTKTinhThanhPho.getSelectedItem();
		int id = item.getMaTP();
		quanhuyen = TinhThanhPhoDAO.getDSQuanHuyen(id);
		for (QuanHuyen o : quanhuyen) {
			CBBTKQuanHuyen.addItem(o);
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
		CBBTKPhuongXa.removeAllItems();

		TinhThanhPho item = (TinhThanhPho) CBBTKTinhThanhPho.getSelectedItem();
		int idTP = item.getMaTP();
		QuanHuyen itemQH = (QuanHuyen) CBBTKQuanHuyen.getSelectedItem();
		int idQH = itemQH.getMaQuan();
		phuongxa = TinhThanhPhoDAO.getDSPhuongXa(idTP, idQH);
		for (PhuongXa o : phuongxa) {
			CBBTKPhuongXa.addItem(o);
		}
	}

	// khi chọn phường, xã sẽ ra các ds máy ATM
	ItemListener chonPhuong = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadDataDSMay();
			}
		}
	};

	public void loadDataDSMay() {
		String tinhTP = CBBTKTinhThanhPho.getSelectedItem().toString();
		int idTP = CBBTKTinhThanhPho.getSelectedIndex() + 1;
		String idTinhThanhpho = String.valueOf(idTP);

		String quanHuyen = CBBTKQuanHuyen.getSelectedItem().toString();
		int idQH = CBBTKQuanHuyen.getSelectedIndex() + 1;
		String idQuanHuyen = String.valueOf(idQH);

		String phuongXa = CBBTKPhuongXa.getSelectedItem().toString();
		int idPX = CBBTKPhuongXa.getSelectedIndex() + 1;
		String idPhuongXa = String.valueOf(idPX);
		
		QuanLyMayATMDAO.timkiem(idTP, idQH, idPX);
		DSMaytable.setRowCount(0);
		qlatm = QuanLyMayATMDAO.timkiem(idTP, idQH, idPX);
		for (int i = 0; i < qlatm.size(); i++) {
			DSMaytable.addRow(new String[] { qlatm.get(i).getMaMay(), qlatm.get(i).getViTri(),
					qlatm.get(i).getTinhTrang(), qlatm.get(i).getTongTien() });
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
