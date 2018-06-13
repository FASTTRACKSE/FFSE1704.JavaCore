package bai5.entity;
import java.util.ArrayList;
public class KhachHang {

	protected String maKH;
	protected String tenKH;
	protected String diaChiKH;
	ArrayList<BienLai> dsBienLai;
	
	public KhachHang(String maKH,String tenKH,String diaChiKH) {
		this.maKH=maKH;
		this.tenKH=tenKH;
		this.diaChiKH=diaChiKH;
		dsBienLai=new ArrayList<BienLai>();
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChiKH() {
		return diaChiKH;
	}

	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}

	public ArrayList<BienLai> getDsBienLai() {
		return dsBienLai;
	}

	public void setDsBienLai(ArrayList<BienLai> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}
	public void addtodsBienLai(BienLai bienLai) {
		this.dsBienLai.add(bienLai);
	}
}