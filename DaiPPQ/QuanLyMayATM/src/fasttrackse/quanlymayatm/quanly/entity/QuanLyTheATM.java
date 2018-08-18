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
public class QuanLyTheATM {
	private int MaThe;
	private int IdKH;
	private int PIN;
	
	public QuanLyTheATM() {
		// TODO Auto-generated constructor stub
	}
	
	public QuanLyTheATM(int maThe, int idKh, int pin) {
		super();
		this.MaThe = maThe;
		this.IdKH = idKh;
		this.PIN = pin;
	}
	
	public QuanLyTheATM(int maThe, int pin) {
		super();
		this.MaThe = maThe;
		this.PIN = pin;
	}

	public int getMaThe() {
		return MaThe;
	}

	public void setMaThe(int maThe) {
		MaThe = maThe;
	}

	public int getIdKH() {
		return IdKH;
	}

	public void setIdKH(int idKH) {
		IdKH = idKH;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}
	
}
