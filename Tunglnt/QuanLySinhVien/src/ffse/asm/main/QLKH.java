package ffse.asm.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ffse.asm.dao.KhachHangDAO;
import ffse.asm.util.SinhVien;
import ffse.asm.util.myException;

public class QLKH {
	static int N;
	static String maKH, tenKH, diaChiKH, namSinhKH, gioiTinhKH, soDT;
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<SinhVien> dsKH = new ArrayList<SinhVien>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			try {

				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+---------------------------+");
				System.out.println("|1.Kết Nối DataBase         |");
				System.out.println("|2.In danh sách DataBase    |");
				System.out.println("|3. Thêm DS Khách Hàng      |");
				System.out.println("|4.XÓa Khách Hàng           |");
				System.out.println("|5.Sửa KH                   |");
				System.out.println("|6.Đọc KH                   |");
				System.out.println("|7.Kết Thúc CT              |");
				System.out.println("+---------------------------+");
				System.out.println("Mời Bạn Chọn Chức Năng");
				N = myInput.nextInt();
				if (N == 1) {
					KetNoiDB();
				} else if (N == 2) {
					InDSKH();
				} else if (N == 3) {
					ThemDsKH();
				} else if (N == 4) {
					XoaKH();
				} else if (N == 5) {
					EditKH();
				} else if (N == 6) {
					ReadKH();
				} else if (N == 7) {
					Exit();
				} else {
					throw new myException(2);
				}

			} catch (InputMismatchException e) {
				System.err.println("Vui Lòng Nhập Kiểu Số\n");
				myInput.next();
			} catch (myException e) {
				System.err.print(e);
				System.err.println("\n1 để nhập lại CT");
				myInput.nextInt();
			}
		}

	
	}

	public static void KetNoiDB() {
		khachHangDAO.getConnect("localhost", "sinhvien", "sinhvien", "sinhvien");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}

	public static void InDSKH() {
		dsKH = khachHangDAO.getDSSinhVien();
		for (SinhVien x : dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}
		/*for (int i=0; i<dsKH.size() ; i++) {
			System.out.println(dsKH.get(i).getID());
		}*/

	}

	public static void ThemDsKH() {
		int N = 0;
		System.out.println("Mời bạn nhập số lượng cần nhập!!");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn " + N + " Số Lượng");
			} else {
				throw new myException(6);
			}
		} catch (myException e) {
			System.out.println(e);
		}

		for (int i = 0; i < N; i++) {

			boolean inputOK;
			do {

				try {
					inputOK = true;
					myInput.nextLine();
					System.out.print("Nhập mã khách hàng: ");
					maKH = myInput.nextLine();
					if (maKH.length() > 0 && maKH.length() < 16) {
						System.out.println("Đã Nhập Mã Khách Hàng  : " + maKH);
					} else {
						throw new myException(6);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("Mời Bạn Nhập Tên Khách Hàng!!!");
					tenKH = myInput.nextLine();
					if (tenKH.length() > 0 && tenKH.length() < 51) {
						System.out.println("Đã Nhập Tên Khách Hàng  : " + tenKH);
					} else {
						throw new myException(7);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("Mời Bạn Nhập ĐỊa CHỉ Khách Hàng!!");
					diaChiKH = myInput.nextLine();
					if (diaChiKH.length() > 0 && diaChiKH.length() < 51) {
						System.out.println("Đã Nhập Địa Chỉ Khách Hàng : " + diaChiKH);
					} else {
						throw new myException(7);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("mời Bạn nhập năm sinh KH. Theo Thứ tự YY/MM/DD");
					namSinhKH = myInput.nextLine();
					if (namSinhKH.length() > 0) {
						System.out.println("Đã Nhập Năm Sinh Khách Hàng  : " + namSinhKH);
					} else {
						throw new myException(3);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("Mời Bạn Nhập Giới Tính!!!");
					gioiTinhKH = myInput.nextLine();
					if (gioiTinhKH.length() > 0 && gioiTinhKH.length() <= 5) {
						System.out.println("Đã Nhập Giới Tính Khách Hàng  : " + gioiTinhKH);
					} else {
						throw new myException(3);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {
				try {
					inputOK = true;
					System.out.println("Mời Bạn Nhập Số Điện Thoại");
					soDT = myInput.nextLine();
					if (soDT.length() >= 0 && soDT.length() <= 13) {
						System.out.println("Đã Nhập SDT Khách Hàng : " + soDT);
					} else {
						throw new myException(8);
					}
				} catch (myException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			SinhVien kh = new SinhVien(maKH, tenKH, diaChiKH, namSinhKH, gioiTinhKH, soDT);
			khachHangDAO.add(kh);

		}
	}

	public static void EditKH() {
		int N = 0;
		boolean inputOK;
		System.out.println("Mời Bạn Nhập ID cần Sửa");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new myException(1);
			}
		} catch (myException e) {
			System.out.println(e);
		}
		
		do {

			try {
				inputOK = true;
				System.out.println("Mời Bạn Nhập Tên Khách Hàng!!!");
				myInput.nextLine();
				tenKH = myInput.nextLine();
				if (tenKH.length() > 0 && tenKH.length() < 51) {
					System.out.println("Sửa Tên Khách Hàng Oke!! : " + tenKH);
				} else {
					throw new myException(7);
				}
			} catch (myException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		do {

			try {
				inputOK = true;
				System.out.println("mời Bạn nhập năm sinh KH. Theo Thứ tự YY/MM/DD");
				namSinhKH = myInput.nextLine();
				if (namSinhKH.length() > 0) {
					System.out.println("Nhập Năm Sinh Khách Hàng Oke!! : " + namSinhKH);
				} else {
					throw new myException(3);
				}
			} catch (myException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		SinhVien kh = new SinhVien(N, tenKH, namSinhKH);
		khachHangDAO.edit(kh);

	}

	public static void XoaKH() {
		int N = 0;
		System.out.println("Mời Bạn Nhập ID cần XÓa");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new myException(1);
			}
		} catch (myException e) {
			System.out.println(e);
		}
		khachHangDAO.delete(N);
	}

	public static void ReadKH() {
		int N = 0;
		System.out.println("Mời Bạn Nhập ID cần Xem");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new myException(1);
			}
		} catch (myException e) {
			System.out.println(e);
		}
		SinhVien khachHangID =khachHangDAO.read(N);
		System.out.println("ID : "+ khachHangID.getID()+  "- Tên KH: " + khachHangID.getTenKH()+"- Mã KH " +khachHangID.getMaKH() );
	}

	public static void Exit() {
		System.out.println("Chương Trình Đã Kết Thúc!!!");
		System.exit(0);
	}
}