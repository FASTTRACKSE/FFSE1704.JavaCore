package ffse.quanlynhanvien.util;

import java.util.Comparator;

import ffse.quanlynhanvien.entity.ThongTin;

public class NVComparator {

	// public static Comparator<ThongTin> CBCodeASCComparator = new
	// Comparator<ThongTin>() {
	//
	// public int compare(ThongTin kh1, ThongTin kh2) {
	// String codeKH1 = kh1.getTenGV().toUpperCase();
	// String codeKH2 = kh2.getTenGV().toUpperCase();
	//
	// // ascending order
	// return codeKH1.compareTo(codeKH2);
	// }
	// };

	// public static Comparator<ThongTin> CBCodeDESCComparator = new
	// Comparator<ThongTin>() {
	//
	// public int compare(ThongTin kh1, ThongTin kh2) {
	// String codeCB1 = kh1.getTenGV().toUpperCase();
	// String codeCB2 = kh2.getTenGV().toUpperCase();
	//
	// // descending order
	// return codeCB2.compareTo(codeCB1);
	// }
	// };

	// public static Comparator<ThongTin> CBNameASCComparator = new
	// Comparator<ThongTin>() {
	//
	// public int compare(ThongTin kh1, ThongTin kh2) {
	// String codeCB1 = kh1.getTenGV().toUpperCase();
	// String codeCB2 = kh2.getTenGV().toUpperCase();
	//
	// // ascending order
	// return codeCB1.compareTo(codeCB2);
	// }
	// };

	// public static Comparator<ThongTin> CBNameDESCComparator = new
	// Comparator<ThongTin>() {
	//
	// public int compare(ThongTin kh1, ThongTin kh2) {
	// String codeCB1 = kh1.getTenGV().toUpperCase();
	// String codeCB2 = kh2.getTenGV().toUpperCase();
	//
	// // descending order
	// return codeCB2.compareTo(codeCB1);
	// }
	// };

	public static Comparator<ThongTin> CanBoLuongASComparator = new Comparator<ThongTin>() {

		public int compare(ThongTin s1, ThongTin s2) {

			double fLuong1 = s1.tinhLuong();
			double fLuong2 = s2.tinhLuong();

			/* For ascending order */
			if ((fLuong2 - fLuong1) > 0)
				return 1;
			else if ((fLuong2 - fLuong1) < 0)
				return -1;
			else
				return 0;

			/* For descending order */
			// fDTB1-fDTB2;
		}
	};
}
