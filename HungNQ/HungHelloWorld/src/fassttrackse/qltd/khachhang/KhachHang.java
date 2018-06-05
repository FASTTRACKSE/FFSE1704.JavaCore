/**
 * Nguyễn Quốc Hưng
 * Khách Hàng
 * 04-06-2018
 */
package fassttrackse.qltd.khachhang;

import java.util.Scanner;

/**
 * @author Admin
 *
 */
public class KhachHang {

	public static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		int answer;
		while (true) {

			System.out.println("+-----------------------------+");
			System.out.println("|-1.Nhập thông tin khách hàng-|");
			System.out.println("|----2.Quản lý chỉ số điện----|");
			System.out.println("|---------3.Kết thúc----------|");
			System.out.println("+-----------------------------+");

			answer = myInput.nextInt();

			if (answer == 1) {
				nttKhachHang();
			} else if (answer == 2) {
				System.out.println("hiiiii");
			}
		}
	}
	public static void nttKhachHang(){
		int MaKhachHang;
		int TenKhachHang;
		int DiaChi;
		int MaCongTo;
		
		System.out.println("Mời bạn nhập mã khách hàng: ");
		MaKhachHang = myInput.nextInt();
		
		System.out.println("Mời bạn nhập tên khách hàng: ");
		TenKhachHang = myInput.nextInt();
		
		System.out.println("Mời bạn nhập địa chỉ: ");
		DiaChi = myInput.nextInt();
		
		System.out.println("Mời bạn nhập mã công tơ: ");
		MaCongTo = myInput.nextInt();
	}
}
