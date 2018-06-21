package fasttrackse.qltt.entity;

public abstract class CanBo {
	protected String tenCB;
	protected long phuCap;
	protected double hsLuong;

	public abstract double tinhLuong();
	public CanBo(String tenCB, long phuCap, double hsLuong) {
		this.tenCB = tenCB;
		this.phuCap = phuCap;
		this.hsLuong = hsLuong;
	}

	public String getTenCB() {
		return tenCB;
	}

	public void setTenCB(String tenCB) {
		this.tenCB = tenCB;
	}

	public long getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(long phuCap) {
		this.phuCap = phuCap;
	}

	public double getHsLuong() {
		return hsLuong;
	}

	public void setHsLuong(double hsLuong) {
		this.hsLuong = hsLuong;
	}

}
