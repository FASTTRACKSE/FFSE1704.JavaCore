
package fasttrackse.database.quanlysinhvien.entity;

public class SinhVien {

	int ID;
	String MaSV;
	String Ho;
	String Ten;
	String GioiTinh;
	String NamSinh;
	String Lop;
	
	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	
	public SinhVien(String maSV, String ho, String ten, String gioiTinh, String namSinh, String lop) {
		super();
		this.MaSV = maSV;
		this.Ho = ho;
		this.Ten = ten;
		this.GioiTinh = gioiTinh;
		this.NamSinh = namSinh;
		this.Lop = lop;
	}
	

	/**
	 * @return the iD
	 */
	
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		Ho = maSV;
	}
	
	public String getHo() {
		return Ho;
	}
	public void setHo(String ho) {
		Ho = ho;
	}
	
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
	public String getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(String namSinh) {
		NamSinh = namSinh;
	}

	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
}
