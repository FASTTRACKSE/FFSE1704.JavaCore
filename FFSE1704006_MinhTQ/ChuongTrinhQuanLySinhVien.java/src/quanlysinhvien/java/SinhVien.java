package quanlysinhvien.java;

public abstract class SinhVien {
	protected String hoSinhVien;
	protected String tenSinhSinh;
	private int namSinh;
	private String diaChi;

	public SinhVien(String hoSinhVien, String tenSinhVien, int namSinh, String diaChi) {
		this.hoSinhVien = hoSinhVien;
		this.tenSinhSinh = tenSinhVien;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
	}

	public String getHoSinhVien() {
		return hoSinhVien;
	}

	public void setHoSinhVien(String hoSinhVien) {
		this.hoSinhVien = hoSinhVien;
	}

	public String getTenSinhSinh() {
		return tenSinhSinh;
	}

	public void setTenSinhSinh(String tenSinhSinh) {
		this.tenSinhSinh = tenSinhSinh;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	 public abstract double tinhDiemTrungBinh();
	 public abstract String xepLoai();

	

}
