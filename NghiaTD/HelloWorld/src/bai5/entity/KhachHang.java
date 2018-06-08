package bai5.entity;

public class KhachHang {

	protected String maKhachHang;
	protected String tenKhachHang;
	protected String diaChi;
	protected int maCongTo;
	
	public KhachHang(String maKhachHang,String tenKhachHang,String diaChi,int maCongTo)
	{
		this.maKhachHang=maKhachHang;
		this.tenKhachHang=tenKhachHang;
		this.diaChi=diaChi;
		this.maCongTo=maCongTo;
		
	}
	public	String getmaKhachHang() {
		return maKhachHang;
	}
	public void setmaKhachHang() {
		this.maKhachHang=maKhachHang;
	}
	public String gettenKhachHang() {
		return tenKhachHang;
	}
	public void settenKhachHang() {
		this.tenKhachHang=tenKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getmaCongTo() {
		return maCongTo;
		}
	public void setmaCongTo() {
		this.maCongTo=maCongTo;
	}
	
}
