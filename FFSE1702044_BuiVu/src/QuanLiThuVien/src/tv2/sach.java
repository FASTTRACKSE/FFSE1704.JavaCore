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

public class sach extends JFrame implements ActionListener,
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

	public sach(String s) {
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
			ResultSet rst = stm.executeQuery("select * from sach");
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
			String sql = "Delete from sach where masach = \""+st.elementAt(0) + "\"";
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
			new UpdateForm1("Insert form", this,"","","","","","","","","","","","");
		}
		// khi an edit

		if (e.getActionCommand().equals("Edit")) {
			Vector st = (Vector)vData.elementAt(selectrow);
			
			new UpdateForm1("Edit form",this,(String)st.elementAt(0),(String)st.elementAt(1),(String)st.elementAt(2),(String)st.elementAt(3),(String)st.elementAt(4),(String)st.elementAt(5),(String)st.elementAt(6),(String)st.elementAt(7),(String)st.elementAt(8),(String)st.elementAt(9),(String)st.elementAt(10),(String)st.elementAt(11));
		}
		}
	
	public void mouseClicked(MouseEvent e) {
		selectrow = tb.getSelectedRow();
	}

	public static void main(String[] args) {
		new sach("sach");
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

class UpdateForm1 extends JFrame implements ActionListener {
	JLabel masachlb;
	JTextField masach;
	
	JLabel tensachlb;
	JTextField tensach;
	
	JLabel maloaisachlb;
	JTextField maloaisach;
	
	JLabel mavitrilb;
	JTextField mavitri;
	
	JLabel tinhtranglb;
	JTextField tinhtrang;
	
	JLabel matacgialb;
	JTextField matacgia;
	
	JLabel manxblb;
	JTextField manxb;
	
	JLabel mangonngulb;
	JTextField mangonngu;
	
	JLabel sotranglb;
	JTextField sotrang;
	
	JLabel namxblb;
	JTextField namxb;
	
	JLabel giatienlb;
	JTextField giatien;
	
	JLabel solantaibanlb;
	JTextField solantaiban;
	
	JLabel errorlb;
	JLabel errordetails;
	
	JButton ok;
	JButton cancel;
	
	
	
	sach mst;
	String id;
	

	public   UpdateForm1(String s, sach aa, String ms,String ts , String mls, String mvt, String tt, String mtg, String mnxb, String mann,String st, String nxb, String gt, String sltb)
	{
		super(s);
		mst = aa;
		Container cont = this.getContentPane();
		cont.setLayout(new GridLayout(24,2));
		
		masachlb = new JLabel("masach");
		masach = new JTextField(ms);
		cont.add(masachlb);
		cont.add(masach);
		
		tensachlb = new JLabel("tensach");
		tensach = new JTextField(ts);
		cont.add(tensachlb);
		cont.add(tensach);
		
		maloaisachlb = new JLabel("maloaisach");
		maloaisach = new JTextField(mls);
		cont.add(maloaisachlb);
		cont.add(maloaisach);
		
		mavitrilb = new JLabel("mavitri");
		mavitri = new JTextField(mvt);
		cont.add(mavitrilb);
		cont.add(mavitri);	
		
		tinhtranglb = new JLabel("tinhtrang");
		tinhtrang = new JTextField(tt);
		cont.add(tinhtranglb);
		cont.add(tinhtrang);
		
		matacgialb = new JLabel("matacgia");
		matacgia = new JTextField(mtg);
		cont.add(matacgialb);
		cont.add(matacgia);	
		
		manxblb = new JLabel("manxb");
		manxb = new JTextField(mnxb);
		cont.add(manxblb);
		cont.add(manxb);
		
		mangonngulb = new JLabel("mangonngu");
		mangonngu = new JTextField(mann);
		cont.add(mangonngulb);
		cont.add(mangonngu);
		
		sotranglb = new JLabel("sotrang");
		sotrang = new JTextField(st);
		cont.add(sotranglb);
		cont.add(sotrang);
		
		namxblb = new JLabel("namxb");
		namxb = new JTextField(nxb);
		cont.add(namxblb);
		cont.add(namxb);
		
		giatienlb = new JLabel("giatien");
		giatien = new JTextField(gt);
		cont.add(giatienlb);
		cont.add(giatien);
		
		solantaibanlb = new JLabel("solantaiban");
		solantaiban = new JTextField(sltb);
		cont.add(solantaibanlb);
		cont.add(solantaiban);
		
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
		id = ms;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			insertDB();
		} else
			this.dispose();
	}

	public void insertDB()
	{
		if(masach.getText().equals("")|| tensach.getText().equals("")||maloaisach.getText().equals("")||mavitri.getText().equals("")||tinhtrang.getText().equals("")||matacgia.getText().equals("")||manxb.getText().equals("")||mangonngu.getText().equals("")||sotrang.getText().equals("")||namxb.getText().equals("")||giatien.getText().equals("")||solantaiban.getText().equals(""))
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
				String ms = masach.getText();
				String ts = tensach.getText();
				String mls = maloaisach.getText();
				String mvt = mavitri.getText();
				
				String tt = tinhtrang.getText();
				String mtg = matacgia.getText();
				String mnxb =manxb.getText();
				String mann = mangonngu.getText();
				Integer st = Integer.parseInt(sotrang.getText());
				Integer nxb = Integer.parseInt(namxb.getText());
				String gt = giatien.getText();
				Integer sltb = Integer.parseInt(solantaiban.getText());
				String sql=" ";
				
				if(this.getTitle().equals("Insert form"))
					sql = "insert into sach (MASACH,TENSACH,MALOAISACH,MAVITRI,TINHTRANG,MATACGIA,MANXB,MANGONNGU,SOTRANG,NAMXB,GIATIEN,SOLANTAIBAN)" +
							" values ('"+ms+"','"+ts+"','"+mls+"','"+mvt+"','"+tt+"','"+mtg+"','"+mnxb+"','"+mann+"',"+st+","+nxb+",'"+gt+"',"+sltb+")";
				else
					sql = "update sach set MASACH= '"+ms+"',TENSACH ='"+ts+"',MALOAISACH='"+mls+"',MAVITRI='"+mvt+"',TINHTRANG='"+tt+"',MATACGIA='"+mtg+"',MANXB='"+mnxb+"',MANGONNGU= '"+mann+"',SOTRANG="+st+",NAMXB="+nxb+",GIATIEN='"+gt+"',SOLANTAIBAN = "+sltb+" where MASACH= '" +id+"'";
				
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

