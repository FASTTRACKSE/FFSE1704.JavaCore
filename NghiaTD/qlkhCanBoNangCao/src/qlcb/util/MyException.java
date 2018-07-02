package qlcb.util;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	int errorCode;
	public MyException(int errCode) {
		errorCode = errCode;
	}
	public String toString() {
		String msg = "Lỗi không xác định";
		switch(errorCode) {
		case 1:
			msg = "Lỗi định mệnh";
			break;
		case 2:
			msg = "Lỗi hơi nhỏ";
			break;
		case 3:
			msg = "Lỗi không hề nhỏ";
			break;
		}
		return msg;
	}
}
