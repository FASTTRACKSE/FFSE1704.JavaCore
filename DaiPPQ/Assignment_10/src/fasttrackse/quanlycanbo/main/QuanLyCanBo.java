/************************
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 25/06/2018
 **********************/
package fasttrackse.quanlycanbo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import fasttrackse.quanlycanbo.entity.CanBo;
import fasttrackse.quanlycanbo.entity.GiangVien;
import fasttrackse.quanlycanbo.entity.NhanVien;
import fasttrackse.quanlycanbo.util.CBException;
import fasttrackse.quanlycanbo.util.NVComparator;
import fasttrackse.quanlycanbo.util.SerializeFileFactory;

/**
 * @author Support
 *
 */
public class QuanLyCanBo {
	private static int N;
	private static ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
	static Scanner nhap = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int myOption = 0;
		while (myOption != 7) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+----------------------------------------------------+");
				System.out.println("|1.Nhập thông tin cán bộ                             |");
				System.out.println("|2.Xuất thông tin cán bộ                             |");
				System.out.println("|3.Tổng Tiền mà Nhà Trường phải trả cho toàn cán bộ  |");
				System.out.println("|4.Danh sách cán bộ toàn trường theo lương           |");
				System.out.println("|5.Ghi danh sách cán bộ vào file                     |");
				System.out.println("|6.Đọc danh sách cán bộ qua file                     |");
				System.out.println("|7.Kết Thúc                                          |");
				System.out.println("+----------------------------------------------------+");

				myOption = nhap.nextInt();
				if (myOption == 1) {

					nhapThongTin();
				} else if (myOption == 2) {

					xuatThongTin();
				} else if (myOption == 3) {

					tongLuong();

				} else if (myOption == 4) {
					SapXep();

				} else if (myOption == 5) {
					ghiFile();

				} else if (myOption == 6) {
					docFile();

				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 7, nhập lại!");
			} finally {
				if (myOption != 7) {
					backToMainMenu();
				}
			}
		}
	}

	private static void backToMainMenu() {
		nhap.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		nhap.nextLine();

	}

	public static void nhapThongTin() {
		System.out.println(">>Nhập Thông tin Cán Bộ<<");
		System.out.println("+--------------------------------------+");
		System.out.println("|1.Giảng Viên                          |");
		System.out.println("|2.Nhân Viên                           |");
		System.out.println("+--------------------------------------+");
		int M = nhap.nextInt();
		if (M == 1) {
			int choose;
			boolean inputOK;
			double heSoLuong = 0;
			String trinhDo = "";
			String tenCanBo = "";
			int soTietDay = 0;
			System.out.println("Nhập thông tin Giảng Viên");
			System.out.println("+------------------------------+");
			System.out.print("Nhập Số Lượng Giảng Viên: ");
			N = nhap.nextInt();
			for (int i = 0; i < N; i++) {

				System.out.print("Nhập Thông Tin giảng Viên thứ " + (i + 1) + "\n");
				nhap.nextLine();

				do {
					try {
						inputOK = true;
						System.out.print("Nhập họ tên giảng viên: ");
						tenCanBo = nhap.nextLine();

						if (tenCanBo.length() < 1 || tenCanBo.length() > 40) {
							// bẵn lỗi
							throw new CBException(1);
						}
					} catch (CBException e) {
						System.err.println(e);
						inputOK = false;
					}
				} while (!inputOK);

				/**
				 * 
				 *
				 */

				System.out.print("Nhập Khoa : ");
				String khoa = nhap.nextLine();

				/**
				 * 
				 *
				 */

				do {
					try {

						System.out.print("Nhập trình độ (1 - cử nhân, 2 - thạc sĩ, 3 -tiến sĩ): ");
						choose = nhap.nextInt();

						if (choose == 1) {
							trinhDo = "Cử nhân";
							inputOK = true;
						} else {
							if (choose == 2) {
								trinhDo = "Thạc sĩ";
								inputOK = true;
							} else {
								if (choose == 3) {
									trinhDo = "Tiến sĩ";
									inputOK = true;
								} else {
									System.err.println("Nhập sai!!!");
									inputOK = false;
								}
							}
						}
					} catch (InputMismatchException e) {
						System.err.println("Nhập sai!!!");
						nhap.next();
						inputOK = false;
					}
				} while (!inputOK);

				/**
				 *
				 *
				 */

				do {
					try {
						inputOK = true;
						System.out.print("Số Tiết Dạy Trong Tháng: ");
						soTietDay = nhap.nextInt();

						if (soTietDay <= 0) {
							// bẵn lỗi
							throw new CBException(2);
						}
					} catch (CBException e) {
						System.err.println(e);
						inputOK = false;
					} catch (InputMismatchException e) {
						System.err.println("Chỉ được nhập số");
						nhap.next();
						inputOK = false;
					}
				} while (!inputOK);

				/**
				 * 
				 *
				 */

				do {
					try {
						inputOK = true;
						System.out.print("Hệ Số Lương: ");
						heSoLuong = nhap.nextDouble();

					} catch (InputMismatchException e) {
						System.err.println("Hệ số lương phải là số thực");
						nhap.next();
						inputOK = false;
					}
				} while (!inputOK);

				System.out.println("------------------------------------------------------------------");

				dsCanBo.add(new GiangVien(tenCanBo, khoa, trinhDo, soTietDay, heSoLuong));

			}
		}
		// kết thúc vòng lặp nhập
		else {
			if (M == 2) {
				int choose;
				boolean inputOK;
				String tenCanBo = "";
				String chucVu = "";
				int soNgayCong = 0;
				double heSoLuong = 0;
				System.out.println("Nhập thông tin Nhân Viên");
				System.out.println("+------------------------------+");
				System.out.print("Nhập Số Lượng Nhân Viên: ");
				N = nhap.nextInt();
				for (int i = 0; i < N; i++) {
					System.out.print("Nhập Thông Tin Nhân Viên thứ " + (i + 1) + "\n");
					nhap.nextLine();
					/**
					 * 
					 *
					 */
					do {
						try {
							inputOK = true;
							System.out.print("Nhập Họ Tên Nhân Viên: ");
							tenCanBo = nhap.nextLine();

							if (tenCanBo.length() < 1 || tenCanBo.length() > 40) {
								// bẵn lỗi
								throw new CBException(1);
							}
						} catch (CBException e) {
							System.err.println(e);
							inputOK = false;
						}
					} while (!inputOK);
					/**
					 * 
					 *
					 */
					System.out.print("Phòng Ban : ");
					String phongBan = nhap.nextLine();
					/**
					 * 
					 *
					 */

					do {
						try {

							System.out.print("Nhập chức vụ (1 - Trưởng phòng, 2 - Phó phòng, 3 -Nhân viên): ");
							choose = nhap.nextInt();

							if (choose == 1) {
								chucVu = "Trưởng phòng";
								inputOK = true;
							} else {
								if (choose == 2) {
									chucVu = "Phó phòng";
									inputOK = true;
								} else {
									if (choose == 3) {
										chucVu = "Nhân viên";
										inputOK = true;
									} else {
										System.err.println("Nhập sai!!!");
										inputOK = false;
									}
								}
							}
						} catch (InputMismatchException e) {
							System.err.println("Nhập sai!!!");
							nhap.next();
							inputOK = false;
						}
					} while (!inputOK);

					/**
					 * 
					 *
					 */

					do {
						try {
							inputOK = true;
							System.out.print("Số ngày công: ");
							soNgayCong = nhap.nextInt();

							if (soNgayCong < 0) {
								// bẵn lỗi
								throw new CBException(2);
							}
						} catch (CBException e) {
							System.err.println(e);
							inputOK = false;
						} catch (InputMismatchException e) {
							System.err.println("phải nhập kiểu số");
							nhap.next();
							inputOK = false;
						}
					} while (!inputOK);

					/**
					 *
					 *
					 */

					do {
						try {
							inputOK = true;
							System.out.print("Hệ Số Lương: ");
							heSoLuong = nhap.nextDouble();

						} catch (InputMismatchException e) {
							System.err.println("Hệ số lương phải là số thực");
							nhap.next();
							inputOK = false;
						}
					} while (!inputOK);
					/**
					 * 
					 *
					 */
					System.out.println("------------------------------------------------------------------");

					dsCanBo.add(new NhanVien(tenCanBo, phongBan, chucVu, soNgayCong, heSoLuong));
				}
				// kết thúc vòng lặp nhập
			} else {
				System.err.println("Bạn chỉ được nhập 1 hoặc 2. Hãy Nhập Lại!!!");
			}
			// kết thúc if else
		}
	}// kết thúc bộ nhập

	public static void xuatThongTin() {

		String tim = "";
		System.out.println("Bạn muốn thông tin cán bộ thuộc khoa hay phòng ban nào???");
		nhap.nextLine();
		tim = nhap.nextLine();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i) instanceof GiangVien) {
				if (tim.equals(((GiangVien) dsCanBo.get(i)).getKhoa())) {

					System.out.println("Giảng Viên  Thứ " + (i + 1) + ":\n Họ Tên Giảng Viên: "
							+ ((GiangVien) dsCanBo.get(i)).getTenCanBo() + "\n - Khoa: "
							+ ((GiangVien) dsCanBo.get(i)).getKhoa() + "\n - Trình Độ: "
							+ ((GiangVien) dsCanBo.get(i)).getTrinhDo() + "\n - Số Tiết Dạy: "
							+ ((GiangVien) dsCanBo.get(i)).getSoTietDay() + "\n - Hệ Số Lương: "
							+ ((GiangVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((GiangVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}
			if (dsCanBo.get(i) instanceof NhanVien) {
				if (tim.equals(((NhanVien) dsCanBo.get(i)).getPhongBan())) {

					System.out.println("Nhân Viên  Thứ " + (i + 1) + ":\n Họ Tên Nhân Viên: "
							+ ((NhanVien) dsCanBo.get(i)).getTenCanBo() + "\n - phòng Ban: "
							+ ((NhanVien) dsCanBo.get(i)).getPhongBan() + "\n - Chức Vụ: "
							+ ((NhanVien) dsCanBo.get(i)).getChucVu() + "\n - Số Ngày Công: "
							+ ((NhanVien) dsCanBo.get(i)).getSoNgayCong() + "\n - Hệ Số Lương: "
							+ ((NhanVien) dsCanBo.get(i)).getHeSoLuong() + "\n - Lương: "
							+ ((NhanVien) dsCanBo.get(i)).tinhLuong() + " VNĐ");

				}
			}

		}
	}

	public static void tongLuong() {
		double tongtien = 0;
		for (int i = 0; i < dsCanBo.size(); i++) {
			tongtien += dsCanBo.get(i).tinhLuong();
		}

		System.out.println("Tổng tiền nhà trường phả trả cho toàn bộ cán bộ là: " + tongtien + " VNĐ");
	}

	public static void SapXep() {
		int i = 0;
		Collections.sort(dsCanBo, NVComparator.CanBoLuongDESCCanBoTenASComparator);

		System.out.println(
				"|-----------------------------------------------------------------------------DANH SÁCH CÁN BỘ-----------------------------------------------------------------------------------|");
		System.out.printf("\n" + "%-10s %-25s %-25s %-25s  %-15s  %-15s %-15s %-15s %-15s %-15s ", "STT", "Họ và tên",
				"Khoa", "Phòng Ban", "Trình Độ", "Chức Vụ", "Số Tiết Dạy", "Số Ngày Công", "Hệ số Lương",
				"Lương Được Nhận\n");
		System.out.println("");
		System.out.println(
				"-----------------------------------------------------------------------------*******************-----------------------------------------------------------------------------------");
		for (CanBo o : dsCanBo) {

			if (o instanceof GiangVien) {
				System.out.printf("\n" + "%-10s %-25s %-25s %-25s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (++i),
						((GiangVien) o).getTenCanBo(), ((GiangVien) o).getKhoa(), "x", ((GiangVien) o).getTrinhDo(),
						"x", ((GiangVien) o).getSoTietDay(), "x", ((GiangVien) o).getHeSoLuong(),
						((GiangVien) o).tinhLuong() + " VNĐ" + "\n");
			} else {
				if (o instanceof NhanVien) {
					System.out.printf("\n" + "%-10s %-25s %-25s %-25s  %-15s  %-15s %-15s %-15s %-15s %-15s ", (++i),
							((NhanVien) o).getTenCanBo(), "x ", ((NhanVien) o).getPhongBan(), "x",
							((NhanVien) o).getChucVu(), "x", ((NhanVien) o).getSoNgayCong(),
							((NhanVien) o).getHeSoLuong(), ((NhanVien) o).tinhLuong() + " VNĐ" + "\n");
				}
			}
			System.out.println("");
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		}

	}

	public static void ghiFile() {
		SerializeFileFactory.luuFile(dsCanBo, "danhsachcanbo.txt");
	}

	public static void docFile() {
		dsCanBo.clear();
		dsCanBo = SerializeFileFactory.docFile("danhsachcanbo.txt");;
	}
}