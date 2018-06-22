package quanglyluongnhanvien.java.entity;

public class GiangVien extends Luong {
	private String khoa;
	private String trinhDo;
	private int soTietDay;
	private double heSoLuong;

	public GiangVien(int maNhanVien, String hoVaTen, String khoa, String trinhDo, int soTietDay, double heSoLuong) {
		super(maNhanVien, hoVaTen);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
		this.heSoLuong = heSoLuong;
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
		double tinhLuong = 0;
		if ("Cử nhân".equals(getTrinhDo())) {
			return (this.heSoLuong * 730) + (300) + (this.soTietDay * 45);
		} else if ("Thạc sĩ".equals(getTrinhDo())) {
			return (this.heSoLuong * 730) + (500) + (this.soTietDay * 45);
		} else if ("Tiến sĩ".equals(getTrinhDo())) {
			return (this.heSoLuong * 730) + (1000) + (this.soTietDay * 45);
		}

		return tinhLuong;

	}

}
