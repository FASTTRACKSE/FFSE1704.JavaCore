package qlcb.main;



//import quanlicanbo.util.MyException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import qlcb.dao.CanBoDao;
import qlcb.entity.GiangVien;
import qlcb.util.MyException;

public class ChuongTrinhQLCB {
	static int N;
	static CanBoDao canBoDao = new CanBoDao();
	static ArrayList<GiangVien> dsCanBo = new ArrayList<GiangVien>();
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		canBoDao.getConnect("localhost", "quanlycanbo", "nghia111", "123456");
		if (canBoDao.getConn() != null) {
			System.out.println("Kết nối MYSQL thành công");
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}

		int maKHCanXoa = 16;
	//	canBoDao.delete(maKHCanXoa);
		
		//sdsCanBo = canBoDao.getDSCanBo();
		// TODO Auto-generated method stub
		while (true) {
			try {
				System.out.println(">> Menu Chương Trình <<");
				System.out.println("+-------------------------------------------+");
				System.out.println("|1.Thêm thông tin cán bộ               |");
				System.out.println("|2.Xóa thông tin cán bộ          |");
				System.out.println("|3.Hiển thị                                |");
				System.out.println("|4.Sửa                                 |");
				System.out.println("|5.Out                              |");
				System.out.println("+-------------------------------------------+");
				System.out.println("Mời Bạn Chọn Chức Năng");
				N = myInput.nextInt();
				if (N == 1) {
					NhapDanhsachCB();
				} else if (N == 2) {
					XoaCanBo();
				
				} else if (N == 3) {
					Hienthi();
				} else if (N == 4) {
					edit();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {

				System.out.println("Bạn chỉ được nhập từ 1 tới 5");
			} finally {
				//
				// Back();
				//
				// }
			}
		}
	}

	public static void NhapDanhsachCB() {
		Scanner myInput = new Scanner(System.in);
//	1
		
			int choose;
			boolean inputOK;
			double heSoLuong = 0;
			String hoTen = "";
			String trinhDo = "";
			int soTietDay = 0;
			int phuCap = 0;
			System.out.println(".Bạn đang nhập thông tin Giảng Viên ");
			System.out.println("+--------------------------------------+");
			System.out.println("Nhập số lượng Giảng Viên");
			int X = myInput.nextInt();
			for (int i = 0; i < X; i++) {
				myInput.nextLine();
				System.out.println("Nhập cán bộ Giảng viên thứ" + (i + 1) + "\n");
				do {
					try {

						System.out.println("Nhập họ tên của Giảng viên");
						
						hoTen = myInput.nextLine();
						inputOK = true;

						if (hoTen.length() < 1 || hoTen.length() > 40) {
							throw new MyException(1);
						}
					} catch (MyException e) {
						System.out.println(e);
						inputOK = false;
					}
				}

				while (!inputOK);

				do {
					try {
						inputOK = true;
						System.out.println("Nhập hệ số lương Giảng viên");
						heSoLuong = myInput.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println("Hệ số lương phairla số thực");
						myInput.next();
						inputOK = false;
					}
				} while (!inputOK);

				System.out.println("Nhập Khoa của Giảng Viên");
				myInput.nextLine();
				String khoa = myInput.nextLine();
				

				
				do {
					try {
						System.out.println("Nhập trình độ: ");
						System.out.println("1:CỬ NHÂN--2:THẠC SĨ---3:TIẾN SĨ ");
						int nhap = myInput.nextInt();
						if(nhap ==1) {
							trinhDo = "Cử nhân";
							phuCap = 1000;
							inputOK = true;
						}else
						if(nhap ==2) {
							trinhDo = "Thạc sĩ";
							phuCap = 1500;
							inputOK = true;
						}else
						if(nhap ==3) {
							trinhDo = "Tiến sĩ";
							phuCap = 200;
							inputOK = true;
						}
						else {
							System.out.println("ban đã nhập sai, mời nhập lại");
							inputOK = false;
						}
					}
						catch(InputMismatchException e) {
							inputOK = false;
							System.out.println("bạn hiền nhập sai rồi nhập lại nhé");
							myInput.next();
						}
				}
					while(!inputOK);
				
					
				
				
				do {
					try {
						inputOK = true;
						System.out.println("Nhập số tiết dạy Giảng Viên");
						soTietDay = myInput.nextInt();
						if (soTietDay < 0) {
							throw new MyException(2);
						}
					} catch (Exception e1) {
						System.err.println(e1);
						inputOK = false;
						myInput.nextLine();
					}

				} while (!inputOK);
				
			
				canBoDao.add(new GiangVien(hoTen, heSoLuong, khoa, trinhDo, soTietDay));
			}
		}
			





	

	public static void Hienthi() {
		canBoDao.getConnect("localhost", "quanlycanbo", "nghia111", "123456");
		dsCanBo = canBoDao.getDSCanBo();
		for (GiangVien x: dsCanBo) {
			
			//System.out.println(((GiangVien)x).getID() + "-" + x.getHoTen() + "-" + ((GiangVien)x).getKhoa());
			System.out.println(x.getID() + "-" + x.getHoTen() + "-" + x.getKhoa()+ "-" 
			+ x.getHeSoLuong()+ "-" + x.getTrinhDo()+ "-" + x.getSoTietDay());
		}
		
		
		
	}
	public static void edit() {
		
		System.out.print("Mời bạn nhập (Id) khách hàng mà bạn muốn sửa:");
		int id = myInput.nextInt();
		GiangVien canbo = canBoDao.read(id);
		
		System.out.println(canbo.getID() + "-" + canbo.getHoTen() + "-" + canbo.getKhoa()+ "-" 
				+ canbo.getHeSoLuong()+ "-" + canbo.getTrinhDo()+ "-" + canbo.getSoTietDay());
		System.out.println("----------------------------------------");
		System.out.println("Mời bạn nhập thông tin mới cửa khách hàng !");
		
		Scanner myInput = new Scanner(System.in);
//		1
			
				int choose;
				boolean inputOK;
				double heSoLuong = 0;
				String hoTen = "";
				String trinhDo = "";
				int soTietDay = 0;
				int phuCap = 0;
				System.out.println(".Bạn đang nhập thông tin Giảng Viên ");
				System.out.println("+--------------------------------------+");
				
//				System.out.println("Nhập số lượng Giảng Viên");
//				int X = myInput.nextInt();
//				for (int i = 0; i < X; i++) {
//					myInput.nextLine();
//					System.out.println("Nhập cán bộ Giảng viên thứ" + (i + 1) + "\n");
					do {
						try {

							System.out.println("Nhập họ tên của Giảng viên");
							
							hoTen = myInput.nextLine();
							inputOK = true;

							if (hoTen.length() < 1 || hoTen.length() > 40) {
								throw new MyException(1);
							}
						} catch (MyException e) {
							System.out.println(e);
							inputOK = false;
						}
					}

					while (!inputOK);

					do {
						try {
							inputOK = true;
							System.out.println("Nhập hệ số lương Giảng viên");
							heSoLuong = myInput.nextDouble();
						} catch (InputMismatchException e) {
							System.out.println("Hệ số lương phairla số thực");
							myInput.next();
							inputOK = false;
						}
					} while (!inputOK);

					System.out.println("Nhập Khoa của Giảng Viên");
					myInput.nextLine();
					String khoa = myInput.nextLine();
					

					
					do {
						try {
							System.out.println("Nhập trình độ: ");
							System.out.println("1:CỬ NHÂN--2:THẠC SĨ---3:TIẾN SĨ ");
							int nhap = myInput.nextInt();
							if(nhap ==1) {
								trinhDo = "Cử nhân";
								phuCap = 1000;
								inputOK = true;
							}else
							if(nhap ==2) {
								trinhDo = "Thạc sĩ";
								phuCap = 1500;
								inputOK = true;
							}else
							if(nhap ==3) {
								trinhDo = "Tiến sĩ";
								phuCap = 200;
								inputOK = true;
							}
							else {
								System.out.println("ban đã nhập sai, mời nhập lại");
								inputOK = false;
							}
						}
							catch(InputMismatchException e) {
								inputOK = false;
								System.out.println("bạn hiền nhập sai rồi nhập lại nhé");
								myInput.next();
							}
					}
						while(!inputOK);
					
						
					
					
					do {
						try {
							inputOK = true;
							System.out.println("Nhập số tiết dạy Giảng Viên");
							soTietDay = myInput.nextInt();
							if (soTietDay < 0) {
								throw new MyException(2);
							}
						} catch (Exception e1) {
							System.err.println(e1);
							inputOK = false;
							
						}

					} while (!inputOK);
					
				
					GiangVien gv = (new GiangVien(id,hoTen, heSoLuong, khoa, trinhDo, soTietDay));
					canBoDao.edit(gv);
		
	}
		public static void XoaCanBo() {
			System.out.println("Mời bạn nhập id muốn xóa");
			int id = myInput.nextInt();
			canBoDao.delete(id);
		}
	
	}




