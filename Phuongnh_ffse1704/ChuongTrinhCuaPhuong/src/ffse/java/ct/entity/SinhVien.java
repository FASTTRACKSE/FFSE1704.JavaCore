package ffse.java.ct.entity;

public class SinhVien {
	String maSinhVien ;
	String lopSinhVien ;
	String tenSinhVien ;
	String tuoiSinhVien ;
	public SinhVien(String maSinhVien,String lopSinhVien , String tenSinhVien, String tuoiSinhVien) {
		super();
		this.maSinhVien = maSinhVien;
		this.lopSinhVien = lopSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.tuoiSinhVien = tuoiSinhVien;
	}
	public SinhVien() {
		
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public String getLopSinhVien() {
		return lopSinhVien;
	}
	public void setLopSinhVien(String lopSinhVien) {
		this.lopSinhVien = lopSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getTenSinhVien() {
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}
	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

}
