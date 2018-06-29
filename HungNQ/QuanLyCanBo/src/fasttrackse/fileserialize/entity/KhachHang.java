package fasttrackse.fileserialize.entity;

import java.io.Serializable;

public class KhachHang implements Serializable {
	String maKH;
	String tenKH;
	
	public KhachHang(String maKH, String tenKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
	}
	/**
	 * @return the maKH
	 */
	public String getMaKH() {
		return maKH;
	}
	/**
	 * @param maKH the maKH to set
	 */
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	/**
	 * @return the tenKH
	 */
	public String getTenKH() {
		return tenKH;
	}
	/**
	 * @param tenKH the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	
	public String toString() {
		return "Mã KH: " + this.maKH + " -- Tên KH: " + this.tenKH;
	}
	
}