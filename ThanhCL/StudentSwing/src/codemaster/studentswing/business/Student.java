package codemaster.studentswing.business;

import java.time.LocalDate;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private float markLab;
	private float markTheory;

	private static int auto_id = 0;

	public Student() {
		super();
	}

	public Student(String firstName, String lasstName, String email, LocalDate birthday, float markLab,
			float markTheory) {
		super();
		this.id = ++auto_id;
		this.firstName = firstName;
		this.lastName = lasstName;
		this.email = email;
		this.birthday = birthday;
		this.markLab = markLab;
		this.markTheory = markTheory;
	}
	
	public Student(int id, String firstName, String lastName, String email, LocalDate birthday, float markLab,
			float markTheory) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.markLab = markLab;
		this.markTheory = markTheory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lasstName) {
		this.lastName = lasstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public float getMarkLab() {
		return markLab;
	}

	public void setMarkLab(float markLab) {
		this.markLab = markLab;
	}

	public float getMarkTheory() {
		return markTheory;
	}

	public void setMarkTheory(float markTheory) {
		this.markTheory = markTheory;
	}

	public float getAverage() {
		return (markTheory + markLab) / 2;
	}
	
	public int getAge() {
		return LocalDate.now().getYear() - birthday.getYear();
	}

}
