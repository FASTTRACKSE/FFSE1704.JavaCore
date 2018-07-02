package quanlycanbo.util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import quanlycanbo.entity.CanBo;
public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<CanBo>dsCanBo,String path) {
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
	public static ArrayList<CanBo>docFile(String path)
	{
		ArrayList<CanBo>dsCanBo=new ArrayList<CanBo>();
		try
		{
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			dsCanBo=(ArrayList<CanBo>) data;
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

