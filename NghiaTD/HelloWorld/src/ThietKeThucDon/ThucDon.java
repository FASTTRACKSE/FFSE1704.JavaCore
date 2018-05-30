package ThietKeThucDon;
import java.util.Scanner;
public class ThucDon {
	static int n, i , j , max, min;
	static int mang[];
	public static void main(String[] args) {
		
		menu();
		
	}
	public static void menu() {
		// TODO Auto-generated method stub
		
		while(true) {
		System.out.println("Hello members: ");
		System.out.println("+--------------------------+");
		System.out.println("| 1.Giải Pt bậc 1          |");
		System.out.println("| 2.Giải Pt bậc 2          |");
		System.out.println("| 3.Giải Pt bậc nhập mảng  |");
		System.out.println("| 4.Sắp xếp mảng tăng dần  |");
		System.out.println("| 5.kêt thúc               |");
		System.out.println("+--------------------------+");
		Scanner nhap = new Scanner(System.in);
		int press=nhap.nextInt();
		if(press==1) {
			Giaiptbac1();
		}
		else if(press==2){
			Giaiptbac2();
		}
		else if(press==3){
			Nhapmang();
		}
		else if(press==4){
			Sapxepmangtangdan();
		}
		else if(press==5){
			
		}
	}
	}
	public static void Giaiptbac1() {
		int soa, sob, x;
		double nghiemX;
		Scanner myInput = new Scanner(System.in);
	
		System.out.println("nháº­p vÃ o sá»‘ a:");
		soa= myInput.nextInt();
		System.out.println("nháº­p vÃ o sá»‘ b:");
		sob= myInput.nextInt();
		if(soa==0) {
		if(sob==0) {
			System.out.println("PhÆ°Æ¡ng trÃ¬nh" + soa+"x+"+sob+"=0 vÃ´ sá»‘ nghiá»‡m");
		}
		else
		{
			System.out.println("PhÆ°Æ¡ng trÃ¬nh" + soa+"x+"+sob+"=0 vÃ´ nghiá»‡m");

	}
		}
		else {
			x = -sob/soa;
			System.out.println("PhÆ°Æ¡ng trÃ¬nh cÃ³ nghiá»‡m" + "x="+ x );
		}
		System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
		myInput.nextLine();
		myInput.nextLine();
	}
	public static void Giaiptbac2() {
		int a,b,c;
		System.out.println("Giáº£i phÆ°Æ¡ng trÃ¬nh báº­c hai má»™t áº©n");
		Scanner myInput = new Scanner(System.in);
		System.out.println("nháº­p sá»‘ a:");
		a = myInput.nextInt();
		System.out.println("nháº­p sá»‘ b:");
		b = myInput.nextInt();
		System.out.println("nháº­p sá»‘ c:");
		c = myInput.nextInt();
		System.out.println("phÆ°Æ¡ng trÃ¬nh cÃ³ dáº¡ng" +a+"x*x+"+b+"x+"+c+"=0");
		int delta=b*b-4*a*c;
		System.out.println("delta = b*b-4*a*c"+ " = " +(b*b-4*a*c));
		if(delta>0) {
			System.out.println("phÆ°Æ¡ng trÃ¬nh cÃ³ 2 nghiá»‡m phÃ¢n biá»‡t");
			System.out.println("x1="+(-b+Math.sqrt(delta))/(2*a));
			System.out.println("x2="+(-b-Math.sqrt(delta))/(2*a));
		}
		if(delta==0) {
			System.out.println("phÆ°Æ¡ng trÃ¬nh nghiá»‡m kÃ©p x1=x2="+(-b/(2*a)));
		}
		if(delta<0) {
			System.out.println("phÆ°Æ¡ng trÃ¬nh vÃ´ nghiá»‡m ");
		}
		System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
		myInput.nextLine();
		myInput.nextLine();
	}
	
	public static void Nhapmang() {
	 //tổng số ptu mảng
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
		System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
		N.nextLine();
		N.nextLine();
	}
	public static void Sapxepmangtangdan() {
		 //tổng số ptu mảng
		Scanner N = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		
		
		
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
		for( i=0;i<n;i++) {
			System.out.println(mang[i]);
		}
		System.out.println("Vui lòng nhấn enter để bắt đầu lại ");
		N.nextLine();
		N.nextLine();
	}
	

}
