package ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginUI extends JFrame {

	public LoginUI(String title) {
		super(title);
		aadControls();
	}

	public void aadControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("form đăng nhập");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("User : ");
		JTextField txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);
		
		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo2 = new JPanel();
		JLabel lblUser2 = new JLabel("pass : ");
		JTextField txtUser2 = new JTextField(20);
		pnUserInfo2.add(lblUser2);
		pnUserInfo2.add(txtUser2);
		pnTitle.add(lblTitle);
		
		// tạo buttron 
		
		JPanel pnFlow = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JButton btn1 = new JButton("đăng nhập");
		JButton btn2 = new JButton("đăng ký");
		pnFlow.add(btn1);
		pnFlow.add(btn2);
		

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnUserInfo2);
		pnMain.add(pnFlow);
		con.add(pnMain);
		
	}

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
