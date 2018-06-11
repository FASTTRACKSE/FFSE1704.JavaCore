package Assgnment5.src.entity;

public class BienLai {
	protected String maCongTo;
	protected int chuKyThang;
	protected int chuKyNam;
	protected int csDauKy;
	protected int csCuoiKy;
	
	public BienLai(String maCongTo,int chuKyThang,int chuKyNam,int csDauKy,int csCuoiKy) {
		this.maCongTo=maCongTo;
		this.chuKyThang=chuKyThang;
		this.chuKyNam=chuKyNam;
		this.csDauKy=csDauKy;
		this.csCuoiKy=csCuoiKy;
	}
	
	
	public String getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}
	public int getChuKyThang() {
		return chuKyThang;
	}
	public void setChuKyThang(int chuKyThang) {
		this.chuKyThang = chuKyThang;
	}
	public int getChuKyNam() {
		return chuKyNam;
	}
	public void setChuKyNam(int chuKyNam) {
		this.chuKyNam = chuKyNam;
	}
	public int getCsDauKy() {
		return csDauKy;
	}
	public void setCsDauKy(int csDauKy) {
		this.csDauKy = csDauKy;
	}
	public int getCsCuoiKy() {
		return csCuoiKy;
	}
	public void setCsCuoiKy(int csCuoiKy) {
		this.csCuoiKy = csCuoiKy;
	}
	public long tinhTongTien() {
		return (this.csCuoiKy-this.csDauKy)*300;
	}


}