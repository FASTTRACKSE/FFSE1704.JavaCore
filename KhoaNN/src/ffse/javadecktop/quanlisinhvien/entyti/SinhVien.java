package ffse.javadecktop.quanlisinhvien.entyti;

public class SinhVien {
	private String maSinhVien;
	private String lopSinhVien;
	private String tenSinhVien;
	private String tuoiSinhVien;
	private String gioiTinhSinhVien;

	public SinhVien(String maSinhVien, String lopSinhVien, String tenSinhVien, 
			String GioiTinhSinhVien, String tuoiSinhVien) {

		this.maSinhVien = maSinhVien;
		this.lopSinhVien = lopSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.gioiTinhSinhVien = GioiTinhSinhVien;
		this.tuoiSinhVien = tuoiSinhVien;

	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getLopSinhVien() {
		return lopSinhVien;
	}

	public void setLopSinhVien(String lopSinhVien) {
		this.lopSinhVien = lopSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getGioiTinhSinhVien() {
		return gioiTinhSinhVien;
	}

	public void setGioiTinhSinhVien(String gioiTinhSinhVien) {
		this.gioiTinhSinhVien = gioiTinhSinhVien;
	}

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

}