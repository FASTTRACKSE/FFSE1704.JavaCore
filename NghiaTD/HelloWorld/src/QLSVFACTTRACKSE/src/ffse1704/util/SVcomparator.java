package QLSVFACTTRACKSE.src.ffse1704.util;
import java.util.Comparator;
import QLSVFACTTRACKSE.src.ffse1704.entity.*;
public class SVcomparator {

	public static Comparator<SinhVien> SVCodeASCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getTenSV().toUpperCase();
			String codeKH2 = kh2.getTenSV().toUpperCase();

			// ascending order
			return codeKH1.compareTo(codeKH2);
		}
	};

	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> SVCodeDESCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getTenSV().toUpperCase();
			String codeKH2 = kh2.getTenSV().toUpperCase();

			// descending order
			return codeKH2.compareTo(codeKH1);
		}
	};

	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> KHNameASCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getTenSV().toUpperCase();
			String codeKH2 = kh2.getTenSV().toUpperCase();

			// ascending order
			return codeKH1.compareTo(codeKH2);
		}
	};

	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> KHNameDESCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getTenSV().toUpperCase();
			String codeKH2 = kh2.getTenSV().toUpperCase();

			// descending order
			return codeKH2.compareTo(codeKH1);
		}
	};

	// /*Comparator for sorting the list by roll no*/
	// public static Comparator<SinhVien> SinhVienDTBDESComparator = new
	// Comparator<SinhVien>() {
	//
	// public int compare(SinhVien s1, SinhVien s2) {
	//
	// float fDTB1 = s1.getDiemTB();
	// float fDTB2 = s2.getDiemTB();
	//
	// /*For ascending order*/
	// if ((fDTB2 - fDTB1) > 0)
	// return 1;
	// else if ((fDTB2 - fDTB1) < 0)
	// return -1;
	// else
	// return 0;
	//
	// /*For descending order*/
	// //fDTB1-fDTB2;
	// }};


}
