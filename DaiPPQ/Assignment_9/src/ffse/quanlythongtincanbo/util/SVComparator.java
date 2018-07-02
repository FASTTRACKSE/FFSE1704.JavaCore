/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 15/06/2018
 */
package ffse.quanlythongtincanbo.util;

import java.util.Comparator;

import ffse.quanlythongtincanbo.entity.NhanVien;

public class SVComparator {

	public static Comparator<NhanVien> NhanVienLuongASComparator = new Comparator<NhanVien>() {

		public int compare(NhanVien s1, NhanVien s2) {
			if ((s2.tinhLuong() - s1.tinhLuong()) > 0)
				return 1;
			else if ((s2.tinhLuong() - s1.tinhLuong()) < 0)
				return -1;
			else
				return s1.getTen().compareTo(s2.getTen());

		}

	};
}