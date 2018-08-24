package javaswing.qltable.main;
import javax.swing.JOptionPane;

import ffse.qlkhsql.dao.KhachHangDAO;
import javaswing.qltable.table.QuanLiDanhSach;

public class QuanLiTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KhachHangDAO sinhVienDAO = new KhachHangDAO();
		QuanLiDanhSach myTable = new QuanLiDanhSach("Quản Lí Danh Sách");
		myTable.showWindow();
		
		sinhVienDAO.getConnect("localhost", "test", "test", "test");
		if (sinhVienDAO.getConn() != null) {
			myTable.showKetNoiSQL();
		} else {
			JOptionPane.showMessageDialog(null,"Kết Nối Thất Bại!");
		}
		
	}

}
