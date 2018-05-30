/************************
 *CtNhapDuLieuChoMang
 *Bùi Lê Anh Vũ
 *29/05/2018
 **********************/
package CtNhapDuLieuChoMang;
import java.util.Scanner;
public class CtNhapDuLieuChoMang {

	public static void main(String[] args) {
		//Nhập Số lượng
		int N;
		System.out.print("Nhập Số lượng mảng : ");
		int a[]= new int[50];
		Scanner nhap = new Scanner (System.in);
		N = nhap.nextInt();
		//Kiểm tra Số lượng muốn tạo, và cho phép người dùng nhập giá trị trong mảng.
		for(int i=0;i<N;i++) {
			a[i]= nhap.nextInt();
		}
		for(int i=0;i<N;i++) {
			System.out.println("Số Thứ "+i+" trong mảng là : " + a[i]);
		}
		//Bài 2+3 tìm giá trị và vị trí lớn bé cho mảng
		int max=a[0];
		int min=a[0];
		int i;
		int maxi=0;
		int mini=0;
		for (i=0;i<N;i++)
        {
            if(max<a[i]) {
                max=a[i];
                maxi=i;
            }
            if(min>a[i]) {
             min=a[i];
             mini=i;
            }
        }
        System.out.println("Giá Trị Lớn nhất là "+ max +" Vị Trí của số lớn nhất là : "+ maxi);
        System.out.println("Giá Trị Nhỏ nhất là "+ min + " Vị Trí của số nhỏ nhất là : "+ mini);
        
	}

}
