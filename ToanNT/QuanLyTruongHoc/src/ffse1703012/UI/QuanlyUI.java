package ffse1703012.UI;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ffse1703012.connect.SinhVienDAO;
import ffse1703012.entity.QuanLyLop;

public class QuanlyUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static SinhVienDAO KetNoi = new SinhVienDAO();

	JTabbedPane myTab;
	QuanLiSinhVien tabQuanLiSinhVien;
	QuanLiMonHoc tabQuanLiMonHoc;
	QuanLiLopHoc tabQuanLiLopHoc;
	QuanLiDiem tabQuanLiDiem;
	ThongKeLopHoc tabThongKeLopHoc;
	ThongKeSinhVien tabThongKeSinhVien;

	/**
	 * Launch the application.
	 */

	public QuanlyUI() {
		super("Quản lý Sinh viên");
		
		
		addControl();
		// addEvent();
		setSize(1600, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
//	public void connect() {
//		KetNoi.getConnect("localhost", "ffse1703012", "toan", "123");
//		if (KetNoi.getConn() != null) {
//			System.out.println("Kết nối MYSQL thành công");
//		} else {
//			System.out.println("Kết nối MYSQL thất bại");
//		}
//	}

	public void addControl() {
		Container con = getContentPane();

		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.X_AXIS));

		myTab = new JTabbedPane();
		tabQuanLiSinhVien = new QuanLiSinhVien();
		tabQuanLiMonHoc = new QuanLiMonHoc();
		tabQuanLiLopHoc = new QuanLiLopHoc();
		tabQuanLiDiem = new QuanLiDiem();
		tabThongKeLopHoc = new ThongKeLopHoc();
		tabThongKeSinhVien = new ThongKeSinhVien();

		myTab.add("Quản lí sinh viên", tabQuanLiSinhVien);
		myTab.add("Quản lí môn học", tabQuanLiMonHoc);
		myTab.add("Quản lí lớp học", tabQuanLiLopHoc);
		myTab.add("Quản lí điểm", tabQuanLiDiem);
		myTab.add("Thống kê lớp học", tabThongKeLopHoc);
		myTab.add("Thống kê sinh viên", tabThongKeSinhVien);
		boxMain.add(myTab);

		con.add(boxMain);

	}

	public void addEvents() {
		myTab.addChangeListener(new SelectedTab());
	}

	public void showWindown() {
		this.setSize(1300, 900);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// set size tab
		double wid = (myTab.getSize().width) / (myTab.getTabCount() + 2.74);
		for (int i = 0; i < myTab.getTabCount(); i++) {
			String name = myTab.getTitleAt(i);
			myTab.setTitleAt(i, "<html><div style='width: " + wid
					+ "px; height: 20px; font-size: 10px; text-align: center'><p style='vertical-align: middle; margin-top: 4px'>"
					+ name + "</p></div></html>");
		}
	}

	private class SelectedTab implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int choose = myTab.getSelectedIndex();
			switch (choose) {
			case 0:

				tabQuanLiSinhVien.addItemMaLop();
				break;
			case 2:

				tabQuanLiLopHoc.addItemMonHoc();
				break;
			case 3:

				tabQuanLiDiem.addItemMaLop();
				break;
			case 4:

				tabThongKeLopHoc.addItemNamHoc();
				break;
			case 5:

				tabThongKeSinhVien.addItemNamHoc();
				break;
			}
		}

	}
}
