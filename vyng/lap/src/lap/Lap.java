package lap;

public class Lap {

	public static void main(String[] args) {
		/*
		 * String str = "ngô gia vỹ"; String strUpper = str.toUpperCase();
		 * System.out.println("ngô gia vỹ " + str); System.out.println("ngô gia vy " +
		 * strUpper);
		 */
		
		String s1 = "ngô gia vỹ";
		String[] words = s1.split("\\s");// chia chuoi dua tren string phan cac nhau boi khoang trang (\\s)
		// su dung vong lap foreach de in cac phan tu trong mang chuoi
		for (String w : words) {
			System.out.println(w);
		}
	}

}
