package ffse1703012.QuanLyNhanVien.entity;
import java.util.Scanner;
public class GiangVien extends NhanVien{
	private String khoa;
	private String trinhDo;
	private int soTietDay;
	Scanner sc = new Scanner(System.in);
	public GiangVien(String hoTen, double heSoLuong, int phuCap,String khoa, String trinhDo, int soTietDay) {
		super(hoTen, heSoLuong, phuCap);
		this.khoa = khoa;
		this.trinhDo = trinhDo;
		this.soTietDay = soTietDay;
	}

	public GiangVien() {
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public int getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	public long tinhLuong() {
        return (long) (this.getHeSoLuong() * 730000 + this.getPhuCap() + this.getSoTietDay() * 45);
    }
}
