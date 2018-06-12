package fasttrackse.ass7.main;

import java.util.*;
import fasttrackse.ass7.entity.*;

public class QuanLySinhVien {
	static int n;
	static ArrayList<SinhVienDaiHan> svDH = new ArrayList<>();
	static ArrayList<SinhVienJavaCapToc> svJVCT = new ArrayList<>();
	static ArrayList<SinhVienWebCapToc> svWCT = new ArrayList<>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập danh sách sinh viên|");
			System.out.println("|2.Xuất thông tin danh sách sinh viên |");
			System.out.println("|3.Xuất danh sách sinh viên có học lực giỏi|");
			System.out.println("|4.Sắp xếp danh sách sinh viên theo điểm|");
			System.out.println("|5.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			n = myInput.nextInt();
			if (n == 1) {
				nhapsvDH();
			} else if (n == 2) {
				xuatSV();
			} else if (n == 3) {
				hienHLG();
			} else if (n == 4) {
				sapXep();
			} else if (n == 5) {
				System.out.println("Exit done!!!!\nCẢM ƠN BẠN ĐÃ SỬ DỤNG \n Code by Quanlt");
				System.exit(0);
			} /*
				 * else if (N == 6) { XoaBienLaiKH(); }
				 */ else {
				System.out.println("Bạn đã chọn sai !!!!");
			}
		}
	}

	public static void nhapsvDH() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		int k = sc.nextInt();
		if (k == 1) {
			System.out.println("Nhập số lượng sinh viên: ");
			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				SinhVienDaiHan x = new SinhVienDaiHan(null, null, i, null, i, i, i, i, i, i, i);
				sc.nextLine();
				System.out.println("Nhập họ sinh viên thứ: " + (i + 1));
				x.setHoSV(sc.nextLine());
				System.out.println("Nhập tên sinh viên thứ: " + (i + 1));
				x.setTenSV(sc.nextLine());

				System.out.println("Nhập năm sinh sinh viên thứ: " + (i + 1));
				x.setNamSinh(sc.nextInt());
				sc.nextLine();
				System.out.println("Nhập địa chỉ sinh viên thứ: " + (i + 1));
				x.setDiaChi(sc.nextLine());
				System.out.println("Nhập điểm LP0: ");
				x.setLp0(sc.nextInt());
				System.out.println("Nhập điểm LP1: ");
				x.setLp1(sc.nextInt());
				System.out.println("Nhập điểm LP2: ");
				x.setLp2(sc.nextInt());
				System.out.println("Nhập điểm LP4: ");
				x.setLp3(sc.nextInt());
				System.out.println("Nhập điểm LP5: ");
				x.setLp4(sc.nextInt());
				System.out.println("Nhập điểm LP6: ");
				x.setLp5(sc.nextInt());
				svDH.add(x);
			}
		} else if (k == 2) {
			System.out.println("Nhập số lượng sinh viên: ");
			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				SinhVienWebCapToc x = new SinhVienWebCapToc(null, null, i, null, i, i);
				sc.nextLine();
				System.out.println("Nhập họ sinh viên thứ: " + (i + 1));
				x.setHoSV(sc.nextLine());
				System.out.println("Nhập tên sinh viên thứ: " + (i + 1));
				x.setTenSV(sc.nextLine());
				System.out.println("Nhập năm sinh sinh viên thứ: " + (i + 1));
				x.setNamSinh(sc.nextInt());
				sc.nextLine();
				System.out.println("Nhập địa chỉ sinh viên thứ: " + (i + 1));
				x.setDiaChi(sc.nextLine());
				System.out.println("Nhập điểm LP2: ");
				x.setLp2(sc.nextInt());
				System.out.println("Nhập điểm LP4: ");
				x.setLp3(sc.nextInt());
				System.out.println("Nhập điểm LP5: ");
				svWCT.add(x);
			}
		} else if (k == 3) {
			System.out.println("Nhập số lượng sinh viên: ");
			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				SinhVienJavaCapToc x = new SinhVienJavaCapToc(null, null, i, null, i, i);
				sc.nextLine();
				System.out.println("Nhập họ sinh viên thứ: " + (i + 1));
				x.setHoSV(sc.nextLine());
				System.out.println("Nhập tên sinh viên thứ: " + (i + 1));
				x.setTenSV(sc.nextLine());
				System.out.println("Nhập năm sinh sinh viên thứ: " + (i + 1));
				x.setNamSinh(sc.nextInt());
				sc.nextLine();
				System.out.println("Nhập địa chỉ sinh viên thứ: " + (i + 1));
				x.setDiaChi(sc.nextLine());
				System.out.println("Nhập điểm LP4: ");
				x.setLp4(sc.nextInt());
				System.out.println("Nhập điểm LP5: ");
				x.setLp5(sc.nextInt());
				svJVCT.add(x);
			}
		} else {
			System.out.println("Bạn đã chọn sai !!!");
		}
	}

	public static void xuatSV() {
		int c = 0;
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		c = myInput.nextInt();
		int i = 1;
		if (c == 1) {
			for (SinhVienDaiHan x : svDH) {
				System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
						+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP0: " + x.getLp0() + "\nLP1: "
						+ x.getLp1() + "\nLP2: " + x.getLp2() + "\nLP3: " + x.getLp3() + "\nLP4: " + x.getLp4()
						+ "\nLP5: " + x.getLp5() + "\nLP6: " + x.getLp6() + "\nĐiểm TB: *" + x.tinhTB());
			}
		} else if (c == 2) {
			for (SinhVienWebCapToc x : svWCT) {
				System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
						+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP2: " + x.getLp2() + "\nLP3: "
						+ x.getLp3() + "\n Điểm TB: *" + x.tinhTB());
			}
		} else if (c == 3) {
			for (SinhVienJavaCapToc x : svJVCT) {
				System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
						+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP4: " + x.getLp4() + "\nLP5: "
						+ x.getLp5() + "\n Điểm TB: *" + x.tinhTB());
			}
		} else {
			System.out.println("Bạn đã chọn sai!!!!");
		}
	}

	public static void hienHLG() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		int k = sc.nextInt();
		int i = 1;
		System.out.println("DANH SÁCH SINH VIÊN CÓ HỌC LỰC LOẠI GIỎI \n");
		if (k == 1) {
			for (SinhVienDaiHan x : svDH) {
				if (x.hocLuc() == "Giỏi") {
					System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
							+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP0: " + x.getLp0() + "\nLP1: "
							+ x.getLp1() + "\nLP2: " + x.getLp2() + "\nLP3: " + x.getLp3() + "\nLP4: " + x.getLp4()
							+ "\nLP5: " + x.getLp5() + "\nLP6: " + x.getLp6() + "\nĐiểm TB: *" + x.tinhTB());
				}
			}
		} else if (k == 2) {
			for (SinhVienWebCapToc x : svWCT) {
				if (x.hocLuc() == "Giỏi") {
					System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
							+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP2: " + x.getLp2() + "\nLP3: "
							+ x.getLp3() + "\n Điểm TB: *" + x.tinhTB());
				}
			}
		} else if (k == 3) {
			for (SinhVienJavaCapToc x : svJVCT) {
				if (x.hocLuc() == "Giỏi") {
					System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
							+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP4: " + x.getLp4() + "\nLP5: "
							+ x.getLp5() + "\n Điểm TB: *" + x.tinhTB());
				}
			}
		}
	}

	public static void sapXep() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MỜI CHỌN KIỂU SV\n1. SINH VIÊN DÀI HẠN \n2. SINH VIÊN WED CẤP TỐC\n3. SINH VIÊN JAVA CẤP TỐC");
		int k = sc.nextInt();
		int i = 1;
		System.out.println("SẮP XẾP \n");
		if (k == 1) {
			Collections.sort(svDH, new Comparator<SinhVienDaiHan>() {
				@Override
				public int compare(SinhVienDaiHan kh1, SinhVienDaiHan kh2) {
					if (kh1.tinhTB() < kh2.tinhTB()) {
						return 1;
					} else if (kh1.tinhTB() > kh2.tinhTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for (SinhVienDaiHan x : svDH) {
				System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
						+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP0: " + x.getLp0() + "\nLP1: "
						+ x.getLp1() + "\nLP2: " + x.getLp2() + "\nLP3: " + x.getLp3() + "\nLP4: " + x.getLp4()
						+ "\nLP5: " + x.getLp5() + "\nLP6: " + x.getLp6() + "\nĐiểm TB: *" + x.tinhTB());
			}
		}else if(k==2) {
			Collections.sort(svWCT, new Comparator<SinhVienWebCapToc>() {
				@Override
				public int compare(SinhVienWebCapToc kh1, SinhVienWebCapToc kh2) {
					if (kh1.tinhTB() < kh2.tinhTB()) {
						return 1;
					} else if (kh1.tinhTB() > kh2.tinhTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for (SinhVienWebCapToc x : svWCT) {
				System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
						+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP2: " + x.getLp2() + "\nLP3: "
						+ x.getLp3() + "\n Điểm TB: *" + x.tinhTB());
			}
		}else if(k==3) {
			Collections.sort(svJVCT, new Comparator<SinhVienJavaCapToc>() {
				@Override
				public int compare(SinhVienJavaCapToc kh1, SinhVienJavaCapToc kh2) {
					if (kh1.tinhTB() < kh2.tinhTB()) {
						return 1;
					} else if (kh1.tinhTB() > kh2.tinhTB()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for (SinhVienJavaCapToc x : svJVCT) {
				System.out.println(i++ + ". Họ: " + x.getHoSV() + "\n Tên: " + x.getTenSV() + "\n Năm sinh: "
						+ x.getNamSinh() + " \nĐịa chỉ: " + x.getDiaChi() + "\nLP4: " + x.getLp4() + "\nLP5: "
						+ x.getLp5() + "\n Điểm TB: *" + x.tinhTB());
			}
		}else {
			System.out.println("Bạn đã nhập sai!!!!");
		}

	}
}
