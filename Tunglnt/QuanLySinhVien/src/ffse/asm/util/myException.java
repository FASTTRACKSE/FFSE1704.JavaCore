package ffse.asm.util;

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
			msg = "Vui Lòng Nhập ID Khách Hàng!!! ";
			break;
		case 2:
			msg = "Bạn đã nhập sai, hãy chọn lại 1 => 7 tương ứng !!!";
			break;
		case 3:
			msg = "Vui lòng nhập không để trống !!!";
			break;
		case 4:
			msg = "Mã cán bộ đã bị trùng, vui lòng nhập lại !!!";
			break;
		case 5:
			msg = "Vui Lòng Nhập Từ 1-15 kí Tự";
			break;
		case 6:
			msg = "Vui lòng Nhập Số Lượng!!! ";
			break;
		case 7:
			msg = "Vui Lòng Nhập Từ 1-50 kí Tự!!! ";
			break;
		case 8:
			msg = "Vui Lòng Nhập Từ 1-12 Số!!! ";
			break;
		}
		return msg;
	}

}
