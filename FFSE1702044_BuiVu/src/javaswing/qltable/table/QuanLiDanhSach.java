package javaswing.qltable.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QuanLiDanhSach extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnMain,pnMain1,pnMonHoc,pnTacGia,pnSoBaiViet;
	private JTextField txtMonHoc,txtTacGia,txtSoBaiViet;
	private JTable table;
	private JButton button1;

	public QuanLiDanhSach(String title) {
		super(title);
		addControls();
	}

	public void addControls() {
		// Nạp container và add vào main panel
		java.awt.Container con = getContentPane();

		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.LIGHT_GRAY);
		JLabel lblTitle = new JLabel("Chương Trình Quản Lí DS Môn Học");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		
		pnMonHoc = new JPanel();
		JLabel lblMonHoc = new JLabel("Môn Học");
		txtMonHoc = new JTextField(15);
		pnMonHoc.add(lblMonHoc);
		pnMonHoc.add(txtMonHoc);
		pnMain.add(pnMonHoc);
	
		
		pnTacGia = new JPanel();
		JLabel lblTacGia = new JLabel("Tác Giả");
		txtTacGia = new JTextField(15);
		pnTacGia.add(lblTacGia);
		pnTacGia.add(txtTacGia);
		pnMain.add(pnTacGia);
		
		pnSoBaiViet = new JPanel();
		JLabel lblSoBaiViet = new JLabel("Số Bài Viết");
		txtSoBaiViet = new JTextField(15);
		pnSoBaiViet.add(lblSoBaiViet);
		pnSoBaiViet.add(txtSoBaiViet);
		pnMain.add(pnSoBaiViet);
		
		
		
		pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.X_AXIS));
		button1=new JButton();
		button1.setText("Thêm");
		button1.addActionListener(this);
		pnMain1.add(button1);
		pnMain.add(pnMain1);
		
		
		String[] titles = new String[] { "STT", "Môn học", "Tác giả", "Tổng số bài viết" };

		Object[][] objects = new Object[][] { 
				{ 1, "JSP & Servlet", "Tùng Dương", 22 },
				{ 2, "Spring Framework", "Tùng Dương", 15 },
				{ 3, "Struts Framework", "Công Minh", 7 } };

		table = new JTable(objects, titles);

		// Nạp Vào Main
		
		pnMain.add(new JScrollPane(table));

		// Nạp Vào con
		con.add(pnMain);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			
		}
	}

	private void i(int i, String text, String text2, String text3) {
		// TODO Auto-generated method stub
		
	}

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
