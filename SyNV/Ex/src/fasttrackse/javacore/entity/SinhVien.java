package fasttrackse.javacore.entity;
import java.util.Scanner;

public class SinhVien {

	public static int tinhDiemTrungBinhMon;
	public static int Length;
	private String tenSinhVien;
	private int namSinh;
	private int diemLP1;
	private int diemLP2;
	private int diemLP3;
	
	public SinhVien(String tenSinhVien, int namSinh, int diemLP1, int diemLP2, int diemLP3) {
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		this.diemLP3 = diemLP3;
		
	}
	public String toString() {
		return "Sinh Vien: " + this.tenSinhVien + " . " + this.namSinh;
		
	}
	public String tenSinhVien() {
		return this.tenSinhVien;
	}
	public double tinhDiemTrungBinhMon() {
		return (diemLP1 + diemLP2 + diemLP3) * 1.0 / 3;
	}
	public String xeploai() {
		if (tinhDiemTrungBinhMon() <= 5 ) {
			return "xep loai yeu";
			}
		else if (tinhDiemTrungBinhMon() <= 7) {
			return "xep loai trung binh";
			}
		else if (tinhDiemTrungBinhMon() <= 8.5) {
			return "xep loai kha";
		}
		else {
			return "xep loai gioi";
		}
			
			
			
	}	

	}


