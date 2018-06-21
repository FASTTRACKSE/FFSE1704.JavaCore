package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quanglyluongnhanvien.java.entity.GiangVien;
import quanglyluongnhanvien.java.entity.Luong;
import quanglyluongnhanvien.java.entity.NhanVienVanPhong;

public class ChuongTrinhQuanLyNhanVien {
	static int n, i;
	static double tongtien;
	static Scanner nhap = new Scanner(System.in);
	static ArrayList<Luong> dsLuong = new ArrayList<Luong>();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		while (n != 5) {

			try {
				System.out.println("\nHệ thống quản lý Sinh Viên");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập thông tin danh sách cán bộ trong trường.");
				System.out.println("2. Xuất danh sách giảng viên khoa x, hoặc nhân viên phòng ban y nào đó. ");
				System.out.println("3. Tổng số lương trường phải trả cho cán bộ.");
				System.out.println("4. Sắp xếp cán bộ theo lương, nếu lương bằng thì sắp xếp theo tên.");
				System.out.println("5. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				n = nhap.nextInt();
				if (n == 1) {
					nhapthongtincanbotrongtruong();
				} else if (n == 2) {

					inthongtindanhsach();
				} else if (n == 3) {

					tinhTongluongNhanVien();
				} else if (n == 4) {
					sapxeptheoluong();

				} else if (n == 5) {

					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {

			} finally {
				if (n != 5) {
					backToMainMenu();
				}
			}
		}
	}

	public static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	public static void nhapthongtincanbotrongtruong() {
		System.out.println("\n NHÂN VIÊN THUỘC LOẠI NÀO");
		System.out.println("--------------------------------------");
		System.out.println("1: Giảng viên");
		System.out.println("2: Nhân viên văn phòng ");
		System.out.println("--------------------------------------");
		n = nhap.nextInt();
		if (n == 1) {
			System.out.println("NHẬP THÔNG TIN GIẢNG VIÊN");
			System.out.println("-------------------------------");
			System.out.print("Nhập số lượng giảng viên :");
			n = nhap.nextInt();
			for (i = 0; i < n; i++) {
				System.out.println("Nhập giảng viên thứ :" + (i + 1));

				System.out.print("Nhập mã giảng viên: ");
				int maNhanVien = nhap.nextInt();
				nhap.nextLine();

				System.out.print("Nhập họ tên giảng viên: ");
				String hoVaTen = nhap.nextLine();

				System.out.print("Nhập khoa giảng viên đang dạy: ");
				String khoa = nhap.nextLine();

				System.out.print("Nhập trình độ: ");
				String trinhDo = nhap.nextLine();

				System.out.print("Số tiết dạy: ");
				int soTietDay = nhap.nextInt();

				System.out.print("Nhập hệ số lương: ");
				double heSoLuong = nhap.nextDouble();

				dsLuong.add(new GiangVien(maNhanVien, hoVaTen, khoa, trinhDo, soTietDay, heSoLuong));
			}
		} else if (n == 2) {
			System.out.println("NHẬP THÔNG TIN NHÂN VIÊN");
			System.out.println("-------------------------------");
			System.out.println("Nhập số lượng nhân viên :");
			n = nhap.nextInt();
			for (i = 0; i < n; i++) {
				System.out.println("Nhập nhân viên thứ :" + (i + 1));

				System.out.print("Nhập mã nhân viên: ");
				int maNhanVien = nhap.nextInt();
				nhap.nextLine();

				System.out.print("Nhập họ tên nhân viên: ");
				String hoVaTen = nhap.nextLine();

				System.out.print("Nhập phòng ban: ");
				String phongBan = nhap.nextLine();

				System.out.print("Nhập chức vụ: ");
				String chucVu = nhap.nextLine();

				System.out.print("Số ngày công: ");
				int soNgayCong = nhap.nextInt();

				System.out.print("Nhập hệ số lương: ");
				double heSoLuong = nhap.nextDouble();

				dsLuong.add(new NhanVienVanPhong(maNhanVien, hoVaTen, phongBan, chucVu, soNgayCong, heSoLuong));

			}
		}

	}

	public static void inthongtindanhsach() {

		String M = "";
		nhap.nextLine();
		System.out.print("Mời Nhập Khoa hoặc phòng ban mà bạn muốn in:");
		M = nhap.nextLine();
		for (int i = 0; i < dsLuong.size(); i++) {
			if (dsLuong.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsLuong.get(i)).getKhoa())) {

					System.out.println((i + 1) + "\t " + ((GiangVien) dsLuong.get(i)).getMaNhanVien() + "\t "
							+ ((GiangVien) dsLuong.get(i)).getHoVaTen() + "\t " + ((GiangVien) dsLuong.get(i)).getKhoa()
							+ "\t  " + ((GiangVien) dsLuong.get(i)).getTrinhDo() + "\t "
							+ ((GiangVien) dsLuong.get(i)).getSoTietDay() + "\t "
							+ ((GiangVien) dsLuong.get(i)).getHeSoLuong() + "\t "
							+ ((GiangVien) dsLuong.get(i)).tinhLuong() + " VNĐ");

				}
			}
			if (dsLuong.get(i) instanceof NhanVienVanPhong) {
				if (M.equals(((NhanVienVanPhong) dsLuong.get(i)).getPhongBan())) {

					System.out.println((i + 1) + "\t " + ((NhanVienVanPhong) dsLuong.get(i)).getMaNhanVien() + "\t "
							+ ((NhanVienVanPhong) dsLuong.get(i)).getHoVaTen() + "\t "
							+ ((NhanVienVanPhong) dsLuong.get(i)).getPhongBan() + "\t  "
							+ ((NhanVienVanPhong) dsLuong.get(i)).getChucVu() + "\t"
							+ ((NhanVienVanPhong) dsLuong.get(i)).getSoNgayCong() + "\t "
							+ ((NhanVienVanPhong) dsLuong.get(i)).getHeSoLuong() + "\t "
							+ ((NhanVienVanPhong) dsLuong.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}

	public static void tinhTongluongNhanVien() {
		double tongtien = 0;
		for (int i = 0; i < dsLuong.size(); i++) {
			tongtien += dsLuong.get(i).tinhLuong();

		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");

	}

	public static void sapxeptheoluong() {

		System.out.println("\n MỜI BẠN CHỌN");
		System.out.println("--------------------------------------");
		System.out.println("1: Giảng viên");
		System.out.println("2: Nhân viên văn phòng ");
		System.out.println("--------------------------------------");
		n = nhap.nextInt();
		Collections.sort(dsLuong, new Comparator<Luong>() {

			@Override
			public int compare(Luong NV1, Luong NV2) {
				if (NV1.tinhLuong() < NV2.tinhLuong()) {
					return 1;
				} else if (NV1.tinhLuong() > NV2.tinhLuong()) {
					return -1;
				} else {
					return (NV2.getHoVaTen().compareTo(NV1.getHoVaTen()));
				}
			}

		});
		if (n == 1) {
			System.out.println(" danh sách giảng viên");
			System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s ", "STT", "MaNhanVien", "HoVaTen", "PhongBan",
					"ChucVu", "SoNgayCong", "HeSoLuong", "TongLuong");
			System.out.println("");
			for (Luong o : dsLuong) {

				if (o instanceof GiangVien) {
					System.out.println((i + 1) + "\t" + ((GiangVien) o).getMaNhanVien() + "\t"
							+ ((GiangVien) o).getHoVaTen() + "\t" + ((GiangVien) o).getKhoa() + "\t"
							+ ((GiangVien) o).getTrinhDo() + "\t" + ((GiangVien) o).getSoTietDay() + "\t"
							+ ((GiangVien) o).getHeSoLuong() + "\t" + ((GiangVien) o).tinhLuong());
				}
			}
		} else if (n == 2) {
			System.out.println(" Danh sách nhân viên văn phòng");
			System.out.printf("%2s %10s %10s %10s %10s %10s %10s %10s ", "STT", "MaNhanVien", "HoVaTen", "PhongBan",
					"ChucVu", "SoNgayCong", "HeSoLuong", "TongLuong");
			System.out.println("");
			for (Luong o : dsLuong) {
				if (o instanceof NhanVienVanPhong) {

					System.out.println((i + 1) + "\t" + ((NhanVienVanPhong) o).getMaNhanVien() + "\t"
							+ ((NhanVienVanPhong) o).getHoVaTen() + "\t" + ((NhanVienVanPhong) o).getPhongBan() + "\t"
							+ ((NhanVienVanPhong) o).getChucVu() + "\t" + ((NhanVienVanPhong) o).getSoNgayCong() + "\t"
							+ ((NhanVienVanPhong) o).getHeSoLuong() + "\t" + ((NhanVienVanPhong) o).tinhLuong());
				}
			}

		}

	}
}
