package fasttrack.quanlykhachhang.entity;

public class KhachHang {
	int ID;
	String maKH;
	String tenKH;
	String diaCHi;
	String ngaySinh;
	String gioiTinh;
	String soDT;
	int n ;

	public KhachHang(int ID, String maKH, String tenKH, String diaCHi, String ngaySinh, String gioiTinh, String soDT) {
		super();
		this.ID = ID;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaCHi = diaCHi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKH, String tenKH, String diaCHi, String ngaySinh, String gioiTinh, String soDT) {
		
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaCHi = diaCHi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		
	}
	

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		ID = ID;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaCHi() {
		return diaCHi;
	}

	public void setDiaCHi(String diaCHi) {
		this.diaCHi = diaCHi;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

}
