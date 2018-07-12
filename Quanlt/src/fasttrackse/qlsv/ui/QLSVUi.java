package fasttrackse.qlsv.ui;

import java.awt.BorderLayout;
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
import javax.xml.soap.Text;

import com.mysql.cj.jdbc.Driver;
import fasttrackse.qlsv.dao.QLSVDao;
import fasttrackse.qlsv.entity.SinhVien;

public class QLSVUi extends JFrame implements Serializable {
	QLSVDao dao = new QLSVDao();
	ArrayList<SinhVien> sv = new ArrayList();
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblmaSV;
	private JTextField txtmaSV;
	private JLabel lblhoSV;
	private JTextField txthoSV;
	private JLabel lbltenSV;
	private JTextField txttenSV;
	private JLabel lblgioitinhSV;
	private JTextField txtgioitinhSV;
	private JLabel lblnamsinhSV;
	private JTextField txtnamsinhSV;
	JRadioButton rb1, rb2;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;// has - a
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	DefaultTableModel dm;
	JTable tbl;
	JComboBox<String> classs;
	static String maSV;
	static String hoSV;
	static String tenSV;
	static String lopSV;
	static String namsinhSV;
	static String gioitinhSV;

	public QLSVUi(String tieude) {
		super(tieude);
		connectDB();
		addControls();
		addEvent();
	}

	public void connectDB() {
		dao = new QLSVDao();
		dao.getConnect("localhost", "qlsv", "letrongquan", "letrongquan");
		if (dao.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
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
			txtmaSV.setText(maSV);

			String hoSV = (String) tbl.getValueAt(row, 1);
			txthoSV.setText(hoSV);

			String tenSV = (String) tbl.getValueAt(row, 2);
			txttenSV.setText(tenSV);

			String namsinhSV = (String) tbl.getValueAt(row, 4);
			txtnamsinhSV.setText(namsinhSV);

		}
	};

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Chương trình giải phương trình bậc nhất
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Chương Trình Quản Lí Sinh Viên");
		lblTitle.setForeground(Color.RED);
		Font fontTitle = new Font("RixLoveFool", Font.BOLD, 30);
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

		JPanel pnMa = new JPanel();
		lblmaSV = new JLabel("Mã SV");
		txtmaSV = new JTextField(20);
		pnMa.add(lblmaSV);
		pnMa.add(txtmaSV);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ hệ số b và textbox hệ số b
		JPanel pnHo = new JPanel();
		lblhoSV = new JLabel("Họ đệm viên");
		txthoSV = new JTextField(20);
		pnHo.add(lblhoSV);
		pnHo.add(txthoSV);
		pnTitle.add(lblTitle);

		JPanel pnTen = new JPanel();
		lbltenSV = new JLabel("Tên sinh Viên");
		txttenSV = new JTextField(20);
		pnTen.add(lbltenSV);
		pnTen.add(txttenSV);
		pnTitle.add(lblTitle);

		JPanel gioitinh = new JPanel();
		lblgioitinhSV = new JLabel("Giới tính:");
		rb1 = new JRadioButton("Nam");
		rb1.setBounds(100, 50, 100, 30);

		rb2 = new JRadioButton("Nữ");
		rb2.setBounds(100, 100, 100, 30);
		add(gioitinh, BorderLayout.NORTH);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		gioitinh.add(lblgioitinhSV);
		gioitinh.add(rb1);
		gioitinh.add(rb2);

		JPanel pnNamsinh = new JPanel();
		lblnamsinhSV = new JLabel("Năm sinh sinh Viên");
		txtnamsinhSV = new JTextField(20);
		pnNamsinh.add(lblnamsinhSV);
		pnNamsinh.add(txtnamsinhSV);

		pnTitle.add(lblTitle);

		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btn1 = new JButton("THÊM");
		btn1.setForeground(Color.BLUE);
		btn1.setBackground(Color.WHITE);
		pnBox.add(btn1);
		btn1.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);

		btn2 = new JButton("SỬA");
		btn2.setForeground(Color.RED);
		btn2.setBackground(Color.WHITE);
		pnBox.add(btn2);
		btn2.addActionListener(actionListener);
		JLabel pnkc2 = new JLabel("        ");
		pnBox.add(pnkc2);

		btn3 = new JButton("XÓA");
		btn3.setForeground(Color.GREEN);
		btn3.setBackground(Color.WHITE);
		pnBox.add(btn3);
		btn3.addActionListener(actionListener);
		JLabel pnkc3 = new JLabel("        ");
		pnBox.add(pnkc3);

		btn4 = new JButton("Hiện DSSV");
		btn4.setForeground(Color.ORANGE);
		btn4.setBackground(Color.WHITE);
		pnBox.add(btn4);
		btn4.addActionListener(actionListener);
		JLabel pnkc4 = new JLabel("        ");
		pnBox.add(pnkc4);

		btn6 = new JButton("RESET");
		btn6.setForeground(Color.GRAY);
		btn6.setBackground(Color.WHITE);
		pnBox.add(btn6);
		btn6.addActionListener(actionListener);
		JLabel pnkc5 = new JLabel("        ");
		pnBox.add(pnkc5);

		btn5 = new JButton("THOÁT");
		btn5.setForeground(Color.WHITE);
		btn5.setBackground(Color.RED);
		pnBox.add(btn5);
		btn5.addActionListener(actionListener);

		JPanel pnKCduoi = new JPanel();

		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Họ");
		dm.addColumn("Tên");
		dm.addColumn("Giới Tính");
		dm.addColumn("Năm Sinh");
		dm.addColumn("Lớp");

		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);

		pnMain.add(pnTitle);
		pnMain.add(pnlist);
		pnMain.add(pnMa);
		pnMain.add(pnHo);
		pnMain.add(pnTen);
		pnMain.add(gioitinh);
		pnMain.add(pnNamsinh);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		pnMain.add(sc);
		con.add(pnMain);
		btn2.setVisible(false);
		btn3.setVisible(false);

	}

	public String gioitinh() {
		String gioitinhh;
		if (rb1.isSelected()) {

			return gioitinhh = "Nam";
		} else if (rb2.isSelected()) {
			return gioitinhh = "Nữ";
		} else {
			return gioitinhh = "null";
		}
	}

	private ButtonGroup ButtonGroup() {

		return null;
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
				showThongTin();
			}
			if (e.getSource() == btn5) {
				System.exit(0);
			}
			if (e.getSource() == btn6) {
				reset();
			}
		}
	};

	public void nhap() {
		maSV = txtmaSV.getText();
		hoSV = txthoSV.getText();
		tenSV = txttenSV.getText();
		lopSV = classs.getSelectedItem().toString();
		namsinhSV = txtnamsinhSV.getText();
		gioitinhSV = gioitinh();

	}

	public void nhapThongTin() {
		nhap();
		if (gioitinhSV != "null") {
			dao.add(new SinhVien(maSV, hoSV, tenSV, gioitinhSV, namsinhSV, lopSV));
			dm.addRow(new String[] { maSV, hoSV, tenSV, gioitinhSV, namsinhSV, lopSV });
			reset();
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính!");

		}
		btn2.setVisible(true);
		btn3.setVisible(true);
	}

	public void showThongTin() {
		sv = dao.getDSinhVien();
		for (int i = 0; i < sv.size(); i++) {
			dm.addRow(new String[] { sv.get(i).getMaSV(), sv.get(i).getHoSV(), sv.get(i).getTenSV(),
					sv.get(i).getGioitinhSV(), sv.get(i).getNamsinhSV(), sv.get(i).getLopSV() });

		}
		btn2.setVisible(true);
		btn3.setVisible(true);
	}

	public void suaThongTin() {

		nhap();
		
		if (gioitinhSV != "null") {
			SinhVien sv = new SinhVien(maSV, hoSV, tenSV, gioitinhSV, namsinhSV, lopSV);
			dao.update(sv);
			int row = tbl.getSelectedRow();
			tbl.setValueAt(maSV, row, 0);
			tbl.setValueAt(tenSV, row, 2);
			tbl.setValueAt(hoSV, row, 1);
			tbl.setValueAt(gioitinhSV, row, 3);
			tbl.setValueAt(namsinhSV, row, 4);
			tbl.setValueAt(lopSV, row, 5);

			reset();
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính!");
		}

	}

	public void xoaThongTin() {
		nhap();

		int[] rows = tbl.getSelectedRows();
		   for(int i=0;i<rows.length;i++){
		     dm.removeRow(rows[i]-i);
		   }
		
		
		dao.delete(new SinhVien(maSV, hoSV, tenSV, gioitinhSV, namsinhSV, lopSV));
		reset();
	}

	public void reset() {
		txtmaSV.setText("");
		txthoSV.setText("");
		txttenSV.setText("");
		txtnamsinhSV.setText("");
	}

	public void showWindow() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
