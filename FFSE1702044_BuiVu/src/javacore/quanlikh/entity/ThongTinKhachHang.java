package javacore.quanlikh.entity;

public class ThongTinKhachHang {
	private String tenKhachHang;
	private int maKhachHang;
	private String diaChiKhachHang;
	private int maCongTo;
	public ThongTinKhachHang(String tenKhachHang, int maKhachHang,String diaChiKhachHang,int maCongTo) {
		this.tenKhachHang=tenKhachHang;
		this.maKhachHang=maKhachHang;
		this.diaChiKhachHang=diaChiKhachHang;
		this.maCongTo=maCongTo;
	}
	public String getThongTinKhachHang() {
		return tenKhachHang;	
	}
	public void setThongTinKhachHang(String tenKhachHang) {
		this.tenKhachHang=tenKhachHang;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang=maKhachHang;
	}
	public String getDiaChiKhachHang() {
		return diaChiKhachHang;
	}
	public void setDiaChiKhachHang(String diaChiKhachHang) {
		this.diaChiKhachHang=diaChiKhachHang;
	}
	public int getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(int maCongTo) {
		this.maCongTo=maCongTo;
	}
}
