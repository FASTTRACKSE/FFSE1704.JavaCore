package ffse.lp4.quanlytiendien.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame {
	private JButton btc1;
	private JButton btc2;
	private JButton btc3;
	private JLabel lblUese ;
	private JTextField txtUese;
	private JLabel lblPass ;
	private JPasswordField txtPass;
	
	public Login(String tieude) {
		super();
		addControls();
		this.conect();
		
	}
	public void conect() {
//		loginDAO.getConnect("localhost", "ffse1703009", "phuonghanh", "phuonghanh123");
		
	}
		public void addControls() {
			
			Container con = getContentPane();
			JPanel pnMain = new JPanel();
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
			// tạo tittle 
			JPanel pntt = new JPanel();
			JLabel lbltt = new JLabel("LOGIN YOUR ACCOUNT");
			lbltt.setFont(new Font("Courier New", Font.BOLD, 20));
			lbltt.setForeground(Color.BLUE);
			lbltt.setSize(120,40);
			pntt.add(lbltt);			
			
			JPanel pnUses = new JPanel();
			lblUese = new JLabel("Uses");
			txtUese = new JTextField(20);
//			txtUese.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			pnUses.add(lblUese);
			pnUses.add(txtUese);
			
			JPanel pnPass = new JPanel();
			lblPass = new JLabel("Pass");
			txtPass = new JPasswordField(20);
//			txtPass.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			pnPass.add(lblPass);
			pnPass.add(txtPass);
			
			JPanel pnBt = new JPanel();
			btc1 = new JButton("  LOGIN  ");
			btc1.setMargin(new Insets (5,5,5,5));
			btc1.setBounds(2,2,2,2);
			btc1.setForeground(Color.BLUE);
			btc1.setBackground(Color.GRAY);
			btc1.addActionListener(actionListener);
			pnBt.add(btc1);
			
			btc3 = new JButton("Đăng kí");
			btc3.setMargin(new Insets (5,5,5,5)); 
			btc3.setForeground(Color.PINK);
			btc3.setBackground(Color.GRAY);
			btc3.addActionListener(actionListener);
			pnBt.add(btc3);
		
			btc2 = new JButton("   EXIT   ");
			btc2.setMargin(new Insets (5,5,5,5)); 
			btc2.setForeground(Color.PINK);
			btc2.setBackground(Color.GRAY);
			btc2.addActionListener(actionListener);
			pnBt.add(btc2);
			
			
			pnMain.add(pntt);
			pnMain.add(pnUses);
			pnMain.add(pnPass);
			pnMain.add(pnBt);
			con.add(pnMain);
			
		}
	
	
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == btc1) {
//					ChuongTrinhUI QLCT = new ChuongTrinhUI("Quản lí sinh viên");
//					QLCT.showWindow();
//					setVisible(false);
//				}
//				if (e.getSource() == btc2) {
//					System.exit(0);
//				}
//				if (e.getSource() == btc3) {
//					dangKi();
//				}
				
				
			}
		};
		public void Login() {
//			
		
		}
		public void showWindow() {
			this.setSize(400,300);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		public void dangKi() {
//			String taiKhoan = txtUese.getText();
//			String matKhau = txtPass.getText();
//			DangNhap dn1 = new DangNhap(taiKhoan, matKhau);
//			
//			loginDAO.addAdmin(dn1);
		}



}
