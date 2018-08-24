package fasttrackse.database.quanlysinhvien.ui;

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

public class LoginUI extends JFrame implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitle;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblPass;
	private JTextField txtPass;
	private JButton btnLogin;
	private JButton btnExit;
	
	public LoginUI (String tieude) {
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
		lblTitle = new JLabel("Login");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);		
		
		// Tạo panel pass chứa dòng chữ "Nhập ID: " và textbox
		JPanel pnId = new JPanel();
		lblId = new JLabel("Nhập ID: ");
		txtId = new JTextField(20);
		pnId.add(lblId);
		pnId.add(txtId);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ "Nhập Pass: " và textbox 
		JPanel pnPass = new JPanel();
		lblPass = new JLabel("Nhập Pass: ");
		txtPass = new JTextField(20);
		pnPass.add(lblPass);
		pnPass.add(txtPass);
		pnTitle.add(lblTitle);
		
		// tao button
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		
		// Tạo button Login
		btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.BLUE);
		pnBox.add(btnLogin);
		
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// Tạo button thoát
		btnExit = new JButton("THOÁT");
		btnExit.setForeground(Color.ORANGE);
		pnBox.add(btnExit);
		btnExit.addActionListener(actionListener);
		
		JPanel pnKCduoi = new JPanel();

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnId);
		pnMain.add(pnPass);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		
		con.add(pnMain);
	}
	
	
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLogin) {
				QuanLySinhVienUI myLoginUI = new QuanLySinhVienUI("Quan Ly Sinh Viên");
				myLoginUI.showWindow();
			}
			if (e.getSource() == btnExit) {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình?", "Thoát", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		}
	};
	
	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
