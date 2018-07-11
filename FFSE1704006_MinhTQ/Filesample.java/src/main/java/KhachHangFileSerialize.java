package main.java;

import java.util.ArrayList;



import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import entity.java.CanBo;
import entity.java.GiangVien;
import entity.java.NhanVien;
import until.java.SerializeFileFactory;
import until.java.until;

public class KhachHangFileSerialize {
	static int n, i, maNhanVien, soTietDay, soNgayCong;
	static String hoVaTen, khoa, trinhDo, phongBan, chucVu;
	static boolean inputOK;
	static int choose;
	static double tongtien, heSoLuong;
	static Scanner nhap = new Scanner(System.in);
	static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();

	public static void main(String[] args) {
		menu();
	}      

	public static void menu() {

		while (n != 7) {

			try {
				System.out.println("\nHệ thống quản lý Sinh Viên");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập thông tin danh sách cán bộ trong trường.");
				System.out.println("2. Xuất danh sách giảng viên khoa x, hoặc nhân viên phòng ban y nào đó. ");
				System.out.println("3. Tổng số lương trường phải trả cho cán bộ.");
				System.out.println("4. Sắp xếp cán bộ theo lương, nếu lương bằng thì sắp xếp theo tên.");
				System.out.println("5. ghiFile");
				System.out.println("6. docFile");
				System.out.println("7. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				n = nhap.nextInt();
				if (n == 1) {
					nhapthongtincanbotrongtruong();
				} else if (n == 2) {

					inthongtindanhsach();
				} else if (n == 3) {

					tinhTongluongNhanVien();
				} else if (n == 4) {
					sapxeptheoluong();

				} else if (n == 5) {

					ghiFile();
				} else if (n == 6) {

					docFile();
				} else if (n == 7) {

					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.err.println("Vui lòng nhập lại bạn hiền !");
			} finally {
				if (n != 7) {
					backToMainMenu();
				}
			}
		}
	}

	public static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	public static void nhapthongtincanbotrongtruong() {

		try {
			System.out.println("\n NHÂN VIÊN THUỘC LOẠI NÀO");
			System.out.println("--------------------------------------");
			System.out.println("1: Giảng viên");
			System.out.println("2: Nhân viên văn phòng ");
			System.out.println("--------------------------------------");
			n = nhap.nextInt();

			if (n == 1) {
				System.out.println("NHẬP THÔNG TIN GIẢNG VIÊN");
				System.out.println("-------------------------------");
				System.out.print("Nhập số lượng giảng viên :");
				n = nhap.nextInt();
				for (i = 0; i < n; i++) {
					System.out.println("Nhập giảng viên thứ :" + (i + 1));

					System.out.print("Nhập mã giảng viên: ");
					maNhanVien = nhap.nextInt();
					nhap.nextLine();

					// nhập họ vầ tên giảng viên

					do {

						try {
							inputOK = true;
							System.out.print("Nhập họ tên giảng viên: ");
							hoVaTen = nhap.nextLine();
							if (hoVaTen.length() < 1 || hoVaTen.length() > 30) {

								throw new until(1);
							}
						} catch (until e) {

							System.err.println(e);
							nhap.nextLine();
							inputOK = false;
						}
					} while (!inputOK);
					// nhạp khoa giảng dạy
					do {

						try {
							inputOK = true;
							System.out.print("Nhập khoa giảng dạy : ");
							khoa = nhap.nextLine();
							if (khoa.length() < 1) {

								throw new until(5);
							}
						} catch (until e) {

							System.err.println(e);
							nhap.nextLine();
							inputOK = false;
						}
					} while (!inputOK);
					System.out.print("Nhập phòng ban : ");
					khoa = nhap.nextLine();
					// nhập trình độ
					do {
						System.out.print("Nhập trình độ (1 - Cử nhân, 2 - Thạc sĩ, 3 -Tiến sĩ): ");
						choose = nhap.nextInt();
						switch (choose) {
						case 1:
							trinhDo = "Cử nhân";

							break;
						case 2:
							trinhDo = "Thạc sĩ";

							break;
						case 3:
							trinhDo = "Tiến sĩ";

						default:
							System.err.println("Chọn không đúng!" + "\nMời chọn lại:");

							break;
						}
					} while (choose < 1 || choose > 3);

					// nhập số tiết giảng dạy
					do {

						try {

							System.out.print("Số tiết dạy: ");
							soTietDay = nhap.nextInt();
							inputOK = true;
							if (soTietDay < 1) {

								throw new until(4);
							}
						} catch (until e) {
							System.err.println(e);
							nhap.nextLine();
							inputOK = false;
						}
					} while (!inputOK);

					// nhập hệ số lương

					do {
						try {

							System.out.print("Nhập hệ số lương: ");
							heSoLuong = nhap.nextDouble();
							inputOK = true;

						} catch (InputMismatchException e) {

							System.err.println("Hệ số lương phải là số thực");
							nhap.nextLine();
							inputOK = false;

						}
					} while (!inputOK);
					dsCanBo.add(new GiangVien(maNhanVien, hoVaTen, khoa, trinhDo, soTietDay, heSoLuong));

				}

			} else if (n == 2) {

				System.out.println("NHẬP THÔNG TIN NHÂN VIÊN");
				System.out.println("-------------------------------");
				System.out.print("Nhập số lượng nhân viên :");
				n = nhap.nextInt();
				for (i = 0; i < n; i++) {
					System.out.println("Nhập nhân viên thứ :" + (i + 1));

					System.out.print("Nhập mã nhân viên: ");
					maNhanVien = nhap.nextInt();
					nhap.nextLine();

					// nhập họ vầ tên giảng viên

					do {

						try {
							inputOK = true;
							System.out.print("Nhập họ tên nhân viên: ");
							hoVaTen = nhap.nextLine();
							if (hoVaTen.length() < 1 || hoVaTen.length() > 30) {

								throw new until(1);
							}
						} catch (until e) {

							System.err.println(e);
							nhap.nextLine();
							inputOK = false;
						}
					} while (!inputOK);

					// nhập phòng ban
					do {

						try {
							inputOK = true;
							System.out.print("Nhập phòng ban : ");
							phongBan = nhap.nextLine();
							if (phongBan.length() < 1) {

								throw new until(5);
							}
						} catch (until e) {

							System.err.println(e);
							nhap.nextLine();
							inputOK = false;
						}
					} while (!inputOK);
					System.out.print("Nhập phòng ban : ");
					khoa = nhap.nextLine();

					// nhập chức vụ
					do {
						System.out.print("Nhập chức vụ (1 - Trưởng phòng, 2 - Phó phòng, 3 - Cử nhân): ");
						choose = nhap.nextInt();
						switch (choose) {
						case 1:
							chucVu = "Trưởng phòng";

							break;
						case 2:
							chucVu = "Phó phòng";

							break;
						case 3:
							chucVu = "Cử nhân";

						default:
							System.err.println("Chọn không đúng!" + "\nMời chọn lại:");
							break;
						}
					} while (choose < 1 || choose > 3);

					// nhập số số ngày công
					do {

						try {

							System.out.print("Số ngày công: ");
							soNgayCong = nhap.nextInt();
							inputOK = true;
							if (soNgayCong < 1) {

								throw new until(4);
							}
						} catch (Exception e) {

							System.err.println(e);
							inputOK = false;
						}
					} while (!inputOK);

					// nhập hệ số lương.
					do {
						try {

							System.out.print("Nhập hệ số lương: ");
							heSoLuong = nhap.nextDouble();
							inputOK = true;

						} catch (InputMismatchException e) {
							System.err.println("Hệ số lương phải là số thực");
							nhap.nextLine();
							inputOK = false;
						}
					} while (!inputOK);
					dsCanBo.add(new NhanVien(maNhanVien, hoVaTen, phongBan, chucVu, soNgayCong, heSoLuong));

				}
			} else {
				throw new IndexOutOfBoundsException();
			}

		} catch (IndexOutOfBoundsException e) {
			System.err.println("Vui lòng chọn  1 or 2 .");
		} catch (Exception e) {
			System.err.println("Vui lòng nhập các trường hợp lệ");
		}

	}

	public static void inthongtindanhsach() {
		String M = "";
		nhap.nextLine();
		System.out.print("Mời Nhập Khoa hoặc phòng ban mà bạn muốn in:");
		M = nhap.nextLine();
		for (i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i) instanceof GiangVien) {
				if (M.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {

					System.out.println((i + 1) + "\t " + ((GiangVien) dsCanBo.get(i)).getMaNhanVien() + "\t "
							+ ((GiangVien) dsCanBo.get(i)).getHoVaTen() + "\t " + ((GiangVien) dsCanBo.get(i)).getKhoa()
							+ "\t  " + ((GiangVien) dsCanBo.get(i)).getTrinhDo() + "\t "
							+ ((GiangVien) dsCanBo.get(i)).getSoTietDay() + "\t "
							+ ((GiangVien) dsCanBo.get(i)).getHeSoLuong() + "\t "
							+ ((GiangVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}
			if (dsCanBo.get(i) instanceof NhanVien) {
				if (M.equals(((NhanVien) dsCanBo.get(i)).getPhongBan())) {

					System.out.println((i + 1) + "\t " + ((NhanVien) dsCanBo.get(i)).getMaNhanVien() + "\t "
							+ ((NhanVien) dsCanBo.get(i)).getHoVaTen() + "\t "
							+ ((NhanVien) dsCanBo.get(i)).getPhongBan() + "\t  "
							+ ((NhanVien) dsCanBo.get(i)).getChucVu() + "\t"
							+ ((NhanVien) dsCanBo.get(i)).getSoNgayCong() + "\t "
							+ ((NhanVien) dsCanBo.get(i)).getHeSoLuong() + "\t "
							+ ((NhanVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}

	public static void tinhTongluongNhanVien() {
		double tongtien = 0;
		for (i = 0; i < dsCanBo.size(); i++) {
			tongtien += dsCanBo.get(i).tinhLuong();

		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");

	}

	public static void sapxeptheoluong() {

		System.out.println("\n MỜI BẠN CHỌN");
		System.out.println("--------------------------------------");
		System.out.println("1: Giảng viên");
		System.out.println("2: Nhân viên văn phòng ");
		System.out.println("--------------------------------------");
		n = nhap.nextInt();
		Collections.sort(dsCanBo, new Comparator<CanBo>() {

			@Override
			public int compare(CanBo NV1, CanBo NV2) {
				if (NV1.tinhLuong() < NV2.tinhLuong()) {
					return 1;
				} else if (NV1.tinhLuong() > NV2.tinhLuong()) {
					return -1;
				} else {
					return (NV1.getHoVaTen().compareTo(NV2.getHoVaTen()));
				}
			}

		});
		if (n == 1) {
			System.out.println(" Danh Sách Giảng Vien");
			
			for (CanBo o : dsCanBo) {

				if (o instanceof GiangVien) {
					System.out.println((i + 1) + "\t" + ((GiangVien) o).getMaNhanVien() + "\t"
							+ ((GiangVien) o).getHoVaTen() + "\t" + ((GiangVien) o).getKhoa() + "\t"
							+ ((GiangVien) o).getTrinhDo() + "\t" + ((GiangVien) o).getSoTietDay() + "\t"
							+ ((GiangVien) o).getHeSoLuong() + "\t" + ((GiangVien) o).tinhLuong());
				}
			}
		} else if (n == 2) {
			System.out.println(" Danh Sách Nhân Viên Văn Phòng");
			
			for (CanBo o : dsCanBo) {
				if (o instanceof NhanVien) {

					System.out.println((i + 1) + "\t" + ((NhanVien) o).getMaNhanVien() + "\t"
							+ ((NhanVien) o).getHoVaTen() + "\t" + ((NhanVien) o).getPhongBan() + "\t"
							+ ((NhanVien) o).getChucVu() + "\t" + ((NhanVien) o).getSoNgayCong() + "\t"
							+ ((NhanVien) o).getHeSoLuong() + "\t" + ((NhanVien) o).tinhLuong());
				}
			}

		}

	}

	public static void ghiFile() {
		SerializeFileFactory.luuFile(dsCanBo, "danhsachcanbo.txt");
	}

	public static void docFile() {
		dsCanBo.clear();
		dsCanBo = SerializeFileFactory.docFile("danhsachcanbo.txt");
		;
	}
}
