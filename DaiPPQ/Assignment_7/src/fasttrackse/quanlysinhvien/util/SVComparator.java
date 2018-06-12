/************************
 *	Prog: QUẢN LÝ SINH VIÊN
 *	@AUTHOR: Phan Phạm Quang Dai
 *	Date: 12/06/2018
 **********************/
package fasttrackse.quanlysinhvien.util;

import java.util.Comparator;
import fasttrackse.quanlysinhvien.entity.SinhVien;

/**
 * @author QuangDai
 *
 */

public class SVComparator {
	/*Comparator for sorting the list SinhVien by HoSV*/
    public static Comparator<SinhVien> KHCodeASCComparator = new Comparator<SinhVien>() {

	public int compare(SinhVien sv1, SinhVien sv2) {
	   String codeSV1 = sv1.getHoSV().toUpperCase();
	   String codeSV2 = sv2.getHoSV().toUpperCase();

	   //ascending order
	   return codeSV1.compareTo(codeSV2);
    }};

	/*Comparator for sorting the list SinhVien by HoSV*/
    public static Comparator<SinhVien> KHCodeDESCComparator = new Comparator<SinhVien>() {

	public int compare(SinhVien sv1, SinhVien sv2) {
	   String codeSV1 = sv1.getHoSV().toUpperCase();
	   String codeSV2 = sv2.getHoSV().toUpperCase();

	   //descending order
	   return codeSV2.compareTo(codeSV1);
    }};

	/*Comparator for sorting the list SinhVien by HoSV*/
    public static Comparator<SinhVien> KHNameASCComparator = new Comparator<SinhVien>() {

	public int compare(SinhVien kh1, SinhVien kh2) {
	   String codeKH1 = kh1.getHoSV().toUpperCase();
	   String codeKH2 = kh2.getHoSV().toUpperCase();

	   //ascending order
	   return codeKH1.compareTo(codeKH2);
    }};

	/*Comparator for sorting the list SinhVien by HoSV*/
    public static Comparator<SinhVien> KHNameDESCComparator = new Comparator<SinhVien>() {

	public int compare(SinhVien kh1, SinhVien kh2) {
	   String codeSV1 = kh1.getHoSV().toUpperCase();
	   String codeSV2 = kh2.getHoSV().toUpperCase();

	   //descending order
	   return codeSV2.compareTo(codeSV1);
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
