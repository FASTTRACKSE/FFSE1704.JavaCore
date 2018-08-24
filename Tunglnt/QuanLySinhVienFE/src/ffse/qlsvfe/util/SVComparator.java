package ffse.qlsvfe.util;

import java.util.Comparator;

import ffse.qlsvfe.entity.SinhVien;
public class SVComparator {
	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> SVCodeASCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien sv1, SinhVien sv2) {
			String codeKH1 = sv1.getHoTen().toUpperCase();
			String codeKH2 = sv2.getHoTen().toUpperCase();

			// ascending order
			return codeKH1.compareTo(codeKH2);
		}
	};

	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> SVCodeDESCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getHoTen().toUpperCase();
			String codeKH2 = kh2.getHoTen().toUpperCase();

			// descending order
			return codeKH2.compareTo(codeKH1);
		}
	};

	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> KHNameASCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getHoTen().toUpperCase();
			String codeKH2 = kh2.getHoTen().toUpperCase();

			// ascending order
			return codeKH1.compareTo(codeKH2);
		}
	};

	/* Comparator for sorting the list KhachHang by MaKH */
	public static Comparator<SinhVien> KHNameDESCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien kh1, SinhVien kh2) {
			String codeKH1 = kh1.getHoTen().toUpperCase();
			String codeKH2 = kh2.getHoTen().toUpperCase();

			// descending order
			return codeKH2.compareTo(codeKH1);
		}
	};

	// /*Comparator for sorting the list by roll no*/
	 public static Comparator<SinhVien> SinhVienDTBDESComparator = new
	 Comparator<SinhVien>() {
	//
	 public int compare(SinhVien s1, SinhVien s2) {
	//
	 double fDTB1 = s1.tinhDiemTb();
	 double fDTB2 = s2.tinhDiemTb();
	//
	// /*For ascending order*/
	 if ((fDTB2 - fDTB1) > 0)
	 return 1;
	else if ((fDTB2 - fDTB1) < 0)
	 return -1;
	 else
	 return 0;
	//
	// /*For descending order*/
	//fDTB1-fDTB2;
	}};
}