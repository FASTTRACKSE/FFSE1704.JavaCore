package ffse.khachhang.entity;

public class KhachHang {

	public int ID;
	public String maKH;
	public String TenKH;
	public String DiaChi;
	public String NgaySinh;
	public String GioiTinh;
	public String sdt;

	public KhachHang(int iD, String maKH, String tenKH, String diaChi, String ngaySinh, String gioiTinh, String sdt) {
		ID = iD;
		this.maKH = maKH;
		this.TenKH = tenKH;
		this.DiaChi = diaChi;
		this.NgaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.sdt = sdt;
	}

	public KhachHang(String maKH, String tenKH, String diaChi, String ngaySinh, String gioiTinh, String sdt) {
		this.maKH = maKH;
		this.TenKH = tenKH;
		this.DiaChi = diaChi;
		this.NgaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.sdt = sdt;
	}
	public KhachHang() {
	// to do something
	}
	public int getID() {
		return ID;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getSoDT() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
}
