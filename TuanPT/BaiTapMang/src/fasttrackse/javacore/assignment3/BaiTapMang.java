package fasttrackse.javacore.assignment3;

import java.util.Scanner;

public class BaiTapMang {

	public static void main(String[] args) {
		// Phần khai báo
		int N; // tổng số phần tử mảng
		int[] myArray;
		int gtMax, gtMin, vtMax, vtMin;
		Scanner myInput = new Scanner(System.in);

		// Phần thân
		// 1.Nhập mảng
		System.out.print("Mời bạn nhập tổng số phần tử mảng N = ");
		N = myInput.nextInt();

		// Khởi tạo mảng N phần tử
		myArray = new int[N];

		// Vòng lặp để nhập từng phần tử mảng myArray
		for (int i = 0; i < N; i++) {
			System.out.print("Mời bạn nhập giá trị phần tử " + (i + 1) + " : ");
			myArray[i] = myInput.nextInt();
		}
		// In mảng
		System.out.println("Danh sách phần tử mảng:");
		for (int i = 0; i < N; i++) {
			System.out.println(myArray[i] + " ");
		}
		// Tìm MIN,MAX, vị trí MIN, vị trí MAX tương ứng
		gtMin = myArray[0];
		vtMin = 1;
		gtMax = myArray[0];
		vtMax = 1;
		for (int i = 0; i < N; i++) {
			if (myArray[i] < gtMin) {
				gtMin = myArray[i];
				vtMin = i + 1;
			}
			if (myArray[i] > gtMax) {
				gtMax = myArray[i];
				vtMax = i + 1;
			}
			System.out.println("Giá trị nhỏ nhất là: " + gtMin + "; Nằm ở vị trí thứ " + vtMin);
			System.out.println("Giá trị lớn nhất là: " + gtMax + "; Nằm ở vị trí thứ " + vtMax);

		}
		//Sắp xếp các giá trị của mảng
		
	}

}
