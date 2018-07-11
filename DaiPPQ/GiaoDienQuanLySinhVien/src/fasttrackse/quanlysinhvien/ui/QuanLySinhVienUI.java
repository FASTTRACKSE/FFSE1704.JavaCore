package fasttrackse.quanlysinhvien.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class QuanLySinhVienUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelInput;
	private JTextField MaSV, TenSV, TuoiSV;
	private JComboBox cboLop;
	private JButton btnAdd, btnEdit, btnDel, btnExit, btnImport;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] columnNames = new String[] {"Mã", "Tên", "Tuổi" };
	private Object[][] data = null;
	private DefaultTableModel model = new DefaultTableModel(data, columnNames);
	DefaultTableModel dm = new DefaultTableModel();
	
	public QuanLySinhVienUI(String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public void showWindow() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		// Tạo panel title chứa dòng chữ Đăng nhập
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		
		// Tạo cửa sổ chọn lớp
		JPanel pnChonLop = new JPanel();
		JLabel lblClass = new JLabel("Chọn lớp: ");
		JComboBox setClass = new JComboBox();
		setClass.addItem("FFSE 1704001");
		setClass.addItem("FFSE 1704002");
		setClass.addItem("FFSE 1704003");
		setClass.addItem("FFSE 1704004");
		pnChonLop.add(lblClass);
		pnChonLop.add(setClass);
		
		// Tạo panel MaSV chứa dòng chữ Mã sinh viên và textbox MaSV
		JPanel pnMaSV = new JPanel();
		JLabel lblMaSV = new JLabel("Mã sinh viên: ");
		MaSV = new JTextField(15);
		pnMaSV.add(lblMaSV);
		pnMaSV.add(MaSV);
		
		// Tạo panel TenSV chứa dòng chữ Tên sinh viên và textbox TenSV
		JPanel pnTenSV = new JPanel();
		JLabel lblTenSV = new JLabel("Tên sinh viên: ");
		TenSV = new JTextField(15);
		pnTenSV.add(lblTenSV);
		pnTenSV.add(TenSV);
		
		// Tạo panel TuoiSV chứa dòng chữ Tuổi sinh viên và textbox TuoiSV
		JPanel pnTuoiSV = new JPanel();
		JLabel lblTuoiSV = new JLabel("Tuổi sinh viên: ");
		TuoiSV = new JTextField(15);
		pnTuoiSV.add(lblTuoiSV);
		pnTuoiSV.add(TuoiSV);
		
		// Tạo panel chứa các nút: Thêm, Sửa, Xóa, Thoát, Nhập
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Sửa");
		btnDel = new JButton("Xóa");
		btnExit = new JButton("Thoát");
		btnImport = new JButton("Nhập");
		
		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnDel);
		pnButton.add(btnExit);
		pnButton.add(btnImport);
		
		pnMain.add(pnButton);
		
		// Tạo panel chứa ô danh sách
		
		JLabel lblDSSV = new JLabel("Danh sách sinh viên: ");
		dm.addColumn("Mã sinh viên");
		dm.addColumn("Tên sinh viên");
		dm.addColumn("Tuổi");
		
		for (int i = 0; i < 10; i++) {
			dm.addRow(new String[] { "FFSE00"+ (i + 1), "Trần Văn T" + i, "20" });
		}
		
		table = new JTable(dm);		
		JScrollPane sc = new JScrollPane(table);
		
		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnChonLop);
		pnMain.add(pnMaSV);
		pnMain.add(pnTenSV);
		pnMain.add(pnTuoiSV);
		pnMain.add(pnButton);
		pnMain.add(sc);
		
		con.add(pnMain);		
	}
	
	public void addEvents() {
		btnAdd.addActionListener(btnAddClick);
		btnEdit.addActionListener(btnEditClick);
		btnDel.addActionListener(btnDelClick);
		btnExit.addActionListener(btnExitClick);
		btnImport.addActionListener(btnImportClick);
		table.addMouseListener(tableUserClick);
	}
	
	ActionListener btnAddClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String maSinhVien = TenSV.getText();
			String tenSinhVien = MaSV.getText();
			String tuoiSinhVien = TuoiSV.getText();

			model.addRow(new String[] { maSinhVien, tenSinhVien, tuoiSinhVien });
		}
	};
	
	ActionListener btnEditClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String maSinhVien = MaSV.getText();
			String tenSinhVien = TenSV.getText();
			String tuoiSinhVien = TuoiSV.getText();
			int row = table.getSelectedRow();
			table.setValueAt(maSinhVien,row, 0);
			table.setValueAt(tenSinhVien,row, 1);
			table.setValueAt(tuoiSinhVien,row, 2);
			
		}
	};
	
	ActionListener btnDelClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			if (row != -1) {
				model.removeRow(row);
				setText("", "", "");
			}
		}
	};
	
	ActionListener btnExitClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	ActionListener btnImportClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MaSV.setText("");
			TenSV.setText("");
			TuoiSV.setText("");	
		}
	};
	
	MouseListener tableUserClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();

			String maSV = (String) table.getValueAt(row, 0);
			MaSV.setText(maSV);
			
			String tenSV = (String) table.getValueAt(row, 1);
			TenSV.setText(tenSV);
			
			String tuoiSV = (String) table.getValueAt(row, 2);
			TuoiSV.setText(tuoiSV);
		}
	};
	
	private void setText(String maSV, String tenSV, String tuoiSV) {
		MaSV.setText(maSV);
		TenSV.setText(tenSV);
		TuoiSV.setText(tuoiSV);
	}
}