package QLSVFACTTRACKSE.src.ffse1704.entity;

public class SinhVienWebCapToc extends SinhVien {

	private double diemLP2;
	private double diemLP3;
	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP2,double diemLP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		// TODO Auto-generated constructor stub
		this.diemLP2=diemLP2;
		this.diemLP3=diemLP3;
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
	public double tinhDiemTrungBinhMon() {
		// TODO Auto-generated method stub
		return (this.diemLP2+this.diemLP3)/2;
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
