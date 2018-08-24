package ffse1703012.UI;

import ffse1703012.entity.*;
import ffse1703012.connect.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ThongKeLopHoc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public JComboBox cboNamHoc;
	private DefaultTableModel dm;
	private JTable tbLop;
	private JButton btnThoat;
	private QuanLyLop_Statement quanLiLopHocStatement = new QuanLyLop_Statement();
	private ThongKeLopHoc_Statement thongKeLopHocStatement = new ThongKeLopHoc_Statement();
	private ArrayList<QuanLyLop> arrLopHoc = new ArrayList<>();
	private ArrayList<String> arrNamHoc = new ArrayList<>();
	private ArrayList<QuanLyLop> arrDanhSach = new ArrayList<>();

	public ThongKeLopHoc() {
		addControls();
		addEvents();
	}

	@SuppressWarnings("unchecked")
	private void addControls() {
		JPanel boxThongKeLopHoc = new JPanel();
		boxThongKeLopHoc.setLayout(new BoxLayout(boxThongKeLopHoc, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD, 15);
		Border borderThongKe = BorderFactory.createEtchedBorder();
		TitledBorder borderTitleThongKe = BorderFactory.createTitledBorder(borderThongKe, "Báo cáo lớp học",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		borderTitleThongKe.setTitleFont(borderTitleThongKe.getTitleFont().deriveFont(Font.BOLD, 20));
		borderTitleThongKe.setTitleColor(Color.BLACK);
		boxThongKeLopHoc.setBorder(borderTitleThongKe);
		JPanel phanTimKiem = new JPanel();
		phanTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phanTimKiem.setPreferredSize(new Dimension(0, 1));
		JLabel namHoc = new JLabel("Năm Học:");
		namHoc.setFont(font);
		namHoc.setPreferredSize(new Dimension(90, 70));

		cboNamHoc = new JComboBox<>();
		cboNamHoc.addItem("Chọn năm học");

		cboNamHoc.setPreferredSize(new Dimension(120, 30));
		JPanel phanHienThi = new JPanel();
		phanHienThi.setLayout(new BoxLayout(phanHienThi, BoxLayout.Y_AXIS));
		phanHienThi.setPreferredSize(new Dimension(0, 500));
		dm = new DefaultTableModel();
		dm.addColumn("Mã lớp");
		dm.addColumn("Tên lớp");
		dm.addColumn("Năm học");
		dm.addColumn("Số lượng sinh viên");
		tbLop = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbLop);
		JPanel phanNut = new JPanel();
		phanNut.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon imgBtnThoat = new ImageIcon(getClass().getResource("/images/btn_thoat.png"));
		btnThoat = new JButton("Thoát", imgBtnThoat);
		btnThoat.setPreferredSize(new Dimension(110, 30));

		phanTimKiem.add(namHoc);
		phanTimKiem.add(cboNamHoc);
		phanTimKiem.add(Box.createRigidArea(new Dimension(100, 0)));

		phanHienThi.add(sc);

		phanNut.add(btnThoat);
		phanNut.add(Box.createRigidArea(new Dimension(100, 0)));

		boxThongKeLopHoc.add(phanTimKiem);
		boxThongKeLopHoc.add(phanHienThi);
		boxThongKeLopHoc.add(Box.createRigidArea(new Dimension(0, 50)));
		boxThongKeLopHoc.add(phanNut);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(boxThongKeLopHoc);
	}

	private void addEvents() {
		cboNamHoc.addActionListener(cboNamHocEvents);
		btnThoat.addActionListener(btnThoatEvents);
	}

	ActionListener cboNamHocEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			sellectAllLop();

			Object nH = cboNamHoc.getSelectedItem();
			if (nH != null && !nH.toString().equals("Chọn năm học")) {
				String namHoc = cboNamHoc.getSelectedItem().toString();
				dm.setRowCount(0);

				for (QuanLyLop x : arrLopHoc) {
					if (namHoc.equals(x.getNamHoc())) {
						String soLuongSv = String.valueOf(quanLiLopHocStatement.demSoSinhVien(x.getMaLop()));
						String row[] = { x.getMaLop(), x.getTenLop(), x.getNamHoc(), soLuongSv };
						dm.addRow(row);
					}
				}
			}
			// String soLuongSinhVien =
			// String.valueOf(quanLiLopHocStatement.demSoSinhVien(maLop));

		}
	};

	ActionListener btnThoatEvents = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
			if (chose == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		}
	};

	private void sellectAllLop() {
		arrLopHoc = quanLiLopHocStatement.sellectAllLop();
	}

	@SuppressWarnings("unchecked")
	public void addItemNamHoc() {
		cboNamHoc.removeAllItems();
		cboNamHoc.addItem("Chọn năm học");
		arrNamHoc = thongKeLopHocStatement.sellectNamHoc();
		for (String x : arrNamHoc) {
			cboNamHoc.addItem(x);
		}
	}
}
