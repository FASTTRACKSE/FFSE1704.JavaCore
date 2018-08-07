package ffse1703012.UI;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ffse1703012.connect.Login_Statement;

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtUserName ;
	JPasswordField txtPassword;
	JButton btnLogin = new JButton("Đăng nhập");
	JButton btnCancel = new JButton("Hủy");
	public Login(String title) {
		super();
//		connect();
		addControl();
	}
	
//	public void connect() {
//		KetNoi.getConnect("localhost", "ffse1703012", "toan", "123");
//		if (KetNoi.getConn() != null) {
//			System.out.println("Kết nối MYSQL thành công");
//		} else {
//			System.out.println("Kết nối MYSQL thất bại");
//		}
//	}
//	
	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Đăng nhập");
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		// lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		
		JPanel pnUser = new JPanel();
		JLabel lblUser = new JLabel("User Name");
		txtUserName = new JTextField(20);
		pnUser.add(lblUser);
		pnUser.add(txtUserName);
		
		
		JPanel pnPass = new JPanel();
		JLabel lblPass = new JLabel("Password");
		txtPassword = new JPasswordField(20);
		pnPass.add(lblPass);
		pnPass.add(txtPassword);
		
		JPanel pnButton = new JPanel();
		pnButton.add(btnLogin);
		btnLogin.addActionListener(actionListener);
		btnLogin.setActionCommand("Open");
		pnButton.add(btnCancel);
		btnCancel.addActionListener(actionListener);
		
		
		pnMain.add(pnTitle);
		pnMain.add(pnUser);
		pnMain.add(pnPass);
		pnMain.add(pnButton);
		con.add(pnMain);
	} 
	
//	public void addEvents() {
//		btnDangNhap.addActionListener(btnDangNhapEvents);
//	}
//	
	ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			if(e.getSource()==btnLogin) {
				if(txtUserName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập Tài khoản");
				}else if(txtPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
				}else {
				
				String username = txtUserName.getText();
				char[] password = txtPassword.getPassword();
				String pwd = String.valueOf(password);
				if(Login_Statement.login(username, pwd)) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					dispose();
					new QuanlyUI();
				}else {
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
				}
				}
				
				
			}else if(e.getSource()== btnCancel) {
				thoatChuongTrinh();
			}
		}
		
	};
			
	public boolean dangNhap() {
		if(txtUserName.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Tài khoản");
		}else if(txtPassword.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
		}else {
		
		String username = txtUserName.getText();
		char[] password = txtPassword.getPassword();
		String pwd = String.valueOf(password);
		if(Login_Statement.login(username, pwd)) {
			JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
			
		}else {
			JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
		}
		}
		return true;
		
		
	}
	
	public void thoatChuongTrinh() {
		System.exit(0);
	}
	public void showWindown() {
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
