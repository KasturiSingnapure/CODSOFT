package codsoft.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
	private List<Course> courses;
	private List<Student> students;

	public CourseRegistrationSystem() {
		courses = new ArrayList<>();
		students = new ArrayList<>();
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void displayCourses() {
		for (Course course : courses) {
			System.out.println(course);
			System.out.println();
		}
	}

	public Student findStudentById(String id) {
		for (Student student : students) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	}

	public Course findCourseByCode(String code) {
		for (Course course : courses) {
			if (course.getCode().equals(code)) {
				return course;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		CourseRegistrationSystem system = new CourseRegistrationSystem();
		Scanner scanner = new Scanner(System.in);

		// Sample courses
		system.addCourse(new Course("CS101", "Introduction to Computer Science", "Basics of computer science.", 30,
				"MWF 9-10AM"));
		system.addCourse(new Course("MATH101", "Calculus I", "Introduction to calculus.", 25, "TTh 11AM-12:30PM"));
		system.addCourse(new Course("PHY101", "Physics I", "Basics of physics.", 20, "MW 1-2:30PM"));

		// Sample students
		system.addStudent(new Student("S001", "Alice"));
		system.addStudent(new Student("S002", "Bob"));

		while (true) {
			System.out.println("\nCourse Registration System Menu:");
			System.out.println("1. Display Available Courses");
			System.out.println("2. Register for a Course");
			System.out.println("3. Drop a Course");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				system.displayCourses();
				break;
			case 2:
				System.out.print("Enter your student ID: ");
				String studentId = scanner.nextLine();
				Student student = system.findStudentById(studentId);
				if (student == null) {
					System.out.println("Student not found.");
					break;
				}
				System.out.print("Enter the course code: ");
				String courseCode = scanner.nextLine();
				Course course = system.findCourseByCode(courseCode);
				if (course == null) {
					System.out.println("Course not found.");
					break;
				}
				if (course.registerStudent(student)) {
					student.registerCourse(course);
					System.out.println("Successfully registered for the course.");
				} else {
					System.out.println("Course is full.");
				}
				break;
			case 3:
				System.out.print("Enter your student ID: ");
				studentId = scanner.nextLine();
				student = system.findStudentById(studentId);
				if (student == null) {
					System.out.println("Student not found.");
					break;
				}
				System.out.print("Enter the course code: ");
				courseCode = scanner.nextLine();
				course = system.findCourseByCode(courseCode);
				if (course == null) {
					System.out.println("Course not found.");
					break;
				}
				if (course.dropStudent(student)) {
					student.dropCourse(course);
					System.out.println("Successfully dropped the course.");
				} else {
					System.out.println("You are not registered for this course.");
				}
				break;
			case 4:
				System.out.println("Exiting the system. Goodbye!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
