package fasttrackse.asm8.entity;

public class GiangVien extends CanBo {
	public GiangVien(String tenCB, int phuCap, int heSoLuong, String khoaGV, String trinhDo, int soTietDay) {
		super(tenCB, phuCap, heSoLuong);
		this.khoaGV = khoaGV;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}
	private String khoaGV;
	private String trinhDo;
	private int soTietDay;
	public String getKhoaGV() {
		return khoaGV;
	}
	public void setKhoaGV(String khoaGV) {
		this.khoaGV = khoaGV;
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
	@Override
	public double luongNV() {
		// TODO Auto-generated method stub
		return heSoLuong*730+phuCap+soTietDay*45;
	}

}
