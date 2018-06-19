package fasttrackse.asm5plus.main;

public class GiangVien {
	private String tenNv;
	private String khoaNV;
	private int songayCong;
	private int hesoLuong;
	private int trinhDo;
	private int phuCap;
	public String getTenNv() {
		return tenNv;
	}
	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}
	public String getKhoaNV() {
		return khoaNV;
	}
	public void setKhoaNV(String khoaNV) {
		this.khoaNV = khoaNV;
	}
	public int getSongayCong() {
		return songayCong;
	}
	public void setSongayCong(int sotietDay) {
		this.songayCong = sotietDay;
	}
	public int getHesoLuong() {
		return hesoLuong;
	}
	public void setHesoLuong(int hesoLuong) {
		this.hesoLuong = hesoLuong;
	}
	public int getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(int trinhDo) {
		this.trinhDo = trinhDo;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public GiangVien(String tenNv, String khoaNV, int sotietDay, int hesoLuong, int trinhDo, int phuCap) {
		this.tenNv = tenNv;
		this.khoaNV = khoaNV;
		this.songayCong = songayCong;
		this.hesoLuong = hesoLuong;
		this.trinhDo = trinhDo;
		this.phuCap = phuCap;
	}
	public double luongNv() {
		return getHesoLuong()*730+getPhuCap()+getSongayCong()*45;
	}
}

