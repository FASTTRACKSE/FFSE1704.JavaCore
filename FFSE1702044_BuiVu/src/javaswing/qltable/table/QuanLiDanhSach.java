package javaswing.qltable.table;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javafx.scene.layout.Border;

public class QuanLiDanhSach extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnAdd = new JButton("Thêm");
	JButton btnEdit = new JButton("Sửa");
	JButton btnDelete = new JButton("Xóa");

	JButton btnInput = new JButton("Nhập");
	JButton btnExit = new JButton("Exit");
	JTable tbl;
	DefaultTableModel tableDSSV = new DefaultTableModel();
	JTextField txtMSV, txtTSV, txtTuoiSV;
	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tableDSSV.addRow(new String[] { txtMSV.getText(), txtTSV.getText(), txtTuoiSV.getText() });
		}
	};
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tableDSSV.removeRow(tbl.getSelectedRow());
		}
	};
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String maSinhVien=txtMSV.getText();
			String tenSinhVien=txtTSV.getText();
			String tuoiSinhVien=txtTuoiSV.getText();
			int row = tbl.getSelectedRow();
			tbl.setValueAt(maSinhVien, row, 0);

			tbl.setValueAt(tenSinhVien, row, 1);

			tbl.setValueAt(tuoiSinhVien, row, 2);
		}
	};

	ActionListener btnInputClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	};
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

			int row1 = tbl.getSelectedRow();

			int col1 = 1;

			String s = (String) tbl.getValueAt(row1, col1);

			txtTSV.setText(s);
			int row0 = tbl.getSelectedRow();

			int col0 = 0;

			String x = (String) tbl.getValueAt(row0, col0);

			txtMSV.setText(x);
			int row2 = tbl.getSelectedRow();

			int col2 = 2;

			String z = (String) tbl.getValueAt(row2, col2);

			txtTuoiSV.setText(z);
		}
	};

	public QuanLiDanhSach(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương Trình Quản Lí Sinh Viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JPanel pnTitle1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Chọn Lớp");
		Font fontTitle1 = new Font("Arial", Font.BOLD, 20);
		lblTitle1.setFont(fontTitle1);
		pnTitle1.add(lblTitle1);
		String arr[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
		JComboBox<String> cbo = new JComboBox<String>(arr);
		pnTitle1.add(cbo);

		// Tạo panel User chứa dòng chữ Mã Sinh Viên và textbox Mã Sinh Viên
		JPanel pnMSV = new JPanel();
		JLabel lblMSV = new JLabel("Mã Sinh Viên:");
		txtMSV = new JTextField(15);
		pnMSV.add(lblMSV);
		pnMSV.add(txtMSV);
		// Tạo panel User chứa dòng chữ Tên Sinh Viên và textbox Tên Sinh Viên
		JPanel pnTSV = new JPanel();
		JLabel lblTSV = new JLabel("Tên Sinh Viên:");
		txtTSV = new JTextField(15);
		pnTSV.add(lblTSV);
		pnTSV.add(txtTSV);
		// Tạo panel User chứa dòng chữ Tên Sinh Viên và textbox Tên Sinh Viên
		JPanel pnTuoiSV = new JPanel();
		JLabel lblTuoiSV = new JLabel("Tuổi Sinh Viên:");
		txtTuoiSV = new JTextField(15);
		pnTuoiSV.add(lblTuoiSV);
		pnTuoiSV.add(txtTuoiSV);

		JPanel pnActions = new JPanel();

		pnActions.add(btnAdd);
		pnActions.add(btnEdit);
		pnActions.add(btnDelete);
		pnActions.add(btnInput);
		pnActions.add(btnExit);

		tableDSSV.addColumn("Mã SV");
		tableDSSV.addColumn("Tên SV");
		tableDSSV.addColumn("Tuổi");

		for (int i = 0; i < 5; i++) {
			tableDSSV.addRow(new String[] { "" + (i + 1), "Trần Văn T" + i, "20" });
		}

		tbl = new JTable(tableDSSV);
		JScrollPane sc = new JScrollPane(tbl);
		javax.swing.border.Border border=

				BorderFactory.createLineBorder(Color.RED);

				TitledBorder borderTitle=

				BorderFactory.createTitledBorder(

				border, "Danh sách");

				sc.setBorder(borderTitle);
		// add vào main
		pnMain.add(pnTitle);
		pnMain.add(pnTitle1);
		pnMain.add(pnMSV);
		pnMain.add(pnTSV);
		pnMain.add(pnTuoiSV);
		pnMain.add(pnActions);
		pnMain.add(sc);

		// add vào con
		con.add(pnMain);

	}

	public void addEvents() {
		btnAdd.addActionListener(btnAddClick);
		btnDelete.addActionListener(btnDeleteClick);
		btnEdit.addActionListener(btnEditClick);
		btnExit.addActionListener(btnExitClick);
		tbl.addMouseListener(tblUserClick);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
