package javacore.main;

import java.util.Scanner;

import javacore.entity.SinhVien;

public class QuanLySinhVien {

	public static void main(String[] args) {
		int N;	
		
		Scanner myInput = new Scanner (System.in);
		System.out.print("Nhập Số Sinh Viên : \n");
		N = myInput.nextInt();
		SinhVien[] dsSinhVien = new SinhVien[N];
		for(int i=0;i<N;i++) {
			
			dsSinhVien[i]= new SinhVien();
			dsSinhVien[i].Input();
			dsSinhVien[i].DiemTrungBinh();
		}
		// dừng chp phép nhập
		myInput.close();
		
		System.out.println(" *---Danh Sách Sinh Viên---* ");
		for(int i=0;i<N;i++) {
			System.out.print("\nThông Tin Sinh Viên thứ "+ (i+1) + "\n");
			dsSinhVien[i].Output();
		}
		
		
		//sv1 = new SinhVien();
		//sv1.Input();
		//sv1.Output();
	}

}
