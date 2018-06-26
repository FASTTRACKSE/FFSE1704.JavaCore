package javacore.fasttrackse.entity;

import java.util.Scanner;

public abstract class CanBo {
	protected String hoTen;
	protected double heSoLuong;

	Scanner myInput = new Scanner(System.in);

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

	public void nhap() {

		System.out.print("Nhập họ tên: ");
		String hoTen = myInput.nextLine();

		System.out.print("Nhập Hệ số lương: ");
		double heSoLuong = myInput.nextInt();

	}
}