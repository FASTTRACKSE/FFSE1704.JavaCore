package ffse1703012.assignment.quanlytiendien;

public class BienLai {
	private String kyTieuThu;
	private int chiSoCu;
	private int chiSoMoi;


	public BienLai(String kyTieuThu, int chiSoCu, int chiSoMoi) {
		this.kyTieuThu = kyTieuThu;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;

	}

	public String getKyTieuThu() {
		return kyTieuThu;
	}

	public void setKyTieuThu(String kyTieuThu) {
		this.kyTieuThu = kyTieuThu;
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
	
	public void soTienPhaiTra() {
		double soTien=0;
		if(chiSoCu<chiSoMoi) {
			soTien = (chiSoMoi - chiSoCu)*300;
		}
		return soTien;
	}
}
