package quanlysinhvien.java;

public class SinhVienJavaCapToc extends SinhVien {
	private double diemLP4;
	private double diemLP5;

	public SinhVienJavaCapToc(String hoSinhVien, String tenSinhVien, int namSinh, String diaChi,double diemLP4,double diemLP5) {
		super(hoSinhVien, tenSinhVien, namSinh, diaChi);
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;

	}

	public double getDiemLP4() {
		return diemLP4;
	}

	public void setDiemLP4(double diemLP4) {
		this.diemLP4 = diemLP4;
	}

	public double getDiemLP5() {
		return diemLP5;
	}

	public void setDiemLP5(double diemLP5) {
		this.diemLP5 = diemLP5;
	}

	@Override
	public double tinhDiemTrungBinh() {
	
		return (this.diemLP4*this.diemLP5)/2;
	}

	@Override
	public String xepLoai() {
		String ketqua;
		if (tinhDiemTrungBinh() <= 5) {
			ketqua = "yếu";
		} else if (tinhDiemTrungBinh() <= 6.5) {
			ketqua = "trung bình";
		} else if (tinhDiemTrungBinh() <= 8.5) {
			ketqua = "khá";
		} else {
			ketqua = "giỏi";
		}
		return ketqua;
	}

}
