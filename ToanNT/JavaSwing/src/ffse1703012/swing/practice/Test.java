package ffse1703012.swing.practice;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Test(){
      prepareGUI();
   }

   public static void main(String[] args){
      Test  swingListenerDemo = new Test();  
      swingListenerDemo.showActionListenerDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Vi du Java Swing");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        

      statusLabel.setSize(350,100);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showActionListenerDemo(){
      headerLabel.setText("Listener in action: ActionListener");      

      JPanel panel = new JPanel();      
      panel.setBackground(Color.magenta);            
		
      JButton okButton = new JButton("OK");

      okButton.addActionListener(new CustomActionListener());        
      panel.add(okButton);
      controlPanel.add(panel);
      mainFrame.setVisible(true); 
   }
   
   class CustomActionListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
          statusLabel.setText("Ok Button Clicked.");
      }
   }	
}