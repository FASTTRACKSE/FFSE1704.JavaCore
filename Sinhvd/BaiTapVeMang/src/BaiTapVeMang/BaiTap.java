package BaiTapVeMang;

import java.util.Scanner;
public class BaiTap {

	public static void main(String[] args) {
		
		System.out.println("//*****   Menu        ******//");
		System.out.println("1.**|| phuong trinh bac nhất ||**");
        System.out.println("2.**|| phuong trinh bac hai  ||**");
        System.out.println("3.**|| kiểu mãng    ||**"            );
        System.out.println("4.**|| sắp xếp mãng ||**");  
        System.out.println("5.**|| kết thúc     ||**");  

		System.out.println("//************************//");

        
        
        Scanner nhhapdicha = new Scanner(System.in);  
          int sinh=nhhapdicha.nextInt();
         if (sinh==1);{
        	 giaiptbacnhat();
         }if(sinh==2) {
        	 giaiptbac2();
         }if(sinh==3) {
        	 kieumang();
         }if(sinh==4) {
        	sinh();
         }if(sinh==5) {
        	 ketthuc();
         }
         }

	public static void giaiptbacnhat() {
		int thamSoA, thamSoB;
		double nghiemX;
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhập tham số a =");
		thamSoA = myInput.nextInt();

		System.out.println("nhập tham số b =");
		thamSoB = myInput.nextInt();

		if (thamSoA == 0) {
			if (thamSoB == 0) {
				System.out.println("phương trình" + thamSoA + "x +" + thamSoB + "=0 có 2 nghiệm");
			} else {
				System.out.println("phương trình" + thamSoA + "x +" + thamSoB + " vô nghiệm");

			}
		} else {
			nghiemX = -thamSoB * 1.0 / thamSoA;
			System.out.println("phương trình"  + thamSoA + "x + " + thamSoB + "  là " + nghiemX);

		}

	}
	public static void BaiTap() {
		
	}

	public static void giaiptbac2() {
Scanner myInput = new Scanner(System.in);
		
		System.out.println("*************************");
		System.out.println("| văn đức sinh|");
		System.out.println("*************************");
		
 		
		System.out.print("Nhập tham số a = ");
		int A = myInput.nextInt();

		System.out.print("Nhập tham số b = ");
		int B = myInput.nextInt();
		
		System.out.print("Nhập tham số c = ");
		int C = myInput.nextInt();
		
		
		 if(A==0) {
			 if(B==0) {
				 if(C==0) {
					 System.out.println("Phương trình "+ A + "X^2" + "+"+B+"X"+ "+"+C +"=0"+" vô số nghiệm"); 
				 }else {
					 System.out.println("Phương trình "+ A + "X^2" + "+"+B+"X"+ "+"+C +"=0"+" vô  nghiệm");
				 }; 
			 }else {
				double X =-C *1.0/ B;
				 System.out.println("Phương trình "+ A + "X^2" + "+"+B +"X"+C+"=0 "+" có nghiệm X bằng "+X);
			 }; 
		 }else{
			 int delta= (B*B)-(4*A*C);
			 if(delta==0) {
				double X = -B/2*A;
				 System.out.println("Phương trình "+ A + "X^2" + "+"+B +"X"+C+"=0 "+" có nghiệm kép X bằng "+X);
			 }else {
				 if(delta>0){
					 double X1 =(-B + Math.sqrt( delta))*1.0/2*A;
					 double X2 =(-B - Math.sqrt( delta))*1.0/2*A;
					 System.out.println("Phương trình "+ A + "X^2" + "+"+B +"X"+C+"=0 "+" có nghiệm  X1 bằng  "+X1+"  và X2 bằng "+X2);
				 }else {
					 System.out.println("Phương trình"+ A + "X^2" + "+"+B+"X"+ "+"+C +"=0"+" vô  nghiệm");
				 }
			 }
		 };

	
		
		
	}
	public static void kieumang() {
		//Khai báo
				int n;
				Scanner N = new Scanner(System.in);
				System.out.println("Nhập vào số phần tử của mảng: ");
				n = N.nextInt();
				//-- khởi tạo và cấp phát bộ nhớ cho mảng
				int array[] = new int[n];
				
				//phần thân trang code
				System.out.println("Nhập các phần tử cho mảng: ");
				for (int i = 0; i < n; i++) {
					int j = i + 1;
					System.out.print("Nhập phần tử thứ " + j + ": ");
					array[i] = N.nextInt();
				}

				//-- Hiển thị mảng vừa nhập
				System.out.println("Mảng đã nhập: ");
				for (int i = 0; i < n; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println(" ");
				// --Tìm min max và vị trí
				int max = array[0];
				int min = array[0];
				int a = 0;
				int b = 0;	
				for (int i = 0; i < n; i++) {
					if (max < array[i]) {
						max = array[i];
						a = i;
					}
					if (min > array[i]) {
						min = array[i];
						b = i;
					}
				}
				System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + a);
				System.out.println("");
				System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + b);
	}
	public static void sinh() {
		//Khai báo
				int n;
				Scanner N = new Scanner(System.in);
				System.out.println("Nhập vào số phần tử của mảng: ");
				n = N.nextInt();
				//-- khởi tạo và cấp phát bộ nhớ cho mảng
				int array[] = new int[n];
				
				//phần thân trang code
				System.out.println("Nhập các phần tử cho mảng: ");
				for (int i = 0; i < n; i++) {
					int j = i + 1;
					System.out.print("Nhập phần tử thứ " + j + ": ");
					array[i] = N.nextInt();
				}

				//-- Hiển thị mảng vừa nhập
				System.out.println("Mảng đã nhập: ");
				for (int i = 0; i < n; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println(" ");
				// --Tìm min max và vị trí
				int max = array[0];
				int min = array[0];
				int a = 0;
				int b = 0;	
				for (int i = 0; i < n; i++) {
					if (max < array[i]) {
						max = array[i];
						a = i;
					}
					if (min > array[i]) {
						min = array[i];
						b = i;
					}
				}
				System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + a);
				System.out.println("");
				System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + b);
	}

	public static void ketthuc() {
		
	}



}

