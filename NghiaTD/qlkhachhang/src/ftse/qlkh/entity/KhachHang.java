package ftse.qlkh.entity;

public class KhachHang {
	int ID;
	String MaKH;
	String TenKH;
	String DiaChi;
	String NgaySinh;
	String GioiTinh;
	String soDT;
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int iD, String maKH, String tenKH, String diaChi, String ngaySinh, String gioiTinh, String soDT) {
		super();
		this.ID = iD;
		this.MaKH = maKH;
		this.TenKH = tenKH;
		this.DiaChi = diaChi;
		this.NgaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.soDT = soDT;
	}
	public KhachHang( String maKH, String tenKH, String diaChi, String ngaySinh, String gioiTinh, String soDT) {
		super();
		
		this.MaKH = maKH;
		this.TenKH = tenKH;
		this.DiaChi = diaChi;
		this.NgaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.soDT = soDT;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the maKH
	 */
	public String getMaKH() {
		return MaKH;
	}
	/**
	 * @param maKH the maKH to set
	 */
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return TenKH;
	}
	/**
	 * @param tenKH the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return DiaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	/**
	 * @return the ngaySinh
	 */
	public String getNgaySinh() {
		return NgaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return GioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	/**
	 * @return the soDT
	 */
	public String getSoDT() {
		return soDT;
	}
	/**
	 * @param soDT the soDT to set
	 */
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
}