package ffse1704.qlsv.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.mysql.jdbc.Driver;

import ffse1704.qlsv.entity.*;
public class SinhVienDao {

	
	
	//kết nối database
	public SinhVienDao() {
			this.getConnect("localhost", "quanlyhocvien", "nghia111", "123456");
		}

		//ngắt kết nối database
		public void disConnection() {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	static Connection conn = null;

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

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase+"?characterEncoding=UTF-8";
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

	public static ArrayList<SinhVien> getDSSinhVien() {
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();

		try {
			String queryString = "SELECT * FROM sinhvien" ;
			PreparedStatement statement = conn.prepareStatement(queryString);
//			statement.setString(1,"kh1");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String MaSV = result.getString("MaSV");
				String HoSV = result.getString("HoSV");
				String TenSV = result.getString("TenSV");
				String GioiTinh = result.getString("GioiTinh");
				String NgaySinh = result.getString("NgaySinh");
				String Lop = result.getString("Lop");
				
				
				dsSV.add(new SinhVien(MaSV, HoSV, TenSV, GioiTinh, NgaySinh, Lop));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSV;
	}

	public static void add(SinhVien sv) {
		try {
			
		String queryString="insert into sinhvien(MaSV,HoSV,TenSV,GioiTinh,NgaySinh,Lop) values(?,?,?,?,?,?)";
		PreparedStatement statement=conn.prepareStatement(queryString);
		statement.setString(1, sv.getMaSV());
		statement.setString(2, sv.getHoSV());
		statement.setString(3, sv.getTenSV());
		statement.setString(4, sv.getGioiTinh());
		statement.setString(5, sv.getNgaySinh());
		statement.setString(6, sv.getLop());;
		
		
		
		
		int x=statement.executeUpdate();
		if(x>0)
		{
		System.out.println("Lưu OK");
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}

	public void edit(SinhVien sv) {
		try {
			String queryString = "UPDATE sinhvien SET  HoSV=?, TenSV=?, GioiTinh=?, NgaySinh=?, Lop=? WHERE  MaSV=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			
			statement.setString(1, sv.getHoSV());
			statement.setString(2, sv.getTenSV());
			statement.setString(3, sv.getGioiTinh());
			statement.setString(4, sv.getNgaySinh());
			statement.setString(5, sv.getLop());
			statement.setString(6, sv.getMaSV());
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println(" Sửa thành công rồi chúng mày ơi .");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void delete(String maSV) {
		try {
			String queryString = "delete from sinhvien where MaSV=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, maSV);

			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Delete OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public SinhVien read(int id) {
		SinhVien sv = new SinhVien();

		try {
			String queryString = "SELECT * FROM sinhvien WHERE MaSV = ?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			result.next();

			String MaSV = result.getString("MaSV");
			String HoSV = result.getString("HoSV");
			String TenSV = result.getString("TenSV");
			String GioiTinh = result.getString("GioiTinh");
			String NgaySinh = result.getString("NgaySinh");
			String Lop = result.getString("Lop");

			sv = new SinhVien(MaSV, HoSV, TenSV, GioiTinh, NgaySinh, Lop);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sv;
	}

	

}
	

