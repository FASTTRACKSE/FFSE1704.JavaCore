package Quanlytiendien.entity;

public class KhachHang {
	private String maKhachHang;
	private String hoTenKhachHang;
	private String diaChi;
	private int maSoCongTo;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang, String hoTenKhachHang, String diaChi, int maSoCongTo) {
		this.maKhachHang = maKhachHang;
		this.hoTenKhachHang = hoTenKhachHang;
		this.diaChi = diaChi;
		this.maSoCongTo = maSoCongTo;
	}

	public String getMaKhachHang() {
		return maKhachHang;

	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTenKhachHang() {
		return maKhachHang;

	}

	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;

	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getMaSoCongTo() {
		return maSoCongTo;

	}

	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

	public String toString() {
		return "Khách hàng: " + this.hoTenKhachHang + "\n *****  Mã khách Hàng: " + this.maKhachHang
				+ "\n ****** Địa chỉ: " + this.diaChi + "\n ***** Mã số công tơ: " + this.maSoCongTo + "\n ***** ";
	}

}
