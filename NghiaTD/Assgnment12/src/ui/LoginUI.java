package ui;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class LoginUI extends JFrame {
	JButton btnadd = new JButton("Thêm"); 
	JButton btnedit = new JButton("Sửa"); 
	JButton btndelete = new JButton("Xóa"); 
	JButton btnThoat = new JButton("exit"); 
	JButton btnNhap = new JButton("ENTER"); 
	JTextField txtUser =new JTextField(20);
	DefaultTableModel dm ;
	JTextField  txtPass , txtage;
	JTable tbl;
	
	ActionListener addClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dm.addRow(new String[] { txtUser.getText(), txtPass.getText(), txtage.getText() });
		}
	};
	
	ActionListener editclick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	};
ActionListener deleteclick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ShowMessageHello();
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
			int row = tbl.getSelectedRow();
			int col =1 ;
			String s = (String) tbl.getValueAt(row, col);
			txtUser.setText(s);
			
		}
	};
	
	public void ShowMessageHello() {
		JOptionPane.showMessageDialog(null,"xin chào bạn" +txtUser.getText()+ "Login thành công!!!");
	};
	public void addEvents()
	{
		btnadd.addActionListener(addClick);
		btnedit.addActionListener(editclick);
		btndelete.addActionListener(deleteclick);
		tbl.addMouseListener(tblUserClick);
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// tạo title chứa dòng đăng nhâp
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("CHương trình quản lý sinh viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);	
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		
		// tạo sổ xuống để chọn lớp
		JPanel pnchonlop = new JPanel();
		JLabel lblclass = new JLabel("Chọn lớp:");
		JComboBox setclass=new JComboBox();
		
		setclass.addItem("FFSE 1701");
		setclass.addItem("FFSE 1702");
		setclass.addItem("FFSE 1703");
		setclass.addItem("FFSE 1704");
		pnchonlop.add(lblclass);
		pnchonlop.add(setclass);
		

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("Mã sinh viên:");
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnUserPass = new JPanel();
		JLabel lblPass = new JLabel("Tên Sinh Viên:");
		txtPass = new JTextField(20);
		pnUserPass.add(lblPass);
		pnUserPass.add(txtPass);
		
		JPanel pnage = new JPanel();
		JLabel lblage = new JLabel("Tuổi:                ");
		txtage = new JTextField(20);
		pnage.add(lblage);
		pnage.add(txtage);
		
		// tạo panel chứa dòng chữ pass và textbox pass
		JPanel pnActions =new JPanel();
		pnActions.add(btnadd);
		pnActions.add(btnedit);
		pnActions.add(btndelete);
		pnActions.add(btnThoat);
		pnActions.add(btnNhap);
		
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		
		for(int i=0;i<5;i++) {
			dm.addRow(new String[] {""+(i+1),"abc"+i,"20"});
		}
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnchonlop);
		
		pnMain.add(pnUserInfo);
		pnMain.add(pnUserPass);
		pnMain.add(pnage);
		pnMain.add(pnActions);
		pnMain.add(sc);
		

		con.add(pnMain);
	
	}
	
	
	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public LoginUI(String title) {
		super(title);
		addControls();
		addEvents();
	}
}
