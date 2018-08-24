/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.quanly.entity;

/**
 * @author QuangDai
 *
 */
public class TinhTrangMayATM {
	private int MaTT;
	private String MoTa;
	
	public TinhTrangMayATM() {
		// TODO Auto-generated constructor stub
	}
	
	public TinhTrangMayATM(int maTT, String moTa) {
		super();
		this.MaTT = maTT;
		this.MoTa = moTa;
	}
	
	public int getMaTT() {
		return MaTT;
	}

	public void setMaTT(int maTT) {
		MaTT = maTT;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public String toString() {
		return MoTa;
	}
}
