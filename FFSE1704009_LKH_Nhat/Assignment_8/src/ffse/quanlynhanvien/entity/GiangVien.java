package ffse.quanlynhanvien.entity;

public class GiangVien extends CanBo {
	// private String tenGV;
	private String khoa;
	private String trinhDo;
	// private int phuCap;
	private int soTietDay;
	private double heSoLuong;

	public GiangVien(String tenCanBo, String khoa, String trinhDo, int soTietDay, double heSoLuong) {
		super(tenCanBo);
		// this.tenGV = tenGV;
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		// this.phuCap = phuCap;
		this.soTietDay = soTietDay;
		this.heSoLuong = heSoLuong;
	}

	// public String getTenGV() {
	// return tenGV;
	// }
	//
	// public void setTenGV(String tenGV) {
	// this.tenGV = tenGV;
	// }

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

	// public int getPhuCap() {
	// return phuCap;
	// }
	//
	// public void setPhuCap(int phuCap) {
	// this.phuCap = phuCap;
	// }

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
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

		if ("Cử nhân".equals(getTrinhDo()) || "Cử Nhân".equals(getTrinhDo()) || "cử nhân".equals(getTrinhDo())) {
			luong = (this.heSoLuong * 730) + 300 + (this.soTietDay * 45);
		} else {
			if ("Thạc sĩ".equals(getTrinhDo()) || "thạc sĩ".equals(getTrinhDo()) || "Thạc Sĩ".equals(getTrinhDo())) {
				luong = (this.heSoLuong * 730) + 500 + (this.soTietDay * 45);
			} else {
				if ("Tiến sĩ".equals(getTrinhDo()) || "Tiến Sĩ".equals(getTrinhDo())
						|| "tiến sĩ".equals(getTrinhDo())) {
					luong = (this.heSoLuong * 730) + 1000 + (this.soTietDay * 45);
				}
			}
		}

		return luong;

		// return (this.heSoLuong*730) + this.phuCap + (this.soTietDay * 45);
	}

}
