package fasttrackse.app.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblpass;
	private JTextField txtpass;

	private JButton btn1;
	private JButton btn2;

	public Login(String tieude) {
		super(tieude);
		addControls();
		// Thêm sự kiện(event)
	}

	public void addControls() {
		// Đưa container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Login
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Login");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ user
		JPanel pnUserInfo = new JPanel();
		lblUser = new JLabel("User");
		txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ pass và textbox pass
		JPanel pnpass = new JPanel();
		lblpass = new JLabel("Pass");
		txtpass = new JTextField(20);
		pnpass.add(lblpass);
		pnpass.add(txtpass);
		pnTitle.add(lblTitle);

		// tao button login
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btn1 = new JButton("Login");
		btn1.setForeground(Color.BLUE);
		pnBox.add(btn1);
		btn1.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// tao button Cancel
		btn2 = new JButton("Cancel");
		btn2.setForeground(Color.RED);
		pnBox.add(btn2);
		btn2.addActionListener(actionListener);
		JPanel pnKCduoi = new JPanel();
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnpass);

		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		con.add(pnMain);
	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn1) {
				login();
			}
			if (e.getSource() == btn2) {
				txtUser.setText("");
				txtpass.setText("");
			}

		}
	};
	public void login() {
		String user = txtUser.getText();
		String pass = txtpass.getText();
		
		try {
			if(user.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(null, "Khong de trong!");
			}else {
				String Url = "jdbc:mysql://localhost/sinhvien";
				Connection conn = DriverManager.getConnection(Url,"sv","123456");
				String sql = "SELECT * FROM Users  WHERE Username=? AND Password=?";
				PreparedStatement stm = conn.prepareStatement(sql);
				stm.setString(1, user);
				stm.setString(2, pass);
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					SVUI svui = new SVUI("Quản lý sinh viên");
					svui.showWindow();
				}else {
					JOptionPane.showMessageDialog(null, "that bai");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}