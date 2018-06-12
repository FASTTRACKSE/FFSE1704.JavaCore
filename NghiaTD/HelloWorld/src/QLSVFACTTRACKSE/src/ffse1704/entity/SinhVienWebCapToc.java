package ffse1704.entity;

public class SinhVienWebCapToc extends SinhVien {
	protected String hoSV;
	protected String tenSV;
	protected int namSinh;
	protected String diaChi;
	private double diemLP2;
	private double diemLP3;
	public SinhVienWebCapToc(String hoSV, String tenSV, int namSinh, String diaChi,double diemLP2,double diemLP3) {
		this.hoSV=hoSV;
		this.tenSV=tenSV;
		this.namSinh=namSinh;
		this.diaChi=diaChi;
		// TODO Auto-generated constructor stub
		this.diemLP2=diemLP2;
		this.diemLP3=diemLP3;
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
