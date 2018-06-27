package fasttrackse.assignment8.entity;

public class GiangVien extends CanBo {
	private String tenKhoa;
	private String trinhDo;
	private int soTietDay;
	
	public GiangVien(String tenCB, long phuCap, double hsLuong, String tenKhoa, String trinhDo, int soTietDay) {
		super(tenCB, phuCap, hsLuong);
		this.tenKhoa = tenKhoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	@Override
	public double tinhLuong() {
		return hsLuong * 730 + phuCap + soTietDay * 45;
	}

	/**
	 * @return the tenKhoa
	 */
	public String getTenKhoa() {
		return tenKhoa;
	}

	/**
	 * @param tenKhoa the tenKhoa to set
	 */
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	/**
	 * @return the trinhDo
	 */
	public String getTrinhDo() {
		return trinhDo;
	}

	/**
	 * @param trinhDo the trinhDo to set
	 */
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	/**
	 * @return the soTietDay
	 */
	public int getSoTietDay() {
		return soTietDay;
	}

	/**
	 * @param soTietDay the soTietDay to set
	 */
	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	

}
