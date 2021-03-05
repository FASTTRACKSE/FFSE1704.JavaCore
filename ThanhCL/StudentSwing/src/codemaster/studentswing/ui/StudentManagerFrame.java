package codemaster.studentswing.ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import codemaster.studentswing.business.Student;
import codemaster.studentswing.database.StudentDB;

@SuppressWarnings("serial")
public class StudentManagerFrame extends JFrame {
	private JTable studentTable;
	private StudentTableModel studentTableModel;
	private StudentForm studentForm;

	public StudentManagerFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println(e);
		}
		setTitle("Student Manager");
		setSize(768, 384);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(buildButtonPanel(), BorderLayout.SOUTH);
		studentTable = buildStudentTable();
		add(new JScrollPane(studentTable), BorderLayout.CENTER);
		
		studentForm = new StudentForm();
		add(studentForm, BorderLayout.EAST);

		setVisible(true);
	}

	private JPanel buildButtonPanel() {
		JPanel panel = new JPanel();

		JButton addButton = new JButton("Add");
		addButton.setToolTipText("Add student");
		addButton.addActionListener((ActionEvent) -> {
			doAddButton();
		});
		panel.add(addButton);

		JButton editButton = new JButton("Edit");
		editButton.setToolTipText("Edit selected student");
		editButton.addActionListener((ActionEvent) -> {
			doEditButton();
		});
		panel.add(editButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setToolTipText("Delete selected student");
		deleteButton.addActionListener((ActionEvent) -> {
			doDeleteButton();
		});
		panel.add(deleteButton);

		JButton printButton = new JButton("Print");
		printButton.setToolTipText("Print selected student");
		printButton.addActionListener((ActionEvent) -> {
			doPrintButton();
		});
		panel.add(printButton);
		return panel;
	}

	private void doAddButton() {
		JOptionPane.showMessageDialog(this, "This feature hasn't been implemented yet.", "Not yet implemented",
				JOptionPane.ERROR_MESSAGE);
	}

	private void doEditButton() {
		doAddButton();
	}

	private void doDeleteButton() {
		int selectedRow = studentTable.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "No student is currently selected.", "No student selected",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Student student = studentTableModel.getStudent(selectedRow);
			int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + student.getFirstName()
					+ " " + student.getLastName() + " from the database?", "Confirm delete", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					StudentDB.delete(student);
					studentTableModel.databaseUpdated();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private void doPrintButton() {
		int selectedRow = studentTable.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "No student is currently selected.", "No student selected",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "The selected student has been sent to the printer.", "Student printed",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void doLoadUser() {
		int selectedRow = studentTable.getSelectedRow();
		String studenID = studentTable.getValueAt(selectedRow, 0).toString();
		String studentName = studentTable.getValueAt(selectedRow, 1).toString();

		JOptionPane.showMessageDialog(this, studenID + " - " + studentName, "Student Info",
				JOptionPane.INFORMATION_MESSAGE);

	}

	private JTable buildStudentTable() {
		studentTableModel = new StudentTableModel();
		
		JTable table = new JTable(studentTableModel);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				doLoadUser();
			}
		});

		table.setBorder(null);

		return table;
	}
}