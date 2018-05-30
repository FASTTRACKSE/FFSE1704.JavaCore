/*
 * Assiment3
 * Prog: Mảng.
 * Outhor: Trần Xuân Kỳ.
 * Date:29/May/2018.
 * Mail:FFSE1701005@st.fasttrack.edu.vn 
 * */


package first.project;

import java.util.Scanner;

public class NhapGiaTriMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,j,max,min,locationMax,locationMin;
		System.out.print("Nhập số phần tử mảng: ");
		Scanner nhap = new Scanner(System.in);
		n = nhap.nextInt();
		int[] mang = new int[n] ;
		for(i=0,j=1;i<n;i++,j++) {
			System.out.print("Nhập giấ trị phần tử thứ " + j + " : ");
			mang[i]=nhap.nextInt();
			//System.out.println();
			
		}
		max= mang[0];
		min=mang[0];
		locationMax=0;
		locationMin=0;
		for(i=0;i<n;i++) {
			if(max<mang[i]) {
				max=mang[i];
				locationMax=i;
			}
			if(min>mang[i]) {
				min=mang[i];
				locationMin=i;
			}
		}
		System.out.println("Danh sách mảng:");
		for(i=0;i<mang.length;i++)
		System.out.print(mang[i]+ " ");
		System.out.println();
		System.out.print("Giá trị lớn nhất là: " + max + ".");
		System.out.println(" Vị trí phần tử chứa giá trị lớn nhất là: " + locationMax + ".");
		System.out.print("Giá trị nhỏ nhất là: " + min + ".");
		System.out.println(" Vị trí phần tử chứa giá trị nhỏ nhất là: " + locationMin + ".");
	}

}
