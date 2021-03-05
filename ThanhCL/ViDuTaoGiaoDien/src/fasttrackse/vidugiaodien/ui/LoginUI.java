package fasttrackse.vidugiaodien.ui;

import java.awt.Container;
import java.awt.Font;

import java.awt.event.*;
import javax.swing.event.*;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import fasttrackse.vidugiaodien.main.ChuongTrinhXYZ;

public class LoginUI extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton btnLogin = new JButton("Info");
	JButton btnHelp = new JButton("Help");
	JButton btnExit = new JButton("Exit");
	JTextField txtUser = new JTextField(20);
	JTextField txtPass = new JTextField(20);
	JRadioButton optGioiTinhNam = new JRadioButton("Nam");
	JRadioButton optGioiTinhNu = new JRadioButton("Nữ");
	ButtonGroup grpGioiTinh = new ButtonGroup();
	String gioiTinh = "";

	JTable tbl;

	ListSelectionListener tblSelectChangeEvent = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent event) {
			updateSelectedStudent();
		}
	};

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

	ItemListener optGioiTinhNamEvent = new ItemListener() {
		public void itemStateChanged(ItemEvent event) {
			int state = event.getStateChange();
			if (state == ItemEvent.SELECTED) {
				gioiTinh = "Nam";
			} else if (state == ItemEvent.DESELECTED) {
				//
			}
		}
	};

	ItemListener optGioiTinhNuEvent = new ItemListener() {
		public void itemStateChanged(ItemEvent event) {
			int state = event.getStateChange();
			if (state == ItemEvent.SELECTED) {
				gioiTinh = "Nữ";
			} else if (state == ItemEvent.DESELECTED) {
				//
			}
		}
	};

	public void updateSelectedStudent() {
		int row = tbl.getSelectedRow();

		String sName = (String) tbl.getValueAt(row, 1);
		String sTuoi = (String) tbl.getValueAt(row, 2);
		String sGioiTinh = (String) tbl.getValueAt(row, 3);

		txtUser.setText(sName);
		txtPass.setText(sTuoi);
		if (sGioiTinh.equals("Nam")) {
			optGioiTinhNam.setSelected(true);
		} else if (sGioiTinh.equals("Nữ")) {
			optGioiTinhNu.setSelected(true);
		}
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

			updateSelectedStudent();
		}
	};

	public void ShowMessageHello() {
		String internalGioiTinh = "";

		for (Enumeration<AbstractButton> buttons = grpGioiTinh.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				internalGioiTinh = button.getText();
			}
		}

		if (grpGioiTinh.getSelection() != null) {
			JOptionPane.showMessageDialog(null,
					"Xin chào bạn " + txtUser.getText() + "\n Tuổi: " + txtPass.getText() + "\n Giới tính (1): "
							+ grpGioiTinh.getSelection().getActionCommand() + "\n Giới tính (2): " + internalGioiTinh
							+ "\n Giới tính (3): " + gioiTinh + "\n Login thành công!!!");
		}
	}

	public LoginUI(String title) {
		super(title + ChuongTrinhXYZ.theFunctionID);
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
		JLabel lblUser = new JLabel("Họ tên:");
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnUserPass = new JPanel();
		JLabel lblPass = new JLabel("Tuổi:");
		pnUserPass.add(lblPass);
		pnUserPass.add(txtPass);

		// Tạo panel Giới tính
		JPanel pnGioiTinh = new JPanel();
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		pnGioiTinh.add(lblGioiTinh);
		optGioiTinhNam.setActionCommand("Nam");
		optGioiTinhNu.setActionCommand("Nữ");
		pnGioiTinh.add(optGioiTinhNam);
		pnGioiTinh.add(optGioiTinhNu);
		grpGioiTinh.add(optGioiTinhNam);
		grpGioiTinh.add(optGioiTinhNu);

		// Tạo panel User chứa dòng chữ pass và textbox pass
		JPanel pnActions = new JPanel();

		pnActions.add(btnLogin);
		pnActions.add(btnHelp);
		pnActions.add(btnExit);

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Giới tính");

		for (int i = 0; i < 100; i++) {
			int iGioiTinh = (int) Math.round(Math.random());
			String gioiTinh = "Nam";
			if (iGioiTinh == 1) {
				gioiTinh = "Nữ";
			}

			dm.addRow(new String[] { "" + (i + 1), "Trần Văn T" + (i + 1), "" + ((int) (Math.random() * 10) + 20),
					"" + gioiTinh });
		}

		tbl = new JTable(dm);
		JScrollPane pnTableUser = new JScrollPane(tbl);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnUserPass);
		pnMain.add(pnGioiTinh);
		pnMain.add(pnActions);
		pnMain.add(pnTableUser);

		con.add(pnMain);
	}

	public void addEvents() {
		btnLogin.addActionListener(btLoginClick);
		btnHelp.addActionListener(btnHelpClick);
		btnExit.addActionListener(btnExitClick);
		tbl.addMouseListener(tblUserClick);
		tbl.getSelectionModel().addListSelectionListener(tblSelectChangeEvent);
		optGioiTinhNam.addItemListener(optGioiTinhNamEvent);
		optGioiTinhNu.addItemListener(optGioiTinhNuEvent);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
