/************************
 *CtNhapDuLieuChoMang
 *Bùi Lê Anh Vũ
 *31/05/2018
 **********************/
package javacore.main;

import java.util.Scanner;

import javacore.entity.*;

public class QuanLySinhVien {
	static int N;
	static Scanner myInput=new Scanner(System.in);
	static SinhVien[] sv;
	public static void main(String[] args) {
		
		while(true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+-------------------------+");
			System.out.println("|1.Thêm Sinh Viên         |");
			System.out.println("|2.sắp xếp                |");
			System.out.println("|3.Kết Thúc               |");
			System.out.println("+-------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			int answer = myInput.nextInt();
			if(answer==1) {
				NhapSinhVien();
				
			}
			else if(answer==2) {
				SapXepSinhVien();
				
			}
			else if(answer==3) {
				System.exit(0);
				
			}
		}
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
			
		
	}
	public static void NhapSinhVien() {
		System.out.print("Nhập Số Sinh Viên : \n");
		N = myInput.nextInt();
		sv = new SinhVien[N];
		
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
		//
		//In Danh Sách Sinh Viên
		//
		System.out.println("|--------------------------------DANH SÁCH SINH VIÊN--------------------------------------|");
		System.out.printf("\n" + "%-10s %-15s %-10s %-12s %-8s %-8s %-8s %-8s %-8s", "STT", "Họ và tên", "Tuổi",
				"Giới tính", "LP1", "LP2", "LP3", "TB", "XLoại");
		for(int i=0;i<N;i++) {
			System.out.printf("\n"+(i+1)+sv[i].toString()+"\n");
			
		}
		System.out.println("\n");
	}
	public static void SapXepSinhVien() {
		//Vòng Lặp for sắp xếp điểm trung bình
		for(int i=0; i< N-1;i++) {
			for(int j=i+1;j<N-1;j++) {
				if(sv[j].tinhDiemTrungBinhMon()>sv[i].tinhDiemTrungBinhMon()) {
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
		 System.out.printf("\n" + "%-10s %-15s %-8s %-8s", "STT", "Họ và tên", "TB", "XLoại");
		for(int i=0;i<N;i++) {
			System.out.print( "\n"+(i+1) +"\t   "+sv[i].getSinhVien() +" \t   " +sv[i].tinhDiemTrungBinhMon()+ "\t   "+sv[i].xepLoai()+"\n");
			
		}
		System.out.println("+----------------------------------------------+");
		System.out.println("+----------------------------------------------+");
		System.out.println("+----------------------------------------------+");
	}
	

}
