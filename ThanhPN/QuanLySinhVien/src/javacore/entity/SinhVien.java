package javacore.entity;

public class SinhVien {
private String tenSinhVien;
private int namSinh;
private String gioiTinh;
public int diemLP1;
public int diemLP2;
public int diemLP3;

public SinhVien(){
	// 
}
public SinhVien(String tenSinhVien, int namSinh) {
	this.tenSinhVien = tenSinhVien;
	this.namSinh = namSinh;
	
}

public SinhVien(String tenSinhVien, int namSinh, String gioiTinh,  int diemLP1, int diemLP2, int diemLP3) {
	this.tenSinhVien = tenSinhVien;
	this.namSinh = namSinh;
	this.gioiTinh = gioiTinh;
	this.diemLP1 = diemLP1;
	this.diemLP2 = diemLP2;
	this.diemLP3 = diemLP3;
	
}

public String gettenSinhVien() {
	return tenSinhVien;
	
}
public void settenSinhVien(String tenSinhVien) {
	this.tenSinhVien = tenSinhVien;
	
}
public int getnamSinh() {
	return namSinh;
	
}
public void setnamSinh(int namSinh) {
	this.namSinh = namSinh;
}

public String getgioiTinh() {
	return gioiTinh;
}

public void setgioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}

public int getdiemLP1() {
	return diemLP1;
}


public void setdiemLP1(int diemLP1) {
	this.diemLP1 = diemLP1;
}

public int getdiemLP2() {
	return diemLP2;
}

public void setdiemLP2(int diemLP2) {
	this.diemLP2 = diemLP2;
}

public int getdiemLP3() {
	return diemLP3;
}

public void setdiemLP3(int diemLP3) {
	this.diemLP3 = diemLP3;
}




public double tinhDiemTrungBinhMon() {
		return (diemLP1 + diemLP2 + diemLP3) * 1.0 / 3;
	}





public double tinhTuoi() {
		return (2018 - namSinh);
	}

public String toString() {
	return " Sinh Viên : " + this.tenSinhVien + " - " + this.namSinh + " - " + this.gioiTinh + " - ";
	
}








}

