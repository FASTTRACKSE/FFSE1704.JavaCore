package Assignment3;

import java.util.Scanner;

public class TimPhantuCuaN {

	public static void main(String[] args) {
		System.out.println("*****************");
		System.out.println("Thêm phần tử N");
		System.out.println("****************** ");
		int n;
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử mảng :");
		n = nhap.nextInt();
		int array[] = new int[n];
		System.out.println("*********************************");
		System.out.println("In ra danh sách các phần tử của N");
		System.out.println("**********************************");
		for (int i = 0; i < n; i++) {

			System.out.println("nhập các phần tử thứ " + i + ":");
			array[i] = nhap.nextInt();
		}
		System.out.println("danh sách các mảng của n là : ");
		for (int q = 0; q < n; q++) {

			System.out.print(array[q] + "");
		}

		System.out.println("*****************");
		System.out.println("In ra giá trị lớn nhất và nhỏ nhất ");
		System.out.println("****************** ");

		int giatrimin = array[0];
		int giatrimax = array[0];
		for (int e = 0; e < array.length; e++) {
			if (array[e] < giatrimin) {
				giatrimin = array[e];
			}
			if (array[e] > giatrimax) {
				giatrimax = array[e];
			}
		}
		System.out.println("giá trị lớn nhất là : " + giatrimax + " ;");
		System.out.println("giá trị nhỏ nhất là : " + giatrimin + " ;");

		System.out.println("*****************");
		System.out.println("In ra vị trí lớn nhất và nhỏ nhất ");
		System.out.println("****************** ");
		String vitrimin = "";
		String vitrimax = "";
		for (int s = 0; s < array.length; s++) {
			if (array[s] == giatrimin) {
				vitrimin = "vị trí phần tử nhỏ nhất trong N là: " + s;
			}if(array[s] == giatrimax) {
				vitrimax = "vị trí phần tử lớn nhất trong N là " + s;
			
			}
		}
	System.out.println(vitrimax);
	System.out.println(vitrimin);
	
	}

}
