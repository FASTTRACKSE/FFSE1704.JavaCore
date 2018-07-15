package test.entity;

import javax.swing.*; 
import java.awt.*;​
import java.awt.event.*;

public class Demo extends JFrame{​

	  public MyWindow(){​

	   super("Demo Windows");​

	   setDefaultCloseOperation(EXIT_ON_CLOSE);​

	  }​

	  public static void main(String[] args) {​

	   MyWindow ui=new MyWindow();​

	   ui.setSize(400, 300);​

	   ui.setLocationRelativeTo(null);​

	   ui.setVisible(true);​

	  }​

	}​