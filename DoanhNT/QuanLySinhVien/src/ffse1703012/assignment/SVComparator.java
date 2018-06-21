package ffse1703012.assignment;
import ffse1703012.assignment.SinhVien;
import java.util.Comparator;

public class SVComparator {
	public static Comparator<SinhVien> SVNameASCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien sv1, SinhVien sv2) {
			String codesv1 = sv1.getTenSV().toUpperCase();
			String codesv2 = sv2.getTenSV().toUpperCase();

			// ascending order
			return codesv1.compareTo(codesv2);
		}
	};


	public static Comparator<SinhVien> SVNameDESCComparator = new Comparator<SinhVien>() {

		public int compare(SinhVien sv1, SinhVien sv2) {
			String namesv1 = sv1.getTenSV().toUpperCase();
			String namesv2 = sv2.getTenSV().toUpperCase();

			// descending order
			return namesv2.compareTo(namesv1);
		}
	};

	 /*Comparator for sorting the list by roll no*/
	 public static Comparator<SinhVien> SinhVienDTBASComparator = new
	 Comparator<SinhVien>() {
	
	 public int compare(SinhVien sv1, SinhVien sv2) {
	
	 double fDTB1 = sv1.tinhDTB();
	 double fDTB2 = sv2.tinhDTB();
	
	 /*For ascending order*/
	 if ((fDTB2 - fDTB1) > 0)
	 return 1;
	 else if ((fDTB2 - fDTB1) < 0)
	 return -1;
	 else
	 return 0;
	
	 /*For descending order*/
	 //fDTB1-fDTB2;
}};
}
