package ffse.quanlynhanvien.entity;

public class NhanVien extends CanBo {
	// private String tenNV;
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	private double heSoLuong;
	// private int phuCap;

	public NhanVien(String tenCanBo, String phongBan, String chucVu, int soNgayCong, double heSoLuong) {
		super(tenCanBo);
		// this.tenNV = tenNV;
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
		this.heSoLuong = heSoLuong;

	}

	// public String getTenNV() {
	// return tenNV;
	// }
	//
	// public void setTenNV(String tenNV) {
	// this.tenNV = tenNV;
	// }

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	// public int getPhuCap() {
	// return phuCap;
	// }
	//
	// public void setPhuCap(int phuCap) {
	// this.phuCap = phuCap;
	// }

	@Override
	public double tinhLuong() {
		double luong = 0;

		if ("Trưởng phòng".equals(getChucVu()) || "Trưởng Phòng".equals(getChucVu())
				|| "trưởng phòng".equals(getChucVu())) {
			luong = (this.heSoLuong * 730) + 2000 + (this.soNgayCong * 30);
		} else {
			if ("Phó phòng".equals(getChucVu()) || "Phó Phòng".equals(getChucVu()) || "phó phòng".equals(getChucVu())) {
				luong = (this.heSoLuong * 730) + 1000 + (this.soNgayCong * 30);
			} else {
				if ("Nhân viên".equals(getChucVu()) || "Nhân Viên".equals(getChucVu())
						|| "nhân viên".equals(getChucVu())) {
					luong = (this.heSoLuong * 730) + 500 + (this.soNgayCong * 30);
				}
			}
		}

		return luong;
		// return (this.heSoLuong * 730) + this.phuCap + (this.soNgayCong * 30);
	}

}
