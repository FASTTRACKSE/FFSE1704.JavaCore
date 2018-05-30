/******************
 * thiết kế menu
 * 
 ******************/
package fasttrackse.asignment;
import java.util.*;

public class ThietKeMenu {

	
	public static void main(String[] args) {
		//dữ liệu xuất ra
				Scanner nhapso = new Scanner(System.in);
				System.out.println("************************************");
				System.out.println("  |     nhập 1 giải PTBN          |");
				System.out.println("  |     nhập 2 giải PTBH          |");
				System.out.println("  |     nhập 3 nhập mảng          |");
				System.out.println("  |     nhập 4 sắp xếp tăng       |");
				System.out.println("  |     nhập 5 sắp xếp giảm       |");
				System.out.println("  |     nhập 6 GET OUT PROGRAM    |");
				System.out.println("************************************");
				int answer = nhapso.nextInt();
				if (answer==1) {
					GPTBN();
				}
				if (answer==2) {
					GPTBH();
				}
				if (answer==3) {
					nhapdanhsachmang();
				}
				if (answer==4) {
					Sapxeptang();
				}
				if (answer==5) {
					sapxepgiam();
				}
				if (answer==6) {
					ketthuc();
				}
		Menu(); }
	
	public static void Menu() {
	}
		// GIẢI PHUONG TRÌNH BẬC NHẤT *******************************************************
	
	public static void GPTBN() {
	

			
		Scanner myInput = new Scanner(System.in);
				
				System.out.println("*****************************");
				System.out.println("| GIẢI PHƯƠNG TRÌNH BẬC NHẤT |");
				System.out.println("*****************************");	
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
			
	// GIẢI PHƯƠNG TRÌNH BẬC HAI ***********************************************	
			public static void GPTBH() {
			Scanner myInput = new Scanner(System.in);
				
				System.out.println("***************************");
				System.out.println("|GiẢI PHƯƠNG TRÌNH BẬC HAI |");
				System.out.println("***************************");
				
		 		
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


		
	
//NHẬP VÀ IN RA DANH SÁCH MẢNG ***********************************************************
		public static void nhapdanhsachmang() {


		// Phần thân ct

		// nhập số lượng phần tử trong mảng
		Scanner myInput = new Scanner(System.in);
		int n;
		int vtmin=0,vtmax=0;
		

		do {
			System.out.print("Nhập vào số phần tử của mảng: ");
			n = myInput.nextInt();
		} while (n < 0);

		// khởi tạo và cấp phát bộ nhớ cho mảng
		int array[] = new int[n];

		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i+1) + ": ");
			array[i] = myInput.nextInt();
		}

		 }
	// SẮP XẾP TĂNG ****************************************************************************
	public static void Sapxeptang(){

	

		// nhập số lượng phần tử trong mảng
		Scanner myInput = new Scanner(System.in);
		int n;
		int vtmin=0,vtmax=0;
		

		do {
			System.out.print("Nhập vào số phần tử của mảng: ");
			n = myInput.nextInt();
		} while (n < 0);

		// khởi tạo và cấp phát bộ nhớ cho mảng
		int array[] = new int[n];

		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i+1) + ": ");
			array[i] = myInput.nextInt();
		}

		// Hiển thị mảng vừa nhập
		System.out.print("\n Mảng ban đầu: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + "\t");
		}
		
		
		int sapxepnl;
		for (int i=0; i<n-1; i++) {
			for( int j=i; j<=n-1; j++) {
			if (array[i] > array[j]) {
		        sapxepnl = array[i];
		        array[i] = array[j];
		        array[j] = sapxepnl;
		         }
				
				
			}
		}
		System.out.print("\n sắp xếp từ bé đến lớn   ");
		for (int i=0;i<n;i++) {
		System.out.print( array[i] +"\t");
		}
	}
	
	


// SẮP XẾP GIẢM*****************************************************************************
	public static void sapxepgiam(){
	
	
		// Phần thân ct

		// nhập số lượng phần tử trong mảng
		Scanner myInput = new Scanner(System.in);
		int n;
		int vtmin=0,vtmax=0;
		

		do {
			System.out.print("Nhập vào số phần tử của mảng: ");
			n = myInput.nextInt();
		} while (n < 0);

		// khởi tạo và cấp phát bộ nhớ cho mảng
		int array[] = new int[n];

		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i+1) + ": ");
			array[i] = myInput.nextInt();
		}

		// Hiển thị mảng vừa nhập
		System.out.print("\n Mảng ban đầu: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + "\t");
		}
		
		int sapxeplb;
		for (int i=0; i<n-1; i++) {
			for( int j=i; j<=n-1; j++) {
			if (array[i] < array[j]) {
		        sapxeplb = array[i];
		        array[i] = array[j];
		        array[j] = sapxeplb;
		         }
				
				
			}
		}
		System.out.print("\n sắp xếp từ lớn đến bé    ");
		for (int i=0;i<n;i++) {
		System.out.print( array[i] +"\t");
		}
		}
		
		
			
		}
		
	

	
	

	
	
	


