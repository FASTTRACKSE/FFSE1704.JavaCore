/**
 * 
 */
package javacore.hinhhoc.entity;

public class HinhVuong extends HinhHoc2D {
	private int canhGoc;
	/**
	 * 
	 */
	public HinhVuong(int canhGoc) {
		// TODO Auto-generated constructor stub
		this.canhGoc=canhGoc;
	}
	public int getCanhGoc() {
		return canhGoc;
	}
	@Override
	public double ChuVi() {
		return (canhGoc*4);
	}
	@Override
	public double DienTich() {
		// TODO Auto-generated method stub
		return (canhGoc*canhGoc);
	}

}
