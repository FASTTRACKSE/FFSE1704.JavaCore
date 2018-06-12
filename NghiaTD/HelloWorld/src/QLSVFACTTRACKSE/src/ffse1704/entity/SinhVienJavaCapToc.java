package ffse1704.entity;

public class SinhVienJavaCapToc extends SinhVien {
	protected String hoSV;
	protected String tenSV;
	protected int namSinh;
	protected String diaChi;
	private double diemLP4;
	private double diemLP5;
	
	public SinhVienJavaCapToc(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP4,double diemLP5) {
		this.hoSV=hoSV;
		this.tenSV=tenSV;
		this.namSinh=namSinh;
		this.diaChi=diaChi;
		// TODO Auto-generated constructor stub
		this.diemLP4=diemLP4;
		this.diemLP5=diemLP5;
	}

	public String getHoSV() {
		return hoSV;
	}

	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
