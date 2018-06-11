package fasttrackse.javacore.assignment;
import java.util.Scanner;
public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bài Tập Nhập Mảng");
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
