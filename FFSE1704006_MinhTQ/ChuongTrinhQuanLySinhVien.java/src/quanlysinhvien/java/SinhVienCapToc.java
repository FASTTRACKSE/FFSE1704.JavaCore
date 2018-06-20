package quanlysinhvien.java;

public class SinhVienCapToc extends SinhVien {
	private double diemLP2;
	private double diemLP3;

	public SinhVienCapToc(String hoSinhVien, String tenSinhVien, int namSinh, String diaChi,double diemLP2,double diemLP3) {
		super(hoSinhVien, tenSinhVien, namSinh, diaChi);
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;

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
	public double tinhDiemTrungBinh() {
		
		return (this.diemLP2*this.diemLP3)/2;
	}

	@Override
	public String xepLoai() {
		
			String ketQua;
		if (tinhDiemTrungBinh() <= 5) {
			ketQua="Yếu";
			//System.out.println("Yếu");
			
		} else if (tinhDiemTrungBinh() <= 7) {
			ketQua="Trung bình";
			//System.out.println("Trung Bình");
			
		} else if (tinhDiemTrungBinh() <= 8.5) {
			ketQua="khá";
			//System.out.println("Khá");
			
		} else {
			ketQua="Giỏi";
			//System.out.println("Giỏi");
			
		}
		return ketQua;
	}



	
}
