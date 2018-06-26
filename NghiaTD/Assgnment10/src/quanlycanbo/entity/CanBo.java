
package quanlycanbo.entity;
import java.io.Serializable;
import java.util.Scanner;

public abstract class CanBo implements Serializable {
	protected String hoTen;
	protected double heSoLuong;
//	protected int phuCap;
//	private String loaiCanBo;
	
	public abstract double tinhLuong();
	public  CanBo(String hoTen,double heSoLuong) {
		this.hoTen=hoTen;
		this.heSoLuong=heSoLuong;
//		this.phuCap=phuCap;
		//this.loaiCanBo=loaiCanBo;
		
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

//	public int getPhuCap() {
//		return phuCap;
//	}
//
//	public void setPhuCap(int phuCap) {
//		this.phuCap = phuCap;
//	}

//	public String getLoaiCanBo() {
//		return loaiCanBo;
//	}
//
//	public void setLoaiCanBo(String loaiCanBo) {
//		this.loaiCanBo = loaiCanBo;
//	}
	
}
