package ffse.joker;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ffse.ui.MyFlowLayoutUI;

public class Test extends JFrame{

	private JFrame frame;
	private JTextField textUser;
	private JPasswordField txtPass;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Test() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 312, 287);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(25, 75, 77, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(25, 113, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textUser = new JTextField();
		textUser.setBounds(103, 72, 119, 20);
		frame.getContentPane().add(textUser);
		textUser.setColumns(10);

		JCheckBox Remember = new JCheckBox("Ghi nhớ pass");
		Remember.setBounds(41, 143, 164, 23);
		frame.getContentPane().add(Remember);

		JLabel lblMessager = new JLabel("");
		lblMessager.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessager.setBounds(21, 208, 265, 26);
		frame.getContentPane().add(lblMessager);

		JButton btnLogin = new JButton("Login");
		

		
		
		btnLogin.setBounds(62, 173, 71, 23);
		frame.getContentPane().add(btnLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 26));
		lblLogin.setBounds(103, 11, 68, 40);
		frame.getContentPane().add(lblLogin);

		txtPass = new JPasswordField();
		txtPass.setBounds(103, 110, 119, 20);
		frame.getContentPane().add(txtPass);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
				txtPass.setText("");
				lblMessager.setText("");
				Remember.setSelected(false);

			}
		});
		btnReset.setBounds(170, 173, 71, 23);
		frame.getContentPane().add(btnReset);

	}
}