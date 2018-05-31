
package asignment;
import java.util.*;

public class menu {

	
	public static void main(String[] args) {
		//dữ liệu xuất ra
				Scanner nhapso = new Scanner(System.in);
				int answer = nhapso.nextInt();
				if (answer==1) {
					giaphuongtrinh();
				}
				if (answer==2) {
					giaiphuongtrinhbat2();
				}
				if (answer==3) {
					khaibaomang();
				}
				if (answer==6) {
					ketthuc();
				}
		Menu(); }
	
	public static void Menu() {
	}
		// GIẢI PHUONG TRÌNH BẬC NHẤT *****************************************************
	
	public static void giaphuongtrinh() {
	

			
		Scanner myInput = new Scanner(System.in);
				
				System.out.println("***************************");
				System.out.println("| GIẢI PHƯƠNG TRÌNH BẬC NHẤT |");
				System.out.println("***************************");	
		 		double X;
				System.out.print("Nhập tham số a = ");
				int A = myInput.nextInt();

				System.out.print("Nhập tham số b = ");
				int B = myInput.nextInt();
				
				 if(A==0) {
					 if(B==10) {
						 System.out.println("Phương trình"+ A + "X" + "+"+B +"=0"+"vô số nghiệm"); 
					 }else{
						 System.out.println("Phương trình"+ A + "X" + "+"+B +"=0"+"vô nghiệm");
					 };
					 
				 }else{
					 X =B *1.0/ A;
					 System.out.println("Phương trình "+ A + "X" + "+"+B +"=0 "+"có nghiệm X bằng "+X);
				 };
			
				
				

		}
	public static void ketthuc(){
		System.out.println("KẾT THÚC CHƯƠNG TRÌNH");
	}
			
	// GIẢI PHƯƠNG TRÌNH BẬC HAI *********************************************	
			public static void giaiphuongtrinhbat2() {
			Scanner myInput = new Scanner(System.in);
				
				System.out.println("*************************");
				System.out.println("|GiẢI PHƯƠNG TRÌNH BẬC HAI |");
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

			{
				
				
			};

		}
		public static void khaibaomang() {
			// khai bao 
			int n;
			Scanner N = new Scanner(System.in);
			System.out.println("Nhập vào số phần tử của mảng: ");
			n = N.nextInt();
			//-- khởi tạo và cấp phát bộ nhớ cho mảng
			int array[] = new int[n];
			
			// phân thân trang code
			System.out.println("nhập các phần tử trong mảng: ");
			for(int i = 0; i < n; i++) {
				int j = i + 1;
				System.out.println("nhập phần tử thứ" + j + ":");
				array[i] = N.nextInt();
			}
			
			// hiển thị mảng vừa nhập
			System.out.println("mảng đã nhập: ");
			for (int i = 0; i < n; i++ ) {
				System.out.println(array[i]+ " ");
			}
			System.out.println(" ");
			// tim min max và vị trí
			int max = array[0];
			int min = array[0];
			int X = 0;
			int Y = 0;
			for(int i=0; i < n; i++) {
				if(max < array[i]) {
					max = array[i];
					X = i;
				}
				if (min > array[i]) {
					min = array[i];
					Y = i;
				}
			}
			System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + X);
			System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + Y);
		}
		}

		
		
			