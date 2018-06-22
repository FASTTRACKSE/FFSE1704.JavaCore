package fasttrackse.exeptionhandlingsamples.main;

import java.util.Scanner;

import fasttrackse.exeptionhandlingsamples.util.MyException;

public class XuLyLoi {

	public static void main(String[] args) {
		int a, b, n, choose = 1;
		boolean choosenOK;
		int[] arrInt = new int[10];
		int x = 0;
		Scanner myInput = new Scanner(System.in);
		
		while (choose != 0) {
			try {
				// Bước 1: thực hiện bài toán giải ptb1
				System.out.println("Giải phương trình bậc nhất 1 ẩn ax + b = 0");
				System.out.print("Hệ số a = ");
				a = myInput.nextInt();
				System.out.print("Hệ số b = ");
				b = myInput.nextInt();
				if (a == 0) {
					throw new MyException(1);
				} else { 
					x = -b/a;
				}
				
				System.out.println("Nghiệm x = " + x);
				System.out.println("Bài toán giải ptb1 thành công tốt đẹp");

				// Bước 2: thực hiện bài toán giải xử lý mảng
				System.out.println("Bạn muốn nhập phần số thứ tự bao nhiêu? ");
				n = myInput.nextInt();
				if (n >= arrInt.length || n < 0) {
					throw new MyException(2);
				}
				arrInt[n] = n+1;
				System.out.println("Bài toán nhập phần tử mảng thành công tốt đẹp");		
			}
//			catch (ArithmeticException e) {
//				System.out.println("Lỗi liên quan đến bộ xử lý toán học: chia cho 0!");
//			}
//			catch (IndexOutOfBoundsException e) {
//				System.out.println("Tràn mảng rồi anh em!");
//			}
			catch (MyException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println("Lỗi rồi 500 anh em --> lỗi chung chung thôi!");
			}
			finally {
				// Bước 3: kết thúc chương trình, lựa chọn tiếp theo
				do {
					System.out.println("Bạn muốn chạy lại chương trình? ");
					try {
						choosenOK = true;
						choose = myInput.nextInt();
						if (choose < 0 || choose > 1) {
							throw new Exception(); 
						}
					}
					catch (Exception e) {
						System.out.println("Nhập số 0 hoặc 1 thôi nhé bạn!");
						myInput.next();
						choosenOK = false;
					}
				} while (!choosenOK);
			}
		}

		System.out.println("Chương trình kết thúc");

		myInput.close();
		
	}

}
