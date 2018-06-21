package fasttrackse.bai3.study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class oopMang {
	private String ten;
	private int tuoi;
	private String gioitinh;
	private double diemLP1;
	private double diemLP2;
	private double diemLP3;
	private double diemTB;
	private String xeploai;
	public void nhapMang() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		ten = sc.nextLine();
		System.out.println();
		System.out.print("Nhập tuổi: ");
		tuoi = sc.nextInt();
		System.out.println();
		System.out.print("Nhập giới tính: ");
		sc.nextLine();
		gioitinh = sc.nextLine();
		System.out.println();
		System.out.print("Nhập điểm LP1: ");
		diemLP1 = sc.nextInt();
		System.out.println();
		System.out.print("Nhập điểm LP2: ");
		diemLP2 = sc.nextInt();
		System.out.println();
		System.out.print("Nhập điểm LP3: ");
		diemLP3 = sc.nextInt();
		System.out.println();
		

	}
public void tinhDiemTrungBinh() {
	diemTB = (diemLP1+diemLP2+diemLP3)/3;
	System.out.println("Điểm TB: "+diemTB);
}
public void xepLoaiSV() {
	if(diemTB<5) {
		xeploai="Xếp loại: Yếu";
	}else if(diemTB<7 && diemTB>5) {
		xeploai="Xếp loại: Trung Bình";
	}else if(diemTB>7 && diemTB<8.5) {
		xeploai="Xếp loại: Khá";
	}else if(diemTB>8.5) {
		xeploai="Xếp loại: Giỏi";
	}
	System.out.println(xeploai);
}
	public void xuatMang() {
		System.out.println("Tên sinh viên là: " + ten);
		System.out.println("Tuổi sinh viên: " + tuoi);
		System.out.println("Giới tính: " +gioitinh);
		System.out.println("Điểm LP1: "+diemLP1);
		System.out.println("Điểm LP2: "+diemLP2);
		System.out.println("Điểm LP3: "+diemLP3);
	}
}