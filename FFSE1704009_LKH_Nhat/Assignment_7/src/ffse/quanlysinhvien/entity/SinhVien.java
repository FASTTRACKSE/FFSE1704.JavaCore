package ffse.quanlysinhvien.entity;

public abstract class SinhVien<Employee> implements Comparable<SinhVien> {
	private String hoSV;
	protected String tenSV;
	private int namSinh;
	private String diaChi;

	// ArrayList<SinhVienDaiHan> dsSVDaiHan;
	public SinhVien(String hoSV, String tenSV, int namSinh, String diaChi) {
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
	}

	public String getHoSV() {
		return hoSV;
	}

	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
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

	public abstract double tinhDTB();

//	public int compare(Employee s1, Employee s2) {
//		if (s1.tinhDTB == s2.tinhDTB)
//			return 0;
//		else if (s1.tinhDTB > s2.tinhDTB)
//			return 1;
//		else
//			return -1;
//	}

}
