package fasttrackse.loginapp.ui;

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
		addControls();
	}
	
	public void addControls() {
		// Lấy đối tượng chứa controls cho màn hình
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tiêu đề cho màn hình : Màn hình Login
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Đăng nhập chương trình");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		
		// Ô nhập user		
		JPanel pnUser=new JPanel();
		JLabel lblUser = new JLabel("User: ");
		JTextField txtUser = new JTextField(15);
		pnUser.add(lblUser);
		pnUser.add(txtUser);
		
		// Ô nhập password
		
		// Button
		
		// Add all panel con lên main pane
		pnMain.add(pnTitle);
		pnMain.add(pnUser);
		con.add(pnMain);
	}
	
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
