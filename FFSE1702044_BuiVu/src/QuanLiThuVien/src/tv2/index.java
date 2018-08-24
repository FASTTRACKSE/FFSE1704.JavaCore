package QuanLiThuVien.src.tv2;




import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class index extends JFrame implements ActionListener, MouseListener {
	JLabel lbtitle = new JLabel("QUẢN LÍ THƯ VIỆN SÁCH");
	JButton bttquanli = new JButton("QUẢN LÍ SÁCH", new ImageIcon(
			"image/qls2.png"));
	JButton btxoa = new JButton("XÓA THÔNG TIN....", new ImageIcon("image/xoa.png"));
	JButton btcapnhat = new JButton("CẬP NHẬP THÔNG TIN....", new ImageIcon(
			"image/cn.png"));
	
	JButton btmuonts = new JButton("Quản Lí Mượn Trả Sách....", new ImageIcon(
			"image/mt.png"));
	JButton bttqlnxb = new JButton("Quản lí ­ NXB....", new ImageIcon(
			"image/nxb.png"));
	JButton btdocgia = new JButton("Quản Lí tác giả....", new ImageIcon("image/qldg.png"));

	JButton bttimkiem = new JButton("tìm kiếm", new ImageIcon("image/tk2.png"));
	JTextField tftimkiem = new JTextField();
	JTextField tfmapt = new JTextField();
	
	JButton btttacgia1 = new JButton("Thông tin tác giả", new ImageIcon("image/qltg.png"));
	
	
	
	
	
	int selectedrow = 0;
	MenuBar bar;
	Menu action;
	MenuItem ketnoi, ketnoicsdl, docgia, ttvs, tths, ttpt,
	ttchupt, thetv, tkhs, ltdg, trasach, tkchucupt, thongkehs,dn,tr,td,dp,phdl,thoatra,tk,tkt,
	thongkept, tkesach;
	JPanel p1, p2, p3, p4, p5;
	// layout
	GridLayout gl = new GridLayout();
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JScrollPane tableResult;
	JLabel lbltd=new JLabel("Bảng Quy ĐỊnh Phạt");
	JTable tb = new JTable();
	DefaultTableModel model;
	Statement stm;
	Connection conn;
	ResultSet rst;
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	public index() {
		
		super("QUẢN LÍ THƯ VIỆN SÁCH");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ket noi den co so du lieu va tao doi tuong statement
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlithuvien","quanlithuvien", "123123");
			stm = conn.createStatement();
			// action button
			btdocgia.addActionListener(this);
			btmuonts.addActionListener(this);
			bttqlnxb.addActionListener(this);

			
			bttquanli.addActionListener(this);
			btxoa.addActionListener(this);
			btcapnhat.addActionListener(this);
			bttimkiem.addActionListener(this);
			// menu
			bar = new MenuBar();
			setMenuBar(bar);
			// menu háº¹ thong
			action = new Menu("Hằng Tháng");
			bar.add(action);
			action.addActionListener(this);
			// muc con he thong
			ketnoicsdl = new MenuItem("Ket noi CSDL");
			action.add(ketnoicsdl);
			ketnoicsdl.addActionListener(this);
			action.addSeparator();
			ketnoi = new MenuItem("Bo ket noi CSDL");
			action.add(ketnoi);
			ketnoi.addActionListener(this);
			action.addSeparator();
			dn = new MenuItem("Dang Nhap");
			action.add(dn);
			dn.addActionListener(this);
			action.addSeparator();
			tr = new MenuItem("Tro ra");
			action.add(tr);
			tr.addActionListener(this);
			action.addSeparator();
			td = new MenuItem("CN Thay doi QD");
			action.add(td);
			td.addActionListener(this);
			action.addSeparator();
			dp = new MenuItem("Luu Du Phong Du Lieu");
			action.add(dp);
			dp.addActionListener(this);
			action.addSeparator();
			phdl = new MenuItem("Phuc Hoi Du Lieu");
			action.add(phdl);
			phdl.addActionListener(this);
			action.addSeparator();
			thoatra = new MenuItem("Thoat Khoi Chuong trinh");
			action.add(thoatra);
			thoatra.addActionListener(this);
			// menu nhap lieu
			action = new Menu("Nhập liệu");
			bar.add(action);
			action.addActionListener(this);
			// muc con nhap lieu
			docgia = new MenuItem("Nhap Thong Tin Ve DG");
			action.add(docgia);
			docgia.addActionListener(this);
			action.addSeparator();
			ttvs = new MenuItem("Nhap Thong Tin Ve Sach");
			action.add(ttvs);
			ttvs.addActionListener(this);
			
			// menu tra cuu
			action = new Menu("Tra cứu");
			bar.add(action);
			action.addActionListener(this);
			// muc con tra cuu
			ttpt = new MenuItem("Tra cuu DG");
			action.add(ttpt);
			ttpt.addActionListener(this);
			action.addSeparator();
			ttchupt = new MenuItem("Tra cuu Sach");
			action.add(ttchupt);
			ttchupt.addActionListener(this);
			action.addSeparator();
			thetv = new MenuItem("Tra cuu The Thu Vien");
			action.add(thetv);
			thetv.addActionListener(this);
			
			// xu li
			action = new Menu("");
			bar.add(action);
			action.addActionListener(this);
			// xu li con
			ltdg = new MenuItem("Lap The DG");
			action.add(ltdg);
			ltdg.addActionListener(this);
			action.addSeparator();
			trasach = new MenuItem("Muon Tra Sach");
			action.add(trasach);
			trasach.addActionListener(this);
			action.addSeparator();
			
			// menu thong ke
			action = new Menu("Thống Kê");
			bar.add(action);
			action.addActionListener(this);
			// muc con thong ke
			tkesach = new MenuItem("Thong Ke Sach");
			action.add(tkesach);
			tkesach.addActionListener(this);
			tk = new MenuItem("Thong Ke DG");
			action.add(tk);
			tk.addActionListener(this);
			tkt = new MenuItem("Thong Ke the DG");
			action.add(tkt);
			tkt.addActionListener(this);
			/* ket thuc menu */
			setLayout(gbl);
			gbc.insets = new Insets(25, 5, 5, 5);
			gbc.fill = GridBagConstraints.BOTH;
			addComponent(bttquanli, 0, 0, 1, 1);
			addComponent(btdocgia, 0, 1, 1, 1);
			addComponent(btmuonts, 0, 2, 1, 1);
			addComponent(bttqlnxb, 0, 3, 1, 1);
			
			addComponent(btcapnhat, 1, 0, 1, 1);
			addComponent(btxoa, 2, 0, 1, 1);
			addComponent(tftimkiem, 3, 0, 1, 1);
			addComponent(bttimkiem, 4, 0, 1, 1);
			addComponent(btttacgia1, 5, 0, 1, 1);
			reload();
			model = new DefaultTableModel(vData, vTitle);
			tb = new JTable(model);
			tb.addMouseListener(this);
			addComponent(lbltd, 0, 2, 1, 10);
			tableResult = new JScrollPane(tb);
			addComponent(tableResult, 3, 1, 10, 10);
			this.setLocation(100, 300);
			this.pack();
			this.setVisible(true);
			this.setResizable(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Loi");
		}

	}

	public void addComponent(Component c, int row, int col, int nrow, int ncol) {
		gbc.gridx = col;
		gbc.gridy = row;

		gbc.gridheight = ncol;
		gbc.gridwidth = nrow;

		gbl.setConstraints(c, gbc);
		add(c);
		
	}

	public void reload() {
		try {
			vTitle.clear();
			vData.clear();
			ResultSet rst = stm.executeQuery("select * from bangphat");
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
		}
		// stm.close();
		// conn.close();}
		catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new index();

	}

	/* xoa ho so */
	public void xoahoso() {

		if (tfmapt.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Báº¡n chÆ°a chá»�n Ä‘á»‘i tÆ°á»£ng cáº§n xoĂ¡");
			}
		 else {
			try {
				int ret=JOptionPane.showConfirmDialog(this, "Báº¡n muá»‘n xoĂ¡ thĂ´ng tin nĂ y ?","ThĂ´ng bĂ¡o",JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION){
				Vector hs = (Vector) vData.elementAt(selectedrow);
				String sql = "Delete from bangphat where MADOCGIA='" + hs.elementAt(0)
						+ "'";
				stm.executeUpdate(sql);
				vData.remove(selectedrow);
				model.fireTableDataChanged();
				JOptionPane.showMessageDialog(null,"Ä�Ă£ xoĂ¡ Ä‘á»‘i tÆ°á»£ng !");
			}
			else{
				
				
			}
			} catch (Exception ec) {
			}}
		}
		

	public void timkiem() {
		try {
		//	vTitle.clear();
			//vData.clear();
			ResultSet rst = stm.executeQuery("select * from bangphat where MADOCGIA='"+tftimkiem+"'");
			ResultSetMetaData rstmeta = rst.getMetaData();
			int col = rstmeta.getColumnCount();
			Vector<String> coll = new Vector<String>();
			coll.addElement("MĂ£ há»“ sÆ¡");
			coll.addElement("MĂ£ PT");
			coll.addElement("MĂ£ chá»§ PT");
			coll.addElement("MĂ£ chá»§ cÅ© PT");
			vTitle = new Vector(coll);
			vData = new Vector();
			while (rst.next()) {
			 Vector row = new Vector();
				row.addElement(rst.getString("MAHS"));
				row.addElement(rst.getString("MAPT"));
				row.addElement(rst.getString("MACHUPT"));
				row.addElement(rst.getString("MACHUCUPT"));
				vData.addElement(row);	
			}
			rst.close();
		model = new DefaultTableModel(vData, vTitle);
		tb = new JTable(model);
		tb.addMouseListener(this);
		tableResult = new JScrollPane(tb);
		addComponent(tableResult, 1, 1, 10, 10);
		// stm.close();
		}// conn.close();}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nhập Tìm Kiếm!");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btttacgia1) {
			
		}
		if (e.getSource() == btmuonts) 
		{
			new quanlimuontra("quanlimuontra");
			
		}
		if (e.getSource() == btdocgia) {
			new quanlidg("quanlidg");
		}
		if (e.getSource() == bttqlnxb) 
		{
			new quanlinxb("quanlinxb");
			
		}
		if (e.getSource() == bttqlnxb) {
			
		}
	
		
		if (e.getSource() == bttquanli) {
			new sach("sach");
			}
			
		if (e.getSource() == btxoa) {
			xoahoso();
		} 
		if(e.getSource()==bttimkiem){
			timkiem();
		}

		if (e.getSource() == btcapnhat) {
			this.dispose();
			new index();
			}
		}
		
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		selectedrow = tb.getSelectedRow();
		Vector hs = (Vector) vData.elementAt(selectedrow);
		tfmapt.setText(hs.elementAt(0).toString());

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
