package fasttrackse.assignment8.util;

import java.util.Comparator;

import fasttrackse.assignment8.entity.CanBo;

public class CBComparator {

	public static Comparator<CanBo> CBLuongDESCComparator = new Comparator<CanBo>() {

		public int compare(CanBo cb1, CanBo cb2) {
			double luongCB1 = cb1.tinhLuong();
			double luongCB2 = cb2.tinhLuong();

			if (luongCB1 > luongCB2) {
				return -1;
			} else if (luongCB1 < luongCB2) {
				return 1;
			} else {
				return 0;
			}
		}
	};

	public static Comparator<CanBo> CBLuongDESCTenCBASCComparator = new Comparator<CanBo>() {

		public int compare(CanBo cb1, CanBo cb2) {
			double luongCB1 = cb1.tinhLuong();
			double luongCB2 = cb2.tinhLuong();
			String tenCB1 = cb1.getTenCB();
			String tenCB2 = cb2.getTenCB();

			if (luongCB1 > luongCB2) {
				return -1;
			} else if (luongCB1 < luongCB2) {
				return 1;
			} else {
				return tenCB1.compareTo(tenCB2);
			}
		}
	};

}
