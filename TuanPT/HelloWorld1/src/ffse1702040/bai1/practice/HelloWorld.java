package ffse1702040.bai1.practice;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		int n;
		float array[] = new float[100];
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhap so phan tu cua mang: ");
		n = nhap.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap phan tu thu " + i + " cua mang: ");
			array[i] = nhap.nextFloat();
		}
		float temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i < j && array[i] > array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
			if (i == 0)
				System.out.println(array[i]);
			else
				System.out.println("," + array[i]);
		}

	}

}
