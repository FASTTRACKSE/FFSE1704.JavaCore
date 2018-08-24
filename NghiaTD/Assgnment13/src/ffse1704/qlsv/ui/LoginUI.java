package ffse1704.qlsv.ui;


	
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

import ffse1704.qlsv.dao.SinhVienDao;
import ffse1704.qlsv.entity.SinhVien;



	public class LoginUI extends JFrame {
		static SinhVienDao sinhVienDao = new SinhVienDao();
		static ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		
		JButton btnadd = new JButton("ADD"); 
		JButton btnedit = new JButton("EDIT"); 
		JButton btndelete = new JButton("DELETE"); 
		JButton btnThoat = new JButton("EXIT"); 
		JButton btnNhap = new JButton("RESET"); 
		JButton btnHome = new JButton("HOME"); 
		JTextField txtUser ,txtHo ,txtgt ,txtns ;
		JComboBox setclass;
		JRadioButton option1, option2;
		ButtonGroup group;
		
		DefaultTableModel dm ;
		JTextField  txtPass ;
		JTable tbl;
		
		ActionListener addClick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//dm.addRow(new String[] { txtUser.getText(), txtPass.getText(), txtage.getText() });
				 
				
				
					if (txtUser.getText().equals("")||txtPass.getText().equals("")||txtHo.getText().equals("")||
							txtns.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin ");
					} else {
						nhapthongtin();
//						btnadd.setVisible(false);
						btnedit.setEnabled(true);
						btndelete.setEnabled(true);
					}
					
//					nhapthongtin();
//					btnedit.setEnabled(true);
//					btndelete.setEnabled(true);
			}
		};
		
		ActionListener editclick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtUser.getText().equals("")||txtPass.getText().equals("")||txtHo.getText().equals("")||
						txtns.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn Phải chọn đối tượng sửa ");
				} else {
					editdata();
					btnadd.setVisible(false);
//					btnedit.setVisible(true);
//					btndelete.setVisible(true);
				}
				
			}
		};
	ActionListener deleteclick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtUser.getText().equals("")||txtPass.getText().equals("")||txtHo.getText().equals("")||
						txtgt.getText().equals("")||txtns.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn hãy chọn đối tượng xóa");
				} else {
					int ret = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa", "Xóa", JOptionPane.YES_NO_OPTION);
					if (ret == JOptionPane.YES_OPTION) {
						deleteData();
					}
					
					btnadd.setVisible(false);
//					btnedit.setVisible(true);
//					btndelete.setVisible(true);
				}
			}
			
		};
	ActionListener enter = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clean();
				txtUser.setEditable(true);
			}
		};
	ActionListener exit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};
	ActionListener home = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtUser.setText("") ;
				txtPass.setText("") ;
				txtHo.setText("");
				txtns.setText("") ;
				LoginUI.getWindows();
				btnadd.setVisible(true);
				txtUser.setEditable(true);
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
				txtUser.setEditable(false);
//				String s = (String) tbl.getValueAt(row, col);
//				txtUser.setText(s);
				
				
				
				String maSV = (String) tbl.getValueAt(row, 0);
				txtUser.setText(maSV);
				
				String HoSV = (String) tbl.getValueAt(row, 1);
				txtHo.setText(HoSV);
				
				String tenSV = (String) tbl.getValueAt(row, 2);		
				txtPass.setText(tenSV);
			
				String GioiTinh = (String) tbl.getValueAt(row, 3);
				 if(GioiTinh.equals("Nam")) {
					 option1.setSelected(true);
				 }
				 else {
					 option2.setSelected(true);
				 }
				
				
				String NgaySinh = (String) tbl.getValueAt(row, 4);
				txtns.setText(NgaySinh);
				String lop = (String) tbl.getValueAt(row, 5);
				setclass.setSelectedItem(lop);
			
			
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
			btnHome.addActionListener(home);
			tbl.addMouseListener(tblUserClick);
		}
		
		public void addControls() {
			Container con = getContentPane();
			JPanel pnMain = new JPanel();
			pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
			// tạo title chứa dòng đăng nhâp
			JPanel pnTitle = new JPanel();
			JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
			lblTitle.setForeground(Color.red);
			Font fontTitle = new Font("Italic ", Font.PLAIN, 20);
			
			lblTitle.setFont(fontTitle);
			pnTitle.add(lblTitle);
			
			// tạo sổ xuống để ch�?n lớp
			JPanel pnchonlop = new JPanel();
			JLabel lblclass = new JLabel("Chọn lớp:");
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
			lblUser.setPreferredSize(new Dimension(80, 10));
			txtUser = new JTextField(20);
			pnUserInfo.add(lblUser);
			pnUserInfo.add(txtUser);
			
			//tạo panel chứa h�? sv
			JPanel pnHo = new JPanel();
			JLabel lblHo = new JLabel("Họ sinh viên:");
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
						 option1 = new JRadioButton("Nam");
				        option2 = new JRadioButton("Nữ");
				         group = new ButtonGroup();
				        group.add(option1);
				        group.add(option2);
				        pngt.add(option1);
				        pngt.add(option2);
				        
			
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
			pnActions.add(btnHome);
			btnadd.setForeground(Color.BLUE);
			btnedit.setForeground(Color.GREEN);
			btndelete.setForeground(Color.RED);
			
//			btnedit.setVisible(false);
//			btndelete.setVisible(false);
			btnedit.setEnabled(false);
			btndelete.setEnabled(false);
			
			dm = new DefaultTableModel();
			
			dm.addColumn("Mã");
			dm.addColumn("Họ");
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
			String GioiTinh= gioiTinh();
			String TenSV= txtPass.getText();
			String NgaySinh= txtns.getText();
			String maSV= txtUser.getText();
			String lop= setclass.getSelectedItem().toString();

			//dm.addRow(new String[] {maSV,HoSV,TenSV,GioiTinh,NgaySinh,lop});
			
	
			sinhVienDao.add(new SinhVien(maSV,HoSV,TenSV,GioiTinh,NgaySinh,lop));
			
			
			
		}
		public String gioiTinh() {
			String GioiTinh;
			if(option1.isSelected()) {
				GioiTinh = "Nam";
			}
			else {
				GioiTinh = "Nữ";
			}
			return GioiTinh;
		}
		public void editdata() {
			String MaSV = txtUser.getText();
			String HoSV = txtHo.getText();
			String TenSV = txtPass.getText();
			String GioiTinh = gioiTinh();
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
		public void clean() {
			txtUser.setText("") ;
			txtPass.setText("") ;
			txtHo.setText("");
			txtns.setText("") ;
			
			
			
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


