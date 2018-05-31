/************************************************* 
 * Assignment02_in_mang
 * @author: LEE KHAR HOONG NHAATJ------ASM_JAVA_02
 *Date: 29-05-2018
 *************************************************/

import java.util.Scanner;

public class Asm_02 {
	public static void main(String[] args) {
	    int n,  Giam, Tang;
	    Scanner scanner = new Scanner(System.in);
	         
	    do {
	        System.out.println("Nhập vào số phần tử của mảng: ");
	        n = scanner.nextInt();
	    } while (n < 0);
	         
	    // khởi tạo và cấp phát bộ nhớ cho mảng
	    int array[] = new int[n];
	         
	    System.out.println("Nhập các phần tử cho mảng: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print("Nhập phần tử thứ " + i + ": ");
	        array[i] = scanner.nextInt();
	    }
	         
	    // Hiển thị mảng vừa nhập
	    System.out.println("Mảng ban đầu: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print(array[i] + " ");
	    }
	         
	    
	         
	    // sắp xếp theo thứ tự giảm dần
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i + 1; j <= n - 1; j++) {
	            if (array[i] < array[j]) {
	                Giam = array[i];
	                array[i] = array[j];
	                array[j] = Giam;
	            }
	        }
	    }
	    System.out.println(" ");
	    System.out.println("Mảng sau khi sắp xếp giảm là: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print(array[i] + " ");
	    }
	         
	    
	 // sắp xếp theo thứ tự tăng dần
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i + 1; j <= n - 1; j++) {
	            if (array[i] > array[j]) {
	                Tang = array[i];
	                array[i] = array[j];
	                array[j] = Tang;
	            }
	        }
	    }
	    
	    System.out.println(" ");
	    System.out.println("Mảng sau khi sắp xếp tăng là: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print(array[i] + " ");
	    }
	    
	    int max = array[0];
		int min = array[0];
		int X = 0;
		int Y = 0;
		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
				max = array[i];
				X = i;
			}
			if (min > array[i]) {
				min = array[i];
				Y = i;
			}
		}
	    System.out.println("Giá trị nhỏ nhất trong mảng là " + array[0] + " Vị Trí của số lớn nhất là : " + X);
	    System.out.println("Giá trị lớn nhất trong mảng là " + array[n - 1] + " Vị Trí của số nhỏ nhất là : " + Y);
	}

}
