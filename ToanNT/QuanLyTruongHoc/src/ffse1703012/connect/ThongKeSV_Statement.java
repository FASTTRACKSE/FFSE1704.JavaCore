package ffse1703012.connect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ffse1703012.entity.DiemSV;
import ffse1703012.entity.PhanMon;
import ffse1703012.entity.QuanLyLop;
import ffse1703012.entity.SinhVien;


public class ThongKeSV_Statement {
	final Connection conn= (Connection) (new SinhVienDAO()).getConnect("localhost", "ffse1703012_java", "toan123", "123");
	ArrayList<String> arrNamHoc = new ArrayList<>();
	ArrayList<QuanLyLop> arrLop = new ArrayList<>();
	ArrayList<PhanMon> arrPhanMon = new ArrayList<>(); 
	ArrayList<SinhVien> arrThongTinSv = new ArrayList<>();
	ArrayList<DiemSV> arrDiemSv = new ArrayList<>();
	String diemSv;
	public ArrayList<String> sellectNamHoc(){
		
		arrNamHoc.clear();
		try {
			String sql = "select distinct Namhoc from Lop";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String namHoc = result.getString("Namhoc");
				
				 arrNamHoc.add(namHoc);
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrNamHoc;
	}
	
	public ArrayList<QuanLyLop> sellectAllLop() {
		arrLop.clear();
		try {
			String sql = "select * from Lop";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maLop = result.getString("Malop");
				 String tenLop = result.getString("Tenlop");
				 String namHoc = result.getString("Namhoc");
				 arrLop.add(new QuanLyLop(maLop, tenLop, namHoc));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrLop;
	}
	
	public ArrayList<PhanMon> sellectPhanMon(String ma){
		arrPhanMon.clear();
		try {
			String sql = "select * from Phan_mon where Malop ='" + ma + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maLop = result.getString("Malop");
				 String maMon = result.getString("Mamon");
				 arrPhanMon.add(new PhanMon(maLop, maMon));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrPhanMon;
	}
	
	public ArrayList<SinhVien> sellectThongTinSv(String maLop){
		arrThongTinSv.clear();
		try {
			String sql = "select Masv, Hoten from Sinh_vien where Malop ='" + maLop + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maSv = result.getString("Masv");
				 String hoTen = result.getString("Hoten");
				 arrThongTinSv.add(new SinhVien(maSv, hoTen));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return arrThongTinSv;
	}
	
	public String diemSv(String maSv, String maMon) {
		diemSv = null;
		try {
			String sql = "select Diem from Diem where Masv ='" + maSv + "'" + "and Mamon = '" + maMon + "'";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String diem = result.getString("Diem");
				 diemSv = diem;
				 
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return diemSv;
	}
	
	public ArrayList<DiemSV> sellectDiemSv (String maSv){
		arrDiemSv.clear();
		try {
			String sql = "select Diem from Diem where Masv = '" + maSv + "'";
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				String diem = result.getString("Diem");
				arrDiemSv.add(new DiemSV(diem));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrDiemSv;
	}
}
