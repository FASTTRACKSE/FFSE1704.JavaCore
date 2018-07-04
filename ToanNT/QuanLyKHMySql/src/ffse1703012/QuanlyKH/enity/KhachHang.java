package ffse1703012.QuanlyKH.enity;

public class KhachHang {
	int maKH;
	String hoTen;
	String diaChi;
	String ngaySinh;
	String gioiTinh;
	int sDT;
	public KhachHang( int maKH, String hoTen, String diaChi, String ngaySinh, String gioiTinh, int sDT) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sDT= sDT;
	}
	public KhachHang() {
		
	}
	
	public int getSDT() {
		return sDT;
	}
	public void setSDT(int sDT) {
		this.sDT= sDT;
	}
	
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	
	
}
