/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.main;

import fasttrackse.quanlymayatm.giaodich.ui.GiaoDienGiaoDichUI;
import fasttrackse.quanlymayatm.quanly.ui.LoginUI;

/**
 * @author QuangDai
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoginUI myLoginUI = new LoginUI("Quan Ly Máy ATM");
		myLoginUI.showWindow();
		GiaoDienGiaoDichUI giaoDienGiaoDichUI = new GiaoDienGiaoDichUI("May ATM");
		giaoDienGiaoDichUI.showWindow();
	}

}
