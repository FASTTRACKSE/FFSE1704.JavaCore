package fasttrackse.javacore.assignment;
import java.util.Scanner;
public class Assignment4 {
	static int N,i,j;
	static int[] myArray;
	static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bài tập Menu chương trình");
		while(true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+------------------------------+");
			System.out.println("|1.Giải Phương Trình Bậc 1     |");
			System.out.println("|2.Giải Phương Trình Bậc 2     |");
			System.out.println("|3.Nhập Mảng                   |");
			System.out.println("|4.Sắp Xếp Mảng và in kết quả  |");
			System.out.println("|5.Kết Thúc chương trình       |");
			System.out.println("+------------------------------+");
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
			SapXepMang();
			
		}
		else if(answer==5) {
			System.exit(0);
		}
		}
	}
	private static void GiaiPTB1() {
		// TODO Auto-generated method stub
		System.out.println("Giải phương trình bậc 1: ax + b = 0");
		Scanner ptbac1 = new Scanner(System.in);
		double a,b;
		//  nhập tham số
		System.out.println("Mời nhập tham số a: ");
		a = ptbac1.nextDouble();
		System.out.println("Mời nhập tham số b: ");
		b = ptbac1.nextDouble();		
		// giải pbbac1
		if(a==0) {
			if(b==0) {
				System.out.println("Phương trình có vô số nghiệm.");
			}
			else {
				System.out.println("Phương trình vô nghiệm.");
			}
			
		}
		else {
			System.out.println("Phương trình có nghiêm: " + (-b/a));
		}
	}
	private static void GiaiPTB2() {
		// TODO Auto-generated method stub
		System.out.println("Giải phương trình bậc 2: ax2 + bx = c");
		Scanner ptbac2 = new Scanner(System.in);
		Double a,b,c;
		// Nhập tham số a, b, c.
		System.out.println("Mời nhập tham số a: ");
		a = ptbac2.nextDouble();
		System.out.println("Mời nhập tham số b: ");
		b = ptbac2.nextDouble();
		System.out.println("Mời nhập tham số c: ");
		c = ptbac2.nextDouble();
		//giải phường trình
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("Phương trình có vô số nghiệm.");
				}
				else {
					System.out.println("Phường trình vô nghiệm");
				}
			}
			else if(c==0) {
				System.out.println("phương trình vô nghiệm");
			}
			else{
				System.out.format("Phường trình có 1 nghiệm: %.3f" , (-c/b));
			}
		}
		else {
			Object math;
			//đi tìm delta
			Double Delta = Math.pow(b,2)-4*a*c;
			if(Delta<0) {
				System.out.println("Phương trình vô nghiệm");
			}
			else if(Delta==0) {
				System.out.println("phương trình có nghiệp kép x1 = x2 = " +(-b/(2*a)));
			}
			else {
				System.out.println("phương trình có 2 nghiệm x1,x2.");
				Double x1;
				Double x2;
				x1=(-b+Math.sqrt(Delta)/(2*a));
				x2=(-b-Math.sqrt(Delta)/(2*a));
				System.out.println("Nghiệm x1= " +x1);
				System.out.println("Nghiệm x2= " +x2);
			}
		}
	}
	private static void NhapMang() {
		// TODO Auto-generated method stub
		// khai báo
				int N;
				Scanner mang = new Scanner(System.in);
				System.out.println("Mời nhập số lượng mảng: ");
				N = mang.nextInt();
				int[] myArray = new int[N];
				
				//nhập mảng
				for(int i=0;i<N;i++) {
					System.out.println("nhập phần tử thứ " + (i+1) +  " của mảng: ");
					myArray[i] = mang.nextInt();
				}
						//hiển thị mảng vừa nhập
				System.out.println("mảng ban đầu: "+ "\t");
				for(int i=0; i<N; i++) {
					System.out.print(myArray[i] + "\t" + "\n");
				}
				//phần tử lớn nhất, nhỏ nhất, vị trí.
				int ptmax;
				int ptmin;
				int vtmax;
				int vtmin;
				ptmax=myArray[0];
				ptmin=myArray[0];
				vtmax=0;
				vtmin=0;
				for(int i=0;i<N;i++) {
					if(ptmax < myArray[i]) {
						ptmax=myArray[i];
						vtmax=(i+1);
					}
					if(ptmin > myArray[i]) {
						ptmin=myArray[i];
						vtmin=(i+1);
					}
				}
				System.out.println("giá trị phần tử lớn nhất trong mảng là: " + ptmax + " và ở vị trí thứ: " + vtmax);
				System.out.println("giá trị phần tử nhỏ nhất trong mảng là: " + ptmin + " và ở vị trí thứ: " + vtmin);
	}
	private static void SapXepMang() {
		// TODO Auto-generated method stub
		// khai báo
				int N;
				Scanner mang = new Scanner(System.in);
				System.out.println("Mời nhập số lượng mảng: ");
				N = mang.nextInt();
				int[] myArray = new int[N];
				//nhập mảng
				for(int i=0;i<N;i++) {
					System.out.println("nhập phần tử thứ " + (i+1) +  " của mảng: ");
					myArray[i] = mang.nextInt();
				}
						//hiển thị mảng vừa nhập
				System.out.println("mảng ban đầu: "+ "\t");
				for(int i=0; i<N; i++) {
					System.out.print(myArray[i] + "\t" + "\n");
				}
				//sắp  xếp mảng
				for (int i=0;i<N-1;i++) {
					for (int j=i+1; j<=N-1; j++) {
						if(myArray[i]>myArray[j]) {
						int	Sort1 = myArray[i];
						myArray[i]=myArray[j];
						myArray[j]=Sort1;
							
						}
					}
				}
				System.out.println("Mảng đươc sắp xếp theo giá trị lớn dần: ");
				for(int i=0;i<N;i++) {
					System.out.print(myArray[i] + "\t");
				}
				//sắp xếp theo thứ tự nhỏ dần
				for(int i=0; i<N-1; i++) {
		        	for(int j=i+1; j<=N-1; j++) {
		        		if(myArray[j] > myArray[i]) {
		        			int temp2 = myArray[i];
		        			myArray[i]=myArray[j];
		        			myArray[j]=temp2;
		        		}
		        	}
		        }
				System.out.println("\nMảng được sắp xếp theo giá trị nhỏ dần: ");
		        for(int i=0;i<N;i++) {
		        	System.out.print( myArray[i] +"\t" );
		        }
	}
	
	
	

}

