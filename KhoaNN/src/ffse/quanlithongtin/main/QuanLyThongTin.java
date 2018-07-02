package ffse.quanlithongtin.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;
import ffse.quanlithongtin.enity.*;
import ffse.quanlithongtin.util.CBException;
import ffse.quanlithongtin.util.NVComparator;

public class QuanLyThongTin {
	private static int N;
	private static ArrayList<ThongTin> dsCanBo = new ArrayList<ThongTin>();
	static Scanner nhap = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		int myOption = 0;
		while (myOption != 5) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+----------------------------------------------------+");
				System.out.println("|1.Nhập thông tin cán bộ                             |");
				System.out.println("|2.Xuất thông tin cán bộ                             |");
				System.out.println("|3.Tổng Tiền mà Nhà Trường phải trả cho toàn cán bộ  |");
				System.out.println("|4.Danh sách cán bộ toàn trường theo lương           |");
				System.out.println("|5.Kết Thúc                                          |");
				System.out.println("+----------------------------------------------------+");

				myOption = nhap.nextInt();
				if (myOption == 1) {

					NhapDanhSach();
				} else if (myOption == 2) {

					InThongTin();
				} else if (myOption == 3) {

					TienLuong();

				} else if (myOption == 4) {
					SapXep();

				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 5, nhập lại!");
			} finally {
				if (myOption != 5) {
					backToMainMenu();
				}
			}
		}
	}
	

	private static void NhapDanhSach() {
		System.out.println(">>Nhập Thông tin Cán Bộ<<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Giảng Viên                          |");
		System.out.println("|2.Nhân Viên                           |");
		System.out.println("+--------------------------------------+");
		int M = nhap.nextInt();
		
		if (M == 1) {
			String hoTen = " ";
			String trinhDo = "";
			int choose;
			boolean inputOK;
			double heSoLuong = 0;
			int soTietDay = 0;
			
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng Viên: ");
			N = nhap.nextInt();
			
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập Thông Tin giảng Viên thứ " + (i + 1) + "\n");
				nhap.nextLine();
				
				do {
					try {
						inputOK = true;
						System.out.print("Nhập họ tên giảng viên: ");
						hoTen = nhap.nextLine();

						if (hoTen.length() < 1 || hoTen.length() > 40) {
							
							throw new CBException(1);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);
				
				System.out.print("Nhập Khoa : ");
				String khoa = nhap.nextLine();

				do {
					System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
					choose = nhap.nextInt();
					switch (choose) {
					case 1:
						trinhDo = "Cử nhân";

						break;
					case 2:
						trinhDo = "Thạc sĩ";

						break;
					case 3:
						trinhDo = "Tiến sĩ";

					default:
						System.out.println("Chọn không đúng!");
						break;
					}
				} while (choose < 1 || choose > 3);

				do {
					try {
						inputOK = true;
						System.out.print("Số Tiết Dạy Trong Tháng: ");
						soTietDay = nhap.nextInt();

						if (soTietDay < 0) {
							
							throw new CBException(2);
						}
					} catch (Exception e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);


				do {
					try {
						inputOK = true;
						System.out.print("Hệ Số Lương: ");
						heSoLuong = nhap.nextDouble();

					} catch (InputMismatchException e) {
						System.err.println("Hệ số lương phải là số thực");
						inputOK = false;
					}
				} while (!inputOK);

				System.out.println("------------------------------------------------------------------");

				dsCanBo.add(new GiangVien(hoTen, khoa, trinhDo, soTietDay, heSoLuong));
			
			}
		} else {
			if (M == 2) {
				int choose;
				boolean inputOK;
				String hoTen = "";
				String chucVu = "";
				int soNgayCong = 0;
				double heSoLuong = 0;
				
				System.out.println("Nhập thông tin Nhân Viên");
				System.out.println("+------------------------------+");
				System.out.print("Nhập Số Lượng Nhân Viên: ");
				N = nhap.nextInt();
				for (int i = 0; i < N; i++) {
					System.out.print("Nhập Thông Tin Nhân Viên thứ " + (i + 1) + "\n");
					nhap.nextLine();

					do {
						try {
							inputOK = true;
							System.out.print("Nhập Họ Tên Nhân Viên: ");
							hoTen = nhap.nextLine();

							if (hoTen.length() < 1 || hoTen.length() > 40) {
								// bẵn lỗi
								throw new CBException(1);
							}
						} catch (Exception e) {
							System.err.println(e);
							inputOK = false;
						}
					} while (!inputOK);

					System.out.print("Phòng Ban : ");
					String phongBan = nhap.nextLine();

					do {
						System.out.print("Nhập trình độ (1 - Trưởng phòng, 2 - Phó phòng, 3 - Nhân viên): ");
						choose = nhap.nextInt();
						switch (choose) {
						case 1:
							chucVu = "Trưởng phòng";

							break;
						case 2:
							chucVu = "Phó phòng";

							break;
						case 3:
							chucVu = "Nhân viên";

						default:
							System.out.println("Chọn không đúng!");
							break;
						}
					} while (choose < 1 || choose > 3);

					do {
						try {
							inputOK = true;
							System.out.print("Số Tiết Dạy Trong Tháng: ");
							soNgayCong = nhap.nextInt();

							if (soNgayCong < 0) {
								
								throw new CBException(2);
							}
						} catch (Exception e) {
							System.err.println(e);
							inputOK = false;
						}
					} while (!inputOK);

					do {
						try {
							inputOK = true;
							System.out.print("Hệ Số Lương: ");
							heSoLuong = nhap.nextDouble();

						} catch (InputMismatchException e) {
							System.err.println("Hệ số lương phải là số thực");
							inputOK = false;
						}
					} while (!inputOK);

					System.out.println("------------------------------------------------------------------");

					dsCanBo.add(new NhanVien(hoTen, phongBan, chucVu,  soNgayCong, heSoLuong));
				}
			}
			 else {
					System.err.println("Bạn chỉ được nhập 1 hoặc 2. Hãy Nhập Lại!!!");
				}
		}
		
	}
	
	private static void InThongTin() {

		String M = "";
		System.out.println("Bạn muốn thông tin cán bộ thuộc khoa hay phòng ban nào???");
		nhap.nextLine();
		M = nhap.nextLine();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {

					System.out.println("Giảng Viên  Thứ " + (i + 1) + ":\n Họ Tên Giảng Viên: "
							+ ((GiangVien) dsCanBo.get(i)).gethoTen() + "\n - Khoa: "
							+ ((GiangVien) dsCanBo.get(i)).getKhoa() + "\n - Trình Độ: "
							+ ((GiangVien) dsCanBo.get(i)).getTrinhDo() + "\n - Số Tiết Dạy: "
							+ ((GiangVien) dsCanBo.get(i)).getSoTietDay() + "\n - Hệ Số Lương: "
							+ ((GiangVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((GiangVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}
			if (dsCanBo.get(i) instanceof NhanVien) {
				if (M.equals(((NhanVien) dsCanBo.get(i)).getPhongBan())) {

					System.out.println("Nhân Viên  Thứ " + (i + 1) + ":\n Họ Tên Nhân Viên: "
							+ ((NhanVien) dsCanBo.get(i)).gethoTen() + "\n - phòng Ban: "
							+ ((NhanVien) dsCanBo.get(i)).getPhongBan() + "\n - Chức Vụ: "
							+ ((NhanVien) dsCanBo.get(i)).getChucVu() + "\n - Số Ngày Công: "
							+ ((NhanVien) dsCanBo.get(i)).getSoNgayCong() + "\n - Hệ Số Lương: "
							+ ((NhanVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((NhanVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}
	
	private static void TienLuong() {
		double tongtien = 0;
		for (int i = 0; i < dsCanBo.size(); i++) {
			tongtien += dsCanBo.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}
	
	private static void SapXep() {
		
	}
	
	private static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();
		
	}
}
