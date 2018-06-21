package ffse.java.canbo.util;

import java.util.Comparator;

import ffse.java.canbo.entity.CanBo;

public class NVComparator {

	public static Comparator<CanBo> CanBoLuongASComparator = new Comparator<CanBo>() {

		public int compare(CanBo s1, CanBo s2) {

			/* For ascending order */
			if ((s2.tinhLuong() - s1.tinhLuong()) > 0)
				return 1;
			else if ((s2.tinhLuong() - s1.tinhLuong()) < 0)
				return -1;
			else

				return s1.getTenCanBo().compareTo(s2.getTenCanBo());

			
		}

	};
}