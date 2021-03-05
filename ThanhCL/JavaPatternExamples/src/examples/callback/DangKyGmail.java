package examples.callback;

public class DangKyGmail implements DangKy {

	@Override
	public void ThucHienDangKy(TaiKhoan tk) {
		System.out.println("Đăng ký GMAIL thành công cho user " + tk.name);		
	}
}
