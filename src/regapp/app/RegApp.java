package regapp.app;

import java.util.List;

import regapp.domain.Student;
import regapp.service.StudentService;

public class RegApp {

	public static void main(String[] args) {
		StudentService service = new StudentService();
		
		Student s1 = new Student(0, "Jim", "FULL_TIME");
		
		Student s2 = service.createStudent(s1);
		
		System.out.println("new student is " + s2);
		
		List<Student> students = service.getStudents();
		
		students.add(new Student());
		
		System.out.println("all students " + students);
	}
}
