package ffse1703012.entity;

import java.util.ArrayList;

public class DiemSV {
	private String maSv, maMon, diem;
	public DiemSV() {
		//
	}
	
	public DiemSV(String maSv, String maMon, String diem) {
		this.maSv = maSv;
		this.maMon = maMon;
		this.diem = diem;
	}
	
	public DiemSV(String diem) {
		this.diem = diem;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return this.maSv + this.maMon;
	}


	

}
