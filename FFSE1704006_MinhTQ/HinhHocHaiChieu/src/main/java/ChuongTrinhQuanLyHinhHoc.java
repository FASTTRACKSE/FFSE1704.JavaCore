package main.java;

import java.util.ArrayList;
import java.util.Scanner;

import ffse.hinh2d.entity.*;


public class ChuongTrinhQuanLyHinhHoc {
	static int n;
	static ArrayList<HinhChuNhat> dsHinhChuNhat = new ArrayList<HinhChuNhat>();
	static Scanner nhap = new Scanner(System.in);

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		int myOption = 0;

		while (myOption != 5) {
			try {
				System.out.println("\nHệ thống quản lý Tiền Điện");
				System.out.println("---------------------------------------");
				System.out.println("1. tính hình chữ nhật ");
				System.out.println("2. tính hình vuông ");
				System.out.println("3. tính hình tam giác");
				System.out.println("4. in thông tin");
				System.out.println("5. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = nhap.nextInt();
				if (myOption == 1) {
					tinhhinhchunhat();
				} else if (myOption == 2) {
					// Sort student list by Name
					tinhhinhvuong();
				} else if (myOption == 3) {
					// Sort student list by Name
					tinhhinhtamgiac();
				} else if (myOption == 4) {
					// Sort student list by Name
					inthongtin();
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

	public static void tinhhinhchunhat() {

		System.out.println("mời nhập số lượng hình ");
		n = nhap.nextInt();
		HinhChuNhat o = new HinhChuNhat();
		for (int i = 0; i < n; i++) {
		 System.out.println("hình thứ "+(i+1));
		 nhap.nextLine();
		
		System.out.print("nhập chiều dài");
		 int chieuDai = nhap.nextInt();
		System.out.print("nhập chiều dài");
		 int chieuRong= nhap.nextInt();
		 dsHinhChuNhat.add(o)
		 }
		 int i = 0;
		 String msg = "";
		 for (HinhChuNhat o : dsHinhhoc) {
		 if (o instanceof HinhChuNhat) {
	 msg = "Hình chữ nhật(" + ((HinhChuNhat) o).getChieuDai() + ", " +
		((HinhChuNhat) o).getChieuRong()
		 + ")";
	}System.out.println("Hình Chữ nhật Thứ "+(++i)+": Chu vi: "+o.tinhChuVi()+" - Diện Tích: "+o.tinhDienTich());

	}

	public static void tinhhinhvuong() {

	}

	public static void tinhhinhtamgiac() {

	}

	public static void inthongtin() {

	}

	public static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

}
