/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.quanly.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import fasttrackse.quanlymayatm.quanly.entity.Admin;
/**
 * @author QuangDai
 *
 */
public class LoginUI extends JFrame implements Serializable {
	
	JTextField User = new JTextField(20), Pass = new JTextField(20);
	JButton okButton = new JButton("Login"), exitButton = new JButton("Exit");
	JTable table;	

	public LoginUI (String tieude) {
		super(tieude);
		addControls();
	}
	
	public void addControls() {			
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		// Phần giao diện đăng nhập quản lý máy ATM cho người quản lý
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new GridBagLayout());
		// add Label vào pnTab1
		addItem(pnTab1, new JLabel("User: "), 0, 0, 1, 1, GridBagConstraints.WEST);
	    addItem(pnTab1, new JLabel("Pass: "), 0, 1, 1, 1, GridBagConstraints.WEST);
	    // add TextField vào pnTab1
	    addItem(pnTab1, User, 1, 0, 1, 1, GridBagConstraints.WEST);
	    addItem(pnTab1, Pass, 1, 1, 1, 1, GridBagConstraints.WEST);
	    // add Button vào pnTab1    
	    Box buttonBox = Box.createHorizontalBox();
	    buttonBox.add(okButton);
	    okButton.addActionListener(actionListener);
	    buttonBox.add(Box.createHorizontalStrut(20));
	    buttonBox.add(exitButton);
	    exitButton.addActionListener(actionListener);
	    addItem(pnTab1, buttonBox, 1, 2, 1, 1, GridBagConstraints.EAST);
		// add pnTab1(Label, textField, Button) vào pnMain
	    pnMain.add(pnTab1);					
					
		// add myTabled vào container
		con.add(pnMain);
		
	}
	
	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
	    GridBagConstraints gc = new GridBagConstraints();
	    gc.gridx = x;
	    gc.gridy = y;
	    gc.gridwidth = width;
	    gc.gridheight = height;
	    gc.insets = new Insets(5, 5, 5, 5);
	    gc.anchor = align;
	    gc.fill = GridBagConstraints.NONE;
	    p.add(c, gc);
	}
	
	public void CloseFrame() {
		super.dispose();
	}
	
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okButton) {
				if (User.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập Username");
				} else if (Pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập PassWord");
				} else {	
					String user = User.getText();
					String pass = Pass.getText();
					try {
						String Url = "jdbc:mysql://localhost/ql_atm";
						Connection conn = DriverManager.getConnection(Url, "mido", "0933237480");
						String queryString = "SELECT * FROM ql_atm_admin WHERE User = ? AND Pass = ?";
						java.sql.PreparedStatement Statement = conn.prepareStatement(queryString);
						Statement.setString(1, user);
						Statement.setString(2, pass);
						ResultSet result = Statement.executeQuery();
						if (result.next()) {
							QuanLyUI myQuanLyUI = new QuanLyUI("Quan Ly Máy ATM");
							myQuanLyUI.showWindow();
							CloseFrame();
						} else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
							User.setText("");
							Pass.setText("");
						}
					} catch (SQLException e1) {
					}
				}
			}
			if (e.getSource() == exitButton) {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình ?", "Thoát", JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		}
	};
	
	public void showWindow() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
