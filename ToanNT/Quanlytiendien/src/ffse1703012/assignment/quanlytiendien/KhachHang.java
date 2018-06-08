package ffse1703012.assignment.quanlytiendien;

public class KhachHang {
	protected String hoTenChuNha;
	protected String soNha;
	protected String maKhachHang;
	protected int maSoCongTo;
	
	public KhachHang() {}

	public KhachHang(String hoTenChuNha, String soNha, String maKhachHang, int maSoCongTo) {
		this.hoTenChuNha = hoTenChuNha;
		this.maSoCongTo = maSoCongTo;
		this.maKhachHang = maKhachHang;
		this.soNha = soNha;
		
	}

	public  String getHoTenChuNha() {
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

	public  String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
}
