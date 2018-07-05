package fasttrackse.vidugiaodien.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoginUI extends JFrame {
	JButton btnLogin = new JButton("Login");
	JButton btnHelp = new JButton("Help");
	JButton btnExit = new JButton("Exit");
	JTextField txtUser = new JTextField(20);
	JTable tbl;

	ActionListener btnHelpClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Chương trình quản lý XYZ");
		}
	};

	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	ActionListener btLoginClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ShowMessageHello();
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
		JOptionPane.showMessageDialog(null, "Xin chào bạn " + txtUser.getText() + "! Login thành công!!!");
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
		JLabel lblTitle = new JLabel("Đăng nhập chương trình XYZ");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ user và textbox user
		JPanel pnUserInfo = new JPanel();
		JLabel lblUser = new JLabel("User:");
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnUserPass = new JPanel();
		JLabel lblPass = new JLabel("Password:");
		JTextField txtPass = new JTextField(20);
		pnUserPass.add(lblPass);
		pnUserPass.add(txtPass);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnActions = new JPanel();

		pnActions.add(btnLogin);
		pnActions.add(btnHelp);
		pnActions.add(btnExit);

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");

		for (int i = 0; i < 100; i++) {
			dm.addRow(new String[] { "" + (i + 1), "Trần Văn T" + i, "20" });
		}
		
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnUserPass);
		pnMain.add(pnActions);
		pnMain.add(sc);

		con.add(pnMain);
	}

	public void addEvents() {
		btnLogin.addActionListener(btLoginClick);
		btnHelp.addActionListener(btnHelpClick);
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
