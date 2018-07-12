package ffse.loginapp.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
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
		//Lấy đối tượng chưa control cho màn hình
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Tiêu đề cho màn hình
		JPanel pnTitle = new JPanel();
		JLabel lblUser = new JLabel("Chương Trình Quản Lí Sinh Viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		pnTitle.add(lblUser);
		
		//ô user
		JPanel pnUser=new JPanel();
		JLabel lbUser = new JLabel("User: ");
		JTextField txtUser = new JTextField(15);
		pnUser.add(lbUser);
		pnUser.add(txtUser);
		
		
		
		//ô pass
		JPanel pnPass=new JPanel();
		JLabel lbPass = new JLabel("Pass: ");
		JTextField txtPass = new JTextField(15);
		pnPass.add(lbPass);
		pnPass.add(txtPass);
		
		//button
		
		//add all panel lên main panel
		pnMain.add(pnTitle);
		pnMain.add(pnUser);
		pnMain.add(pnPass);
		con.add(pnMain);
	}
	
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
