/**
 * 
 */
package fasttrackse.asignment;

import java.util.Scanner;

/**
 * @author PC
 *
 */
public class NhapVaInRadanhSachMang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		// kiểm tra gia tri lớn nhất
		int max = array[0];
		
		int min = array[0];
		
		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
				max = array[i];
				vtmax = i;}

			if (min > array[i]) {
				min = array[i];
				vtmin = i;}
		}
		System.out.println("\n giá trị lớn nhất là: " + max + " và vị trí trong mảng là: " + vtmax );
		System.out.println("giá trị nhỏ nhất là: " + min  + " và vị trí trong mảng là: " + vtmin);
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
	

}
