package ffse.quanlysinhvien.entity;

public class SinhVienWebCapToc extends SinhVien {
	
	private double diemLP2;
	private double diemLP3;

	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double diemLP2, double diemLP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		
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
