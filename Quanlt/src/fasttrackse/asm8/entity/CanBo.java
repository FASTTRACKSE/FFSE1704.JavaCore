package fasttrackse.asm8.entity;

public abstract class CanBo {
	protected String tenCB;
	protected int phuCap;
	protected int heSoLuong;
	public String getTenNV() {
		return tenCB;
	}
	public void setTenNV(String tenCB) {
		this.tenCB = tenCB;
	}
	public CanBo(String tenCB, int phuCap, int heSoLuong) {
		this.tenCB = tenCB;
		this.phuCap = phuCap;
		this.heSoLuong = heSoLuong;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public int getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public abstract double luongNV();
}
