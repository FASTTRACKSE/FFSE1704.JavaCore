package codemaster.sms.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

import codemaster.sms.business.Student;
import codemaster.sms.database.StudentDB;
import codemaster.sms.util.Console;
import codemaster.sms.util.StringUtil;

public class StudentApp {
	final static int WIDTH_STT = 5;
	final static int WIDTH_NAME = 30;
	final static int WIDTH_ADDRESS = 15;
	final static int WIDTH_AGE = 5;
	final static int WIDTH_THEORY = 10;
	final static int WIDTH_LAB = 10;
	final static int WIDTH_AVE = 10;
	final static String SEPERATOR = "------------------------------------------------";

	public static void displayMenu() {
		System.out.println("Chương trình quản lý sinh viên CodeMaster");
		System.out.println("------------------------------------------------");
		System.out.println("1. Thêm mới sinh viên");
		System.out.println("2. Tìm sinh viên theo tên");
		System.out.println("3. In danh sách sinh viên điểm cao nhất");
		System.out.println("4. In danh sách sinh viên (có điểm trung bình)");
		System.out.println("5. In danh sách sinh viên sắp xếp theo tên");
		System.out.println("6. In danh sách sinh viên sắp xếp theo điểm TB");
		System.out.println("7. Kết thúc chương trình");
		System.out.println("------------------------------------------------");
	}

	public static void displayListHeader() {
		// System.out.println("ID Name Address Age Theory Lab Average");
		System.out.println(StringUtil.pad("ID", WIDTH_STT) + StringUtil.pad("Name", WIDTH_NAME)
				+ StringUtil.pad("Address", WIDTH_ADDRESS) + StringUtil.pad("Age", WIDTH_AGE)
				+ StringUtil.pad("Theory", WIDTH_THEORY) + StringUtil.pad("Lab", WIDTH_LAB)
				+ StringUtil.pad("Average", WIDTH_AVE));
		// System.out.println("--- ----------------------------- -------------- ----
		// -------- -------- --------");
		System.out.println(StringUtil.pad(SEPERATOR, WIDTH_STT) + StringUtil.pad(SEPERATOR, WIDTH_NAME)
				+ StringUtil.pad(SEPERATOR, WIDTH_ADDRESS) + StringUtil.pad(SEPERATOR, WIDTH_AGE)
				+ StringUtil.pad(SEPERATOR, WIDTH_THEORY) + StringUtil.pad(SEPERATOR, WIDTH_LAB)
				+ StringUtil.pad(SEPERATOR, WIDTH_AVE));
	}

	public static void displayStudentInfo(Student student) {
		System.out.println(
				StringUtil.pad(student.getStudentID(), WIDTH_STT) + StringUtil.pad(student.getStudentName(), WIDTH_NAME)
						+ StringUtil.pad(student.getStudentAddress(), WIDTH_ADDRESS)
						+ StringUtil.pad(Integer.toString(student.getAge()), WIDTH_AGE)
						+ StringUtil.pad(Float.toString(student.getTheoryMark()), WIDTH_THEORY)
						+ StringUtil.pad(Float.toString(student.getLabMark()), WIDTH_LAB)
						+ StringUtil.pad(student.getAverageFormatted(), WIDTH_AVE));
	}

	public static void addStudentList() {
		String id = Console.getString("Nhập Mã SV: ");
		String name = Console.getString("Nhập Tên SV: ");
		String address = Console.getString("Nhập địa chỉ: ");
		LocalDate dBirthDay = Console.getDate("Nhập ngày sinh (dd/mm/yyyy): ", "d/MM/yyyy");
		float theory = Console.getFloat("Nhập điểm lý thuyết: ");
		float lab = Console.getFloat("Nhập điểm thực hành: ");
		Student student = new Student(id, name, address, dBirthDay, theory, lab);
		StudentDB.addStudent(student);
		Console.displayLine();
		Console.displayLine("Thêm mới sinh viên thành công!");
		Console.getString("Ấn enter để tiếp tục!");
	}

	public static void printStudentList() {
		Student[] students = StudentDB.getAll();

		displayListHeader();

		for (int i = 0; i < StudentDB.getCount(); i++) {
			displayStudentInfo(students[i]);
		}
		Console.displayLine();
		Console.getString("Ấn enter để tiếp tục!");
		Console.displayLine();
	}
	
	public static void printStudentByName() {
		Student[] students = Arrays.copyOf(StudentDB.getAll(), StudentDB.getCount());

		Arrays.sort(students, new Comparator<Student>() {
		    @Override
		    public int compare(Student s1, Student s2) {
		        return StringUtil.getName(s1.getStudentName()).compareTo(StringUtil.getName(s2.getStudentName()));
		    }
		});

		displayListHeader();

		for (int i = 0; i < StudentDB.getCount(); i++) {
			displayStudentInfo(students[i]);
		}
		Console.displayLine();
		Console.getString("Ấn enter để tiếp tục!");
		Console.displayLine();
	}
	
	public static void printStudentByMark() {
		Student[] students = Arrays.copyOf(StudentDB.getAll(), StudentDB.getCount());

		Arrays.sort(students, new Comparator<Student>() {
		    @Override
		    public int compare(Student s1, Student s2) {
		        return (s1.getAverage() < s2.getAverage() ? 1 : s1.getAverage() > s2.getAverage() ? -1 : 0);
		    }
		});

		displayListHeader();

		for (int i = 0; i < StudentDB.getCount(); i++) {
			displayStudentInfo(students[i]);
		}
		Console.displayLine();
		Console.getString("Ấn enter để tiếp tục!");
		Console.displayLine();
	}
	
	public static void searchStudentByName() {
		Student[] students = StudentDB.getAll();
		int count = 0;
		String findName = Console.getString("Nhập tên sinh viên cần tìm: ");

		displayListHeader();

		for (int i = 0; i < StudentDB.getCount(); i++) {
			String studentName = StringUtil.getName(students[i].getStudentName());
			if (studentName.contains(findName)) {
				count++;
				displayStudentInfo(students[i]);
			}
		}
		Console.displayLine();
		Console.displayLine("Tìm thấy " + count + " sinh viên");
		Console.getString("Ấn enter để tiếp tục!");
		Console.displayLine();
	}

	public static void printBestStudents() {
		Student[] students = StudentDB.getAll();
		int count = 0;

		if (StudentDB.getCount() > 0) {
			float maxAve = students[0].getAverage();

			for (int i = 0; i < StudentDB.getCount(); i++) {
				if (students[i].getAverage() > maxAve) {
					maxAve = students[i].getAverage();
				}
			}
			
			displayListHeader();
			for (int i = 0; i < StudentDB.getCount(); i++) {
				if (students[i].getAverage() == maxAve) {
					count++;
					displayStudentInfo(students[i]);
				}
			}

			Console.displayLine();
			Console.displayLine("Tìm thấy " + count + " sinh viên");
			Console.getString("Ấn enter để tiếp tục!");
			Console.displayLine();
		} else {
			Console.displayLine();
			Console.displayLine("Không có sinh viên nào!!!");
			Console.getString("Ấn enter để tiếp tục!");
			Console.displayLine();
		}

	}

	public static void main(String[] args) {
		// Khởi tạo danh sách sinh viên
		StudentDB.init();

		String choice = "1";
		while (!choice.equalsIgnoreCase("7")) {
			displayMenu();
			choice = Console.getString("Lựa chọn của bạn? (1-7): ");
			switch (choice) {
			case "1":
				addStudentList();
				break;
			case "2":
				searchStudentByName();
				break;
			case "3":
				printBestStudents();
				break;
			case "4":
				printStudentList();
				break;
			case "5":
				printStudentByName();
				break;
			case "6":
				printStudentByMark();
				break;
			case "7":
				Console.displayLine("Bye!");
				break;
			default:
				Console.displayLine("Tính năng chưa phát triển, mời bạn nhập lại!!!");
				break;
			}
		}
	}

}
