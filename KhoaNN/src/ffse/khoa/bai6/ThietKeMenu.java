package ffse.khoa.bai6;

import java.util.Scanner;

public class ThietKeMenu {
	 static int n, j, i;
	 static Scanner sc = new Scanner(System.in);
	
	
	 static int mang[] ;
	 int max = mang[0];
	 int min = mang[0];
	 int vitriMax = 0;
	 int vitriMin = 0;
	
	public static void main(String[] args) {
				// TODO Auto-generated method stub
		while(true){
		System.out.println(">> Menu Chương Trình <<");
		System.out.println("+-----------------------------+");
		System.out.println("| 1 : Giải Phương Trình Bậc 1 |");
		System.out.println("| 2 : Giải Phương Trình Bậc 2 |");
		System.out.println("| 3 : Nhập Mảng               |");
		System.out.println("| 4 : Sắp Xếp Mảng Tăng Dần   |");
		System.out.println("| 5 : Kết Thúc                |");
		System.out.println("+-----------------------------+");
		System.out.print(" >> Mời Bạn Chọn : << ");
		
		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();
		if(answer == 1 ) {
			GPTBac1();
		}else if (answer == 2) {
			GPTBac2();
		}else if (answer == 3) {
			NhapMang();
		}else if (answer == 4) {
			Sapsepmang();
		}else if (answer == 5) {
			System.exit(0);
		}
		}
	}
	public static void GPTBac1() {
		int a , b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban hay nhap a : ");
        a = sc.nextInt();
        System.out.println("Ban hay nhap b : ");
        b = sc.nextInt();
        if ( a == 0){
            if ( b == 0) {
                System.out.println("Phuong trinh vo so nghiem");             
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
    } else {
            float x = (float) - b/a;
            System.out.println("Phuong trinh co nghiem duy nhat : "+ x);
        }
    
}
	
	public static void GPTBac2() {
		int a , b , c , a1 , a2 , delta;
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Ban Hay Nhap a : ");
		a = Scanner.nextInt();
		System.out.println("Ban Hay Nhap b : ");
		b = Scanner.nextInt();
		System.out.println("Ban Hay Nhap c : ");
		c = Scanner.nextInt();
		if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô nghiệm!");
            } else {
                System.out.println("Phương trình có một nghiệm: " + "x = " + (-c / b));
            }
            return;
        }
		delta = (int) (Math.pow(b, 2) - 4 * a * c);
		if (delta < 0){
			System.out.println("Phương trình vô nghiệm!");
        	
        } else if (delta == 0) {
        	a1 = a2 = -b/ (2*a);
        } else {
        	a1 = (int) ((-b + Math.sqrt(delta)) / (2 * a));
            a2 = (int) ((-b - Math.sqrt(delta)) / (2 * a));
            System.out.println("Phương trình có 2 nghiệm x1 = " + a1 + " và x2 = " + a2);
        }
	}
	
	public static void NhapMang() {
		
		System.out.print("Xin Nhập Số Lượng Phần Tử Của Mảng : ");
		n = sc.nextInt();
		 mang = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập Phần Tử" + " " + i + " " + "Của Mảng : ");
			mang[i] = sc.nextInt();
		}
		int max = mang[0];
		int min = mang[0];
		int vitriMax = 0;
		int vitriMin = 0;
		// Vòng Lặp tính min max
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
		
		System.out.print("2/");
		System.out.println(" Mảng N có  giá trị lớn nhất là :" + max);		
		System.out.println("   Mảng N có giá trị nhỏ nhất là : " + min);
		
		System.out.print("3/");
		System.out.println(" Phần tử " + max + " ở vị trí thứ " + vitriMax);		
		System.out.println("   Phần tử " + min + " ở vị trí thứ " + vitriMin);

	}
	
	public static void Sapsepmang() {
		
		for (int i=0; i < n-1; i++) {
			for (int j = i + 1; j >= 1; j-- ) {
				if (mang[j] < mang[j - 1]) {
					int temp = mang[j];
					mang[j] = mang[j - 1];
					mang[j - 1] = temp;
				}
			}
		}
		System.out.println("\nMảng sau khi sắp xếp từ nhỏ đến lớn : ");
	    for (int i = 0; i < n; i++) {
	        System.out.print(mang[i] + "\t");
	    }
	}
	

	

}
