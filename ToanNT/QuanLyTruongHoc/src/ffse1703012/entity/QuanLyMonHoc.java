package ffse1703012.entity;

public class QuanLyMonHoc {
	private String maMH, tenMH, soTinChi, thoiGianHoc;
	public QuanLyMonHoc() {
		
	}
	public QuanLyMonHoc(String maMH, String tenMH, String soTinChi, String thoiGianHoc) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTinChi = soTinChi;
		this.thoiGianHoc = thoiGianHoc;
	}
	public QuanLyMonHoc(String tenMH, String maMH) {
		this.tenMH = tenMH;
		this.maMH = maMH;
		
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public String getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(String soTinChi) {
		this.soTinChi = soTinChi;
	}
	public String getThoiGianHoc() {
		return thoiGianHoc;
	}
	public void setThoiGianHoc(String thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}
	@Override
	public String toString() {
		return this.tenMH;
	}
	
}

