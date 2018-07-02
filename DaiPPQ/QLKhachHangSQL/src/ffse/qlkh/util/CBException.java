/**
 *	Prog: QUẢN LÝ THÔNG TIN CÁN BỘ
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 22/06/2018
 */
package ffse.qlkh.util;

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
			msg = "\nLỗi chưa nhập dử liệu \nHảy nhập lại : ";
			break;
		case 2:
			msg = "\nLỗi Không Nhập Tên hoặc nhập tên trên 40 ký tự";
			break;
		case 3:
			msg = "\nChỉ được phép nhập số nguyên dương";
			break;
		case 4:
			msg = "\\nLổi lựa chọn \\nChỉ nhập số từ 1 đến 6!";
			break;
		} 
		return msg;
	}
}