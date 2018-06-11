package QuanLySv;
import java.util.Scanner;

import Entity.SinhVien;
public class main {
	static int N ,sinhvien[], i;

public static void main(String[] args) {
	Scanner nhap = new Scanner(System.in);
	System.out.print("Nhập số sinh viên : ");
	N = nhap.nextInt();
	SinhVien[] sinhvien =new SinhVien[N];
	for(int i=0;i<sinhvien.length;i++) {
		System.out.print("Nhập Tên SInh VIên viên"+(i+1)+":");
		nhap.nextLine();
		String TenSV = nhap.nextLine();
		System.out.print("Nhập giới tính sinh viên:");
		String GioiTinh = nhap.nextLine();
		
		System.out.print("Nhập Năm sinh sinh viên:");
		int namSinh = nhap.nextInt();
		
		System.out.print("Nhập điểm LP1 sinh viên:");
		int diemLP1 = nhap.nextInt();
		
		System.out.print("Nhập điểm LP2 sinh viên:");
		int diemLP2 = nhap.nextInt();
		
		System.out.print("Nhập điểm LP3 sinh viên:");
		int diemLP3 = nhap.nextInt();
		sinhvien[i] =new SinhVien(TenSV, GioiTinh, namSinh, diemLP1, diemLP2, diemLP3);
		sinhvien[i].tinhDiemTrungBinhMon();
	}
	System.out.println(" ");
	System.out.println("******************** DANH SÁCH SINH VIÊN ************************");
	for(i=0;i<sinhvien.length;i++) {
		System.out.println("Sinh viên thứ "+(i+1)+":"+sinhvien[i].Hienthi()+"Điểm trung bình:"+sinhvien[i].tinhDiemTrungBinhMon()+"xếp loại:"+sinhvien[i].xepLoai());
		}
	//sắp xếp
	for(int i=0;i<sinhvien.length-1;i++) {
		SinhVien tang=sinhvien[i];
		for(int j=i+1;j<=sinhvien.length-1;j++) {
			if(tang.tinhDiemTrungBinhMon()<sinhvien[j].tinhDiemTrungBinhMon()) {
				sinhvien[i]=sinhvien[j];
				sinhvien[j]=tang;
				tang = sinhvien[i];
			}
			
		}
	}
	
	
//	for (int i = 0; i < sinhvien.length - 1; i++) {
//		for (int j = i + 1; j <= sinhvien.length - 1; j++) {
//			if (sinhvien[j].tinhDiemTrungBinhMon() > sinhvien[i].tinhDiemTrungBinhMon()) {
//				SinhVien tang = sinhvien[i];
//				sinhvien[i] = sinhvien[j];
//				sinhvien[j] = tang;
//			}
//		}
//	}
	//in theo thứ tự tăng dần
	System.out.println(" ");
	System.out.println("***************Danh Sách Sinh Viên Đã Sắp Xếp******************");
	for(i=0;i<sinhvien.length;i++) {
		System.out.println("Xếp hạng thứ " + (i + 1) + ": " + sinhvien[i].Hienthi() + " ***** "
				+ sinhvien[i].tinhDiemTrungBinhMon() + " điểm ***** "+"Xếp loại: "+sinhvien[i].xepLoai());
	}
		
	}
}

