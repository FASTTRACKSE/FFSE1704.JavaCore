package quanlitiendien.java.etity;

import java.util.ArrayList;

public class KhachHang {
	protected int maKhachHang;
	public String tenKhachHang;
	protected String diaChi;
	protected int maCongTo;
	ArrayList<BienLai> dsBienLai;

	public KhachHang(int maKhachHang, String tenKhachHang, String diaChi, int maCongTo) {

		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.maCongTo = maCongTo;

	}

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(int maCongTo) {
		this.maCongTo = maCongTo;
	}

	public ArrayList<BienLai> getDsBienLai() {
		return dsBienLai;
	}

	public void setDsBienLai(ArrayList<BienLai> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}

	public void addToDsBienLai(BienLai bienLai) {
		this.dsBienLai.add(bienLai);
	}

	public int sapxep(KhachHang x) {
		if (this.tenKhachHang.compareTo(x.tenKhachHang) == 0) {
			return this.tenKhachHang.compareTo(x.tenKhachHang);
		} else {
			return this.tenKhachHang.compareTo(x.tenKhachHang);
		}
	}

}
