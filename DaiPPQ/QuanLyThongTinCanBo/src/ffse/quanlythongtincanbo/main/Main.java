/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import ffse.quanlythongtincanbo.entity.*;
import ffse.quanlythongtincanbo.util.SVComparator;

public class Main {
	
	static int N;
	static ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	static Scanner myInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+----------------------------------------------------+");
			System.out.println("|1.Nhập thông tin cán bộ                             |");
			System.out.println("|2.Xuất thông tin cán bộ                             |");
			System.out.println("|3.Tổng Tiền mà Nhà Trường phải trả cho toàn cán bộ  |");
			System.out.println("|4.Danh sách cán bộ toàn trường theo lương           |");
			System.out.println("|5.Kết Thúc                                          |");
			System.out.println("+----------------------------------------------------+");
			System.out.print("Mời Bạn Chọn Chức Năng: ");
			N = myInput.nextInt();
			if (N == 1) {
				NhapThongTinNV();
			} else if (N == 2) {
				xuatThongTin();
			} else if (N == 3) {
				tongLuong();
			} else if (N == 4) {
				sapXep();
			} else {
				System.exit(0);
			}
		}
	}
	public static void NhapThongTinNV() {
		
		Scanner n = new Scanner(System.in);
		int M = 0;
		for (;;) {
			System.out.println(">>     Nhân viên thuộc     <<");
			System.out.println("+---------------------------+");
			System.out.println("|1. Giảng viên              |");
			System.out.println("|2. Nhân viên hành chính    |");
			System.out.println("+---------------------------+");
			System.out.print("Mời Bạn Chọn: ");
			M = n.nextInt();
			if (M == 1 ||M == 2)
				break;
		}
		
		if (M == 1) {
			System.out.println("Nhập Thông Tin Giảng Viên ");
			System.out.println("+------------------------------+");
			System.out.print("Nhập số lượng giảng viên: ");
			N = myInput.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập thông tin giảng viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập họ tên giảng viên: ");
				String ten = myInput.nextLine();
				/*
				System.out.print("Nhập Khoa: ");
				String khoa = myInput.nextLine();
				*/
				int K = 0;
				for (;;) {
					System.out.println(">> Giảng Viên Thuộc Khoa <<");
					System.out.println("+------------------------+");
					System.out.println("|1. Toán                 |");
					System.out.println("|2. Lý                   |");
					System.out.println("|3. Hóa                  |");
					System.out.println("|4. Sinh                 |");
					System.out.println("|5. Văn                  |");
					System.out.println("|6. Sử                   |");
					System.out.println("|7. Địa                  |");
					System.out.println("|8. Ngoại Ngữ            |");
					System.out.println("|9. Năng Khiếu           |");
					System.out.println("+------------------------+");
					System.out.print("Mời Bạn Chọn: ");
					K = n.nextInt();
					if (K == 1 || K == 2 || K == 3 || K == 4 || K == 5 || K == 6 || K == 7 || K == 8 || K == 9)
						break;
				}
				String khoa = null;
				if(K == 1) {
					khoa = "Toán";
				} else if(K == 2) {
					khoa = "Lý";
				} else if (K == 3) {
					khoa = "Hóa";
				}else if (K == 4) {
					khoa = "Sinh";
				}else if (K == 5) {
					khoa = "Văn";
				}else if (K == 6) {
					khoa = "Sử";
				}else if (K == 7) {
					khoa = "Địa";
				}else if (K == 8) {
					khoa = "Ngoại Ngữ";
				}else if (K == 9) {
					khoa = "Năng Khiếu";
				}
				
				
				int TD = 0;
				for (;;) {
					System.out.println(">> Trình Độ Giảng Viên <<");
					System.out.println("+-----------------------+");
					System.out.println("|1. Cử nhân             |");
					System.out.println("|2. Thạc sỉ             |");
					System.out.println("|3. Tiến  sỉ            |");
					System.out.println("+-----------------------+");
					System.out.print("Mời Bạn Chọn: ");
					TD = n.nextInt();
					if (TD == 1 ||TD == 2 || TD == 3)
						break;
				}
				int phuCap = 0;
				String trinhDo = null;
				if(TD == 1) {
					trinhDo = "Cử nhân";
					phuCap = 300;
				} else if(TD == 2) {
					trinhDo = "Thạc sỉ";
					phuCap = 500;
				} else if (TD == 3) {
					trinhDo = "Tến sỉ";
					phuCap = 1000;
				}

				System.out.print("Số tiết dạy: ");
				int soTietDayTrongThang = myInput.nextInt();

				System.out.print("Hệ số lương: ");
				double heSoLuong = myInput.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new GiangVien(ten, khoa, trinhDo, phuCap, soTietDayTrongThang, heSoLuong));
			}
		} else {
			System.out.println("Nhập Thông Tin Nhân Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập số lượng nhân viên: ");
			N = myInput.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.print("Nhập thông tin nhân viên thứ " + (i + 1) + "\n");
				myInput.nextLine();

				System.out.print("Nhập họ tên nhân viên: ");
				String ten = myInput.nextLine();
				
				/*
				System.out.print("Nhân viên thuộc phòng: ");
				String phongBan = myInput.nextLine();
				*/
				
				int P = 0;
				for (;;) {
					System.out.println(">> Nhân Viên Thuộc Phòng <<");
					System.out.println("+-------------------------+");
					System.out.println("|1. Nhân Sự               |");
					System.out.println("|2. Kế Toán               |");
					System.out.println("|3. Quản Lý Sinh Viên     |");
					System.out.println("+-------------------------+");
					System.out.print("Mời Bạn Chọn: ");
					P = n.nextInt();
					if (P == 1 || P == 2 || P == 3)
						break;
				}
				String phongBan = null;
				if(P == 1) {
					phongBan = "Nhân Sự";
				} else if(P == 2) {
					phongBan = "Kế Toán";
				} else if (P == 3) {
					phongBan = "Quản Lý Sinh Viên";
				}
				
				int TD = 0;
				for (;;) {
					System.out.println(">>       Chức Vụ       <<");
					System.out.println("+-----------------------+");
					System.out.println("|1. Trưởng phòng        |");
					System.out.println("|2. Phó phòng           |");
					System.out.println("|3. Nhân viên           |");
					System.out.println("+-----------------------+");
					System.out.print("Mời Bạn Chọn: ");
					TD = n.nextInt();
					if (TD == 1 ||TD == 2 || TD == 3)
						break;
				}
				int phuCap = 0;
				String chucVu = null;
				if(TD == 1) {
					chucVu = "Trưởng phòng";
					phuCap = 2000;
				} else if(TD == 2) {
					chucVu = "Phó phòng";
					phuCap = 1000;
				} else if (TD == 3) {
					chucVu = "Nhân viên";
					phuCap = 500;
				}

				System.out.print("Số ngày công: ");
				int soNgayCong = myInput.nextInt();

				System.out.print("Hệ Số Lương: ");
				double heSoLuong = myInput.nextDouble();

				System.out.println("------------------------------------------------------------------");

				dsNhanVien.add(new NhanVienHanhChinh(ten, phongBan, chucVu, phuCap, soNgayCong, heSoLuong));
			}
		
		}
	}
	
	public static void xuatThongTin() {

		Scanner n = new Scanner(System.in);
		int M = 0;
		for (;;) {
			System.out.println(">> Xuất Thông Tin Của Nhóm <<");
			System.out.println("+---------------------------+");
			System.out.println("|1. Giảng viên              |");
			System.out.println("|2. Nhân viên hành chính    |");
			System.out.println("+---------------------------+");
			System.out.print("Mời Bạn Chọn: ");
			M = n.nextInt();
			if (M == 1 ||M == 2)
				break;
		}
		
		if (M == 1) {
			/*
			String K = "";
			System.out.print("Bạn muốn thông tin giảng viên thuộc khoa: ");
			myInput.nextLine();
			K = myInput.nextLine();
			*/
			
			int KH = 0;
			for (;;) {
				System.out.println(">> Giảng Viên Thuộc Khoa <<");
				System.out.println("+------------------------+");
				System.out.println("|1. Toán                 |");
				System.out.println("|2. Lý                   |");
				System.out.println("|3. Hóa                  |");
				System.out.println("|4. Sinh                 |");
				System.out.println("|5. Văn                  |");
				System.out.println("|6. Sử                   |");
				System.out.println("|7. Địa                  |");
				System.out.println("|8. Ngoại Ngữ            |");
				System.out.println("|9. Năng Khiếu           |");
				System.out.println("+------------------------+");
				System.out.print("Mời Bạn Chọn: ");
				KH = n.nextInt();
				if (KH == 1 || KH == 2 || KH == 3 || KH == 4 || KH == 5 || KH == 6 || KH == 7 || KH == 8 || KH == 9)
					break;
			}
			String K = null;
			if(KH == 1) {
				K = "Toán";
			} else if(KH == 2) {
				K = "Lý";
			} else if (KH == 3) {
				K = "Hóa";
			}else if (KH == 4) {
				K = "Sinh";
			}else if (KH == 5) {
				K = "Văn";
			}else if (KH == 6) {
				K = "Sử";
			}else if (KH == 7) {
				K = "Địa";
			}else if (KH == 8) {
				K = "Ngoại Ngữ";
			}else if (KH == 9) {
				K = "Năng Khiếu";
			}
			
			System.out.println("--------------------------------------------------");
			System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
					"Khoa", "Trình Độ", "Phụ Cấp", "Số Tiết Dạy", "Hệ số Lương", "Lương Được Nhận");
			System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < dsNhanVien.size(); i++) {
				if (K.equals(((GiangVien) dsNhanVien.get(i)).getKhoa())) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", (i+1),
							((GiangVien) dsNhanVien.get(i)).getTen(),
							((GiangVien) dsNhanVien.get(i)).getKhoa(),
							((GiangVien) dsNhanVien.get(i)).getTrinhDo(),
							((GiangVien) dsNhanVien.get(i)).getPhuCap(),
							((GiangVien) dsNhanVien.get(i)).getsoTietDayTrongThang(),
							((GiangVien) dsNhanVien.get(i)).getHeSoLuong(),
							((GiangVien) dsNhanVien.get(i)).tinhLuong()
							);
					System.out.println();
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
				}	
			}
		} else if (M == 2) {
			/*
			String P = "";
			System.out.print("Bạn muốn thông tin giảng viên thuộc phòng: ");
			myInput.nextLine();
			P = myInput.nextLine();
			*/
			
			int PB = 0;
			for (;;) {
				System.out.println(">> Nhân Viên Thuộc Phòng <<");
				System.out.println("+-------------------------+");
				System.out.println("|1. Nhân Sự               |");
				System.out.println("|2. Kế Toán               |");
				System.out.println("|3. Quản Lý Sinh Viên     |");
				System.out.println("+-------------------------+");
				System.out.print("Mời Bạn Chọn: ");
				PB = n.nextInt();
				if (PB == 1 || PB == 2 || PB == 3)
					break;
			}
			String P = null;
			if(PB == 1) {
				P = "Nhân Sự";
			} else if(PB == 2) {
				P = "Kế Toán";
			} else if (PB == 3) {
				P = "Quản Lý Sinh Viên";
			}
			
			System.out.println("--------------------------------------------------");
			System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
					"Phòng Ban", "Chức Vụ", "Phụ Cấp", "Số Ngày Công", "Hệ số Lương", "Lương Được Nhận");
			System.out.println("\n -----------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < dsNhanVien.size(); i++) {
				if (P.equals(((NhanVienHanhChinh) dsNhanVien.get(i)).getPhongBan())) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s ", (i+1),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getTen(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getPhongBan(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getChucVu(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getPhuCap(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getSoNgayCong(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).getHeSoLuong(),
							((NhanVienHanhChinh) dsNhanVien.get(i)).tinhLuong()
							);
					System.out.println();
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
				}
			}
		}
	}

	public static void tongLuong() {
		double tongtien = 0;
		for (int i = 0; i < dsNhanVien.size(); i++) {
			tongtien += dsNhanVien.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}
	
	public static void sapXep() {
		int i = 0;
		Collections.sort(dsNhanVien, SVComparator.NhanVienLuongASComparator);

		System.out.println("-------------------------------------------------------------------DANH SÁCH CÁN BỘ-------------------------------------------------------------------------");
		System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
				"Khoa", "Phòng Ban", "Trình Độ", "Chức Vụ", "Số Tiết Dạy", "Số Ngày Công", "Hệ số Lương",
				"Lương Được Nhận\n");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (NhanVien o : dsNhanVien) {
			if (o instanceof GiangVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i+1),
						((GiangVien) o).getTen(), ((GiangVien) o).getKhoa(), "x", ((GiangVien) o).getTrinhDo(),
						"x", ((GiangVien) o).getsoTietDayTrongThang(), "x", ((GiangVien) o).getHeSoLuong(),
						((GiangVien) o).tinhLuong() + "\n");
			} else {
				if (o instanceof NhanVienHanhChinh) {
					System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (i+1),
							((NhanVienHanhChinh) o).getTen(), "x ", ((NhanVienHanhChinh) o).getPhongBan(), "x",
							((NhanVienHanhChinh) o).getChucVu(), "x", ((NhanVienHanhChinh) o).getSoNgayCong(),
							((NhanVienHanhChinh) o).getHeSoLuong(), ((NhanVienHanhChinh) o).tinhLuong() + "\n");
				}
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}
}
