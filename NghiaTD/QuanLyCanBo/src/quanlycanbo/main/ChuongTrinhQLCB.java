package quanlycanbo.main;
import java.util.ArrayList;
import java.util.Collections;
import quanlycanbo.util.CanBoComparator;
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
			System.out.println("|2.Xuất danh sách thông tin cán bộ          |");
			System.out.println("|3.Tổng số tiền mà nhà trường phải trả      |");
			System.out.println("|4.Sắp xếp danh sách Cán Bộ    |");
			System.out.println("|5.Xóa 1 Cán bộ                          |");
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
				
				
				 
				 System.out.println("Nhập Khoa của Giảng Viên");
				 myInput.nextLine();
				 String khoa = myInput.nextLine();
				 
				 System.out.println("Nhập Trình độ Giảng Viên");
				 String trinhDo = myInput.nextLine();
				 System.out.println("Nhập số tiết dạy Giảng Viên");
				 int soTietDay = myInput.nextInt();
				 
				 dsCanBo.add(new GiangVien(hoTen,heSoLuong,khoa,trinhDo,soTietDay));
				
				
				
			}
		}
		else if(M==2) {
			System.out.println(".Bạn đang nhập thông tin Cán Bộ Nhân Viên ");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng Nhân viên");
			int X = myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Nhập cán bộ Nhân viên thứ"+(i+1)+ "\n");
				System.out.println("Nhập họ tên của Nhân viên");
				myInput.nextLine();
				String hoTen = myInput.nextLine();
				
				System.out.println("Nhập hệ số lương Nhân viên");
				double heSoLuong = myInput.nextDouble();
				System.out.println(" Phòng ban Nhân viên");
			
				  myInput.nextLine();
				 String phongBan = myInput.nextLine();
				 
				 System.out.println("Nhập Số ngày công của Nhân Viên");
				 int soNgayCong = myInput.nextInt();
				 
				 System.out.println("Chức vụ");
				 myInput.nextLine();
				 String chucVu = myInput.nextLine();
				 
				 dsCanBo.add(new NhanVien(hoTen,heSoLuong, phongBan,soNgayCong,chucVu));
				 
				 
			}
		}
		else {
			System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
		}
	}
	public static void XuatTTCanBo() {
		
		String M= "";
		System.out.println("Bạn muốn xuất thông tin thuộc khoa hay phòng ban nào đây?");
		myInput.nextLine();
		M = myInput.nextLine();
		for(int i=0; i<dsCanBo.size();i++) {
			if(dsCanBo.get(i) instanceof GiangVien) {
				if(M.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {
					System.out.println("Giảng viên thứ:"+(i+1)+
				":\n Họ tên giảng viên:"+((GiangVien) dsCanBo.get(i)).getHoTen()
				+"\n - Hệ số lương: "+((GiangVien) dsCanBo.get(i)).getHeSoLuong()
				+"\n - Khoa: "+((GiangVien) dsCanBo.get(i)).getKhoa()
				+"\n - Trình độ: "+((GiangVien) dsCanBo.get(i)).getTrinhDo()
				+"\n - Khoa: "+((GiangVien) dsCanBo.get(i)).getKhoa()
				+"\n - Lương : "+((GiangVien) dsCanBo.get(i)).tinhLuong()+" VNĐ");	
				}
			}
			if(dsCanBo.get(i) instanceof NhanVien) {
				if(M.equals(((NhanVien) dsCanBo.get(i)).getPhongBan())) {
				System.out.println("Nhân viên thứ:"+(i+1)+
			    ":\n Họ tên giảng viên:"+((NhanVien) dsCanBo.get(i)).getHoTen()
				+"\n - Hệ số lương: "+((NhanVien) dsCanBo.get(i)).getHeSoLuong()
				+"\n - Phòng ban: "+((NhanVien) dsCanBo.get(i)).getPhongBan()
				+"\n - Số ngày công: "+((NhanVien) dsCanBo.get(i)).getSoNgayCong()
				+"\n - Chức vụ: "+((NhanVien) dsCanBo.get(i)).getChucVu()
				+"\n - Lương : "+((NhanVien) dsCanBo.get(i)).tinhLuong()+" VNĐ");				
				}
			}
		}
	}
	public static void TongSoLuongPhaiTra() {
		double tongtien = 0;
		for(int i = 0;i<dsCanBo.size();i++) {
			tongtien+= dsCanBo.get(i).tinhLuong();
		}
		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}
	public static void SapXepCanBo() {
		int i =0;
		Collections.sort(dsCanBo, CanBoComparator.CanBoLuongASComparator);
		System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ","STT","Họ tên",
				"Hệ số lương","khoa", "Phòng ban","Trình độ","chức vụ","Số Tiết Dạy","Số ngày công","lương được nhận\n");
		System.out.println("");
		System.out.println(
				"-------------------------------	------------------------------------*******************-------------------------------------------------------------------------");
		for(CanBo o : dsCanBo) {
			if(o instanceof GiangVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ",
						(i++),((GiangVien) o).getHoTen()+ " " +((GiangVien) o).getHeSoLuong()+((GiangVien) o).getKhoa()+"x"
						+((GiangVien) o).getTrinhDo()+"x"+((GiangVien) o).getSoTietDay()+"X"
						+((GiangVien) o).tinhLuong()+"\n");
			}
			else if(o instanceof NhanVien) {
				System.out.printf("\n" + "%-10s %-10s %-15s %-15s  %-15s  %-15s %-15s %-15s %-15s %-15s ", 
						(i++),((NhanVien) o).getHoTen()+((NhanVien) o).getHeSoLuong()+"x"+((NhanVien) o).getPhongBan()+"X"
						+((NhanVien) o).getChucVu()+"X"+((NhanVien) o).getSoNgayCong()
						+((NhanVien) o).tinhLuong()+"\n");
			}
		}
		System.out.println("");
		System.out.println(
				"-------------------------------------------------------------------*******************-------------------------------------------------------------------------");

	}

	
public static void KetThuc() {
		
	}
	

}
