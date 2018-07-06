package javaswing.ui;

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

public class LoginUI extends JFrame {
	public LoginUI(String title) {
		super(title);
		addControls();
	}

	public void addControls() {
		// Nạp container và add main panel
		java.awt.Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Đăng nhập chương trình ");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);

		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		// Tạo panel User chứa dòng chữ Tài Khoản,mật Khẩu và textbox Tài Khoản,mật Khẩu
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("Tài Khoản:");
		JTextField txtUser = new JTextField("            Tài Khoản               ");
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnMain.add(pnUserInfo);
		JPanel pnUserPass = new JPanel();
		JLabel lblPass = new JLabel("Mật Khẩu:");
		JTextField txtPass = new JPasswordField("12345678901234567891");
		pnUserPass.add(lblPass);
		pnUserPass.add(txtPass);
		pnTitle.add(lblTitle);
		pnMain.add(pnUserPass);

		// Tạo Button
		JPanel pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.X_AXIS));
		JButton jButton1 = new JButton();
		jButton1.setText("Đăng Kí");
		jButton1.addActionListener(new ActionListener()

		{

		 public void actionPerformed(ActionEvent arg0)

		 {

		 JOptionPane.showMessageDialog(null, "Đã Click Đăng Kí");

		 }

		});
		JLabel jButton31 = new JLabel("       ");
		JButton jButton2 = new JButton();
		jButton2.setText("Đăng Nhập");
		jButton2.addActionListener(new ActionListener()

				{

				 public void actionPerformed(ActionEvent arg0)

				 {

				 JOptionPane.showMessageDialog(null, "Đã Click Đăng Nhập");

				 }

				});
		pnMain1.add(jButton1);
		pnMain1.add(jButton31);
		pnMain1.add(jButton2);
		
		pnMain.add(pnMain1);
		// add main panel vào container
		
		
		
		con.add(pnMain);
		
	}

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
