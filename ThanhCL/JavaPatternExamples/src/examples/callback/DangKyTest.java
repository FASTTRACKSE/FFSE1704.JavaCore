package examples.callback;

public class DangKyTest {

	public static void main(String[] args) {
		DangKyGmail dvGmail = new DangKyGmail();
		DangKyFacebook dvFacebook = new DangKyFacebook();

		TaiKhoan tk1 = new TaiKhoan("ThanhCL");
		TaiKhoan tk2 = new TaiKhoan("HongLTM");
		
		tk1.DangKyDichVu(dvGmail);
		tk2.DangKyDichVu(dvFacebook);
	}

}
