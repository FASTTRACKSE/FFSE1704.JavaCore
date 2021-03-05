package chapter04.qlsv.business;

public class SinhVien {
	private int maSV;
	private String hoDem;
	private String ten;
	private int namSinh;
	private String queQuan;
	private String maLop;
	private double diemToan;
	private double diemLy;
	private double diemHoa;
	public static int tongSV;
	
	
	public SinhVien() {
		tongSV += 1;
		setMaSV(tongSV);
	}

	public SinhVien(String hoDem, String ten) {
		tongSV += 1;
		setMaSV(tongSV);
		this.hoDem = hoDem;
		this.ten = ten;
	}
	
	public int getMaSV() {
		return maSV;
	}
	private void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public double getDiemToan() {
		return diemToan;
	}
	public void setDiemToan(double diemToan) {
		this.diemToan = diemToan;
	}
	public double getDiemLy() {
		return diemLy;
	}
	public void setDiemLy(double diemLy) {
		this.diemLy = diemLy;
	}
	public double getDiemHoa() {
		return diemHoa;
	}
	public void setDiemHoa(double diemHoa) {
		this.diemHoa = diemHoa;
	}

}
