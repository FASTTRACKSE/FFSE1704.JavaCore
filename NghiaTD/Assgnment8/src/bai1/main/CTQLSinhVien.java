package bai1.main;
import bai1.entity.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CTQLSinhVien {
	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+-------------------------------------------+");
			System.out.println("|1.Nhập danh sách sinh viên                 |");
			System.out.println("|2.Xuất thông tin danh sách sinh viên       |");
			System.out.println("|3.Xuất danh sách sinh viên có học lực giỏi |");
			System.out.println("|4.Sắp xếp danh sách sinh viên theo điểm    |");
			System.out.println("|5.Xóa 1 Sinh Viên                          |");
			System.out.println("|6.Kết Thúc                                 |");
			System.out.println("+-------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			
			N = myInput.nextInt();
			if (N == 1) {
				NhapDanhsachSV();
			} else if (N == 2) {
				XuatTTSinhVien();
			} else if (N == 3) {
				XuatDsNgauNhien();
			} else if (N == 4) {
				SapXepGiamDan();
			} else if (N == 5) {
				XoaHoTen();
			} else if (N == 6) {
				TimHoTen();
			}/*else if (N == 6) {
				XoaBienLaiKH();
			}*/ else {
				System.exit(0);
			}
		}
	}
		public static void NhapDanhsachSV() {
			System.out.println("Nhập số lượng sinh viên");
			int X =myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Nhập sinh viên thứ "+(i+1)+" ");
				System.out.println("Nhập họ sinh viên");
				myInput.nextLine();
				String hoSV = myInput.nextLine();
				
				System.out.println("Nhập tên sinh viên");
				String tenSV = myInput.nextLine();
				dsSinhVien.addnew(SinhVien(hoSV,tenSV));
				
			}
		}
		public static void XuatTTSinhVien() {
		
		}
		public static void XuatDsNgauNhien() {
		
		}
		public static void SapXepGiamDan() {
			
		}
		public static void TimHoTen() {
			
		}	
		public static void XoaHoTen() {
			
		}	
	


}
