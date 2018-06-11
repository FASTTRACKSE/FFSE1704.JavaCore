package fasttrack.asm5.antity;

public class BienLai extends KhachHang {
	int chiSoCu;
	int chiSoMoi;
	int kyTieuThu;

	public BienLai(int maKhachHang, String tenKhachHang, String diaChi, int maCongTo, int chiSoCu, int chiSoMoi,
			int kyTieuThu) {
		super(maKhachHang, tenKhachHang, diaChi, maCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
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

	public int getKyTieuThu() {
		return kyTieuThu;
	}

	public void setKyTieuThu(int kyTieuThu) {
		this.kyTieuThu = kyTieuThu;
	}

	public int tieuThu() {
		return kyTieuThu;
	}

	public double soTienPhaiTra() {
		int soTien = 0;
		if (chiSoCu < chiSoMoi) {
			soTien = (chiSoMoi - chiSoCu) * 3000;
		}
		return soTien;
	}

	public String toString() {
		return "\t" + this.maKhachHang + "\t\t" + this.tenKhachHang + "\t\t" + this.diaChi + "\t\t" + this.maCongTo
				+ "\t\t" + this.kyTieuThu + "\t\t" + this.chiSoCu + "\t\t" + this.chiSoMoi + "\t    ";

	}

}