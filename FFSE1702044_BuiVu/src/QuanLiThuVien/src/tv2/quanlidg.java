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

public class quanlidg extends JFrame implements ActionListener,
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

	public  quanlidg(String s) {
		super(s);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/quanlithuvien", "quanlithuvien", "123123");
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
			ResultSet rst = stm.executeQuery("select * from docgia");
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
			String sql = "Delete from docgia where madocgia = \""+st.elementAt(0) + "\"";
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
			new UpdateForm("Insert form", this,"","","","","","","");
		}
		// khi an edit

		if (e.getActionCommand().equals("Edit")) {
			Vector st = (Vector)vData.elementAt(selectrow);
			
			new UpdateForm("Edit form",this,(String)st.elementAt(0),(String)st.elementAt(1),(String)st.elementAt(2),(String)st.elementAt(3),(String)st.elementAt(4),(String)st.elementAt(5),(String)st.elementAt(6));
		}
		}
	
	public void mouseClicked(MouseEvent e) {
		selectrow = tb.getSelectedRow();
	}

	public static void main(String[] args) {
		new  quanlidg(" quanlidg");
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

class UpdateForm extends JFrame implements ActionListener {
	JLabel madocgialb;
	JTextField madocgia;
	
	JLabel tendocgialb;
	JTextField tendocgia;
	
	JLabel ngaysinhlb;
	JTextField ngaysinh;
	
	JLabel noisinhlb;
	JTextField noisinh;
	
	JLabel diachilb;
	JTextField diachi;
	
	JLabel dienthoailb;
	JTextField dienthoai;
	
	JLabel maloaidocgialb;
	JTextField maloaidocgia;
	
	
	
	JLabel errorlb;
	JLabel errordetails;
	
	JButton ok;
	JButton cancel;
	
	
	
	 quanlidg mst;
	String id;
	

	public   UpdateForm(String dg,  quanlidg bb, String mdg, String tdg, String ns, String nois, String dc, String dt, String mldg)
	{
		super(dg);
		mst = bb;
		Container cont = this.getContentPane();
		cont.setLayout(new GridLayout(24,2));
		
		madocgialb = new JLabel("madocgia");
		madocgia = new JTextField(mdg);
		cont.add(madocgialb);
		cont.add(madocgia);
		
		tendocgialb = new JLabel("tendocgia");
		tendocgia = new JTextField(tdg);
		cont.add(tendocgialb);
		cont.add(tendocgia);
		
		ngaysinhlb = new JLabel("ngaysinh");
		ngaysinh = new JTextField(ns);
		cont.add(ngaysinhlb);
		cont.add(ngaysinh);
		
		noisinhlb = new JLabel("noisinh");
		noisinh = new JTextField(nois);
		cont.add(noisinhlb);
		cont.add(noisinh);	
		
		diachilb = new JLabel("diachi");
		diachi = new JTextField(dc);
		cont.add(diachilb);
		cont.add(diachi);
		
		dienthoailb = new JLabel("dienthoai");
		dienthoai = new JTextField(dt);
		cont.add(dienthoailb);
		cont.add(dienthoai);	
		
		maloaidocgialb = new JLabel("maloaidocgia");
		maloaidocgia = new JTextField(mldg);
		cont.add(maloaidocgialb);
		cont.add(maloaidocgia);
		
		
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
		id = mdg;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			insertDB();
		} else
			this.dispose();
	}

	public void insertDB()
	{
		if(madocgia.getText().equals("")|| tendocgia.getText().equals("")||ngaysinh.getText().equals("")||noisinh.getText().equals("")||diachi.getText().equals("")||dienthoai.getText().equals("")||maloaidocgia.getText().equals(""))
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
				String mdg = madocgia.getText();
				String tdg = tendocgia.getText();
				String ns = ngaysinh.getText();
				String nois = noisinh.getText();
				String dc = diachi.getText();
				Integer dt = Integer.parseInt(dienthoai.getText());
				String mldg = maloaidocgia.getText();
				
				String sql=" ";
				
				if(this.getTitle().equals("Insert form"))
					sql = "insert into docgia (MADOCGIA,TENDOCGIA,NGAYSINH,NOISINH,DIACHI,DIENTHOAI,MALOAIDOCGIA)" +
							" values ('"+mdg+"','"+tdg+"','"+ns+"','"+nois+"','"+dc+"',"+dt+",'"+mldg+"')";
				else
					sql = "update docgia set MADOCGIA= '"+mdg+"',TENDOCGIA ='"+tdg+"',NGAYSINH='"+ns+"',NOISINH='"+nois+"',DIACHI='"+dc+"',DIENTHOAI= "+dt+",MALOAIDOCGIA='"+mldg+"' where MADOCGIA= '" +id+"'";
				
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

