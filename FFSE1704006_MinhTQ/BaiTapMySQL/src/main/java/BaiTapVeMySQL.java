package main.java;

public class BaiTapVeMySQL {

	public static void main(String[] args) {
		// Bài tâp 1:
		// 1.SELECT * FROM `sinhvien` WHERE `Gender`='Nữ' AND `Age`<19;
		// 2.SELECT * FROM `sinhvien` WHERE Name LIKE N'%NAM';
		// 3.SELECT COUNT(*) FROM sinhvien WHERE class="FFSE1701";
		// 4.DELETE FROM sinhvien WHERE age < 18;
		// bài tập 2:
		// SELECT lms_students.code,lms_students.first_name,lms_countries.id
		// ,lms_countries.name AS country ,dat_nuoc.name AS nationality
		// FROM lms_students
		// INNER JOIN lms_countries
		// ON lms_students.country=lms_countries.id
		// INNER JOIN lms_countries AS dat_nuoc
		// ON lms_students.nationality = dat_nuoc.id
		
//		SELECT hoadon.MaHD ,
//		ifnull(hoadon.MaKH,'vẵng lai') AS MaKH,
//		ifnull(khachhang.TenKH,'Vẵng Lai') AS TenKH ,
//		hoadon.Slsanpham,
//		sanpham.MaSp,
//		sanpham.TenSP,
//		sanpham.DonGia,
//
//		hoadon.Slsanpham*sanpham.DonGia AS TongTien
//		FROM `hoadon` 
//		LEFT JOIN khachhang
//		ON hoadon.MaKH= khachhang.MaKH
//		INNER JOIN sanpham
//		ON hoadon.MaSP = sanpham.MaSp
	}

}
