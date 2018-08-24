package fasttrackse.javacore.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.javacore.entity.QuanLiMuonTra;
import fasttrackse.javacore.entity.QuanLiTenSach;
import fasttrackse.javacore.entity.QuanLiTheLoaiSach;
import fasttrackse.javacore.entity.QuanLiThongTinQuan1;
public class DBMaSach {
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
		DBMaSach.conn = conn;
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
	public ArrayList<QuanLiMuonTra> getList() {
		ArrayList<QuanLiMuonTra> dsTinh = new ArrayList<QuanLiMuonTra>();
		try {
			String queryString = "SELECT `Ma_GD`, `Ngay_muon`, `Ma_TV`, trang_thai_muon_tra.trang_thai, `Ma_sach` FROM `quan_li_muon_tra` INNER JOIN trang_thai_muon_tra on trang_thai_muon_tra.id = quan_li_muon_tra.trang_thai";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String MaGD = result.getString("Ma_GD");
				String NgayMuon = result.getString("Ngay_muon");
				String MaTV = result.getString("Ma_TV");
				String TrangThai = result.getString("trang_thai_muon_tra.trang_thai");
				String MaSach = result.getString("Ma_sach");
				dsTinh.add(new QuanLiMuonTra(MaGD, NgayMuon, MaTV, TrangThai, MaSach));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTinh;
	}

	public ArrayList<QuanLiTenSach> getSach(String idTheLoai) {
		ArrayList<QuanLiTenSach> dsQuan = new ArrayList<QuanLiTenSach>();
		try {
			String queryString = "SELECT `id`, `Ten_sach` FROM `quan_li_sach` WHERE `id_TheLoai` ='"+idTheLoai+"'";
			PreparedStatement statement = conn.prepareStatement(queryString);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String id = result.getString("id");
				String TenSach = result.getString("Ten_sach");
				dsQuan.add(new QuanLiTenSach(id, TenSach));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsQuan;
	}

}
