package codemaster.studentswing.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import codemaster.studentswing.business.Student;


public class StudentDB {
	private static List<Student> students = new ArrayList<Student>();
	
	public static List<Student> getAll() {
		return students;
	}
	
	public static void init() {
		students.add(new Student("Nguyễn Văn", "Anh", "anh@gmail.com", LocalDate.of(1996, 1, 8), 9, 9));
		students.add(new Student("Trần Thị", "Bình", "binh@gmail.com", LocalDate.of(1996, 2, 8), 9, 10));
		students.add(new Student("Bùi Thiện", "Cảnh", "canh@gmail.com", LocalDate.of(1996, 3, 8), 7, 9));
		students.add(new Student("Lê Anh", "Dũng", "dung@gmail.com", LocalDate.of(1996, 4, 8), 6, 6.5f));
		students.add(new Student("Phan Văn Tài", "Em", "em@gmail.com", LocalDate.of(1996, 5, 8), 9, 8.5f));
	}
	
	public static Student get(int id) {
		Student s = null;
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getId() == id) {
				s = students.get(i);
				break;
			}
		}
		return s;
	}

	public static void add(Student student) {
		students.add(student);
	}

	public static int edit(Student student) {
		int result = 0;
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getId() == student.getId()) {
				students.set(i, student);
				result = 1;
				break;
			}
		}
		return result;
	}

	public static int delete(int id) {
		int result = 0;
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
				result = 1;
				break;
			}
		}
		return result;
	}

	public static int delete(Student student) {
		int result = 0;
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getId() == student.getId()) {
				students.remove(i);
				result = 1;
				break;
			}
		}
		return result;
	}
}
