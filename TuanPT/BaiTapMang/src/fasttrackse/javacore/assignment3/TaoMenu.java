package fasttrackse.javacore.assignment3;

import java.util.Scanner;

public class TaoMenu {
	public static void GiaiPhuongTrinhBacNhat() {
		int thamsoA, thamsoB;
		double nghiemX;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập tham số a =");
		thamsoA = myInput.nextInt();
		System.out.print("Nhập tham số b =");
		thamsoB = myInput.nextInt();

		if (thamsoA == 0) {
			if (thamsoB == 0) {
				System.out.print("Phuong trinh vo so nghiem");
			} else {
				System.out.print("Phuong trinh vo nghiem");
			}
		} else {
			nghiemX = -thamsoB * 1.0 / thamsoA;
			System.out.println("Phuong trinh co nghiem duy nhat : " + nghiemX);
		}
	}

	//// Pt bậc hai
	public static void GiaiPhuongTrinhBacHaiMotAn() {
		int a, b, c;
		double x;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập số a = ");
		a = myInput.nextInt();
		System.out.print("Nhập số b = ");
		b = myInput.nextInt();
		System.out.print("Nhập số c = ");
		c = myInput.nextInt();

		if (a == 0) {
			if (b == 0) {
				System.out.print("Phương trình vô nghiệm");
			} else {
				System.out.print("Phương trình có 1 nghiệm: " + "x = " + (-c / b));
			}
			return;
		}

		double dt = b * b - 4 * a * c;
		double x1;
		double x2;

		if (dt > 0) {
			x1 = ((-b + Math.sqrt(dt)) / (2 * a));
			x2 = ((-b - Math.sqrt(dt)) / (2 * a));
			System.out.println("Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2);
		} else if (dt == 0) {
			x1 = (-b / (2 * a));
			System.out.println("Phương trình có nghiệm kép: " + "x1 = x2 = " + x1);
		} else {
			System.out.println("Phương trình vô nghiệm!");

		}
	}

	// Nhập mảng
	public static void BaiTapMang() {
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
	}

	// Sắp xếp mảng
	public static void SapXepMang() {
		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập số phần tử của mảng: ");
		int n = myInput.nextInt();
		// khởi tạo arr
		int[] arr = new int[n];
		System.out.print("Nhập các phần tử của mảng: \n");
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = myInput.nextInt();
		}
		// sắp xếp dãy số theo thứ tự tăng dần
		sortASC(arr);
		System.out.println("Dãy số được sắp xếp tăng dần: ");
		show(arr);
	}

	/**
	 * sắp xếp mảng số nguyên theo thứ tự tăng dần
	 * 
	 * @param arr:
	 *            mảng các số nguyên
	 * @param n:
	 *            số phần tử của mảng
	 */
	public static void sortASC(int[] arr) {
		int temp = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int chon;
		do {
			System.out.println("***Menu***");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. PT bậc nhất một ẩn                   |");
			System.out.println("|2. PT bậc hai một ẩn                    |");
			System.out.println("|3. Nhập mảng                            |");
			System.out.println("|4. Sắp xếp mảng                         |");
			System.out.println("|5. Exit                                 |");
			System.out.println("+----------------------------------------+");
			System.out.println("Mời bạn chọn : ");
			chon = in.nextInt();
			switch (chon) {
			case 1:
				GiaiPhuongTrinhBacNhat();
				break;
			case 2:
				GiaiPhuongTrinhBacHaiMotAn();
				break;
			case 3:
				BaiTapMang();
				break;
			case 4:
				SapXepMang();
				break;
			case 5: {
				System.out.println("Ðã thoát!");
				System.exit(0);
			}
			}
		} while (chon != 0);
		

	}

}
