package fasttrackse.assignment8.entity;

public abstract class CanBo {
	protected String tenCB;
	protected long phuCap;
	protected double hsLuong;
	
	public CanBo(String hoTen, long phuCap, double hsLuong) {
		this.tenCB = hoTen;
		this.phuCap = phuCap;
		this.hsLuong = hsLuong;
	}

	public abstract double tinhLuong();
	
	/**
	 * @return the tenCB
	 */
	public String getTenCB() {
		return tenCB;
	}
	/**
	 * @param tenCB the tenCB to set
	 */
	public void setTenCB(String tenCB) {
		this.tenCB = tenCB;
	}
	/**
	 * @return the phuCap
	 */
	public long getPhuCap() {
		return phuCap;
	}
	/**
	 * @param phuCap the phuCap to set
	 */
	public void setPhuCap(long phuCap) {
		this.phuCap = phuCap;
	}
	/**
	 * @return the hsLuong
	 */
	public double getHsLuong() {
		return hsLuong;
	}
	/**
	 * @param hsLuong the hsLuong to set
	 */
	public void setHsLuong(double hsLuong) {
		this.hsLuong = hsLuong;
	}
	
}
