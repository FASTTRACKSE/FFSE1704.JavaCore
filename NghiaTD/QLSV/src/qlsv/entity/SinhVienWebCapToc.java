package qlsv.entity;

public class SinhVienWebCapToc extends SinhVien {
		private double diemLP2;
		private double diemLP3;
	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP2,double diemLP3) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP2=diemLP2;
		this.diemLP3=diemLP3;
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return (this.diemLP2+this.diemLP3)/2;
	}

	@Override
	public String xepLoai() {
		// TODO Auto-generated method stub
		String hocLuc="";
		if(tinhDiemTrungBinh()<5) {
			hocLuc="Yếu";
		}
		else if(tinhDiemTrungBinh()<7) {
			
				hocLuc="Trung bình";
			}else
				if(tinhDiemTrungBinh()<8.5){
					hocLuc="Khá";
				}
				else{
					hocLuc="Giỏi";
				}
		return hocLuc;
		}
	}


