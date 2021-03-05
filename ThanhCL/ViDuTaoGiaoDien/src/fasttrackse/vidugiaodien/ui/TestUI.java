package fasttrackse.vidugiaodien.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import fasttrackse.vidugiaodien.main.ChuongTrinhXYZ;

public class TestUI extends JFrame {
	PanelTitle1 pnTitle1 = new PanelTitle1();
	PanelTitle2 pnTitle2 = new PanelTitle2();
	JPanel pnHead = new JPanel();
	JPanel pnTitle = new JPanel();

	JButton btnAdd = new JButton("Add");
	JButton btnEdit = new JButton("Edit");
	JButton btnRemove = new JButton("Remove");

	public TestUI(String title) {
		super(title + ChuongTrinhXYZ.theFunctionID);
		addControls();
		addEvents();
	}

	ActionListener btn1Click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pnTitle.removeAll();
			pnTitle.add(pnTitle1);
		}
	};

	ActionListener btn2Click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pnTitle.removeAll();
			pnTitle.add(pnTitle2);
		}
	};

	ActionListener btn3Click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			callTestUI();
		}
	};
	
	public void callTestUI() {
		ChuongTrinhXYZ.theFunctionID = 1;
		this.dispose();
		LoginUI myUI = new LoginUI("Go from TestUI - ");
		myUI.showWindow();
	}

	public void addControls() {
		// Nạp container và add main panel
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnHead.setLayout(new BoxLayout(pnHead, BoxLayout.Y_AXIS));

		JPanel pnAction = new JPanel();
		pnHead.add(pnTitle);

		JLabel lblTitle = new JLabel("Title of the App");
		pnTitle.add(lblTitle);


		pnAction.add(btnAdd);
		pnAction.add(btnEdit);
		pnAction.add(btnRemove);
		pnHead.add(pnAction);

		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel(new BorderLayout());
		String[] columnNames = { "A", "B", "C", "D", "E" };
		Object[][] data = new Object[20][columnNames.length];
		for (int i = 0; i < 20; i++) {
			data[i] = new Object[] { "Some other stuff that is long", "K", "1234567891011121314", "R", "T" };
		}

		JTable skillTable = new JTable(data, columnNames);
		skillTable.setFillsViewportHeight(true);
		JScrollPane scrollTable = new JScrollPane(skillTable);
		panel.add(scrollTable, BorderLayout.CENTER);
		
		TableColumnModel tcm = skillTable.getColumnModel();
		tcm.removeColumn( tcm.getColumn(2) );
		
		skillTable.getColumnModel().getColumn(3).setMinWidth(0);
		skillTable.getColumnModel().getColumn(3).setMaxWidth(0);

		// as you said you want to add a button as well
		JPanel buttonpanel = new JPanel();
		buttonpanel.add(new JButton("Test"));
		panel.add(buttonpanel, BorderLayout.SOUTH);

		pnMain.add(pnHead);
		pnMain.add(panel);
		con.add(pnMain);
	}

	public void addEvents() {
		btnAdd.addActionListener(btn1Click);
		btnEdit.addActionListener(btn2Click);
		btnRemove.addActionListener(btn3Click);
	}

	public void showWindow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
