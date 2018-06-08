package fasttrackse.javacore.assignment3;

import java.util.Scanner;

public class BaiTapMang {

	public static void main(String[] args) {
		// Phần khai báo
		int N; // Tổng số phần tử mảng
		int[] myArray;
		int gtMax, gtMin, vtMax, vtMin;
		
		Scanner myInput = new Scanner(System.in);
		
		// Phần thân
		
		// 1. Nhập mảng
		System.out.print("Mời bạn nhập tổng số phần tử mảng N = ");
		N = myInput.nextInt();
		
		// Khởi tạo mảng N phần tử
		myArray = new int[N];
		
		// Vòng lặp để nhập từng phần tử mảng myArray
		for (int i=0; i<N; i++) {
			System.out.print("Mời bạn nhập giá trị phần tử " + (i+1) + " : ");
			myArray[i] = myInput.nextInt();
		}
		
		// In mảng
		System.out.print("Danh sách phần tử mảng:");
		for (int i=0; i<N; i++) {
			System.out.print(myArray[i] + " ");			
		}
		
		// Tìm MIN, MAX, Vị trí MIN, MAX tương ứng
		
		gtMin = myArray[0];
		vtMin = 0;
		gtMax = myArray[0];
		vtMax = 0;
		
		
		
		// Kết thúc
		myInput.close();
	}

}
