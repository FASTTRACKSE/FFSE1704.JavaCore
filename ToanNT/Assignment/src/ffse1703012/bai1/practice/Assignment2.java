package ffse1703012.bai1.practice;

import java.util.Scanner;

public class Assignment2 {
	public static Scanner print = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập số phần tử của mảng: ");
		int n = print.nextInt();
		int[] array = new int[n];// khai báo mảng
		System.out.println("Nhập phần tử của mảng: \n");// dùng \n để con trỏ xuống dòng tiếp theo
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);// %d: số thập phân, số nguyên
			array[i] = print.nextInt();
		}
		System.out.println("Các phần từ của mảng: ");
		show(array);
		int max = array[0];// khởi tạo biến max và min bằng 0
		int min = array[0];
		int pmax = 0;
		int pmin = 0;
		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
				max = array[i];// nếu max nhỏ hơn phần tử nào trong mảng thì cho max bằng phần tử đó
				pmax = i;
			}
			if (min > array[i]) {
				min = array[i];// nếu min lớn hơn phần tử nào trong mảng thì cho min bằng phần tử đó
				pmin = i;
			}
		}
		System.out.println("Phần tử lớn nhất của mảng là " + max + " và nằm ở vị trí thứ " + pmax);
		System.out.println("Phần tử lớn nhỏ của mảng là " + min + " và nằm ở vị trí thứ " + pmin);

	}

	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}

}
