/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.entity;

public class GiangVien extends NhanVien {
	private String khoa;
	private String trinhDo;
	private int soTietDayTrongThang;
	
	public GiangVien(String ten, String khoa, String trinhDo, int phuCap, int soTietDayTrongThang, double heSoLuong) {
		super(ten, phuCap, heSoLuong);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDayTrongThang = soTietDayTrongThang;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	
	public int getsoTietDayTrongThang() {
		return soTietDayTrongThang;
	}

	public void setsoTietDayTrongThang(int soTietDayTrongThang) {
		this.soTietDayTrongThang = soTietDayTrongThang;
	}

	@Override
	public double tinhLuong() {
		double luong = getHeSoLuong()*730 + getPhuCap() + getsoTietDayTrongThang()*45;
		return luong;
	}

}
