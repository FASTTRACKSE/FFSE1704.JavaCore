/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 22/06/2018
 */
package ffse.quanlythongtincanbo.util;

public class CBException extends Exception {

	private static final long serialVersionUID = 1L;
	int errorCode;
	
	public CBException (int errCode) {
		errorCode = errCode;
	}
	
	@Override
	public String toString() {
		String msg = "Lỗi không xác định!!!";
		
		switch (errorCode) {
		case 1:
			msg = "\nLỗi Không Nhập Tên hoặc nhập tên trên 40 ký tự ";
			break;
		case 2:
			msg = "\nChỉ được phép nhập số nguyên dương";
			break;
		case 3:
			msg = "\nLổi lựa chọn \nChỉ nhập số nguyên từ 1 or 2!";
			break;
		case 4:
			msg = "\nLổi lựa chọn \nChỉ nhập số nguyên từ 1 đến 3!";
			break;
		case 5:
			msg = "\nLổi lựa chọn \nChỉ nhập số nguyên từ 1 đến 5!";
			break;
		case 6:
			msg = "\nLổi lựa chọn \nChỉ nhập số nguyên từ 1 đến 9!";
			break;
		} 
		return msg;
	}
}