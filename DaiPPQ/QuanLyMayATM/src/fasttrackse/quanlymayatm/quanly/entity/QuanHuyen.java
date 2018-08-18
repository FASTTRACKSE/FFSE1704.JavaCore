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
public class QuanHuyen {
	private int ID;
	private int MaQuan;
	private String TenQuan;
	private int MaTP;

	public QuanHuyen() {
		// TODO Auto-generated constructor stub
	}

	public QuanHuyen(int iD, int maQuan, String tenQuan, int maTP) {
		super();
		this.ID = iD;
		this.MaQuan = maQuan;
		this.TenQuan = tenQuan;
		this.MaTP = maTP;
	}

	public QuanHuyen(int maQuan, String tenQuan, int maTP) {
		super();
		this.MaQuan = maQuan;
		this.TenQuan = tenQuan;
		this.MaTP = maTP;
	}

	public int getID() {
		return ID;
	}

	public void setid(int iD) {
		ID = iD;
	}

	public int getMaQuan() {
		return MaQuan;
	}

	public void setMaQuan(int maQuan) {
		MaQuan = maQuan;
	}

	public String getTenQuan() {
		return TenQuan;
	}

	public void setTenQuan(String tenQuan) {
		TenQuan = tenQuan;
	}

	public int getMaTP() {
		return MaTP;
	}

	public void setMaTP(int maTP) {
		MaTP = maTP;
	}

	public String toString() {
		return TenQuan;
	}
}
