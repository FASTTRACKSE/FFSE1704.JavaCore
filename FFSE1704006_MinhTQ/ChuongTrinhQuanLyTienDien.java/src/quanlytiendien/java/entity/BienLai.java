package quanlytiendien.java.entity;

public class BienLai {

	private String kyTieuThu;
	private int soCu;
	private int soMoi;
	


	public BienLai( String kyTieuThu,  int soCu, int soMoi ) {
		
		this.kyTieuThu = kyTieuThu;
		this.soCu= soCu;
		this.soMoi = soMoi;
		
	}


	public BienLai() {
		// TODO Auto-generated constructor stub
	}


	public String getKyTieuThu() {
		return kyTieuThu;
	}

	public void setKyTieuThu(String kyTieuThu) {
		this.kyTieuThu = kyTieuThu;
	}

	public int getSoCu() {
		return soCu;
	}

	public void setSoCu(int soCu) {
		this.soCu = soCu;
	}

	public int getSoMoi() {
		return soMoi;
	}

	public void setSoMoi(int soMoi) {
		this.soMoi = soMoi;
	}
	 public int soTienPhaiTra() {
		int soTien = 0;
		if (soCu < soMoi) {
			Math.round(soTien = (soMoi - soCu) * 3000);
		}
		return soTien;
	}

}
