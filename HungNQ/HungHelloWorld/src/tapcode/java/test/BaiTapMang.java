package tapcode.java.test;

import java.util.Scanner;

public class BaiTapMang {

	public static void main(String[] args) {
		//Khai báo
		int X;
		int[] myArray;
		int gtMin, gtMax, vtMin, vtMax;
		
		Scanner myInput = new Scanner(System.in);
		
		//Phần Thân
		System.out.print("Mời bạn nhập tổng số X = ");
		X = myInput.nextInt();
		
		myArray = new int[X];
		
		for(int i=0;i<X;i++) {
			System.out.print("Mời bạn nhập giá trị X = " + (i+1) + " : ");
			myArray[i] = myInput.nextInt();
		}
		
		//In mảng
		System.out.print("Danh sách phần tử mảng:");
		for(int i=0;i<X;i++) {
			System.out.print(myArray[i] + " ");
		}
		
		gtMin = myArray[0];
		vtMin = 0;
		gtMax = myArray[0];
		vtMax = 0;
		for(int i=0;i<X;i++) {
			if(gtMax < myArray[i]) {
				gtMax = myArray[i];
				vtMax = i+1;
			}
			if(gtMin > myArray[i]) {
				gtMin = myArray[i];
				vtMin = i+1;
			}
		}
		System.out.println("Phần tử lớn nhất của mảng là " + gtMax + " và ở vị trí " + vtMax);
		System.out.println("Phần tử nhỏ nhất của mảng là " + gtMin + " và ở vị trí " + vtMin);
		
		//Kết thúc
		myInput.close();
	}
}
