package Menu;

import java.util.Scanner;

public class Tao {
	static int i,j,n,max,min;
	static int mang[];
	public static void main(String[] args) {
		thucdon();
	}
		// TODO Auto-generated method stub
		public static void thucdon() {
			while(true) {

		System.out.println("Hello members: ");
		System.out.println("+--------------------------+");
		System.out.println("| 1.Giải Pt bậc 1          |");
		System.out.println("| 2.Giải Pt bậc 2          |");
		System.out.println("| 3.nhập mảng              |");
		System.out.println("| 4.Sắp xếp mảng tăng dần  |");
		System.out.println("| 5.kêt thúc               |");
		System.out.println("+--------------------------+");
		Scanner nhap = new Scanner(System.in);
		int press=nhap.nextInt();
		if(press==1) {
			giaitbac1();
		}
		if(press==2) {
			giaitbac2();
		}
		if(press==3) {
			mangso();
		}
		if(press==4) {
			sapxepmang();
		}
		if(press==5) {
			ketthuc();
		}
	}
		}
		public static void giaitbac1() {
			int soa, sob, x;
			double nghiemX;
			Scanner myInput = new Scanner(System.in);
		
			System.out.println("nhập vào số a:");
			soa= myInput.nextInt();
			System.out.println("nhập vào số b:");
			sob= myInput.nextInt();
			if(soa==0) {
			if(sob==0) {
				System.out.println("Phương trình" + soa+"x+"+sob+"=0 vô số nghiệm");
			}
			else
			{
				System.out.println("Phương trình" + soa+"x+"+sob+"=0 vô nghiệm");

		}
			}
			else {
				x = -sob/soa;
				System.out.println("Phương trình có nghiệm" + "x="+ x );
			}
			System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
			myInput.nextLine();
			myInput.nextLine();
		}
		public static void giaitbac2() {
			int a,b,c;
			System.out.println("Giải phương trình bậc hai một ẩn");
			Scanner myInput = new Scanner(System.in);
			System.out.println("nhập số a:");
			a = myInput.nextInt();
			System.out.println("nhập số b:");
			b = myInput.nextInt();
			System.out.println("nhập số c:");
			c = myInput.nextInt();
			System.out.println("phương trình có dạng" +a+"x*x+"+b+"x+"+c+"=0");
			int delta=b*b-4*a*c;
			System.out.println("delta = b*b-4*a*c"+ " = " +(b*b-4*a*c));
			if(delta>0) {
				System.out.println("phương trình có 2 nghiệm phân biệt");
				System.out.println("x1="+(-b+Math.sqrt(delta))/(2*a));
				System.out.println("x2="+(-b-Math.sqrt(delta))/(2*a));
			}
			if(delta==0) {
				System.out.println("phương trình nghiệm kép x1=x2="+(-b/(2*a)));
			}
			if(delta<0) {
				System.out.println("phương trình vô nghiệm ");
			}
			System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
			myInput.nextLine();
			myInput.nextLine();
		}	

		public static void mangso() {
			
			Scanner N = new Scanner(System.in);
			System.out.println("Nhập vào số phần tử của mảng: ");
			n = N.nextInt();
			 mang= new int[n];
			for(int i=0; i<n ;i++) {
			 int	j= i+1;
				System.out.print("nhập phần tử thứ "+j+":");
				mang[i]=N.nextInt();
			}
			System.out.println("Mảng đã nhập: ");
			for(int i=0; i<mang.length; i++) {
				System.out.print(mang[i] +" ");
			}
			int max= mang[0];
			int min = mang[0];
			int a = 0;
			int b = 0;
			for(int i=0; i<mang.length; i++)
			{
				if(max<mang[i]) {
					max= mang[i];
					a=i;
				}
				if(min>mang[i]) {
					max= mang[i];
					b=i;
			}
		}
			System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + a);
			System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + b);
			System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
			N.nextLine();
			N.nextLine();
		
		}
		public static void sapxepmang() {
		
			
			Scanner N = new Scanner(System.in);
			
			//tìm min max và vị trí
			int max= mang[0];
			int min = mang[0];
			int a = 0;
			int b = 0;
			for(int i=0; i<mang.length; i++)
			{
				if(max<mang[i]) {
					max= mang[i];
					a=i;
				}
				if(min>mang[i]) {
					max= mang[i];
					b=i;
			}
		}
			System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + a);
			System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + b);
			for(int i=0;i<mang.length;i++) {
				int tang=mang[i];
				for(int j=i+1;j<mang.length;j++) {
					if(tang>mang[j]) {
						mang[i]=mang[j];
						mang[j]=tang;
						tang=mang[i];
					}
				}
			}
			System.out.println("Mang được sắp xếp tăng dần");
			for(int i=0;i<n;i++) {
				System.out.println(mang[i]);
			}
			for(int i=0;i<mang.length;i++) {
				int tang=mang[i];
				for(int j=i+1;j<mang.length;j++) {
					if(tang<mang[j]) {
						mang[i]=mang[j];
						mang[j]=tang;
						tang=mang[i];
					}
				}
				
			}
			System.out.println("Mang được sắp xếp giảm dần");
			for(int i=0;i<n;i++) {
				System.out.println(mang[i]);
			}
			System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
			N.nextLine();
			N.nextLine();
		}
		public static void ketthuc() {
			System.out.println("See you again.");
			System.exit(0);
		}
}
