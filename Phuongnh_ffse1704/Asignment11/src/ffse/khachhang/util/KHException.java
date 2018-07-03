

package ffse.khachhang.util;

public class KHException extends Exception {
	private static final long serialVersionUID = 1L;
	int errorCode;

	public  KHException (int errCode) {
		errorCode = errCode;
	}

	@Override
	public String toString() {
		String msg = "Lỗi không xác định!!!";

		switch (errorCode) {
		case 1:
			msg = "Lỗi Không Nhập Tên hoặc nhập tên trên 40 ký tự ";
			break;
		case 2:
			msg = "mã khách hàng phải gồm chữ và số";
			break;
		case 3:
			msg = "Các trường số chỉ được phép nhập số dương";
			break;
		case 4:
			msg = "Số điện thoại không được để trống và không được vượt quá 11 ký tự";
			break;
		case 5:
			msg = "Địa chỉ không được để trống";
			break;
		}
		return msg;
	}
}