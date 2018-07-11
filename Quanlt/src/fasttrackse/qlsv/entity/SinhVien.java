package fasttrackse.qlsv.entity;

public class SinhVien {
	private String maSV;
	private String hoSV;
	private String tenSV;
	private String gioitinhSV;
	private String namsinhSV;
	private String lopSV;

	public SinhVien(String maSV, String hoSV, String tenSV, String gioitinhSV, String namsinhSV, String lopSV) {
		super();
		this.maSV = maSV;
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.gioitinhSV = gioitinhSV;
		this.namsinhSV = namsinhSV;
		this.lopSV = lopSV;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoSV() {
		return hoSV;
	}

	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getGioitinhSV() {
		return gioitinhSV;
	}

	public void setGioitinhSV(String gioitinhSV) {
		this.gioitinhSV = gioitinhSV;
	}

	public String getNamsinhSV() {
		return namsinhSV;
	}

	public void setNamsinhSV(String namsinhSV) {
		this.namsinhSV = namsinhSV;
	}

	public String getLopSV() {
		return lopSV;
	}

	public void setLopSV(String lopSV) {
		this.lopSV = lopSV;
	}
}
