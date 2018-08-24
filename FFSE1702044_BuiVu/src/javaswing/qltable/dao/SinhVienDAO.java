package javaswing.qltable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;

import ffse.qlkhsql.utity.KhachHang;
import javaswing.tablesql.untity.SinhVien;

public class SinhVienDAO {
	DefaultTableModel tableDSSV = new DefaultTableModel();
	ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
	Connection conn = null;

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase + "?useUnicode=yes&characterEncoding=UTF-8";
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

	public ArrayList<SinhVien> getDSSinhVien() {
		
		try {
			String queryString = "SELECT * FROM SinhVien";
			PreparedStatement statement = conn.prepareStatement(queryString);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String ID = result.getString("id");
				String hoSV = result.getString("ho_sv");
				String tenSV = result.getString("ten_sv");
				String genderSV = result.getString("gender_sv");
				String namSinhSV = result.getString("namsinh_sv");
				String classSV = result.getString("class_sv");
				dsSV.add(new SinhVien(ID, hoSV, tenSV, genderSV, namSinhSV, classSV));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSV;
	}

	public void add(SinhVien sv) {
		//
		try {
			String queryString = "INSERT INTO `SinhVien`(ho_sv, ten_sv, gender_sv, namsinh_sv, class_sv) VALUES (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, sv.getHoSV());
			statement.setString(2, sv.getTenSV());
			statement.setString(3, sv.getGenderSV());
			statement.setString(4, sv.getNamSinhSV());
			statement.setString(5, sv.getClassSV());
		

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Thêm OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void edit(SinhVien sv) {
		//
		try {
			String sql = "update SinhVien set ho_sv=?,ten_sv=?,namsinh_sv=? where id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sv.getHoSV());
			statement.setString(2, sv.getTenSV());
			statement.setString(3, sv.getNamSinhSV());
			statement.setString(4, sv.getID());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sửa OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(int idKH) {
		//
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM `SinhVien` WHERE id=?");
			statement.setLong(1, idKH);
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Xóa OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void read(int idKH) {
		try {
			PreparedStatement statement = conn.prepareStatement("select * from khachhang where id=?",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setLong(1, idKH);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String ID = result.getString("id");
				String hoSV = result.getString("ho_sv");
				String tenSV = result.getString("ten_sv");
				String genderSV = result.getString("gender_sv");
				String namSinhSV = result.getString("namsinh_sv");
				String classSV = result.getString("class_sv");
				dsSV.add(new SinhVien(ID, hoSV, tenSV, genderSV, namSinhSV, classSV));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
