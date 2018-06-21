package fasttrackse.qltt.entity;

public class GiangVien extends CanBo {
	private String tenKhoa;
	private String trinhDo;
	private int soTietDay;

	public GiangVien(String tenCB, int phuCap, double hsLuong, String tenKhoa, String trinhDo, int soTietDay) {
		super(tenCB, phuCap, hsLuong);
		this.tenKhoa = tenKhoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}

	public double tinhLuong() {
		return hsLuong * 730 + phuCap + soTietDay * 45;
	}
}
