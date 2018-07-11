package fasttrackse.exeptionhandlingsamples.util;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int errorCode;
	
	public MyException (int errCode) {
		errorCode = errCode;
	}
	
	@Override
	public String toString() {
		String msg = "Lỗi không xác định!!!";
		
		switch (errorCode) {
		case 1:
			msg = "Tên giảng viên không được để trống";
			break;
		case 2:
			msg = "Tên giảng viên không được dài hơn 40 ký tự";
			break;
		case 3:
			msg = "Trình độ chỉ được chọn từ 1 -> 3";
			break;
		
		} 
		return msg;
	}
	
}
