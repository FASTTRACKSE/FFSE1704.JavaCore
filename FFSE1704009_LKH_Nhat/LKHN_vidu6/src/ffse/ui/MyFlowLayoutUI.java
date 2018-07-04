package ffse.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFlowLayoutUI extends JFrame {
	public MyFlowLayoutUI(String tieude) {
		super(tieude);
		addControls();
	}

	public void addControls() {
		// Nạp container và add main panel
				Container con = getContentPane();
				JPanel pnMain = new JPanel();
				pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
				
				
				// Tạo panel title chứa dòng chữ Đăng nhập
				JPanel pnTitle = new JPanel();
				JLabel lblTitle = new JLabel("Login");
				Font fontTitle = new Font("Arial", Font.BOLD, 20);
				lblTitle.setFont(fontTitle);
				pnTitle.add(lblTitle);
				
				// Tạo panel User chứa dòng chữ user và textbox user
				JPanel pnUserInfo = new JPanel();
				JLabel lblUser = new JLabel("User:");
				JTextField txtUser = new JTextField(20);
				pnUserInfo.add(lblUser);
				pnUserInfo.add(txtUser);
				pnTitle.add(lblTitle);
				
				// Tạo panel pass chứa dòng chữ password và textbox user
				JPanel pnpass = new JPanel();
				JLabel lblpass = new JLabel("pass:");
				JTextField txtpass = new JTextField(20);
				pnpass.add(lblpass);
				pnpass.add(txtpass);
				pnTitle.add(lblTitle);
						
				
				//tao button
				JPanel pnBox=new JPanel();
				pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
				JButton btn1=new JButton("Login");
				btn1.setForeground(Color.BLUE);
				pnBox.add(btn1);
				JButton btn2=new JButton("Reset");
				btn2.setForeground(Color.RED);
				pnBox.add(btn2);
				JLabel pnkc=new JLabel("        ");				
				pnBox.add(btn1);
				pnBox.add(pnkc);
				pnBox.add(btn2);
				
				JPanel pnKCduoi=new JPanel();
				// add main panel vào container
				pnMain.add(pnTitle);
				pnMain.add(pnUserInfo);
				pnMain.add(pnpass);
				pnMain.add(pnBox);
				pnMain.add(pnKCduoi);
				con.add(pnMain);
				
	}

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
