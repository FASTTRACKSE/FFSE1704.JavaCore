package BaiTapVeMang;

import java.util.Scanner;

public class BaiTapVeMang {
	public static void main(String[] args) {
		
		//Khai báo
		int n;
		Scanner N = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		n = N.nextInt();
		//-- khởi tạo và cấp phát bộ nhớ cho mảng
		int array[] = new int[n];
		
		//phần thân trang code
		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			System.out.print("Nhập phần tử thứ " + j + ": ");
			array[i] = N.nextInt();
		}

		//-- Hiển thị mảng vừa nhập
		System.out.println("Mảng đã nhập: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
		// --Tìm min max và vị trí
		int max = array[0];
		int min = array[0];
		int a = 0;
		int b = 0;	
		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
				max = array[i];
				a = i;
			}
			if (min > array[i]) {
				min = array[i];
				b = i;
			}
		}
		System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + a);
		System.out.println("");

		System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + b);
	}

}