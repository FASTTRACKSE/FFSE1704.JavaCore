package ffse1703012.bai1.practice;

import java.util.Scanner;

public class Assignment4 {
	public static Scanner print = new Scanner(System.in);
	public static int n;
	public static int[] array = new int[n];// khai báo mảng
	public static int bubbleSort;


	public static void main(String[] args) {

		menu();

	}

	public static void menu() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(">> Chương trình máy tính<< ");
			System.out.println("+---------------------------------------+");
			System.out.println("|	1. Phép cộng			|");
			System.out.println("|	2. Giải phương trình bậc 1	|");
			System.out.println("|	3. Giải phương trình bậc 2	|");
			System.out.println("|	4. Nhập mảng			|");
			System.out.println("|	5. Sắp xếp mảng			|");
			System.out.println("|	6. Thoát chương trình		|");
			System.out.println("+---------------------------------------+");
			System.out.println("Chọn chức năng: ");
			int answer = sc.nextInt();
			if (answer == 1) {
				phepcong();
			} else if (answer == 2) {
				phuongtrinhbac1();
			} else if (answer == 3) {
				phuongtrinhbac2();
			} else if (answer == 4) {
				nhapmang();
			} else if (answer == 5) {
				sapxepmang();
			} else if (answer == 6) {
				ketthuc();
			}
		}

	}

	public static void phepcong() {
		System.out.println("----------------------------");
		System.out.println("|	Giải phép cộng	   |");
		System.out.println("----------------------------");
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.print("Nhập số a: ");
		a = sc.nextInt();
		int b;
		System.out.print("Nhập số b: ");
		b = sc.nextInt();
		int c = a + b;
		System.out.print("Kết quả của " + a + " + " + b + " = " + c + "\n");
		System.out.println("Nhấn Enter để chọn chức năng khác");
		sc.nextLine();// hứng enter của nextInt();
		sc.nextLine();// hứng enter của bàn phím

	}

	public static void phuongtrinhbac1() {
		int soA, soB;

		Scanner sc = new Scanner(System.in);

		System.out.println("----------------------------");
		System.out.println("|Giải phương trình bậc nhất|");
		System.out.println("----------------------------");
		System.out.println("Nhập số a: ");
		soA = sc.nextInt();
		System.out.println("Nhập số b: ");
		soB = sc.nextInt();
		if (soA == 0) {
			if (soB == 0) {
				System.out.println("Phương trình vô số nghiệm");
			} else {
				System.out.println("Phương trình vô nghiệm!");
			}
		} else {
			System.out.println("Phương trình có nghiệm X = " + (-soB / soA));
		}
		System.out.println("Nhấn Enter để chọn chức năng khác");
		sc.nextLine();
		sc.nextLine();
	}

	public static void phuongtrinhbac2() {

		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("|Giải phương trình bậc hai|");
		System.out.println("----------------------------");
		int a;
		System.out.println("Mời nhập sô a: ");
		a = sc.nextInt();
		int b;
		System.out.println("Mời nhập sô b: ");
		b = sc.nextInt();
		int c;
		System.out.println("Mời nhập sô c: ");
		c = sc.nextInt();

		double delta = Math.pow(b, 2) - 4 * a * c;
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("Phương trình vô số nghiệm");
				} else {
					System.out.println("Phương trình vô nghiệm!");
				}
			} else {
				System.out.println("Phương trình có nghiệm X = " + (-b / a));
			}
		} else {

			if (delta > 0) {
				System.out.println("Phương trình có hai nghiệm phân biệt X1= " + (-b + Math.sqrt(delta)) / (2 * a)
						+ " và X2= " + (-b - Math.sqrt(delta)) / (2 * a));
			} else if (delta < 0) {
				System.out.println("Phương trình vô nghiệm!");
			} else if (delta == 0) {
				System.out.println("Phương trình có nghiệm kép X1 = X2 = " + (-b / 2 * a));
			}
		}
		System.out.println("Nhấn Enter để chọn chức năng khác");
		sc.nextLine();
		sc.nextLine();

	}

	public static void nhapmang() {

		do {
			System.out.print("Nhập số phần tử của mảng: ");
			n = print.nextInt();
		} while (n <= 0);

		array = new int[n];// khai báo mảng
		System.out.println("Nhập phần tử của mảng: \n");// dùng \n để con trỏ xuống dòng tiếp theo
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);// %d: số thập phân, số nguyên
			array[i] = print.nextInt();
		}
		System.out.println("Các phần từ của mảng ban đầu: ");
		show(array);

	}

	public static void sapxepmang() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j >= 1; j--) {
				if (array[j] < array[j - 1]) {
					bubbleSort = array[j];
					array[j] = array[j - 1];
					array[j - 1] = bubbleSort;
				}
			}
		}
		System.out.println("Mảng sau khi sắp sếp: ");
		for (int t = 0; t < n; t++) {
			System.out.println(array[t] + " ");
		}
		System.out.println("Nhấn Enter để chọn chức năng khác");
		print.nextLine();
		print.nextLine();
	}

	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " \n");
		}

	}

	public static void ketthuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình.");
		System.exit(0);
	}

}
