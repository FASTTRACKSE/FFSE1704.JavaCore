/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.quanly.entity;

/**
 * @author QuangDai
 *
 */
public class QuanLyKhachHang {
	private String MaKH;
	private String TenKH;
	private String SoCMND;
	private String NamSinh;
	private String GioiTinh;
	private String DiaChi;
	private String ThanhPho;
	private String Quan;
	private String Phuong;
	private String Email;
	private String SoDT;
	private String SoTaiKhoang;
	private String SoDu;

	public QuanLyKhachHang() {
		// TODO Auto-generated constructor stub
	}

	public QuanLyKhachHang(String maKH, String tenKH, String soCMND, String namSinh, String gioiTinh, String diaChi,
			String thanhPho, String quan, String phuong, String email, String soDT, String soTaiKhoang, String soDu) {
		super();
		this.MaKH = maKH;
		this.TenKH = tenKH;
		this.SoCMND = soCMND;
		this.NamSinh = namSinh;
		this.GioiTinh = gioiTinh;
		this.DiaChi = diaChi;
		this.ThanhPho = thanhPho;
		this.Quan = quan;
		this.Phuong = phuong;
		this.Email = email;
		this.SoDT = soDT;
		this.SoTaiKhoang = soTaiKhoang;
		this.SoDu = soDu;
	}

	public QuanLyKhachHang(String tenKH, String soCMND, String namSinh, String gioiTinh, String diaChi, String thanhPho,
			String quan, String phuong, String email, String soDT, String soTaiKhoang, String soDu) {
		super();
		this.TenKH = tenKH;
		this.SoCMND = soCMND;
		this.NamSinh = namSinh;
		this.GioiTinh = gioiTinh;
		this.DiaChi = diaChi;
		this.ThanhPho = thanhPho;
		this.Quan = quan;
		this.Phuong = phuong;
		this.Email = email;
		this.SoDT = soDT;
		this.SoTaiKhoang = soTaiKhoang;
		this.SoDu = soDu;
	}

	public QuanLyKhachHang(String maKH, String tenKH, String soCMND, String namSinh, String gioiTinh, String diaChi,
			String email, String soDT, String soTaiKhoang, String soDu) {
		super();
		this.MaKH = maKH;
		this.TenKH = tenKH;
		this.SoCMND = soCMND;
		this.NamSinh = namSinh;
		this.GioiTinh = gioiTinh;
		this.DiaChi = diaChi;
		this.Email = email;
		this.SoDT = soDT;
		this.SoTaiKhoang = soTaiKhoang;
		this.SoDu = soDu;
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

	public String getSoCMND() {
		return SoCMND;
	}

	public void setSoCMND(String soCMND) {
		SoCMND = soCMND;
	}

	public String getNamSinh() {
		return NamSinh;
	}

	public void setNamSinh(String namSinh) {
		NamSinh = namSinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getThanhPho() {
		return ThanhPho;
	}

	public void setThanhPho(String thanhPho) {
		ThanhPho = thanhPho;
	}

	public String getQuan() {
		return Quan;
	}

	public void setQuan(String quan) {
		Quan = quan;
	}

	public String getPhuong() {
		return Phuong;
	}

	public void setPhuong(String phuong) {
		Phuong = phuong;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSoDT() {
		return SoDT;
	}

	public void setSoDT(String soDT) {
		SoDT = soDT;
	}

	public String getSoTaiKhoang() {
		return SoTaiKhoang;
	}

	public void setSoTaiKhoang(String soTaiKhoang) {
		SoTaiKhoang = soTaiKhoang;
	}

	public String getSoDu() {
		return SoDu;
	}

	public void setSoDu(String soDu) {
		SoDu = soDu;
	}

}
