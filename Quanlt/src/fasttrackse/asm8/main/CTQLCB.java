package fasttrackse.asm8.main;

import java.util.*;

import fasttrackse.asm8.entity.*;

public class CTQLCB {
	static int n;
	static ArrayList<CanBo> arr = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(">> Menu Chương Trình <<");
			System.out.println("+---------------------------+");
			System.out.println("|1.Nhập danh sách Cán bộ|");
			System.out.println("|2.Xuất thông tin Cán bộ |");
			System.out.println("|3.Tổng số lương phải trả|");
			System.out.println("|4.Sắp xếp danh sách Cán bộ|");
			System.out.println("|5.Kết Thúc                 |");
			System.out.println("+---------------------------+");
			System.out.println("Mời Bạn Chọn Chức Năng");
			n = sc.nextInt();
			if (n == 1) {
				nhapCanBo();
			} else if (n == 2) {
				xuatCanBo();
			} else if (n == 3) {
				tongLuong();
			} else if (n == 4) {
			 sapXepCB();
			}else if(n==5) {
				System.out.println("Exit done!!!!\nCẢM ƠN BẠN ĐÃ SỬ DỤNG \n Code by Quanlt");
				System.exit(0);
			}else {
				System.out.println("Nhập từ 1->5 thôi man!!!");
			}
		}
	}

	public static void nhapCanBo() {
		System.out.println("Chọn loại Cán Bộ muốn nhập: \n1.Nhân Viên \n2. Giáo Viên");
		int loai = sc.nextInt();
		if (loai == 1) {
			System.out.println("Nhập số lượng Nhân Viên: ");
			int soluong = sc.nextInt();
			String tenCB =" ", phongBan=" ", chucVu=" ";
			int phuCap = 0, heSoLuong = 0, soNgayCong = 0;
			for (int i = 0; i < soluong; i++) {
				System.out.println("Nhập thông tin Nhân viên thứ " + (i + 1) + ": ");
				sc.nextLine();
				System.out.println("Nhập tên: ");
				tenCB = sc.nextLine();
				System.out.println("Nhập phòng ban: ");
				phongBan = sc.nextLine();
				System.out.println("Nhập số ngày công: ");
				soNgayCong = sc.nextInt();
				System.out.println("Nhập hệ số lương: ");
				heSoLuong = sc.nextInt();
				System.out.println("Chức vụ: \n1. Trưởng phòng \n2. Phó phòng\n3. Nhân Viên");
				int cv = sc.nextInt();
				try {
					cv = sc.nextInt();
				}catch (InputMismatchException e) {
				System.out.println("ABC");
				}
				if (cv == 1) {
					chucVu = "Trưởng phòng";
					phuCap = 2000;
				} else if (cv == 2) {
					chucVu = "Phó phòng";
					phuCap = 1000;
				} else if (cv == 3) {
					chucVu = "Nhân viên";
					phuCap = 500;
				} else {
					System.out.println("Bạn đã chọn sai !!!");
				}

			}
			arr.add(new NhanVien(tenCB, phuCap, heSoLuong, phongBan, soNgayCong, chucVu));
		}if(loai==2) {
			System.out.println("Nhập số lượng Giảng Viên: ");
			int soluong = sc.nextInt();
			String tenCB =" ", khoaGV= " ", trinhDo =" ";
			int phuCap=0, heSoLuong=0, soTietDay=0;
			for(int i =0; i<soluong; i++) {
				System.out.println("Nhập thông tin Giảng Viên thứ "+(i+1)+": ");
				sc.nextInt();
				System.out.println("Nhập tên: ");
				tenCB= sc.nextLine();
				System.out.println("Nhập khoa GV: ");
				khoaGV= sc.nextLine();
				System.out.println("Nhập hệ số lương: ");
				heSoLuong =sc.nextInt();
				System.out.println("Nhập số tiết dạy: ");
				soTietDay =sc.nextInt();
				System.out.println("Nhập trình độ: \n1.Cử nhân \n2.Thạc sĩ\n3. Tiến sĩ");
				int td = sc.nextInt();
				if(td==1) {
					trinhDo="Cử nhân";
					phuCap=300;
				}else if(td==2) {
					trinhDo="Thạc sĩ";
					phuCap= 500;
				}else if(td==3) {
					trinhDo="Tiến sĩ";
					phuCap=1000;
				}else {
					System.out.println("Bạn đã nhập sai!!!");
				}
			}
			arr.add(new GiangVien(tenCB, phuCap, heSoLuong, khoaGV, trinhDo, soTietDay));
		}
	}
	public static void xuatCanBo() {
		System.out.println("Chọn loại Cán Bộ: \n1. Nhân Viên\n2. Giảng Viên");
		int loai= sc.nextInt();
		if(loai==1) {
			sc.nextLine();
			System.out.println("Nhập phòng ban: ");
			String pb = sc.nextLine();
				for(CanBo x : arr) {
					if(pb.equals(((NhanVien) x).getPhongBan())==true) {
						System.out.println("Tên Nhân Viên: "+((NhanVien) x).getTenNV()+"\n Phòng ban: "+((NhanVien) x).getPhongBan()
								+"\n Số ngày công: "+((NhanVien) x).getSoNgayCong()+" \nHệ số lương: "+((NhanVien) x).getHeSoLuong()
								+" \n Phụ cấp: "+((NhanVien) x).getPhuCap()+" \n Chức vụ: "+((NhanVien) x).getChucVu()
								+"\n Lương NV: "+((NhanVien)x).luongNV());
					}

			}
		}else if(loai==2) {
			sc.nextLine();
			System.out.println("Nhập khoa: ");
			String k = sc.nextLine();
			for(CanBo x : arr) {
				if(k.equals(((GiangVien) x).getKhoaGV())==true){
					System.out.println("Tên Giảng Viên: "+((GiangVien) x).getTenNV()+"\n Khoa: "+((GiangVien) x).getKhoaGV()
							+"\n Số tiết dạy: "+((GiangVien) x).getSoTietDay()+" \nHệ số lương: "+((GiangVien) x).getHeSoLuong()
							+" \n Phụ cấp: "+((GiangVien) x).getPhuCap()+" \n Chức vụ: "+((GiangVien) x).getTrinhDo()
							+"\n Lương NV: "+((GiangVien)x).luongNV());
				}
			}
		}
	}
	public static void tongLuong() {
		int luong = 0;
		for(CanBo x : arr) {
			luong+=x.luongNV();
		}
		System.out.println("Tổng lương Cán Bộ: "+luong);
	}
	public static void sapXepCB() {
		Collections.sort(arr, new Comparator<CanBo>() {

			@Override
			public int compare(CanBo o1, CanBo o2) {
				if (o2.luongNV() < o1.luongNV()) {
					return 1;
				} else if (o2.luongNV() > o1.luongNV()) {
					return -1;
				} else {
					return o1.getTenNV().compareTo(o2.getTenNV());
				}
			}
			
		});
		for(CanBo x : arr) {
				if(x instanceof NhanVien) {
					System.out.println("Tên Nhân Viên: "+((NhanVien) x).getTenNV()+"\n Phòng ban: "+((NhanVien) x).getPhongBan()
							+"\n Số ngày công: "+((NhanVien) x).getSoNgayCong()+" \nHệ số lương: "+((NhanVien) x).getHeSoLuong()
							+" \n Phụ cấp: "+((NhanVien) x).getPhuCap()+" \n Chức vụ: "+((NhanVien) x).getChucVu()
							+"\n Lương NV: "+((NhanVien)x).luongNV());
				}else if( x instanceof GiangVien) {
					System.out.println("Tên Giảng Viên: "+((GiangVien) x).getTenNV()+"\n Khoa: "+((GiangVien) x).getKhoaGV()
							+"\n Số tiết dạy: "+((GiangVien) x).getSoTietDay()+" \nHệ số lương: "+((GiangVien) x).getHeSoLuong()
							+" \n Phụ cấp: "+((GiangVien) x).getPhuCap()+" \n Chức vụ: "+((GiangVien) x).getTrinhDo()
							+"\n Lương NV: "+((GiangVien)x).luongNV());
				}
		}
	}
}
