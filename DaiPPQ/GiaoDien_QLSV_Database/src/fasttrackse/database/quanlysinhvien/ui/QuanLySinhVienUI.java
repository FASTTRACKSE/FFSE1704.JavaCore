package fasttrackse.database.quanlysinhvien.ui;

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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.database.quanlysinhvien.dao.QuanLySinhVienDAO;
import fasttrackse.database.quanlysinhvien.entity.SinhVien;

public class QuanLySinhVienUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JLabel lblMaSV;
	private JTextField txtMaSV;
	private JLabel lblHo;
	private JTextField txtHo;
	private JLabel lblTen;
	private JTextField txtTen;
	private JLabel lblNamSinh;
	private JTextField txtNamSinh;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnReset;
	private JButton btnExit;
	DefaultTableModel dm;
	JRadioButton radNam, radNu;
	JTable tbl;
	JComboBox<String> classs;
	JComboBox<String> gender;

	public static QuanLySinhVienDAO sinhVienDAO = new QuanLySinhVienDAO();
	public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

	public QuanLySinhVienUI(String tieude) {
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
			txtMaSV.setText(maSV);
			txtMaSV.setEnabled(false);
			
			String ho = (String) tbl.getValueAt(row, 1);
			txtHo.setText(ho);

			String ten = (String) tbl.getValueAt(row, 2);
			txtTen.setText(ten);

			String gtSV = (String) tbl.getValueAt(row, 3);
			if (gtSV.equals("Nam")) {
				radNam.setSelected(true);
			} else if (gtSV.equals("Nữ")){
				radNu.setSelected(true);
			}			
			
			String namSinh = (String) tbl.getValueAt(row, 4);
			txtNamSinh.setText(namSinh);
			
			String lopSV = (String) tbl.getValueAt(row, 5);
			classs.setSelectedItem(lopSV);
			
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);
			btnReset.setEnabled(true);
		}
	};

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ quản lý sinh viên fasttrack se
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Quản lý sinh viên FastTrack SE");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);		

		// Tạo panel pass chứa dòng chữ Ma sinh viên và textbox
		JPanel pnMaSV = new JPanel();
		lblMaSV = new JLabel("MaSV: ");
		txtMaSV = new JTextField(20);
		pnMaSV.add(lblMaSV);
		pnMaSV.add(txtMaSV);
		pnTitle.add(lblTitle);		
				
		// Tạo panel pass chứa dòng chữ họ sinh viên và textbox họ sinh viên
		JPanel pnHo = new JPanel();
		lblHo = new JLabel("Họ: ");
		txtHo = new JTextField(20);
		pnHo.add(lblHo);
		pnHo.add(txtHo);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ tên sinh viên và textbox tên sinh viên
		JPanel pnTen = new JPanel();
		lblTen = new JLabel("Tên: ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnTitle.add(lblTitle);


		// tao box gender cho giới tính sinh viên
		JPanel pnlistGender = new JPanel();
		pnlistGender.setLayout(new BoxLayout(pnlistGender, BoxLayout.X_AXIS));
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		TitledBorder lblGender = new TitledBorder(raisedBevel, "Giới tính");
		pnlistGender.setBorder(lblGender);
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		
		ButtonGroup group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		pnlistGender.add(radNam);
		pnlistGender.add(radNu);
		add(pnlistGender);
		radNam.setSelected(true);
		
		// Tạo panel pass chứa dòng chữ năm sinh và textbox năm sinh
		JPanel pnNamSinh = new JPanel();
		lblNamSinh = new JLabel("Năm sinh: ");
		txtNamSinh = new JTextField(20);
		pnNamSinh.add(lblNamSinh);
		pnNamSinh.add(txtNamSinh);
		pnTitle.add(lblTitle);
		
		// tao box class chọ lớp sinh viên
		JPanel pnlist = new JPanel();
		JLabel lblclass = new JLabel("Lớp: ");
		classs = new JComboBox<String>();
		classs.addItem("FFSE 1701");
		classs.addItem("FFSE 1702");
		classs.addItem("FFSE 1703");
		classs.addItem("FFSE 1704");
		pnlist.add(lblclass);
		pnlist.add(classs);		

		// tao button Thêm
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btnAdd = new JButton("THÊM");
		btnAdd.setForeground(Color.BLUE);
		pnBox.add(btnAdd);
		btnAdd.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// tao button Sửa
		btnEdit = new JButton("SỬA");
		btnEdit.setForeground(Color.RED);
		pnBox.add(btnEdit);
		btnEdit.addActionListener(actionListener);
		JLabel pnkc2 = new JLabel("        ");
		pnBox.add(pnkc2);
		btnEdit.setEnabled(false);

		// tao button XÓA
		btnDelete = new JButton("XÓA");
		btnDelete.setForeground(Color.GREEN);
		pnBox.add(btnDelete);
		btnDelete.addActionListener(actionListener);
		JLabel pnkc3 = new JLabel("        ");
		pnBox.add(pnkc3);
		btnDelete.setEnabled(false);

		// tao button Reset
		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.GRAY);
		pnBox.add(btnReset);
		btnReset.addActionListener(actionListener);
		JLabel pnkc4 = new JLabel("        ");
		pnBox.add(pnkc4);
		btnReset.setEnabled(false);

		// tao button thoát
		btnExit = new JButton("THOÁT");
		btnExit.setForeground(Color.ORANGE);
		pnBox.add(btnExit);
		btnExit.addActionListener(actionListener);

		JPanel pnKCduoi = new JPanel();

		// table
		dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Họ");
		dm.addColumn("Tên");
		dm.addColumn("Giới Tính");
		dm.addColumn("Năm Sinh");
		dm.addColumn("Lớp");
		this.getTable();
		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnMaSV);
		pnMain.add(pnHo);
		pnMain.add(pnTen);
		pnMain.add(pnlistGender);
		pnMain.add(pnNamSinh);
		pnMain.add(pnlist);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		pnMain.add(sc);
		
		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAdd) {
				nhapThongTin();
			}
			if (e.getSource() == btnEdit) {
				suaThongTin();
			}
			if (e.getSource() == btnDelete) {
				xoaThongTin();
			}
			if (e.getSource() == btnReset) {
				reset();
				
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnReset.setEnabled(false);	
				
				radNam.setSelected(true);
				classs.setSelectedItem("FFSE 1701");
			}
			if (e.getSource() == btnExit) {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình?", "Thoát", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		}
	};

	public void nhapThongTin() {
		String maSV = txtMaSV.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		String gioiTinh = gioiTinh();
		String namSinh = txtNamSinh.getText();
		String lop = classs.getSelectedItem().toString();
		
		sinhVienDAO.add(new SinhVien(maSV, ho, ten, gioiTinh, namSinh, lop));
		dm.addRow(new String[] { maSV, ho, ten, gioiTinh, namSinh, lop });
	}

	public void suaThongTin() {
		String maSV = txtMaSV.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		String gioiTinh = gioiTinh();
		String namSinh = txtNamSinh.getText();
		String lop = classs.getSelectedItem().toString();

		SinhVien sv = new SinhVien(maSV, ho, ten, gioiTinh, namSinh, lop);

		sinhVienDAO.edit(sv);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSV, row, 0);
		tbl.setValueAt(ho, row, 1);
		tbl.setValueAt(ten, row, 2);
		tbl.setValueAt(gioiTinh, row, 3);
		tbl.setValueAt(namSinh, row, 4);
		tbl.setValueAt(lop, row, 5);	
	}

	public String gioiTinh() {
		String gender;
		if (radNam.isSelected()) {
			gender = "Nam";
		} else {
			gender = "Nữ";
		}
		return gender;
	}
	
	public void xoaThongTin() {
		String maSV = txtMaSV.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			sinhVienDAO.delete(maSV);
			dm.removeRow(rows[i] - i);

		}
	}

	public void reset() {
		txtMaSV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtNamSinh.setText("");
	}

	public void getTable() {
		arr = sinhVienDAO.getDSSinhVien();
		for (int i = 0; i < arr.size(); i++) {
			dm.addRow(new String[] {arr.get(i).getMaSV(), arr.get(i).getHo(), arr.get(i).getTen(), 
					arr.get(i).getGioiTinh(), arr.get(i).getNamSinh(), arr.get(i).getLop() });
		}
	}

	public void showWindow() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}