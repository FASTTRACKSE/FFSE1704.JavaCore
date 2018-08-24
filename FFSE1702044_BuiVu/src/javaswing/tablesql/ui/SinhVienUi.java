	package javaswing.tablesql.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javaswing.qltable.dao.SinhVienDAO;
import javaswing.tablesql.untity.SinhVien;

public class SinhVienUi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnAdd = new JButton("Thêm");
	JButton btnEdit = new JButton("Sửa");
	JButton btnDelete = new JButton("Xóa");
	JButton btnRead = new JButton("Đọc");
	JButton btnExit = new JButton("Exit");
	JTextField txtTSV, txtHSV, txtNamSinh, txtIDSV;
	ButtonGroup group;
	JComboBox<String> cbo;
	JRadioButton rad1, rad2;
	JTable tbl;
	DefaultTableModel tableDSSV = new DefaultTableModel();
	ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public SinhVienUi(String title) {
		super(title);
		connectControls();
		addControls();
		addEvents();

	}

	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			sinhVienDAO.add(new SinhVien(txtHSV.getText(), txtTSV.getText(), gioiTinh(), txtNamSinh.getText(),
					cbo.getSelectedItem().toString()));
			for (int i = 1; i <= dsSV.size(); i++) {
				tableDSSV.removeRow(i);
			}
			/*
			 * tableDSSV.addRow(new String[] { "", txtHSV.getText(),
			 * txtTSV.getText(),gioiTinh(), txtNamSinh.getText(),
			 * cbo.getSelectedItem().toString() });
			 */

		}
	};
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int idKH = Integer.parseInt(txtIDSV.getText());
			tableDSSV.removeRow(tbl.getSelectedRow());
			sinhVienDAO.delete(idKH);
		}
	};
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String hoSinhVien = txtHSV.getText();
			String tenSinhVien = txtTSV.getText();
			String tuoiSinhVien = txtNamSinh.getText();

			int row = tbl.getSelectedRow();
			tbl.setValueAt(hoSinhVien, row, 1);

			tbl.setValueAt(tenSinhVien, row, 2);

			tbl.setValueAt(tuoiSinhVien, row, 4);

			SinhVien sv = new SinhVien(txtIDSV.getText(), hoSinhVien, tenSinhVien, tuoiSinhVien);
			sinhVienDAO.edit(sv);

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

			int row = tbl.getSelectedRow();

			String s = (String) tbl.getValueAt(row, 1);
			txtHSV.setText(s);
			;
			String x = (String) tbl.getValueAt(row, 2);
			txtTSV.setText(x);
			String z = (String) tbl.getValueAt(row, 4);
			txtNamSinh.setText(z);
			String id = (String) tbl.getValueAt(row, 0);
			txtIDSV.setText(id);
			txtIDSV.setEditable(false);

		}
	};

	public void connectControls() {
		sinhVienDAO.getConnect("localhost", "SinhVien", "sinhvien", "123456");
		if (sinhVienDAO.getConn() != null) {
			JOptionPane.showMessageDialog(null, "Kết Nối Thành Công!");
		} else {
			JOptionPane.showMessageDialog(null, "Kết Nối Thất Bại!");
		}
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương Trình Quản Lí Sinh Viên DB");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạp pnMain1 xét Layout của các ô Nhập
		JPanel pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.X_AXIS));

		JPanel pnIDSV = new JPanel();
		JLabel lblIDSV = new JLabel("ID  SV:");
		txtIDSV = new JTextField(7);
		pnIDSV.add(lblIDSV);
		pnIDSV.add(txtIDSV);

		// Panel Chứa Các Ô nhập dữ liệu
		JPanel pnHSV = new JPanel();
		JLabel lblHSV = new JLabel("Họ SV:");
		txtHSV = new JTextField(7);
		pnHSV.add(lblHSV);
		pnHSV.add(txtHSV);

		JPanel pnTSV = new JPanel();
		JLabel lblTSV = new JLabel("Tên SV:");
		txtTSV = new JTextField(10);
		pnTSV.add(lblTSV);
		pnTSV.add(txtTSV);

		JPanel pnNamSinh = new JPanel();
		JLabel lblNamSinh = new JLabel("NSinh SV:");
		txtNamSinh = new JTextField(12);
		pnNamSinh.add(lblNamSinh);
		pnNamSinh.add(txtNamSinh);

		JPanel pnTitle1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Chọn Lớp");
		Font fontTitle1 = new Font("Arial", Font.BOLD, 15);
		lblTitle1.setFont(fontTitle1);
		pnTitle1.add(lblTitle1);
		String arr[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
		cbo = new JComboBox<String>(arr);
		pnTitle1.add(cbo);

		// Tạo Radio box giới tính
		JPanel pnGioiTinh = new JPanel();

		pnGioiTinh.setLayout(new BoxLayout(pnGioiTinh, BoxLayout.X_AXIS));
		javax.swing.border.Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "Giới tính  :");
		pnGioiTinh.setBorder(titlebor);
		rad1 = new JRadioButton("Nam");
		rad2 = new JRadioButton("Nữ");

		group = new ButtonGroup();

		group.add(rad1);
		group.add(rad2);

		pnGioiTinh.add(rad1);
		pnGioiTinh.add(rad2);

		add(pnGioiTinh);

		// add Main1

		pnMain1.add(pnHSV);
		pnMain1.add(pnTSV);
		pnMain1.add(pnNamSinh);

		// Tạp pnMain1 xét Layout của các ô Nhập
		JPanel pnMain2 = new JPanel();
		pnMain2.setLayout(new BoxLayout(pnMain2, BoxLayout.X_AXIS));
		pnMain2.add(pnGioiTinh);
		pnMain2.add(pnTitle1);

		tableDSSV.addColumn("ID");
		tableDSSV.addColumn("Họ");
		tableDSSV.addColumn("Tên");
		tableDSSV.addColumn("Gender");
		tableDSSV.addColumn("Năm Sinh");
		tableDSSV.addColumn("Lớp");

		JPanel pnActions = new JPanel();

		pnActions.add(btnAdd);
		pnActions.add(btnEdit);
		pnActions.add(btnDelete);
		pnActions.add(btnRead);
		pnActions.add(btnExit);

		tbl = new JTable(tableDSSV);
		JScrollPane sc = new JScrollPane(tbl);
		javax.swing.border.Border border =

				BorderFactory.createLineBorder(Color.RED);

		TitledBorder borderTitle =

				BorderFactory.createTitledBorder(

						border, "Danh sách");

		sc.setBorder(borderTitle);
		dsSV = sinhVienDAO.getDSSinhVien();
		for (SinhVien x : dsSV) {
			tableDSSV.addRow(new String[] { x.getID(), x.getHoSV(), x.getTenSV(), x.getGenderSV(), x.getNamSinhSV(),
					x.getClassSV() });
		}

		// add main

		pnMain.add(pnTitle);
		pnMain.add(pnIDSV);
		pnMain.add(pnMain1);
		pnMain.add(pnMain2);
		pnMain.add(pnActions);

		pnMain.add(sc);

		// add vào con
		con.add(pnMain);
	}

	public String gioiTinh() {
		String bede = null;
		if (rad2.isSelected()) {
			bede = "Nữ";
		} else {
			bede = "Nam";
		}
		return bede;
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
