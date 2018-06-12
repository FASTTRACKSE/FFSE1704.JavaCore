package QLSVFACTTRACKSE.src.ffse1704.main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import QLSVFACTTRACKSE.src.ffse1704.entity.*;
public class ChuongTrinhQLSVFASTTRACKSE {
	static int N;
	static ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	
	
	static Scanner myInput = new Scanner(System.in);
	public ChuongTrinhQLSVFASTTRACKSE() {
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
		System.out.println(">> Sinh viên thuộc chương trình nào <<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Sinh viên dài hạn                   |");
		System.out.println("|2.Sinh viên web cấp tốc               |");
		System.out.println("|3.Sinh viên java cấp tốc             |");
		System.out.println("+--------------------------------------+");
		int M = myInput.nextInt();
		if(M==1) {
			System.out.println(">> Sinh viên Dài hạn");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng sinh viên");
			int X =myInput.nextInt();
			for(int i=0;i<X;i++) {
				
				System.out.println("Nhập sinh viên thứ"+(i+1)+ "\n");
				System.out.println("Nhập họ sinh viên");
				myInput.nextLine();
				String hoSV = myInput.nextLine();
				
				System.out.println("Nhập tên sinh viên");
				String tenSV = myInput.nextLine();
				
				System.out.println("Nhập năm sinh Sinh Viên");
				int namSinh = myInput.nextInt();
				
				System.out.println("Nhập địa chỉ");
				myInput.nextLine();
				String diaChi = myInput.nextLine();
				
				System.out.print("Nhập điểm LP0: ");
				double diemLP0 = myInput.nextInt();
				System.out.print("Nhập năm LP1: ");
				double diemLP1 = myInput.nextInt();
				System.out.print("Nhập năm LP2: ");
				double diemLP2 = myInput.nextInt();
				System.out.print("Nhập năm LP3: ");
				double diemLP3 = myInput.nextInt();
				System.out.print("Nhập năm LP4: ");
				double diemLP4 = myInput.nextInt();
				System.out.print("Nhập năm LP5: ");
				double diemLP5 = myInput.nextInt();
				System.out.print("Nhập năm LP6: ");
				double diemLP6 = myInput.nextInt();
				
				System.out.println("-------------------------------");
				dsSinhVien.add(new SinhVienDaiHan(hoSV, tenSV, namSinh, diaChi, diemLP0, diemLP1, diemLP2, diemLP3,
						diemLP4, diemLP5, diemLP6));
				
				
			}
		}
		else if(M==2) {
			System.out.println("Nhập thông tin Sinh Viên Web Cấp Tốc");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			int X =myInput.nextInt();
			for(int i=0;i<X;i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				myInput.nextLine();
				
				System.out.print("Nhập Họ sinh viên: ");
				String hoSV = myInput.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSV = myInput.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = myInput.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.print("Nhập năm LP2: ");
				double diemLP2 = myInput.nextInt();
				System.out.print("Nhập năm LP3: ");
				double diemLP3 = myInput.nextInt();
				System.out.println("------------------------------------------------------------------");
				dsSinhVien.add(new SinhVienJavaCapToc(hoSV, tenSV, namSinh, diaChi, diemLP2, diemLP3));
			}
		}
		else if(M==3) {
			System.out.println("Nhập thông tin Sinh Viên Java Cấp Tốc");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Sinh viên: ");
			N = myInput.nextInt();
			for(int i=0;i<N;i++) {
				System.out.print("Nhập Thông Tin sinh viên thứ " + (i + 1) + "\n");
				myInput.nextLine();
				
				System.out.print("Nhập Họ sinh viên: ");
				String hoSV = myInput.nextLine();

				System.out.print("Nhập tên sinh viên: ");
				String tenSV = myInput.nextLine();

				System.out.print("Nhập năm sinh sinh viên: ");
				int namSinh = myInput.nextInt();

				System.out.print("Nhập địa chỉ sinh viên: ");
				myInput.nextLine();
				String diaChi = myInput.nextLine();

				System.out.print("Nhập năm LP4: ");
				double diemLP4 = myInput.nextInt();
				System.out.print("Nhập năm LP5: ");
				double diemLP5 = myInput.nextInt();
				System.out.println("------------------------------------------------------------------");
				
				dsSinhVien.add(new SinhVienWebCapToc(hoSV, tenSV, namSinh, diaChi, diemLP4, diemLP5));
			}
		} else {
			System.out.println("BẠN CHỈ ĐƯỢC NHẬP TỪ 1 ĐẾN 3. HÃY NHẬP LẠI !!!");
		}
	}
	public static void XuatTTSinhVien() {
		int i=0;
		String msg= "";
		for(SinhVien o : dsSinhVien) {
			msg = "**** Sinh Viên Dài Hạn ***** \n";
			if(o instanceof SinhVienDaiHan) {
				System.out.println("Sinh viên thứ "+(i+1)+msg+":\n Họ Sinh Viên"+((SinhVienDaiHan) o).getHoSV()+"\n - Tên Sinh Viên: "+((SinhVienDaiHan) o).getTenSV()
						+"--Năm sinh: "+((SinhVienDaiHan) o).getNamSinh()+"--Địa chỉ: "+((SinhVienDaiHan) o).getDiaChi()+ " - Điểm LP0: "+((SinhVienDaiHan) o).getDiemLP0()+
						"\n - Điểm LP1: "+((SinhVienDaiHan) o).getDiemLP1()+"\n - Điểm LP2: "+((SinhVienDaiHan) o).getDiemLP2()+"\n - Điểm LP3: "+((SinhVienDaiHan) o).getDiemLP3()+"\n - Điểm LP4: "+((SinhVienDaiHan) o).getDiemLP4()+
						"\n - Điểm LP5: "+((SinhVienDaiHan) o).getDiemLP5()+"\n - Điểm LP6: "+((SinhVienDaiHan) o).getDiemLP6()+"\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiHocLuc());
			}
		
		
		
		
		else {	if(o instanceof SinhVienWebCapToc) {
			msg = "**** Sinh Viên Web Cấp Tốc ***** \n";
			System.out
			.println("Sinh Viên  Thứ " + (++i) +msg+ ":\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoSV()
					+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
					+ ((SinhVienWebCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
					+ ((SinhVienWebCapToc) o).getDiaChi() + "\n - Điểm LP2: "
					+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
					+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
					+ ((SinhVienWebCapToc) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: "
					+ ((SinhVienWebCapToc) o).xepLoaiHocLuc());
		}
		else {
			if(o instanceof SinhVienJavaCapToc){
				msg = "**** Sinh Viên Java Cấp Tốc ***** \n";
				System.out
				.println("Sinh Viên  Thứ " + (++i) +msg+ ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoSV()
						+ " - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + "\n - năm Sinh: "
						+ ((SinhVienJavaCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
						+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n - Điểm LP2: "
						+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP3: "
						+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
						+ ((SinhVienJavaCapToc) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: "
						+ ((SinhVienJavaCapToc) o).xepLoaiHocLuc());
			}
		}
		}
			
		}
		}
	public static void DSSinhVienHLGioi() {
		int i = 0;
		String msg = "";
		for(SinhVien o : dsSinhVien) {
			if(o instanceof SinhVienDaiHan) {
			if(((SinhVienDaiHan) o).tinhDiemTrungBinhMon()>=8.5) {
				System.out.println("SInh viên có học lực giỏi là");
				System.out.println(msg+":\n Họ Sinh Viên"+((SinhVienDaiHan) o).getHoSV()+"\n - Tên Sinh Viên: "+((SinhVienDaiHan) o).getHoSV()
						+"--Năm sinh: "+((SinhVienDaiHan) o).getNamSinh()+"--Địa chỉ: "+((SinhVienDaiHan) o).getDiaChi()+"\n - Điểm LP0: "+((SinhVienDaiHan) o).getDiemLP0()+
						"\n - Điểm LP1: "+((SinhVienDaiHan) o).getDiemLP1()+"\n - Điểm LP2: "+((SinhVienDaiHan) o).getDiemLP2()+"\n - Điểm LP3: "+((SinhVienDaiHan) o).getDiemLP3()+"\n - Điểm LP4: "+((SinhVienDaiHan) o).getDiemLP4()+
						"\n - Điểm LP5: "+((SinhVienDaiHan) o).getDiemLP5()+"\n - Điểm LP6: "+((SinhVienDaiHan) o).getDiemLP6()+"\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiHocLuc());
			
			}
			else if(o instanceof SinhVienWebCapToc) {
				if(((SinhVienWebCapToc) o).tinhDiemTrungBinhMon()>=8.5) {
					msg = "**** Sinh Viên Web Cấp Tốc có học lực giỏi ***** \n";
					System.out
					.println(msg+ ":\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoSV()
							+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
							+ ((SinhVienWebCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
							+ ((SinhVienWebCapToc) o).getDiaChi() + "\n - Điểm LP2: "
							+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
							+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
							+ ((SinhVienWebCapToc) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: "
							+ ((SinhVienWebCapToc) o).xepLoaiHocLuc());
				}
				else if(o instanceof SinhVienJavaCapToc) {
					if(((SinhVienJavaCapToc) o).tinhDiemTrungBinhMon()>=8.5) {
						msg = "**** Sinh Viên Java Cấp TốP HỌC LỰC GIỎI ***** \n";
						System.out
						.println(msg+ ":\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoSV()
								+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
								+ ((SinhVienJavaCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
								+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n - Điểm LP2: "
								+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP3: "
								+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
								+ ((SinhVienJavaCapToc) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: "
								+ ((SinhVienJavaCapToc) o).xepLoaiHocLuc());
					}
				}
			}
			}
		}System.out.println("******************************************************");
	}
	public static void DSSinhVienTheoDiem() {
		Scanner nhap = new Scanner(System.in);
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		int vip = nhap.nextInt();
		int i=0;
		System.out.println("SẮP XẾP \n");
		if(vip==1) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien o1, SinhVien o2) {
					if (o1.tinhDiemTrungBinhMon() < o2.tinhDiemTrungBinhMon()) {
						return 1;
					} else if (o1.tinhDiemTrungBinhMon() > o2.tinhDiemTrungBinhMon()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for(SinhVien o : dsSinhVien) {
				System.out.println("Sinh viên thứ "+(i+1)+":\n Họ Sinh Viên"+((SinhVienDaiHan) o).getHoSV()+"\n - Tên Sinh Viên: "+((SinhVienDaiHan) o).getTenSV()
						+"--Năm sinh: "+((SinhVienDaiHan) o).getNamSinh()+"--Địa chỉ: "+((SinhVienDaiHan) o).getDiaChi()+ " - Điểm LP0: "+((SinhVienDaiHan) o).getDiemLP0()+
						"\n - Điểm LP1: "+((SinhVienDaiHan) o).getDiemLP1()+"\n - Điểm LP2: "+((SinhVienDaiHan) o).getDiemLP2()+"\n - Điểm LP3: "+((SinhVienDaiHan) o).getDiemLP3()+"\n - Điểm LP4: "+((SinhVienDaiHan) o).getDiemLP4()+
						"\n - Điểm LP5: "+((SinhVienDaiHan) o).getDiemLP5()+"\n - Điểm LP6: "+((SinhVienDaiHan) o).getDiemLP6()+"\n - Điểm Trung Bình: "
						+ ((SinhVienDaiHan) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: " + ((SinhVienDaiHan) o).xepLoaiHocLuc());
			}
		}
		else if(vip==2) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien o1, SinhVien o2) {
					if (o1.tinhDiemTrungBinhMon() < o2.tinhDiemTrungBinhMon()) {
						return 1;
					} else if (o1.tinhDiemTrungBinhMon() > o2.tinhDiemTrungBinhMon()) {
						return -1;
					} else {
						return 0;
					}
				}
			});for(SinhVien o : dsSinhVien) {
				System.out
				.println( "\n Họ Sinh Viên: " + ((SinhVienWebCapToc) o).getHoSV()
						+ " - Tên Sinh Viên: " + ((SinhVienWebCapToc) o).getTenSV() + "\n - năm Sinh: "
						+ ((SinhVienWebCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
						+ ((SinhVienWebCapToc) o).getDiaChi() + "\n - Điểm LP2: "
						+ ((SinhVienWebCapToc) o).getDiemLP2() + "\n - Điểm LP3: "
						+ ((SinhVienWebCapToc) o).getDiemLP3() + "\n - Điểm Trung Bình: "
						+ ((SinhVienWebCapToc) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: "
						+ ((SinhVienWebCapToc) o).xepLoaiHocLuc());
			}
			
		}
		else if(vip==3) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien o1, SinhVien o2) {
					if (o1.tinhDiemTrungBinhMon() < o2.tinhDiemTrungBinhMon()) {
						return 1;
					} else if (o1.tinhDiemTrungBinhMon() > o2.tinhDiemTrungBinhMon()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for(SinhVien o : dsSinhVien) {
				System.out
				.println( "\n Họ Sinh Viên: " + ((SinhVienJavaCapToc) o).getHoSV()
						+ " - Tên Sinh Viên: " + ((SinhVienJavaCapToc) o).getTenSV() + "\n - năm Sinh: "
						+ ((SinhVienJavaCapToc) o).getNamSinh() + "\n - Địa Chỉ: "
						+ ((SinhVienJavaCapToc) o).getDiaChi() + "\n - Điểm LP2: "
						+ ((SinhVienJavaCapToc) o).getDiemLP4() + "\n - Điểm LP3: "
						+ ((SinhVienJavaCapToc) o).getDiemLP5() + "\n - Điểm Trung Bình: "
						+ ((SinhVienJavaCapToc) o).tinhDiemTrungBinhMon() + "\n - Xếp Loại: "
						+ ((SinhVienJavaCapToc) o).xepLoaiHocLuc());
			}
			
		}
	}
	public static void XoaMotSinhVien() {
		
	}
	}


