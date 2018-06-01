package javacore.main;

import java.util.Scanner;

import javacore.entity.*;


public class QuanLySinhVien {



	public static void main(String[] args) {
		
		
		int n;
		SinhVien sapxep;
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("Nh?p S? Sinh Viên Vào M?ng: ");
		
		n = myInput.nextInt();
		
		SinhVien[] sv = new SinhVien[n];
		for (int i=0;  i<n; i++) {
			
	  
		System.out.print("\nNh?p Tên Sinh Viên: ");
		myInput.nextLine();
		String tenSinhVien = myInput.nextLine();
		
		
		
		System.out.print("Nh?p Gi?i Tính Sinh Viên: ");
	    String gioiTinh = myInput.nextLine();
		
	    
		System.out.print("Nh?p Nam Sinh Sinh Viên: ");
	    int namSinh = myInput.nextInt();
		
	
		System.out.print("Nh?p Ði?m LP1 : ");
	    int diemLP1 = myInput.nextInt();
		
	  
		System.out.print("Nh?p Ði?m LP2 : ");
	    int diemLP2 = myInput.nextInt();
		
		System.out.print("Nh?p Ði?m LP3 : ");
	    int diemLP3 = myInput.nextInt();
	 
	  
		sv[i] = new SinhVien(tenSinhVien, namSinh, gioiTinh, diemLP1, diemLP2, diemLP3);
	    sv[i].tinhDiemTrungBinhMon();
	    
	    sv[i].tinhTuoi();
		}
		System.out.println("\nDanh Sách Sinh Viên: ");
		for (int i=0; i<n; i++) {
			
			System.out.println((i+1) + " : " + sv[i].toString() + "Tu?i: " + sv[i].tinhTuoi() + " Ði?m LP1: " + sv[i].diemLP1 + " - " + " Ði?m LP2: " + sv[i].diemLP2 + " - " + " Ði?m LP3: " + sv[i].diemLP3 + " - "
			+ " Ði?m Trung Bình Môn : " + sv[i].tinhDiemTrungBinhMon() + " " + " X?p Lo?i: " );
		}
		
	

	    for (int i = 0; i < n - 1; i++) {
	        for (int j = n - 1; j >= 1; j--) {

	            if (sv[j].tinhDiemTrungBinhMon() < sv[j - 1].tinhDiemTrungBinhMon()) {
	                sapxep = sv[j];
	                sv[j] = sv[j-1];
	                sv[j-1] = sapxep;
	            }
	        }
	    }
	         
	    System.out.println("\nS?p X?p Ði?m Trung Bình T? Th?p Ð?n Cao : \n");
	    for (int i = 0; i < n; i++) {
	        System.out.print((i+1) + " " + " Sinh Viên: " +  sv[i].gettenSinhVien() + " " + sv[i].tinhDiemTrungBinhMon() + "  " + "\t" );
	    }
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*********		
		
		// Nh?p thông tin Sinh Viên qua m?t hàm d?ng s?n.
		SinhVien sv1 = new SinhVien ("Ph?m Ng?c Thành", 1997, " Nam ", 9, 9, 8);

	
		// Nh?p Thông tin Sinh Viên qua phuong th?c " Set ".
		SinhVien sv2 = new SinhVien ();
		sv2.setdiemLP1(10);
		sv2.settenSinhVien("Ph?m Ng?c Thành 2");
		sv2.setdiemLP2(8);
		sv2.setdiemLP3(3);
		sv2.setnamSinh(1998);
		sv2.setgioiTinh(" Nam ");
	
		
	
		
		System.out.print(sv1.toString());
		System.out.println(sv1.tinhDiemTrungBinhMon());
		
		// In Thông Tin Sinh Viên 2 ( PT " Set " ) 
		System.out.print(sv2.toString() + "ÐTB : " + sv2.tinhDiemTrungBinhMon());
		*/
	

}

