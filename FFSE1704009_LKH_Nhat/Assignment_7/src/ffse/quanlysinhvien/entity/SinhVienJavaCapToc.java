package ffse.quanlysinhvien.entity;

public class SinhVienJavaCapToc extends SinhVien {
	private String hoSV;
	private String tenSV;
	private int namSinh;
	private String diaChi;	
	private double diemLP4;
	private double diemLP5;

	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double diemLP4, double diemLP5) {
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;
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
	public double tinhDTB() {
		// TODO Auto-generated method stub
		return (this.diemLP4 + this.diemLP5)/2;
	}

	@Override
	public String xepLoaiSV() {
		String ketQua;
		if (tinhDTB() <= 5) {
			ketQua="Yếu";
			//System.out.println("Yếu");
			
		} else if (tinhDTB() <= 7) {
			ketQua="Trung bình";
			//System.out.println("Trung Bình");
			
		} else if (tinhDTB() <= 8.5) {
			ketQua="khá";
			//System.out.println("Khá");
			
		} else {
			ketQua="Giỏi";
			//System.out.println("Giỏi");
			
		}
		return ketQua;
	}

}
