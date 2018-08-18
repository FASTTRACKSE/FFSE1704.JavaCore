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
public class Admin {
	private int ID;
	private String User;
	private String Pass;

	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int iD, String user, String pass) {
		super();
		this.ID = iD;
		this.User = user;
		this.Pass = pass;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}
}
