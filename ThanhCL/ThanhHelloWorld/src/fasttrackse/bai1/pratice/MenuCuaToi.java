package fasttrackse.bai1.pratice;

import java.util.Scanner;

public class MenuCuaToi {

	public static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		int myOption = 0;
		while (myOption != 4) {
			try {
				System.out.println("\nLUA CHON CHUC NANG");
				System.out.println("1. Chuong trinh phep cong");
				System.out.println("2. Chuong trinh GPTB2");
				System.out.println("3. Chuong trinh tim MIN MAX trong mang");
				System.out.println("4. Ket thuc chuong trinh");
				System.out.print("Lua chon cua ban: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {
					phepCong();
				} else if (myOption == 2) {
					giaiPTB2();
				} else if (myOption == 3) {
					xuLyMang();
				} else if (myOption == 4) {
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chi duoc nhap tu 1 den 5, hay nhap lai nhe ban!!!");
				myInput.nextLine();
			}
		}
		// Kết thúc chương trình

	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myInput.nextLine();
	}

	public static void phepCong() {
		System.out.println("Bai toan tim tong 2 so");
		System.out.println("----------------------");
		int a, b, c;

		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();

		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();

		c = a + b;

		System.out.printf("Tong cua %d + %d = %d \n", a, b, c);
		backToMainMenu();
	}

	public static void giaiPTB2() {
		System.out.println("Bai toan nhập thông tin sinh viên");
		System.out.print("Nhập tổng số sinh viên: ");
		int N = Integer.parseInt(myInput.nextLine());
		
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập họ tên: ");
			String name = myInput.nextLine();
			System.out.print("Nhập năm sinh: ");
			int year = Integer.parseInt(myInput.nextLine());
		}

		backToMainMenu();
	}

	public static void xuLyMang() {
		System.out.println("Bai toan tim MIN MAX trong mang");
		backToMainMenu();
	}

	public static void ketThuc() {
		System.out.println("Chuong trinh da ket thuc. Cam on cac ban!!!");
		// System.exit(0);
	}

}
