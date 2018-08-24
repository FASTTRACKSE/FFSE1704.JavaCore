package ffse1703012.ui;


	
	import java.awt.Container;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;

	import ffse1703012.connect.SinhVienDAO;
	import ffse1703012.entity.SinhVien;

	public class SuaLopUI extends JFrame{
		JTextField txtNam;
		JTextField txtMa;
		JTextField txtTuoi;
		JButton btnThem = new JButton("Sửa");
		JButton btnHuy = new JButton("Hủy");
		JComboBox<String> cbo;
		/**
		 * 
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static ArrayList<SinhVien> dsSv = new ArrayList<SinhVien>();
		static SinhVienDAO KetNoi = new SinhVienDAO();
		public SuaLopUI() {
			super("Quản lý Sinh viên");
			connect();
			addControl();
			addEvent();
			setSize(800, 600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			setLocationRelativeTo(null);
			setVisible(true);
		}
		
		public void connect() {
			KetNoi.getConnect("localhost", "ffse1703012", "toan", "123");
			if (KetNoi.getConn() != null) {
				System.out.println("Kết nối MYSQL thành công");
			} else {
				System.out.println("Kết nối MYSQL thất bại");
			}
		}
		
		public void addControl() {
			Container con = getContentPane();
			JPanel pnMain = new JPanel();
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

			// Title
			JPanel pnTitle = new JPanel();
			JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
			Font fontTitle = new Font("Arial", Font.BOLD, 30);
			// lblTitle.setForeground(Color.BLUE);
			lblTitle.setFont(fontTitle);
			pnTitle.add(lblTitle);
			
			JPanel pnMa = new JPanel();
			JLabel lblMa = new JLabel("Tên lớp học:");
			lblMa.setBounds(80, 70, 200, 30);
			txtMa = new JTextField(20);
			pnMa.add(lblMa);
			pnMa.add(txtMa);
			pnTitle.add(lblTitle);
			
			
			JPanel pnCbo = new JPanel();
			JLabel lblCbo = new JLabel("Mã khóa học");
			cbo = new JComboBox<String>();
			cbo.addItem("FFSE1701");
			cbo.addItem("FFSE1702");
			cbo.addItem("FFSE1703");
			cbo.addItem("FFSE1704");
			pnCbo.add(lblCbo);
			pnCbo.add(cbo);
			JPanel pnButton = new JPanel();
			pnButton.add(btnThem);
			btnThem.addActionListener(actionListener);
			pnButton.add(btnHuy);
			btnHuy.addActionListener(actionListener);
			
			JPanel pnNam = new JPanel();
			JLabel lblNam = new JLabel("Năm học:");
			lblMa.setBounds(80, 70, 200, 30);
			txtNam = new JTextField(20);
			pnNam.add(lblNam);
			pnNam.add(txtNam);
			pnTitle.add(lblTitle);
			
			pnMain.add(pnTitle);
			pnMain.add(pnCbo);
			pnMain.add(pnMa);
			pnMain.add(pnNam);
			pnMain.add(pnButton);
			con.add(pnMain);
		}
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnThem) {
					nhapThongTin();
				} else if (e.getSource() == btnHuy) {
					thoatChuongTrinh();
				} 
			}

		};
		
		public void nhapThongTin() {
			
		}
		
		public void thoatChuongTrinh() {
			dispose();
		}
		public void addEvent() {
			
		}
	}


