package main;

import java.sql.Connection;

import layout.LayoutLogin;
import model.*;


public class QuanLiATM {
	public static void main(String[] args) {
		LayoutLogin myLayout = new LayoutLogin("TP BANK");
		myLayout.showWindow();
		 Connection conn = ConnectDatabase.getConnect("localhost", "ffse1703013_atm", "nghia111", "123456");
		if (conn != null) {
		} else {
			System.out.println("Kết nối MYSQL thất bại");
		}
	}
}