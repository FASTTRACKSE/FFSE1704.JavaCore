package project.lp5.entity;

public class TruongHoc {
	private String maSV;
	private String lopSV;
	private String hoTenSV;
	private String diaChiSV;
	private String phuongSV;
	private String quanSV;
	private String tinhTP;
	private int dienThoai;
	private String tenEmail;
	
	public TruongHoc(String maSV, String lopSV, String hoTenSV, String diaChiSV, String phuongSV, String quanSV,
			String tinhTP, int dienThoai, String tenEmail) {
		super();
		this.maSV = maSV;
		this.lopSV = lopSV;
		this.hoTenSV = hoTenSV;
		this.diaChiSV = diaChiSV;
		this.phuongSV = phuongSV;
		this.quanSV = quanSV;
		this.tinhTP = tinhTP;
		this.dienThoai = dienThoai;
		this.tenEmail = tenEmail;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getLopSV() {
		return lopSV;
	}

	public void setLopSV(String lopSV) {
		this.lopSV = lopSV;
	}

	public String getHoTenSV() {
		return hoTenSV;
	}

	public void setHoTenSV(String hoTenSV) {
		this.hoTenSV = hoTenSV;
	}

	public String getDiaChiSV() {
		return diaChiSV;
	}

	public void setDiaChiSV(String diaChiSV) {
		this.diaChiSV = diaChiSV;
	}

	public String getPhuongSV() {
		return phuongSV;
	}

	public void setPhuongSV(String phuongSV) {
		this.phuongSV = phuongSV;
	}

	public String getQuanSV() {
		return quanSV;
	}

	public void setQuanSV(String quanSV) {
		this.quanSV = quanSV;
	}

	public String getTinhTP() {
		return tinhTP;
	}

	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}

	public int getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(int dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getTenEmail() {
		return tenEmail;
	}

	public void setTenEmail(String tenEmail) {
		this.tenEmail = tenEmail;
	}

}
