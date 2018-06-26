package fasttrackse.qlsv.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import fasttrackse.qlsv.entity.*;

public class QLSV2 {
	ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

	public static void main(String[] args) {
		QLSV2 ctQLSV1 = new QLSV2();
		QLSV2 ctQLSV2 = new QLSV2();

		Scanner myInput = new Scanner(System.in);

		int myOption = 0;
		while (myOption != 4) {
			try {
				System.out.println("\nHệ thống quản lý sinh viên FASTTRACKSE");
				System.out.println("---------------------------------------");
				System.out.println("1. Nhập Data");
				System.out.println("2. In danh sách theo tên");
				System.out.println("3. In danh sách theo điểm trung bình");
				System.out.println("4. Kết thúc chương trình");
				System.out.println("---------------------------------------");
				System.out.print("Mời bạn chọn chức năng: ");

				myOption = myInput.nextInt();
				if (myOption == 1) {
					// Generate data
					ctQLSV1.generateData();
				} else if (myOption == 2) {
					// Sort student list by Name
					ctQLSV1.sortByName();
					ctQLSV1.printReport("Danh Sách Sinh Viên FASTTRACKSE - Sắp xếp theo tên");
				} else if (myOption == 3) {
					// Sort student list by Name
					ctQLSV1.sortByMarks();
					ctQLSV1.printReport("Danh Sách Sinh Viên FASTTRACKSE - Sắp xếp theo điểm TB");
				} else if (myOption == 4) {
					// Hiển thị thông báo kết thúc
					ketThuc();
					myInput.close();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ nhập từ 1 đến 4, nhập lại nhé bạn hiền!");
			} finally {
				if (myOption != 4) {
					ctQLSV2.backToMainMenu();
				}
			}
		}
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình, cám ơn bạn đã sử dụng!!!");
	}

	public void backToMainMenu() {
		System.out.println("Ấn Enter để về menu chính");
	}

	public void generateData() {
		// Danh sách Môn Học
		MonHoc LP1 = new MonHoc("LP1", "Nhập Môn Lập Trình");
		MonHoc LP2 = new MonHoc("LP2", "Lập Trình Web FrontEnd");
		MonHoc LP3 = new MonHoc("LP3", "Lập Trình Java Core");
		MonHoc LP4 = new MonHoc("LP4", "Lập Trình Java EE");
		MonHoc LP5 = new MonHoc("LP5", "Lập Trình Android");

		// Nhập
		ArrayList<DiemMonHoc> diemSV1 = new ArrayList<DiemMonHoc>();
		diemSV1.add(new DiemMonHoc(LP1, 10));
		diemSV1.add(new DiemMonHoc(LP2, 10));
		diemSV1.add(new DiemMonHoc(LP3, 9));
		SinhVien sv1 = new SinhVien("Nguyễn Văn", "Toàn", 1997, diemSV1);

		ArrayList<DiemMonHoc> diemSV2 = new ArrayList<DiemMonHoc>();
		diemSV2.add(new DiemMonHoc(LP1, 7));
		diemSV2.add(new DiemMonHoc(LP2, 7));
		diemSV2.add(new DiemMonHoc(LP3, 7));
		SinhVien sv2 = new SinhVien("Trần Thị", "Bình", 1999, diemSV2);

		ArrayList<DiemMonHoc> diemSV3 = new ArrayList<DiemMonHoc>();
		diemSV3.add(new DiemMonHoc(LP1, 6));
		diemSV3.add(new DiemMonHoc(LP2, 6));
		diemSV3.add(new DiemMonHoc(LP3, 9));

		dsSinhVien = new ArrayList<SinhVien>();

		dsSinhVien.add(sv1);
		dsSinhVien.add(sv2);
		dsSinhVien.add(new SinhVien("Chu Cảnh", "Chiêu", 1992, diemSV3));

		dsSinhVien.add(new SinhVien("Cao Lê", "Thành", 1977, new ArrayList<DiemMonHoc>() {
			{
				add(new DiemMonHoc(LP4, 8));
				add(new DiemMonHoc(LP5, 5));
			}
		}));
	}

	public void sortByName() {
		if (dsSinhVien.size() > 0) {
			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					return (sv1.getTenSinhVien().compareTo(sv2.getTenSinhVien()));
				}
			});
		}
	}

	public void sortByMarks() {
		if (dsSinhVien.size() > 0) {

			Collections.sort(dsSinhVien, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					if (sv1.tinhDiemTrungBinhMon() < sv2.tinhDiemTrungBinhMon()) {
						return 1;
					} else {
						if (sv1.tinhDiemTrungBinhMon() == sv2.tinhDiemTrungBinhMon()) {
							return 0;
						} else {
							return -1;
						}
					}
				}
			});
		}
	}

	public void printReportHeader(String title) {
		System.out.println("\n" + title);
		System.out.println(
				"STT Họ Tên              Năm Sinh       LP1       LP2       LP3       LP4       LP5       DTB");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}

	public void printReportFooter() {
		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}

	public void printReport(String title) {
		printReportHeader(title);

		int stt = 0;

		if (dsSinhVien.size() == 0) {
			System.out.println("Không có sinh viên nào");
		} else {

			for (SinhVien sv : dsSinhVien) {
				System.out.printf("%03d %-20s%8d", ++stt, sv.getHoSinhVien() + " " + sv.getTenSinhVien(),
						sv.getNamSinh());

				String sLP1 = "x";
				String sLP2 = "x";
				String sLP3 = "x";
				String sLP4 = "x";
				String sLP5 = "x";
				String sDTB = "x";
				DecimalFormat formatter = new DecimalFormat("#,###.0");
				for (DiemMonHoc x : sv.getDiemThi()) {
					String temp = formatter.format(x.getDiemThi());
					switch (x.getMonHoc().getMaMonHoc()) {
					case "LP1":
						sLP1 = temp;
						break;

					case "LP2":
						sLP2 = temp;
						break;

					case "LP3":
						sLP3 = temp;
						break;

					case "LP4":
						sLP4 = temp;
						break;

					case "LP5":
						sLP5 = temp;
						break;
					}
				}
				sDTB = formatter.format(sv.tinhDiemTrungBinhMon());
				System.out.printf("%10s%10s%10s%10s%10s%10s%n", sLP1, sLP2, sLP3, sLP4, sLP5, sDTB);
			}
		}

		printReportFooter();
	}
}
