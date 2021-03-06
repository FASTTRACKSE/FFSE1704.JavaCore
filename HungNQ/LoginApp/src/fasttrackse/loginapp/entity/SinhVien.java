package fasttrackse.loginapp.entity;

public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
	private String lopSinhVien;
	private String tuoiSinhVien;
	private String gioiTinhSinhVien;

	public SinhVien(String maSinhVien, String tenSinhVien, String lopSinhVien, String tuoiSinhVien,
			String gioiTinhSinhVien) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.lopSinhVien = lopSinhVien;
		this.tuoiSinhVien = tuoiSinhVien;
		this.gioiTinhSinhVien = gioiTinhSinhVien;
	}

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getLopSinhVien() {
		return lopSinhVien;
	}

	public void setLopSinhVien(String lopSinhVien) {
		this.lopSinhVien = lopSinhVien;
	}

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getGioiTinhSinhVien() {
		return gioiTinhSinhVien;
	}

	public void setGioiTinhSinhVien(String gioiTinhSinhVien) {
		this.gioiTinhSinhVien = gioiTinhSinhVien;
	}

}