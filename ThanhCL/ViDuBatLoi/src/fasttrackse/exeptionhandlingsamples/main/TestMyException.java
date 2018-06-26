package fasttrackse.exeptionhandlingsamples.main;

import java.util.Scanner;

import fasttrackse.exeptionhandlingsamples.util.MyException;

public class TestMyException {

	public static void main(String[] args) {
		int a, b, n, choose = 1;
		boolean choosenOK;
		int[] arrInt = new int[10];
		int x = 0;
		Scanner myInput = new Scanner(System.in);
		
		
		boolean inputOK = false;
		String tenGV = "";

		do {
			try {
				System.out.println("Nhập tên giảng viên : ");
				tenGV = myInput.nextLine();
				if (tenGV.length()==0) {
					throw new MyException(1);
				}
				else if (tenGV.length() > 40) {
					throw new MyException(2);
				}
				inputOK = true;
			}
			catch (MyException e) {
				System.out.println("Lỗi: " + e);
			}	
		}
		while (!inputOK);
		
		inputOK = false;
		String trinhDo = "";
		do {
			try {
				System.out.println("Nhập trình độ giảng viên (1-Tiến Sỹ, 2-Thạc Sỹ, 3-Cử Nhân) : ");
				trinhDo = myInput.nextLine();
				
				if (!(trinhDo.equals("1") || trinhDo.equals("2") || trinhDo.equals("3"))) { 
					throw new MyException(3);
				}
				inputOK = true;
			}
			catch (MyException e) {
				System.out.println("Lỗi: " + e);
			}	
		}
		while (!inputOK);
		

		while (choose != 0)

		{
			try {
				System.out.println("Bạn muốn hiển thị lỗi nào? ");
				n = myInput.nextInt();
				throw new MyException(n);
			} catch (MyException e) {
				System.out.println("Lỗi: " + e);
			} catch (Exception e) {
				System.out.println("Lỗi không xác định");
				myInput.next();
			} finally {
				// Bước 3: kết thúc chương trình, lựa chọn tiếp theo
				do {
					System.out.println("Bạn muốn chạy lại chương trình? ");
					try {
						choosenOK = true;
						choose = myInput.nextInt();
						if (choose < 0 || choose > 1) {
							throw new Exception();
						}
					} catch (Exception e) {
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
