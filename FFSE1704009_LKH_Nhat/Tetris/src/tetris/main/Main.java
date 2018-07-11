package tetris.main;

import javax.swing.SwingUtilities;

import tetris.ui.TetrisUI;

public class Main {

	public static void main(String[] args) {
		 
        SwingUtilities.invokeLater(new Runnable() {
             
            @Override
            public void run() {
                 
                TetrisUI game = new TetrisUI();
                game.setVisible(true);
            }
        });                
    } 

}
