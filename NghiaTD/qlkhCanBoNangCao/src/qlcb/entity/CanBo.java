package qlcb.entity;

import java.util.Scanner;

public abstract class CanBo {
	protected String hoTen;
	protected double heSoLuong;
//	protected int phuCap;
//	private String loaiCanBo;
	Scanner myInput = new Scanner(System.in);
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
	public void nhap() {
		
			
		
		System.out.print("Nhập họ tên: ");
		String hoTen = myInput.nextLine();
		
		System.out.print("Nhập Hệ số lương: ");
		double heSoLuong = myInput.nextInt();
		
	}
}

