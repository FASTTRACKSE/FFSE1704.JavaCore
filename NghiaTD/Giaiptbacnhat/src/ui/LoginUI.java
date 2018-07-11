package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

public class LoginUI extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblpass;
	private JTextField txtpass;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JTextField txtresult;
	private JLabel lblresult;
	public LoginUI(String title) {
		super(title);
		addControl();
	}
	public void addControl() {
		//nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		//tạo pannel title chứa dòng đăng nhập
		JPanel pnTitle = new JPanel();
		 lblTitle = new JLabel("Giải Phương trình bậc nhất");
		pnTitle.setBackground(Color.RED);
		lblTitle.setForeground(Color.BLUE);
		
//		pnTitle.setSize(5,5);
		Font fontTitle = new Font("Arial",Font.BOLD,20);
		lblTitle.setFont(fontTitle);
		pnTitle.setPreferredSize(new Dimension(20, 20));
		pnTitle.add(lblTitle);
		
		// tạo panel chứa dòng user và 	text box user
		JPanel pnUserInfo = new JPanel();
		 lblUser = new JLabel("Hệ số a");
		 txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);
		
		// tạo panel chứa dòng pass word and text pass word
		JPanel pnpass = new JPanel();
		 lblpass = new JLabel("Hệ số b");
		 txtpass = new JTextField(20);
		pnpass.add(lblpass);
		pnpass.add(txtpass);
		
		
		// tạo button đăng nhập
		JPanel pnbutton = new JPanel();
		//pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
		 btn1 = new JButton("CALC");
		btn1.setForeground(Color.BLUE);
		JLabel pnkc = new JLabel("        ");
		btn1.addActionListener(actionListener);
		
	
		pnbutton.add(btn1);
		pnbutton.add(pnkc);
		 btn2 = new JButton("EXIT");
		btn2.setForeground(Color.RED);
		JLabel pnkc1 = new JLabel("        ");
		pnbutton.add(btn2);
		pnbutton.add(pnkc1);
		btn2.addActionListener(actionListener);
		
		 btn3 = new JButton("HELP");
		pnbutton.add(btn3);
		btn3.addActionListener(actionListener);
		
		JPanel pnresult = new JPanel();
		 lblresult = new JLabel("Kết quả");
		 txtresult = new JTextField(20);
		pnresult.add(lblresult);
		pnresult.add(txtresult);
		
		
		
		
		//add vào main 
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnpass);
		pnMain.add(pnbutton);
		pnMain.add(pnresult);
		con.add(pnMain);
		
		
		
	}
	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() ==btn1) {
				tinhtoan();
			}
			if(e.getSource() ==btn2) {
				System.out.println("ahihi");
			}
			if(e.getSource() ==btn3) {
				System.out.println("Hello 500ae");
			}
		}
			
	};
	public void tinhtoan() {
		String kq1= txtUser.getText();
		String kq2= txtpass.getText();
		Float a= Float.parseFloat(kq1);
		Float b= Float.parseFloat(kq2);
		String x = null;
		if(a==0) {
			if(b==0) {
				System.out.println("Phuong trình vô số nghiệm");
			}
			else if(b!=0) {
				System.out.println("Phuong trình VÔ nghiệm");
			}
		}
		else {
			System.out.println("Phuong trình Có nghiệm kép");
			x = Float.toString(-b/a);
		}
		txtresult.setText(x);
	}
}
