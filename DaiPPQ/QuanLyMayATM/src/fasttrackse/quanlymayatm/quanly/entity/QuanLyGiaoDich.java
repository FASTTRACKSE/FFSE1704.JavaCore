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
public class QuanLyGiaoDich {
	private String MaGD;
	private String MaMay;
	private String MaKH;
	private String MaThe;
	private String SoTien;
	private String LoaiGD;

	public QuanLyGiaoDich() {
		// TODO Auto-generated constructor stub
	}
	
	public QuanLyGiaoDich(String maGD2, String maMay2, String tenKH, String maThe2, String soTien2, String moTa) {
		super();
		this.MaGD = maGD2;
		this.MaMay = maMay2;
		this.MaKH = tenKH;
		this.MaThe = maThe2;
		this.SoTien = soTien2;
		this.LoaiGD = moTa;
	}

	public String getMaGD() {
		return MaGD;
	}

	public void setMaGD(String maGD) {
		MaGD = maGD;
	}

	public String getMaMay() {
		return MaMay;
	}

	public void setMaMay(String maMay) {
		MaMay = maMay;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getMaThe() {
		return MaThe;
	}

	public void setMaThe(String maThe) {
		MaThe = maThe;
	}

	public String getSoTien() {
		return SoTien;
	}

	public void setSoTien(String soTien) {
		SoTien = soTien;
	}

	public String getLoaiGD() {
		return LoaiGD;
	}

	public void setLoaiGD(String loaiGD) {
		LoaiGD = loaiGD;
	}
}
