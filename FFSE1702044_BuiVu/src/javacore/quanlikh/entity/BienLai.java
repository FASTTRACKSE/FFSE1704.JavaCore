package javacore.quanlikh.entity;

public class BienLai{
	protected int chiSoCu;
	protected int chiSoMoi;
	protected int ckThang;
	protected int ckNam;
	
	public BienLai(int chiSoCu,int chiSoMoi,int ckThang, int ckNam) {
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		this.ckThang=ckThang;
		this.ckNam=ckNam;
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
	public int getChiSoCu() {
		return chiSoCu;
	}
	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu=chiSoCu;
	}
	public int getChiSoMoi() {
		return chiSoMoi;
	}
	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi=chiSoMoi;
	}
	public long tinhTienDien() {
		return (chiSoMoi-chiSoCu)*3000;
	}
}

