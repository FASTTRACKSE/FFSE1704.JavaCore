package javacore.chapter03.practice;

import java.util.Scanner;
import java.text.NumberFormat;


public class XepLoai {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String choise = "y";

		while (choise.equalsIgnoreCase("y")) {
			System.out.println("Moi ban nhap thong tin diem thi.");
			System.out.print("Diem Toan = ");
			double diemToan = input.nextDouble();

			System.out.print("Diem Ly = ");
			double diemLy = input.nextDouble();

			System.out.print("Diem Hoa = ");
			double diemHoa = input.nextDouble();

			double diemTB = (diemToan + diemLy + diemHoa) / 3;
			
			
			NumberFormat num = NumberFormat.getNumberInstance();
			num.setMinimumFractionDigits(1);
			num.setMaximumFractionDigits(1);
			
			String ketQua = num.format(diemTB);

			System.out.println("Diem trung binh = " + ketQua);

			System.out.print("Ban co muon tiep tuc khong? (y/n): ");
			choise = input.next();
		}

		System.out.println("Bye!");
	}

}
