package ffse.quanlithongtin.enity;

public class NhanVien extends ThongTin {
	//private String hoTenNV;
	private String phongBan;
	private String chucVu;
	private int soNgayCong;
	private double heSoLuong;
	
	
	public NhanVien() {
		super();
	}
	
	public NhanVien(String hoTen, String phongBan,  String chucVu, int soNgayCong, double heSoLuong) {
		super();
		//this.hoTenNV = hoTenNV;
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
		this.heSoLuong = heSoLuong;

	}	
	
	
	/* public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	} */

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public double tinhLuong() {
		double luong = 0;
		
		if("Trưởng phòng".equals(getChucVu())) {
			luong = (this.heSoLuong * 730) + 2000 + (this.soNgayCong * 30);
		}else {
			if("Phó phòng".equals(getChucVu())) {
				luong = (this.heSoLuong * 730) + 1000 + (this.soNgayCong * 30);
			}else {
				if("Nhân Viên".equals(getChucVu())) {
					luong = (this.heSoLuong * 730) + 500 + (this.soNgayCong * 30);
				}
			}
		}
		
		return luong;
	
	}
}
