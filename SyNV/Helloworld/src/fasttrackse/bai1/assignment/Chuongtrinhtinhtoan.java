package fasttrackse.bai1.assignment;

import java.util.Scanner;

public class Chuongtrinhtinhtoan {
	public static Scanner print = new Scanner(System.in);

	public static void main(String[] args) {

		menu();
	}

	public static void menu() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(">> Chương trình tính toán<< ");
			System.out.println("+---------------------------------------+");
			System.out.println("|	1. Giải phương trình bậc 1	|");
			System.out.println("|	2. Giải phương trình bậc 2	|");
			System.out.println("|	3. Sắp xếp mảng			|");
			System.out.println("|	4. Thoát chương trình		|");
			System.out.println("+---------------------------------------+");
			System.out.println("Chọn chức năng: ");
			int answer = sc.nextInt();
			if (answer == 1) {
				phuongtrinhbac1();
			} else if (answer == 2) {
				phuongtrinhbac2();
			} else if (answer == 3) {
				sapxepmang();
			} else if (answer == 4) {
				ketthuc();
			} 
		}

	}
	public static void phuongtrinhbac1() {
		int soA, soB;
		 
		 Scanner sc = new Scanner(System.in);
		 
		 	System.out.println("----------------------------");
		 	System.out.println("|Giải phương trình bậc nhất|");
		 	System.out.println("----------------------------");
			System.out.println("Nhập số a: ");
			soA= sc.nextInt();
			System.out.println("Nhập số b: ");
			soB= sc.nextInt();
		if(soA == 0) {
			if(soB ==0) {
				System.out.println("Phương trình vô số nghiệm");
			}else {
				System.out.println("Phương trình vô nghiệm!");
			}
		}else {
			System.out.println("Phương trình có nghiệm X = " + (-soB/soA));
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
	
	public static void sapxepmang() {
		
		int n;
		do {
		System.out.print("Nhập số phần tử của mảng: ");
		 n = print.nextInt();
		}while(n<=0);
		int bubbleSort;
		
		int[] array = new int[n];// khai báo mảng
		System.out.println("Nhập phần tử của mảng: \n");// dùng \n để con trỏ xuống dòng tiếp theo
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);// %d: số thập phân, số nguyên
			array[i] = print.nextInt();
		}
		System.out.println("Các phần từ của mảng ban đầu: ");
		show(array);
		int max = array[0];// khởi tạo biến max và min tại vị trí phần tử đầu tiên của mảng
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
		System.out.println("Phần tử nhỏ nhất của mảng là " + min + " và nằm ở vị trí thứ " + pmin);
		for(int i=0; i< n -1; i++) {
			for(int j =n-1; j>=1;j--) {
				if(array[j] < array[j - 1]) {
					bubbleSort = array[j];
	                array[j] = array[j-1];
	                array[j-1] = bubbleSort;
				}
			}
		}
		System.out.print("Mảng sau khi sắp sếp: ");
		for(int t=0;t<n;t++) {
			System.out.print(array[t]+" ");
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
