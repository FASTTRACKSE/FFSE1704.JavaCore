package assignment5.main;

import entity.SinhVien;

public class QuanLySinhVien {

	public static void main(String[] args) {
		SinhVien sv1, sv2, sv3;
		SinhVien[] dsSinhVien;
		
		sv1 = new SinhVien();
		sv2 = new SinhVien();
		sv3 = new SinhVien();
		
		do {
			System.out.println("Nhập vào tổng số SV: ");
			soSV = myInput.nextInt();
		} while (soSV < 0);
		
		int soSVArray[] = new int[soSV];
		
		for (int i = 0; i < soSV; i++) {
			System.out.print("Nhập Họ và Tên SV thứ " + (i+1) + ": " );
			soSVArray = myInput.next
		}
		
		System.out.println("Nhập thông tin SV1 ");
		sv1.Input();
		
		System.out.println("Nhập thông tin SV2 ");
		sv2.Input();
		
		System.out.println("Nhập thông tin SV3 ");
		sv3.Input();
		
		sv1.Output();
		sv2.Output();
		sv3.Output();
		
	}

}
