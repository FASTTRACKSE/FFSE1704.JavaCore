package javacore.quanlikh.main;

import java.util.Scanner;

import javacore.quanlikh.entity.*;
public class QuanLiHoaDonKhachHang {
	static int N;
	static BienLai[] bl;
	static Scanner myInput= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				while(true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập Thong Tin Khách Hàng|")
			System.out.println("|4.Kết Thúc                 |");
			System.out.println("+-------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N=myInput.nextInt();
			if(N==1) {
				 NhapThongTinKH();
			}
			else {
				System.exit(0);
			}
		}
	}
	public static void NhapThongTinKH() {
		System.out.print("Nhập Số Lượng Khách Hàng");
		N= myInput.nextInt();
		bl = new BienLai[N];
		for(int i=0; i<N;i++) {
			System.out.print("Nhập Tên Khách Hàng thứ "+ (i+1));
			myInput.nextLine();
			String tenKhachHang=myInput.nextLine();
			System.out.print("Nhập Mã Khách Hàng");
			int maKhachHang=myInput.nextInt();
			System.out.print("Nhập Địa Chỉ Khách Hàng");
			myInput.nextLine();
			String diaChiKhachHang=myInput.nextLine();
			System.out.print("Nhập Mã Công Tơ Khách Hàng");
			int maCongTo=myInput.nextInt();
			System.out.print("Nhập Chỉ Số Cũ:");
			int chiSoCu=myInput.nextInt();
			System.out.print("Nhập Chỉ Số Mới");
			int chiSoMoi=myInput.nextInt();
			bl[i]= new BienLai(tenKhachHang,maKhachHang,diaChiKhachHang,maCongTo,chiSoCu,chiSoMoi);
			
			System.out.printf("\n %-12s %-15s %-12s %-12s %-12s %-12s %-12s","MKH", "Họ tên", "Địa chỉ", "Mã CT", "C.số cũ", "C.số mới", "Tổng tiền");
			for(int i1=0;i1<N;i1++) {
				System.out.println(bl[i1].inBienLai());
			}
		}
		
	}
	public static void InHoaDon() {
		
	}

}
