package ffse1704.qlsv.ui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ffse1704.qlsv.entity.User;
import ffse1704.util.SerializeFileFactory;
public class KetNoi extends JFrame {
	static ArrayList<User> admin = new ArrayList<User>();
	private static final long serialVersionUID = 1L;
	private JTextField txtUser ,  txtPass   ;
	private JLabel lblLogin ;
	JPasswordField lblPass;
	JCheckBox check1;
	JButton btnLogin = new JButton("LOGIN");
	JButton btnlogout = new JButton("CANCEL");
	JButton btnRegister = new JButton("REGISTER");
	
	
	ActionListener dangnhap = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Login();
		}
	};
ActionListener thoat = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Logout();
		}
	};
	public void addEvents()
	{
		btnLogin.addActionListener(dangnhap);
		btnlogout.addActionListener(thoat);
		
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		//tạo user
		
		//tạo dòng chữ tài khoản
	
		
		
		JPanel pnUser = new JPanel();
		JLabel lblUser = new JLabel("UserName");
		lblUser.setForeground(Color.BLUE);
		lblUser.setBounds(200,220,200,0);
//
		txtUser = new  JTextField(20);
		pnUser.add(lblUser);
		pnUser.add(txtUser);
		
		// tạo pass
		
		JPanel pnPass = new JPanel();
		JLabel lbPass = new JLabel("Password");
		lbPass.setForeground(Color.BLUE);
		txtPass = new  JPasswordField(20);
		pnPass.add(lbPass);
		pnPass.add(txtPass);
		
//		JPanel pnRegister = new JPanel();
//		JLabel lblRegister = new JLabel("Đăng kí");
		
	
		pnPass.add(lbPass);
		pnPass.add(txtPass);
		
		JPanel pncheckbox = new JPanel();
		check1 = new JCheckBox();
		JLabel lblcheckbox = new JLabel("REMEMBER ACOUNT");
		lblcheckbox.setForeground(Color.BLUE);
		pncheckbox.add(check1);
		pncheckbox.add(lblcheckbox);
		
		JPanel pnActions =new JPanel();
		btnLogin.setBounds(100, 400, 220, 30);
		pnActions.add(btnLogin);
		btnLogin.setForeground(Color.BLUE);
		pnActions.add(btnRegister);
		btnRegister.setForeground(Color.RED);
		pnActions.add(btnlogout);
		btnlogout.setForeground(Color.GREEN);
		
		
		pnMain.add(pnUser);
		pnMain.add(pnPass);
//		pnMain.add(btnLogin);
		pnMain.add(pncheckbox);
		pnMain.add(pnActions);
		con.add(pnMain);
		
	}
	public void Login()  {
		String username = txtUser.getText();
		String pass = txtPass.getText();
		try {
		if(username.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(null,"Không được để trống");
		}
		else {
			String Url = "jdbc:mysql://localhost/quanlyhocvien";
			Connection conn = DriverManager.getConnection(Url,"nghia111","123456");
//			String sql = "SELECT * FROM login  WHERE Username='"+username+"' AND Password='"+pass+"5e'";
//			PreparedStatement stm = conn.prepareStatement(sql);
//			stm.setString(1, username);
//			stm.setString(2, pass);
			String sql = "SELECT * FROM login  WHERE Username=? AND Password= ? ";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, pass);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				if(check1.isSelected()==true) {
					String usname = txtUser.getText();
					String password = txtPass.getText();
					for(int i =0;i<admin.size();i++) {
						if(usname.equals(admin.get(i).getName()) && password.equals(admin.get(i).getPass())) {
							JOptionPane.showMessageDialog(null,"Tài khoản mk đã tồn tại");
						}
						else {
							admin.add(new User(usname, password));
							SerializeFileFactory.luuFile(admin, "User.txt");
							LoginUI svui =new LoginUI("Quản lý sinh viên");
							svui.showWindow();
							this.setVisible(false);
							break;
						}
						
					}
				}
				else {
					LoginUI svui =new LoginUI("Quản lý sinh viên");
					svui.showWindow();
					this.setVisible(false);
//					
				}
			}else {
				JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
			}
		}
	} catch (Exception e) {
		System.out.println(e);
	
		}
	}
	public void docfile() {
		admin.clear();
		admin = SerializeFileFactory.docFile("user.text");
		File fi = new File("E:\\FFSE1704007\\FFSE1704.JavaCore\\NghiaTD\\Assgnment13\\user.text");
		if(fi.exists()) {
			if(admin.isEmpty()) {
				txtUser.setText("");
				txtPass.setText("");
			}else {
				txtUser.setText(admin.get(0).getName());
				txtPass.setText(admin.get(0).getPass());
			}
		}else {
				System.out.println("file k tồn tại");
			}
		if(check1.isSelected()==false) {
			txtUser.setText("");
			txtPass.setText("");
		}
		}
	
	
	
	public void Logout() {
		
	}
	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public KetNoi(String title) {
		super(title);
		addControls();
		addEvents();
	}
}
