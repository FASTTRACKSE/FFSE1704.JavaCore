package javacore.entity;

public class BienLai  {
	protected String maCongTo;
	protected int chiSoCu;
	protected int chiSoMoi;
	protected int ckThang;
	protected int ckNam;
	
	public BienLai(String maCongTo, int ckThang, int ckNam, int chiSoCu, int chiSoMoi) {
		
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.ckThang = ckThang;
		this.ckNam = ckNam;
		this.maCongTo = maCongTo;
	}

	public String getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public int getCkThang() {
		return ckThang;
	}

	public void setCkThang(int ckThang) {
		this.ckThang = ckThang;
	}

	public int getCkNam() {
		return ckNam;
	}

	public void setCkNam(int ckNam) {
		this.ckNam = ckNam;
	}

public long tinhTienTrongKy() {
	return (this.chiSoMoi - this.chiSoCu)*3000;
}


}
