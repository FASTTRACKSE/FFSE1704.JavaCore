package atm_ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class Login_ui extends JFrame {
	JButton admin ,customer;
	
	JTable tbl;
	
	ActionListener adclick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Admin login = new Admin("HỆ THỐNG ĐĂNG NHẬP ADMIN");
			login.showWindow();
		CloseFrame();
			
	
		}
	};
	public void CloseFrame(){
	    super.dispose();
	}
	ActionListener customerclick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			dangnhapkh_ui login = new dangnhapkh_ui("HỆ THỐNG ĐĂNG NHẬP KHÁCH HÀNG");
			login.showWindow();
			CloseFrame();
			//this.setVisible(false);
			
			
		}

		
		
	};
	MouseListener tblUserClick = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
	
		
		}
	};
	public void addEvents()
	{
		admin.addActionListener(adclick);
		customer.addActionListener(customerclick);	
	
		//tbl.addMouseListener(tblUserClick);
	}
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		
		JPanel pnTitle= new JPanel();
		pnTitle.setLayout(new BoxLayout(pnTitle, BoxLayout.Y_AXIS));
		JLabel lblTitle = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI ĐÔNG Á BANK                                        ");
		lblTitle.setForeground(Color.red);
		
		JLabel lblTitle1 = new JLabel("                   -----------------0-----------------");
		
		pnTitle.add(lblTitle);
		pnTitle.add(lblTitle1);
		
		JPanel pnTitle2= new JPanel();
		JLabel lblTitle2 = new JLabel("XIN VUI LÒNG CHỌN TÀI KHOẢN MUỐN ĐĂNG NHẬP");
		lblTitle2.setForeground(Color.blue);
		pnTitle2.add(lblTitle2);
		
		
		
		JPanel pnActions =new JPanel();
		//pnActions.setLayout(new BoxLayout(pnActions, BoxLayout.X_AXIS));
		pnActions.setPreferredSize(new Dimension(150, 20));
		admin = new JButton();
		JLabel lbladmin = new JLabel("ADMIN");
		lbladmin.setForeground(Color.blue);
		admin.add(lbladmin);
		admin.setPreferredSize(new Dimension(150, 50));
		
		customer = new JButton();
		JLabel lblcustomer = new JLabel("KHÁCH HÀNG");
		customer.setPreferredSize(new Dimension(150, 50));
		lblcustomer.setForeground(Color.blue);
		customer.add(lblcustomer);
		pnActions.add(admin);
		pnActions.add(customer);
		
		pnMain.add(pnTitle);
		pnMain.add(pnTitle2);
		pnMain.add(pnActions);
		
		
		

		con.add(pnMain);
		
	}
	public Login_ui(String title) {
		super(title);
		addControls();
		addEvents();
	}
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
