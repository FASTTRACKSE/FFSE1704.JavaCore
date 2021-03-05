package examples.callback;

public class DangKyFacebook implements DangKy {
	@Override
	public void ThucHienDangKy(TaiKhoan tk) {
		System.out.println("Đăng ký Facebook thành công cho user " + tk.name);
	}

}
