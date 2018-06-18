package quanlycanbo.entity;

public class GiangVien extends CanBo {
		private String khoa;
		private String trinhDo;
		private int soTietDay;
	public GiangVien(String hoTen, double heSoLuong, int phuCap, String khoa,String trinhDo,
			int soTietDay) {
		super(hoTen, heSoLuong, phuCap);
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
		return this.getHeSoLuong()*730+this.getPhuCap()+this.getSoTietDay()*45;
	}
}
