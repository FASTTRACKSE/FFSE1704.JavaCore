package ffse1703012.QuanLyNhanVien.comparator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ffse1703012.QuanLyNhanVien.entity.NhanVien;


public class LuuDocFile {
	public static boolean luuFile(ArrayList<NhanVien> dsNhanVien, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dsNhanVien);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<NhanVien>docFile(String path){
		ArrayList<NhanVien>dsNhanVien = new ArrayList<NhanVien>();
		try {
			
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			dsNhanVien= (ArrayList<NhanVien>) data;
			ois.close();
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

}
