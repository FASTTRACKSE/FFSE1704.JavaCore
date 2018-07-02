package ffse.qlkh.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import ffse.qlkh.dao.KhachHangDAO;
import ffse.qlkh.entity.KhachHang;
import ffse.qlkh.util.CBException;


public class QLKH {
	static int N;
	static Scanner myInput = new Scanner(System.in);
	
	static KhachHangDAO khachHangDAO = new KhachHangDAO();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		khachHangDAO.getConnect("localhost", "ffse1704002", "mido", "0933237480");
		if (khachHangDAO.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
		
		int myMain = 0;
		boolean inputOK;
		while (true) {
			try {
				System.out.println();
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+-----------------------------------------------------+");
				System.out.println("|1. Danh sách khách hàng                              |");
				System.out.println("|2. Thêm khách hàng mới                               |");
				System.out.println("|3. Xem khách hàng                                    |");
				System.out.println("|4. Sữa thông tin khách hàng                          |");
				System.out.println("|5. Delete khách hàng                                 |");
				System.out.println("|6. Kết Thúc                                          |");
				System.out.println("+-----------------------------------------------------+");
				System.out.print("Mời Bạn Chọn Chức Năng: ");
				try {
					inputOK = true;
					myMain = myInput.nextInt();
					if (myMain < 0 || myMain > 6 ) {
						throw new CBException(4);
					}
				} catch (CBException e) {
					System.err.println(e);
					inputOK = true;
				}
			} catch (Exception e) {
				System.err.println("\nLổi lựa chọn \nChỉ nhập số từ 1 đến 6!" );
				myInput.next();
			} 
			if (myMain == 1) {
				DanhSachKhachHang();
			} else if (myMain == 2) {
				AddKhachHang();
			} else if (myMain == 3) {
				ReadKhachHang();
			} else if (myMain == 4) {
				UpdateKhachHang();
			} else if (myMain == 5) {
				DeleteKhachHang(); 
			} else if (myMain == 6){
				System.exit(0);
			}
		}
	}

	public static void DanhSachKhachHang() {
		dsKH = khachHangDAO.getDSKhachHang();
		for (KhachHang x: dsKH) {
			System.out.println(x.getID() + " _ " + x.getMaKH() + " _ " + x.getTenKH());
		}
	}
	
	public static void AddKhachHang() {
		String maKH = "";
		String tenKH = "";
		String diaChi = "";
		String ngaySinh = "";
		String gioiTinh = "";
		String soDT = "";
		boolean inputOK;
		System.out.println("\nNhập Thông Tin Khách Hàng ");
		System.out.println("+------------------------------+");
		System.out.print("\nNhập số lượng khách hàng cần thêm: ");
		N = myInput.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.print("Nhập thông tin khách hàng thứ " + (i + 1) + "\n");
			myInput.nextLine();
			
			do {
				System.out.print("Nhập mã số khách hàng (Bắc đầu bằng KH): ");
				try {
					inputOK = true;
					maKH = myInput.nextLine();
					if (maKH.length() < 1 ) {
						throw new CBException(1);
					}
				} catch (CBException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);
			
			do {
				System.out.print("Nhập họ tên khách hàng: ");
				try {
					inputOK = true;
					tenKH = myInput.nextLine();
					if (tenKH.length() < 1 || tenKH.length() > 40) {
						throw new CBException(2);
					}
				} catch (CBException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);	
			
			do {
				System.out.print("Nhập địa chỉ khách hàng: ");
				try {
					inputOK = true;
					diaChi = myInput.nextLine();
					if (diaChi.length() < 1 || diaChi.length() > 40) {
						throw new CBException(2);
					}
				} catch (CBException e) {
					System.err.println(e);
					inputOK = false;
				}
			} while (!inputOK);	
				
			System.out.print("Nhập ngày sinh khách hàng (yyyy-mm-dd): ");
			ngaySinh = myInput.nextLine();
			
			System.out.print("Nhập giới tính khách hàng: ");
			gioiTinh = myInput.nextLine();
			
			System.out.print("Nhập số điện thoại khách hàng: ");
			soDT = myInput.nextLine();
		}
		khachHangDAO.add(new KhachHang((N + 1), maKH, tenKH, diaChi, ngaySinh, gioiTinh, soDT));
	}
	
	public static void ReadKhachHang() {
		String idKH = "";
		System.out.print("Nhập mã khách hàng cần xem (mã khách hàng dạng KH + số): ");
		myInput.nextLine();
		idKH = myInput.nextLine();
		KhachHang khachHangThanYeu = khachHangDAO.read(idKH);
		System.out.println(khachHangThanYeu.getID() + " _ " + khachHangThanYeu.getMaKH() 
					+ " _ " + khachHangThanYeu.getTenKH() + " _ " + khachHangThanYeu.getDiaChi()
					+ " _ " + khachHangThanYeu.getNgaySinh() + " _ " + khachHangThanYeu.getGioiTinh()
					+ " _ " + khachHangThanYeu.getSoDT());
	}
	
	public static void UpdateKhachHang() {
		String maKH = "";
		String tenKH = "";
		String diaChi = "";
		String ngaySinh = "";
		String gioiTinh = "";
		String soDT = "";
		boolean inputOK;
		String idKH = "";
		System.out.print("Nhập mã khách hàng cần sửa (mã khách hàng dạng KH + số): ");
		myInput.nextLine();
		idKH = myInput.nextLine();
		KhachHang khachHangThanYeu = khachHangDAO.read(idKH);
		System.out.println(khachHangThanYeu.getID() + " _ " + khachHangThanYeu.getMaKH() 
					+ " _ " + khachHangThanYeu.getTenKH() + " _ " + khachHangThanYeu.getDiaChi()
					+ " _ " + khachHangThanYeu.getNgaySinh() + " _ " + khachHangThanYeu.getGioiTinh()
					+ " _ " + khachHangThanYeu.getSoDT());
		System.out.println("----------------------------------------");
		System.out.println("Mời bạn nhập thông tin mới cửa khách hàng !");
		do {
			System.out.print("Nhập mã số khách hàng (Bắc đầu bằng KH): ");
			try {
				inputOK = true;
				maKH = myInput.nextLine();
				if (maKH.length() < 1 ) {
					throw new CBException(1);
				}
			} catch (CBException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);
		
		do {
			System.out.print("Nhập họ tên khách hàng: ");
			try {
				inputOK = true;
				tenKH = myInput.nextLine();
				if (tenKH.length() < 1 || tenKH.length() > 40) {
					throw new CBException(2);
				}
			} catch (CBException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);	
		
		do {
			System.out.print("Nhập địa chỉ khách hàng: ");
			try {
				inputOK = true;
				diaChi = myInput.nextLine();
				if (diaChi.length() < 1 || diaChi.length() > 40) {
					throw new CBException(2);
				}
			} catch (CBException e) {
				System.err.println(e);
				inputOK = false;
			}
		} while (!inputOK);	
			
		System.out.print("Nhập ngày sinh khách hàng (yyyy-mm-dd): ");
		ngaySinh = myInput.nextLine();
		
		System.out.print("Nhập giới tính khách hàng: ");
		gioiTinh = myInput.nextLine();
		
		System.out.print("Nhập số điện thoại khách hàng: ");
		soDT = myInput.nextLine();
		
		khachHangDAO.edit(new KhachHang((N + 1), maKH, tenKH, diaChi, ngaySinh, gioiTinh, soDT), idKH);
	}
	
	public static void DeleteKhachHang() {
		String idKH = "";
		System.out.print("Nhập mã khách hàng cần Xóa (mã khách hàng dạng KH + số): ");
		myInput.nextLine();
		idKH = myInput.nextLine();
		KhachHang xoaKhachHang = khachHangDAO.delete(idKH);
		
		dsKH = khachHangDAO.getDSKhachHang();
		for (KhachHang x: dsKH) {
			System.out.println(x.getID() + "-" + x.getMaKH() + "-" + x.getTenKH());
		}
	}
	
	private static int nextLine() {
		// TODO Auto-generated method stub
		return 0;
	}
}