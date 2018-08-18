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

import fasttrackse.quanlymayatm.quanly.dao.QuanLyMayATMDAO;
import fasttrackse.quanlymayatm.quanly.dao.TinhThanhPhoDAO;
import fasttrackse.quanlymayatm.quanly.entity.PhuongXa;
import fasttrackse.quanlymayatm.quanly.entity.QuanHuyen;
import fasttrackse.quanlymayatm.quanly.entity.QuanLyMayATM;
import fasttrackse.quanlymayatm.quanly.entity.TinhThanhPho;
import fasttrackse.quanlymayatm.quanly.entity.TinhTrangMayATM;

/**
 * @author QuangDai
 *
 */
public class QuanLyMayATMUI extends JPanel {

	JLabel JLabelMaMay = new JLabel("Mã Máy: "), JLabelViTri = new JLabel("Vị Trí: "),
			JLabelTinhThanhPho = new JLabel("Tỉnh / Thành Phố: "), JLabelQuanHuyen = new JLabel("Quận / Huyện: "),
			JLabelPhuongXa = new JLabel("Phường / Xã: "), JLabelTinhTrang = new JLabel("Tình Trạng: "),
			JLabelTongTien = new JLabel("Tổng Tiền: ");

	JLabel JLabelTCTinhThanhPho = new JLabel("Tỉnh / Thành Phố: "), JLabelTCQuanHuyen = new JLabel("Quận / Huyện: "),
			JLabelTCPhuongXa = new JLabel("Phường / Xã: ");

	JTextField MaMay = new JTextField(20), ViTri = new JTextField(20), TongTien = new JTextField(20);

	JComboBox CBBTinhThanhPho = new JComboBox<TinhThanhPho>(), CBBQuanHuyen = new JComboBox<QuanHuyen>(),
			CBBPhuongXa = new JComboBox<PhuongXa>(), CBBTinhTrang = new JComboBox<TinhTrangMayATM>();

	JComboBox CBBTKTinhThanhPho = new JComboBox<TinhThanhPho>(), CBBTKQuanHuyen = new JComboBox<QuanHuyen>(),
			CBBTKPhuongXa = new JComboBox<PhuongXa>();

	JPanel pnMain = new JPanel(), pnThongTin = new JPanel(), pnThem = new JPanel(), pnHuy = new JPanel(),
			pnDanhSach = new JPanel();

	JButton ThenButton = new JButton("Thêm Mới"), SuaButton = new JButton("Sữa"), XoaButton = new JButton("Xóa"),
			ThucHienButton = new JButton("Thực Hiện"), HuyButton = new JButton("Hủy");

	DefaultTableModel QLMayATMTable = new DefaultTableModel();
	JTable tableQlMayATM;

	public static QuanLyMayATMDAO quanLyMayATMDAO = new QuanLyMayATMDAO();
	public static ArrayList<QuanLyMayATM> qlatm = new ArrayList<QuanLyMayATM>();
	public static ArrayList<TinhTrangMayATM> tinhtrangmayatm = new ArrayList<TinhTrangMayATM>();

	public static TinhThanhPhoDAO tinhThanhPhoDAO = new TinhThanhPhoDAO();
	public static ArrayList<TinhThanhPho> tinhtp = new ArrayList<TinhThanhPho>();
	public static ArrayList<QuanHuyen> quanhuyen = new ArrayList<QuanHuyen>();
	public static ArrayList<PhuongXa> phuongxa = new ArrayList<PhuongXa>();

	public QuanLyMayATMUI() {
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Phần hiển thị thông tin máy
		pnThongTin.setPreferredSize(new Dimension(900, 250));
		pnThongTin.setBorder(BorderFactory.createRaisedBevelBorder());
		pnThongTin.setLayout(new GridBagLayout());
		// add Label vào pnThongTin
		addItem(pnThongTin, JLabelMaMay, 0, 0, 1, 1, GridBagConstraints.WEST);
		MaMay.setEnabled(false);
		addItem(pnThongTin, JLabelViTri, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelTinhThanhPho, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelQuanHuyen, 0, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelPhuongXa, 2, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelTinhTrang, 0, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, JLabelTongTien, 2, 4, 1, 1, GridBagConstraints.WEST);

		// add TextField, ComboBox vào pnThongTin
		addItem(pnThongTin, MaMay, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, ViTri, 1, 1, 1, 1, GridBagConstraints.WEST);
		// add DS Tinh, TP vào ComboBox TinhThanhPho
		tinhtp = tinhThanhPhoDAO.getDSTinhThanhPho();
		for (int i = 0; i < tinhtp.size(); i++) {
			CBBTinhThanhPho.addItem(tinhtp.get(i));
		}
		CBBTinhThanhPho.addItemListener(chonTinh);
		CBBTinhThanhPho.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBTinhThanhPho, 1, 2, 1, 1, GridBagConstraints.WEST);
		//
		CBBQuanHuyen.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBQuanHuyen, 1, 3, 1, 1, GridBagConstraints.WEST);
		CBBQuanHuyen.addItemListener(chonQuan);
		//
		CBBPhuongXa.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBPhuongXa, 3, 3, 1, 1, GridBagConstraints.WEST);
		// add DS tình trạng vào ComboBox TinhThanhPho
		tinhtrangmayatm = QuanLyMayATMDAO.getDSTinhTrangMayATM();
		for (int i = 0; i < tinhtrangmayatm.size(); i++) {
			CBBTinhTrang.addItem(tinhtrangmayatm.get(i));
		}
		CBBTinhTrang.setPreferredSize(new Dimension(200, 20));
		addItem(pnThongTin, CBBTinhTrang, 1, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pnThongTin, TongTien, 3, 4, 1, 1, GridBagConstraints.WEST);

		// Add button vào pnThem
		addItem(pnThem, ThenButton, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThem, SuaButton, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnThem, XoaButton, 2, 0, 1, 1, GridBagConstraints.WEST);
		// Add button vào pnHuy
		addItem(pnHuy, ThucHienButton, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnHuy, HuyButton, 2, 0, 1, 1, GridBagConstraints.WEST);
		pnHuy.setVisible(false);
		// Add pnThem, pnHuy vào pnThongTin
		addItem(pnThongTin, pnThem, 1, 5, 1, 1, GridBagConstraints.EAST);
		addItem(pnThongTin, pnHuy, 1, 5, 1, 1, GridBagConstraints.EAST);

		// Tạo đường viền bao thông tin chi tiết máy
		Border borderTTKhachHang = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleTTKhachHang = BorderFactory.createTitledBorder(borderTTKhachHang, "Thông Tin Máy");
		pnThongTin.setBorder(borderTitleTTKhachHang);
		// Kết thút phần thông tin chi tiết
		//
		pnDanhSach.setBorder(BorderFactory.createRaisedBevelBorder());
		pnDanhSach.setLayout(new GridBagLayout());
		// add Label vào pnDanhSach
		addItem(pnDanhSach, JLabelTCTinhThanhPho, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnDanhSach, JLabelTCQuanHuyen, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnDanhSach, JLabelTCPhuongXa, 0, 2, 1, 1, GridBagConstraints.WEST);
		// add ComboBox vào pnDanhSach
		// add DS Tinh, TP vào ComboBox TinhThanhPho
		tinhtp = tinhThanhPhoDAO.getDSTinhThanhPho();
		for (int i = 0; i < tinhtp.size(); i++) {
			CBBTKTinhThanhPho.addItem(tinhtp.get(i));
		}
		CBBTKTinhThanhPho.addItemListener(chonTinhTK);
		CBBTKTinhThanhPho.setPreferredSize(new Dimension(200, 20));
		addItem(pnDanhSach, CBBTKTinhThanhPho, 1, 0, 1, 1, GridBagConstraints.WEST);
		//
		CBBTKQuanHuyen.setPreferredSize(new Dimension(200, 20));
		addItem(pnDanhSach, CBBTKQuanHuyen, 1, 1, 1, 1, GridBagConstraints.WEST);
		CBBTKQuanHuyen.addItemListener(chonQuanTK);
		//
		CBBTKPhuongXa.setPreferredSize(new Dimension(200, 20));
		addItem(pnDanhSach, CBBTKPhuongXa, 1, 2, 1, 1, GridBagConstraints.WEST);
		CBBTKPhuongXa.addItemListener(chonPhuongTK);
		// JTable danh sách máy
		QLMayATMTable.addColumn("Mã Máy");
		QLMayATMTable.addColumn("Tỉnh / Thành Phố");
		QLMayATMTable.addColumn("Quận / Huyện");
		QLMayATMTable.addColumn("Phường / Xã");
		QLMayATMTable.addColumn("Vị Trí");
		QLMayATMTable.addColumn("Tình Trạng");
		QLMayATMTable.addColumn("Tổng Tiền");
		this.getTable();
		tableQlMayATM = new JTable(QLMayATMTable);
		JScrollPane pnDanhSachMay = new JScrollPane(tableQlMayATM);
		pnDanhSachMay.setPreferredSize(new Dimension(900, 350));
		addItem(pnDanhSach, pnDanhSachMay, 0, 3, 3, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách máy
		Border borderDSKhachHang = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSKhachHang = BorderFactory.createTitledBorder(borderDSKhachHang, "Danh Sách Máy");
		pnDanhSach.setBorder(borderTitleDSKhachHang);

		// add pnThongTin, pnDanhSach vào pnMai
		pnMain.add(pnThongTin);
		pnMain.add(pnDanhSach);
		this.add(pnMain);
		addEvent();
	}

	public void getTable() {
		qlatm = QuanLyMayATMDAO.getDSMayATM();
		for (int i = 0; i < qlatm.size(); i++) {
			QLMayATMTable.addRow(new String[] { qlatm.get(i).getMaMay(), qlatm.get(i).getThanhPho(),
					qlatm.get(i).getQuan(), qlatm.get(i).getPhuong(), qlatm.get(i).getViTri(),
					qlatm.get(i).getTinhTrang(), qlatm.get(i).getTongTien() });
		}
	}

	public void addEvent() {
		tableQlMayATM.addMouseListener(tableUserClick);

		ThenButton.addActionListener(ThenButtonClick);
		SuaButton.addActionListener(SuaButtonClick);
		XoaButton.addActionListener(XoaButtonClick);
		ThucHienButton.addActionListener(ThucHienButtonClick);
		HuyButton.addActionListener(HuyButtonClick);
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
				int row = tableQlMayATM.getSelectedRow();

				String maMay = (String) tableQlMayATM.getValueAt(row, 0);
				MaMay.setText(maMay);
				MaMay.setEnabled(false);

				Object tinhTP = (Object) tableQlMayATM.getValueAt(row, 1);
				tinhtp = TinhThanhPhoDAO.getDSTinhThanhPho();
				for (int i = 0; i < tinhtp.size(); i++) {
					if (tinhTP.equals(tinhtp.get(i).getTenTP())) {
						CBBTinhThanhPho.setSelectedIndex(i);
					}
				}

				Object quanHuyen = (Object) tableQlMayATM.getValueAt(row, 2);
				TinhThanhPho itemTinh = (TinhThanhPho) CBBTinhThanhPho.getSelectedItem();
				int idTinh = itemTinh.getMaTP();
				quanhuyen = TinhThanhPhoDAO.getDSQuanHuyen(idTinh);
				for (int j = 0; j < quanhuyen.size(); j++) {
					if (quanHuyen.equals(quanhuyen.get(j).getTenQuan())) {
						CBBQuanHuyen.setSelectedIndex(j);
					}
				}

				Object phuongXa = (Object) tableQlMayATM.getValueAt(row, 3);
				QuanHuyen itemQuan = (QuanHuyen) CBBQuanHuyen.getSelectedItem();
				int idQuan = itemQuan.getMaQuan();
				phuongxa = TinhThanhPhoDAO.getDSPhuongXa(idQuan);
				for (int k = 0; k < phuongxa.size(); k++) {
					if (phuongXa.equals(phuongxa.get(k).getTenPhuong())) {
						CBBPhuongXa.setSelectedIndex(k);
					}
				}

				String viTri = (String) tableQlMayATM.getValueAt(row, 4);
				ViTri.setText(viTri);

				Object tinhTrangMay = (Object) tableQlMayATM.getValueAt(row, 5);
				tinhtrangmayatm = QuanLyMayATMDAO.getDSTinhTrangMayATM();
				for (int i = 0; i < tinhtrangmayatm.size(); i++) {
					if (tinhTrangMay.equals(tinhtrangmayatm.get(i).getMoTa())) {
						CBBTinhTrang.setSelectedIndex(i);
					}
				}

				String tongTien = (String) tableQlMayATM.getValueAt(row, 6);
				TongTien.setText(tongTien);
			}
		}
	};

	ActionListener ThenButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			pnThem.setVisible(false);
			pnHuy.setVisible(true);

			MaMay.setText("");
			ViTri.setText("");
			TongTien.setText("");
		}
	};

	ActionListener SuaButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			suaThongTinMayATM();
		}
	};

	ActionListener XoaButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			xoaThongTinMayATM();
		}
	};

	ActionListener ThucHienButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			themMoiMayATM();
			pnThem.setVisible(true);
			pnHuy.setVisible(false);

			MaMay.setText("");
			ViTri.setText("");
			TongTien.setText("");
		}
	};

	ActionListener HuyButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			pnThem.setVisible(true);
			pnHuy.setVisible(false);

			MaMay.setText("");
			ViTri.setText("");
			TongTien.setText("");
		}
	};

	// sửa thông tin máy ATM
	public void suaThongTinMayATM() {
		String maMay = MaMay.getText();

		String tinhTP = CBBTinhThanhPho.getSelectedItem().toString();
		int idTTP = CBBTinhThanhPho.getSelectedIndex() + 1;
		String idTinhThanhpho = String.valueOf(idTTP);

		String quanHuyen = CBBQuanHuyen.getSelectedItem().toString();
		int idQH = CBBQuanHuyen.getSelectedIndex() + 1;
		String idQuanHuyen = String.valueOf(idQH);

		String phuongXa = CBBPhuongXa.getSelectedItem().toString();
		int idPX = CBBPhuongXa.getSelectedIndex() + 1;
		String idPhuongXa = String.valueOf(idPX);

		String viTri = ViTri.getText();

		String tinhTrangMay = CBBTinhTrang.getSelectedItem().toString();
		int idTT = CBBTinhTrang.getSelectedIndex() + 1;
		String idTinhTrang = String.valueOf(idTT);

		String tongTien = TongTien.getText();

		QuanLyMayATM qlmatm = new QuanLyMayATM(maMay, idTinhThanhpho, idQuanHuyen, idPhuongXa, viTri, idTinhTrang,
				tongTien);
		QuanLyMayATMDAO.update(qlmatm);

		int row = tableQlMayATM.getSelectedRow();
		tableQlMayATM.setValueAt(maMay, row, 0);
		tableQlMayATM.setValueAt(tinhTP, row, 1);
		tableQlMayATM.setValueAt(quanHuyen, row, 2);
		tableQlMayATM.setValueAt(phuongXa, row, 3);
		tableQlMayATM.setValueAt(viTri, row, 4);
		tableQlMayATM.setValueAt(tinhTrangMay, row, 5);
		tableQlMayATM.setValueAt(tongTien, row, 6);
	}

	// xóa thông tin máy ATM
	public void xoaThongTinMayATM() {
		String maMay = MaMay.getText();
		int[] rows = tableQlMayATM.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			QuanLyMayATMDAO.delete(maMay);
			QLMayATMTable.removeRow(rows[i] - i);
		}
	}

	// thêm mới máy ATM
	public void themMoiMayATM() {
		String tinhTP = CBBTinhThanhPho.getSelectedItem().toString();
		int idTTP = CBBTinhThanhPho.getSelectedIndex() + 1;
		String idTinhThanhpho = String.valueOf(idTTP);

		String quanHuyen = CBBQuanHuyen.getSelectedItem().toString();
		int idQH = CBBQuanHuyen.getSelectedIndex() + 1;
		String idQuanHuyen = String.valueOf(idQH);

		String phuongXa = CBBPhuongXa.getSelectedItem().toString();
		int idPX = CBBPhuongXa.getSelectedIndex() + 1;
		String idPhuongXa = String.valueOf(idPX);

		String viTri = ViTri.getText();

		String tinhTrangMay = CBBTinhTrang.getSelectedItem().toString();
		int idTT = CBBTinhTrang.getSelectedIndex() + 1;
		String idTinhTrang = String.valueOf(idTT);

		String tongTien = TongTien.getText();

		QuanLyMayATMDAO.add(new QuanLyMayATM(idTinhThanhpho, idQuanHuyen, idPhuongXa, viTri, idTinhTrang, tongTien));
		QLMayATMTable.setRowCount(0);
		this.getTable();
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

	// khi chọn tỉnh, thành phố sẽ ra các quận, huyện mục tìm kiếm
	ItemListener chonTinhTK = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadDataQuanHuyenTK();
			}
		}
	};

	public void loadDataQuanHuyenTK() {
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
	ItemListener chonQuanTK = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadDataPhuongXaTK();
			}
		}
	};

	public void loadDataPhuongXaTK() {
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
	
	ItemListener chonPhuongTK = new ItemListener() {
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
		QLMayATMTable.setRowCount(0);
		qlatm = QuanLyMayATMDAO.timkiem(idTP, idQH, idPX);
		for (int i = 0; i < qlatm.size(); i++) {
			QLMayATMTable.addRow(new String[] { qlatm.get(i).getMaMay(), qlatm.get(i).getThanhPho(),
					qlatm.get(i).getQuan(), qlatm.get(i).getPhuong(), qlatm.get(i).getViTri(),
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
