package codemaster.sms.business;

import java.time.LocalDate;
import java.text.NumberFormat;

public class Student {
	private String studentID;
	private String studentName;
	private String studentAddress;
	private LocalDate studentBirthday;
	private float theoryMark;
	private float labMark;
	
	public Student() {
		super();
		studentID = "";
		studentName ="";
		studentAddress = "";
	}
	
	public Student(String studentID, String studentName, String studentAddress, LocalDate studentBirthday) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentBirthday = studentBirthday;
	}



	public Student(String studentID, String studentName, String studentAddress, LocalDate studentBirthday,
			float theoryMark, float labMark) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentBirthday = studentBirthday;
		this.theoryMark = theoryMark;
		this.labMark = labMark;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public LocalDate getStudentBirthday() {
		return studentBirthday;
	}
	public void setStudentBirthday(LocalDate studentBirthday) {
		this.studentBirthday = studentBirthday;
	}
	public float getTheoryMark() {
		return theoryMark;
	}
	public void setTheoryMark(float theoryMark) {
		this.theoryMark = theoryMark;
	}
	public float getLabMark() {
		return labMark;
	}
	public void setLabMark(float labMark) {
		this.labMark = labMark;
	}
	
	public float getAverage() {
		return (theoryMark + labMark)/2;
	}
	
	public int getAge() {
		return LocalDate.now().getYear() - studentBirthday.getYear();
	}

	public String getAverageFormatted() {
		return NumberFormat.getNumberInstance().format(getAverage());
	}

	@Override
	public String toString() {
		return "ID: \t" + studentID + "\nName:\t" + studentName + "\nAddress:\t" + studentAddress
				+ "\nAge:\t" + getAge() + "\nTheory:\t" + theoryMark + "\nLab:\t" + labMark
				+ "\nAverage:\t" + getAverageFormatted() + "\n";
	}
	
}
