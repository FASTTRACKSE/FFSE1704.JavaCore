package ffse.java.main;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;


import ffse.java.enity.*;
public class QuanLyTienDien {

	
		static int N;
		static ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
		static Scanner myInput = new Scanner(System.in);

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			while (true) {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+---------------------------+");
				System.out.println("|1.Nhập Thông Tin Khách Hàng|");
				System.out.println("|2.Nhập Biên Lai  Khách Hàng|");
				System.out.println("|3.In Hóa Đơn Tiền điện KH  |");
				System.out.println("|4.DS Tiêu Thụ Theo Chu Kỳ  |");
				System.out.println("|5.Xóa 1 Khách Hàng         |");
				System.out.println("|6.Kết Thúc                 |");
				System.out.println("+---------------------------+");
				System.out.println("Mời Bạn Chọn Chức Năng");
				N = myInput.nextInt();
				if (N == 1) {
					NhapThongTinKH();
				} else if (N == 2) {
					NhapBienLai();
				} else if (N == 3) {
					InKhachHang();
				} else if (N == 4) {
					InDsTieuThuTheoChuKy();
				} else if (N == 5) {
					XoaMotKhachHang();
				} /*
					 * else if (N == 6) { XoaBienLaiKH(); }
					 */ else {
					System.exit(0);
				}
			}
		}

		public static void NhapThongTinKH() {
			System.out.print("Nhập Số Lượng Khách Hàng");
			N = myInput.nextInt();

			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin Khách Hàng Thứ " + (i + 1) + "\n");
				myInput.nextLine();
				System.out.print("Nhập Tên Khách Hàng");
				String tenKhachHang = myInput.nextLine();
				System.out.print("Nhập Mã Khách Hàng");
				int maKhachHang = myInput.nextInt();
				System.out.print("Nhập Địa Chỉ Khách Hàng");
				myInput.nextLine();
				String diaChiKhachHang = myInput.nextLine();
				System.out.print("Nhập Mã Công Tơ Khách Hàng");
				int maCongTo = myInput.nextInt();
				dsKhachHang.add(new KhachHang(tenKhachHang, maKhachHang, diaChiKhachHang, maCongTo));
			}
		}

		public static void NhapBienLai() {
			String M = "";
			System.out.print("Nhập Biên Lai Khách Hàng thứ bao nhiêu? : ");
			myInput.nextLine();
			M = myInput.nextLine();
			for (int i = 0; i < dsKhachHang.size(); i++) {
				if (M.equals(dsKhachHang.get(i).getThongTinKhachHang())) {
					System.out.print("Nhập Thông Tin Biên Lai Khách Hàng Thứ " + (i + 1) + "\n");
					System.out.print("Nhập Chỉ Số Cũ");
					int chiSoCu = myInput.nextInt();
					System.out.print("Nhập Chỉ Số mới");
					int chiSoMoi = myInput.nextInt();
					System.out.print("Nhập Chu Kỳ Tháng:");
					int ckThang = myInput.nextInt();
					System.out.print("Nhập Chu Kỳ Năm:");
					int ckNam = myInput.nextInt();
					dsKhachHang.get(i).addToDsBienLai(new BienLai(chiSoCu, chiSoMoi, ckThang, ckNam));
				}
			}
		}

		public static void InKhachHang() {
			Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
				public int compare(KhachHang kh1, KhachHang kh2) {
					return (kh1.getThongTinKhachHang().compareTo(kh2.getThongTinKhachHang()));
					// Muốn đảo danh sách các bạn đối thành
					// return (sv2.hoTen.compareTo(sv1.hoTen));
				}
			});
			for (KhachHang x : dsKhachHang) {

				System.out.println(" Mã KH : " + x.getMaKhachHang() + " Tên KH :" + x.getThongTinKhachHang() + "\t"
						+ "CS Cũ" + "\t" + "CS Mới" + "\t" + "Tháng/Năm" + "\t" + "Tổng tiền");
				for (BienLai o : x.getDsBienLai()) {
					System.out.println("\t\t\t\t" + o.getChiSoCu() + " \t" + o.getChiSoMoi() + "\t " + o.getCkThang() + "/"
							+ o.getCkNam() + "\t\t" + o.tinhTienDien() + " VNĐ");
				}
				System.out.println(
						"\n----------------------------------------------------------------------------------------");
			}
		}

		public static void InDsTieuThuTheoChuKy() {
			int C = 0;
			System.out.print("Nhập Chu Kì Muốn In");
			C = myInput.nextInt();
			for (KhachHang x : dsKhachHang) {
				System.out.println(" Mã KH : " + x.getMaKhachHang() + " Tên KH :" + x.getThongTinKhachHang() + "\t"
						+ "CS Cũ" + "\t" + "CS Mới" + "\t" + "Tháng/Năm" + "\t" + "Tổng tiền");
				for (BienLai o : x.getDsBienLai()) {
					if (o.getCkThang() == C) {
						System.out.println("\t\t\t\t" + o.getChiSoCu() + " \t" + o.getChiSoMoi() + "\t " + o.getCkThang()
								+ "/" + o.getCkNam() + "\t\t" + o.tinhTienDien() + " VNĐ");
						break;
					}
				}
			}
		}

		public static void XoaMotKhachHang() {
			String X;
			System.out.print("Nhập Tên Khách Hàng Cần Xóa!!!");
			myInput.nextLine();
			X = myInput.nextLine();
			for(KhachHang x : dsKhachHang) {
				if(X.equals(x.getThongTinKhachHang())) {
					dsKhachHang.remove(x);
				}
			}
		}
		/*
		 * public static void XoaBienLaiKH() { int M = 0;
		 * System.out.print("Xóa Biên Lai Khách Hàng thứ bao nhiêu? : "); M =
		 * myInput.nextInt(); for (int i = 0; i < dsKhachHang.size(); i++) { if(M==i) {
		 * BienLai.remove(i); } }
		 * 
		 * 
		 * }
		 */
	}