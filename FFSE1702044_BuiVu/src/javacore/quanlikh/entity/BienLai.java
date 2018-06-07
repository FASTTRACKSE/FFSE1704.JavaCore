package javacore.quanlikh.entity;

public class BienLai extends ThongTinKhachHang{
	private float chiSoCu;
	private float chiSoMoi;
	public BienLai(String tenKhachHang, int maKhachHang,String diaChiKhachHang,int maCongTo,float chiSoCu,float chiSoMoi) {
		super(tenKhachHang,maKhachHang,diaChiKhachHang,maCongTo);
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
	}
	public float getChiSoCu() {
		return chiSoCu;
	}
	public void setChiSoCu(float chiSoCu) {
		this.chiSoCu=chiSoCu;
	}
	public float getChiSoMoi() {
		return chiSoMoi;
	}
	public void setChiSoMoi(float chiSoMoi) {
		this.chiSoMoi=chiSoMoi;
	}
	public float tinhTienDien() {
		return (chiSoMoi-chiSoCu)*3000;
	}
	public String inBienLai() {
		return "\n"+getMaKhachHang()+ "\t"+getThongTinKhachHang()+ "\t "+getDiaChiKhachHang()+"\t"+getChiSoCu()+"\t "+getChiSoMoi()+"\t  "+tinhTienDien()+"VNĐ";
	}
}

