/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.entity;


public class GiangVien extends NhanVien {
	private String tenGV;
	private String khoa;
	private String trinhDo;
	private int soTietDayTrongThang;
	private double heSoLuong;
	
	public GiangVien(String tenGV, String khoa, String trinhDo, int soTietDayTrongThang, float heSoLuong) {
		this.tenGV = tenGV;
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDayTrongThang = soTietDayTrongThang;
		this.heSoLuong = heSoLuong;
	}

	public GiangVien(String tenGV2, String khoa2, String trinhDo2, int soTietDay, double heSoLuong2) {
		// TODO Auto-generated constructor stub
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
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

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public double tinhLuong() {

		double luong = 0;

		if ("Cử nhân".equals(getTrinhDo())) {
			luong = (this.heSoLuong * 730) + 300 + (this.soTietDayTrongThang * 45);
		} else {
			if ("Thạc sĩ".equals(getTrinhDo())) {
				luong = (this.heSoLuong * 730) + 500 + (this.soTietDayTrongThang * 45);
			} else {
				if ("Tiến sĩ".equals(getTrinhDo())) {
					luong = (this.heSoLuong * 730) + 1000 + (this.soTietDayTrongThang * 45);
				}
			}
		}

		return luong;

	}

}
