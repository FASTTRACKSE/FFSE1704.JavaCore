package javacore.qlcanbotruonghoc.myexception;

public class myException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int err;

	public myException(int a) {
		err = a;
	}

	public String toString() {
		String msg = "Lỗi không xác định, mời chạy lại !!!";
		switch (err) {
		case 1:
			msg = "Tên cần có độ dài từ 1 -> 40, xin vui lòng nhập lại!!! ";
			break;
		case 2:
			msg = "Bạn đã nhập sai, hãy chọn lại 1 => 5 tương ứng !!!";
			break;
		case 3:
			msg = "Vui lòng nhập lại số nguyên dương !!!";
			break;
		case 4:
			msg = "Mã cán bộ đã bị trùng, vui lòng nhập lại !!!";
			break;
		case 5:
			msg = "Hệ số lương là số thực, vui lòng nhập lại !!!";
			break;
		case 6:
			msg = "Vui lòng hãy nhập kiểu số !!! ";
			break;
		}
		return msg;
	}

}
