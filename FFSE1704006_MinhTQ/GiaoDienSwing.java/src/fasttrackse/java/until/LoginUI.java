package fasttrackse.java.until;

import java.awt.Color;
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
		addControls();
	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("FORM LOGIN");
		lblTitle.setForeground(Color.RED);
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("UserName:");
		lblUser.setForeground(Color.RED);
		JTextField txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);

		JPanel pnPassWordInfo = new JPanel();
		JLabel lblPassWord = new JLabel("PassWord:");
		lblPassWord.setForeground(Color.RED);
		JTextField txtPassWord = new JTextField(20);
		pnPassWordInfo.add(lblPassWord);
		pnPassWordInfo.add(txtPassWord);
		pnTitle.add(lblTitle);

		//tạo button
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		JButton btn1 = new JButton("Đăng nhập");
		btn1.setForeground(Color.RED);
		
		JLabel pnkc = new JLabel("      ");
		JButton btn2 = new JButton("Đăng ký");
		btn2.setForeground(Color.RED);
		
		JPanel pnKCInfo = new JPanel();
		//add button
		pnBox.add(btn1);
		pnBox.add(pnkc);
		pnBox.add(btn2);
		

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnPassWordInfo);
		pnMain.add(pnBox);
		pnMain.add(pnKCInfo);
		con.add(pnMain);

	}

	public void showView() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}