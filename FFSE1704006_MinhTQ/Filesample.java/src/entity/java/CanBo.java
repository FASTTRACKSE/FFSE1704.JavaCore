package entity.java;

import java.io.Serializable;

public abstract class CanBo implements Serializable{

	private int maNhanVien;
	protected String hoVaTen;

	public CanBo(int maNhanVien, String hoVaTen) {

		this.maNhanVien = maNhanVien;
		this.hoVaTen = hoVaTen;

	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public abstract double tinhLuong();

	
}
