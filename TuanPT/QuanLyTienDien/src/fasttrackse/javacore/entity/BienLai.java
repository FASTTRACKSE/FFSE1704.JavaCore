package fasttrackse.javacore.entity;

public class BienLai extends KhachHang {
	public int chiSoDau;
	public int chiSoCuoi;
	public int thang;
	public int nam;

	public BienLai() {

	}

	public BienLai(String maKhachHang, String tenKhachHang, String diaChi, int maCongTo, int chiSoDau, int chiSoCuoi,
			int thang, int nam) {
		super(maKhachHang, tenKhachHang, diaChi, maCongTo);
		this.chiSoDau = chiSoDau;
		this.chiSoCuoi = chiSoCuoi;
		this.thang = thang;
		this.nam = nam;
	}


	public int getChiSoDau() {
		return chiSoDau;
	}

	public void setChiSoDau(int chiSoDau) {
		this.chiSoDau = chiSoDau;
	}

	public int getChiSoCuoi() {
		return chiSoCuoi;
	}

	public void setChiSoCuoi(int chiSoCuoi) {
		this.chiSoCuoi = chiSoCuoi;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public int soTienPhaiTra() {
		return (chiSoCuoi - chiSoDau) * 3000;
	}
}
