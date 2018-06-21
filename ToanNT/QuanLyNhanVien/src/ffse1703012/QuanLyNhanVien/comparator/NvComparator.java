package ffse1703012.QuanLyNhanVien.comparator;
import java.util.Comparator;

import ffse1703012.QuanLyNhanVien.entity.NhanVien;
public class NvComparator {
	public static Comparator<NhanVien> NVNameASCComparator = new Comparator<NhanVien>() {

		public int compare(NhanVien nv1, NhanVien nv2) {
			String codenv1 = nv1.getHoTen().toUpperCase();
			String codenv2 = nv2.getHoTen().toUpperCase();

			// ascending order
			return codenv1.compareTo(codenv2);
		}
	};


	public static Comparator<NhanVien> NVNameDESCComparator = new Comparator<NhanVien>() {

		public int compare(NhanVien nv1, NhanVien nv2) {
			String namenv1 = nv1.getHoTen().toUpperCase();
			String namenv2 = nv2.getHoTen().toUpperCase();

			// descending order
			return namenv2.compareTo(namenv1);
		}
	};

	 /*Comparator for sorting the list by roll no*/
	 public static Comparator<NhanVien> NhanVienLTBASComparator = new
	 Comparator<NhanVien>() {
	
	 public int compare(NhanVien nv1, NhanVien nv2) {
	
	 double fTL1 = nv1.tinhLuong();
	 double fTL2 = nv2.tinhLuong();
	
	 /*For ascending order*/
	 if ((fTL2 - fTL1) > 0)
	 return 1;
	 else if ((fTL2 - fTL1) < 0)
	 return -1;
	 else
	 return 0;
	
	 /*For descending order*/
	 //fDTB1-fDTB2;
}};
}
