package quanlycanbo.entity;

public class GiangVien extends CanBo {
		private String khoa;
		private String trinhDo;
		private int soTietDay;
	public GiangVien(String hoTen, double heSoLuong, String khoa,String trinhDo,
			int soTietDay) {
		super(hoTen, heSoLuong);
		this.khoa=khoa;
		this.trinhDo=trinhDo;
		this.soTietDay=soTietDay;
		
		
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
	public double tinhLuong() {
		
			double tinhLuong=0;
			if("Cử nhân".equals(getTrinhDo())) {
				return (this.heSoLuong * 730) + (2000) + (this.soTietDay * 45);
			}else if("Thạc sĩ".equals(getTrinhDo())) {
				return (this.heSoLuong * 730) +(1000) + (this.soTietDay * 45);
			}else if("Tiến sĩ".equals(getTrinhDo())) {
				return (this.heSoLuong * 730) + (500) + (this.soTietDay * 45);
			}
			
			return tinhLuong;

		}
}
