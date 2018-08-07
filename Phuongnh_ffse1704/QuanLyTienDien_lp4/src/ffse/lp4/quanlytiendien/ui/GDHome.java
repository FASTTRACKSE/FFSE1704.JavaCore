package ffse.lp4.quanlytiendien.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GDHome extends JFrame {
	JButton bienLai;
	JButton dsKhachHang;
	JButton gDChung;
	JButton Exit;

	public GDHome(String tieude) {
		super();
		this.addControls();
		this.conect();

	}

	public void conect() {
		// loginDAO.getConnect("localhost", "ffse1703009", "phuonghanh",
		// "phuonghanh123");

	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		//
		//
		// ****** tạo panel chứa tittle********//
		JPanel pntt = new JPanel();
		ImageIcon iconlogo = new ImageIcon(
				new ImageIcon("icon/logo.gif").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		JLabel logo = new JLabel(iconlogo);
		pntt.add(logo);
		pntt.setPreferredSize(new Dimension(1500, 100));
		
		JLabel lbltt = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ TIÊU THỤ ĐIỆN");
		pntt.add(lbltt);
		Font font = new Font("Courier New", Font.BOLD, 30);
		lbltt.setFont(font);
		

		JPanel pnbt = new JPanel();
		bienLai = new JButton("");
		JLabel lblBienLai =new JLabel("            Thống kê biên lai");
		bienLai.setPreferredSize(new Dimension(185, 50));
		ImageIcon iconThongKe = new ImageIcon(
				new ImageIcon("icon/thongke.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		JLabel thongke = new JLabel(iconThongKe);
		bienLai.add(thongke);
		bienLai.add(lblBienLai);
		bienLai.setMargin(new Insets(0, 18, 0, 0));
		bienLai.addActionListener(actionListener);

		dsKhachHang = new JButton("");
		JLabel lblDSKhachHang =new JLabel("          Danh sách khách hàng");
		dsKhachHang.setPreferredSize(new Dimension(185, 50));
		ImageIcon iconDanhSach = new ImageIcon(
				new ImageIcon("icon/danhsach.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		JLabel danhSach = new JLabel(iconDanhSach);
		dsKhachHang.add(danhSach);
		dsKhachHang.add(lblDSKhachHang);
		dsKhachHang.setMargin(new Insets(0, 18, 0, 0));
		dsKhachHang.addActionListener(actionListener);

		gDChung = new JButton("");
		JLabel lblCSKhachHang =new JLabel("         Chỉnh sửa danh sách");
		gDChung.setPreferredSize(new Dimension(185, 50));
		ImageIcon iconCSDS = new ImageIcon(
				new ImageIcon("icon/csdanhsach.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		JLabel chinhsua = new JLabel(iconCSDS);
		gDChung.add(chinhsua);
		gDChung.add(lblCSKhachHang);
		gDChung.setMargin(new Insets(0, 18, 0, 0));
		gDChung.addActionListener(actionListener);

		Exit = new JButton("Exit");
		Exit.setPreferredSize(new Dimension(110, 50));
		ImageIcon iconExit = new ImageIcon(
				new ImageIcon("icon/exit.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		JLabel exit = new JLabel(iconExit);
		Exit.add(exit);
		Exit.setMargin(new Insets(0, 18, 0, 0));
		Exit.addActionListener(actionListener);

		pnbt.add(bienLai);
		pnbt.add(dsKhachHang);
		pnbt.add(gDChung);
		pnbt.add(Exit);
		
//		 ImageIcon background=new ImageIcon("icon/bg1.jpg");
//		    Image img=background.getImage();
//		    Image temp=img.getScaledInstance(1000,600,Image.SCALE_SMOOTH);
//		    background=new ImageIcon(temp);
//		   
//		    JLabel back=new JLabel(background);
//		    back.add(pntt);
//		    back.add(pnbt);
//		    back.setLayout(null);
//		    back.setBounds(0,0,1000,600);
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("icon/bg1.jpg"));
		
		add(background);
		background.setLayout(new FlowLayout());
		
		background.add(pntt);
		background.add(pnbt);
		   
		    pnMain.add(background);
		    pnMain.setPreferredSize(new Dimension(1500,600));
		getContentPane().add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bienLai) {
				GDBienLai BL = new GDBienLai("");
				BL.showWindow();
				setVisible(false);
			}
			if (e.getSource() == dsKhachHang) {
				GDDSKhachHang dsKH = new GDDSKhachHang("");
				dsKH.showWindow();
				setVisible(false);
			}
			if (e.getSource() == gDChung) {
				GDChinh chinh = new GDChinh("");
				chinh.showWindow();
				setVisible(false);
			}
			if (e.getSource() == Exit) {
				System.exit(0);
			}

		}
	};

	// public void itemStateChanged(ItemEvent event) {
	// if (event.getStateChange() == ItemEvent.SELECTED) {
	// Object item = event.getItem();
	// // do something with object
	// }
	// }

	public void showWindow() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
