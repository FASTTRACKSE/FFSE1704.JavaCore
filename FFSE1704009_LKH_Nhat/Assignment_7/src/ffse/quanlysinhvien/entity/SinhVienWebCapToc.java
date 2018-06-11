package ffse.quanlysinhvien.entity;

public class SinhVienWebCapToc extends SinhVien {
	private String hoSV;
	private String tenSV;
	private int namSinh;
	private String diaChi;

	private double diemLP2;
	private double diemLP3;

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double diemLP2, double diemLP3) {
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
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

	public double getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(double diemLP2) {
		this.diemLP2 = diemLP2;
	}

	public double getDiemLP3() {
		return diemLP3;
	}

	public void setDiemLP3(double diemLP3) {
		this.diemLP3 = diemLP3;
	}

	@Override
	public double tinhDTB() {

		return (this.diemLP2 + this.diemLP3)/2;
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
