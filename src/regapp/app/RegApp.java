package regapp.app;

import java.util.List;

import regapp.domain.Student;
import regapp.service.StudentService;

public class RegApp {

	public static void main(String[] args) {
		StudentService service = new StudentService();
		
		Student s1 = new Student("Jim", "FULL_TIME");
		Student s2 = new Student("Jim", "FULL_TIME");
		
		s1 = service.createStudent(s1);
		s2 = service.createStudent(s2);
		
		System.out.println("new student is " + s2);
		
		List<Student> students = service.getStudents();
		
		students.forEach(student -> System.out.println(student.getName() + ", " + student.getStatus().getValue()));
		
		for(Student student : students) {
			System.out.println(student);
		}
	}
}
