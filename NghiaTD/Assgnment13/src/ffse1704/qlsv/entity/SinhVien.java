package ffse1704.qlsv.entity;



public class SinhVien {
	
	String MaSV;
	String HoSV;
	String TenSV;
	String GioiTinh;
	String NgaySinh;
	String Lop;
	
	public SinhVien() {
		
	}
	
	public SinhVien(String maSV,String HoSV,String TenSV,String GioiTinh,String NgaySinh,String Lop) {
		this.MaSV = maSV;
		this.HoSV = HoSV;
		this.TenSV = TenSV;
		this.GioiTinh = GioiTinh;
		this.NgaySinh = NgaySinh;
		this.Lop = Lop;
		
	}
public SinhVien(String HoSV,String TenSV,String GioiTinh,String NgaySinh,String Lop) {
	this.MaSV = MaSV;
	this.HoSV = HoSV;
	this.TenSV = TenSV;
	this.GioiTinh = GioiTinh;
	this.NgaySinh = NgaySinh;
	this.Lop = Lop;
	
}
public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getHoSV() {
		return HoSV;
	}

	public void setHoSV(String hoSV) {
		HoSV = hoSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getLop() {
		return Lop;
	}

	public void setLop(String lop) {
		Lop = lop;
	}


}

