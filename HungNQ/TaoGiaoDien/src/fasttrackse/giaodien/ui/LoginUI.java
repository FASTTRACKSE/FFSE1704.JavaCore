package fasttrackse.giaodien.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class LoginUI extends JFrame {
	JButton btnLogin = new JButton("Nhập");
	JButton btnHelp = new JButton("Help");
	JButton btnThem = new JButton("Thêm");
	JButton btnSua = new JButton("Sửa");
	JButton btnXoa = new JButton("Xóa");
	JButton btnThoat = new JButton("Thoát");
	JButton btnNhap = new JButton("Nhập");
	JTextField txtTen = new JTextField(20);
	JTextField txtMa = new JTextField(20);
	JTextField txtTuoi = new JTextField(20);
	private DefaultTableModel dm = new DefaultTableModel(new Object[] {"Mã","Tên","Tuổi"}, 0);
	final JTable tbl = new JTable(dm);
	JScrollPane sc = new JScrollPane(tbl);

	ActionListener btnHelpClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Chương trình quản lý sinh viên");}};

	ActionListener btnThoatClick=new ActionListener(){public void actionPerformed(ActionEvent e){System.exit(0);}};

	ActionListener btLoginClick=new ActionListener(){public void actionPerformed(ActionEvent e){ShowMessageHello();}};

	MouseListener tblUserClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

	public void mouseClicked(MouseEvent e){

	int row=tbl.getSelectedRow();

	int col=1;

	String s=(String)tbl.getValueAt(row,col);

	txtTen.setText(s);}};

	public void ShowMessageHello() {
		JOptionPane.showMessageDialog(null, "Xin chào bạn " + txtTen.getText() + "! Login thành công!!!");
	}

	public LoginUI(String title) {
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
		JLabel lblTitle = new JLabel("Chương trình quản lý sinh viên");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		JLabel lblBo = new JLabel("Chọn lớp: ");
		JPanel pnbo = new JPanel();
		Font fontBo = new Font("Class", Font.BOLD, 15);
		lblBo.setFont(fontBo);
		pnbo.add(lblBo);
		JComboBox cbo = new JComboBox();
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		add(cbo);
		String arr[] = { "FFSE1701", "FFSE1702", "FFSE1703" , "FFSE1704"};

		pnbo.add(cbo);

		// Tạo panel Mã sinh viên chứa dòng chữ pass và textbox pass
		JPanel pnMaSV = new JPanel();
		JLabel lblMa = new JLabel("Mã Sinh Viên:");
		//JTextField txtMa = new JTextField(20);
		pnMaSV.add(lblMa);
		pnMaSV.add(txtMa);

		JPanel pnTenSV = new JPanel();
		JLabel lblTen = new JLabel("Tên Sinh Viên:");

		pnTenSV.add(lblTen);
		pnTenSV.add(txtTen);

		JPanel pnTuoiSV = new JPanel();
		JLabel lblTuoi = new JLabel("Tuổi:");
		//JTextField txtTuoi = new JTextField(20);
		pnTuoiSV.add(lblTuoi);
		pnTuoiSV.add(txtTuoi);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnActions = new JPanel();

		// Tạo các ô bấm
		pnActions.add(btnLogin);
		pnActions.add(btnHelp);
		pnActions.add(btnThem);
		pnActions.add(btnSua);
		pnActions.add(btnXoa);
		pnActions.add(btnThoat);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnbo);
		pnMain.add(pnMaSV);
		pnMain.add(pnTenSV);
		pnMain.add(pnTuoiSV);
		pnMain.add(pnActions);
		pnMain.add(sc);

		con.add(pnMain);
	}

	public void addEvents() {
		btnLogin.addActionListener(btLoginClick);
		btnHelp.addActionListener(btnHelpClick);
		btnThoat.addActionListener(btnThoatClick);
		tbl.addMouseListener(tblUserClick);
		btnThem.addActionListener(evenThem);
	}

	ActionListener evenThem = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] row = { txtMa.getText(), txtTen.getText(), txtTuoi.getText()
			};dm.addRow(row);}};

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}