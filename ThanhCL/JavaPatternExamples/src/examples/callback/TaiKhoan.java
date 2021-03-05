package examples.callback;

public class TaiKhoan {
	String name;
	
	public TaiKhoan(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void DangKyDichVu(DangKy dangKyDichVu) {
		dangKyDichVu.ThucHienDangKy(this);
	}
}
