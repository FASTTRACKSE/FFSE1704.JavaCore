package javacore.entity;

import java.util.ArrayList;

public class KhachHang {
	public String maKhachHang;
	public String tenKhachHang;
	public String diaChi;
	ArrayList<BienLai> dsBienLai;
	
	public KhachHang() {
		
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String diaChi) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		dsBienLai = new ArrayList<BienLai>();

	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
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

	public ArrayList<BienLai> getDsBienLai() {
		return dsBienLai;
	}

	public void setDsBienLai(ArrayList<BienLai> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}

	public void addDsBienLai(BienLai bienlai) {
		this.dsBienLai.add(bienlai);
	}
	

}