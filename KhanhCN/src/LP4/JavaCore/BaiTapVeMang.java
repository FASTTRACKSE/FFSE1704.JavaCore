/***********************
  Bài tập Assignment 3
 Prog : BÀI TẬP VỀ MẢNG 
 Outhor : CAO NGỌC KHÁNH
 Date : 29-May-2018
 
************************/
package LP4.JavaCore;

import java.util.Scanner;

public class BaiTapVeMang {

	public static void main(String[] args) {
		// Phần khai báo
		int n;
		float mang[] = new float[10];
		Scanner nhap = new Scanner(System.in);

		// Thân chương trình
		System.out.println("*******BÀI LÀM*********");
		System.out.println("-----------------");
		System.out.print("Xin nhập số lượng phần tử của mảng : ");

		n = nhap.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + i + " của mảng :");
			mang[i] = nhap.nextFloat();

		}
		float max = mang[0];
		float min = mang[0];
		int vitriMax = 0;
		int vitriMin = 0;

		// Vòng lặp tính tim Min Max và vị trí của chúng trong mảng

		for (int i = 0; i < n; i++) {

			if (mang[i] > max) {
				max = mang[i];
				vitriMax = i;

			}
			if (mang[i] < min) {
				min = mang[i];
				vitriMin = i;
			}

		}
		
		int sapxep;

		
		for(int i = 0 ; i<n-1 ;i++) {
			for(int j=n-1; j>=1 ; j--) {
				
				if(mang[j]<mang[j-1]){
					
					sapxep = (int) mang[j];
					mang[j] = mang[j-1];
					mang[j-1] = sapxep;
					
				}
			}
			
		}
		

		System.out.println("******************");
		System.out.println("Mang N có  giá trị lớn nhất là :" + max+ " ở vị trí thứ " + vitriMax);
		System.out.println("******************");
		System.out.println("Mảng N có giá trị nhỏ nhất là : " + min+ " ở vị trí thứ " + vitriMin);
		System.out.println("******************");
		System.out.println("Sắp xếp từ bé đến lớn là : ");
		
		for(int i= 0 ; i<n ; i++) {
			System.out.print(mang[i]+ " ->  ");
			
		}
		
		
	}

}
