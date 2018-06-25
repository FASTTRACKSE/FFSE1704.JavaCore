package quanlycanbo.main;

//import quanlicanbo.util.MyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import quanlycanbo.util.CanBoComparator;
import quanlycanbo.util.MyException;

import java.util.Scanner;

import quanlycanbo.entity.*;

public class ChuongTrinhQLCB {
	static int N;
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (N != 5) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+-------------------------------------------+");
				System.out.println("|1.Nhập danh thông tin cán bộ                |");
				System.out.println("|2.Xuất danh sách thông tin cán bộ          |");
				System.out.println("|3.Tổng số tiền mà nhà trường phải trả      |");
				System.out.println("|4.Sắp xếp danh sách Cán Bộ                 |");
				System.out.println("|5.Xóa 1 Cán bộ                             |");
				System.out.println("|6.Kết Thúc                                 |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Mời Bạn Chọn Chức Năng");
				N = myInput.nextInt();
				if (N == 1) {
					NhapDanhsachCB();
				} else if (N == 2) {
					XuatTTCanBo();
				} else if (N == 3) {
					TongSoLuongPhaiTra();
				} else if (N == 4) {
					SapXepCanBo();
				} else if (N == 5) {
					KetThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {

				System.out.println("Bạn chỉ được nhập từ 1 tới 5");
			} finally {
				//
				// Back();
				//
				// }
			}
		}
	}

	public static void NhapDanhsachCB() {
		Scanner myInput = new Scanner(System.in);
		System.out.println(">> Bạn nhập cho Giảng Vien hay Nhân Viên <<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Giảng Viên                          |");
		System.out.println("|2.Nhân Viên                           |");
		System.out.println("+--------------------------------------+");
		int M = myInput.nextInt();
		if (M == 1) {
			int choose;
			boolean inputOK;
			double heSoLuong = 0;
			String hoTen = "";
			String trinhDo = "";
			int soTietDay = 0;
			int phuCap = 0;
			System.out.println(".Bạn đang nhập thông tin Giảng Viên ");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng Giảng Viên");
			int X = myInput.nextInt();
			for (int i = 0; i < X; i++) {
				myInput.nextLine();
				System.out.println("Nhập cán bộ Giảng viên thứ" + (i + 1) + "\n");
				do {
					try {

						System.out.println("Nhập họ tên của Giảng viên");
						
						hoTen = myInput.nextLine();
						inputOK = true;

						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new MyException(1);
						}
					} catch (MyException e) {
						System.out.println(e);
						inputOK = false;
					}
				}

				while (!inputOK);

				do {
					try {
						inputOK = true;
						System.out.println("Nhập hệ số lương Giảng viên");
						heSoLuong = myInput.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println("Hệ số lương phairla số thực");
						myInput.next();
						inputOK = false;
					}
				} while (!inputOK);

				System.out.println("Nhập Khoa của Giảng Viên");
				myInput.nextLine();
				String khoa = myInput.nextLine();
				

				
				do {
					try {
						System.out.println("Nhập trình độ: ");
						System.out.println("1:CỬ NHÂN--2:THẠC SĨ---3:TIẾN SĨ ");
						int nhap = myInput.nextInt();
						if(nhap ==1) {
							trinhDo = "Cử nhân";
							phuCap = 1000;
							inputOK = true;
						}else
						if(nhap ==2) {
							trinhDo = "Thạc sĩ";
							phuCap = 1500;
							inputOK = true;
						}else
						if(nhap ==3) {
							trinhDo = "Tiến sĩ";
							phuCap = 200;
							inputOK = true;
						}
						else {
							System.out.println("ban đã nhập sai, mời nhập lại");
							inputOK = false;
						}
					}
						catch(InputMismatchException e) {
							inputOK = false;
							System.out.println("bạn hiền nhập sai rồi nhập lại nhé");
							myInput.next();
						}
				}
					while(!inputOK);
				
					
				
				
				do {
					try {
						inputOK = true;
						System.out.println("Nhập số tiết dạy Giảng Viên");
						soTietDay = myInput.nextInt();
						if (soTietDay < 0) {
							throw new MyException(2);
						}
					} catch (Exception e1) {
						System.err.println(e1);
						inputOK = false;
						myInput.nextLine();
					}

				} while (!inputOK);
				
			
				dsCanBo.add(new GiangVien(hoTen, heSoLuong, khoa, trinhDo, soTietDay));
			}
			}
				
		 else if (M == 2) {
			int choose;
			boolean inputOK;
			double heSoLuong = 0;
			String hoTen = "";
			int soNgayCong = 0;
			String chucVu = "";
			int phuCap = 0;
			System.out.println(".Bạn đang nhập thông tin Cán Bộ Nhân Viên ");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng Nhân viên");
			int X = myInput.nextInt();
			for (int i = 0; i < X; i++) {
				myInput.nextLine();
				System.out.println("Nhập cán bộ Nhân viên thứ" + (i + 1) + "\n");

				do {
					try {
						inputOK = true;
						
						System.out.println("Nhập họ tên của Nhân viên");
						
						hoTen = myInput.nextLine();
						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new MyException(1);
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
						System.out.println("Hệ số lương phairla số thực");
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
							throw new MyException(2);
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
						System.out.println("1:TRƯỞNG PHÒNG--2:PHÓ PHÒNG---3:NHÂN VIÊN CÙI ");
						int nhap = myInput.nextInt();
						if(nhap ==1) {
							chucVu = "Trưởng phòng";
							phuCap = 2000;
							inputOK = true;
						}else
						if(nhap ==2) {
							chucVu = "Phó phòng";
							phuCap = 1500;
							inputOK = true;
						}else
						if(nhap ==3) {
							chucVu = "Nhân viên";
							phuCap = 1000;
							inputOK = true;
						}
						else {
							System.out.println("ban đã nhập sai, mời nhập lại");
							inputOK = false;
						}
					}
						catch(InputMismatchException e) {
							inputOK = false;
							System.out.println("bạn hiền nhập sai rồi nhập lại nhé");
							myInput.next();
						}
				}
					while(!inputOK);

				dsCanBo.add(new NhanVien(hoTen, heSoLuong, phongBan, soNgayCong, chucVu));

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
			if (dsCanBo.get(i) instanceof NhanVien) {
				if (M.equals(((NhanVien) dsCanBo.get(i)).getPhongBan())) {
					System.out.println("Nhân viên thứ:" + (i + 1) + ":\n Họ tên giảng viên:"
							+ ((NhanVien) dsCanBo.get(i)).getHoTen() + "\n - Hệ số lương: "
							+ ((NhanVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Phòng ban: "
							+ ((NhanVien) dsCanBo.get(i)).getPhongBan() + "\n - Số ngày công: "
							+ ((NhanVien) dsCanBo.get(i)).getSoNgayCong() + "\n - Chức vụ: "
							+ ((NhanVien) dsCanBo.get(i)).getChucVu() + "\n - Lương : "
							+ ((NhanVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");
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
		int i = 0;
		Collections.sort(dsCanBo, CanBoComparator.CanBoLuongASComparator);
		System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ tên",
				"Hệ số lương", "khoa", "Phòng ban", "Trình độ", "chức vụ", "Số Tiết Dạy", "Số ngày công",
				"lương được nhận\n");
		System.out.println("");
		System.out.println(
				"-------------------------------	------------------------------------*******************-------------------------------------------------------------------------");
		for (CanBo o : dsCanBo) {
			if (o instanceof GiangVien) {
				GiangVien gv = (GiangVien) o;
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
						gv.getHoTen(), gv.getHeSoLuong(), gv.getKhoa(), "x", gv.getTrinhDo(), "x", gv.getSoTietDay(),
						"X", gv.tinhLuong(), "\n");
			} else if (o instanceof NhanVien) {
				NhanVien nv = (NhanVien) o;
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i++),
						nv.getHoTen(), nv.getHeSoLuong(), "x", nv.getPhongBan(), "X", nv.getChucVu(), "X",
						nv.getSoNgayCong(), nv.tinhLuong(), "\n");
			}
		}
		System.out.println("");
		System.out.println(
				"-------------------------------------------------------------------*******************-------------------------------------------------------------------------");

	}

	public static void KetThuc() {
		System.out.println("KTCT");

	}

	public static void Back() {
		myInput.nextInt();
		System.out.println("Ấn enter vê menu chính");
		myInput.nextInt();

	}

}
