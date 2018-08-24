package fasttrackse.javacore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.javacore.*;
import fasttrackse.javacore.entity.QuanLiThongTinBanDoc1;
public class DBQuanLiBanDoc {
	static Connection conn = null;

	/**
	 * @return the conn
	 */
	public static Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

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

	public ArrayList<QuanLiThongTinBanDoc1> getDSBanDoc() {
		ArrayList<QuanLiThongTinBanDoc1> dsBanDoc = new ArrayList<QuanLiThongTinBanDoc1>();
		try {
			String queryString = "SELECT id, Ma_TV, Ten_TV, Dia_chi, ward.name, district.name, province.name, sdt, email FROM quan_li_tt_ban_doc INNER JOIN ward ON ward.wardid = quan_li_tt_ban_doc.Phuong INNER JOIN district ON district.districtid = ward.districtid INNER JOIN province on province.provinceid = district.provinceid";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String maTV = result.getString("Ma_TV");
				String tenTV = result.getString("Ten_TV");
				String DiaChi = result.getString("Dia_chi");
				String phuong = result.getString("ward.name");
				String quan = result.getString("district.name");
				String tinh = result.getString("province.name");
				String sdt = result.getString("sdt");
				String email = result.getString("email");

				dsBanDoc.add(new QuanLiThongTinBanDoc1(maTV, tenTV, DiaChi, phuong, quan, tinh, sdt, email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsBanDoc;
	}
	public void add(QuanLiThongTinBanDoc1 bd) {
		//
		try {
			String queryString = "INSERT INTO `quan_li_tt_ban_doc`( `Ma_TV`, `Ten_TV`, `Dia_chi`, `Phuong`, `sdt`, `email`) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			
			statement.setString(1, bd.getMaTV());
			statement.setString(2, bd.getTenTV());
			statement.setString(3, bd.getDiaChi());
			statement.setString(4, bd.getPhuong());
			statement.setString(5, bd.getSdt());
			statement.setString(6, bd.getEmail());
			int x = statement.executeUpdate();
			if (x > 0) {
				
				JOptionPane.showMessageDialog(null, "Them OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void edit(QuanLiThongTinBanDoc1 bd) {
		//
		try {
			String sql = "UPDATE `quan_li_tt_ban_doc` SET `Ten_TV`=?,`Dia_chi`=?,`sdt`=?,`email`=? where Ma_TV=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, bd.getTenTV());
			statement.setString(2, bd.getDiaChi());
			statement.setString(3, bd.getSdt());
			statement.setString(4, bd.getEmail());
			statement.setString(5, bd.getMaTV());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sua OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(String idBD) {
		//
		try
		{
		PreparedStatement statement=conn.prepareStatement
		("DELETE FROM `quan_li_tt_ban_doc` WHERE `Ma_TV`=?");
		statement.setString(1, idBD);
		int x=statement.executeUpdate();
		if(x>0)
		{
			JOptionPane.showMessageDialog(null, "Xoa ok");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
}


