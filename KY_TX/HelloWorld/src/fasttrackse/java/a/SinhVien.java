package fasttrackse.java.a;

import java.util.Scanner;

public class SinhVien {
	private String tenSinhVien;
	private int namSinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;
	public SinhVien(String tenSinhVien, int namSinh, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;

	}
	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien + " - " + this.namSinh;
	}
	public double tinhDiemTrungBinhMon() {
		return (diemLP1 + diemLP2 + diemLP3) * 1.0 / 3;
	}	
}
