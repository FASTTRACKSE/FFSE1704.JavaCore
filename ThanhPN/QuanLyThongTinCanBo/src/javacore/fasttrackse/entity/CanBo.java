package javacore.fasttrackse.entity;

import java.io.Serializable;

public abstract class CanBo implements Serializable {
	protected String hoTen;
	protected double heSoLuong;

	public abstract double tinhLuong();

	public CanBo(String hoTen, double heSoLuong) {
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;

	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

}