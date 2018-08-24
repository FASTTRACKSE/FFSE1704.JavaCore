package javacore.qlcanbotruonghoc.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javacore.qlcanbotruonghoc.entity.*;
import javacore.qlcanbotruonghoc.main.*;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<QuanLiCanBo>dsCanBo,String path)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(dsCanBo);
			oos.close();
			fos.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<QuanLiCanBo>docFile(String path)
	{
		ArrayList<QuanLiCanBo>dsCanBo=new ArrayList<QuanLiCanBo>();
		try
		{
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			dsCanBo=(ArrayList<QuanLiCanBo>) data;
			ois.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsCanBo;
	}
}
