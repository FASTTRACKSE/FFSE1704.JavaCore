/*
 * Assiment3
 * Prog: Mảng.
 * Outhor: Trần Xuân Kỳ.
 * Date:29/May/2018.
 * Mail:FFSE1701005@st.fasttrack.edu.vn 
 * */


package first.project;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NhapGiaTriMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,j,max,min,locationMax,locationMin,ldb;
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
		/*Arrays.sort(mang);
        System.out.println("Dãy số được sắp xếp tăng dần: ");
        for(i=0;i<n;i++) {
        	System.out.println(mang[i]);
        }
        int mang2[]=
        Arrays.sort(mang,Collections.reverseOrder());*/
		for (i = 0; i < n - 1; i++) {
	        for (j = n - 1; j >= 1; j--) {
	            // nếu phần tử đứng sau nhỏ hơn phần tử đứng trước
	            // thì đổi chỗ 2 phần tử đó cho nhau
	            // với cách sắp xếp này thì trong lần duyệt đầu tiên
	            // phần tử nhỏ nhất sẽ được chuyển lên trên cùng.
	            if (mang[j] < mang[j - 1]) {
	                ldb = mang[j];
	                mang[j] = mang[j-1];
	                mang[j-1] = ldb;
	            }
	        }
	    }
	         
		System.out.println("Sắp xếp mảng theo chiều tăng dần");
	    for (i = 0; i < n; i++) {
	        System.out.print(mang[i] + "\t");
	    }
	    for (i = 0; i < n - 1; i++) {
	        for (j = n - 1; j >= 1; j--) {
	            // nếu phần tử đứng sau lớn hơn phần tử đứng trước
	            // thì đổi chỗ 2 phần tử đó cho nhau
	            // với cách sắp xếp này thì trong lần duyệt đầu tiên
	            // phần tử lớn nhất sẽ được chuyển lên trên cùng.
	            if (mang[j] > mang[j - 1]) {
	                ldb = mang[j];
	                mang[j] = mang[j-1];
	                mang[j-1] = ldb;
	            }
	        }
	    }
	    System.out.println();
	         
		System.out.println("Sắp xếp mảng theo chiều giảm dần");
	    for (i = 0; i < n; i++) {
	        System.out.print(mang[i] + "\t");
	    }

	}

}
