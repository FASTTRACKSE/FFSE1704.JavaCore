package javacore.main;

import java.util.Scanner;

import javacore.entity.*;


public class QuanLySinhVien {



	public static void main(String[] args) {
		menu();
		
		int n;
		SinhVien sapxep;
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("Nhập Số Sinh Viên Vào Mảng: ");
		
		n = myInput.nextInt();
		
		SinhVien[] sv = new SinhVien[n];
		for (int i=0;  i<n; i++) {
			
	  
		System.out.print("\nNhập Tên Sinh Viên: ");
		myInput.nextLine();
		String tenSinhVien = myInput.nextLine();
		
		
		
		System.out.print("Nhập Giới Tính Sinh Viên: ");
	    String gioiTinh = myInput.nextLine();
		
	    
		System.out.print("Nhập Năm Sinh Sinh Viên: ");
	    int namSinh = myInput.nextInt();
		
	
		System.out.print("Nhập điểm LP1 : ");
	    int diemLP1 = myInput.nextInt();
		
	  
		System.out.print("Nhập điểm LP2 : ");
	    int diemLP2 = myInput.nextInt();
		
		System.out.print("Nhập điểm LP3 : ");
	    int diemLP3 = myInput.nextInt();
	 
	  
		sv[i] = new SinhVien(tenSinhVien, namSinh, gioiTinh, diemLP1, diemLP2, diemLP3);
	 
		
	   
		}
		System.out.println("\nDanh Sách Sinh Viên: ");
		for (int i=0; i<sv.length; i++) {
			
			System.out.println((i+1) + " : " + sv[i].toString() + "Tuổi: " + sv[i].tinhTuoi() + " - " + " điểm LP1: " + sv[i].getdiemLP1() + " - " + " điểm LP2: " + sv[i].getdiemLP2() + " - " + " điểm LP3: " + sv[i].getdiemLP3() + " - "
			+ " điểm Trung Bình Môn : " + sv[i].tinhDiemTrungBinhMon() + " - " + " Xếp Loại: " + sv[i].ketQuaXepLoai());
		}
		
	

	    for (int i = 0; i < n - 1; i++) {
	        for (int j = n - 1; j >= 1; j--) {
                    // A                                          B
	            if (sv[j].tinhDiemTrungBinhMon() < sv[j - 1].tinhDiemTrungBinhMon()) {
	                
	            	// C       A
	            	sapxep = sv[j];
	                // A        B
	            	sv[j] = sv[j-1];
	                // B        C
	            	sv[j-1] = sapxep;
	            }
	        }
	    }
	         
	    System.out.println("\nSắp xếp điểm trung bình từ thấp đến cao : \n");
	    for (int i = 0; i < n; i++) {
	        System.out.print((i+1) + " " + " Sinh Viên: " +  sv[i].gettenSinhVien() + " " + sv[i].tinhDiemTrungBinhMon() + "  " + "\t" );
	    }
	}

	private static void menu() {
		// TODO Auto-generated method stub
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*********		
		
		// Nh?p th�ng tin Sinh Vi�n qua m?t h�m d?ng s?n.
		SinhVien sv1 = new SinhVien ("Ph?m Ng?c Th�nh", 1997, " Nam ", 9, 9, 8);

	
		// Nh?p Th�ng tin Sinh Vi�n qua phuong th?c " Set ".
		SinhVien sv2 = new SinhVien ();
		sv2.setdiemLP1(10);
		sv2.settenSinhVien("Ph?m Ng?c Th�nh 2");
		sv2.setdiemLP2(8);
		sv2.setdiemLP3(3);
		sv2.setnamSinh(1998);
		sv2.setgioiTinh(" Nam ");
	
		
	
		
		System.out.print(sv1.toString());
		System.out.println(sv1.tinhDiemTrungBinhMon());
		
		// In Th�ng Tin Sinh Vi�n 2 ( PT " Set " ) 
		System.out.print(sv2.toString() + "�TB : " + sv2.tinhDiemTrungBinhMon());
		*/
	

}

