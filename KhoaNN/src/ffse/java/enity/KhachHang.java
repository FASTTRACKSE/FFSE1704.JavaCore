package ffse.java.enity;

import java.util.ArrayList;

public class KhachHang {
	protected String tenKhachHang;
	protected int maKhachHang;
	protected String diaChiKhachHang;
	protected int maCongTo;
	ArrayList <BienLai> dsBienLai; 
	public KhachHang(String tenKhachHang, int maKhachHang,String diaChiKhachHang,int maCongTo) {
		this.tenKhachHang=tenKhachHang;
		this.maKhachHang=maKhachHang;
		this.diaChiKhachHang=diaChiKhachHang;
		this.maCongTo=maCongTo;
		ArrayList<BienLai> BienLai = new ArrayList<BienLai>();
	}
	public String getThongTinKhachHang() {
		return tenKhachHang;	
	}
	public void setThongTinKhachHang(String tenKhachHang) {
		this.tenKhachHang=tenKhachHang;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang=maKhachHang;
	}
	public String getDiaChiKhachHang() {
		return diaChiKhachHang;
	}
	public void setDiaChiKhachHang(String diaChiKhachHang) {
		this.diaChiKhachHang=diaChiKhachHang;
	}
	public int getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(int maCongTo) {
		this.maCongTo=maCongTo;
	}
	public String toString(){
		return this.tenKhachHang + "\t" + this.maKhachHang +"\t"+ this.diaChiKhachHang+"\t"+ this.maCongTo+"\n";
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
}