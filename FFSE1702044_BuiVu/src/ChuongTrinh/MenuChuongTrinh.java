package ChuongTrinh;

import java.util.Scanner;

public class MenuChuongTrinh {
	//Khai Báo
		static int N,i,j;
		static int[] myArray;
		static Scanner myInput=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		System.out.println(">> Menu Chương Trình <<");
		System.out.println("+-------------------------+");
		System.out.println("|1.Giải Phương Trình Bậc 1|");
		System.out.println("|2.Giải Phương Trình Bậc 2|");
		System.out.println("|3.Nhập Mảng              |");
		System.out.println("|4.Sắp Xếp Mảng Tăng Dần  |");
		System.out.println("|5.Kết Thúc               |");
		System.out.println("+-------------------------+");
		System.out.println("Mời Bạn Chọn Chức Năng");
		
		int answer = myInput.nextInt();
		if(answer==1) {
			GiaiPTB1();
			
		}
		else if(answer==2) {
			GiaiPTB2();
			
		}
		else if(answer==3) {
			NhapMang();
			
		}
		else if(answer==4) {
			SapXepMangTangDan();
			
		}
		else if(answer==5) {
			System.exit(0);
		}
		}
	}
	public static void GiaiPTB1() {
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
			x = -b / a;
			System.out.println("Phương trình có nghiệm: " + x);
		}
	}
	public static void GiaiPTB2() {
		System.out.println("Giải Phương Trình Bậc 2 ");
		Scanner GiaiPtBac2 = new Scanner(System.in);
		int a,b,c;
		double x1,x2;
		// Nhập a , b, c
		System.out.print("Nhập Số a : ");
		a = GiaiPtBac2.nextInt();
		System.out.print("Nhập Số b : ");
		b= GiaiPtBac2.nextInt();
		System.out.print("Nhập Số c : ");
		c= GiaiPtBac2.nextInt();
		// Kiểm Tra các số đã nhập
		if(a==0) {
			if(b==0) {
				System.out.println("PT vô nghiệm");
			}else {
				System.out.println("PT có 1 nghiệm x= "+ (-b/2*a));
			}
			return;
		}
		float detal = (b*b)-(4*a*c);
		
		//Kiểm tra delta
		if(detal < 0) {
			System.out.println("PT vô Nghiệm");
			
		}else if(detal == 0) {
			x1=(-b/2*a);
			System.out.println("PT có nghiệm kép x1=x2= " + x1);
		}else {
			x1= (-b + Math.sqrt(detal)/(2*a));
			x2= (-b - Math.sqrt(detal)/(2*a));
			System.out.println("PT có Nghiệm x1= "+ x1 +"  PT có Nghiệm x2= "+ x2);
		}
	}
	public static void NhapMang() {
		System.out.print("Nhập Số lượng mảng : ");
		N = myInput.nextInt();
		myArray = new int[N];
		
		//Kiểm tra Số lượng muốn tạo, và cho phép người dùng nhập giá trị trong mảng.
		for(int i=0;i<N;i++) {
			System.out.print("Nhập Phần tử thứ "+ (i+1)+ " của mảng: ");
			myArray[i]= myInput.nextInt();
		}
		//
		System.out.println("Giá Trị Của Mảng :");
		for(int i=0;i<N;i++) {
			System.out.print( myArray[i]+"\t");
		}
		System.out.println("\n");
		
		
	}
	public static void SapXepMangTangDan() {
		for(i=0; i< N-1;i++) {
        	for(j=i+1;j<=N-1;j++) {
        		if(myArray[j] < myArray[i]) {
        			int temp = myArray[i];
        			myArray[i]=myArray[j];
        			myArray[j]=temp;
        		}
        	}
        }
        System.out.println("Mảng sau khi sắp xếp nhỏ đến lớn là");
        for(int i=0;i<N;i++) {
        	System.out.print( myArray[i] +"\t" );
        }
    	System.out.print("\n");
	}
	
}
