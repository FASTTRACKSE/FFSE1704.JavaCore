package danhsachnv;

import java.util.Scanner;

import javax.swing.Spring;
public class danhsachnv {
    String hovaten;
	int lop;
	public double namsinh;
	
	public void input() {
		Scanner	myInput = new Scanner(System.in);
		System.out.print("*ten chi vay ban*");
		hovaten= myInput.nextLine();
		
		System.out.print("hoc lop may"); 
		lop= myInput.nextInt();
		
		System.out.print("** birthday **");
		namsinh= myInput.nextDouble();
	}
	public void output() {
		System.out.print("ho va ten: "+ hovaten);
		System.out.print("class: "+ lop);
		System.out.print("birthday: "+ namsinh);

	
	}
}