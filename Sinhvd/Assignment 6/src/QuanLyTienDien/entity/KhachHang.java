package QuanLyTienDien.entity;

import java.util.ArrayList;

public class KhachHang implements Comparable<KhachHang> {
     protected String maKh;
     protected String tenKh;
     protected String diaChi;
     ArrayList<BienLai> dsBienLai ;
     
     public KhachHang (String maKh,String tenKh,String diaChi) {
    	 this.maKh= maKh;
    	 this.tenKh=tenKh;
    	 this.diaChi=diaChi;
    	 dsBienLai= new ArrayList<BienLai>();
     }

	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public ArrayList<BienLai> getdsBienLai() {
		return dsBienLai;
	}
	
	public void setdsBienLai(ArrayList<BienLai> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}
	
	public void addTodsBienLai(BienLai bienLai) {
		this.dsBienLai.add(bienLai);
	}

	
	 public int compareTo(KhachHang x) {
	  if(this.tenKh.compareTo(x.tenKh)== 0){
	   return this.tenKh.compareTo(x.tenKh);
	  }else{
	   return this.tenKh.compareTo(x.tenKh);
	  }
	 }

}
