package ffse.java.util;

import java.util.Collections;
import java.util.Comparator;

import ffse.java.entity.*;
import ffse.java.main.*;

public class CBComparator {

	
//		public static Comparator<CanBo> sapXepABC  = new Comparator <CanBo>() {
//			public int compare(CanBo cb1, CanBo cb2) {
//				  
//
//				   //descending order
//				   return cb1.getHoTen().compareTo(cb2.getHoTen());
//			    }};
//		
		public static Comparator <CanBo> sapXepLuong = new Comparator <CanBo>() {
			public int compare(CanBo cb1 , CanBo cb2) {
				if ((cb2.tinhLuong()-cb1.tinhLuong())<0)
					return 1;
				else if((cb2.tinhLuong()-cb1.tinhLuong())>0)
					return -1;
				else 
					return cb1.getTenCanBo().compareTo(cb2.getTenCanBo());
				
			}
		};
		
		
		
}
