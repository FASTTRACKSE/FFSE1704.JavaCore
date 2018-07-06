package fasttrackse.javacore.ui;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LoginUI extends JFrame {
	JButton btnLogin = new JButton("Thêm");
	JButton btnHelp = new JButton("Sửa");
	JButton btnExit = new JButton("Xóa");
	JButton btnOut = new JButton("Thoát");
	JButton btnImport = new JButton("Nhập");
	JTextField txtUser = new JTextField(20);
	JTable tbl;

	ActionListener btnHelpClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "#######");
		}
	};

	ActionListener btnOutClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Thoát hả?", "Thoát", JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
			}
			System.exit(0);
		}
	};

	ActionListener btnLoginClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ShowMessageHello();
		}
	};
	ActionListener btnExitClick = new ActionListener() {
	

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
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

			int col = 1;

			String s = (String) tbl.getValueAt(row, col);

			txtUser.setText(s);
		}
	};

	public void ShowMessageHello() {
		JOptionPane.showMessageDialog(null, "Xin chào bạn" + txtUser.getText() + "! Bạn đã nhập thành công!!!");
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

		// Chọn Lớp
		JPanel pnTitle1 = new JPanel();
		JLabel lblTitle1 = new JLabel("Chọn Lớp");
		Font fontTitle1 = new Font("Arial", Font.BOLD, 20);
		lblTitle1.setFont(fontTitle1);
		pnTitle1.add(lblTitle1);
		String arr[] = { "FFSE1701", "FFSE1702", "FFSE1703", "FFSE1704" };
		JComboBox<String> cbo = new JComboBox<String>(arr);
		pnTitle1.add(cbo);

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("Mã Sinh Viên:");
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnUserPass = new JPanel();
		JLabel lblPass = new JLabel("Tên Sinh Viên:");
		JTextField txtPass = new JTextField(20);
		pnUserPass.add(lblPass);
		pnUserPass.add(txtPass);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnAge = new JPanel();
		JLabel lblAge = new JLabel("Tuổi:");
		JTextField txtAge = new JTextField(20);
		pnAge.add(lblAge);
		pnAge.add(txtAge);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnActions = new JPanel();

		pnActions.add(btnLogin);
		pnActions.add(btnHelp);
		pnActions.add(btnExit);
		pnActions.add(btnOut);
		pnActions.add(btnImport);

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");

		for (int i = 0; i < 10; i++) {

			dm.addRow(new String[] { "" + (i + 1), "Trần Văn T" + i, "20" });

		}

		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh Sách");
		sc.setBorder(borderTitle);
		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnTitle1);
		pnMain.add(pnUserInfo);
		pnMain.add(pnUserPass);
		pnMain.add(pnAge);
		pnMain.add(pnActions);
		pnMain.add(sc);
		pnMain.add(pnTable);
		con.add(pnMain);
	}

	public void addEvents() {
		btnLogin.addActionListener(btnLoginClick);
		btnHelp.addActionListener(btnHelpClick);
		btnExit.addActionListener(btnExitClick);
		btnOut.addActionListener(btnOutClick);

		// btnImport.addActionListener(btnImportClick);
		tbl.addMouseListener(tblUserClick);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}