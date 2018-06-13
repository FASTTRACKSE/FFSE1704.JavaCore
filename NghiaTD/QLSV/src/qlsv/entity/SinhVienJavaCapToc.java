package qlsv.entity;

public class SinhVienJavaCapToc extends SinhVien {
	private double diemLP4;
	private double diemLP5;
	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP4,double diemLP5) {
		super(hoSV, tenSV, namSinh, diaChi);
		this.diemLP4=diemLP4;
		this.diemLP5=diemLP5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double tinhDiemTrungBinh() {
		// TODO Auto-generated method stub
		return (this.diemLP4+this.diemLP5)/2;
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


