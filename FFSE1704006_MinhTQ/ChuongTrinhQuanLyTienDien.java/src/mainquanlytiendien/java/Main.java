package mainquanlytiendien.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import quanlytiendien.java.entity.*;

public class Main {

	static int n, i, tongtien, number;

	static Scanner nhap = new Scanner(System.in);
	static ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
	static ArrayList<BienLai> dsBienLai = new ArrayList<BienLai>();

	private static Object maKhachHang;

	public static void main(String[] args) {

		while (true) {

			System.out.println("\nHệ thống quản lý Tiền Điện");
			System.out.println("---------------------------------------");
			System.out.println("1. Nhập danh sách Khách Hàng");
			System.out.println("2. Nhập thông tin Biên Lai");
			System.out.println("3. In báo cáo tiêu thụ điện");
			System.out.println("4. Xoá 1 khách hàng");
			System.out.println("5. Kết thúc chương trình");
			System.out.println("---------------------------------------");
			System.out.print("Mời bạn chọn chức năng: ");

			n = nhap.nextInt();

			if (n == 1) {
				nhapthongtinkhachhang();
			} else if (n == 2) {
				nhapthongtinbienlai();
			} else if (n == 3) {
				inthongtintieuthudiennang();
			} else if (n == 4) {
				xoakhachhang(n);
			} else if (n == 5) {
				ketthucchuongtrinh();
			}
		}
	}

	public static void nhapthongtinkhachhang() {

		System.out.print("nhập số lượng khách hàng :");
		number = nhap.nextInt();

		for (i = 0; i < number; i++) {
			KhachHang x = new KhachHang();
			System.out.print("Nhập mã khách hàng :");
			nhap.nextLine();
			x.setMaKhachHang(nhap.nextInt());

			System.out.print("Nhập tên khách hàng :");
			nhap.nextLine();
			x.setTenKhachHang(nhap.nextLine());

			System.out.print("Nhập địa chỉ khách hàng :");
			x.setDiaChi(nhap.nextLine());

			System.out.print("Nhập số công tơ :");
			x.setMaCongTo(nhap.nextInt());

			dsKhachHang.add(x);

		}
		System.out.println("");
		System.out.println("************@**********@*********");
		nhap.nextLine();
		System.out.println("Mời ấn Enter để về menu chính!");
		nhap.nextLine();

	}

	public static void nhapthongtinbienlai() {

		System.out.print("mời nhập mã khách hàng muốn nhập biên lai : ");
		n = nhap.nextInt();
		KhachHang tim = dsKhachHang.get(n - 1);
		System.out.println("*khách hàng : " + "\t" + tim.getTenKhachHang());

		BienLai o = new BienLai();
		System.out.print("nhập kỳ tiêu thụ : ");
		nhap.nextLine();
		o.setKyTieuThu(nhap.nextLine());

		System.out.print("nhập chỉ số cũ : ");
		o.setSoCu(nhap.nextInt());
		System.out.print("nhập chỉ số mới : ");
		o.setSoMoi(nhap.nextInt());

		dsBienLai.add(o);
		System.out.println("");
		System.out.println("************@**********@*********");
		nhap.nextLine();
		System.out.println("Mời ấn Enter để về menu chính!");
		nhap.nextLine();
	}

	public static void inthongtintieuthudiennang() {
		System.out.println("\n Thông Tin Khách Hàng");

		Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang kh1, KhachHang kh2) {
				return (kh1.getTenKhachHang().compareTo(kh2.getTenKhachHang()));
				// Muốn đảo danh sách các bạn đối thành
				// return (sv2.hoTen.compareTo(sv1.hoTen));
			}
		});
		for (KhachHang tim : dsKhachHang) {
			System.out.print("\n" + " : " + tim.getTenKhachHang());
			for (BienLai o : dsBienLai) {
				System.out.println("\t\t\t\t" + o.getKyTieuThu() + o.getSoCu() + " \t" + o.getSoMoi() + "\t "
						+ o.soTienPhaiTra() + "VNĐ");
			}
			System.out.println(
					"\n----------------------------------------------------------------------------------------");
		}

		System.out.println("");
		System.out.println("************@**********@*********");
		nhap.nextLine();
		System.out.println("Mời ấn Enter để về menu chính!");
		nhap.nextLine();
	}

	public static void xoakhachhang(int i) {

		if (!dsKhachHang.isEmpty()) {
			dsKhachHang.remove(001);
		}
		System.out.println("");
		System.out.println("************@**********@*********");
		nhap.nextLine();
		System.out.println("Mời ấn Enter để về menu chính!");
		nhap.nextLine();
	}

	public static void ketthucchuongtrinh() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
		System.exit(0);

	}

}