/**
 *	Prog: Login
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 03/07/2018
 */

package fasttrackse.giaodien.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {
	public Login() {
		super("Dome Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void name(String[] args) {
		Login ui = new Login();
		ui.setSize(400, 300);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}
}
