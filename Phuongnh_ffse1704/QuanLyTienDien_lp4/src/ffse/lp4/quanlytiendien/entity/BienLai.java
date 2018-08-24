package ffse.lp4.quanlytiendien.entity;

public class BienLai extends KhachHang {
	
	 int chiSoMoi;
	 String maCongTo,thangNhap,namNhap,ngayNhap,chuKy;
	 int tienDien;
	 
	 public BienLai(String maCongTo, String thangNhap, String namNhap, String ngayNhap,
			String chuKy, int chiSoMoi,int tienDien) {
		 this.maCongTo = maCongTo;
		this.chiSoMoi = chiSoMoi;
		this.thangNhap = thangNhap;
		this.namNhap = namNhap;
		this.ngayNhap = ngayNhap;
		this.chuKy = chuKy;
		this.tienDien = tienDien;
	}
	public int getChiSoMoi() {
		return chiSoMoi;
	}
	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}
	public String getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}
	public String getThangNhap() {
		return thangNhap;
	}
	public void setThangNhap(String thangNhap) {
		this.thangNhap = thangNhap;
	}
	public String getNamNhap() {
		return namNhap;
	}
	public void setNamNhap(String namNhap) {
		this.namNhap = namNhap;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getChuKy() {
		return chuKy;
	}
	public void setChuKy(String chuKy) {
		this.chuKy = chuKy;
	}
	public int getTienDien() {
		return tienDien;
	}
	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
	}
	
}
	
	
