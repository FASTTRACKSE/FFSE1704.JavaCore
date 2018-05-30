package khaibaomang;

import java.util.Scanner;

public class khaibaomang {


	public static void main(String[] args) {
		// khai bao 
		int n;
		Scanner N = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		n = N.nextInt();
		//-- khởi tạo và cấp phát bộ nhớ cho mảng
		int array[] = new int[n];
		
		// phân thân trang code
		System.out.println("nhập các phần tử trong mảng: ");
		for(int i = 0; i < n; i++) {
			int j = i + 1;
			System.out.println("nhập phần tử thứ" + j + ":");
			array[i] = N.nextInt();
		}
		
		// hiển thị mảng vừa nhập
		System.out.println("mảng đã nhập: ");
		for (int i = 0; i < n; i++ ) {
			System.out.println(array[i]+ " ");
		}
		System.out.println(" ");
		// tim min max và vị trí
		int max = array[0];
		int min = array[0];
		int X = 0;
		int Y = 0;
		for(int i=0; i < n; i++) {
			if(max < array[i]) {
				max = array[i];
				X = i;
			}
			if (min > array[i]) {
				min = array[i];
				Y = i;
			}
		}
		System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + X);
		System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + Y);
	}
	
}
