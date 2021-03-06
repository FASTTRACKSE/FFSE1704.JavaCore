/************************
 *Prog: QUẢN LÝ TIỀN ĐIỆN
 *@AUTHOR: Phan Phạm Quang Dai
 *Date: 06/06/2018
 **********************/
package Assignment_5.src.ffse.quanlytiendien.entity;

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

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public double soTienPhaiTra() {
		double soTien = 0;
		if (chiSoCu < chiSoMoi) {
			soTien = (chiSoMoi - chiSoCu) * 3000;
		}
		return soTien;
	}

}