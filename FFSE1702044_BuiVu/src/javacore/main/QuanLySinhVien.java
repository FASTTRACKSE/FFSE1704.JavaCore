/************************
 *CtNhapDuLieuChoMang
 *Bùi Lê Anh Vũ
 *31/05/2018
 **********************/
package javacore.main;

import java.util.Scanner;

import javacore.entity.*;

public class QuanLySinhVien {

	public static void main(String[] args) {
		Scanner myInput = new Scanner (System.in);

		/*int N;	
		
				System.out.print("Nhập Số Sinh Viên : \n");
		N = myInput.nextInt();
		SinhVien[] dsSinhVien = new SinhVien[N];
		for(int i=0;i<N;i++) {
			System.out.print("Nhap ten sinh vien: ");
			String ten = myInput.nextLine();
			System.out.print("Nhap nam sinh sinh vien: ");
			int namSinh = myInput.nextInt();
			dsSinhVien = SinhVien(ten, namSinh);
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
		//sv1.Output();*/
		//Khai Báo
		int N;	
		
		System.out.print("Nhập Số Sinh Viên : \n");
		N = myInput.nextInt();
		SinhVien[] sv = new SinhVien[N];
		//Nhập Thông Tin
		for(int i=0;i<N;i++) {
		System.out.print("Nhập Tên sinh viên: ");
		myInput.nextLine();
		String tenSinhVien = myInput.nextLine();
		System.out.print("Nhập Giới Tính Sinh vien (chọn 1 Nam;chọn 2 Nữ) ");
		int gioiTinh = myInput.nextInt();
		System.out.print("Nhập năm sinh sinh viên: ");
		int namSinh = myInput.nextInt();
		System.out.print("Nhập Điểm LP1 sinh viên: ");
		int diemLP1 = myInput.nextInt();
		System.out.print("Nhập Điểm LP2 sinh viên: ");
		int diemLP2 = myInput.nextInt();
		System.out.print("Nhập Điểm LP3 sinh viên: ");
		int diemLP3 = myInput.nextInt();
		sv[i]= new SinhVien(tenSinhVien,gioiTinh, namSinh, diemLP1, diemLP2, diemLP3);
		}
		// Kết Thúc Nhập.
		//
		//in Danh Sách Sinh Viên
		System.out.println("+*********************************************************+");
		System.out.println("|---------------------DANH SÁCH SINH VIÊN-----------------|");
		System.out.println("|---------------------------------------------------------|");
		for(int i=0;i<N;i++) {
			System.out.println("|--Sinh Viên Thứ :"+(i+1)+" " +sv[i].toString()+ " Điểm Trung Bình "+Math.round(sv[i].tinhDiemTrungBinhMon())+" ---------------|");
			
	}
		System.out.println("|---------------------------------------------------------|");
		System.out.println("+*********************************************************+");
		//Vòng Lặp for sắp xếp điểm trung bình
		for(int i=0; i< N-1;i++) {
        	for(int j=i+1;j<N-1;j++) {
        		if(sv[j].tinhDiemTrungBinhMon()<sv[i].tinhDiemTrungBinhMon()) {
        			SinhVien temp = sv[i];
        			sv[i]=sv[j];
        			sv[j]=temp;
        		}
        	}
        }
        //Kết thúc vòng lặp
		//
		// In thông tin sinh viên đã sắp xếp 
		
		 System.out.println("+----------------------------------------------+");
		 System.out.println("+------Danh Sách Sinh Viên Đã Sắp Xếp----------+");
		 System.out.println("+----------------------------------------------+");
        for(int i=0;i<N;i++) {
        	System.out.print( "+------Sinh Viên"+(i+1) +" : "+sv[i].getSinhVien() +" --" +sv[i].tinhDiemTrungBinhMon()+ " Điểm-- "+sv[i].xepLoai()+"---+\n");
        	
        }
        System.out.println("+----------------------------------------------+");
        System.out.println("+----------------------------------------------+");
        System.out.println("+----------------------------------------------+");
        //Kết thúc chương Trình
        System.exit(0);
	}
	

}
