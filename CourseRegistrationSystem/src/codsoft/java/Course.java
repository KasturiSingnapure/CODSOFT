package codsoft.java;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String code;
	private String title;
	private String description;
	private int capacity;
	private String schedule;
	private List<Student> registeredStudents;

	public Course(String code, String title, String description, int capacity, String schedule) {
		this.code = code;
		this.title = title;
		this.description = description;
		this.capacity = capacity;
		this.schedule = schedule;
		this.registeredStudents = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getSchedule() {
		return schedule;
	}

	public List<Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public boolean registerStudent(Student student) {
		if (registeredStudents.size() < capacity) {
			registeredStudents.add(student);
			return true;
		} else {
			return false;
		}
	}

	public boolean dropStudent(Student student) {
		return registeredStudents.remove(student);
	}

	public int getAvailableSlots() {
		return capacity - registeredStudents.size();
	}

	@Override
	public String toString() {
		return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description + "\nCapacity: "
				+ capacity + "\nSchedule: " + schedule + "\nAvailable Slots: " + getAvailableSlots();
	}
}
