package fasttrack.quanlycanboluufile.util;

public class myException extends Exception {

	private int err;

	public myException(int a) {
		err = a;
	}

	@Override
	public String toString() {
		String msg = "Lỗi không xác định, mời chạy lại !!!";
		switch (err) {
		case 1:
			msg = "Không được để trống và ko quá 40 kí tự, xin vui lòng nhập lại!!! \n ";
			break;
		case 2:
			msg = "Bạn đã nhập sai, hãy chọn lại 1 2 hoặc 3 tương ứng !!!";
			break;
		case 3:
			msg = "Vui lòng nhập lại số nguyên dương !!!";
			break;
		case 4:
			msg = "Mã cán bộ đã bị trùng, vui lòng nhập lại !!!";
			break;
		case 5:
			msg = "Hệ số lương là số thực, vui lòng nhập lại !!!";
			break;
		case 6:
			msg = "Vui lòng hãy nhập kiểu số !!! ";
			break;
		case 7:
			msg = "Chỉ nhập từ 1 đến 5, nhập lại nhé bạn hiền! ";
			break;
		}
		return msg;
	}

}
