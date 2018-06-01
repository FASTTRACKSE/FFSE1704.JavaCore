package ffse.khoa.bai8;

import java.util.Scanner;

import ffse.khoa.bai7.Sinhvien;

public class Quanlysinhvien {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập Số Sinh Viên : \n");
		N = myInput.nextInt();
		Sinhvien[] sv = new Sinhvien[N];
		for(int i=0;i<N;i++) {
			System.out.print("Nhập Tên sinh viên: ");
			myInput.nextLine();
			String tenSinhVien = myInput.nextLine();
			System.out.print("Nhập năm sinh sinh viên: ");
			int namSinh = myInput.nextInt();
			System.out.print("Nhập Giới Tính : ");
			myInput.nextLine();
			String gioiTinh = myInput.nextLine();
			System.out.print("Nhập Điểm LP1 sinh viên: ");
			int diemLP1 = myInput.nextInt();
			System.out.print("Nhập Điểm LP2 sinh viên: ");
			int diemLP2 = myInput.nextInt();
			System.out.print("Nhập Điểm LP3 sinh viên: ");
			int diemLP3 = myInput.nextInt();
			sv[i]= new Sinhvien(tenSinhVien, namSinh, gioiTinh, diemLP1, diemLP2, diemLP3);
			
		}
		System.out.println("+**************************************************************************+");
		System.out.println("|---------------------DANH SÁCH SINH VIÊN----------------------------------|");
		System.out.println("|--------------------------------------------------------------------------|");
		for(int i=0;i<N;i++) {
			System.out.println("|--Sinh Viên Thứ "+(i+1)+" : " +sv[i].toString()+ " - Giới Tính :  " + sv[i].getGioiTinh() +  " -  Điểm Trung Bình "+sv[i].tinhDiemTrungBinhMon()+"--|");
			
	}
		System.out.println("|--------------------------------------------------------------------------|");
		
		for(int i=0; i< N-1;i++) {
        	for(int j=i+1;j<=N-1;j++) {
        		if(sv[j].tinhDiemTrungBinhMon()<sv[i].tinhDiemTrungBinhMon()) {
        			Sinhvien temp = sv[i];
        			sv[i] = sv[j];
        			sv[j]=temp;
        		}
        	}
        }
		System.out.println("|---------------------DANH SÁCH XẾP LOẠI SINH VIÊN TỪ YẾU ĐẾN GIỎI------------------------|");
		for(int i=0;i<N;i++) {
        	System.out.print( "+------Sinh Viên Tên : " + sv[i].getTenSinhVien() +" " + " - Điểm Trung Bình : " +sv[i].tinhDiemTrungBinhMon() + " - Xếp Loại : "+sv[i].xepLoai()+"-------+\n");
        	
        }
		
	}

}
