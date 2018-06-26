package ffse.quanlithongtin.util;

import java.util.Comparator;

import ffse.quanlithongtin.enity.ThongTin;

public class NVComparator {

	public static Comparator<ThongTin> CanBoLuongDESCCanBoTenASComparator = new Comparator<ThongTin>() {

		public int compare(ThongTin s1, ThongTin s2) {

			/* For ascending order */
			if ((s2.tinhLuong() - s1.tinhLuong()) > 0)
				return 1;
			else if ((s2.tinhLuong() - s1.tinhLuong()) < 0)
				return -1;
			else

				return s1.gethoTen().compareTo(s2.gethoTen());

			/* For descending order */
			// fDTB1-fDTB2;
		}

	};

}