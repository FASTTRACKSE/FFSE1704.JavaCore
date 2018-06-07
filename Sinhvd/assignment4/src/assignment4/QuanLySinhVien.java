package assignment4;

import java.util.Scanner;

public class QuanLySinhVien {
	private String tenSinhVien;
	private String gioiTinh;
	private String inGt;
	 int namSinh;
	 int diemLP1;
	 int diemLP2;
	 int diemLP3;


	public QuanLySinhVien(String tenSinhVien,String gioiTinh,int namSinh,int diemLP1,int diemLP2,int diemLP3) {
		this.tenSinhVien=tenSinhVien;
		this.gioiTinh=gioiTinh;
		this.namSinh=namSinh;
		this.diemLP1=diemLP1;
		this.diemLP2=diemLP2;
		this.diemLP3=diemLP3;
	}
	public String getSinhVien(){
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh=gioiTinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
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
	public int tinhTuoi() {
		return (2018 - namSinh);
	}
	public double tinhDiemTrungBinhMon() {
		return (diemLP1 + diemLP2 + diemLP3)/ 3;
	}
	public String xepLoai() {
		String ketqua;
		if(tinhDiemTrungBinhMon()<5) {
			ketqua= "yếu";
		}else if(tinhDiemTrungBinhMon()<6.5) {
			ketqua= "Trung Bình";
		}else if(tinhDiemTrungBinhMon()<8.5) {
			ketqua= "Khá";
		}else {
			ketqua= "Giỏi";
		}
		return ketqua;
	}
	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien+" -- Giới Tính: "+this.gioiTinh + "----|\n|----------- ";
	}
	
}