package fasttrackse.baitap.asm;

import java.util.Scanner;

public class BaiTapMang {
	public static void main(String[] args) {
		// khai báo
		int N; // tong so phan tu
		int[] myArray;
		int  gtMin, gtMax, vtMin, vtMax; 
		
		Scanner myInput = new Scanner(System.in);
		
		//Phan mem
		
		//1 nhap mang
		System.out.print("Mời bạn nhập số phần tử mảng N = ");
		N = myInput.nextInt();
		
		// khoi tao mang N
		myArray = new int[N];
		
		//vong lap nhap phan tu myarray
		for (int i=0;i<N;i++) {
			System.out.print("Mời bạn nhập phần tử" + (i+1) +":");
			myArray[i]= myInput.nextInt();
		};
		
		//in mang
		System.out.print("danh sach phan tu mang");
		for (int i=0;i<N;i++) {
			System.out.print(" " + myArray[i]);
			
		};
		
		//tim Min Max 
		gtMin = myArray[0];
		vtMin = 0;
		gtMax = myArray[0];
		vtMax = 0;
		
		for (int i=0;i<N;i++) {
			if(myArray[i]>=gtMax) {
				gtMax = myArray[i];
				vtMax = i+1;
			};

		};
		
		System.out.print("\n Giá trị Max là : " + gtMax);
		System.out.print("\n Vị trí Max là : " + vtMax);
		
		for (int i=0;i<N;i++) {
			if(myArray[i]<=gtMin) {
				gtMin = myArray[i];
				vtMin = i+1;
			};

		};
		
		System.out.print("\n Giá trị Min là : " + gtMin);
		System.out.print("\n Vị trí Min là : " + vtMin);
		
		//sap sep tang dan
		
		int bien = 0;
	    for(int i=0;i<N-1;i++)
	        for(int j=i+1;j<N;j++){
	        if(myArray[i]>myArray[j]) {
	        	bien= myArray[i];
	        	myArray[i]=myArray[j];
	        	myArray[j]=bien;
	            }
	    }
	    System.out.print("\n mang tang dan");
		for (int i=0;i<N;i++) {
			System.out.print(" " + myArray[i]);
			
		};
		
		// sap sep giam dan
		
		bien = 0;
	    for(int i=0;i<N-1;i++)
	        for(int j=i+1;j<N;j++){
	        if(myArray[i]<myArray[j]) {
	        	bien= myArray[i];
	        	myArray[i]=myArray[j];
	        	myArray[j]=bien;
	            }
	    }
	    System.out.print("\n mang giam dan");
		for (int i=0;i<N;i++) {
			System.out.print(" " + myArray[i]);
			
		};
	}
	
	
	
	
	
}
