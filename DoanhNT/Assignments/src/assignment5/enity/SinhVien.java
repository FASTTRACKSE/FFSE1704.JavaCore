package assignment5.enity;

import java.util.Scanner;

public class SinhVien {

	String hoTenSV;
	int namSinhSV;

	public void Input() {
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhập Họ và Tên SV: ");
		hoTenSV = myInput.nextLine();
		
		System.out.print("Nhập năm sinh SV: ");
		namSinhSV = myInput.nextInt();
	}
	public void Output() {
		System.out.println("Họ và tên: " + hoTenSV + " - Năm sinh: " + namSinhSV);
	}

}
