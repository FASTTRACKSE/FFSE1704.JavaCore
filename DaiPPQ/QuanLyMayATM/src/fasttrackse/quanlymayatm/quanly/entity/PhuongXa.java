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
public class PhuongXa {
	private int ID;
	private int MaPhuong;
	private String TenPhuong;
	private int MaQuan;
	private int MaTP;

	public PhuongXa() {
		// TODO Auto-generated constructor stub
	}
	
	public PhuongXa(int iD, int maPhuong, String tenPhuong, int maQuan, int maTP) {
		super();
		this.ID = iD;
		this.MaPhuong = maPhuong;
		this.TenPhuong = tenPhuong;
		this.MaQuan = maQuan;
		this.MaTP = maTP;
	}

	public PhuongXa(int maPhuong, String tenPhuong, int maQuan, int maTP) {
		super();
		this.MaPhuong = maPhuong;
		this.TenPhuong = tenPhuong;
		this.MaQuan = maQuan;
		this.MaTP = maTP;
	}
	
	public int getID() {
		return ID;
	}

	public void setid(int iD) {
		ID = iD;
	}

	public int getMaPhuong() {
		return MaPhuong;
	}

	public void setMaPhuong(int maPhuong) {
		MaPhuong = maPhuong;
	}

	public String getTenPhuong() {
		return TenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		TenPhuong = tenPhuong;
	}

	public int getMaQuan() {
		return MaQuan;
	}

	public void setMaQuan(int maQuan) {
		MaQuan = maQuan;
	}

	public int getMaTP() {
		return MaTP;
	}

	public void setMaTP(int maTP) {
		MaTP = maTP;
	}
	
	public String toString() {
		return TenPhuong;
	}

}
