package QLSVFACTTRACKSE.src.ffse1704.entity;

public class SinhVienDaiHan extends SinhVien {

	private double diemLP0;
	private double diemLP1;
	private double diemLP2;
	private double diemLP3;
	private double diemLP4;
	private double diemLP5;
	private double diemLP6;
	
	public SinhVienDaiHan(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP0,double diemLP1,double diemLP2,double diemLP3,double diemLP4,
			double diemLP5,double diemLP6) {
		
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP0=diemLP0;
		this.diemLP1=diemLP1;
		this.diemLP2=diemLP2;
		this.diemLP3=diemLP3;
		this.diemLP4=diemLP4;
		this.diemLP5=diemLP5;
		this.diemLP6=diemLP6;
		// TODO Auto-generated constructor stub
		
	}
	

	public double getDiemLP0() {
		return diemLP0;
	}


	public void setDiemLP0(double diemLP0) {
		this.diemLP0 = diemLP0;
	}


	public double getDiemLP1() {
		return diemLP1;
	}


	public void setDiemLP1(double diemLP1) {
		this.diemLP1 = diemLP1;
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


	public double getDiemLP6() {
		return diemLP6;
	}


	public void setDiemLP6(double diemLP6) {
		this.diemLP6 = diemLP6;
	}


	

	@Override
	public double tinhDiemTrungBinhMon() {
		// TODO Auto-generated method stub
		return (this.diemLP0+this.diemLP1+this.diemLP2+this.diemLP3+this.diemLP4+this.diemLP5+this.diemLP6)/7 ;
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
