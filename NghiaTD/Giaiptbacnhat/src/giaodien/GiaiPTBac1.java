package giaodien;
import java.awt.*;
import ui.LoginUI;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

import ui.LoginUI;
public class GiaiPTBac1 extends JFrame {
	public GiaiPTBac1(){
		   super("Login");
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUI myLoginUI = new LoginUI("Màn hình login");
		myLoginUI.showWindow();
	}

}
