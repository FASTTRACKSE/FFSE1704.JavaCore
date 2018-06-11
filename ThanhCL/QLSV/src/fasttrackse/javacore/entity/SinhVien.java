package fasttrackse.javacore.entity;

import java.util.Scanner;

public class SinhVien {
	String hoTenSV;
	int namSinhSV;
	
	
	public void Input() {
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap ten SV: ");
		hoTenSV = myInput.nextLine();
		
		System.out.print("Nhap nam sinh SV: ");
		namSinhSV = myInput.nextInt();
	}
	
	public void Output() {
		System.out.println("Ho ten: " + hoTenSV + " -- Nam sinh: " + namSinhSV);
	}
}