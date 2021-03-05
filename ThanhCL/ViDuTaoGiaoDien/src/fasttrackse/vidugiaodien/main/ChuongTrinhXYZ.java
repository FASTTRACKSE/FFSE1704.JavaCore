package fasttrackse.vidugiaodien.main;

import fasttrackse.vidugiaodien.ui.TestUI;

public class ChuongTrinhXYZ {
	public static int theFunctionID = 0;
	
	/**
	 * @return the theFunctionID
	 */
	public static int getTheFunctionID() {
		return theFunctionID;
	}

	/**
	 * @param theFunctionID the theFunctionID to set
	 */
	public static void setTheFunctionID(int theFunctionID) {
		ChuongTrinhXYZ.theFunctionID = theFunctionID;
	}

	public static void main(String[] args) {
		TestUI myLoginUI = new TestUI("Màn hình Login - ");
		myLoginUI.showWindow();
	}

}
