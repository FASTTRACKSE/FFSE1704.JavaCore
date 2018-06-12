package fasttrackse.quanlytiendien.util;

import java.util.Comparator;
import fasttrackse.quanlytiendien.entity.KhachHang;

public class KHComparator {
	/*Comparator for sorting the list KhachHang by MaKH*/
    public static Comparator<KhachHang> KHCodeASCComparator = new Comparator<KhachHang>() {

	public int compare(KhachHang kh1, KhachHang kh2) {
	   String codeKH1 = kh1.getMaKH().toUpperCase();
	   String codeKH2 = kh2.getMaKH().toUpperCase();

	   //ascending order
	   return codeKH1.compareTo(codeKH2);
    }};

	/*Comparator for sorting the list KhachHang by MaKH*/
    public static Comparator<KhachHang> KHCodeDESCComparator = new Comparator<KhachHang>() {

	public int compare(KhachHang kh1, KhachHang kh2) {
	   String codeKH1 = kh1.getMaKH().toUpperCase();
	   String codeKH2 = kh2.getMaKH().toUpperCase();

	   //descending order
	   return codeKH2.compareTo(codeKH1);
    }};

	/*Comparator for sorting the list KhachHang by MaKH*/
    public static Comparator<KhachHang> KHNameASCComparator = new Comparator<KhachHang>() {

	public int compare(KhachHang kh1, KhachHang kh2) {
	   String codeKH1 = kh1.getTenKH().toUpperCase();
	   String codeKH2 = kh2.getTenKH().toUpperCase();

	   //ascending order
	   return codeKH1.compareTo(codeKH2);
    }};

	/*Comparator for sorting the list KhachHang by MaKH*/
    public static Comparator<KhachHang> KHNameDESCComparator = new Comparator<KhachHang>() {

	public int compare(KhachHang kh1, KhachHang kh2) {
	   String codeKH1 = kh1.getTenKH().toUpperCase();
	   String codeKH2 = kh2.getTenKH().toUpperCase();

	   //descending order
	   return codeKH2.compareTo(codeKH1);
    }};

//    /*Comparator for sorting the list by roll no*/
//    public static Comparator<SinhVien> SinhVienDTBDESComparator = new Comparator<SinhVien>() {
//
//	public int compare(SinhVien s1, SinhVien s2) {
//
//	   float fDTB1 = s1.getDiemTB();
//	   float fDTB2 = s2.getDiemTB();
//
//	   /*For ascending order*/
//	   if ((fDTB2 - fDTB1) > 0)
//		   return 1;
//	   else if ((fDTB2 - fDTB1) < 0)
//		   return -1;
//	   else
//		   return 0;
//
//	   /*For descending order*/
//	   //fDTB1-fDTB2;
//   }};

}
