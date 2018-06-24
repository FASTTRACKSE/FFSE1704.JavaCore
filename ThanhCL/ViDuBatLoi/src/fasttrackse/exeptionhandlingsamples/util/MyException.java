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
			msg = "Lỗi chia cho 0";
			break;
		case 2:
			msg = "Lỗi tràn mảng";
			break;
		case 3:
			msg = "Lỗi nhập sai kiểu dữ liệu";
			break;
		
		} 
		return msg;
	}
	
}
