package ffse.javacore.util;

import java.util.Comparator;

import ffse.javacore.entity.QuanLiCanBo;


public class NVComparator {

	public static Comparator<QuanLiCanBo> CanBoLuongASComparator = new Comparator<QuanLiCanBo>() {

		public int compare(QuanLiCanBo s1, QuanLiCanBo s2) {

			/* For ascending order */
			if ((s2.tinhLuong() - s1.tinhLuong()) > 0)
				return 1;
			else if ((s2.tinhLuong() - s1.tinhLuong()) < 0)
				return -1;
			else

				return s1.getHoTen().compareTo(s2.getHoTen());

			/* For descending order */
			// fDTB1-fDTB2;
		}
	};
}
