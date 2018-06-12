package javacore.main;

import java.util.Scanner;

import javacore.entity.*;


public class QuanLySinhVien {



	public static void main(String[] args) {
		menu();
		
		int n;
		SinhVien sapxep;
		
		Scanner myInput = new Scanner(System.in);
<<<<<<< HEAD
		System.out.println("Nhập Số Sinh Viên Vào Mảng: ");
=======
		System.out.println("Nh?p S? Sinh Viên Vào M?ng: ");
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
		
		n = myInput.nextInt();
		
		SinhVien[] sv = new SinhVien[n];
		for (int i=0;  i<n; i++) {
			
	  
<<<<<<< HEAD
		System.out.print("\nNhập Tên Sinh Viên: ");
=======
		System.out.print("\nNh?p Tên Sinh Viên: ");
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
		myInput.nextLine();
		String tenSinhVien = myInput.nextLine();
		
		
		
<<<<<<< HEAD
		System.out.print("Nhập Giới Tính Sinh Viên: ");
	    String gioiTinh = myInput.nextLine();
		
	    
		System.out.print("Nhập Năm Sinh Sinh Viên: ");
	    int namSinh = myInput.nextInt();
		
	
		System.out.print("Nhập điểm LP1 : ");
	    int diemLP1 = myInput.nextInt();
		
	  
		System.out.print("Nhập điểm LP2 : ");
	    int diemLP2 = myInput.nextInt();
		
		System.out.print("Nhập điểm LP3 : ");
=======
		System.out.print("Nh?p Gi?i Tính Sinh Viên: ");
	    String gioiTinh = myInput.nextLine();
		
	    
		System.out.print("Nh?p Nam Sinh Sinh Viên: ");
	    int namSinh = myInput.nextInt();
		
	
		System.out.print("Nh?p Ði?m LP1 : ");
	    int diemLP1 = myInput.nextInt();
		
	  
		System.out.print("Nh?p Ði?m LP2 : ");
	    int diemLP2 = myInput.nextInt();
		
		System.out.print("Nh?p Ði?m LP3 : ");
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
	    int diemLP3 = myInput.nextInt();
	 
	  
		sv[i] = new SinhVien(tenSinhVien, namSinh, gioiTinh, diemLP1, diemLP2, diemLP3);
<<<<<<< HEAD
	 
		
	   
		}
		System.out.println("\nDanh Sách Sinh Viên: ");
		for (int i=0; i<sv.length; i++) {
			
			System.out.println((i+1) + " : " + sv[i].toString() + "Tuổi: " + sv[i].tinhTuoi() + " - " + " điểm LP1: " + sv[i].getdiemLP1() + " - " + " điểm LP2: " + sv[i].getdiemLP2() + " - " + " điểm LP3: " + sv[i].getdiemLP3() + " - "
			+ " điểm Trung Bình Môn : " + sv[i].tinhDiemTrungBinhMon() + " - " + " Xếp Loại: " + sv[i].ketQuaXepLoai());
=======
	    
		}
		System.out.println("\nDanh Sách Sinh Viên: ");
		for (int i=0; i<n; i++) {
			
			System.out.println((i+1) + " : " + sv[i].toString() + "Tu?i: " + sv[i].tinhTuoi() + " Ði?m LP1: " + sv[i].diemLP1 + " - " + " Ði?m LP2: " + sv[i].diemLP2 + " - " + " Ði?m LP3: " + sv[i].diemLP3 + " - "
			+ " Ði?m Trung Bình Môn : " + sv[i].tinhDiemTrungBinhMon() + " " + " X?p Lo?i: " );
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
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
	         
<<<<<<< HEAD
	    System.out.println("\nSắp xếp điểm trung bình từ thấp đến cao : \n");
=======
	    System.out.println("\nS?p X?p Ði?m Trung Bình T? Th?p Ð?n Cao : \n");
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
	    for (int i = 0; i < n; i++) {
	        System.out.print((i+1) + " " + " Sinh Viên: " +  sv[i].gettenSinhVien() + " " + sv[i].tinhDiemTrungBinhMon() + "  " + "\t" );
	    }
	}

	private static void menu() {
		// TODO Auto-generated method stub
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*********		
		
<<<<<<< HEAD
		// Nh?p th�ng tin Sinh Vi�n qua m?t h�m d?ng s?n.
		SinhVien sv1 = new SinhVien ("Ph?m Ng?c Th�nh", 1997, " Nam ", 9, 9, 8);

	
		// Nh?p Th�ng tin Sinh Vi�n qua phuong th?c " Set ".
		SinhVien sv2 = new SinhVien ();
		sv2.setdiemLP1(10);
		sv2.settenSinhVien("Ph?m Ng?c Th�nh 2");
=======
		// Nh?p thông tin Sinh Viên qua m?t hàm d?ng s?n.
		SinhVien sv1 = new SinhVien ("Ph?m Ng?c Thành", 1997, " Nam ", 9, 9, 8);

	
		// Nh?p Thông tin Sinh Viên qua phuong th?c " Set ".
		SinhVien sv2 = new SinhVien ();
		sv2.setdiemLP1(10);
		sv2.settenSinhVien("Ph?m Ng?c Thành 2");
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
		sv2.setdiemLP2(8);
		sv2.setdiemLP3(3);
		sv2.setnamSinh(1998);
		sv2.setgioiTinh(" Nam ");
	
		
	
		
		System.out.print(sv1.toString());
		System.out.println(sv1.tinhDiemTrungBinhMon());
		
<<<<<<< HEAD
		// In Th�ng Tin Sinh Vi�n 2 ( PT " Set " ) 
		System.out.print(sv2.toString() + "�TB : " + sv2.tinhDiemTrungBinhMon());
=======
		// In Thông Tin Sinh Viên 2 ( PT " Set " ) 
		System.out.print(sv2.toString() + "ÐTB : " + sv2.tinhDiemTrungBinhMon());
>>>>>>> 7c2a04f7cd266cc0d97b2810bd2c0cf77881d484
		*/
	

}

