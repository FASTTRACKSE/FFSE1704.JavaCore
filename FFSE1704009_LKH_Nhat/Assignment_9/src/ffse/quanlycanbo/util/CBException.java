/************************
 *Prog: QUẢN LÝ CÁN BỘ
 *@AUTHOR: LÊ KHẢ HỒNG NHẬT
 *Date: 22/06/2018
 **********************/
package ffse.quanlycanbo.util;

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
			msg = "Lỗi Không Nhập Tên hoặc nhập tên trên 40 ký tự ";
			break;
		case 2:
			msg = "Các trường số chỉ được phép nhập số dương";
			break;
		
		
		} 
		return msg;
	}
}
