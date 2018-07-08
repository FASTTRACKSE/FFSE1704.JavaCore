package ffse1704.qlsv.ui;


	
	import java.awt.Container;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.util.ArrayList;

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

import ffse1704.qlsv.dao.SinhVienDao;
import ffse1704.qlsv.entity.SinhVien;



	public class LoginUI extends JFrame {
		static SinhVienDao sinhVienDao = new SinhVienDao();
		static ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		
		JButton btnadd = new JButton("Thêm"); 
		JButton btnedit = new JButton("Sửa"); 
		JButton btndelete = new JButton("Xóa"); 
		JButton btnThoat = new JButton("exit"); 
		JButton btnNhap = new JButton("ENTER"); 
		JTextField txtUser ,txtHo ,txtgt ,txtns ;
		JComboBox setclass;
		
		DefaultTableModel dm ;
		JTextField  txtPass ;
		JTable tbl;
		
		ActionListener addClick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//dm.addRow(new String[] { txtUser.getText(), txtPass.getText(), txtage.getText() });
				nhapthongtin();
			}
		};
		
		ActionListener editclick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				editdata();
			}
		};
	ActionListener deleteclick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteData();
			}
		};
	ActionListener enter = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				enterData();
			}
		};
	ActionListener exit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
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
//				String s = (String) tbl.getValueAt(row, col);
//				txtUser.setText(s);
				String maSV = (String) tbl.getValueAt(row, 0);
				txtUser.setText(maSV);
				
				String HoSV = (String) tbl.getValueAt(row, 1);
				txtHo.setText(HoSV);
				
				String tenSV = (String) tbl.getValueAt(row, 2);		
				txtPass.setText(tenSV);
			
				String GioiTinh = (String) tbl.getValueAt(row, 3);
				txtgt.setText(GioiTinh);
				
				
				String NgaySinh = (String) tbl.getValueAt(row, 4);
				txtns.setText(NgaySinh);
				
			
			
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
			btnNhap.addActionListener(enter);
			btnThoat.addActionListener(exit);
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
			
			// tạo sổ xuống để ch�?n lớp
			JPanel pnchonlop = new JPanel();
			JLabel lblclass = new JLabel("Ch�?n lớp:");
			 setclass=new JComboBox<String>();
			
			setclass.addItem("FFSE 1701");
			setclass.addItem("FFSE 1702");
			setclass.addItem("FFSE 1703");
			setclass.addItem("FFSE 1704");
			pnchonlop.add(lblclass);
			pnchonlop.add(setclass);
			

			// Tạo panel User chứa dòng chữ user và textbox user
			JPanel pnUserInfo = new JPanel();
			JLabel lblUser = new JLabel("Mã sinh viên:");
			txtUser = new JTextField(20);
			pnUserInfo.add(lblUser);
			pnUserInfo.add(txtUser);
			
			//tạo panel chứa h�? sv
			JPanel pnHo = new JPanel();
			JLabel lblHo = new JLabel("H�? sinh viên:");
			txtHo = new JTextField(20);
			pnHo.add(lblHo);
			pnHo.add(txtHo);

			// Tạo panel User chứa dòng chữ pass và textbox pass
			JPanel pnUserPass = new JPanel();
			JLabel lblPass = new JLabel("Tên Sinh Viên:");
			txtPass = new JTextField(20);
			pnUserPass.add(lblPass);
			pnUserPass.add(txtPass);
			
			// Tạo panel User chứa dòng giới tính
						JPanel pngt = new JPanel();
						JLabel lblgt = new JLabel("Giơi tính:");
						txtgt = new JTextField(20);
						pngt.add(lblgt);
						pngt.add(txtgt);
			
						// Tạo panel User chứa dòng giới tính
						JPanel pnns = new JPanel();
						JLabel lblns = new JLabel("Ngày Sinh:");
						txtns = new JTextField(20);
						pnns.add(lblns);
						pnns.add(txtns);
			
		
			
			// tạo panel chứa dòng chữ pass và textbox pass
			JPanel pnActions =new JPanel();
			pnActions.add(btnadd);
			pnActions.add(btnedit);
			pnActions.add(btndelete);
			pnActions.add(btnThoat);
			pnActions.add(btnNhap);
			
			dm = new DefaultTableModel();
			dm.addColumn("Mã");
			dm.addColumn("H�?");
			dm.addColumn("Tên");
			dm.addColumn("Giới tính");
			dm.addColumn("Ngày sinh");
			dm.addColumn("Lớp");
			this.getTable();
			
			
//			for(int i=0;i<5;i++) {
//				dm.addRow(new String[] {""+(i+1),"abc"+i,"20"});
//			}
			tbl = new JTable(dm);		
			JScrollPane sc = new JScrollPane(tbl);

			// add main panel vào container
			pnMain.add(pnTitle);
			pnMain.add(pnchonlop);
			pnMain.add(pnUserInfo);
			pnMain.add(pnHo);
			pnMain.add(pnUserPass);
			
			
			
			pnMain.add(pngt);
			pnMain.add(pnns);

			
			pnMain.add(pnActions);
			
			pnMain.add(sc);
			

			con.add(pnMain);
		
		}
		public void nhapthongtin() {
			String HoSV= txtHo.getText();
			String GioiTinh= txtgt.getText();
			String TenSV= txtPass.getText();
			String NgaySinh= txtns.getText();
			String maSV= txtUser.getText();
			String lop= setclass.getSelectedItem().toString();

			dm.addRow(new String[] {maSV,HoSV,TenSV,GioiTinh,NgaySinh,lop});
			
	
			sinhVienDao.add(new SinhVien(maSV,HoSV,TenSV,GioiTinh,NgaySinh,lop));
			
			
			
			
		}
		public void editdata() {
			String MaSV = txtUser.getText();
			String HoSV = txtHo.getText();
			String TenSV = txtPass.getText();
			String GioiTinh = txtgt.getText();
			String NgaySinh = txtns.getText();
			String lop = setclass.getSelectedItem().toString();
			
			sinhVienDao.edit(new SinhVien(MaSV,HoSV,TenSV,GioiTinh,NgaySinh,lop));

			int row = tbl.getSelectedRow();
			tbl.setValueAt(MaSV,row, 0);
			tbl.setValueAt(HoSV,row, 1);
			tbl.setValueAt(TenSV,row, 2);
			tbl.setValueAt(GioiTinh,row, 3);
			tbl.setValueAt(NgaySinh,row, 4);
			tbl.setValueAt(lop,row, 5);
			
			
			
			
		
		}
		public void deleteData() {
			String MaSV = txtUser.getText();
			int[] rows = tbl.getSelectedRows();
			for(int i=0;i<rows.length;i++) {
				dm.removeRow(rows[i]-i);
				sinhVienDao.delete(MaSV);
				
			}
		}
		public void enterData() {
			txtUser.setText("") ;
			txtPass.setText("") ;
			
			txtns.setText("") ;
			txtgt.setText("") ;
			
		}
		public void getTable() {
			dsSV = sinhVienDao.getDSSinhVien();
			for(int i = 0; i<dsSV.size();i++) {
				dm.addRow(new String[] {dsSV.get(i).getMaSV(),dsSV.get(i).getHoSV(),dsSV.get(i).getTenSV(),dsSV.get(i).getGioiTinh(),
						dsSV.get(i).getNgaySinh(),dsSV.get(i).getLop()});
			}
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


