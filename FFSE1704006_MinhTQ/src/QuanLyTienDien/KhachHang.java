package QuanLyTienDien;

public class KhachHang {
	protected int maKhachHang;
	protected String tenKhachHang;
	protected String diaChi;
	protected int maCongTo;

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
		this.diaChi = diaChi;
	}

	public int getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(int maCongTo) {
		this.maCongTo = maCongTo;
	}

}
