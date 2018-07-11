package javaswing.giaiptbac1.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPTB1 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnMain, pnHeSoA, pnHeSoB, pnMain1;
	private JTextField txtHeSoA, txtHeSoB, txtHeSoKQ;
	private JButton jButton1, jButton2, jButton3;

	public GiaiPTB1(String title) {
		super(title);
		addControls();
	}

	public void addControls() {
		// Nạp container và add vào main panel
		java.awt.Container con = getContentPane();

		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		// Tạo panel title chứa dòng chữ Chương Trình Giải PT bậc 1
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.LIGHT_GRAY);
		JLabel lblTitle = new JLabel("Chương Trình Giải PT bậc 1");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		// Tạo panel User chứa dòng chữ Hệ Số A
		pnHeSoA = new JPanel();
		JLabel lblHeSoA = new JLabel("Hệ Số A:");
		txtHeSoA = new JTextField(15);
		pnHeSoA.add(lblHeSoA);
		pnHeSoA.add(txtHeSoA);
		pnMain.add(pnHeSoA);

		// Tạo panel User chứa dòng chữ Hệ Số B
		pnHeSoB = new JPanel();
		JLabel lblHeSoB = new JLabel("Hệ Số B:");
		txtHeSoB = new JTextField(15);
		pnHeSoB.add(lblHeSoB);
		pnHeSoB.add(txtHeSoB);
		pnMain.add(pnHeSoB);
		// tẠO BUTTON

		pnMain1 = new JPanel();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.X_AXIS));
		jButton1 = new JButton();
		jButton1.setText("Calc");
		jButton1.addActionListener(this);
		jButton2 = new JButton();
		jButton2.setText("Exit");
		jButton2.addActionListener(this);
		jButton3 = new JButton();
		jButton3.setText("Help");
		jButton3.addActionListener(this);
		
		JLabel jButton31 = new JLabel("       ");
		JLabel jButton32 = new JLabel("       ");
		pnMain1.add(jButton1);
		pnMain1.add(jButton32);
		pnMain1.add(jButton2);
		pnMain1.add(jButton31);
		pnMain1.add(jButton3);
		
		pnMain.add(pnMain1);

		// Ô kết Quả
		JPanel pnHeSoKQ = new JPanel();
		JLabel lblHeSoKQ = new JLabel("Kết Quả");
		txtHeSoKQ = new JTextField(15);
		pnHeSoKQ.add(lblHeSoKQ);
		pnHeSoKQ.add(txtHeSoKQ);
		pnMain.add(pnHeSoKQ);
		
		// add vào con

		con.add(pnMain);
	}

	// Các Action
	public void actionPerformed(ActionEvent x) {

		float c = 0;
		
		if (x.getSource() == jButton1) {
			String s1 = txtHeSoA.getText();
			String s2 = txtHeSoB.getText();
			float a = Integer.parseInt(s1);
			float b = Integer.parseInt(s2);

			c = -(b) / a;
		} else if (x.getSource() == jButton2) {
			System.exit(0);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Nhập a,b và ấn Calc\n để tính Phương Trình Bậc 1");
		}
		String result = String.valueOf(c);
		txtHeSoKQ.setText(result);

	};

	public void showWindow() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
