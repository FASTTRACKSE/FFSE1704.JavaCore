package fasttrackse.bai1.assignment;

import java.util.Scanner;

public class Mangsonguyen {

	private static Scanner myInput;

	public static void main(String[] args) {
		int size; // Kích thước mảng nhập từ bàn phím
		myInput = new Scanner(System.in);
		System.out.print("Hãy nhập số phần tử của mảng: ");
		size = myInput.nextInt();

		// khai báo và cấp phát bộ nhớ cho mảng
		// mảng này có tên là array và kích thước = size
		int[] array = new int[size];

		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + " : ");
			array[i] = myInput.nextInt(); // nhập giá trị cho phần tử
		}

		// Hiển thị các phần tử trong mảng
		System.out.println();
		System.out.print("Danh sách mảng: ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + ", ");
		}

		// Giá trị lớn nhất, nhỏ nhất
		int max = array[0], min = array[0], vitrimax = 0, vitrimin = 0;
		System.out.println();
		for (int j = 0; j < size; j++) {
			if (max <= array[j]) {
				max = array[j];
				vitrimax = j + 1;
			}
			if (min >= array[j]) {
				min = array[j];
				vitrimin = j + 1;
			}
		}
		System.out.println("Giá trị lớn nhất của mảng là: " + max + ", vị trí thứ " + vitrimax + " trong mảng");
		System.out.println("Giá trị nhỏ nhất của mảng là: " + min + ", vị trí thứ " + vitrimin + " trong mảng");

	}

}
