package ffse.qlkh.entity;

public class KhachHang {
	int ID;
	String MaKH;
	String TenKH;
	String DiaChi;
	String GioiTinh;
	String NgaySinh;
	String SoDT;

	public KhachHang(int iD, String maKH, String tenKH, String diaChi,String ngaySinh, String gioiTinh,  String soDT) {
		super();
		this.ID = iD;
		this.MaKH = maKH;
		this.TenKH = tenKH;
		this.DiaChi = diaChi;
		this.GioiTinh = gioiTinh;
		this.NgaySinh = ngaySinh;
		this.SoDT = soDT;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
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

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getSoDT() {
		return SoDT;
	}

	public void setSoDT(String soDT) {
		SoDT = soDT;
	}

}
