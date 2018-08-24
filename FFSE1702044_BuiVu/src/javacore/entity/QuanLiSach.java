package fasttrackse.javacore.entity;

public class QuanLiSach {

	private String  MaSach, TenSach, TacGia, NXB, TheLoaiSach, NamXB,TimKiem;
	
	public QuanLiSach( String maSach, String tenSach, String tacGia, String nXB, String theLoaiSach,
			String namXB) {
		super();
		
		MaSach = maSach;
		TenSach = tenSach;
		TacGia = tacGia;
		NXB = nXB;
		TheLoaiSach = theLoaiSach;
		NamXB = namXB;
	}

	
	
	
	public QuanLiSach(String maSach, String tenSach, String tacGia, String nXB, String id2, String theLoaiSach,String namXB) {
		
		MaSach = maSach;
		TenSach = tenSach;
		TacGia = tacGia;
		NXB = nXB;
		TheLoaiSach = theLoaiSach;
		NamXB = namXB;
	}


	public QuanLiSach(String tenSach, String tacGia, String nXB,  String maSach) {
		// TODO Auto-generated constructor stub
		MaSach = maSach;
		TenSach = tenSach;
		TacGia = tacGia;
		NXB = nXB;
	
	}




	public String getTimKiem() {
		return TimKiem;
	}


	public void setTimKiem(String timKiem) {
		TimKiem = timKiem;
	}


	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}

	public String getTenSach() {
		return TenSach;
	}

	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}

	public String getTacGia() {
		return TacGia;
	}

	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public String getTheLoaiSach() {
		return TheLoaiSach;
	}

	public void setTheLoaiSach(String theLoaiSach) {
		TheLoaiSach = theLoaiSach;
	}
	
	public String getNamXB() {
		return NamXB;
	}

	public void setNamXB(String namXB) {
		NamXB = namXB;
	}


	

}
