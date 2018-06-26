package javacore.fasttrackse.util;

public class CBException extends Exception {
	private static final long serialVersionUID = 1L;
	int errorCode;

	public CBException(int errCode) {
		errorCode = errCode;
	}

	public String toString() {
		String msg = "Lỗi không xác định";
		switch (errorCode) {
		case 1:
			msg = " Không được rỗng ,và có độ dài không quá 40 ký tự , Mời bạn nhập lại! ";
			break;
		case 2:
			msg = " Các trường số chỉ được phép nhập số dương, Yêu cầu bạn nhập lại! ";
			break;

		}
		return msg;
	}
}