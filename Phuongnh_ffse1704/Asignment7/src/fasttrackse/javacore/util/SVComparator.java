package fasttrackse.javacore.util;
import fasttrackse.javacore.main.*;
import fasttrackse.javacore.entity.*;
import java.util.Comparator;
public class SVComparator {

	
		public static Comparator<SinhVien> sapXepTheoABC = new Comparator<SinhVien>() {

			public int compare(SinhVien sv1, SinhVien sv2) {
			   String codeSV1 = sv1.getTenSV().toUpperCase();
			   String codeSV2 = sv2.getTenSV().toUpperCase();

			   //descending order
			   return codeSV1.compareTo(codeSV2);
		    }};
		    public static Comparator<SinhVien> sapXepTheoDTB = new Comparator<SinhVien>() {
		    	
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


