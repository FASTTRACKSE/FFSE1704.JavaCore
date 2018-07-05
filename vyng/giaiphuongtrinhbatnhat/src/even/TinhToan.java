package even;

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

public class TinhToan extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JLabel lblUsera;
	private JTextField txtUsera;
	private JLabel lblUserb;
	private JTextField txtUserb;
	private JLabel lblkq;
	private JTextField txtkq;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;// has - a

	public TinhToan(String tieude) {
		super(tieude);
		addControls();
	}

	private void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// tạo panel dòng chứa hệ số a
		JPanel pnTitle = new JPanel();
		lblTitle = new JLabel("giải phương trình bật nhất ");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);

		// Tạo panel a chứa dòng chữ a và textbox a
		JPanel pnUserInfoa = new JPanel();
		lblUsera = new JLabel("hệ số a : ");
		txtUsera = new JTextField(20);
		pnUserInfoa.add(lblUsera);
		pnUserInfoa.add(txtUsera);
		pnTitle.add(lblTitle);

		// Tạo panel b chứa dòng chữ b và textbox b
		JPanel pnUserInfob = new JPanel();
		lblUserb = new JLabel("hệ số b : ");
		txtUserb = new JTextField(20);
		pnUserInfob.add(lblUserb);
		pnUserInfob.add(txtUserb);
		pnTitle.add(lblTitle);

		// tạo buttron

		JPanel pnFlow = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		btn1 = new JButton("calc ");
		btn2 = new JButton("exit");
		btn3 = new JButton("hellp");
		pnFlow.add(btn1);
		btn1.addActionListener(actionListener);
		pnFlow.add(btn2);
		btn2.addActionListener(actionListener);
		pnFlow.add(btn3);
		btn3.addActionListener(actionListener);

		// Tạo panel kq chứa dòng chữ kq và textbox kq
		JPanel pnUserInfokq = new JPanel();
		lblkq = new JLabel("kết quả : ");
		txtkq = new JTextField(20);
		pnUserInfokq.add(lblkq);
		pnUserInfokq.add(txtkq);
		pnTitle.add(lblTitle);

		// add main panel vào container
		pnMain.add(pnTitle);
		pnMain.add(pnUserInfoa);
		pnMain.add(pnUserInfob);
		pnMain.add(pnFlow);
		pnMain.add(pnUserInfokq);

		con.add(pnMain);

	}

	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn1) {
				calc();
			}
			if (e.getSource() == btn2) {
				System.exit(0);
			}
			if (e.getSource() == btn3) {
				JOptionPane.showMessageDialog(null, "xin mời thử lại chương trình");
			}
		}
	};

	private void calc() {
		String s1 = txtUsera.getText();
		String s2 = txtUserb.getText();
		float a = Float.parseFloat(s1);
		float b = Float.parseFloat(s2);
		String x;
		if (a == 0) {
			if (b == 0) {
				x = "phương trinh có số vô nghiệm";
			} else {
				x = "phương trinh vô nghiệm";
			}
		} else {
			x = Float.toHexString(b / a);
		}
		txtkq.setText(x);
	}

	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
