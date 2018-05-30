/************************
 *CtNhapDuLieuChoMang
 *Bùi Lê Anh Vũ
 *29/05/2018
 **********************/
package CtNhapDuLieuChoMang;
import java.util.Scanner;
public class CtNhapDuLieuChoMang {

	public static void main(String[] args) {
		//Khai Báo
		int N;	
		
		Scanner myInput = new Scanner (System.in);
		System.out.print("Nhập Số lượng mảng : ");
		N = myInput.nextInt();
		int[] myArray = new int[N];
		
		//Kiểm tra Số lượng muốn tạo, và cho phép người dùng nhập giá trị trong mảng.
		for(int i=0;i<N;i++) {
			System.out.print("Nhập Phần tử thứ "+ (i+1)+ " của mảng: ");
			myArray[i]= myInput.nextInt();
		}
		//
		System.out.println("Giá Trị Của Mảng :");
		for(int i=0;i<N;i++) {
			System.out.print( myArray[i]+"\t");
		}
		//Bài 2+3 tìm giá trị và vị trí lớn bé cho mảng
		int gtMin,gtMax,vtMin,vtMax;
		gtMin=myArray[0];
		gtMax=myArray[0];
		vtMin=0;
		vtMax=0;
		for(int i=1;i<N;i++) {
			if(gtMin>myArray[i]) {
				gtMin=myArray[i];
				vtMin= (i+1);
			}
			if(gtMax<myArray[i]) {
				gtMax=myArray[i];
				vtMax= (i+1);
			}
		}
        System.out.println("\nGiá Trị Lớn nhất là "+ gtMax +" Vị Trí của số lớn nhất là : "+ vtMax);
        System.out.println("Giá Trị Nhỏ nhất là "+ gtMin + " Vị Trí của số nhỏ nhất là : "+ vtMin);
        // Sắp xếp
        for(int i=0; i< N-1;i++) {
        	for(int j=i+1;j<=N-1;j++) {
        		if(myArray[j] < myArray[i]) {
        			int temp = myArray[i];
        			myArray[i]=myArray[j];
        			myArray[j]=temp;
        		}
        	}
        }
        System.out.println("Mảng sau khi sắp xếp là");
        for(int i=0;i<N;i++) {
        	System.out.print( myArray[i] +"\t" );
        	
        }
	}
        

}
