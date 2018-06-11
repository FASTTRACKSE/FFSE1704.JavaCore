package main;

import java.util.Scanner;
import sinhvien.quanlysinhvien;


public class DanhSachSinhVien {
	
	static int n, quanlysinhvien[], i;

	public static void main(String[] args) {
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.println("nhập số sinh vien : ");
		n = nhap.nextInt();
		quanlysinhvien[] quanlysinhvien = new quanlysinhvien[n];
		for (int i=0;i<n;i++) {
			
			System.out.print("Nhập tên sinh viên: ");
			nhap.nextLine();
			String tenSinhVien = nhap.nextLine();
			
			System.out.println("nhập giới tính sinh vien");
			nhap.nextLine();
			String gioitinh = nhap.nextLine();
			
			System.out.println("nhập năm sinh sinh vien");
			int namsinh = nhap.nextInt();
			
			System.out.println("nhập điểm lp1");
			int diemlp1 = nhap.nextInt();
			
			System.out.println("nhập điểm lp2");
			int diemlp2 = nhap.nextInt();
			
			System.out.println("nhập điểm lp3");
			int diemlp3 = nhap.nextInt();
			
			System.out.println();
			quanlysinhvien[i] = new quanlysinhvien(tenSinhVien,gioitinh,namsinh,diemlp1,diemlp2,diemlp3);
			quanlysinhvien[i].diemtrungbinh();
		}
		
		// if (quanlysinhvine[i].diemtrungbinh()<=7){
		//
		// System.out.prin("yếu");
		
		// } else if (quanlysinhvien[i].diemtrungbinh() <= 7) {
		//
		// System.out.println("Trung Bình");
		
		// } else if (quanlysinhvien[i].diemtrungbinh() <= 8.5) {
		//
		// System.out.println("khá");
		
		// } else {
		//
		// System.out.println("Giỏi");
		// }
		
		// in danh sách ban đầu
		
		System.out.println(" ");
		System.out.println("danh sách sinh viên");
		
		for(int i=0;i<quanlysinhvien.length;i++) {
			for(int j = i + 1; j <= quanlysinhvien.length - 1; j++) {
					if (quanlysinhvien[j].diemtrungbinh() > quanlysinhvien[i].diemtrungbinh()) {
						quanlysinhvien tang = quanlysinhvien[i];
						quanlysinhvien[i] = quanlysinhvien[j];
						quanlysinhvien[j] = tang;
					}
				}
			}
		
		// in ra thứ tự tăng 
		
		System.out.println(" ");
		System.out.println("danh sách sinh viên đã sắp xếp");
		
		for(int i=0;i< quanlysinhvien.length;i++) {
				System.out.println("xếp hạng thứ " + (i + 1) + ": " + quanlysinhvien[i].getquanlysinhvien() + " " 
						+ quanlysinhvien[i].diemtrungbinh() + "điểm  " + "xếp loại:" + quanlysinhvien[i].xeploai());
			}
		System.exit(0);
		}
	}


