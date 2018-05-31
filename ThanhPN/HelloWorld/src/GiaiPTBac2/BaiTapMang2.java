package GiaiPTBac2;

import java.util.Scanner;

public class BaiTapMang2 {

	public static void main(String[] args) {
		// phần khai báo
		int i;
		int sapxep;
		int n;
		int [] arr;
		int gtMin, gtMax, vtMin, vtMax;
		// Phần Thân 
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời Bạn Nhập Phần Tử Của Mảng : ");
		n = scanner.nextInt();
		
		
	    // Khai báo mảng 
	    arr = new int [n];
		
		// vòng lặp mảng 
		for (i=0; i<n;i++) {
			System.out.printf("Arr " + i + " : " );
			arr[i] = scanner.nextInt();
		}
		System.out.println("Các phần tử của mảng: ");
		for (i=0; i<arr.length;i++) {
			System.out.println(arr[i] + " ");
		}
		
	/****	gtMin = arr[0];
		 gtMax = arr[0];
		vtMax = 0;
		vtMin = 0;
		for (i = 0; i < n; i++) {
			if (arr[i]<gtMin) {
			gtMin=arr[i];
			vtMin = i;
				
			}
			if (arr[i]>gtMax) {
				gtMax=arr[i];
			 vtMax = i;
			}
		}
		System.out.println("giá trị nhỏ nhất: " +gtMin);
		System.out.println("giá trị lớn nhất: " +gtMax);
	    System.out.println("vị trí nhỏ nhất: " + vtMin);
	    System.out.println("vị trí lớn nhất: " + vtMax);
		
		*/
		
		
		 for ( i = 0; i < n - 1; i++) {                                                                                       
		        for (int j = n - 1; j >= 1; j--) {
		            // nếu phần tử đứng sau nhỏ hơn phần tử đứng trước
		            // thì đổi chỗ 2 phần tử đó cho nhau
		            // với cách sắp xếp này thì trong lần duyệt đầu tiên
		            // phần tử nhỏ nhất sẽ được chuyển lên trên cùng.
		            if (arr[j] < arr[j - 1]) {//3561
		            	//61
		                sapxep = arr[j];
		                arr[j] = arr[j-1];
		                arr[j-1] = sapxep;
		            }
		        }
		    }
		         
		    System.out.println("\nMảng sau khi sắp xếp: ");
		    for (i = 0; i < n; i++) {
		        System.out.print(arr[i] + "\t");
		    }
		
		
}

}
