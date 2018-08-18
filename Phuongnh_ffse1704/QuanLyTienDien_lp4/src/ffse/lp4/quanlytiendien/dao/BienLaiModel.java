package ffse.lp4.quanlytiendien.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import ffse.lp4.quanlytiendien.entity.BienLai;

public class BienLaiModel {
	private PreparedStatement ps;
	private String sql;

	static Connection conn = null;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public static  Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;

	}




	public ArrayList<BienLai> getDSBienLai(String maCT) {
		ArrayList<BienLai> dSBL = new ArrayList<BienLai>();
		try {
			String queryString = "SELECT * FROM bienlai WHERE MaCongTo=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dSBL;
	}

	public void addBL(BienLai bl) {
		try {
			String queryString = "insert into bienlai(MaCongTo,Date,Thang,Nam,ChuKy,ChiSoMoi,SoTien) values(?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, bl.getMaCongTo());
			statement.setString(2, bl.getNgayNhap());
			statement.setString(3, bl.getThangNhap());
			statement.setString(4, bl.getNamNhap());
			statement.setString(5, bl.getChuKy());
			statement.setInt(6, bl.getChiSoMoi());
			statement.setInt(7, bl.getTienDien());

			int x = statement.executeUpdate();

			if (x > 0) {
				JOptionPane.showMessageDialog(null, "THÊM thành công !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static ResultSet getMaCT() {
		try {
			String sql = "select MaCongTo from bienlai";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void deleteBL(String MCT) {
		try {
			String queryString = "delete from bienlai where MaCongTo=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, MCT);

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "XOÁ thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Bạn thao tác sai, bấm OK để thoát!!!!!");
				System.exit(0);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

public ArrayList<BienLai> getDSBienLai() {
		ArrayList<BienLai> dsBL= new ArrayList<BienLai>();
	try {
			String queryString = "SELECT * FROM bienlai order by Date DESC";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String mactKH = result.getString("MaCongTo");
				String ngaynhapKH = result.getString("Date");
				String thangnhapKH = result.getString("Thang");
				String namnhapKH = result.getString("Nam");
				String chukyKH = result.getString("ChuKy");
				int chisoCT = result.getInt("ChiSoMoi");
				int tiendienKH = result.getInt("SoTien");


				dsBL.add(new BienLai(mactKH, ngaynhapKH, thangnhapKH, namnhapKH, chukyKH, chisoCT, tiendienKH));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsBL;
	}
	public void updateBL(BienLai bl) {
	try {
		String queryString = "update bienlai set ChiSoMoi=?, SoTien=? WHERE MaKhachHang=? AND Date=?";
		PreparedStatement statement = conn.prepareStatement(queryString);
		System.out.println(statement);

		statement.setInt(1, bl.getChiSoMoi());
		statement.setInt(2, bl.getTienDien());
		statement.setString(3, bl.getMaCongTo());
		statement.setString(4, bl.getNgayNhap());

		int x = statement.executeUpdate();
		System.out.println(x);
		if (x > 0) {
			JOptionPane.showMessageDialog(null, "SỬA thành công!!!");
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}


}