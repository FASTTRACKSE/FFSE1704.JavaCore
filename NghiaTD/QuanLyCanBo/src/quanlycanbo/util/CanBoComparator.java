package quanlycanbo.util;
import java.util.Comparator;
import quanlycanbo.entity.*;
public class CanBoComparator {
	public static Comparator<CanBo> CanBoLuongASComparator = new Comparator<CanBo>() {

		public int compare(CanBo s1, CanBo s2) {

		

			/* For ascending order */
			if ((s2.tinhLuong() - s1.tinhLuong()) > 0)
				return 1;
			else if  ((s2.tinhLuong() - s1.tinhLuong()) < 0)
				return -1;
			else
				return s1.getHoTen().compareTo(s2.getHoTen()) ;
				

			/* For descending order */
			// fDTB1-fDTB2;
		}
	};
}
