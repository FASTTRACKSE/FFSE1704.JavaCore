/**
 * 
 */
package ffse.ffse1704.quanly;

import java.util.Scanner;

public class QuanLySinhVien {
	String hoTenSinhVien;
	int namSinhSV;

	public void Input() {

		Scanner nhap = new Scanner(System.in);

		System.out.print("Nhập tên sinh viên: ");
		hoTenSinhVien = nhap.nextLine();

		System.out.print("Nhập năm sinh sinh viên: ");
		namSinhSV = nhap.nextInt();
	}

	public void Output() {
		//System.out.print(namSinhSV + " ");
//		for (int i = 0; i < namSinhSV - 1; i++) {
//			for (int j = i + 1; j <namSinhSV - 1; j++) {
//				if (namSinhSV[i] > namSinhSV[j]) {
//					Tang = namSinhSV[i];
//					namSinhSV[i] =namSinhSV[j];
//					namSinhSV[j] = Tang;
//				}
//			}
//		}
//
//		System.out.println(" ");
//		System.out.println("Mảng sau khi sắp xếp tăng là: ");
//		for (int i = 0; i < namSinhSV; i++) {
//			System.out.print(namSinhSV[i] + " ");
//		}
		System.out.println("Tên sinh viên: "+hoTenSinhVien+"--------- Năm sinh: "+namSinhSV);
		
		//return"Sinh Vien"+this.hoTenSinhVien+"------ Nam sinh"+this.namSinhSV;
	}
}
