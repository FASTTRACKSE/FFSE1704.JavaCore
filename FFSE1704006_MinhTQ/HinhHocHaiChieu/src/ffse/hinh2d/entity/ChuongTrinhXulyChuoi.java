package ffse.hinh2d.entity;

public class ChuongTrinhXulyChuoi {

	public static void main(String[] args) {
		String arraylist = " Phạm  Trung  Hải";
		String listarray = "";
		String listarray1 = "";
		System.out.println(arraylist);
		System.out.println();

		
		System.out.println("Xoá khoảng trắng dư:");
		System.out.println(arraylist);

		listarray = arraylist.toLowerCase();
		System.out.println(listarray);
		
		
		System.out.println("❖Cách ngắn nhất để xóa các khoảng trắng");
		listarray = arraylist.replace("  ", " ").trim();
		System.out.println(listarray);
		System.out.println();

		System.out.println("❖Cách ngắn nhất để xóa các khoảng trắng");
		arraylist.split(arraylist);
		
		
		
		String[] arrImage = arraylist.split(" ");
		
		for (int i = 0; i < arrImage.length; i++) {
			String aWord = arrImage[i].trim();
			if (aWord.length() > 0) {
				arrImage[i] = arrImage[i].substring(0, 1).toUpperCase() + arrImage[i].substring(1);
				arraylist+= arrImage[i] + " ";
				System.out.println("" + (i + 1) + ": " + arrImage[i]);
				
			}
			
		}
		System.out.println(arraylist);
	}

}
