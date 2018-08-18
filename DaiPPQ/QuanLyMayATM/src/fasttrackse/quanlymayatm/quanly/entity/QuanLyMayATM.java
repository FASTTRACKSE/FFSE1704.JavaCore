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
public class QuanLyMayATM {
	private String MaMay;
	private String ThanhPho;
	private String Quan;
	private String Phuong;
	private String ViTri;
	private String TinhTrang;
	private String TongTien;

	public QuanLyMayATM() {
		// TODO Auto-generated constructor stub
	}

	public QuanLyMayATM(String thanhPho, String quan, String phuong, String viTri, String tinhTrang, String tongTien) {
		super();
		this.ThanhPho = thanhPho;
		this.Quan = quan;
		this.Phuong = phuong;
		this.ViTri = viTri;
		this.TinhTrang = tinhTrang;
		this.TongTien = tongTien;
	}

	public QuanLyMayATM(String maMay, String thanhPho, String quan, String phuong, String viTri, String tinhTrang, String tongTien) {
		super();
		this.MaMay = maMay;
		this.ThanhPho = thanhPho;
		this.Quan = quan;
		this.Phuong = phuong;
		this.ViTri = viTri;
		this.TinhTrang = tinhTrang;
		this.TongTien = tongTien;
	}
	
	public QuanLyMayATM(String maMay,  String viTri, String tinhTrang, String tongTien) {
		super();
		this.MaMay = maMay;
		this.ViTri = viTri;
		this.TinhTrang = tinhTrang;
		this.TongTien = tongTien;
	}

	public String getMaMay() {
		return MaMay;
	}

	public void setMaMay(String maMay) {
		MaMay = maMay;
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

	public String getViTri() {
		return ViTri;
	}

	public void setViTri(String viTri) {
		ViTri = viTri;
	}

	public String getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public String getTongTien() {
		return TongTien;
	}

	public void setTongTien(String tongTien) {
		TongTien = tongTien;
	}
}
