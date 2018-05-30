package ffse1703012.bai1.practice;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		menu();
			
	}
		public static void menu() {
			
			Scanner sc =new Scanner(System.in);	
			System.out.println(">> Chương trình máy tính<< ");
			System.out.println("+---------------------------------------+");
			System.out.println("|	1. Giải phép cộng		|");
			System.out.println("|	2. Giải phương trình bậc 1	|");
			System.out.println("|	3. Giải phương trình bậc 2	|");
			System.out.println("|	4. Chọn bài toán khác		|");
			System.out.println("|	5. Thoát chương trình		|");
			System.out.println("+---------------------------------------+");
			System.out.println("Chọn chức năng: ");
			int answer= sc.nextInt();
			if(answer == 1) {
				phepcong();
			}else if(answer == 2) {
				phuongtrinhbac1();
			}else if(answer == 3) {
				phuongtrinhbac2();
			}else if(answer == 4) {
				menu();
			}else if(answer == 5) {
				System.exit(0);
			}
			
		}
		
		private static void While(boolean b) {
			// TODO Auto-generated method stub
			
		}
		public static void phepcong() {
			System.out.println("----------------------------");
			System.out.println("|	Giải phép cộng	   |");
			System.out.println("----------------------------");
			Scanner sc = new Scanner(System.in);
			int a;
			System.out.print("Nhập số a: ");
			a= sc.nextInt();
			int b;
			System.out.print("Nhập số b: ");
			b= sc.nextInt();
			int c=a+b;
			System.out.print("Kết quả của "+a+ " + " +b +" = "+c);
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
	    
		}
}


