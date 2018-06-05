package assignment4;

import java.util.Scanner;


public class SinhVien{

	public static void main(String[] args) {
		Scanner myInput = new Scanner (System.in);

		int N;	
		
		System.out.print("Nhập Số Sinh Viên : \n");
		N = myInput.nextInt();
		QuanLySinhVien[] sv = new QuanLySinhVien[N];
		//Nhập Thông Tin
		
		for(int i=0;i<N;i++) {
		System.out.print("Nhập Tên sinh viên: ");
		myInput.nextLine();
		String tenSinhVien = myInput.nextLine();
		System.out.print("Nhập Giới Tính Sinh vien  ");
		String gioiTinh = myInput.nextLine();
		System.out.print("Nhập năm sinh sinh viên: ");
		int namSinh = myInput.nextInt();
		System.out.print("Nhập Điểm LP1 sinh viên: ");
		int diemLP1 = myInput.nextInt();
		System.out.print("Nhập Điểm LP2 sinh viên: ");
		int diemLP2 = myInput.nextInt();
		System.out.print("Nhập Điểm LP3 sinh viên: ");
		int diemLP3 = myInput.nextInt();
		sv[i]= new QuanLySinhVien(tenSinhVien,gioiTinh, namSinh, diemLP1, diemLP2, diemLP3);
		}
		
		
		System.out.println("*********************************");
		System.out.println("       Danh sách Sinh Viên        ");
		System.out.println("*********************************");

		for(int i=0;i<N;i++) {
			System.out.println("|--Sinh Viên Thứ :"+(i+1)+" " +sv[i].toString()+ sv[i].tinhTuoi() +" Điểm Trung Bình "+Math.round(sv[i].tinhDiemTrungBinhMon())+" ---------------|");
			
	}
		
		//Vòng Lặp for sắp xếp điểm trung bình
		for(int i=0; i< N-1;i++) {
        	for(int j=i+1;j<N-1;j++) {
        		if(sv[j].tinhDiemTrungBinhMon()<sv[i].tinhDiemTrungBinhMon()) {
        			QuanLySinhVien temp = sv[i];
        			sv[i]=sv[j];
        			sv[j]=temp;
        		}
        	}
        }
    
		
        for(int i=0;i<N;i++) {
        	

        	System.out.print( "+------Sinh Viên"+(i+1) +" : "+sv[i].getSinhVien() +" --" +sv[i].tinhDiemTrungBinhMon()+ " Điểm-- "+sv[i].xepLoai()+"---+\n");
        	
        }
     
        System.exit(0);
	}
	

}