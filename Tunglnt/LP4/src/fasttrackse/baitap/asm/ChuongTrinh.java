/*****************************
 * Prog: Chương Trình Java
 * @author LÊ NGUYỄN THANH TÙNG
 * Date: 30-05-2018
 *****************************/

package fasttrackse.baitap.asm;

import java.util.Scanner;

public class ChuongTrinh {
	
	//khai báo
		static int n, i, j, app;
		static int myArray[] = new int[n];
		
	public static void main(String[] args) {
		
		System.out.println(">>           MENU           <<");
		System.out.println("+----------------------------+");
		System.out.println("| 1. Giải PT Bậc Nhất 1 Ẩn   |");
		System.out.println("| 2. Giải PT Bậc Hai 1 Ẩn    |");
		System.out.println("| 3. Nhập Mảng               |");
		System.out.println("| 4. Sắp Xếp Mảng Tăng Dần   |");
		System.out.println("| 5. Kết Thúc Chương Trình   |");
		System.out.println("|----------------------------|");
		
		while (true) {
			System.out.print("\n Nhập chương trình tính toán bạn cần: ");
			Scanner nhap = new Scanner(System.in);
			int app = nhap.nextInt();
			switch (app) {
			case 1:
				PhuongTrinhBac1();
				break;
			case 2:
				PhuongTrinhBac2();
				break;
			case 3:
				Mang();
				break;
			case 4:
				SapXepTangDan();
				break;
			case 5:
				KetThuc();
				break;
				
			}
		}
		
	}
	
	public static void PhuongTrinhBac1(){
		Scanner myInput = new Scanner(System.in);

		System.out.println("+----------------------------+");
		System.out.println("| Giải phương trình bậc nhất |");
		System.out.println("+----------------------------+");
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
			};

		} else {
			X = B * 1.0 / A;
			System.out.println("Phương trình " + A + "X" + "+" + B + "=0 " + "có nghiệm X bằng " + X);
		}
	}
	public static void PhuongTrinhBac2(){
		Scanner myInput = new Scanner(System.in);

		System.out.println("+----------------------------+");
		System.out.println("| Giải phương trình bậc hai  |");
		System.out.println("+----------------------------+");

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
				};
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
	}
	public static void Mang(){
		Scanner myInput = new Scanner(System.in);
		
		//Phan mem
		
		//1 nhap mang
		System.out.print("Mời bạn nhập số phần tử mảng N = ");
		n = myInput.nextInt();
		
		// khoi tao mang N
		myArray = new int[n];
		
		//vong lap nhap phan tu myarray
		for (int i=0;i<n;i++) {
			System.out.print("Mời bạn nhập phần tử" + (i+1) +":");
			myArray[i]= myInput.nextInt();
		};
		
		//in mang
		System.out.print("danh sach phan tu mang");
		for (int i=0;i<n;i++) {
			System.out.print(" " + myArray[i]);
			
		};
	}
	public static void SapXepTangDan(){
		int bien = 0;
	    for(int i=0;i<n-1;i++)
	        for(int j=i+1;j<n;j++){
	        if(myArray[i]>myArray[j]) {
	        	bien= myArray[i];
	        	myArray[i]=myArray[j];
	        	myArray[j]=bien;
	            }
	    }
	    System.out.print("\n mang tang dan");
		for (int i=0;i<n;i++) {
			System.out.print(" " + myArray[i]);
			
		};
		
	}
	public static void KetThuc(){
		System.exit(0);
	}
	
	
	
}