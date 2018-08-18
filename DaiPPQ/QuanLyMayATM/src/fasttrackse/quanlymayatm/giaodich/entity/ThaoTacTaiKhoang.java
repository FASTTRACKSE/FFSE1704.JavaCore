/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.giaodich.entity;

/**
 * @author QuangDai
 *
 */
public class ThaoTacTaiKhoang {
	private String MaThe;
	private String IdKH;
	private String PIN;

	public ThaoTacTaiKhoang() {
		// TODO Auto-generated constructor stub
	}
	
	public ThaoTacTaiKhoang(String maThe, String idKH, String pin) {
		super();
		this.MaThe = maThe;
		this.IdKH = idKH;
		this.PIN = pin;
	}
	
	public ThaoTacTaiKhoang(String maThe, String pin) {
		super();
		this.MaThe = maThe;
		this.PIN = pin;
	}

	public String getMaThe() {
		return MaThe;
	}

	public void setMaThe(String maThe) {
		MaThe = maThe;
	}

	public String getIdKH() {
		return IdKH;
	}

	public void setIdKH(String idKH) {
		IdKH = idKH;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

}
