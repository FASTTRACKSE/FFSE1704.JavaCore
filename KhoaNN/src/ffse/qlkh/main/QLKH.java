package ffse.qlkh.main;

import java.util.ArrayList;
import java.util.Scanner;

import ffse.qlkh.dao.KhachHangDAO;
import ffse.qlkh.entity.KhachHang;
import ffse.quanlithongtin.util.CBException;


public class QLKH {
	static int N;
	static String maKH, tenKH, diaChi, namSinh, gioiTinh, soDT;
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner myInput = new Scanner(System.in);
	private static boolean inputOK;

	public static void main(String[] args) {

		while (true) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				
				System.out.println("|1.Kết Nối Database         |");
				System.out.println("|2.In Danh Sách Database    |");
				System.out.println("|3.Thêm Thông Tin Khách Hàng|");
				System.out.println("|4.Xóa Khách Hàng           |");
				System.out.println("|5.Sửa Khách Hàng           |");
				N = myInput.nextInt();
				if (N == 1) {

					KetNoiDatabase();
				}else if (N == 2) {

					InDanhSachDatabase();
				}else if (N == 3) {

					NhapThongTin();
				}else if (N == 4) {

					XoaKH();
				}else if (N == 5) {

					SuaKH();
				}  else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 5, nhập lại!");
			} 
		}
	
	}
	
	private static void SuaKH() {
		int N = 0;
		boolean inputOK;
		System.out.println("Mời Bạn Nhập ID cần Sửa");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new CBException(1);
			}
		} catch (CBException e) {
			System.out.println(e);
		}
		
		do {
			try {
				inputOK = true;
				System.out.print("Nhập mã khách hàng: ");
				maKH = myInput.nextLine();

				if (maKH.length() < 1 || maKH.length() > 40) {
					// bẵn lỗi
					throw new CBException(2);
				}
			} catch (CBException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);
		
		do {

			try {
				inputOK = true;
				System.out.println("Mời Bạn Nhập Tên Khách Hàng!!!");
				myInput.nextLine();
				tenKH = myInput.nextLine();
				if (tenKH.length() > 0 && tenKH.length() < 51) {
					System.out.println("Sửa Tên Khách Hàng Oke : " + tenKH);
				} else {
					throw new CBException(7);
				}
			} catch (CBException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		
		do {

			try {
				inputOK = true;
				System.out.print("Nhập địa chỉ Khách Hàng: ");
				diaChi = myInput.nextLine();
				if (diaChi.length() < 1 || diaChi.length() > 30) {
					System.out.println("Sửa Địa Chỉ Khách Hàng : " + diaChi);
					throw new CBException(7);
				}
			} catch (CBException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		
		do {

			try {
				inputOK = true;
				System.out.println("m?i B?n nh?p nam sinh KH. Theo Th? t? YY/MM/DD");
				namSinh = myInput.nextLine();
				if (namSinh.length() > 0) {
					System.out.println(" Sửa Nhập Năm Sinh  " + namSinh);
				} else {
					throw new CBException(3);
				}
			} catch (CBException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		
		do {

			try {
				inputOK = true;
				System.out.println("Mời Bạn Nhập Giới Tính ");
				gioiTinh = myInput.nextLine();
				if (gioiTinh.length() > 0 && gioiTinh.length() <= 5) {
					System.out.println("Sửa Giới Tính  : " + gioiTinh);
				} else {
					throw new CBException(3);
				}
			} catch (CBException e) {

				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);
		
		do {
			try {
				myInput.nextLine();
				inputOK = true;
				System.out.print("Nh?p s? di?n tho?i khách hàng: ");
				soDT = myInput.nextLine();

				if (soDT.length() < 1 || soDT.length() > 11) {
					System.out.println(" Sửa Ngày Sinh  " + namSinh);
					throw new CBException(8);
				}
			} catch (CBException e) {
				System.err.println(e);
				myInput.nextLine();
				inputOK = false;
			}
		} while (!inputOK);

		KhachHang kh = new KhachHang(N, maKH, tenKH, diaChi, namSinh, gioiTinh, soDT );
		khachHangDAO.edit(kh);

		
	}

	private static void XoaKH() {
		int N = 0;
		System.out.println("Mời Bạn Nhập ID cần XÓa");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn ID: " + N);
			} else {
				throw new CBException(1);
			}
		} catch (CBException e) {
			System.out.println(e);
		}
		khachHangDAO.delete(N);
		
	}

	private static void NhapThongTin() {
		int N = 0;
		System.out.println("Mời bạn nhập số lượng cần nhập");
		N = myInput.nextInt();
		try {
			if (N > 0) {
				System.out.println("Bạn Đã Chọn " + N + " Số Lượng");
			} else {
				throw new CBException(6);
			}
		} catch (CBException e) {
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
						System.out.println("Nhập Mã Khách Hàng  " + maKH);
					} else {
						throw new CBException(6);
					}
				} catch (CBException e) {

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
						System.out.println("Nhập Tên  " + tenKH);
					} else {
						throw new CBException(7);
					}
				} catch (CBException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("Mời Bạn Nhập ĐỊa CHỉ !");
					diaChi = myInput.nextLine();
					if (diaChi.length() > 0 && diaChi.length() < 51) {
						System.out.println("Nhập Địa Chỉ  " + diaChi);
					} else {
						throw new CBException(7);
					}
				} catch (CBException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("mời Bạn nhập năm sinh KH. Theo Thứ tự YY/MM/DD");
					namSinh = myInput.nextLine();
					if (namSinh.length() > 0) {
						System.out.println("Nhập Năm Sinh  " + namSinh);
					} else {
						throw new CBException(3);
					}
				} catch (CBException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);

			do {

				try {
					inputOK = true;
					System.out.println("Mời Bạn Nhập Giới Tính ");
					gioiTinh = myInput.nextLine();
					if (gioiTinh.length() > 0 && gioiTinh.length() <= 5) {
						System.out.println("Nhập Giới Tính  : " + gioiTinh);
					} else {
						throw new CBException(3);
					}
				} catch (CBException e) {

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
						System.out.println("Nhập Số Điện Thoại : " + soDT);
					} else {
						throw new CBException(8);
					}
				} catch (CBException e) {

					System.err.println(e);
					myInput.nextLine();
					inputOK = false;
				}
			} while (!inputOK);
			KhachHang kh = new KhachHang(maKH, tenKH, diaChi, namSinh, gioiTinh, soDT);
			khachHangDAO.add(kh);

		}
	}

	private static void InDanhSachDatabase() {
		dsKH = khachHangDAO.getDSKhachHang();
		for (KhachHang x : dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH() + "-" + x.getDiaChi() 
			+ "-" + x.getGioiTinh() + "-" + x.getNgaySinh() + "-" + x.getSoDT());
		}
		
	}

	private static void KetNoiDatabase() {
		khachHangDAO.getConnect("localhost", "ffse1702", "khoa2311", "ngockhoa2311");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		
		
	}
	private static void backToMainMenu() {
		// TODO Auto-generated method stub
		
	}
	

}
