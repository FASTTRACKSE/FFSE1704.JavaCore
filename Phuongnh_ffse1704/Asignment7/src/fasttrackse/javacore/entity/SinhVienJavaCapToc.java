package fasttrackse.javacore.entity;

public class SinhVienJavaCapToc extends SinhVien {
	private double diemLP4;
	private double diemLP5;
	public SinhVienJavaCapToc(String hoDemSV, String tenSV, String diaChiSV, int namSinhSV
			,double diemLP4,double diemLP5) {
		super(hoDemSV, tenSV, diaChiSV, namSinhSV);
		this.diemLP4=diemLP4;
		this.diemLP5=diemLP5;
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
		
		return ((this.diemLP4+this.diemLP5)/2)*1.0;
	}
	// xếp loại sv
		public String xepLoaiSV() {
			String ketQua;
			
			if( tinhDTB() <5) {
				
				ketQua="Yếu";
				
			}else if (tinhDTB()<6.5) {
				
				ketQua ="Trung Bình";
				
			}else if (tinhDTB()<8.5) {
				
				ketQua="Khá";
				
			}else {
				
				ketQua="Giỏi";
			}
				
				return ketQua;
		}

	
		
}
