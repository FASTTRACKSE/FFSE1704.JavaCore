package fasttrackse.qlsv2.util;
import java.util.*;
import fasttrackse.qlsv2.antity.*;
public class Util {
	public static Comparator<SinhVienDaiHan> SXSVDaiHan = new Comparator<SinhVienDaiHan>() {
		
		@Override
		public int compare(SinhVienDaiHan o1, SinhVienDaiHan o2) {
			if (o1.tinhTB() < o2.tinhTB()) {
				return 1;
			} else if (o1.tinhTB() > o2.tinhTB()) {
				return -1;
			} else {
				return 0;
			}
		}
	};
	public static Comparator<SinhVienWebCapToc> SXSVWCapToc = new Comparator<SinhVienWebCapToc>() {
		
		@Override
		public int compare(SinhVienWebCapToc o1, SinhVienWebCapToc o2) {
			if (o1.tinhTB() < o2.tinhTB()) {
				return 1;
			} else if (o1.tinhTB() > o2.tinhTB()) {
				return -1;
			} else {
				return 0;
			}
		}
	};
	public static Comparator<SinhVienJavaCapToc> SXSVJVCapToc = new Comparator<SinhVienJavaCapToc>() {
		
		@Override
		public int compare(SinhVienJavaCapToc o1, SinhVienJavaCapToc o2) {
			if (o1.tinhTB() < o2.tinhTB()) {
				return 1;
			} else if (o1.tinhTB() > o2.tinhTB()) {
				return -1;
			} else {
				return 0;
			}
		}
	};
}