package ffse.javacore.entity;

public class NhanVien extends QuanLiCanBo {
	private String phongBan;
	private int soNgayCong;
	private int chonChucVu;
	public NhanVien(String hoTen, int heSoLuong, String phongBan, int soNgayCong,int chonChucVu) {
		super(hoTen, heSoLuong);
		this.phongBan = phongBan;
		this.soNgayCong = soNgayCong;
		this.chonChucVu=chonChucVu;
	}
	public int getChonChucVu() {
		return chonChucVu;
	}
	public void setChonChucVu(int chonChucVu) {
		this.chonChucVu = chonChucVu;
	}
	public String getChucVu() {
		String ChucVu=null;
		if(getChonChucVu()==1) {
			ChucVu="Nhân Viên";
		}else if(getChonChucVu()==2) {
			ChucVu="Phó Phòng";
		}else if(getChonChucVu()==3) {
			ChucVu="Trưởng Phòng";
		}else {
			ChucVu="Vui Lòng Nhập LạI!!!";
		}
		return ChucVu;
	}
	public double tinhLuongNV() {
		double tinhLuongNV=0;
		if(getChonChucVu()==1) {
			tinhLuongNV= ((getHeSoLuong()*730)+ 500 + (getSoNgayCong()*30));
		}else if(getChonChucVu()==2) {
			tinhLuongNV= ((getHeSoLuong()*730)+ 1000 + (getSoNgayCong()*30));
		}else {
			tinhLuongNV= ((getHeSoLuong()*730)+ 2000 + (getSoNgayCong()*30));
		}
		return tinhLuongNV;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public int getSoNgayCong() {
		return soNgayCong;
	}
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	@Override
	public double tinhLuong() {
		double tinhLuongNV=0;
		if(getChonChucVu()==1) {
			tinhLuongNV= ((getHeSoLuong()*730)+ 500 + (getSoNgayCong()*30));
		}else if(getChonChucVu()==2) {
			tinhLuongNV= ((getHeSoLuong()*730)+ 1000 + (getSoNgayCong()*30));
		}else {
			tinhLuongNV= ((getHeSoLuong()*730)+ 2000 + (getSoNgayCong()*30));
		}
		return tinhLuongNV;
	}
	

}