package ffse1703012.practice.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JavaDesktop extends JFrame {
	/**
	 * 
	 */
	private int a;
	private int b;

	private static final long serialVersionUID = 1L;

	public JavaDesktop(String title) {
		super(title);
		addControl();
	}

	public JavaDesktop(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		JTextField txtResult;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	/**
	 * 
	 */

	public double giai() {
		return (-(double) this.a / this.b);
	}

	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// Title
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.RED);
		JLabel lblTitle = new JLabel("Giải phương trình bậc 1");
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Nhập số A
		JPanel pnSoA = new JPanel();
		JLabel lblSoA = new JLabel("Nhập số A:");
		JTextField txtSoA = new JTextField(20);
		pnSoA.add(lblSoA);
		pnSoA.add(txtSoA);
		pnTitle.add(lblTitle);
		// Nhập số B
		JPanel pnSoB = new JPanel();
		JLabel lblSoB = new JLabel("Nhập sô B:");
		JTextField txtSoB = new JTextField(20);
		pnSoB.add(lblSoB);
		pnSoB.add(txtSoB);
		pnTitle.add(lblTitle);

		// Các nút bấm
		JPanel pnButton = new JPanel();
		JButton btn1 = new JButton("Giải");
		JButton btn2 = new JButton("Thoát");
		JButton btn3 = new JButton("Trợ giúp");
		pnButton.add(btn1);
		pnButton.add(btn2);
		pnButton.add(btn3);
		JPanel pnKq = new JPanel();
		JLabel lblKq = new JLabel("Kết quả nè:");

		JTextField txtKq = new JTextField(20);
		txtKq.setEditable(false);
		pnKq.add(lblKq);
		pnKq.add(txtKq);
		pnTitle.add(lblTitle);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txtSoA.getText());
				int b = Integer.parseInt(txtSoB.getText());
				if (a == 0 && b == 0) {
					JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
				} else if (a == 0 && b != 0) {
					JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
				} else {
					JavaDesktop ass = new JavaDesktop(a, b);
					txtKq.setText("x = " + String.valueOf(ass.giai()));
				}

			}

		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Tro giup");
			}

		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		;

		// Thêm các panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnSoA);
		pnMain.add(pnSoB);
		pnMain.add(pnButton);
		pnMain.add(pnKq);
		con.add(pnMain);

	}

	public void showWindows() {
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
