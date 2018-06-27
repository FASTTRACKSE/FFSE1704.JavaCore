package ffse.java.util;

public class MyException extends Exception{
	private int err;
	public MyException(int a) {
		err = a;
	}
	public String toString() {
		String smg ="lỗi không xác định mời chạy lại";
				switch(err) {
				case 1 :
					smg = "Lỗi nhập tên. Xin mời nhập lại tên ";
					break;
				case 2 :
					smg = "Phải nhập một trong ba giá trị : Cử nhân , Thạc sĩ ,Tiến sĩ";
					break;
				case 3 :
					smg = "Số tiết dạy phải là số thực \n nhập lại số tiết dạy ";
					break;
				case 4 :
					smg = "Hệ số Lương phải là số thực ";
					break;
				case 5 :
					smg = "Phải nhập một trong ba giá trị : Trưởng phòng , Phó phòng , Nhân viên ";
					break;
				case 6 :
					smg = "Số ngày làm phải là số thực ";
					break;
				}
				return smg;
	}
	

}
