package ffse.quanlysinhvien.entity;



public abstract class SinhVien{
	private String hoSV;
	private String tenSV;
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
	
	public String xepLoaiSV() {
		String ketQua;
		if (tinhDTB() <= 5) {
			ketQua = "Yếu";
			// System.out.println("Yếu");

		} else if (tinhDTB() <= 7) {
			ketQua = "Trung bình";
			// System.out.println("Trung Bình");

		} else if (tinhDTB() <= 8.5) {
			ketQua = "khá";
			// System.out.println("Khá");

		} else {
			ketQua = "Giỏi";
			// System.out.println("Giỏi");

		}
		return ketQua;

	}


	
	

}
