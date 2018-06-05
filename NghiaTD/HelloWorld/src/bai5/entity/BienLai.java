package bai5.entity;

public class BienLai {
	private String kyTieuThu;
	private int chiSoCu;
	private int chiSoMoi;
	
	public BienLai(String kyTieuThu,int chiSoCu,int chiSoMoi) {
		this.kyTieuThu=kyTieuThu;
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
	}
	public String getkyTieuThu() {
		return kyTieuThu;
	}
	public void setkyTieuThu() {
		this.kyTieuThu=kyTieuThu;
	}
	public int getchiSoCu() {
		return chiSoCu;
	}
	public void setchiSoCu() {
		this.chiSoCu=chiSoCu;
	}
	
	public int getchiSoMoi() {
		return chiSoMoi;
	}
	public void setchiSoMoi() {
		this.chiSoMoi= chiSoMoi;
	}
	public double sotienphaitra() {
		double sotientra=0;
		if(chiSoMoi>chiSoCu) {
			sotientra=(chiSoMoi-chiSoCu)*3000;
		}
		return sotientra;
		
		
	}
}
