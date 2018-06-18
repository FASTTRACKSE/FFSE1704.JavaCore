package ffse.quanlysinhvien.entity;

public class SinhVienJavaCapToc extends SinhVien {
	
	private double diemLP4;
	private double diemLP5;

	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi, double diemLP4, double diemLP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		
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
	public double tinhDTB() {
		// TODO Auto-generated method stub
		return (this.diemLP4 + this.diemLP5)/2;
	}

//	@Override
//	public String xepLoaiSV() {
//		String ketQua;
//		if (tinhDTB() <= 5) {
//			ketQua="Yếu";
//			//System.out.println("Yếu");
//			
//		} else if (tinhDTB() <= 7) {
//			ketQua="Trung bình";
//			//System.out.println("Trung Bình");
//			
//		} else if (tinhDTB() <= 8.5) {
//			ketQua="khá";
//			//System.out.println("Khá");
//			
//		} else {
//			ketQua="Giỏi";
//			//System.out.println("Giỏi");
//			
//		}
//		return ketQua;
//	}



	



	



	

}
