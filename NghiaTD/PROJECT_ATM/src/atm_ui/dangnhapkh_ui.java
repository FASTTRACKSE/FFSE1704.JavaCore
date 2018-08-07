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
import javax.swing.BorderFactory;
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
public class dangnhapkh_ui extends JFrame {
	JButton enTer = new JButton("ENTER"); 
	JButton clear = new JButton("CLEAR"); 
	JButton canCel = new JButton("CANCEL");
	JTextField txt_sothe ,txtPin ;
	
	
ActionListener enterClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			RutTien_ui login = new RutTien_ui("HỆ THỐNG RÚT TIỀN DÀNH CHO KHÁCH HÀNG");
			login.showWindow();
			
	
		}
	};
	
	ActionListener clearClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
	ActionListener canCelClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Login_ui login = new Login_ui("Máy ATM");
			login.showWindow();
			
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
		enTer.addActionListener(enterClick);
		clear.addActionListener(clearClick);
		canCel.addActionListener(canCelClick);
	
		//tbl.addMouseListener(tblUserClick);
	}
	public dangnhapkh_ui(String title) {
		super(title);
		addControls();
		addEvents();
	}
	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		// tạo id khách hàng đăng nhập'
		JPanel soThe_atm = new JPanel();
		//soThe_atm.setBorder(BorderFactory.createEmptyBorder(250, 10, 10, 10));
		JLabel lblsothe = new JLabel("NHẬP SỐ THẺ") ;
	
		lblsothe.setPreferredSize(new Dimension(80, 10));
		lblsothe.setForeground(Color.blue);
		txt_sothe = new JTextField(20);
		//soThe_atm.setBounds(60, 400, 220, 30);
	
		soThe_atm.add(lblsothe);
		
		soThe_atm.add(txt_sothe);
		
		
		// tạo mã pin khách hàng đăng nhập'
		JPanel pnPin = new JPanel();
		pnPin.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		JLabel lblPin = new JLabel("NHẬP MÃ PIN") ;
		lblPin.setForeground(Color.blue);
		txtPin = new JTextField(20);
		pnPin.add(lblPin);
		pnPin.add(txtPin);
		
		JPanel pnActions =new JPanel();
		pnActions.add(enTer);
		pnActions.add(clear);
		pnActions.add(canCel);
		enTer.setForeground(Color.BLUE);
		clear.setForeground(Color.GREEN);
		canCel.setForeground(Color.RED);
		
		pnMain.add(soThe_atm);
		pnMain.add(pnPin);
		pnMain.add(pnActions);
		con.add(pnMain);
	}
}
