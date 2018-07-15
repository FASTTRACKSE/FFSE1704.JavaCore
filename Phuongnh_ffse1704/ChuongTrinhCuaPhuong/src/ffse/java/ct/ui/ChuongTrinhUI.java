package ffse.java.ct.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
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

import ffse.java.ct.dao.SinhVienDAO;
import ffse.java.ct.entity.SinhVien;


public class ChuongTrinhUI extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
	ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
	

	private JLabel lblTitle;
	private JLabel lblTSV;
	private JTextField txtTSV;
	private JLabel lblMSV;
	private JTextField txtMSV;
	private JLabel lbltuoi;
	private JTextField txttuoi;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;// has - a
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	DefaultTableModel dm;
	JTable tbl;
	JComboBox<String> classs;
	
	public ChuongTrinhUI(String tieude) {
		super(tieude);
		addControls();
		addEvent();
	}

	public void addEvent() {
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
			txtMSV.setText(maSV);
			
			String tenSV = (String) tbl.getValueAt(row, 2);
			txtTSV.setText(tenSV);
			
			String tuoiSV = (String) tbl.getValueAt(row, 3);
			txttuoi.setText(tuoiSV);
		}
	};

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Chương trình giải phương trình bậc nhất
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Quản lý sinh viên FastTrack SE");
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

		// Tạo panel pass chứa dòng chữ hệ số b và textbox hệ số b
		JPanel pnMSV = new JPanel();
		lblMSV = new JLabel("Mã sinh viên");
		txtMSV = new JTextField(20);
		pnMSV.add(lblMSV);
		pnMSV.add(txtMSV);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ hệ số a
		JPanel pnTSV = new JPanel();
		lblTSV = new JLabel("Tên Sinh Viên");
		txtTSV = new JTextField(20);
		pnTSV.add(lblTSV);
		pnTSV.add(txtTSV);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ kết quả và textbox kết quả
		JPanel pntuoi = new JPanel();
		lbltuoi = new JLabel("Tuổi Sinh Viên");
		txttuoi = new JTextField(20);
		pntuoi.add(lbltuoi);
		pntuoi.add(txttuoi);
		pnTitle.add(lblTitle);

		// tao button CACL
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btn1 = new JButton("THÊM");
		btn1.setForeground(Color.BLUE);
		pnBox.add(btn1);
		btn1.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// tao button EXIT
		btn2 = new JButton("SỬA");
		btn2.setForeground(Color.RED);
		pnBox.add(btn2);
		btn2.addActionListener(actionListener);
		JLabel pnkc2 = new JLabel("        ");
		pnBox.add(pnkc2);

		// tao button XÓA
		btn3 = new JButton("XÓA");
		btn3.setForeground(Color.GREEN);
		pnBox.add(btn3);
		btn3.addActionListener(actionListener);
		JLabel pnkc3 = new JLabel("        ");
		pnBox.add(pnkc3);

		// tao button HELP
		btn4 = new JButton("RESET");
		btn4.setForeground(Color.YELLOW);
		pnBox.add(btn4);
		btn4.addActionListener(actionListener);
		JLabel pnkc4 = new JLabel("        ");
		pnBox.add(pnkc4);

		// tao button HELP
		btn5 = new JButton("THOÁT");
		btn5.setForeground(Color.PINK);
		pnBox.add(btn5);
		btn5.addActionListener(actionListener);

		
		
		// tao button HELP
		btn6 = new JButton("IN DS");
		btn6.setForeground(Color.PINK);
		pnBox.add(btn6);
		btn6.addActionListener(actionListener);
		JPanel pnKCduoi = new JPanel();
		

		// table
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Lớp");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		this.inThongTin();
		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnlist);
		pnMain.add(pnTSV);
		pnMain.add(pnMSV);
		pnMain.add(pntuoi);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		pnMain.add(sc);
		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn1) {
				nhapThongTin();
			}
			if (e.getSource() == btn2) {
				suaThongTin();
			}
			if (e.getSource() == btn3) {
				xoaThongTin();
			}
			if (e.getSource() == btn4) {
				JOptionPane.showMessageDialog(null, "Hello World");
			}
			if (e.getSource() == btn5) {
				System.exit(0);
			}
			if (e.getSource() == btn6) {
				inThongTin();
			}
		}
	};

	public void inThongTin() {
		dsSV = sinhVienDAO.getDSinhVien();
		for(int i=0 ; i< dsSV.size();i++) {
			dm.addRow(new String[] { dsSV.get(i).getMaSinhVien(), dsSV.get(i).getLopSinhVien() , dsSV.get(i).getTenSinhVien(),dsSV.get(i).getTuoiSinhVien()});
			
		}
		
	}
	public void nhapThongTin() {
		String tenSinhVien = txtTSV.getText();
		String maSinhVien = txtMSV.getText();
		String lopSinhVien = classs.getSelectedItem().toString();
		String tuoiSinhVien = txttuoi.getText();
//		String[] row = {maSinhVien, lopSinhVien, tenSinhVien, tuoiSinhVien };
//		dm.addColumn(row);
		dm.addRow(new String[] { maSinhVien,tenSinhVien, lopSinhVien,  tuoiSinhVien });
		sinhVienDAO.add(new SinhVien(maSinhVien,tenSinhVien,lopSinhVien,tuoiSinhVien));
	}
	public void suaThongTin() {
		String tenSinhVien = txtTSV.getText();
		String lopSinhVien = classs.getSelectedItem().toString();
		String maSinhVien = txtMSV.getText();
		String tuoiSinhVien = txttuoi.getText();
		sinhVienDAO.update(new SinhVien(maSinhVien,tenSinhVien,lopSinhVien,tuoiSinhVien));
		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSinhVien,row, 0);
		tbl.setValueAt(lopSinhVien,row, 1);
		tbl.setValueAt(tenSinhVien,row, 2);
		tbl.setValueAt(tuoiSinhVien,row, 3);
		
	}
	public void xoaThongTin() {
		int[] rows = tbl.getSelectedRows();
		   for(int i=0;i<rows.length;i++){
		     dm.removeRow(rows[i]-i);
		   }
	}
	public void showWindow() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}