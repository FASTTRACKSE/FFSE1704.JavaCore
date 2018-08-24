package fasttrackse.javacore.entity;

public class QuanLiThongTin {

	private String Id, MaTV, Name, DiaChi, Phuong, Quan, Tinh, Sdt, Email;

	public QuanLiThongTin(String id, String maTV, String name, String diaChi, String phuong, String quan, String tinh,
			String sdt, String email) {
		Id = id;
		MaTV = maTV;
		Name = name;
		DiaChi = diaChi;
		Phuong = phuong;
		Quan = quan;
		Tinh = tinh;
		Sdt = sdt;
		Email = email;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getMaTV() {
		return MaTV;
	}

	public void setMaTV(String maTV) {
		MaTV = maTV;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
