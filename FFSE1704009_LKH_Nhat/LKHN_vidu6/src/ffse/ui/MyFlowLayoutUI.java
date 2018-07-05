package ffse.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFlowLayoutUI extends JFrame implements Serializable { // Is- a
	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblpass;
	private JTextField txtpass;
	private JLabel lblkq;
	private JTextField txtkq;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;// has - a

	public MyFlowLayoutUI(String tieude) {
		super(tieude);
		addControls();
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Tạo panel title chứa dòng chữ Chương trình giải phương trình bậc nhất
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("Chương trình giải phương trình bậc nhất");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel User chứa dòng chữ hệ số a
		JPanel pnUserInfo = new JPanel();
		lblUser = new JLabel("Hệ số a");
		txtUser = new JTextField(20);
		pnUserInfo.add(lblUser);
		pnUserInfo.add(txtUser);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ hệ số b và textbox hệ số b
		JPanel pnpass = new JPanel();
		lblpass = new JLabel("Hệ số b");
		txtpass = new JTextField(20);
		pnpass.add(lblpass);
		pnpass.add(txtpass);
		pnTitle.add(lblTitle);

		// Tạo panel pass chứa dòng chữ kết quả và textbox kết quả
		JPanel pnkq = new JPanel();
		lblkq = new JLabel("Kết quả");
		txtkq = new JTextField(20);
		txtkq.setEnabled(false);
		pnkq.add(lblkq);
		pnkq.add(txtkq);
		pnTitle.add(lblTitle);

		// tao button CACL
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		btn1 = new JButton("CACL");
		btn1.setForeground(Color.BLUE);
		pnBox.add(btn1);
		btn1.addActionListener(actionListener);
		JLabel pnkc = new JLabel("        ");
		pnBox.add(pnkc);
		
		// tao button EXIT
		btn2 = new JButton("EXIT");
		btn2.setForeground(Color.RED);
		pnBox.add(btn2);
		btn2.addActionListener(actionListener);
		JLabel pnkc2 = new JLabel("        ");
		pnBox.add(pnkc2);
		// btn2.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// System.out.println("buton 2");
		//
		// }
		// });
		
		
		// tao button HELP
		btn3 = new JButton("HELP");
		btn3.setForeground(Color.YELLOW);
		pnBox.add(btn3);
		btn3.addActionListener(actionListener);
	
		JPanel pnKCduoi = new JPanel();

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfo);
		pnMain.add(pnpass);
		pnMain.add(pnBox);
		pnMain.add(pnKCduoi);
		pnMain.add(pnkq);

		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn1) {
				tinhToan();
			}
			if (e.getSource() == btn2) {
				System.exit(0);
			}
			if (e.getSource() == btn3) {
				JOptionPane.showMessageDialog(null, "Hello Joker");
			}
		}
	};

	public void tinhToan() {
		String s1 = txtUser.getText();
		String s2 = txtpass.getText();
		float a = Float.parseFloat(s1);
		float b = Float.parseFloat(s2);
		String x;
		if (a == 0) {
			if (b == 0) {
				x = "Phương trình có vô số nghiệm";
			} else {
				x = "Phương trình vô nghiệm";
			}
		} else {
			x = Float.toString(-b / a);
		}
		txtkq.setText(x);

	}
	/*
	 * @Override public void actionPerformed(ActionEvent arg0) {
	 * 
	 * if (arg0.getSource() == btn1) { System.out.println("Ok"); } if
	 * (arg0.getSource() == btn3) { System.out.println("no Ok"); } }
	 */

	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
