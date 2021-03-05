package codemaster.studentswing.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import codemaster.studentswing.business.Student;

@SuppressWarnings("serial")
public class StudentForm extends JPanel {
	private JTextField idField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField birthdayField;
	private JTextField markLabField;
	private JTextField markTheoryField;

	private JButton updateButton;
	private JButton resetButton;
	Student student = new Student();

	public StudentForm() {
		componentInit();
	}

	private void componentInit() {
		idField = new JTextField();
		firstNameField = new JTextField();
		lastNameField = new JTextField();

		emailField = new JTextField();
		birthdayField = new JTextField();
		markLabField = new JTextField();
		markTheoryField = new JTextField();

		updateButton = new JButton();
		resetButton = new JButton();

		Dimension shortField = new Dimension(80, 20);
		Dimension longField = new Dimension(240, 20);

		idField.setPreferredSize(shortField);
		idField.setMinimumSize(shortField);
		idField.setEditable(false);

		firstNameField.setPreferredSize(longField);
		firstNameField.setMinimumSize(longField);

		lastNameField.setPreferredSize(longField);
		lastNameField.setMinimumSize(longField);

		emailField.setPreferredSize(longField);
		emailField.setMinimumSize(longField);

		birthdayField.setPreferredSize(longField);
		birthdayField.setMinimumSize(longField);

		markLabField.setPreferredSize(shortField);
		markLabField.setMinimumSize(shortField);

		markTheoryField.setPreferredSize(shortField);
		markTheoryField.setMinimumSize(shortField);

		updateButton.setText("Cancel");
		updateButton.addActionListener((ActionEvent) -> {
			updateButtonActionPerformed();
		});

		resetButton.setText("Add");
		resetButton.addActionListener((ActionEvent) -> {
			resetButtonActionPerformed();
		});

		// JLabel and JTextField panel
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridBagLayout());
		productPanel.add(new JLabel("ID:"), getConstraints(0, 0, GridBagConstraints.LINE_END));
		productPanel.add(idField, getConstraints(1, 0, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("First Name:"), getConstraints(0, 1, GridBagConstraints.LINE_END));
		productPanel.add(firstNameField, getConstraints(1, 1, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Last Name:"), getConstraints(0, 2, GridBagConstraints.LINE_END));
		productPanel.add(lastNameField, getConstraints(1, 2, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Email:"), getConstraints(0, 3, GridBagConstraints.LINE_END));
		productPanel.add(emailField, getConstraints(1, 3, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Birthday:"), getConstraints(0, 4, GridBagConstraints.LINE_END));
		productPanel.add(birthdayField, getConstraints(1, 4, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Theory:"), getConstraints(0, 5, GridBagConstraints.LINE_END));
		productPanel.add(markTheoryField, getConstraints(1, 5, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Lab:"), getConstraints(0, 6, GridBagConstraints.LINE_END));
		productPanel.add(markLabField, getConstraints(1, 6, GridBagConstraints.LINE_START));

		// JButton panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(updateButton);
		buttonPanel.add(resetButton);

		// add panels to main panel
		setLayout(new BorderLayout());
		add(productPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }

    private void resetButtonActionPerformed() {
		// TODO Auto-generated method stub

	}

	private void updateButtonActionPerformed() {
		// TODO Auto-generated method stub

	}

}
