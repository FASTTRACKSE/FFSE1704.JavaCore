package quanglyluongnhanvien.java.entity;

public class NhanVienVanPhong extends Luong {
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	private double heSoLuong;

	public NhanVienVanPhong(int maNhanVien, String hoVaTen, String phongBan, String chucVu, int soNgayCong,
			double heSoLuong) {
		super(maNhanVien, hoVaTen);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
		this.heSoLuong = heSoLuong;
	}

	
	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

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

	public double tinhLuong() {
		double tinhLuong = 0;
		if ("Trưởng phòng".equals(getChucVu())) {
			return (this.heSoLuong * 730) + (2000) + (this.soNgayCong * 45);
		} else if ("Phó phòng".equals(getChucVu())) {
			return (this.heSoLuong * 730) + (1000) + (this.soNgayCong * 45);
		} else if ("Nhân viên".equals(getChucVu())) {
			return (this.heSoLuong * 730) + (500) + (this.soNgayCong * 45);
		}

		return tinhLuong;

	}


}
