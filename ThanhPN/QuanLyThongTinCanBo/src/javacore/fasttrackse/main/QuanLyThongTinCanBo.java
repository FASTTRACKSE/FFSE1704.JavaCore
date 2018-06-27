package javacore.fasttrackse.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javacore.fasttrackse.entity.*;
import javacore.fasttrackse.util.CBException;

public class QuanLyThongTinCanBo {
	static int N;
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		int myOption = 0;
		while (myOption != 6) {
			try {
				System.out.println("\nHệ thống quản lý Cán Bộ ");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập thông tin cán bộ     ");
				System.out.println("2. Xuất thông tin cán bộ   ");
				System.out.println("3. Tổng Tiền mà Nhà Trường phải trả cho toàn cán bộ ");
				System.out.println("4. Sắp Xếp  ");
				System.out.println("5. Kết Thúc");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {

					NhapDanhsachCB();
				} else if (myOption == 2) {

					XuatTTCanBo();
				} else if (myOption == 3) {

					TongSoLuongPhaiTra();
				} else if (myOption == 4) {
					SapXepCanBo();

				} else if (myOption == 5) {

					KetThuc();
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

	public static void NhapDanhsachCB() {
		Scanner myInput = new Scanner(System.in);
		System.out.println(">> Bạn nhập cho Giảng Vien hay Nhân Viên <<");

		System.out.println("1.Giảng Viên                       ");
		System.out.println("2.Nhân Viên                         ");

		int M = myInput.nextInt();
		if (M == 1) {
			boolean inputOK;
			double heSoLuong = 0;
			String hoTen = "";
			String trinhDo = "";
			int soTietDay = 0;
			System.out.println(".Bạn đang nhập thông tin Giảng Viên ");

			System.out.println("Nhập số lượng Giảng Viên");
			int X = myInput.nextInt();
			for (int i = 0; i < X; i++) {
				myInput.nextLine();

				System.out.println("Nhập cán bộ Giảng viên thứ: " + (i + 1) + "\n");

				// Input Exception Tên

				do {
					try {

						System.out.println("Nhập họ tên của Giảng viên");

						hoTen = myInput.nextLine();
						inputOK = true;

						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new CBException(1);
						}
					} catch (CBException e) {
						System.out.println(e);
						inputOK = false;
					}
				}

				while (!inputOK);
				// IE Lương
				do {
					try {
						inputOK = true;
						System.out.println("Nhập hệ số lương Giảng viên");
						heSoLuong = myInput.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println("Hệ số lương phải là số thực, Yêu cầu nhập lại!");
						myInput.next();
						inputOK = false;
					}
				} while (!inputOK);

				System.out.println("Nhập Khoa của Giảng Viên");
				myInput.nextLine();
				String khoa = myInput.nextLine();
				// IE Trình độ

				do {
					try {
						System.out.println("Nhập trình độ: ");
						System.out.println("1:CỬ NHÂN   2:THẠC SĨ    3:TIẾN SĨ ");
						int nhap = myInput.nextInt();
						if (nhap == 1) {
							trinhDo = "Cử nhân";
							inputOK = true;
						} else if (nhap == 2) {
							trinhDo = "Thạc sĩ";
							inputOK = true;
						} else if (nhap == 3) {
							trinhDo = "Tiến sĩ";
							inputOK = true;
						} else {
							System.out.println("Bạn đã nhập sai, mời bạn nhập lại");
							inputOK = false;
						}
					} catch (InputMismatchException e) {
						inputOK = false;
						System.out.println("Hello. Nhập sai rồi nhập lại nhé!");
						myInput.next();
					}
				} while (!inputOK);

				// IE Số tiết dạy

				do {
					try {
						inputOK = true;
						System.out.println("Nhập số tiết dạy trong tháng của Giảng Viên");
						soTietDay = myInput.nextInt();
						if (soTietDay < 0) {
							throw new CBException(2);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
						myInput.nextLine();
					}

				} while (!inputOK);

				dsCanBo.add(new GiangVien(hoTen, heSoLuong, khoa, trinhDo, soTietDay));
			}
		} else if (M == 2) {
			boolean inputOK;
			double heSoLuong = 0;
			String hoTen = "";
			int soNgayCong = 0;
			String chucVu = "";
			System.out.println(".Bạn đang nhập thông tin Cán Bộ Nhân Viên ");

			System.out.println("Nhập số lượng Nhân viên");
			int X = myInput.nextInt();
			for (int i = 0; i < X; i++) {
				myInput.nextLine();
				System.out.println("Nhập cán bộ Nhân viên thứ: " + (i + 1) + "\n");

				do {
					try {
						inputOK = true;

						System.out.println("Nhập họ tên của Nhân viên: ");

						hoTen = myInput.nextLine();
						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new CBException(1);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}

				} while (!inputOK);

				do {
					try {
						inputOK = true;
						System.out.println("Nhập hệ số lương Giảng viên");
						heSoLuong = myInput.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println("Hệ số lương phải là số thực ");
						myInput.next();
						inputOK = false;
					}
				} while (!inputOK);

				System.out.println(" Phòng ban Nhân viên");
				myInput.nextLine();
				String phongBan = myInput.nextLine();

				do {
					try {
						inputOK = true;
						System.out.println("Nhập số tiết dạy Giảng Viên");
						soNgayCong = myInput.nextInt();
						if (soNgayCong < 0) {
							throw new CBException(2);
						}
					} catch (Exception e1) {
						System.err.println(e1);
						inputOK = false;
						myInput.nextLine();
					}

				} while (!inputOK);

				do {
					try {
						System.out.println("Nhập trình độ: ");
						System.out.println("1:TRƯỞNG PHÒNG     2:PHÓ PHÒNG    3:NHÂN VIÊN CÙI ");
						int nhap = myInput.nextInt();
						if (nhap == 1) {
							chucVu = "Trưởng phòng";
							inputOK = true;
						} else if (nhap == 2) {
							chucVu = "Phó phòng";
							inputOK = true;
						} else if (nhap == 3) {
							chucVu = "Nhân viên";
							inputOK = true;
						} else {
							System.out.println("Bạn đã nhập sai, mời bạn nhập lại");
							inputOK = false;
						}
					} catch (InputMismatchException e) {
						inputOK = false;
						System.out.println(" Hello. Nhập sai rồi nhập lại nhé! ");
						myInput.next();
					}
				} while (!inputOK);

				dsCanBo.add(new NhanVienHanhChinh(hoTen, heSoLuong, phongBan, soNgayCong, chucVu));

			}
		} else {
			System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
		}
	}

	public static void XuatTTCanBo() {

		String M = "";
		System.out.println("Bạn muốn xuất thông tin thuộc khoa hay phòng ban nào đây?");
		myInput.nextLine();
		M = myInput.nextLine();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {
					System.out.println("Giảng viên thứ:" + (i + 1) + ":\n Họ tên giảng viên:"
							+ ((GiangVien) dsCanBo.get(i)).getHoTen() + "\n - Hệ số lương: "
							+ ((GiangVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Khoa: "
							+ ((GiangVien) dsCanBo.get(i)).getKhoa() + "\n - Trình độ: "
							+ ((GiangVien) dsCanBo.get(i)).getTrinhDo() + "\n - Khoa: "
							+ ((GiangVien) dsCanBo.get(i)).getKhoa() + "\n - Lương : "
							+ ((GiangVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");
				}
			}
			if (dsCanBo.get(i) instanceof NhanVienHanhChinh) {
				if (M.equals(((NhanVienHanhChinh) dsCanBo.get(i)).getPhongBan())) {
					System.out.println("Nhân viên thứ:" + (i + 1) + ":\n Họ tên giảng viên:"
							+ ((NhanVienHanhChinh) dsCanBo.get(i)).getHoTen() + "\n - Hệ số lương: "
							+ ((NhanVienHanhChinh) dsCanBo.get(i)).getHeSoLuong() + "\n - Phòng ban: "
							+ ((NhanVienHanhChinh) dsCanBo.get(i)).getPhongBan() + "\n - Số ngày công: "
							+ ((NhanVienHanhChinh) dsCanBo.get(i)).getSoNgayCong() + "\n - Chức vụ: "
							+ ((NhanVienHanhChinh) dsCanBo.get(i)).getChucVu() + "\n - Lương : "
							+ ((NhanVienHanhChinh) dsCanBo.get(i)).tinhLuong() + " VNĐ");
				}
			}
		}
	}

	public static void TongSoLuongPhaiTra() {
		double tongtien = 0;
		for (int i = 0; i < dsCanBo.size(); i++) {
			tongtien += dsCanBo.get(i).tinhLuong();
		}
		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}

	public static void SapXepCanBo() {

	}

	public static void KetThuc() {
		System.out.println("Kết thúc chương trình, cảm ơn bạn đã sử dụng!!!");
	}

	public static void backToMainMenu() {
		myInput.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myInput.nextLine();
	}

}
