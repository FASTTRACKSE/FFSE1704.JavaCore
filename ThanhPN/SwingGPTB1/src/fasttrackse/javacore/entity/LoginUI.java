package fasttrackse.javacore.entity;

import java.awt.Color;
import java.awt.Container;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginUI extends JFrame {
	
	private JPanel pnTitle, pnUserInfo, pnUserInfo1, pnUserInfo2, pnMain11, pnMain;
	private JLabel lblTitle, lblUser, lblUser1, lblUser2, ok, ok1;
	private JTextField txtUser, txtUser1, txtUser2;
	private JButton btn1, btn11, btn111;

	public LoginUI(String title) {
		super(title);
		addControls();
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		pnTitle = new JPanel();
		pnTitle.setBackground(Color.PINK);
		lblTitle = new JLabel("Giải Phương Trình Bậc 1");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ user và textbox user
		pnUserInfo = new JPanel();
		lblUser = new JLabel("Hệ số A:");
		txtUser = new JTextField(15);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		lblUser.requestFocus();

		// Tạo panel User chứa dòng chữ user và textbox user
		pnUserInfo1 = new JPanel();
		lblUser1 = new JLabel("Hệ số B:");
		txtUser1 = new JTextField(15);
		pnUserInfo1.add(lblUser1);
		pnUserInfo1.add(txtUser1);

		// Tạo panel User chứa dòng chữ user và textbox user
		pnUserInfo2 = new JPanel();
		lblUser2 = new JLabel("Kết Qủa:");
		txtUser2 = new JTextField(15);
		txtUser2.setEnabled(false);
		pnUserInfo2.add(lblUser2);
		pnUserInfo2.add(txtUser2);

		// Nạp container và add main panel

		pnMain11 = new JPanel();
		pnMain11.setLayout(new BoxLayout(pnMain11, BoxLayout.X_AXIS));
		btn1 = new JButton("Calc");
		pnMain11.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				JOptionPane.showMessageDialog(null, "##############");

			}
		});
		ok = new JLabel("       ");
		pnMain11.add(ok);
		btn11 = new JButton("Exit");
		pnMain11.add(btn11);
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				JOptionPane.showMessageDialog(null, "##############");

			}
		});

		ok1 = new JLabel("       ");
		pnMain11.add(ok1);
		btn111 = new JButton("Help");
		pnMain11.add(btn111);

		btn111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				JOptionPane.showMessageDialog(null, "##############");

			}
		});

		// add main panel vào container

		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnUserInfo1);
		pnMain.add(pnMain11);
		pnMain.add(pnUserInfo2);
		con.add(pnMain);
	}

	// ActionListener actionListener = new ActionListener() {
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// if (e.getSource() == btn1) {
	// tinhToan();
	// }
	// if (e.getSource() == btn11) {
	// System.out.println("button 2");
	// }
	// if (e.getSource() == btn111) {
	// System.out.println("button 3");
	// }
	// }
	// };
	// private void tinhToan() {
	//
	// String s1 = txtUser.getText();
	// String s2 = txtUser1.getText();
	// float a = Float.parseFloat(s1);
	// float b = Float.parseFloat(s2);
	// String x;
	// if (a == 0) {
	// if (b == 0) {
	// x = "Phương trình có vô số nghiệm";
	// } else {
	// x = "Phương trình vô nghiệm";
	// }
	// } else {
	// x = Float.toString(-b / a);
	// }
	// txtUser2.setText(x);
	//
	// }

	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}