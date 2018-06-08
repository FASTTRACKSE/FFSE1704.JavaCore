/**
 * 	@author: Phan Phạm Quang Dai
 */
package fasttrackse.bai1.assignment;

import java.util.Scanner;
/**
 * Dựa trên slide 29 của Unit 2, các em thiết kế 1 chương trình gồm nhiều chức năng, thực hiện chức năng qua menu lựa chọn:
 * Giải Phương trình bậc nhất 1 ẩn
 * Giải Phương trình bậc hai 1 ẩn
 * Nhập mảng
 * Sắp xếp mảng và in kết quả
 * Kết thúc chương trình
 *
 */
public class Assignment3 {

	/**
	 * @param args
	 */
	static int n, i, j, Tang, Giam, app;
	static int array[] = new int[n];
	public static void main(String[] args) {
		// Khai báo
		System.out.println("*************************************");
		System.out.println("|      CHƯƠNG TRÌNH TÍNH TOÁN       |");
		System.out.println("|                                   |");
		System.out.println("| 1. GIẢI PHƯƠNG TRÌNH BẬC NHẤT 1 ẨN|");
		System.out.println("| 2. GIẢI PHƯƠNG TRÌNH BẬC HAI 1 ẨN |");
		System.out.println("| 3. NHẬP MẢNG                      |");
		System.out.println("| 4. SẮP XẾP MẢNG VÀ IN KẾT QUẢ     |");
		System.out.println("| 5. KẾT THÚC CHƯƠNG TRÌNH          |");
		System.out.println("|                                   |");
		System.out.println("*************************************");
		
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
		}

	}
	
	// giải phương trình bậc 1
	public static void GPTB1() {
		int a, b;
		double x;
		@SuppressWarnings("resource")
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhập tham số a: ");
		a = myInput.nextInt();
		
		System.out.print("Nhập tham số b: ");
		b = myInput.nextInt();
		
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình vô số nghiệm");
			} else {
				System.out.println("Phương trình vô nghiệm");
			}
		} else {
			x = -b * 1.0 / a;
			System.out.println("Phương trình có nghiệm: " + x);
		}
	}
	
	// giải phương trình bậc 2
	public static void GPTB2() {
		// Khai báo tham số a, b, c và biến x, x1, x2
		int a, b, c;
		double x, x1, x2;
		
		@SuppressWarnings("resource")
		// Khai báo biến Scanner nhập dữ liệu từ bàn phím
		Scanner myInput = new Scanner(System.in);
		
		// Nhập giá trị tham số a, b, c từ bàn phím
		System.out.print("Nhập tham số a: ");
		a = myInput.nextInt();
		
		System.out.print("Nhập tham số b: ");
		b = myInput.nextInt();
		
		System.out.print("Nhập tham số c: ");
		c = myInput.nextInt();

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					// a = 0 & b = 0 & c = 0: Phương trình vô số nghiệm
					System.out.println("Phương trình vô số nghiệm");
				} else {
					// a = 0 & b = 0 & c != 0: Phương trình vô nghiệm
					System.out.println("Phương trình vô nghiệm");
				}
			} else {
				// a = 0 & b != 0: Phương trình có nghiệm x = -c / b
				x = -c *1.0/ b;
				System.out.print("Phương trình có nghiệm: x = ");
				System.out.printf("%.3f %n", x);
			}
		} else {
			// a != 0
			double delta = b * b - 4 * a * c;
			if (delta < 0) {
				// Phương trình vô nghiệm
				System.out.println("Phương trình vô nghiệm");
			} else {
				if (delta == 0) {
					// Phương trình có nghiệm kép x1 = x2 = -b/2a
					x = - b / 2 * a;
					System.out.print("Phương trình có nghiệm kép: x1 = x2 = ");
					System.out.printf("%.3f %n", x);
				} else {
					// Phương trình có 2 nghiệm x = (-b +/- căn delta)/2a
					x1 =(-b + Math.sqrt(delta)) / (2*a);
					x2 =(-b - Math.sqrt(delta)) / (2*a);
					System.out.println("Phương trình có 2 nghiệm là");
					System.out.print("x1 = ");
					System.out.printf("%.3f %n", x1);
					System.out.print("x2 = ");
					System.out.printf("%.3f %n", x2);
				}
			}
		}
	}
	
	// nhập mảng
	public static void mang() {
		int size; //Kích thước mảng nhập từ bàn phím
		Scanner myInput = new Scanner(System.in);
		System.out.print("hảy nhập số phần tử của mảng: ");
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
				vitrimax=j+1;
			}
			if (min >= array[j]) {
				min = array[j];
				vitrimin=j+1;
			}
		}
		System.out.println("Giá trị lớn nhất của mảng là: " + max + ", vị trí thứ " + vitrimax + " trong mảng");
		System.out.println("Giá trị nhỏ nhất của mảng là: " + min + ", vị trí thứ " + vitrimin + " trong mảng");
	}
	
	// sắp xếp theo thứ tự tăng dần
	public static void mangtang() {
		
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n - 1; j++) {
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
	
	// kết thúc chương trình
	public static void ketthuc() {
		System.exit(0);

	}

}
