package GiaiPTBac2;
import java.util.Scanner;
public class Menu {
	
	public static void main(String[] args) {
	   menu();
	}
	static int n, i, j, sapxep;
	static int array[];
	static Scanner scanner = new Scanner(System.in);
	
	
	public static void menu() {
		
		while(true) {
		   System.out.println("          >> MÁY TÍNH CÁ NHÂN <<        ");
		   System.out.println("+---------------------------------------+");
		   System.out.println("| 1. Giải Phương Trình Bậc 1    |");
		   System.out.println("| 2. Giải Phương Trình Bậc 2    |");
		   System.out.println("| 3. Nhập Mảng         |");
		   System.out.println("| 4. Sắp Xếp Mảng Tăng Dần      |");
		   System.out.println("| 5. Kết Thúc                   |");
		   System.out.println("+---------------------------------------+");
		   System.out.println(" >> Chọn Chức Năng? ");
	       Scanner scanner = new Scanner(System.in);	
		   int answer = scanner.nextInt();
		   if (answer == 1) {
			   GiaiPTBac1();
			   
		   }
		   else if (answer == 2) {
			   GiaiPTBac2();
		   }
		   else if (answer ==3) {
			   NhapMang();
		   }
		   else if (answer ==4) {
			   SapXepMangTangDan();
		   }
		   else if (answer ==5) {
			   KetThuc();
		   }
		   
		}
	}
    
	public static void GiaiPTBac1() {
		
		      Scanner nhap = new Scanner(System.in);
				
				System.out.println("Nhập vào số a : ");
				int a = nhap.nextInt();
				
				System.out.println("Nhập vào số b : ");
				int b = nhap.nextInt();
				
				if(a==0) {
					if(b==0) {
						System.out.println(" Phương trình " + a +"x + " + b +" = 0 có vô số nghiệm");
					}else {
						System.out.println(" Phương trình "  + a +"x + " + b +" = 0 có vô số nghiệm");
					}
				}else {
				
					float x ; 
					x = (-b/a);
					System.out.println("Phương trình có nghiệm là x = "+x);
				}

			}
		
	
	public static void GiaiPTBac2() {
		
		Scanner scanner = new Scanner(System.in);
		float  a,b,c;
		
		// Nhập a , b, c
		System.out.print("Nhập Số a : ");
		a = scanner.nextInt();
		System.out.print("Nhập Số b : ");
		b= scanner.nextInt();
		System.out.print("Nhập Số c : ");
		c= scanner.nextInt();
		// Kiểm Tra các số đã nhập
		if(a==0) {
			if(b==0) {
				System.out.println("PT vô nghiệm");
			}else {
				System.out.println("PT có 1 nghiệm x= "+ (-c/b));
			}
			
		}
		else { 
			
		}
		
	 float denta = (b*b)-(4*a*c);
		
		//Kiểm tra denta
		if(denta < 0) {
			System.out.println("PT vô Nghiệm");
			
		}else if(denta == 0) {
		
			System.out.println("PT có nghiệm kép x1=x2= " + (-b/(2*a)));
		}else {
			System.out.println("PT có 2 nghiệm phân biệt:");
			System.out.println("PT có Nghiệm x1= "+ (-b + Math.sqrt(denta))/(2*a));
			System.out.println("PT có Nghiệm x2= "+ (-b - Math.sqrt(denta))/(2*a));
			
		}

	}
	
	
	
	public static void NhapMang() {

		// phần khai báo
		
		Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập số phần tử của mảng: ");
			
			  n = scanner.nextInt();
			  array = new int[n];
			 
			// phần thân
			 
			 for (i = 0; i < n; i++) {
				 System.out.printf("Ar[%d] = " , i);
				 array[i] = scanner.nextInt();
				
			 }
			 System.out.println("Các phần tử của mảng: ");
			 for ( i = 0; i< array.length; i++) {
				 System.out.println(array[i] + " ");
				 
			 }
			 
			 // tính giá trị nhỏ nhất , lớn nhất 
			 // vị trí lớn nhất , nhỏ nhất
			 
			int max = array[0];
			int min = array[0];
			int vitrimax = 0;
			int vitrimin = 0;
			for (int i = 0; i < n; i++) {
				if (array[i]<min) {
				min=array[i];
				vitrimin = i;
					
				}
				if (array[i]>max) {
					max=array[i];
				 vitrimax = i;
				}
			}
			System.out.println("giá trị nhỏ nhất: " +min);
			System.out.println("giá trị lớn nhất: " +max);
		    System.out.println("vị trí nhỏ nhất: " + vitrimin);
		    System.out.println("vị trí lớn nhất: " + vitrimax);
			
			
	}



	

public static void SapXepMangTangDan() {
	   
	
	    for (i = 0; i < n - 1; i++) {
	        for (j = n - 1; j >= 1; j--) {

	            if (array[j] < array[j - 1]) {
	                sapxep = array[j];
	                array[j] = array[j-1];
	                array[j-1] = sapxep;
	            }
	        }
	    }
	         
	    System.out.println("\nSap xep theo thu tu tang dan : ");
	    for (i = 0; i < n; i++) {
	        System.out.print(array[i] + "\t");
	    }
	}


public static void KetThuc() {
	scanner.close();
	System.out.println("CẢM ƠN");
	System.exit(0);
}
}

