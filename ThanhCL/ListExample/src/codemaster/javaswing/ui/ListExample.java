package codemaster.javaswing.ui;

import javax.swing.*;  
import java.awt.event.*;  

public class ListExample {
	ListExample() {
		JFrame f = new JFrame();
		
        final JLabel label = new JLabel();          
        label.setSize(500,100);  
        JButton b=new JButton("Show");  
        b.setBounds(200,150,80,30);  

        DefaultListModel<Item> l1 = new DefaultListModel<Item>();
		l1.addElement(new Item(1, "1 - Item1"));
		l1.addElement(new Item(2, "2 - Item2"));
		l1.addElement(new Item(3, "3 - Item3"));
		l1.addElement(new Item(4, "4 - Item4"));
		JList<Item> list = new JList<Item>(l1);
		list.setBounds(100, 100, 75, 75);
		
        f.add(list); f.add(b); f.add(label);  

		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
				
        b.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {   
               String data = "";  
               
               if (list.getSelectedIndex() != -1) {                       
                  data = ""; //Item Selected: " + list.getSelectedValue(); 
                  for(int i = 0; i< list.getModel().getSize();i++){
                      data += ((Item)list.getModel().getElementAt(i)).getId() + ";";
                  }
                  label.setText(data);  
               }  
            }  
         });   

	}

	class Item {
		private int id;
		private String description;

		public Item(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		public String toString() {
			return description;
		}
	}

	public static void main(String args[]) {
		new ListExample();
	}
}