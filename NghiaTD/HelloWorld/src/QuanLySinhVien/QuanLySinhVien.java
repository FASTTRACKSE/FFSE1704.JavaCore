package QuanLySinhVien;
import java.util.Scanner;

import BangSinhVien.*;
public class QuanLySinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int N ;
			
			Scanner myInput = new Scanner(System.in);
			System.out.println("nhap Số lượng sinh viên");
			N = myInput.nextInt();
			SinhVien[] dsSinhVien = new SinhVien[N];
			for(int i=0;i<dsSinhVien.length;i++) {
				System.out.println("Nhập phần tử thứ"+ (i+1));
				dsSinhVien[i]=new SinhVien();
				dsSinhVien[i].Input();
				
				
			}
			
			for(int i=0; i<dsSinhVien.length; i++) {
				System.out.println("Danh sách sinh viên vừa nhập");
				dsSinhVien[i].Output();
			}
			
			
			
			
	}

	

}
