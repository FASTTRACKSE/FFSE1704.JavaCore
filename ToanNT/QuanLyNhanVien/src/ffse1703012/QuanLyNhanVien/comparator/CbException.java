package ffse1703012.QuanLyNhanVien.comparator;

public class CbException extends Exception {
		private static final long serialVersionUID = 1L;
		int errorCode;
		
		public CbException (int errCode) {
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
			case 3:
				msg = "Chỉ được nhập Cử nhân , Thạc sĩ, Tiến sĩ";
				break;
			case 4:
				msg = "Hệ số lương chỉ được nhập số thực! Nhập lại bạn nhé!";
				break;
			case 5:
				msg = "Chỉ được nhập Trưởng phòng , Phó phòng, Nhân viên";
				break;
			} 
			return msg;
		}
	}

