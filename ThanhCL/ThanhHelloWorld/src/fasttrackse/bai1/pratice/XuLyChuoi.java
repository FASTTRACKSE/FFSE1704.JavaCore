package fasttrackse.bai1.pratice;

public class XuLyChuoi {

	public static void main(String[] args) {
		String myList = "  Trần     NGuyên   tHụC  Hán            VIỆT    ";
		String temp = "";

		System.out.println("Chuỗi ban đầu:");
		System.out.println(myList);

		myList = myList.trim();
		System.out.println("Trim:");
		System.out.println(myList);

		// System.out.println("To Lower Cases");
		// temp = myList.toLowerCase();
		// System.out.println(temp);
		//
		// System.out.println("To Upper Cases");
		// temp = myList.toUpperCase();
		// System.out.println(temp);

		// System.out.println("SubString from 10 to 20");
		// temp = myList.substring(10, 20);
		// System.out.println(temp);
		//
		// System.out.println("Replace aa -> bb");
		// temp = myList.replaceAll("aa", "bb");
		// System.out.println(temp);

		while (myList.indexOf("..") > 0) {
			myList = myList.replaceAll("..", ".");
		}
		
		System.out.println("Xoá khoảng trắng dư:");
		System.out.println(myList);

		myList = myList.toLowerCase();
		System.out.println("Về ký tự thường:");
		System.out.println(myList);

		String[] arrImage = myList.split(" ");

		myList = "";
		System.out.println("Cắt thành mảng, viết hoa đầu từ:");
		for (int i = 0; i < arrImage.length; i++) {
			System.out.println("" + (i + 1) + ": " + arrImage[i] + " length = " + arrImage[i].length());
		}
		for (int i = 0; i < arrImage.length; i++) {
			String aWord = arrImage[i].trim();
			if (aWord.length() > 0) {
				arrImage[i] = arrImage[i].substring(0, 1).toUpperCase() + arrImage[i].substring(1);
				myList += arrImage[i] + " ";
				System.out.println("" + (i + 1) + ": " + arrImage[i]);
			}
		}
		System.out.println("Kết quả cuối cùng:");
		System.out.println(myList);
	}

}
