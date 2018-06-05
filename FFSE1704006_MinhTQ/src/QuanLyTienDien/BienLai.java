package QuanLyTienDien;

public class BienLai extends KhachHang {

	private String kyTieuThu;
	private int soCu;
	private int soMoi;

	public BienLai(int maKhachHang, String tenKhachHang, String diaChi, int maCongTo, String kyTieuThu, int soCu,
			int soMoi) {
		super(maKhachHang, tenKhachHang, diaChi, maCongTo);
		this.kyTieuThu = kyTieuThu;
		this.soCu = soCu;
		this.soMoi = soMoi;

	}

	public String getKyTieuThu() {
		return kyTieuThu;
	}

	public void setKyTieuThu(String kyTieuThu) {
		this.kyTieuThu = kyTieuThu;
	}

	public double getSoCu() {
		return soCu;
	}

	public void setSoCu(int soCu) {
		this.soCu = soCu;
	}

	public double getSoMoi() {
		return soMoi;
	}

	public void setSoMoi(int soMoi) {
		this.soMoi = soMoi;
	}

	public double soTienPhaiTra() {
		double soTien = 0;
		if (soCu < soMoi) {
			soTien = (soMoi - soCu) * 3000;
		}
		return soTien;
	}

	public String toString() {
		return "\t" + this.maKhachHang + "\t\t" + this.tenKhachHang + "\t\t" + this.diaChi + "\t\t" + this.maCongTo + "\t\t"
				+ this.kyTieuThu + "\t\t" + this.soCu + "\t\t" + this.soMoi + "\t    ";

	}
}
