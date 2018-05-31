/************************
 *CtNhapDuLieuChoMang
 *Bùi Lê Anh Vũ
 *31/05/2018
 **********************/
package javacore.entity;

import java.util.Scanner;

public class SinhVien {
	private String tenSinhVien;
	private String gioiTinh;
	private int namSinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;
	/*public void Input() {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập Tên Sinh Viên : ");
		fullName = myInput.nextLine();
		System.out.print("Nhập Mã Sinh Viên :");
		maSinhVien =myInput.nextInt();
		System.out.print("Nhập Điểm LP1 của Sinh Viên :");
		LP1 =myInput.nextInt();
		System.out.print("Nhập Điểm LP2 của Sinh Viên :");
		LP2 =myInput.nextInt();
		System.out.print("Nhập Điểm LP3 của Sinh Viên :");
		LP3 =myInput.nextInt();
		}
	
	public float DiemTrungBinh() {
		return (LP1+LP2+LP3)/3;
	}
	public void Output() {
		System.out.println("+--------------------------------+");
		System.out.println("|Tên Sinh Viên: " + fullName+"|" );
		System.out.println("|Mã Sinh Viên: "+maSinhVien+"|");
		System.out.println("|Điểm LP1 "+LP1+" Điểm LP2 "+LP2+" Điểm LP3 "+LP3+"|");
		System.out.println("|Điểm Trung Bình "+diemTrungBinh+"             |");
		System.out.println("+--------------------------------+");
	}*/
	public SinhVien(String tenSinhVien,String gioiTinh,int namSinh,int diemLP1,int diemLP2,int diemLP3) {
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
	public void setGioiTinh() {
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
	
	public double tinhDiemTrungBinhMon() {
		return Math.round((diemLP1 + diemLP2 + diemLP3)/ 3);
	}
	/*public String xepLoai() {
		return xepLoai();
		
	}*/
	public String toString() {
		return "Sinh Viên: " + this.tenSinhVien+" -- Giới Tính: "+this.gioiTinh + "---|\n|-----------  Năm Sinh " + this.namSinh;
	}
	
}
