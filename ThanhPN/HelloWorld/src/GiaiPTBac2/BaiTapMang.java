/**********
 * Viết chương trình nhập dữ liệu cho một mảng số nguyên gồm N phần tử. 
 * Số lượng phần tử N và giá trị các phần tử mảng được nhập từ bàn phím.
   
   Phạm Ngọc Thành
     29/5/2018
 */

package GiaiPTBac2;
import java.util.Scanner;
public class BaiTapMang {

	public static void main(String[] args) {
		
	
		// phần khai báo
		
		Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập số phần tử của mảng: ");
			 int n = scanner.nextInt();
			 int []arr = new int[n];
			 
			// phần thân
			 
			 for (int i = 0; i < n; i++) {
				 System.out.printf("Ar[%d] = " , i);
				 arr[i] = scanner.nextInt();
				
			 }
			
			 // tính giá trị nhỏ nhất , lớn nhất 
			 // vị trí lớn nhất , nhỏ nhất
			 
			int max = arr[0];
			int min = arr[0];
			int vitrimax = 0;
			int vitrimin = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i]<min) {
				min=arr[i];
				vitrimin = i;
					
				}
				if (arr[i]>max) {
					max=arr[i];
				 vitrimax = i;
				}
			}
			System.out.println("giá trị nhỏ nhất: " +min);
			System.out.println("giá trị lớn nhất: " +max);
		    System.out.println("vị trí nhỏ nhất: " + vitrimin);
		    System.out.println("vị trí lớn nhất: " + vitrimax);
			
			
	}

}
