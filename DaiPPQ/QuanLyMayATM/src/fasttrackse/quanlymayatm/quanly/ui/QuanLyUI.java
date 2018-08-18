/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.quanly.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fasttrackse.quanlymayatm.giaodich.ui.BaoCaoTinhTrangMayUI;
import fasttrackse.quanlymayatm.giaodich.ui.BaoCaoTinhTrangRutTienKhachHangUI;

/**
 * @author QuangDai
 *
 */
public class QuanLyUI extends JFrame {

	JButton QLButton = new JButton("Quản lý"), TKButton = new JButton("Thống kê / Báo cáo"),
			LogoutButton = new JButton("Đăng xuất"), QLKhachHangButton = new JButton("Quản Lý Khách hàng"),
			QLTheATMButton = new JButton("Quản Lý Thẻ ATM"), QLMayATMButton = new JButton("Quản Lý Máy ATM"),
			QLGiaoDichButton = new JButton("Quản Lý Giao Dịch"), BaoCaoKHButton = new JButton("Báo Cáo Khách Hàng"),
			TinhTrangRutTienKHButton = new JButton("Tình Trạng Rút Tiền Của Khách Hàng"),
			TinhTrangMayButton = new JButton("TÌnh Trạng máy"),
			TinhTrangRutTienButton = new JButton("Tình Trạng Rút Tiền");

	JPanel pnBorder = new JPanel();
	JPanel pnNorth = new JPanel(), pnNorthMenuWest = new JPanel(), pnNorthMenuEast = new JPanel();
	JPanel pnWest = new JPanel(), pnWestQL = new JPanel(), pnWestTK = new JPanel();
	JPanel pnCenter = new JPanel(), pnCenterNorth = new JPanel(), pnCenterCenter = new JPanel();

	private CardLayout cardLayout = new CardLayout();

	// các class UI
	QuanLyKhachHangUI quanLyKhachHangUI = new QuanLyKhachHangUI();
	QuanLyTheATMUI quanLyTheATMUI = new QuanLyTheATMUI();
	QuanLyMayATMUI quanLyMayATMUI = new QuanLyMayATMUI();
	QuanLyGiaoDichUI quanLyGiaoDichUI = new QuanLyGiaoDichUI();

	BaoCaoKhachHangUI baoCaoKhachHangUI = new BaoCaoKhachHangUI();
	BaoCaoTinhTrangRutTienKhachHangUI baoCaoTinhTrangRutTienKhachHangUI = new BaoCaoTinhTrangRutTienKhachHangUI();
	BaoCaoTinhTrangMayUI baoCaoTinhTrangMayUI = new BaoCaoTinhTrangMayUI();
	// BaoCaoTinhTrangRutTienTheoMayUI baoCaoTinhTrangRutTienTheoMayUI = new
	// BaoCaoTinhTrangRutTienTheoMayUI();

	public QuanLyUI(String tieude) {
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
		// Phần menu bên trên
		pnNorth.setPreferredSize(new Dimension(0, 40));
		pnNorth.setLayout(new BorderLayout());
		// Add Button "Quản Lý", "Thống Kê / Báo Cáo" vào bên trái
		pnNorthMenuWest.setPreferredSize(new Dimension(300, 0));
		pnNorthMenuWest.add(QLButton);
		pnNorthMenuWest.add(TKButton);
		pnNorth.add(pnNorthMenuWest, BorderLayout.WEST);
		// Add Button "Đăng xuất" vào bên phải
		pnNorthMenuEast.setPreferredSize(new Dimension(300, 0));
		pnNorthMenuEast.add(LogoutButton);
		pnNorth.add(pnNorthMenuEast, BorderLayout.EAST);
		// Add Pane trái phải vào Pane menu
		getContentPane().add(pnNorth);
		pnNorth.setBorder(BorderFactory.createRaisedBevelBorder());

		// Phần menu bên trái
		pnWest.setPreferredSize(new Dimension(200, 0));
		pnWest.setLayout(cardLayout);

		QLKhachHangButton.setPreferredSize(new Dimension(180, 30));
		QLTheATMButton.setPreferredSize(new Dimension(180, 30));
		QLMayATMButton.setPreferredSize(new Dimension(180, 30));
		QLGiaoDichButton.setPreferredSize(new Dimension(180, 30));
		pnWestQL.add(QLKhachHangButton);
		pnWestQL.add(QLTheATMButton);
		pnWestQL.add(QLMayATMButton);
		pnWestQL.add(QLGiaoDichButton);
		//

		BaoCaoKHButton.setPreferredSize(new Dimension(180, 30));
		TinhTrangRutTienKHButton.setPreferredSize(new Dimension(180, 30));
		TinhTrangMayButton.setPreferredSize(new Dimension(180, 30));
		TinhTrangRutTienButton.setPreferredSize(new Dimension(180, 30));
		pnWestTK.add(BaoCaoKHButton);
		pnWestTK.add(TinhTrangRutTienKHButton);
		pnWestTK.add(TinhTrangMayButton);
		pnWestTK.add(TinhTrangRutTienButton);

		pnWest.add(pnWestQL, "quanly");
		pnWest.add(pnWestTK, "thongke");
		pnWest.setBorder(BorderFactory.createRaisedBevelBorder());

		// Phần nội dung
		// Add class UI vào JPanel
		pnCenter.add(quanLyKhachHangUI);
		pnCenter.add(quanLyTheATMUI);
		pnCenter.add(quanLyMayATMUI);
		pnCenter.add(quanLyGiaoDichUI);

		pnCenter.add(baoCaoKhachHangUI);
		pnCenter.add(baoCaoTinhTrangRutTienKhachHangUI);
		pnCenter.add(baoCaoTinhTrangMayUI);
		// pnCenter.add(baoCaoTinhTrangRutTienTheoMayUI);
		//
		quanLyTheATMUI.setVisible(false);
		quanLyMayATMUI.setVisible(false);
		quanLyGiaoDichUI.setVisible(false);

		baoCaoKhachHangUI.setVisible(false);
		baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
		baoCaoTinhTrangMayUI.setVisible(false);
		// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		//
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		pnBorder.add(pnWest, BorderLayout.WEST);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		//
		getContentPane().add(pnBorder);

	}

	public void addEvents() {
		QLButton.addActionListener(QLButtonClick);
		TKButton.addActionListener(TKButtonClick);
		LogoutButton.addActionListener(LogoutButtonClick);

		QLKhachHangButton.addActionListener(QLKhachHangButtonClick);
		QLTheATMButton.addActionListener(QLTheATMButtonClick);
		QLMayATMButton.addActionListener(QLMayATMButtonClick);
		QLGiaoDichButton.addActionListener(QLGiaoDichButtonClick);

		BaoCaoKHButton.addActionListener(BaoCaoKHButtonClick);
		TinhTrangRutTienKHButton.addActionListener(TinhTrangRutTienKHButtonClick);
		TinhTrangMayButton.addActionListener(TinhTrangMayButtonClick);
		TinhTrangRutTienButton.addActionListener(TinhTrangRutTienButtonClick);
	}

	public void CloseFrame() {
		super.dispose();
	}

	ActionListener QLButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout.show(pnWest, "quanly");
			quanLyKhachHangUI.setVisible(true);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener TKButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout.show(pnWest, "thongke");
			quanLyKhachHangUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(true);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener LogoutButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * LoginUI myLoginUI = new LoginUI("Quan Ly Máy ATM"); myLoginUI.showWindow();
			 * CloseFrame();
			 */
			int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất ?", "Thoát", JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				LoginUI myLoginUI = new LoginUI("Quan Ly Máy ATM");
				myLoginUI.showWindow();
				CloseFrame();
			}
		}
	};

	ActionListener QLKhachHangButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(true);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};
	
	ActionListener QLTheATMButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(true);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener QLMayATMButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(true);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener QLGiaoDichButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(true);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener BaoCaoKHButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(true);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener TinhTrangRutTienKHButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(true);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener TinhTrangMayButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(true);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(false);
		}
	};

	ActionListener TinhTrangRutTienButtonClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			quanLyKhachHangUI.setVisible(false);
			quanLyTheATMUI.setVisible(false);
			quanLyMayATMUI.setVisible(false);
			quanLyGiaoDichUI.setVisible(false);

			baoCaoKhachHangUI.setVisible(false);
			baoCaoTinhTrangRutTienKhachHangUI.setVisible(false);
			baoCaoTinhTrangMayUI.setVisible(false);
			// baoCaoTinhTrangRutTienTheoMayUI.setVisible(true);
		}
	};

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
		this.setSize(1200, 850);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}