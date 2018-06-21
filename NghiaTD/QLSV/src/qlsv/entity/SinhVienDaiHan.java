package qlsv.entity;

public  class SinhVienDaiHan extends SinhVien {
	private double diemLP0;
	private double diemLP1;
	private double diemLP2;
	private double diemLP3;
	private double diemLP4;
	private double diemLP5;
	private double diemLP6;
	
	public SinhVienDaiHan(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP0,
			double diemLP1,double diemLP2,double diemLP3,
			double diemLP4,double diemLP5,double diemLP6) {
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

	@Override
	public double tinhDiemTrungBinh() {
		// TODO Auto-generated method stub
		return (this.diemLP0+this.diemLP1+this.diemLP2+this.diemLP3+this.diemLP4+this.diemLP5+this.diemLP6)/7;
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


