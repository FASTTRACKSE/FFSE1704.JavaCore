package javacore.qlcanbotruonghoc.entity;

public class GiangVien extends QuanLiCanBo {
	private String khoa;
	private int soTietDay;
	private int chonTrinhDo;

	public GiangVien(String hoTen, int heSoLuong, String khoa, int chonTrinhDo, int soTietDay) {
		super(hoTen, heSoLuong);
		this.khoa = khoa;
		this.soTietDay = soTietDay;
		this.chonTrinhDo = chonTrinhDo;
	}

	public int getChonTrinhDo() {
		return chonTrinhDo;
	}

	public void setChonTrinhDo(int chonTrinhDo) {
		this.chonTrinhDo = chonTrinhDo;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		String TrinhDo = null;
		if (getChonTrinhDo() == 1) {
			TrinhDo = "Cử Nhân";
		} else if (getChonTrinhDo() == 2) {
			TrinhDo = "Thạc Sĩ";
		} else if (getChonTrinhDo() == 3) {
			TrinhDo = "Tiến Sĩ";
		}
		return TrinhDo;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}


	@Override
	public double tinhLuong() {
		double TinhLuong = 0;
		if (getChonTrinhDo() == 1) {
			TinhLuong = ((getHeSoLuong() * 730) + 300 + (getSoTietDay() * 45));
		} else if (getChonTrinhDo() == 2) {
			TinhLuong = ((getHeSoLuong() * 730) + 500 + (getSoTietDay() * 45));
		} else if (getChonTrinhDo() == 3) {
			TinhLuong = ((getHeSoLuong() * 730) + 1000 + (getSoTietDay() * 45));
		}
		return TinhLuong;
	}
}
