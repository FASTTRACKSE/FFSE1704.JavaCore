package ffse.quanlihinhhoc.entyti;

public class HinhChuNhat extends HinhHoc2D {
	private double ChieuDai;
	private double ChieuRong;
	

	@Override
	public double TinhChuVi() {
		// TODO Auto-generated method stub
		
		return (ChieuDai + ChieuRong) * 2;
	}

	@Override
	public double TinhDienTich() {
		// TODO Auto-generated method stub
		return ChieuDai * ChieuRong;
	}
	public HinhChuNhat (double chieuDai, double chieuRong) {
		this.ChieuDai = chieuDai;
		this.ChieuRong = chieuRong;
	}
	
	public double getChieuDai() {
		return ChieuDai;
	}
	
	public void setChieuDai(double ChieuDai) {
		this.ChieuDai = ChieuDai;
	}
	
	public double getChieuRong() {
		return ChieuRong;
	}
	
	public void setChieuRong(double ChieuRong) {
		this.ChieuRong = ChieuRong;
	}
}
