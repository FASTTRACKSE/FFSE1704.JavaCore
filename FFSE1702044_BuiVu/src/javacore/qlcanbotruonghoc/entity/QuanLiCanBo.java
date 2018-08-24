package javacore.qlcanbotruonghoc.entity;

import java.io.Serializable;

public abstract class QuanLiCanBo implements Serializable{
	private String hoTen;
	private int heSoLuong;

	public QuanLiCanBo(String hoTen, int heSoLuong) {
		this.hoTen = hoTen;
		this.heSoLuong = heSoLuong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public abstract double tinhLuong();
	public String toString() {
		return hoTen + "\t" + heSoLuong +"\n";
		
	}
}
