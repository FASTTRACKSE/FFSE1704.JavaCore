package fasttrackse.qlsv.main;

import fasttrackse.qlsv.entity.*;

public class Operation2 {
    static void change(Operation1 op) {
        op.data = op.data + 100;
    }

    static void changeInt(Integer myData) {
    	myData = myData + 100;
    }

    static void swap(MonHoc mh1, MonHoc mh2) {
    	MonHoc temp = mh1;
    	mh1 = mh2;
    	mh2 = temp;
        System.out.println("swapObject: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
    }

    static void swapValue(MonHoc mh1, MonHoc mh2) {
    	mh1.setMaMonHoc(mh2.getMaMonHoc());
    	mh1.setTenMonHoc(mh2.getTenMonHoc());
        System.out.println("swapValue: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
    }

    static void changeTen(MonHoc mh1) {
    	MonHoc mh = new MonHoc("MH02", "Môn học 2");

    	System.out.println("changeTen: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
    	
    	mh1.setTenMonHoc("MÔN HỌC MỘT");
        System.out.println("changeTen: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
    	
        mh1 = mh;
        System.out.println("changeTen: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
    }

	public static void main(String args[]) {
        Operation1 op = new Operation1();
        Integer myData = 5;
 
        System.out.println("Trước khi thay đổi: " + op.data + " - " + myData);
        change(op); // truyền đối tượng
        changeInt(op.data); // truyền thuộc tính của đối tượng
        changeInt(myData); // truyền thuộc tính của đối tượng
        System.out.println("Sau khi thay đổi: " + op.data + " - " + myData);
        
        MonHoc mh1 = new MonHoc("MH01","Môn Học Một");
        MonHoc mh2 = new MonHoc("MH02","Môn Học Hai");
        
        System.out.println("Trước khi thay đổi: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());
        
        changeTen(mh1);
        System.out.println("Sau khi thay đổi: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
        
        swap(mh1, mh2);
        System.out.println("Sau khi thay đổi: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        

        swapValue(mh1, mh2);
        System.out.println("Sau khi thay đổi: " + mh1.getTenMonHoc() + ":" + mh1.getMaMonHoc());        
        
    }
}