package QLSVFACTTRACKSE.src.ffse1704.entity;

public class SinhVienJavaCapToc extends SinhVien {

	private double diemLP4;
	private double diemLP5;
	
	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP4,double diemLP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		// TODO Auto-generated constructor stub
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
	public double tinhDiemTrungBinhMon() {
		// TODO Auto-generated method stub
		return (this.diemLP4+this.diemLP5)/2 ;
	}

	@Override
	public String xepLoaiHocLuc() {
		// TODO Auto-generated method stub
		String xeploai = "";
		if(tinhDiemTrungBinhMon() <5) {
			xeploai = "Yếu";
		}
		else if(tinhDiemTrungBinhMon() <6.5) {
			xeploai = "Trung Bình";
		}
		else if(tinhDiemTrungBinhMon() <8.5) {
			xeploai = "Khá";
		}
		else {
			xeploai = "Giỏi";
		}
		return xeploai;
	}

}
