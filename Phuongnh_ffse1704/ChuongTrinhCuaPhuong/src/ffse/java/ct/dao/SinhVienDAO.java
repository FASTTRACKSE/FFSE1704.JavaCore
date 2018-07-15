package ffse.java.ct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import ffse.java.ct.entity.SinhVien;


public class SinhVienDAO {
	// ArrayList<SinhVien> sv = new ArrayList<SinhVien>();

	static Connection conn = null;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
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

	}

	public void add(SinhVien sv) {
		try {
			String queryString = "insert into sinhvien set MaSV=?, Lop=?, TenSV=?, Tuoi=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, sv.getMaSinhVien());
			statement.setString(2, sv.getTenSinhVien());
			statement.setString(3, sv.getLopSinhVien());
			statement.setString(4, sv.getTuoiSinhVien());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void update(SinhVien sv) {
		try {
			String queryString = "update sinhvien set MaSV=?, Lop=?, TenSV=?, Tuoi=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, sv.getMaSinhVien());
			statement.setString(2, sv.getTenSinhVien());
			statement.setString(3, sv.getLopSinhVien());
			statement.setString(4, sv.getTuoiSinhVien());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, " UPDATE thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<SinhVien> getDSinhVien() {
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

		try {
			String queryString = "SELECT * FROM sinhvien";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String maSinhVien  = result.getString("TenSV");
				String tenSinhVien  = result.getString("MaSV");
				String lopSinhVien = result.getString("Lop");
				String tuoiSinhvien = result.getString("Tuoi");

				dsSV.add(new SinhVien(maSinhVien,tenSinhVien,lopSinhVien,tuoiSinhvien));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSV;
	}

}