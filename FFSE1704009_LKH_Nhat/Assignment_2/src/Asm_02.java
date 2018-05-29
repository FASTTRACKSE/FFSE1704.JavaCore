
/************************************************* 
 * Assignment02_in_mang
 * @author: LEE KHAR HOONG NHAATJ------ASM_JAVA_02
 *Date: 29-05-2018
 *************************************************/

import java.util.Scanner;

public class Asm_02 {
	public static void main(String[] args) {

		int n;
		Scanner N = new Scanner(System.in);

		do {
			System.out.println("Nhập vào số phần tử của mảng: ");
			n = N.nextInt();
		} while (n < 0);

		// khởi tạo và cấp phát bộ nhớ cho mảng
		int array[] = new int[n];

		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			System.out.print("Nhập phần tử thứ " + j + ": ");
			array[i] = N.nextInt();
		}

		// Hiển thị mảng vừa nhập
		System.out.println("Mảng đã nhập: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
		int max = array[0];
		int min = array[0];
		int X = 0;
		int Y = 0;
		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
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
