/* Assignment02_in_mang
 * @author: TRƯƠNG ĐẠI NGHĨA------ASM_JAVA_02
 *Date: 30-05-2018 */
package Mang;
import java.util.Scanner;
public class assgnment3 {

	public static void main(String[] args) {
		int n;
		Scanner N = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");
		n = N.nextInt();
		int mang[]= new int[n];
		for(int i=0; i<n ;i++) {
		 int	j= i+1;
			System.out.print("nhập phần tử thứ "+j+":");
			mang[i]=N.nextInt();
		}
		System.out.println("Mảng đã nhập: ");
		for(int i=0; i<mang.length; i++) {
			System.out.print(mang[i] +" ");
		}
		//tìm min max và vị trí
		int max= mang[0];
		int min = mang[0];
		int a = 0;
		int b = 0;
		for(int i=0; i<mang.length; i++)
		{
			if(max<mang[i]) {
				max= mang[i];
				a=i;
			}
			if(min>mang[i]) {
				max= mang[i];
				b=i;
		}
	}
		System.out.println("Giá Trị Lớn nhất là " + max + " Vị Trí của số lớn nhất là : " + a);
		System.out.println("Giá Trị Nhỏ nhất là " + min + " Vị Trí của số nhỏ nhất là : " + b);
	}
}