package ffse.quanlysinhvien.entity;



public class SinhVienDaiHan extends SinhVien  implements Comparable<SinhVienDaiHan> {
	private String hoSV;
	private String tenSV;
	private int namSinh;
	private String diaChi;
	private double diemLP0;
	private double diemLP1;
	private double diemLP2;
	private double diemLP3;
	private double diemLP4;
	private double diemLP5;
	private double diemLP6;
	private Object tinhDTB;

	public SinhVienDaiHan(String hoSV, String tenSV, int namSinh,String diaChi, double diemLP0, double diemLP1, double diemLP2,
			double diemLP3, double diemLP4, double diemLP5, double diemLP6) {
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.diemLP0 = diemLP0;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
		this.diemLP4 = diemLP4;
		this.diemLP5 = diemLP5;
		this.diemLP6 = diemLP6;
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
	public double tinhDTB() {
	
		return (this.diemLP0 + this.diemLP1 + this.diemLP2 + this.diemLP3 + this.diemLP4 + this.diemLP5 + this.diemLP6)/7;
	}

	@Override
	public String xepLoaiSV() {
		String ketQua;
		if (tinhDTB() <= 5) {
			ketQua="Yếu";
			//System.out.println("Yếu");
			
		} else if (tinhDTB() <= 7) {
			ketQua="Trung bình";
			//System.out.println("Trung Bình");
			
		} else if (tinhDTB() <= 8.5) {
			ketQua="khá";
			//System.out.println("Khá");
			
		} else {
			ketQua="Giỏi";
			//System.out.println("Giỏi");
			
		}
		return ketQua;

	}
	@Override
	public int compareTo(SinhVienDaiHan x) {
		if (((SinhVienDaiHan) this.tinhDTB).compareTo((SinhVienDaiHan) x.tinhDTB) == 0) {
			return this.tenSV.compareTo(x.tenSV);
		} else {
			return ((SinhVienDaiHan) this.tinhDTB).compareTo((SinhVienDaiHan) x.tinhDTB);
		}
	}
}
