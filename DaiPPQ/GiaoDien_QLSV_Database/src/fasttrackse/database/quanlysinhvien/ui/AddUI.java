package fasttrackse.database.quanlysinhvien.ui;

import java.awt.Color;
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

import fasttrackse.database.quanlysinhvien.dao.QuanLySinhVienDAO;
import fasttrackse.database.quanlysinhvien.entity.SinhVien;

public class AddUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JLabel lblHo;
	private JTextField txtHo;
	private JLabel lblTen;
	private JTextField txtTen;
	private JLabel lblNamSinh;
	private JTextField txtNamSinh;
	private JButton btnADD;
	private JButton btnReset;
	private JButton btnExit;
	DefaultTableModel dm;
	JTable tbl;
	JComboBox<String> classs;
	JComboBox<String> gender;

	public static QuanLySinhVienDAO sinhVienDAO = new QuanLySinhVienDAO();
	public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();

	public AddUI(String tieude) {
		super(tieude);
		addControls();
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ quản lý sinh viên fasttrack se
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Thêm Sinh Viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
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
		JLabel lblGender = new JLabel("Giới tính: ");
		gender = new JComboBox<String>();
		gender.addItem("Nam");
		gender.addItem("Nữ");
		pnlistGender.add(lblGender);
		pnlistGender.add(gender);
		
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
		btnADD = new JButton("THÊM");
		btnADD.setForeground(Color.BLUE);
		pnBox.add(btnADD);
		//btn1.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		// tao button Reset
		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.GRAY);
		pnBox.add(btnReset);
		//btn4.addActionListener(actionListener);
		JLabel pnkc4 = new JLabel("        ");
		pnBox.add(pnkc4);

		// tao button thoát
		btnExit = new JButton("THOÁT");
		btnExit.setForeground(Color.ORANGE);
		pnBox.add(btnExit);
		//btn5.addActionListener(actionListener);

		JPanel pnKCduoi = new JPanel();

		

		// add main panel vào container
		pnMain.add(pnTitle);
		//pnMain.add(pnID);
		pnMain.add(pnHo);
		pnMain.add(pnTen);
		pnMain.add(pnlistGender);
		pnMain.add(pnNamSinh);
		pnMain.add(pnlist);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		
		con.add(pnMain);

	}

	public void showWindow() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}