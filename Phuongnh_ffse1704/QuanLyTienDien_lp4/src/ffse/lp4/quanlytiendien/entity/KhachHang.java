package ffse.lp4.quanlytiendien.entity;

public class KhachHang {
//	private int ID;
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String MaQuan;
	private String MaPhuong;
	private String sDT;
	private String email;
	private String maCongTo;
	public KhachHang(String maKH, String tenKH, String diaChi, String MaQuan,String email, String sDT, 
			String maCongTo, String MaPhuong) {
		super();
//		this.ID =ID;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.MaQuan = MaQuan;
		this.MaPhuong = MaPhuong;
		this.sDT = sDT;
		this.email = email;
		this.maCongTo = maCongTo;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMaPhuong() {
		return MaPhuong;
	}
	public void setMaPhuong(String phuong) {
		this.MaPhuong = phuong;
	}
	public String getMaQuan() {
		return MaQuan;
	}
	public void setMaQuan(String quan) {
		this.MaQuan = quan;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}
	
	

}
