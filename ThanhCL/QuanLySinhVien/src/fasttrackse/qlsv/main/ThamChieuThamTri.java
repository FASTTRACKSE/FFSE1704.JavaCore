package fasttrackse.qlsv.main;

public class ThamChieuThamTri {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	    // TODO code application logic here 
	    HocSinh mHocSinh = new HocSinh();
	    mHocSinh.setName("Nguyen Van A");
	    System.out.println("step 1: " + mHocSinh.getName());
	    updateInfo(mHocSinh);
	    System.out.println("step 3: " + mHocSinh.getName());
	}

	public static void updateInfo(HocSinh mHocSinh) {
	    HocSinh hocSinh2 = new HocSinh();
	    hocSinh2.setName("Nguyen Van C");
	    mHocSinh.setName("Nguyen Van D");
	    mHocSinh.setName("Nguyen Van B");
	    System.out.println("step 2.1: " + mHocSinh.getName());
	    //mHocSinh.setName(hocSinh2.getName());
	    mHocSinh = hocSinh2;
	    System.out.println("step 2.2: " + mHocSinh.getName());
	}

}
