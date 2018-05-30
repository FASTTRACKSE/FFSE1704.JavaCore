/***********************
 Bài tập Assignment 3
 Prog : BÀI TẬP VỀ MẢNG 
 Outhor : Nguyễn Ngọc Khoa
 Date : 29-May-2018
 
************************/
package ffse.khoa.bai5;

import java.util.Scanner;

public class BaiTapMang {	
	public static void main(String[] args) {
		int n;
		float mang[] = new float[10];
		Scanner sc = new Scanner(System.in);
		System.out.print("1/");
		System.out.print("Xin Nhập Số Lượng Phần Tử Của Mảng : ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập Phần Tử" + " " + i + " " + "Của Mảng : ");
			mang[i] = sc.nextFloat();
		}
		float max = mang[0];
		float min = mang[0];
		int vitriMax = 0;
		int vitriMin = 0;
		// Vòng Lặp tính min max
		for (int i = 0; i < n; i++) {
			if (mang[i] > max) {
				max = mang[i];
				vitriMax = i;

			}
			if (mang[i] < min) {
				min = mang[i];
				vitriMin = i;
			}
		}
		
		System.out.print("2/");
		System.out.println(" Mảng N có  giá trị lớn nhất là :" + max);		
		System.out.println("   Mảng N có giá trị nhỏ nhất là : " + min);
		
		System.out.print("3/");
		System.out.println(" Phần tử " + max + " ở vị trí thứ " + vitriMax);		
		System.out.println("   Phần tử " + min + " ở vị trí thứ " + vitriMin);

	}

	

	
}
