package ffse.quanlithongtin.enity;

public class GiangVien extends ThongTin  {
	// private String hoTenGV;
	private String khoa;
	private String trinhDo;
	//private String phuCap;
	private int soTietDay;
	private double heSoLuong;
	
	public GiangVien() {
		super();
	}
	
	public GiangVien(String hoTen, String khoa, String trinhDo,  int soTietDay, double heSoLuong) {
		super();
		// this.hoTenGV = hoTenGV;
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		//this.phuCap = phuCap;
		this.soTietDay = soTietDay;
		this.heSoLuong = heSoLuong;
	}

	/* public String getHoTenGV() {
		return hoTenGV;
	}

	public void setHoTenGV(String hoTenGV) {
		this.hoTenGV = hoTenGV;
	} */

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

	/* public String getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(String phuCap) {
		this.phuCap = phuCap;
	} */

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
	
	public double tinhLuong() {

		double luong = 0;

		if ("Cử nhân".equals(getTrinhDo())) {
			luong = (this.heSoLuong * 730) + 300 + (this.soTietDay * 45);
		} else {
			if ("Thạc sĩ".equals(getTrinhDo())) {
				luong = (this.heSoLuong * 730) + 500 + (this.soTietDay * 45);
			} else {
				if ("Tiến sĩ".equals(getTrinhDo())) {
					luong = (this.heSoLuong * 730) + 1000 + (this.soTietDay * 45);
				}
			}
		}

		return luong;

		
	}

}
