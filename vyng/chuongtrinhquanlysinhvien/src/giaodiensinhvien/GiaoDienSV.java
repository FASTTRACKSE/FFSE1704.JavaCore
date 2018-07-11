package giaodiensinhvien;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GiaoDienSV extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitle;
	private JLabel lblUserMSV;
	private JTextField txtUserMSV;
	private JLabel lblUserTSV;
	private JTextField txtUserTSV;
	private JLabel lblUsertuoi;
	private JTextField txtUsertuoi;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	DefaultTableModel dm;
	JTable tbl;
	JComboBox<String> classs;

	
	public GiaoDienSV(String title) {
		super(title);
		addControls();
		addEvent();
	}
	

	private void addEvent() {
		tbl.addMouseListener(tblUserClick);
	}
	
	MouseListener tblUserClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {

			int row = tbl.getSelectedRow();

			

			String maSV = (String) tbl.getValueAt(row, 0);
			txtUserMSV .setText(maSV);
			
			String tenSV = (String) tbl.getValueAt(row, 1);
			txtUserTSV.setText(tenSV);
			
			String tuoiSV = (String) tbl.getValueAt(row, 2);
			txtUsertuoi.setText(tuoiSV);
		}
	};


	private void addControls() {
		
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("giao diện quản lý sinh viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		
		// tao box class
		JPanel pnlist = new JPanel();
		JLabel lblclass = new JLabel("Lớp");
		classs = new JComboBox<String>();
		classs.addItem("FFSE 1701");
		classs.addItem("FFSE 1702");
		classs.addItem("FFSE 1703");
		classs.addItem("FFSE 1704");
		classs.addItem("FFSE 1801");
		pnlist.add(lblclass);
		pnlist.add(classs);
		

		
		// tạo panel mã sinh viên
		JPanel pnUserInfoMSV = new JPanel();
		JLabel lblUserMSV = new JLabel("mã : ");
		txtUserMSV = new JTextField(20);
		pnUserInfoMSV.add(lblUserMSV);
		pnUserInfoMSV.add(txtUserMSV);
		pnTitle.add(lblTitle);
		
		// tạo panel tên sinh viên
		JPanel pnUserInfoTSV = new JPanel();
		JLabel lblUserTSV = new JLabel("tên : ");
		txtUserTSV = new JTextField(20);
		pnUserInfoTSV.add(lblUserTSV);
		pnUserInfoTSV.add(txtUserTSV);
		pnTitle.add(lblTitle);
		
		// tạo panel tuổi 
		JPanel pnUserInfotuoi = new JPanel();
		JLabel lblUsertuoi = new JLabel("tuổi : ");
		txtUsertuoi = new JTextField(20);
		pnUserInfotuoi.add(lblUsertuoi);
		pnUserInfotuoi.add(txtUsertuoi);
		pnTitle.add(lblTitle);
		
		// tạo buttron
		JPanel pnFlow = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		 btn1 = new JButton("thêm");
		 btn2 = new JButton("sửa");
		 btn3 = new JButton("xóa");
		 btn4 = new JButton("reset");
		 btn5 = new JButton("thoát");
		pnFlow.add(btn1);
		btn1.addActionListener(actionListener);
		pnFlow.add(btn2);
		btn2.addActionListener(actionListener);
		pnFlow.add(btn3);
		btn3.addActionListener(actionListener);
		pnFlow.add(btn4);
		btn4.addActionListener(actionListener);
		pnFlow.add(btn5);
		btn5.addActionListener(actionListener);
		
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		
	/*	for (int i = 0; i < 100; i++) {
			dm.addRow(new String[] { "" + (i + 1), "Trần Văn T" + i, "20" });
		}*/
		
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);
				
		// add panel vào main
		pnMain.add(pnTitle);
		pnMain.add(pnlist);
		pnMain.add(pnUserInfoMSV);
		pnMain.add(pnUserInfoTSV);
		pnMain.add(pnUserInfotuoi);
		pnMain.add(pnFlow);
		pnMain.add(sc);
		con.add(pnMain);
	}
	
	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource() == btn1) {
				nhapthongtin();
			}
			
			if(a.getSource() == btn2) {
				suathongtin();
			}
			
			if(a.getSource() == btn3) {
				xoathongtin();
			}
			
			if(a.getSource() == btn4) {
				reset();
			}
			
			if(a.getSource() == btn5) {
				System.exit(0);
			}
			
		}
		
		private void nhapthongtin() {
			String tensinhvien = txtUserTSV.getText();
			String masinhvien = txtUserMSV.getText();
			String tuoisinhvien = txtUsertuoi.getText();
			
			dm.addRow(new String[] {masinhvien,tensinhvien,tuoisinhvien});
		}
		
		private void suathongtin() {
			String tensinhvien = txtUserTSV.getText();
			String masinhvien = txtUserMSV.getText();
			String tuoisinhvien = txtUsertuoi.getText();
			int row = tbl.getSelectedRow();
			tbl.setValueAt(masinhvien,row, 0);
			tbl.setValueAt(tensinhvien,row, 1);
			tbl.setValueAt(tuoisinhvien,row, 2);
			
		}
		
		private void xoathongtin() {
			int[] rows = tbl.getSelectedRows();
				for(int i=0;i<rows.length;i++) {
					dm.removeRow(rows[i]-i);
				}
			
		}

		private void reset() {
			txtUserTSV.setText("");
			txtUserMSV.setText("");
			txtUsertuoi.setText("");
			
		}
		
	};
	
	public void showWindow() {
		this.setSize(500, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
