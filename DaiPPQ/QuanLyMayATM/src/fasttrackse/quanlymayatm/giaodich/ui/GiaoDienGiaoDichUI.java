/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.giaodich.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlymayatm.giaodich.dao.ThaoTacTKDAO;
import fasttrackse.quanlymayatm.giaodich.entity.ThaoTacTaiKhoang;
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
public class GiaoDienGiaoDichUI extends JFrame {
	JPanel pnBorder = new JPanel(), pnWest = new JPanel(), pnCenter = new JPanel();

	JPanel pnCenterNorth = new JPanel(), pnLogin = new JPanel(), pnChucNang = new JPanel(), pnRutTien = new JPanel(),
			pnNapTien = new JPanel(), pnTraCuu = new JPanel(), pnDoiPIN = new JPanel();

	private CardLayout cardLayout = new CardLayout();

	JLabel JLabelMaMay = new JLabel("Mã Máy: "), JLabelViTri = new JLabel("Vị Trí: "),
			JLabelTinhThanhPho = new JLabel("Tỉnh / Thành Phố: "), JLabelQuanHuyen = new JLabel("Quận / Huyện: "),
			JLabelPhuongXa = new JLabel("Phường / Xã: "), JLabelTinhTrang = new JLabel("Tình Trạng: "),
			JLabelMaThe = new JLabel("Mã Thẻ: "), JLabelPIN = new JLabel("PIN: "), JLabelMaMay1 = new JLabel(),
			JLabelLuaChon = new JLabel("Mời Bạn Chọn Dịch Vụ"),
			JLabelThongBao = new JLabel("Chào Mừng Bạn Đến Với Cây ATM Của Ngân Hàng TPBank"),
			JLabelThongBao1 = new JLabel("Chào Mừng Bạn Đến Với Cây ATM Của Ngân Hàng TPBank"),
			JLabelThongBao2 = new JLabel("Giao Diện Đổi PIN"), JLabelTraCuuTK = new JLabel("Tra Cứu tài khoảng"),
			JLabelNgayGio = new JLabel("Ngày / Giờ: "), JLabelNgayGio1 = new JLabel(),
			JLabelATMID = new JLabel("ATM ID: "), JLabelATMID1 = new JLabel(), JLabelSoThe = new JLabel("Số Thẻ: "),
			JLabelSoThe1 = new JLabel(), JLabelSoTK = new JLabel("Số Tai Khoảng: "), JLabelSoTK1 = new JLabel(),
			JLabelSoTien = new JLabel("Số Tiền: "), JLabelSoTien1 = new JLabel(),
			JLabelPINCu = new JLabel("Nhập số PIN Củ: "), JLabelPINMoi = new JLabel("Nhập Số Pin Mới: "),
			JLabelGD = new JLabel("Mời Chọn Loại Giao Dich"), JLabelGD1 = new JLabel("Mời Chọn Loại Giao Dich");

	JTextField ThongBao = new JTextField(), MaMay = new JTextField(20), ViTri = new JTextField(20),
			TongTien = new JTextField(20), MaThe = new JTextField(20), PIN = new JTextField(6),
			PINCu = new JTextField(6), PINMoi = new JTextField(6);

	JComboBox CBBTKTinhThanhPho = new JComboBox<TinhThanhPho>(), CBBTKQuanHuyen = new JComboBox<QuanHuyen>(),
			CBBTKPhuongXa = new JComboBox<PhuongXa>();

	JButton okButton = new JButton("Login"), exitButton = new JButton("Exit"), rutTien = new JButton("Rút Tiền"),
			napTien = new JButton("Nạp Tiền"), xemSoDu = new JButton("Xem Số Dư"), doiPIN = new JButton("Đổi PIN"),
			thoat = new JButton("Thoát"), xacNhan = new JButton("Xác Nhận"), huyBo = new JButton("Hủy"),
			TroLai = new JButton("Trở Lại"), motTram = new JButton("100.000"), haitram = new JButton("200.000"),
			namTram = new JButton("500.000"), mottrieu = new JButton("1.000.000"), haiTrieu = new JButton("2.000.000"),
			namTrieu = new JButton("5.000.000"), giaoDich = new JButton("Xác nhận"), huyBoGD = new JButton("Hủy"),
			motTram1 = new JButton("100.000"), haitram1 = new JButton("200.000"), namTram1 = new JButton("500.000"),
			mottrieu1 = new JButton("1.000.000"), haiTrieu1 = new JButton("2.000.000"),
			namTrieu1 = new JButton("5.000.000"), giaoDich1 = new JButton("Xác nhận"), huyBoGD1 = new JButton("Hủy");

	DefaultTableModel DSMaytable = new DefaultTableModel();
	JTable tableDSMay;

	protected int row;

	public static QuanLyMayATMDAO quanLyMayATMDAO = new QuanLyMayATMDAO();
	public static ArrayList<QuanLyMayATM> qlatm = new ArrayList<QuanLyMayATM>();
	public static ArrayList<TinhTrangMayATM> tinhtrangmayatm = new ArrayList<TinhTrangMayATM>();

	public static TinhThanhPhoDAO tinhThanhPhoDAO = new TinhThanhPhoDAO();
	public static ArrayList<TinhThanhPho> tinhtp = new ArrayList<TinhThanhPho>();
	public static ArrayList<QuanHuyen> quanhuyen = new ArrayList<QuanHuyen>();
	public static ArrayList<PhuongXa> phuongxa = new ArrayList<PhuongXa>();

	public GiaoDienGiaoDichUI(String tieude) {
		super(tieude);
		addControls();
		addEvents();
	}

	public void addControls() {
		// tạo container và boder chính
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(4);
		layout.setVgap(4);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.gray);
		// Phần bên trái
		pnWest.setPreferredSize(new Dimension(500, 0));
		pnWest.setBorder(BorderFactory.createRaisedBevelBorder());
		pnWest.setLayout(new GridBagLayout());
		// add Label vào pnDSMay
		addItem(pnWest, JLabelTinhThanhPho, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pnWest, JLabelQuanHuyen, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnWest, JLabelPhuongXa, 0, 2, 1, 1, GridBagConstraints.WEST);
		// add DS Tinh, TP vào ComboBox TinhThanhPho
		tinhtp = tinhThanhPhoDAO.getDSTinhThanhPho();
		for (int i = 0; i < tinhtp.size(); i++) {
			CBBTKTinhThanhPho.addItem(tinhtp.get(i));
		}
		CBBTKTinhThanhPho.addItemListener(chonTinh);
		CBBTKTinhThanhPho.setPreferredSize(new Dimension(200, 20));
		//
		addItem(pnWest, CBBTKTinhThanhPho, 1, 0, 1, 1, GridBagConstraints.WEST);
		CBBTKQuanHuyen.setPreferredSize(new Dimension(200, 20));
		addItem(pnWest, CBBTKQuanHuyen, 1, 1, 1, 1, GridBagConstraints.WEST);
		CBBTKQuanHuyen.addItemListener(chonQuan);
		//
		CBBTKPhuongXa.setPreferredSize(new Dimension(200, 20));
		addItem(pnWest, CBBTKPhuongXa, 1, 2, 1, 1, GridBagConstraints.WEST);
		CBBTKPhuongXa.addItemListener(chonPhuong);
		// JTable danh sách máy
		DSMaytable.addColumn("Mã Máy");
		DSMaytable.addColumn("Vị Trí");
		DSMaytable.addColumn("Tình Trạng");
		tableDSMay = new JTable(DSMaytable);
		JScrollPane pnDanhSach = new JScrollPane(tableDSMay);
		pnDanhSach.setPreferredSize(new Dimension(400, 200));
		addItem(pnWest, pnDanhSach, 0, 3, 4, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách máy
		Border borderDSMay = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSMay = BorderFactory.createTitledBorder(borderDSMay, "Danh Sách Máy");
		pnWest.setBorder(borderTitleDSMay);
		//
		// Phần bên phai
		// login
		pnLogin.setLayout(new GridBagLayout());
		// add Label vào pnLogin
		addItem(pnLogin, JLabelThongBao, 1, 0, 3, 1, GridBagConstraints.WEST);
		addItem(pnLogin, JLabelMaThe, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnLogin, JLabelPIN, 0, 2, 1, 1, GridBagConstraints.WEST);
		// add TextField vào pnCenterNorth
		addItem(pnLogin, MaThe, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnLogin, PIN, 1, 2, 1, 1, GridBagConstraints.WEST);
		// add Button vào pnCenterNorth
		addItem(pnLogin, okButton, 4, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnLogin, exitButton, 4, 4, 1, 1, GridBagConstraints.WEST);
		okButton.addActionListener(actionListener);
		exitButton.addActionListener(actionListener);

		// chon chức năng
		pnChucNang.setLayout(new GridBagLayout());
		addItem(pnChucNang, JLabelThongBao1, 1, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pnChucNang, JLabelLuaChon, 2, 1, 2, 1, GridBagConstraints.CENTER);
		// add Button vào pnChucNang
		addItem(pnChucNang, xemSoDu, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnChucNang, doiPIN, 0, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnChucNang, rutTien, 3, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnChucNang, napTien, 3, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnChucNang, thoat, 3, 4, 1, 1, GridBagConstraints.EAST);
		xemSoDu.addActionListener(actionListener);
		doiPIN.addActionListener(actionListener);
		rutTien.addActionListener(actionListener);
		napTien.addActionListener(actionListener);
		thoat.addActionListener(actionListener);

		// đổi PIN
		pnDoiPIN.setLayout(new GridBagLayout());
		// add Label
		addItem(pnDoiPIN, JLabelThongBao2, 1, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pnDoiPIN, JLabelPINCu, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnDoiPIN, JLabelPINMoi, 0, 2, 1, 1, GridBagConstraints.WEST);
		// add TextField
		addItem(pnDoiPIN, PINCu, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnDoiPIN, PINMoi, 1, 2, 1, 1, GridBagConstraints.WEST);
		// add Button
		addItem(pnDoiPIN, xacNhan, 3, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnDoiPIN, huyBo, 3, 4, 1, 1, GridBagConstraints.EAST);
		xacNhan.addActionListener(actionListener);
		huyBo.addActionListener(actionListener);

		// Tra cứu tài khoảng
		pnTraCuu.setLayout(new GridBagLayout());
		// add Label
		addItem(pnTraCuu, JLabelTraCuuTK, 0, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pnTraCuu, JLabelNgayGio, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelATMID, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelSoThe, 0, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelSoTK, 0, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelSoTien, 0, 5, 1, 1, GridBagConstraints.WEST);
		// add TextField
		addItem(pnTraCuu, JLabelNgayGio1, 1, 1, 1, 1, GridBagConstraints.WEST);
		Date thoiGian = new Date();
		// Khai bao dinh dang ngay thang
		SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
		// parse ngay thang sang dinh dang va chuyen thanh string.
		String showTime = dinhDangThoiGian.format(thoiGian.getTime());
		JLabelNgayGio1.setText(showTime);
		addItem(pnTraCuu, JLabelATMID1, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelSoThe1, 1, 3, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelSoTK1, 1, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pnTraCuu, JLabelSoTien1, 1, 5, 1, 1, GridBagConstraints.WEST);
		// add Button
		addItem(pnTraCuu, TroLai, 3, 6, 1, 1, GridBagConstraints.EAST);
		TroLai.addActionListener(actionListener);

		// Rút tiền
		pnRutTien.setLayout(new GridBagLayout());
		// add Label
		addItem(pnRutTien, JLabelGD, 1, 0, 2, 1, GridBagConstraints.EAST);
		// add Button
		addItem(pnRutTien, motTram, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, haitram, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, namTram, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, giaoDich, 0, 4, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, mottrieu, 3, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, haiTrieu, 3, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, namTrieu, 3, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnRutTien, huyBoGD, 3, 4, 1, 1, GridBagConstraints.EAST);
		giaoDich.addActionListener(actionListener);
		huyBoGD.addActionListener(actionListener);

		// Nạp tiền
		pnNapTien.setLayout(new GridBagLayout());
		// add Label
		addItem(pnNapTien, JLabelGD1, 1, 0, 2, 1, GridBagConstraints.EAST);
		// add Button
		addItem(pnNapTien, motTram1, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, haitram1, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, namTram1, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, giaoDich1, 0, 4, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, mottrieu1, 3, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, haiTrieu1, 3, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, namTrieu1, 3, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnNapTien, huyBoGD1, 3, 4, 1, 1, GridBagConstraints.EAST);
		giaoDich1.addActionListener(actionListener);
		huyBoGD1.addActionListener(actionListener);

		//
		pnLogin.setVisible(false);
		pnChucNang.setVisible(false);
		pnDoiPIN.setVisible(false);
		pnTraCuu.setVisible(false);
		pnRutTien.setVisible(false);
		pnNapTien.setVisible(false);
		//
		pnCenter.add(pnLogin);
		pnCenter.add(pnChucNang);
		pnCenter.add(pnDoiPIN);
		pnCenter.add(pnTraCuu);
		pnCenter.add(pnRutTien);
		pnCenter.add(pnNapTien);
		//
		pnBorder.add(pnWest, BorderLayout.WEST);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		//
		getContentPane().add(pnBorder);

	}

	public void addEvents() {
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
			pnLogin.setVisible(true);
			pnChucNang.setVisible(false);
			pnDoiPIN.setVisible(false);
			pnTraCuu.setVisible(false);
			pnRutTien.setVisible(false);
			pnNapTien.setVisible(false);
		}
	};

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

	public void CloseFrame() {
		super.dispose();
	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okButton) {
				if (MaThe.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã Thẻ");
				} else if (PIN.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập PIN");
				} else {
					String mathe = MaThe.getText();
					String pin = PIN.getText();
					try {
						String Url = "jdbc:mysql://localhost/ql_atm";
						Connection conn = DriverManager.getConnection(Url, "mido", "0933237480");
						String queryString = "SELECT * FROM ql_atm_theatm WHERE MaThe = ? AND PIN = ?";
						java.sql.PreparedStatement Statement = conn.prepareStatement(queryString);
						Statement.setString(1, mathe);
						Statement.setString(2, pin);
						ResultSet result = Statement.executeQuery();
						if (result.next()) {
							pnLogin.setVisible(false);
							pnChucNang.setVisible(true);
							pnDoiPIN.setVisible(false);
							pnTraCuu.setVisible(false);
							pnRutTien.setVisible(false);
							pnNapTien.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
							MaThe.setText("");
							PIN.setText("");
						}
					} catch (SQLException e1) {
					}
				}
			}
			if (e.getSource() == exitButton) {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình ?", "Thoát",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			if (e.getSource() == thoat) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
				MaThe.setText("");
				PIN.setText("");
			}
			if (e.getSource() == doiPIN) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(true);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == xacNhan) {
				suaSoPIN();
				pnLogin.setVisible(false);
				pnChucNang.setVisible(true);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == huyBo) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(true);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == xemSoDu) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(true);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == TroLai) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(true);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == rutTien) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(true);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == giaoDich) {
				//
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);

				MaThe.setText("");
				PIN.setText("");
			}
			if (e.getSource() == huyBoGD) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(true);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
			if (e.getSource() == napTien) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(true);
			}
			if (e.getSource() == giaoDich1) {
				//
				pnLogin.setVisible(false);
				pnChucNang.setVisible(false);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);

				MaThe.setText("");
				PIN.setText("");
			}
			if (e.getSource() == huyBoGD1) {
				pnLogin.setVisible(false);
				pnChucNang.setVisible(true);
				pnDoiPIN.setVisible(false);
				pnTraCuu.setVisible(false);
				pnRutTien.setVisible(false);
				pnNapTien.setVisible(false);
			}
		}
	};
	
	public void suaSoPIN() {
		String maThe = MaThe.getText();
		String pin = PINMoi.getText();
		ThaoTacTaiKhoang id = new ThaoTacTaiKhoang(maThe, pin);
		ThaoTacTKDAO.update(id);
		
	}

	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c, gc);
	}

	public void showWindow() {
		this.setSize(1200, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}