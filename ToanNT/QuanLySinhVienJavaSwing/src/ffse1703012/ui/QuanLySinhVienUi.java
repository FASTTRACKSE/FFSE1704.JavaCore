package ffse1703012.ui;

import ffse1703012.entity.*;
import ffse1703012.connect.*;
import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class QuanLySinhVienUi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<SinhVien> dsSv = new ArrayList<SinhVien>();
	static SinhVienDAO KetNoi = new SinhVienDAO();
	JTextField txtTen;
	JTextField txtMa;
	JTextField txtTuoi;
	JCheckBox chbo;
	JButton btnThem = new JButton("Thêm");
	JButton btnSua = new JButton("Sửa");
	JButton btnXoa = new JButton("Xóa");
	JButton btnThoat = new JButton("Thoát");
	JButton btnXoaTat = new JButton("Xóa tất");
	JTable tbl;
	DefaultTableModel dm;
	JComboBox<String> cbo;
	JRadioButton r1;
	JRadioButton r2;
	String gioiTinh;

	public QuanLySinhVienUi(String title) {
		super(title);
		connect();
		addControl();
		addEvent();
	}

	public void connect() {
		KetNoi.getConnect("localhost", "ffse1703012", "toan", "123");
		if (KetNoi.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	@SuppressWarnings("unused")
	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Title
		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		// lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// tạo Radiobox
		JPanel pnRbo = new JPanel();
		JLabel lblRbo = new JLabel("Giới Tính");
		r1 = new JRadioButton("Nam");
		r2 = new JRadioButton("Nữ");
		r1.setBounds(50, 100, 70, 30);
		r2.setBounds(50, 100, 70, 30);
		pnRbo.add(lblRbo);
		pnRbo.add(r1);
		pnRbo.add(r2);

		// Tạo Combobox
		JPanel pnCbo = new JPanel();
		JLabel lblCbo = new JLabel("Chọn lớp");
		cbo = new JComboBox<String>();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");

		pnCbo.add(lblCbo);
		pnCbo.add(cbo);

		// HOẶC CÓ THỂ LÀM THEO CÁCH NÀY
		// String arr[]= {"FFSE1701","FFSE1702","FFSE1703","FFSE1704"};
		// JComboBox cbo = new JComboBox(arr);
		// add(cbo);

		// Nhập Mã Sinh viên
		JPanel pnMa = new JPanel();
		JLabel lblMa = new JLabel("Nhập mã Sinh Viên:");
		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnTitle.add(lblTitle);

		// Nhập Tên Sinh Viên
		JPanel pnTen = new JPanel();
		JLabel lblTen = new JLabel("Nhập tên Sinh Viên:");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnTitle.add(lblTitle);

		// Nhập tuổi
		JPanel pnTuoi = new JPanel();
		JLabel lblTuoi = new JLabel("Nhập tuổi:");
		txtTuoi = new JTextField(20);
		pnTuoi.add(lblTuoi);
		pnTuoi.add(txtTuoi);

		// Thêm bảng
		JPanel pnTbl = new JPanel();
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Lớp");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Giới Tính");
		this.getTable();
		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTbl.setLayout(new BorderLayout());
		pnTbl.add(sc, BorderLayout.CENTER);

		// Các nút bấm
		JPanel pnButton = new JPanel();
		pnButton.add(btnThem);
		btnThem.addActionListener(actionListener);
		pnButton.add(btnSua);
		btnSua.addActionListener(actionListener);
		pnButton.add(btnXoa);
		btnXoa.addActionListener(actionListener);
		pnButton.add(btnXoaTat);
		btnXoaTat.addActionListener(actionListener);
		pnButton.add(btnThoat);
		btnThoat.addActionListener(actionListener);

		// Thêm các panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnCbo);
		pnMain.add(pnMa);
		pnMain.add(pnTen);
		pnMain.add(pnTuoi);
		pnMain.add(pnRbo);
		pnMain.add(pnButton);
		pnMain.add(pnTbl);
		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnThem) {
				nhapThongTin();
			} else if (e.getSource() == btnSua) {
				suaThongTin();
			} else if (e.getSource() == btnXoa) {
				xoaThongTin();
			} else if (e.getSource() == btnXoaTat) {
				xoaTatCaThongTin();
			} else if (e.getSource() == btnThoat) {
				thoatChuongTrinh();
			}
		}

	};

	public void nhapThongTin() {
		String lopSv = cbo.getSelectedItem().toString();
		String maSv = txtMa.getText();
		String tenSv = txtTen.getText();
		String tuoi = txtTuoi.getText();
		String gioiTinh = "";
		if (r1.isSelected()) {
			gioiTinh = r1.getText().toString();
		}
		if (r2.isSelected()) {
			gioiTinh = r2.getText().toString();
		}
		dm.addRow(new String[] { maSv, tenSv, tuoi,lopSv, gioiTinh });
		if(KetNoi.add(new SinhVien(maSv, tenSv, tuoi,lopSv, gioiTinh))) {
			JOptionPane.showMessageDialog(null, "Đã Lưu");

            //CLEAR TXT
            txtTen.setText("");
            txtMa.setText("");
            txtTuoi.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Lưu thất bại");
        }
		};



		public String ktgt() {
			String gioiTinh = "";
			if (r1.isSelected()) {
				gioiTinh = "Nam";
			}
			if (r2.isSelected()) {
				gioiTinh = "Nữ";
			}
			return gioiTinh;
			
		}

	public void suaThongTin() {
		String lopSv = cbo.getSelectedItem().toString();
		String maSv = txtMa.getText();
		String tenSv = txtTen.getText();
		String tuoi = txtTuoi.getText();
		String gioiTinh = ktgt() ;
		KetNoi.edit(new SinhVien(maSv,tenSv, tuoi ,lopSv, gioiTinh));
		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSv, row, 0);
		tbl.setValueAt(tenSv, row, 2);
		tbl.setValueAt(tuoi, row, 3);
		tbl.setValueAt(gioiTinh, row, 4);
		txtTen.setText("");
        txtMa.setText("");
        txtTuoi.setText("");
		

		
	}

	public void xoaThongTin() {
		String maSV = txtMa.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			dm.removeRow(rows[i] - i);
			if(KetNoi.delete(maSV)) {
				JOptionPane.showMessageDialog(null, "Xoá Thành Công!");
			}
		}
	}

	public void xoaTatCaThongTin() {

	}

	public void thoatChuongTrinh() {
		System.exit(0);
	}

	public void getTable() {
		dsSv = KetNoi.getDsSinhVien();
		for (int i = 0; i < dsSv.size(); i++) {
			dm.addRow(new String[] { dsSv.get(i).getMaSV(), dsSv.get(i).getLopSV(), dsSv.get(i).getTenSV(),
					dsSv.get(i).getTuoiSV(), dsSv.get(i).getGioiTinh() });
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
			txtMa.setText(maSV);
				
			String tenSV = (String) tbl.getValueAt(row, 2);
			txtTen.setText(tenSV);

			String tuoiSV = (String) tbl.getValueAt(row, 3);
			txtTuoi.setText(tuoiSV);
		}

	};

	public void showWindows() {
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
