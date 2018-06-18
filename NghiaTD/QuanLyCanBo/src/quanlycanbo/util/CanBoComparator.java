package quanlycanbo.util;
import java.util.Comparator;
import quanlycanbo.entity.*;
public class CanBoComparator {
	public static Comparator<CanBo> CanBoLuongASComparator = new Comparator<CanBo>() {

		public int compare(CanBo s1, CanBo s2) {

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
