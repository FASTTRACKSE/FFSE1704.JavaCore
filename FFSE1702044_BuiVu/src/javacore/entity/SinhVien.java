package javacore.entity;

import java.util.Scanner;

public class SinhVien {
	String fullName;
	int maSinhVien,LP1,LP2,LP3;
	float diemTrungBinh;
	public void Input() {
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
	
	public void DiemTrungBinh() {
		diemTrungBinh=(LP1+LP2+LP3)/3;
	}
	public void Output() {
		System.out.println("+--------------------------------+");
		System.out.println("|Tên Sinh Viên: " + fullName+"|" );
		System.out.println("|Mã Sinh Viên: "+maSinhVien+"|");
		System.out.println("|Điểm LP1 "+LP1+" Điểm LP2 "+LP2+" Điểm LP3 "+LP3+"|");
		System.out.println("|Điểm Trung Bình "+diemTrungBinh+"             |");
		System.out.println("+--------------------------------+");
	}
}
