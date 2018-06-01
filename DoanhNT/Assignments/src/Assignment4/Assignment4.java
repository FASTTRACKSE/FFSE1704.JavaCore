package Assignment4;

import java.util.Scanner;

	public class Assignment4 {
		static int a, n, q, i, c, d, temp;
		static int array[];

		public static void main(String[] args) {
			while (true) {

				System.out.println(" << MENU >>");
				System.out.println("***----------------------*---------------------------***");
				System.out.println(" 1. giẢi phương trình bậc nhất");
				System.out.println(" 2. giải phương trình bậc hai");
				System.out.println(" 3. nhập mảng ");
				System.out.println(" 4. sắp xêp theo thứ tự tăng dần");
				System.out.println(" 5. kết thúc");
				System.out.println("***----------------------*----------------------------***");

				System.out.print("Mời bạn chọn:");
				
				Scanner nhap = new Scanner(System.in);
				n = nhap.nextInt();
				if (n == 1) {
					PTbacmot1();
					main(args);
				} else if (n == 2) {
					PTbachai();
					main(args);
				} else if (n == 3) {
					Nhapmang();

				} else if (n == 4) {
					Sapxepphantutangdan();
				} else if (n == 5) {
					System.out.println("Đã thoát!");
					System.exit(0);
			
				}
				
			}
		}
		

		public static void PTbacmot1() {
			Scanner nhap = new Scanner(System.in);

			System.out.println("Nhập vào số a");
			a = nhap.nextInt();

			System.out.println("Nhập vào số b");
			int b = nhap.nextInt();

			if (a == 0) {
				if (b == 0) {
					// a=0,b=0;
					System.out.print("Phương trình" + a + "x +" + b + "= 0 có vô số nghiệm");
				} else {
					// a=o,b#0;
					System.out.print("phương trình" + a + "x +" + b + "= 0 vô nghiệm");
				}
			} else {
				// a!=0 phương trình có một nghiệm là x=- b/a
				int nghiemX = -b / a;
				System.out.print("phương trình" + a + "x + " + b + " = 0 có nghiệm x = " + nghiemX);
			}
		}

		public static void PTbachai() {
			Scanner nhap = new Scanner(System.in);
			System.out.print("Nhập số a = ");
			int a = nhap.nextInt();
			System.out.print("nhập số b =");
			int b = nhap.nextInt();
			System.out.print("Nhập số c =");
			int c = nhap.nextInt();

			System.out.print("phương trình bậc hai có dạng :" + a + "x*x " + " + " + b + "x" + " + " + c + " = 0");
			int delta = b * b - 4 * a * c;
			System.out.print("delta = b*b-4*a*c" + " = " + (b * b - 4 * a * c));
			if (delta > 0) {
				System.out.print("phương trình có hai nghiệm phân biệt");
				System.out.print("X1= " + (-b + Math.sqrt(delta)) / (2 * a));
				System.out.print("X2=" + (-b - Math.sqrt(delta)) / (2 * a));
			}
			if (delta == 0) {
				System.out.print("phương trình có nghiệm kép X1 = X2 = " + (-b / (2 * a)));
			}
			if (delta < 0) {
				System.out.print("phương trình vô nghiệm");
			}
		}

		public static void Nhapmang() {

			Scanner nhap = new Scanner(System.in);
			System.out.print("Nhập vào số phần tử mảng :");
			n = nhap.nextInt();
		 array = new int[n];

			for (i = 0; i < n; i++) {

				System.out.print("nhập các phần tử thứ " + i + ":");
				array[i] = nhap.nextInt();
			}
			System.out.print("danh sách các mảng của n là : ");
			for (q = 0; q < n; q++) {

				System.out.print(array[q] + "");
			}
		}

		public static void Sapxepphantutangdan() {

			temp = array[0];
			for ( i = 0; i < array.length-1; i++) {
				for ( d = i + 1; d < array.length; d++) {
					
					if (array[i] < array[d]) {
						temp = array[d];
						array[d] = array[i];
						array[i] = temp;

					}
				}

			}
			System.out.print("Sắp xếp từ nhỏ đến lớn :");
			for (i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}


}
