package Nhap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mylist = "      Phạm       Trung         Hải";
		String ten = mylist.trim();
		ten = ten.replaceAll("\\s+"," "); // 1/s là 1 kí tự trắng ,+ là thêm tất các khoảng trắng 
		System.out.println(ten);
		// cách 2: while 
		String hoa = "phạm trung hải";
		
		
	}
	
	

}
