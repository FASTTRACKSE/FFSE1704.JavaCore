package fasttrackse.javacore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.javacore.entity.QuanLiDiaChi;
import fasttrackse.javacore.entity.QuanLiSach;
import fasttrackse.javacore.entity.QuanLiTheLoaiSach;
import fasttrackse.javacore.entity.QuanLiThongTinBanDoc1;
public class DBThuVien {
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
		DBThuVien.conn = conn;
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
	public ArrayList<QuanLiTheLoaiSach> getList() {
		ArrayList<QuanLiTheLoaiSach> dsTinh = new ArrayList<QuanLiTheLoaiSach>();
		try {
			String queryString = "SELECT `id`, `The_loai` FROM `the_loai_sach`";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String id = result.getString("id");
				String TheLoai = result.getString("The_loai");
				dsTinh.add(new QuanLiTheLoaiSach(id, TheLoai));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTinh;
	}


	public ArrayList<QuanLiSach> getDSSach() {
		ArrayList<QuanLiSach> dsSach = new ArrayList<QuanLiSach>();
		try {
			String queryString = "SELECT Ma_sach,Ten_sach,Tac_gia,NXB,The_loai_sach.The_loai,nam_XB FROM quan_li_sach INNER JOIN The_loai_sach ON The_loai_sach.id_TheLoai= quan_li_sach.id_TheLoai ORDER BY `quan_li_sach`.`Ma_sach` ASC ";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maSach = result.getString("Ma_sach");
				String tenSach = result.getString("Ten_sach");
				String TacGia = result.getString("Tac_gia");
				String nXB = result.getString("NXB");
				String TheLoaiSach = result.getString("The_loai_sach.The_loai");
				String NamXB = result.getString("nam_XB");

				dsSach.add(new QuanLiSach(maSach, tenSach, TacGia, nXB, TheLoaiSach, NamXB));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSach;
	}

	public void add(QuanLiSach sach) {
		//
		try {
			String queryString = "INSERT INTO `quan_li_sach`( `Ma_sach`, `Ten_sach`, `Tac_gia`, `NXB`, `id_TheLoai`, `nam_XB`) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			
			statement.setString(1, sach.getMaSach());
			statement.setString(2, sach.getTenSach());
			statement.setString(3, sach.getTacGia());
			statement.setString(4, sach.getNXB());
			statement.setString(5, sach.getTheLoaiSach());
			statement.setString(6, sach.getNamXB());
			int x = statement.executeUpdate();
			if (x > 0) {
				
				JOptionPane.showMessageDialog(null, "Them OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void edit(QuanLiSach sach) {
		//
		try {
			String sql = "UPDATE `quan_li_sach` SET `Ten_sach`=?,`Tac_gia`=?,`NXB`=? where `Ma_sach`=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, sach.getTenSach());
			statement.setString(2, sach.getTacGia());
			statement.setString(3, sach.getNXB());
			
			statement.setString(4, sach.getMaSach());
			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Sua OK!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(String idSACH) {
		//
		try
		{
		PreparedStatement statement=conn.prepareStatement
		("DELETE FROM `quan_li_sach` WHERE `Ma_sach`=?");
		statement.setString(1, idSACH);
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

	/*
	 * public ArrayList<QuanLiThongTin> login(QuanLiThongTin tt) {
	 * ArrayList<QuanLiThongTin> dsTT = new ArrayList<QuanLiThongTin>(); try {
	 * String queryString =
	 * "SELECT * FROM TTDangNhap where pass='?' and user_name='?' ";
	 * PreparedStatement statement = conn.prepareStatement(queryString);
	 * 
	 * ResultSet result = statement.executeQuery();
	 * 
	 * while (result.next()) { JOptionPane.showMessageDialog(null,
	 * "ÄÄƒng Nháº­p ThÃ nh CÃ´ng "); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return dsTT; } public void
	 * add(KhachHang kh) { // try { String queryString =
	 * "insert into khachhang(MaKH,TenKH,DiaChi,NgaySinh,GioiTinh,SoDT) values(?,?,?,?,?,?)"
	 * ; PreparedStatement statement = conn.prepareStatement(queryString);
	 * 
	 * statement.setString(1, kh.getMaKH()); statement.setString(2, kh.getTenKH());
	 * statement.setString(3, kh.getDiaChi()); statement.setString(4,
	 * kh.getNgaySinh()); statement.setString(5, kh.getGioiTinh());
	 * statement.setString(6, kh.getSoDT());
	 * 
	 * int x = statement.executeUpdate(); if (x > 0) {
	 * System.err.println("ThÃªm OK!"); } } catch (Exception ex) {
	 * ex.printStackTrace(); } }
	 * 
	 * public void edit(KhachHang kh) { // try { String sql =
	 * "update khachhang set TenKH=?,NgaySinh=? where id=?"; PreparedStatement
	 * statement = conn.prepareStatement(sql); statement.setString(1,
	 * kh.getTenKH()); statement.setString(2, kh.getNgaySinh());
	 * statement.setLong(3, kh.getID()); int x = statement.executeUpdate(); if (x >
	 * 0) { System.err.println("Cáº­p nháº­t OK"); } } catch (Exception ex) {
	 * ex.printStackTrace(); } }
	 * 
	 * public void delete(int idKH) { // try { PreparedStatement statement =
	 * conn.prepareStatement("DELETE FROM `khachhang` WHERE id=?");
	 * statement.setLong(1, idKH); int x = statement.executeUpdate(); if (x > 0) {
	 * System.out.println("XÃ³a ok"); } } catch (Exception ex) {
	 * ex.printStackTrace(); } }
	 */
	public  void timKiem(QuanLiSach sach) {
	

		try {
			String queryString = "SELECT * FROM `quan_li_sach` WHERE Ten_sach = '?' ";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, sach.getTimKiem());
			ResultSet result = statement.executeQuery();
			result.next();

			String maSach = result.getString("Ma_sach");
			String tenSach = result.getString("Ten_sach");
			String TacGia = result.getString("Tac_gia");
			String nXB = result.getString("NXB");
			String TheLoaiSach = result.getString("The_loai");
			String NamXB = result.getString("nam_XB");

			

			sach = new QuanLiSach(maSach, tenSach, TacGia, nXB, TheLoaiSach, NamXB);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}

}
