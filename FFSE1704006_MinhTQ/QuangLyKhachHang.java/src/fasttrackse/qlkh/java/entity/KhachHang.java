package fasttrackse.qlkh.java.entity;

public class KhachHang {
	protected int id;
	protected String MaKH;
	protected String TenKH;
	protected String DiaChi;
	protected String NgaySinh;
	protected String GioiTinh;
	protected int SoDT;

	public KhachHang(int id, String maKH, String tenKH, String diaChi, String ngaySinh, String gioiTinh, int sdt) {

		this.id = id;
		MaKH = maKH;
		TenKH = tenKH;
		DiaChi = diaChi;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		this.SoDT = sdt;
	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSoDT() {
		return SoDT;
	}

	public void setSDT(int SoDT) {
		this.SoDT = SoDT;
	}

}
