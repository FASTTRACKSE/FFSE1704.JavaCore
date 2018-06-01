
/*****************************
 * Prog: ỨNG DỤNG TÍNH TOÁN
 * @author LÊ KHẢ HỒNG NHẬT
 * Date: 30-05-2018
 *****************************/
import java.util.Scanner;

public class BaiTapChuongTrinhTinhToan {
	// khai báo
	static int n, i, j, Tang, Giam, app;
	static int array[] = new int[n];

	public static void main(String[] args) {
		System.out.println("*************************************");
		System.out.println("|      CHƯƠNG TRÌNH TÍNH TOÁN       |");
		System.out.println("|                                   |");
		System.out.println("| 1. GIẢI PHƯƠNG TRÌNH BẬC NHẤT 1 ẨN|");
		System.out.println("| 2. GIẢI PHƯƠNG TRÌNH BẬC HAI 1 ẨN |");
		System.out.println("| 3. NHẬP MẢNG                      |");
		System.out.println("| 4. SẮP XẾP MẢNG TĂNG DẦN          |");
		System.out.println("| 5. KẾT THÚC CHƯƠNG TRÌNH          |");
		System.out.println("|                                   |");
		System.out.println("*************************************");

		// menu chương trình
		while (true) {
			System.out.print("Nhập chương trình tính toán bạn cần: ");
			Scanner nhap = new Scanner(System.in);
			int app = nhap.nextInt();
			if (app == 1 || app == 2 || app == 3 || app == 4 || app == 5) {
				switch (app) {
				case 1:
					GPTB1();
					break;
				case 2:
					GPTB2();
					break;
				case 3:
					mang();
					break;
				case 4:
					mangtang();
					break;
				case 5:
					return;
				}
			} else {
				System.out.println("Bạn phải nhập một trong các số từ 1 đến 5. Hãy nhập lại!!!");
				nhap.nextInt();
			}
			;
		}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	// giải phương trình bậc 1
	public static void GPTB1() {
		Scanner myInput = new Scanner(System.in);

		System.out.println("*************************");
		System.out.println("| Giải phương trình bậc nhất |");
		System.out.println("*************************");
		double X;
		System.out.print("Nhập tham số a = ");
		int A = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		int B = myInput.nextInt();

		if (A == 0) {
			if (B == 10) {
				System.out.println("Phương trình" + A + "X" + "+" + B + "=0" + "vô số nghiệm");
			} else {
				System.out.println("Phương trình" + A + "X" + "+" + B + "=0" + "vô nghiệm");
			}
			;

		} else {
			X = B * 1.0 / A;
			System.out.println("Phương trình " + A + "X" + "+" + B + "=0 " + "có nghiệm X bằng " + X);
		}
		;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	// giải phương trình bậc 2
	public static void GPTB2() {
		Scanner myInput = new Scanner(System.in);

		System.out.println("*************************");
		System.out.println("| Giải phương trình bậc hai  |");
		System.out.println("*************************");

		System.out.print("Nhập tham số a = ");
		int A = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		int B = myInput.nextInt();

		System.out.print("Nhập tham số c = ");
		int C = myInput.nextInt();

		if (A == 0) {
			if (B == 0) {
				if (C == 0) {
					System.out.println("Phương trình " + A + "X^2" + "+" + B + "X" + "+" + C + "=0" + " vô số nghiệm");
				} else {
					System.out.println("Phương trình " + A + "X^2" + "+" + B + "X" + "+" + C + "=0" + " vô  nghiệm");
				}
				;
			} else {
				double X = -C * 1.0 / B;
				System.out.println("Phương trình " + A + "X^2" + "+" + B + "X" + C + "=0 " + " có nghiệm X bằng " + X);
			}
			;
		} else {
			int delta = (B * B) - (4 * A * C);
			if (delta == 0) {
				double X = -B / 2 * A;
				System.out.println(
						"Phương trình " + A + "X^2" + "+" + B + "X" + C + "=0 " + " có nghiệm kép X bằng " + X);
			} else {
				if (delta > 0) {
					double X1 = (-B + Math.sqrt(delta)) * 1.0 / 2 * A;
					double X2 = (-B - Math.sqrt(delta)) * 1.0 / 2 * A;
					System.out.println("Phương trình " + A + "X^2" + "+" + B + "X" + C + "=0 " + " có nghiệm  X1 bằng  "
							+ X1 + "  và X2 bằng " + X2);
				} else {
					System.out.println("Phương trình " + A + "X^2" + "+" + B + "X" + "+" + C + "=0" + " vô  nghiệm");
				}
			}
		}
		;

		{

		}
		;

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	// nhập mảng
	public static void mang() {
		// Khai báo

		Scanner N = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		n = N.nextInt();
		// -- khởi tạo và cấp phát bộ nhớ cho mảng
		array = new int[n];

		// phần thân trang code
		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			System.out.print("Nhập phần tử thứ " + j + ": ");
			array[i] = N.nextInt();
		}

		// -- Hiển thị mảng vừa nhập
		System.out.println("Mảng đã nhập: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	// sắp xếp theo thứ tự tăng dần
	public static void mangtang() {

		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n - 1; j++) {
				if (array[i] > array[j]) {
					Tang = array[i];
					array[i] = array[j];
					array[j] = Tang;
				}
			}
		}

		System.out.println(" ");
		System.out.println("Mảng sau khi sắp xếp tăng là: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	// kết thúc chương trình
	public static void ketthuc() {
		System.exit(0);

	}

}
