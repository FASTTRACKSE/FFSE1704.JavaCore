package tetris.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


import tetris.entyti.Board;

public class TetrisUI extends JFrame {
	private JLabel statusbar;

	public TetrisUI() {

		addControls();
	}

	public JLabel getStatusBar() {

		return statusbar;
	}

	private void addControls() {

		statusbar = new JLabel();
		add(statusbar, BorderLayout.SOUTH);
		Board board = new Board(this);
		add(board);
		board.start();

		setSize(300, 500);
		setTitle("Tetris by Joker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	

}
