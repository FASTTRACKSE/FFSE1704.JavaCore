package Assgnment5.src.main;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Assgnment5.src.entity.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {

	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
}
	public static void menu() {
		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println("\nHệ thống quản lý Tiền Điện");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập danh sách Khách Hàng");
				System.out.println("2. Nhập thông tin Biên Lai");
				System.out.println("3. In báo cáo tiêu thụ điện");
				System.out.println("4. Xoá 1 khách hàng");
				System.out.println("5. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {
					// Generate data
					creatDaTaKH();
				} else if (myOption == 2) {
					// Sort student list by Name
					creaDaTaBienLai();
				} else if (myOption == 3) {
					// Sort student list by Name
					printReport("Thống kê tình hình tiêu thụ điện");
				} else if (myOption == 4) {
					xoaKH(1);
					// Sort student list by Name
					printReport("Thống kê tình hình tiêu thụ điện");
				} else if (myOption == 5) {
					// Hiển thị thông báo kết thúc
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 5, nhập lại nhé bạn hiền!");
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}
	public static void creatDaTaKH(){
		dsKH = new ArrayList<KhachHang>();
		dsKH.add(new KhachHang("SV001", "Nguyễn Văn Sỹ", "Sơn Trà,Đà Nẵng"));
		dsKH.add(new KhachHang("SV002", "Ngô Thế Toàn", "Hải CHâu,Đà Nẵng"));
		dsKH.add(new KhachHang("SV003", "Cao Ngọc Khánh", "Liên CHiểu,Đà Nẵng"));
		dsKH.add(new KhachHang("SV004", "Trần Xuân kì", "Thanh Khê,Đà Nẵng"));
		dsKH.add(new KhachHang("SV005", "Hứa Văn Lều", "Sơn Trà,Đà Nẵng"));
		
	}
	
	public static void creaDaTaBienLai(){
		//biên lai kh 1
		ArrayList<BienLai> blKH1 = new  ArrayList<BienLai>();
		blKH1.add(new BienLai("CK1",1,2018,0,100));
		blKH1.add(new BienLai("CK1",2,2018,110,140));
		blKH1.add(new BienLai("CK1",3,2018,140,190));
		blKH1.add(new BienLai("CK1",4,2018,190,210));
		dsKH.get(0).setDsBienLai(blKH1);
		dsKH.get(0).addtodsBienLai(new BienLai("Ck1", 5, 2018, 200, 250));
		
		// Biên lai khách hàng 2
		ArrayList<BienLai> blKH2 = new  ArrayList<BienLai>();
		blKH2.add(new BienLai("CK2",3,2018,0,170));
		blKH2.add(new BienLai("CK2",4,2018,170,270));
		dsKH.get(1).setDsBienLai(blKH2);
		
		// Biên lai khách hàng 3
				ArrayList<BienLai> blKH3 = new  ArrayList<BienLai>();
				blKH3.add(new BienLai("CK3",4,2018,0,120));
				blKH3.add(new BienLai("CK3",5,2018,120,170));
				dsKH.get(2).setDsBienLai(blKH3);
				
				// Biên lai khách hàng 4
				dsKH.get(3).addtodsBienLai(new BienLai("Ck4", 6, 2018, 138, 160));
				// Biên lai khách hàng 4
				dsKH.get(4).addtodsBienLai(new BienLai("Ck5", 7, 2018, 150, 160));
	
	}
	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}
	public static void xoaKH(int i) {
		if(!dsKH.isEmpty()) {
			dsKH.remove(i);
		}
	}
	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}
	public static void printReport(String title) {
		System.out.println("\n"+title);
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		 
        Collections.sort(dsKH, new Comparator<KhachHang>() {
        
            public int compare(KhachHang sv1, KhachHang sv2) {
                return (sv1.tenKH.compareTo(sv2.tenKH));
               
            }
        });
		for(KhachHang x :dsKH) {
			System.out.println(x.getMaKH()+":"+x.getTenKH()+"\t");
			for(BienLai o: x.getDsBienLai()) {
				System.out.println("\t\t\t" + o.getMaCongTo() + " - " + o.getChuKyNam() + "/" + o.getChuKyThang() + " - "
						+ o.getCsDauKy() + "\t:\t" + o.getCsCuoiKy() + "\t->\t" + o.tinhTongTien());
			}
		}
		System.out.println(
		
				"--------------------------------------------------------------------------------------------");
		
	}
	
	}

