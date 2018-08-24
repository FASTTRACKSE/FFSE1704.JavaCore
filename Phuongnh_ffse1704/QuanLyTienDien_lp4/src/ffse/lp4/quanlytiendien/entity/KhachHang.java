package ffse.lp4.quanlytiendien.entity;

public class KhachHang {
//	private int ID;
	private String maKH;
	private String tenKH;
	private String diaChi;
	private int maPhuong;
	private int maQuan;
	private String sDT;
	private String email;
	private String maCongTo;
	public KhachHang(String maKH, String tenKH, String diaChi,String maCongTo, String email, String sDT, 
			int maQuan,int maPhuong) {
		super();
//		this.ID =ID;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.maPhuong = maPhuong;
		this.maQuan = maQuan;
		this.sDT = sDT;
		this.email = email;
		this.maCongTo = maCongTo;
	}
	public int getMaQuan() {
		return maQuan;
	}
	public void setMaQuan(int maQuan) {
		maQuan = maQuan;
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
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
	public int getMaPhuong() {
		return maPhuong;
	}
	public void setMaPhuong(int phuong) {
		this.maPhuong = phuong;
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
