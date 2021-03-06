package ffse1703012.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.ConnectException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class QuanLi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane myTab;
	QuanLiSinhVien tabQuanLiSinhVien;
	QuanLiMonHoc tabQuanLiMonHoc;
	QuanLiLopHoc tabQuanLiLopHoc;
	QuanLiDiem tabQuanLiDiem;
	ThongKeLopHoc tabThongKeLopHoc;
	ThongKeSinhVien tabThongKeSinhVien;

	public QuanLi() {
		super();
	}

	public QuanLi(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		Container con = getContentPane();

		JPanel boxMain = new JPanel();
		boxMain.setLayout(new BoxLayout(boxMain, BoxLayout.X_AXIS));
		JLabel lblMain = new JLabel("Chương trình quản lý sinh viên Fasttrack SE");

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
		con.add(lblMain);
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
				// tabQuanLiSinhVien = new QuanLiSinhVien();
				// myTab.setComponentAt(0, tabQuanLiSinhVien);
				// break;
				tabQuanLiSinhVien.addItemMaLop();
				break;
			case 2:
				// tabQuanLiLopHoc = new QuanLiLopHoc();
				// myTab.setComponentAt(2, tabQuanLiLopHoc);
				tabQuanLiLopHoc.addItemMonHoc();
				break;
			case 3:
				// tabQuanLiDiem = new QuanLiDiem();
				// myTab.setComponentAt(3, tabQuanLiDiem);
				tabQuanLiDiem.addItemMaLop();
				break;
			case 4:
				// tabThongKeLopHoc = new ThongKeLopHoc();
				// myTab.setComponentAt(4, tabThongKeLopHoc);
				tabThongKeLopHoc.addItemNamHoc();
				break;
			case 5:
				// tabThongKeSinhVien = new ThongKeSinhVien();
				// myTab.setComponentAt(5, tabThongKeSinhVien);
				tabThongKeSinhVien.addItemNamHoc();
				break;
			}
		}

	}
}
