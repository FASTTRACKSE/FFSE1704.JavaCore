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
public class TinhThanhPho {
	private int MaTP;
	private String TenTP;
	
	public TinhThanhPho() {
		// TODO Auto-generated constructor stub
	}
	
	public TinhThanhPho(int maTP, String tenTP) {
		super();
		this.MaTP = maTP;
		this.TenTP = tenTP;
	}

	public int getMaTP() {
		return MaTP;
	}

	public void setMaTP(int maTP) {
		MaTP = maTP;
	}

	public String getTenTP() {
		return TenTP;
	}

	public void setTenTP(String tenTP) {
		TenTP = tenTP;
	}
	
	public String toString() {
		return TenTP;
	}
}
