package ffse.asm.util;

public class SinhVien {
	int ID;
	String MaSV;
	String TenSV;
	String NgaySinh;
	String GioiTinh;
	String lopSV;

	public SinhVien(int ID,String tenSV,  String ngaySinh) {
		this.ID=ID;
		this.TenSV = tenSV;
		this.NgaySinh = ngaySinh;
	}

	public SinhVien(int iD, String maSV, String tenSV, String ngaySinh, String gioiTinh, String lopSV) {

		this.ID = iD;
		this.MaSV = maSV;
		this.TenSV = tenSV;
		this.NgaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.lopSV = lopSV;
	}

	public SinhVien(String maSV, String tenSV, String diaChi, String ngaySinh, String gioiTinh, String soDT) {

		this.MaSV = maSV;
		this.TenSV = tenSV;
		this.NgaySinh = ngaySinh;
		this.GioiTinh = gioiTinh;
		this.lopSV = lopSV;
	}

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the maKH
	 */
	public String getMaKH() {
		return MaSV;
	}

	/**
	 * @param maKH
	 *            the maKH to set
	 */
	public void setMaKH(String maSV) {
		MaSV = maSV;
	}

	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return TenSV;
	}

	/**
	 * @param tenKH
	 *            the tenKH to set
	 */
	public void setTenKH(String tenSV) {
		TenSV = tenSV;
	}


	/**
	 * @return the ngaySinh
	 */
	public String getNgaySinh() {
		return NgaySinh;
	}

	/**
	 * @param ngaySinh
	 *            the ngaySinh to set
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
	 * @param gioiTinh
	 *            the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	/**
	 * @return the soDT
	 */
	public String getlopSV() {
		return lopSV;
	}

	/**
	 * @param soDT
	 *            the soDT to set
	 */
	public void setlopSV(String lopSV) {
		this.lopSV = lopSV;
	}
}