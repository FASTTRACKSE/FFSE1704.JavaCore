package fasttrackse.javacore.sinhvien;

import java.util.Scanner;

public class SinhVien {
	private String tenSinhVien;
	private int namSinh;
	private String gioiTinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;

	public SinhVien(String tenSinhVien, int namSinh,String gioiTinh,int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getDiemLP1() {
		return diemLP1;
	}

	public void setDiemLP1(int diemLP1) {
		this.diemLP1 = diemLP1;
	}

	public int getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(int diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public int getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(int diemLP3) {
		this.diemLP3 = diemLP3;
	}

	public double tinhDiemTrungBinhMon() {
		return (diemLP1 + diemLP2 + diemLP3) * 1.0 / 3;
	}
	
	public String xepLoai() {
		String ketQua;
		if (tinhDiemTrungBinhMon() >= 8 ) {
			ketQua= "Giỏi";
		}else if (tinhDiemTrungBinhMon() >= 7 ) {
			ketQua= "Khá";
		}else if (tinhDiemTrungBinhMon() >= 5 ) {
			ketQua= "Trung bình";
		}else {
			ketQua= "Yếu";
		}
		return ketQua;
	}

	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien + "-" + this.namSinh + "-" + this.gioiTinh ;
	}

}