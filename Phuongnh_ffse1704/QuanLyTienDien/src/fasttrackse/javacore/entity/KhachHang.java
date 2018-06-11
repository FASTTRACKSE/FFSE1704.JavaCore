package fasttrackse.javacore.entity;

import java.util.ArrayList;

public class KhachHang {

	// khai báo các biến (phuong thức)
	private int maKhachHang;
	public String tenKhachHang;
	private String diaChi;
	private String maCongTo;
	private ArrayList<BienLai> dsBienLai;

	// hàm tạo Khách hàng chứa các phương thức nhập thông tin khách hàng
	public KhachHang(int maKhachHang, String tenKhachHang, String diaChi, String maCongTo) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.maCongTo = maCongTo;
		dsBienLai = new ArrayList<BienLai>();
	}

	// mã khách hàng
	public int getmaKhachHang() {
		return maKhachHang;
	}

	public void setmaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	// tên khách hàng
	public String gettenKhachHang() {
		return tenKhachHang;
	}

	public void settenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	// địa chủ khách hàng
	public String getdiaChi() {
		return diaChi;
	}

	public void setdiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	// mã công tơ
	public String getmaCongTo() {
		return maCongTo;
	}

	public void setmaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}
	// biên lai

	public ArrayList<BienLai> getBienlai() {
		return dsBienLai;
	}

	public void setBienlai(ArrayList<BienLai> dsBienlai) {
		this.dsBienLai = dsBienlai;
	}
	// thử

}
