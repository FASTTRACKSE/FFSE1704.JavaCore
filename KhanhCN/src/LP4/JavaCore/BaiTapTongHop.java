package LP4.JavaCore;

import java.util.Scanner;

public class BaiTapTongHop {

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		while (true) {
			System.out.println("Xin chào quý khách");
			System.out.println("+--------------------------+");
			System.out.println("| 1. Phương trình bậc nhất |");
			System.out.println("| 2. Phương trình bậc 2    |");
			System.out.println("| 3. Nhập mảng             |");
			System.out.println("| 4. Sắp xếp mảng tăng dần |");
			System.out.println("| 5. Kết thúc              |");
			System.out.println("+--------------------------+");
			System.out.println("Vui lòng chọn chức năng :");

			Scanner chon = new Scanner(System.in);
			int answer = chon.nextInt();

			if (answer == 1) {
				GiaiPhuongTrinhBacNhat();
			} else if (answer == 2) {
				GiaiPTBac2();
			} else if (answer == 3) {
				NhapMang();
			} else if (answer == 4) {
				SapXepMangTangDan();
			} else if (answer == 5) {
				SapXepMangGiamDan();
			} else if (answer == 6) {
				System.exit(0);
			}

		}
	}

	// PHƯƠNG TRÌNH BẬC NHẤT
	public static void GiaiPhuongTrinhBacNhat() {

		Scanner nhap = new Scanner(System.in);
		System.out.println("+---------------------+");
		System.out.println("|PHƯƠNG TRÌNH BẬC NHẤT|");
		System.out.println("+---------------------+");

		System.out.println("Nhập vào số a : ");
		int a = nhap.nextInt();

		System.out.println("Nhập vào số b : ");
		int b = nhap.nextInt();

		if (a == 0) {
			if (b == 0) {
				System.out.println(" Phương trình " + a + "x + " + b + " = 0 có vô số nghiệm");
			} else {
				System.out.println(" Phương trình " + a + "x + " + b + " = 0 có vô số nghiệm");
			}
		} else {

			float x;
			x = (-b / a);
			System.out.println("Phương trình có nghiệm là x = " + x);

		}
		System.out.println("Nhấn Enter để chọn chức năng khác !!!!");
		nhap.nextLine();
			

	}

	// PHƯƠNG TRÌNH BẬC 2
	public static void GiaiPTBac2() {

		Scanner nhap = new Scanner(System.in);
		System.out.println("+------------------+");
		System.out.println("|PHƯƠNG TRÌNH BẬC 2|");
		System.out.println("+------------------+");

		System.out.println("Nhập vào số a : ");
		float a = nhap.nextFloat();

		System.out.println("Nhập vào số b :");
		float b = nhap.nextFloat();

		System.out.println("Nhập vào số c ");
		float c = nhap.nextFloat();

		if (a == 0) {
			if (b == 0) {
				System.out.println(" Phương trình " + a + "x2 + " + b + "x + " + c + " = 0 vô nghiệm");
			} else {
				System.out.println(" Phương trình " + a + "x2 + " + b + "x + " + c + " = 0 có nghiệm là : " + (-c / b));
			}
			return;
		}

		float delta = (b * b) - (4 * a * c);

		if (delta > 0) {

			float x1 = (float) ((-b) + Math.sqrt(delta)) / (2 * a);
			float x2 = (float) ((-b) - Math.sqrt(delta)) / (2 * a);

			System.out.println("Phương trình " + a + "x2 + " + b + "x + " + c + " = 0 có 2  nghiệm là : ");
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);

		} else if (delta == 0) {

			float x = (-b / (2 * a));
			System.out.println("Phương trình " + a + "x2 + " + b + "x + " + c + " = 0 có nghiệm là :" + x);

		} else {

			System.out.println("Phương trình " + a + "x2 + " + b + "x + " + c + " = 0 vô nghiệm");
		}

		System.out.println("Nhấn Enter để chọn chức năng khác !!!!");
		nhap.nextLine();
		nhap.nextLine();

	}

	static float mang[];
	static int n;
	static int i;
	static int j;

	// NHẬP MẢNG
	public static void NhapMang() {

		// Phần khai báo

		Scanner nhap = new Scanner(System.in);

		// Thân chương trình
		System.out.println("+---------+");
		System.out.println("|NHẬP MẢNG|");
		System.out.println("+---------+");
		System.out.print("Xin nhập số lượng phần tử của mảng : ");

		n = nhap.nextInt();
		mang = new float[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + i + " của mảng :");
			mang[i] = nhap.nextFloat();

		}
		float max = mang[0];
		float min = mang[0];
		int vitriMax = 0;
		int vitriMin = 0;

		// Vòng lặp tính tim Min Max và vị trí của chúng trong mảng

		for (int i = 0; i < n; i++) {

			if (mang[i] > max) {
				max = mang[i];
				vitriMax = i;

			}
			if (mang[i] < min) {
				min = mang[i];
				vitriMin = i;
			}

		}

		System.out.println("******************");
		System.out.println("Mang N có  giá trị lớn nhất là :" + max + " ở vị trí thứ " + vitriMax);
		System.out.println("******************");
		System.out.println("Mảng N có giá trị nhỏ nhất là : " + min + " ở vị trí thứ " + vitriMin);
		System.out.println("******************");
		System.out.println("Nhấn Enter để chọn chức năng khác !!!!");
		nhap.nextLine();
		nhap.nextLine();

	}

	// SẮP XẾP MẢNG THEO THỨ TỰ TĂNG DẦN
	public static void SapXepMangTangDan() {
		// Phần khai báo

		Scanner nhap = new Scanner(System.in);

		// Thân chương trình

		System.out.println("+---------------------------------+");
		System.out.println("|SẮP XẾP MẢNG THEO THỨ TỰ TĂNG DẦN|");
		System.out.println("+---------------------------------+");

		int sapxep;

		for (i = 0; i < n - 1; i++) {
			for (j = n - 1; j >= 1; j--) {

				if (mang[j] < mang[j - 1]) {

					sapxep = (int) mang[j];
					mang[j] = mang[j - 1];
					mang[j - 1] = sapxep;

				}
			}

		}

		System.out.println("Sắp xếp từ bé đến lớn : ");

		for (int i = 0; i < n; i++) {
			System.out.print(mang[i] + "  \n");

		}

		System.out.println("Nhấn Enter để chọn chức năng khác !!!!");
		nhap.nextLine();
		nhap.nextLine();

	}

	// SẮP XẾP MẢNG THEO THỨ TỰ GIẢM DẦN
	public static void SapXepMangGiamDan() {

		Scanner nhap = new Scanner(System.in);

		System.out.println("+---------------------------------+");
		System.out.println("|SẮP XẾP MẢNG THEO THỨ TỰ GIẢM DẦN|");
		System.out.println("+---------------------------------+");

		int sapxep;

		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {

				if (mang[i] < mang[j]) {

					sapxep = (int) mang[j];
					mang[j] = mang[i];
					mang[i] = sapxep;

				}
			}

		}

		System.out.println("Sắp xếp từ giảm dần : ");

		for (int i = 0; i < n; i++) {
			System.out.print(mang[i] + "  \n");

		}

		System.out.println("Nhấn Enter để chọn chức năng khác !!!!");
		nhap.nextLine();
		nhap.nextLine();

	}

}
