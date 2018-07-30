package ffse1704.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ffse1704.qlsv.entity.*;;

public class SerializeFileFactory {
	
	public static boolean luuFile(ArrayList<User>user,String path) {
		try
		{
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(user);
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
	public static ArrayList<User>docFile(String path)
	{
		ArrayList<User>user=new ArrayList<User>();
		try
		{
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			user=(ArrayList<User>) data;
			ois.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return user;
	}
}
