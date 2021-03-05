package codemaster.sms.database;

import codemaster.sms.business.Student;
import java.time.LocalDate;

public class StudentDB {
	private static Student[] students = new Student[100];
	private static int count;
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		StudentDB.count = count;
	}

	public static void init() {
		addStudent(new Student("1", "Nguyễn Văn Anh", "Đà Nẵng", LocalDate.of(1999,10,10), 9, 9));
		addStudent(new Student("2", "Trần Thị Bình", "Quảng Nam", LocalDate.of(1998,10,10), 7, 5));
		addStudent(new Student("3", "Chu Cảnh Chiêu", "Đà Nẵng", LocalDate.of(1997,10,10), 8, 9));
		addStudent(new Student("4", "Phạm Thành Danh", "Huế", LocalDate.of(2000,10,10), 10, 9));
		addStudent(new Student("5", "Phan Văn Tài Em", "Đồng Tháp", LocalDate.of(1999,10,10), 6, 9));
	}
	
	public static Student[] getAll() {
		return students;
	}
	
	public static void addStudent(Student s) {
		students[count++] = s;
	}
}
