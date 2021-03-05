package codemaster.customexception.business;


public class MyException extends Exception {
	private int errorCode; 
	
	public MyException() {
	}

	public MyException(String message) {
		super(message);
	}
	
	public MyException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public MyException(int errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		String msg = "";
		switch (errorCode) {
		case 1: 
			msg = "Dữ liệu nhập không phải kiểu số, mời bạn nhập lại";
			break;
		case 2:
			msg = "Không được nhập số âm";
			break;
		case 3:
			msg = "Số phải nhỏ hơn 2020";
			break;
		default:
			msg = "Lỗi không xác định, mời chạy lại!";
			break;
		}
		return msg;
	}
}
