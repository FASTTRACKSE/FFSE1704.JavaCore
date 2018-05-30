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
		
		//nhập số lượng phần tử trong mảng
		Scanner myInput = new Scanner(System.in);
		int n;
	   
	         
	    do {
	        System.out.print("Nhập vào số phần tử của mảng: ");
	        n = myInput.nextInt();
	    } while (n < 0);
	         
	    // khởi tạo và cấp phát bộ nhớ cho mảng
	    int array[] = new int[n];
	         
	    System.out.println("Nhập các phần tử cho mảng: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print("Nhập phần tử thứ " + i + ": ");
	        array[i] = myInput.nextInt();
	    }
	         
	    // Hiển thị mảng vừa nhập
	    System.out.print("\n Mảng ban đầu: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print(array[i]+"\t" );
	    }
	    //kiểm tra gia tri lớn nhất
	   int max=array[0];
	   int min=array[0];
	    for (int i=0;i <n ;i++) {
	    	if (max < array[i])
	    		max = array[i];
	   
	 	    if (min > array[i])
	 	    	min = array[i];
	    }
	  System.out.println("giá trị lớn nhất là: " + max  );
	  System.out.println("giá trị nhỏ nhất là: " + min );
		}
		
	}
	


