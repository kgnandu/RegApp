package regapp.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import regapp.domain.Student;
import regapp.service.StudentService;

public class RegApp {

	public static void main(String[] args) {

		RegApp re = new RegApp();
		re.go();
	}

	public void go() {
		StudentService service = new StudentService();

		Student s1 = new Student("Jim", "FULL_TIME");
		Student s2 = new Student("Mohan", "HIBERNATING");
		Student s3 = new Student("Jill", "HIBERNATING");

		System.out.println("new student is " + s2);

		service.createStudent(s3);
		service.createStudent(s1);
		service.createStudent(s2);

		List<Student> students = service.getStudents();
		

		StartsWith sw = new StartsWith("M");
		
		List<Student> jStudents = filter(students, sw);

		jStudents.forEach(this::myLoggingMethod);

	}

	interface Filtered {
		public boolean filter(Student s);
	}
	
	public class StartsWith implements Filtered
	{
		private String start;
		public StartsWith(String start) {
			this.start = start;
		}
		
		public boolean filter(Student s) {
			return s.getName().startsWith(start);
		}
	}

	public List<Student> filter(List<Student> students,  Filtered f) {
		List<Student> jStudents = new ArrayList<>();
		for(Student student : students) {
			if(f.filter(student)) {
				jStudents.add(student);
			}
		}
		
		return jStudents;
	}
	
	
	public List<Student> getStudentsWithIdLessThan(List<Student> students, int start) {
		List<Student> jStudents = new ArrayList<>();
		for(Student student : students) {
			if(student.getId() < start) {
				jStudents.add(student);
			}
		}
		
		return jStudents;
	}
	
	public List<Student> getStudenstWithJ(List<Student> students, String startStr) {
		List<Student> jStudents = new ArrayList<>();
		for(Student student : students) {
			if(student.getName().startsWith(startStr)) {
				jStudents.add(student);
			}
		}
		
		return jStudents;
	}
	

	public void myLoggingMethod(Student s) {
		System.out.println(s.getName());
	}

	public class MyConsumer implements Consumer<Student> {
		public void accept(Student student) {
			System.out.println(student);
		}
	}
	
	public class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}
}
