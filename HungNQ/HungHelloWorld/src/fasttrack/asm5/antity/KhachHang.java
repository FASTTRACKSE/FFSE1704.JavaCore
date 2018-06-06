package fasttrack.asm5.antity;

public class KhachHang {
	int maKhachHang;
	String tenKhachHang;
	String diaChi;
	int maCongTo;

	public KhachHang(int maKhachHang, String tenKhachHang, String diaChi, int maCongTo) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.maCongTo = maCongTo;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		diaChi = diaChi;
	}

	public int getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(int maCongTo) {
		maCongTo = maCongTo;
	}

	public int hienThi() {
		return maCongTo;
	}
}
