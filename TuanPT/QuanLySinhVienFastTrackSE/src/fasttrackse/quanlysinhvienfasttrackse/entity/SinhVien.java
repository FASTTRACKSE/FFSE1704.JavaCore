package fasttrackse.quanlysinhvienfasttrackse.entity;

public abstract class SinhVien {
	private String hoSV;
	private String tenSV;
	private int namSinh;

	public SinhVien(String hoSV, String tenSV, int namSinh, String diaChi) {
		super();
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

	private String diaChi;

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public abstract double tinhDTB();

	public String xepLoaiSV() {
		String ketQua;
		if (tinhDTB() <= 5) {
			ketQua = "Yếu";	

		} else if (tinhDTB() <= 7) {
			ketQua = "Trung bình";
			
		} else if (tinhDTB() <= 8.5) {
			ketQua = "khá";
			
		} else {
			ketQua = "Giỏi";
			
		}
		return ketQua;

	}

}
