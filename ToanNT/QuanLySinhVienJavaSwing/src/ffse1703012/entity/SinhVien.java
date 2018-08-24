package ffse1703012.entity;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private String tuoiSV;
	private String lopSV;
	private String gioiTinh;
	
	
	
	public SinhVien(String maSV, String tenSV, String tuoiSV, String lopSV, String gioiTinh) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
		this.lopSV = lopSV;
		this.gioiTinh = gioiTinh;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getTuoiSV() {
		return tuoiSV;
	}
	public void setTuoiSV(String tuoiSV) {
		this.tuoiSV = tuoiSV;
	}
	public String getLopSV() {
		return lopSV;
	}
	public void setLopSV(String lopSV) {
		this.lopSV = lopSV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


}
