package qlsv.main;

import java.util.ArrayList;
import java.util.Scanner;

import qlsv.entity.*;

public class CTQLSVFTSE1704 {
	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static Scanner myInput=new Scanner(System.in);
	public CTQLSVFTSE1704() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+-------------------------------------------+");
			System.out.println("|1.Nhập danh sách sinh viên                 |");
			System.out.println("|2.Xuất thông tin danh sách sinh viên       |");
			System.out.println("|3.Xuất danh sách sinh viên có học lực giỏi |");
			System.out.println("|4.Sắp xếp danh sách sinh viên theo điểm    |");
			System.out.println("|5.Xóa 1 Sinh Viên                          |");
			System.out.println("|6.Kết Thúc                                 |");
			System.out.println("+-------------------------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			N = myInput.nextInt();
			if (N == 1) {
				NhapDanhsachSV();
			} else if (N == 2) {
				XuatTTSinhVien();
			} else if (N == 3) {
				DSSinhVienHLGioi();
			} else if (N == 4) {
				DSSinhVienTheoDiem();
			} else if (N == 5) {
				XoaMotSinhVien();
			}/*else if (N == 6) {
				XoaBienLaiKH();
			}*/ else {
				System.exit(0);
			}
		}
	}
	public static void NhapDanhsachSV() {
		Scanner myInput = new Scanner(System.in);
		System.out.println("Bạn muốn nhập danh sách sinh viên nào:");
		System.out.println("|1.Nhập danh sách sinh viên                 |");
		System.out.println("|2.Xuất thông tin danh sách sinh viên       |");
		System.out.println("|3.Xuất danh sách sinh viên có học lực giỏi |");
		
		int M = myInput.nextInt();
		if(M==1) {
			System.out.println(">> Sinh viên Dài hạn");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng sinh viên");
			int X=myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Mời bạn nhập sinh vien thứ"+(i+1)+": ");
				System.out.println("Mời bạn nhập họ sinh viên:");
				myInput.nextLine();
				String hoSV = myInput.nextLine();
				System.out.println("Mời bạn nhập tên sinh viên:");
				String tenSV = myInput.nextLine();
				
				System.out.println("Mời bạn nhập năm sinh sinh viên:");
				int namSinh = myInput.nextInt();
				System.out.println("Mời bạn nhập địa chỉ sinh viên:");
				myInput.nextLine();
				String diaChi = myInput.nextLine();
				
				System.out.println("Mời bạn nhập diểm LP0 sinh viên:");
				double diemLP0 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP1 sinh viên:");
				double diemLP1 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP2 sinh viên:");
				double diemLP2 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP3 sinh viên:");
				double diemLP3 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP4 sinh viên:");
				double diemLP4 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP5 sinh viên:");
				double diemLP5 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP6 sinh viên:");
				double diemLP6 = myInput.nextInt();
				dsSinhVien.add(new SinhVienDaiHan(hoSV,tenSV,namSinh,diaChi,diemLP0,
						diemLP1,diemLP2,diemLP3,
						diemLP4,diemLP5,diemLP6));
				
				
			}
			
		}
		else if(M==2) {
			System.out.println(">> Sinh viên Java cấp tốc");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng sinh viên");
			int X=myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Mời bạn nhập sinh vien thứ"+(i+1)+": ");
				System.out.println("Mời bạn nhập họ sinh viên:");
				myInput.nextLine();
				String hoSV = myInput.nextLine();
				System.out.println("Mời bạn nhập tên sinh viên:");
				String tenSV = myInput.nextLine();
				
				System.out.println("Mời bạn nhập năm sinh sinh viên:");
				int namSinh = myInput.nextInt();
				System.out.println("Mời bạn nhập địa chỉ sinh viên:");
				myInput.nextLine();
				String diaChi = myInput.nextLine();
				System.out.println("Mời bạn nhập diểm LP2 sinh viên:");
				double diemLP2 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP3 sinh viên:");
				double diemLP3 = myInput.nextInt();
				dsSinhVien.add(new SinhVienJavaCapToc(hoSV,tenSV,namSinh,diaChi,diemLP2,diemLP3));
			}
		}
		else if(M==3) {
			System.out.println(">> Sinh viên Web cấp tốc");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng sinh viên");
			int X=myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.println("Mời bạn nhập sinh vien thứ"+(i+1)+": ");
				System.out.println("Mời bạn nhập họ sinh viên:");
				myInput.nextLine();
				String hoSV = myInput.nextLine();
				System.out.println("Mời bạn nhập tên sinh viên:");
				String tenSV = myInput.nextLine();
				
				System.out.println("Mời bạn nhập năm sinh sinh viên:");
				int namSinh = myInput.nextInt();
				System.out.println("Mời bạn nhập địa chỉ sinh viên:");
				myInput.nextLine();
				String diaChi = myInput.nextLine();
				System.out.println("Mời bạn nhập diểm LP4 sinh viên:");
				double diemLP4 = myInput.nextInt();
				System.out.println("Mời bạn nhập diểm LP5 sinh viên:");
				double diemLP5 = myInput.nextInt();
				dsSinhVien.add(new SinhVienWebCapToc(hoSV,tenSV,namSinh,diaChi,diemLP4,diemLP5));
			}
		}
		else {
			System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
		}
		
	}
	public static void XuatTTSinhVien() {
		int i =0;
		String msg = "";
		for(SinhVien o : dsSinhVien) {
			if(o instanceof SinhVienDaiHan) {
				
			}
		}
	}
	
	}


