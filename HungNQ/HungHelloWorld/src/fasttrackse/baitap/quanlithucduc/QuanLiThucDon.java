/**
 * 
 */
package fasttrackse.baitap.quanlithucduc;

import java.util.Scanner;

/**
 * @author Admin
 *
 */
public class QuanLiThucDon {
	public static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int answer;

		while (true) {
			System.out.println(">>     MÁY TÍNH CÁ NHÂN     <<");
			System.out.println("+----------------------------+");
			System.out.println("| 1. Phương trình bậc nhất   |");
			System.out.println("| 2. Phương trình bậc hai    |");
			System.out.println("| 3. Nhập mảng               |");
			System.out.println("| 4. Sắp xếp mảng tăng dần   |");
			System.out.println("| 5. Kết thúc                |");
			System.out.println("+----------------------------+");
			System.out.println(">>     Chọn chức năng?      <<");

			 answer = myInput.nextInt();
			if (answer == 1) {
				GiaiPhuongTrinhBacNhat();
			} else if (answer == 2) {
				GiaiPhuongTrinhBacHai();
			} else if (answer == 3) {
				NhapMang();
			} else if (answer == 4) {
				SapXepMangTangDan();
			} else if (answer == 5) {
				KetThuc();
			}
		}
	}

	public static void GiaiPhuongTrinhBacNhat() {
		int thamSoA, thamSoB;
		double nghiemX;
		
		System.out.print("Nhập tham số a = ");
		thamSoA = myInput.nextInt();

		System.out.print("Nhập tham số b =");
		thamSoB = myInput.nextInt();

		if (thamSoA == 0) {
			if (thamSoB == 0) {
				System.out.print("Phương trình " + thamSoA + "x + " + thamSoB + " = 0" + "có nghiệm");
			} else {
				System.out.print("Phương trình " + thamSoA + "x + " + thamSoB + " = 0" + "vô nghiệm");
			}
		} else {
			nghiemX = -thamSoB * 1.0 / thamSoA;
			System.out.print("Phương trình " + thamSoA + "x + " + thamSoB + "= 0 có nghiệm x = " + nghiemX);
		}
	}

	public static void GiaiPhuongTrinhBacHai() {
		int thamSoA, thamSoB, thamSoC;
		double nghiemX;
		double nghiemX1;
		double nghiemX2;

		System.out.print("Nhập tham số a = ");
		thamSoA = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		thamSoB = myInput.nextInt();

		System.out.print("Nhập tham số c = ");
		thamSoC = myInput.nextInt();

		if (thamSoA == 0) {
			nghiemX = -thamSoC * 1.0 / thamSoB;
			System.out.print("Phương trình có một nghiệm duy nhất x = " + nghiemX);
		} else {
			nghiemX1 = -thamSoB * 1.0 / thamSoA;
			nghiemX2 = thamSoC * 1.0 / 2 * thamSoA;
			System.out.print("Phương trình có hai nghiệm phân biệt x1 = " + nghiemX1 + " và x2 = " + nghiemX2);
		}
	}

	public static void NhapMang() {
		// Khai báo
		int X;
		int[] myArray;
		int gtMin, gtMax, vtMin, vtMax;


		// Phần Thân
		System.out.print("Mời bạn nhập tổng số X = ");
		X = myInput.nextInt();

		myArray = new int[X];

		for (int i = 0; i < X; i++) {
			System.out.print("Mời bạn nhập giá trị X = " + (i + 1) + " : ");
			myArray[i] = myInput.nextInt();
		}

		// In mảng
		System.out.print("Danh sách phần tử mảng: ");
		for (int i = 0; i < X; i++) {
			System.out.print(myArray[i] + " ");
		}

		gtMin = myArray[0];
		vtMin = 0;
		gtMax = myArray[0];
		vtMax = 0;
		for (int i = 0; i < X; i++) {
			if (gtMax < myArray[i]) {
				gtMax = myArray[i];
				vtMax = i + 1;
			}
			if (gtMin > myArray[i]) {
				gtMin = myArray[i];
				vtMin = i + 1;
			}
		}
		System.out.println("Phần tử lớn nhất của mảng là " + gtMax + " và ở vị trí " + vtMax);
		System.out.println("Phần tử nhỏ nhất của mảng là " + gtMin + " và ở vị trí " + vtMin);

		// Kết thúc
	}

	public static void SapXepMangTangDan() {
		int n, temp, max = 100;
		Scanner scanner = new Scanner(System.in);

		// khai báo và cấp phát bộ nhớ cho mảng A
		int A[] = new int[max];

		// nhập số phần tử của mảng
		// kiểm tra nếu n <= 2 hoặc n > max - 1
		// thì phải nhập lại
		do {
			System.out.println("Nhập số phần tử của mảng: ");
			n = scanner.nextInt();
		} while (n <= 2 || n > max - 1);

		System.out.println("Nhập giá trị cho các phần tử của mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("A[" + i + "] = ");
			A[i] = scanner.nextInt();
		}

		// in ra màn hình mảng số ban đầu
		System.out.println("Mảng ban đầu: ");
		for (int i = 0; i < n; i++) {
			// in các phần tử trên cùng 1 dòng
			System.out.print(A[i] + "\t");
		}

		// sắp xếp các phần tử trong mảng
		// vòng lặp for sẽ duyệt i và j
		// i chạy từ 0 đến n - 2, j chay từ i + 1 đến n - 1
		// nếu phần tử tại chỉ số j nhỏ hơn phần tử tại i
		// thì sẽ hoán đổi vị trí 2 phần tử này cho nhau
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				if (A[j] < A[i]) {
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}

		// in ra màn hình mảng số sau khi sắp xếp
		System.out.println("\nMảng sau khi sắp xếp tăng dần: ");
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + "\t");
		}
	}

	public static void KetThuc() {
		myInput.close();
		System.out.println("Cảm ơn bạn đã sử dụng chương trình");
		System.exit(0);
	}
}
