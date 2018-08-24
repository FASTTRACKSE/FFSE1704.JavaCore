package fasttrackse.javacore.entity;

public class QuanLiThongTinBanDoc1 {
	private String id, MaTV, TenTV, DiaChi, Phuong, Quan, Tinh, Sdt, email;

	public QuanLiThongTinBanDoc1(String maTV, String tenTV, String diaChi, String phuong, String quan, String tinh,
			String sdt, String email) {
		this.MaTV = maTV;
		this.TenTV = tenTV;
		this.DiaChi = diaChi;
		this.Phuong = phuong;
		this.Quan = quan;
		this.Tinh = tinh;
		this.Sdt = sdt;
		this.email = email;
	}

	public QuanLiThongTinBanDoc1(String maTV, String tenTV, String diaChi, String phuong, String sdt, String email) {
		this.MaTV = maTV;
		this.TenTV = tenTV;
		this.DiaChi = diaChi;
		this.Phuong = phuong;
		this.Sdt = sdt;
		this.email = email;
	}

	public QuanLiThongTinBanDoc1( String tenTV, String diaChi, String sdt, String email,String maTV) {
		this.MaTV = maTV;
		this.TenTV = tenTV;
		this.DiaChi = diaChi;
		this.Sdt = sdt;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaTV() {
		return MaTV;
	}

	public void setMaTV(String maTV) {
		MaTV = maTV;
	}

	public String getTenTV() {
		return TenTV;
	}

	public void setTenTV(String tenTV) {
		TenTV = tenTV;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getPhuong() {
		return Phuong;
	}

	public void setPhuong(String phuong) {
		Phuong = phuong;
	}

	public String getQuan() {
		return Quan;
	}

	public void setQuan(String quan) {
		Quan = quan;
	}

	public String getTinh() {
		return Tinh;
	}

	public void setTinh(String tinh) {
		Tinh = tinh;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
