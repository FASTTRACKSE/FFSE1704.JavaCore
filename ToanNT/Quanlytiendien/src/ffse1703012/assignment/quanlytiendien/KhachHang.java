package ffse1703012.assignment.quanlytiendien;

public class KhachHang {
	private String hoTenChuNha;
	private String maKhachHang;
	private String soNha;
	private int maSoCongTo;
	

	public KhachHang(String hoTenChuNha, String soNha, String maKhachHang, int maSoCongTo) {
		super();
		this.hoTenChuNha = hoTenChuNha;
		this.soNha = soNha;
		this.maSoCongTo = maSoCongTo;
		this.maKhachHang = maKhachHang;

	}

	public String getHoTenChuNha() {
		return hoTenChuNha;
	}

	public void setHoTenChuNha(String hoTenChuNha) {
		this.hoTenChuNha = hoTenChuNha;

	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public int getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
}
