package ffse1703012.assignment.quanlytiendien;

public class BienLai extends KhachHang{
	private String kyTieuThu;
	private int chiSoCu;
	private int chiSoMoi;
	
	public BienLai() {
		super();
	}

	public BienLai(String hoTenChuNha, String soNha, String maKhachHang, int maSoCongTo, String kyTieuThu, int chiSoCu, int chiSoMoi) {
		super(hoTenChuNha, soNha, maKhachHang, maSoCongTo);
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
	
	public double soTienPhaiTra() {
		double soTien = 0;
		if(chiSoCu<chiSoMoi) {
			soTien = (chiSoMoi - chiSoCu)*300;
		}
		return soTien;
	}
}
