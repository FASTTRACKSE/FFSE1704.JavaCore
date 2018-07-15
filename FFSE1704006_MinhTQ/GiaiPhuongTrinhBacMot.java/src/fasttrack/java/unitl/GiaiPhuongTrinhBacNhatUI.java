package fasttrack.java.unitl;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhBacNhatUI extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPassWord;
	private JTextField txtPassWord;
	private JLabel lbKetQua;
	private JTextField txtKetQua;
	private JButton btn;
	private JButton btn1;
	private JButton btn2;

	public GiaiPhuongTrinhBacNhatUI(String title) {
		super(title);
		addControls();
	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn) {
				tinhToan();
			}
			if (e.getSource() == btn1) {
				ketThucChuongTrinh();
			}
			if (e.getSource() == btn2) {
				System.out.println("button 3");
			}
		}
	};

	

	public void addControls() {

		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.RED);
		lblTitle = new JLabel("Chương Trình Giải Phương Trình Bậc 1");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo = new JPanel();
		lblUser = new JLabel("Nhập hệ số a:");
		txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);

		JPanel pnPassWordInfo = new JPanel();
		lblPassWord = new JLabel("Nhập hệ số b:");
		txtPassWord = new JTextField(20);
		pnPassWordInfo.add(lblPassWord);
		pnPassWordInfo.add(txtPassWord);

		// tạo button
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btn = new JButton("Calc");

		JLabel pnkc = new JLabel("      ");
		btn1 = new JButton("Exit");

		JLabel pnkc1 = new JLabel("      ");
		btn2 = new JButton("Help");

		// tạo một User khác chứa chữ
		JPanel pnUserKetQua = new JPanel();
		lbKetQua = new JLabel("Kết Quả:");

		txtKetQua = new JTextField(20);
		pnUserKetQua.add(lbKetQua);
		pnUserKetQua.add(txtKetQua);

		JPanel pnKCInfo = new JPanel();
		// add button
		pnBox.add(btn);
		btn.addActionListener(actionListener);
		pnBox.add(pnkc);
		pnBox.add(btn1);
		btn1.addActionListener(actionListener);
		pnBox.add(pnkc1);
		pnBox.add(btn2);
		btn2.addActionListener(actionListener);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnPassWordInfo);
		pnMain.add(pnBox);
		pnMain.add(pnKCInfo);
		pnMain.add(pnUserKetQua);
		con.add(pnMain);

	}

	public void tinhToan() {
		String s1 = txtUser.getText();
		String s2 = txtPassWord.getText();
		float a = Float.parseFloat(s1);
		float b = Float.parseFloat(s2);
		String x;
		if (a == 0) {
			if (b == 0) {
				x = "Phương trình có vô số nghiệm";
			} else {
				x = "Phương trình vô nghiệm";
			}
		} else {
			x = Float.toString(-b / a);
		}
		txtKetQua.setText(x);

	}

	public void ketThucChuongTrinh() {
		System.exit(0);
	}

	public void showView() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
