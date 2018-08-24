package ffse.baitapstring;

public class bai1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "     Phạm         Trung  Hải  ";
		System.out.println(a);
		a = a.trim();
		a = a.replaceAll("\\s+", " ");
		System.out.println(a);
		System.out.println(a.charAt(0));
	}

}
