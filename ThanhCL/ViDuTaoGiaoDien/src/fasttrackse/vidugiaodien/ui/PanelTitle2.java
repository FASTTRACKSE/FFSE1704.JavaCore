package fasttrackse.vidugiaodien.ui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTitle2 extends JPanel {
	public PanelTitle2() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.BLUE);
		
		JPanel pnTitleHead1 = new JPanel();
		JLabel lblTitle = new JLabel("Title of the App");
		pnTitleHead1.add(lblTitle);
		
		JPanel pnTitleHead2 = new JPanel();
		JLabel lblText1 = new JLabel("Label 1");
		JTextField txtText1 = new JTextField(10);
		pnTitleHead2.add(lblText1);
		pnTitleHead2.add(txtText1);
		
		this.add(pnTitleHead1);
		this.add(pnTitleHead2);
	}
}
