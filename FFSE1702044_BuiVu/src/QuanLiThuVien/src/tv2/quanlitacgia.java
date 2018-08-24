package QuanLiThuVien.src.tv2;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class quanlitacgia extends JFrame implements ActionListener,
		MouseListener {
	Connection conn;
	Statement stm;
	ResultSet rst;
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	JScrollPane tableResult;
	DefaultTableModel model;
	JTable tb = new JTable();
	JButton edit, delete, insert;
	int selectrow = 0;

	public quanlitacgia(String s) {
		super(s);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/quanlithuvien","quanlithuvien", "123123");
			stm = conn.createStatement();
			JPanel p = new JPanel();
			edit = new JButton("Edit", new ImageIcon("image/sua1.png"));
			edit.addActionListener(this);
			delete = new JButton("Delete", new ImageIcon("image/xoa1.png"));
			delete.addActionListener(this);
			insert = new JButton("Insert", new ImageIcon("image/them1.png"));
			insert.addActionListener(this);
			p.add(edit);
			p.add(delete);
			p.add(insert);
			this.add(p,"South");
			reload();
			model = new DefaultTableModel(vData, vTitle);
			tb = new JTable(model);
			tb.addMouseListener(this);
			tableResult = new JScrollPane(tb);
			this.getContentPane().add(tableResult, "North");
			this.setSize(500,500);
			this.setLocation(200, 500);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public void reload() {
		try {
			vTitle.clear();
			vData.clear();
			ResultSet rst = stm.executeQuery("select * from tacgia");
			ResultSetMetaData rstmeta = rst.getMetaData();
			int num_column = rstmeta.getColumnCount();
			for(int i = 1; i<=num_column;i++)
			{
				vTitle.add(rstmeta.getColumnLabel(i));
			}
			
			while (rst.next())
			{
				Vector row = new Vector(num_column);
				for(int i = 1; i<=num_column;i++)
					row.add(rst.getString(i));
				vData.add(row);
			}
			rst.close();
		} catch (Exception e) {
		}
	}

	// thao tac xoa du lieu voi button delete
	public void delete() {
		try {
			Vector st = (Vector)vData.elementAt(selectrow);
			String sql = "Delete from tacgia where matacgia = \""+st.elementAt(0) + "\"";
			stm.executeUpdate(sql);
			
			vData.remove(selectrow);
			
			model.fireTableDataChanged();
		} catch (Exception e) {
		}
	}

	public void actionPerformed(ActionEvent e) {
		// khi an delete
		if (e.getActionCommand().equals("Delete")) {
			delete();

		}
		// khi an insert
		if (e.getActionCommand().equals("Insert"))
		{
			// cua so nhap moi
			new UpdateForm9("Insert form", this,"","","","","","");
		}
		// khi an edit

		if (e.getActionCommand().equals("Edit")) {
			Vector st = (Vector)vData.elementAt(selectrow);
			
			new UpdateForm9("Edit form",this,(String)st.elementAt(0),(String)st.elementAt(1),(String)st.elementAt(2),(String)st.elementAt(3),(String)st.elementAt(4),(String)st.elementAt(5));
		}
		}
	
	public void mouseClicked(MouseEvent e) {
		selectrow = tb.getSelectedRow();
	}

	public static void main(String[] args) {
		new quanlitacgia("quanlitacgia");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class UpdateForm9 extends JFrame implements ActionListener {
	JLabel matacgialb;
	JTextField matacgia;
	
	JLabel tentacgialb;
	JTextField tentacgia;
	
	JLabel diachilb;
	JTextField diachi;
	
	JLabel dienthoailb;
	JTextField dienthoai;
	
	JLabel emaillb;
	JTextField email;
	
	JLabel ghichulb;
	JTextField ghichu;
	
	
	
	JLabel errorlb;
	JLabel errordetails;
	
	JButton ok;
	JButton cancel;
	
	
	
	quanlitacgia mst;
	String id;
	

	public   UpdateForm9(String s, quanlitacgia aa, String mtg ,String ttg , String dc, String dt, String em, String gc)
	{
		super(s);
		mst = aa;
		Container cont = this.getContentPane();
		cont.setLayout(new GridLayout(24,2));
		
		matacgialb = new JLabel("matacgia");
		matacgia = new JTextField(mtg);
		cont.add(matacgialb);
		cont.add(matacgia);
		
		tentacgialb = new JLabel("tentacgia");
		tentacgia = new JTextField(ttg);
		cont.add(tentacgialb);
		cont.add(tentacgia);
		
		diachilb = new JLabel("diachi");
		diachi = new JTextField(dc);
		cont.add(diachilb);
		cont.add(diachi);
		
		dienthoailb = new JLabel("dienthoai");
		dienthoai = new JTextField(dt);
		cont.add(dienthoailb);
		cont.add(dienthoai);	
		
		emaillb = new JLabel("email");
		email = new JTextField(em);
		cont.add(emaillb);
		cont.add(email);
		
		ghichulb = new JLabel("ghichu");
		ghichu = new JTextField(gc);
		cont.add(ghichulb);
		cont.add(ghichu);	
		
		
		
	
		
		
		
		errorlb = new JLabel("");
		errordetails = new JLabel("");
		errorlb.setVisible(false);
		errordetails.setVisible(false);
		cont.add(errorlb);
		cont.add(errordetails);
		JButton ok = new JButton("Ok");
		JButton cancel = new JButton("Cancel");
		cont.add(ok);
		cont.add(cancel);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		this.setSize(430,500);
		this.setLocation(250, 100);
		this.setVisible(true);
		id = mtg;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			insertDB();
		} else
			this.dispose();
	}

	public void insertDB()
	{
		if(matacgia.getText().equals("")|| tentacgia.getText().equals("")||diachi.getText().equals("")||dienthoai.getText().equals("")||email.getText().equals("")||ghichu.getText().equals(""))
		{
			errorlb.setText("Error");
			errordetails.setText("empty value");
			errorlb.setForeground(Color.RED);
			errordetails.setForeground(Color.RED);
			
			errorlb.setVisible(true);
			errordetails.setVisible(true);
			
		}
		else
		{
			try
			{
				String mtg = matacgia.getText();
				String ttg = tentacgia.getText();
				String dc = diachi.getText();
				String dt = dienthoai.getText();
				
				String em = email.getText();
				String gc = ghichu.getText();
				
				String sql=" ";
				
				if(this.getTitle().equals("Insert form"))
					sql = "insert into tacgia (MATACGIA,TENTACGIA,DIACHI,DIENTHOAI,EMAIL,GHICHU)" +
							" values ('"+mtg+"','"+ttg+"','"+dc+"','"+dt+"','"+em+"','"+gc+"')";
				else
					sql = "update tacgia set MATACGIA= '"+mtg+"',TENTACGIA ='"+ttg+"',DIACHI='"+dc+"',DIENTHOAI='"+dt+"',EMAIL='"+em+"',GHICHU='"+gc+"' where MATACGIA= '" +id+"'";
				
				mst.stm.executeUpdate(sql);
				mst.reload();
				mst.model.fireTableDataChanged();
				this.dispose();
			}
			catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Loi");
			}

		}
	}

}

