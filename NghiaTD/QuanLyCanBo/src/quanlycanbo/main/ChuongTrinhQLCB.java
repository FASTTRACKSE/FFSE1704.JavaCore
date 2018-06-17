package quanlycanbo.main;
import java.util.ArrayList;
import java.util.Scanner;


import quanlycanbo.entity.*;

public class ChuongTrinhQLCB {
	static int N;
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+-------------------------------------------+");
			System.out.println("|1.Nhập danh thông tin cán bộ                |");
			System.out.println("|2.Xuất danh sách thông tin cán bộ        |");
			System.out.println("|3.Xuất danh sách sinh viên có học lực giỏi |");
			System.out.println("|4.Sắp xếp danh sách sinh viên theo điểm    |");
			System.out.println("|5.Xóa 1 Sinh Viên                          |");
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
			}/*else if (N == 6) {
				XoaBienLaiKH();
			}*/ else {
				System.exit(0);
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
		if(M==1) {
			System.out.println(".Bạn đang nhập thông tin Giảng Viên ");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng Giảng Viên");
			int X = myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Nhập cán bộ Giảng viên thứ"+(i+1)+ "\n");
				System.out.println("Nhập họ tên của Giảng viên");
				myInput.nextLine();
				String hoTen = myInput.nextLine();
				
				System.out.println("Nhập hệ số lương Giảng viên");
				double heSoLuong = myInput.nextDouble();
				
				System.out.println("Chọn Phụ cấp cho giảng viên");
				System.out.println("|1.cử nhân 300.        |");
				System.out.println("|2.thạc sĩ 500.        |");
				System.out.println("|3.tiến sĩ 1000.       |");
				System.out.println("+--------------------------------------+");
				 int phuCap = myInput.nextInt();
				 
				 System.out.println("Nhập Khoa của Giảng Viên");
				 String khoa = myInput.nextLine();
				 
				 System.out.println("Nhập Trình độ Giảng Viên");
				 String trinhDo = myInput.nextLine();
				 System.out.println("Nhập số tiết dạy Giảng Viên");
				 int soTietDay = myInput.nextInt();
				 
				 dsCanBo.add(new GiangVien(hoTen,heSoLuong,phuCap,khoa,trinhDo,soTietDay));
				
				
				
			}
		}
		else if(M==2) {
			System.out.println(".Bạn đang nhập thông tin Cán Bộ Nhân Viên ");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng Nhân Viên");
			int X = myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Nhập cán bộ Giảng viên thứ"+(i+1)+ "\n");
				System.out.println("Nhập họ tên của Giảng viên");
				myInput.nextLine();
				String hoTen = myInput.nextLine();
				
				System.out.println("Nhập hệ số lương Giảng viên");
				double heSoLuong = myInput.nextDouble();
				System.out.println("Chọn Phụ cấp cho giảng viên");
				System.out.println("|1.trưởng phòng 2000    |");
				System.out.println("|2.phó phòng 1000.      |");
				System.out.println("|3.nhân viên 500.       |");
				System.out.println("+------------------------+");
				 int phuCap = myInput.nextInt();
				 
				 System.out.println("Nhập Phòng ban của Nhân Viên");
				 String phongBan = myInput.nextLine();
				 
				 System.out.println("Nhập Phòng ban của Nhân Viên");
				 int soNgayCong = myInput.nextInt();
				 
				 System.out.println("Chức vụ");
				 String chucVu = myInput.nextLine();
				 
				 dsCanBo.add(new NhanVien(hoTen,heSoLuong,phuCap,phongBan,soNgayCong,chucVu));
				 
				 
			}
		}
		else {
			System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
		}
	}
	public static void XuatTTCanBo() {
		int i=0;
		String msg= "";
		for(CanBo o : dsCanBo) {
			
		}
	}
	public static void TongSoLuongPhaiTra() {
		
	}
	public static void SapXepCanBo() {
		
	}
public static void KetThuc() {
		
	}
	

}
