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
		addControl();
	}
	public void addControl() {
		//nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		//tạo pannel title chứa dòng đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Giao diện đăng nhập");
		Font fontTitle = new Font("Arial",Font.BOLD,20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		
		// tạo panel chứa dòng user và 	text box user
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("User");
		JTextField txtUser = new JTextField(30);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);
		
		// tạo panel chứa dòng pass word and text pass word
		JPanel pnpass = new JPanel();
		JLabel lblpass = new JLabel("Pass word");
		JTextField txtpass = new JTextField(20);
		pnUserInfo.add(lblpass);
		pnUserInfo.add(txtpass);
		
		
		// tạo button đăng nhập
		JPanel pnbutton = new JPanel();
		JButton btn1 = new JButton("Login");
		
		pnbutton.add(btn1);
		JButton btn2 = new JButton("Register");
		pnbutton.add(btn2);
		
		
		
		//add vào main 
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnpass);
		pnMain.add(pnbutton);
		con.add(pnMain);
		
		
		
	}
	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
