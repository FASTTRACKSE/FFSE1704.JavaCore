package fasttrack.quanlycanbo.entity;

public class NhanVien extends CanBo {

	private String phongBan;
	private String chucVu;
	private int soNgayCong;

	public NhanVien(String hoTen, int phuCap, double heSo, String phongBan, String chucVu, int soNgayCong) {
		super(hoTen, phuCap, heSo);
		this.phongBan = phongBan;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
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


	@Override
	public double tinhLuong() {
		double tienluong = 0;
		tienluong = getHeSo()*730000 + getPhuCap() + getSoNgayCong() * 30 ;
		return tienluong;
	}

}
