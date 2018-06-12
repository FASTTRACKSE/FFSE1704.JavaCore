package fasttrackse.javacore.entity;

import javax.swing.text.StringContent;

public abstract class SinhVien {
		protected String hoDemSV;
		protected String tenSV;
		protected String diaChiSV;
		protected int namSinhSV;

	public SinhVien(String hoDemSV, String tenSV, String diaChiSV, int namSinhSV) {
		this.hoDemSV = hoDemSV;
		this.tenSV = tenSV;
		this.diaChiSV = diaChiSV;
		this.namSinhSV = namSinhSV;
	}

	public abstract double tinhDTB();

	public String getHoDemSV() {
		return hoDemSV;
	}

	public void setHoDemSV(String hoDemSV) {
		this.hoDemSV = hoDemSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getDiaChiSV() {
		return diaChiSV;
	}

	public void setDiaChiSV(String diaChiSV) {
		this.diaChiSV = diaChiSV;
	}

	public int getNamSinhSV() {
		return namSinhSV;
	}

	public void setNamSinhSV(int namSinhSV) {
		this.namSinhSV = namSinhSV;
	}

	public abstract String xepLoaiSV();

}
