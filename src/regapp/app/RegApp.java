package regapp.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		Student s3 = new Student("Jill", "PART_TIME");

		System.out.println("new student is " + s2);

		service.createStudent(s3);
		service.createStudent(s1);
		service.createStudent(s2);

		List<Student> students = service.getStudents();
		
		String [] arr = {"One", "two", "three" };
		
		String str = Arrays.stream(arr).collect(Collectors.joining(","));
		System.out.println(str);
		
		Map<Integer, List<Student>> map = students.stream()
				.collect(Collectors.groupingBy((Student s) -> s.getId()));
		
		
		//List<String> list2 = 
		long count = students.stream()
				.peek(s -> System.out.println("peek1: " + s))
				.filter(s -> s.getName().startsWith("J"))
				.peek(s -> System.out.println("peek2: " + s))
				.map(s -> s.getName())
				.peek(s -> System.out.println("peek3: " + s))
				//.sorted()
				.peek(s -> System.out.println("peek4: " + s))
				//.collect(Collectors.toList());
				.collect(Collectors.counting());
		
		//System.out.println("list 2" + list2);
		//System.out.println("count = " + count);
		
		Collections.sort(students, (o1, o2) -> o1.getName().compareTo(o2.getName()));


		//students.forEach(System.out::println);
		//students.forEach(RegApp::myLoggingMethod);
		
		StartsWith sw = new StartsWith("J");

		//ByStatus byStatus = new ByStatus(Student.Status.FULL_TIME);
		
		//List<Student> jStudents = myFilterer(students, byStatus);
		
		
		Predicate<Student> byStatus = (s) -> s.getStatus() == Student.Status.FULL_TIME;

		SomethingElse se = (s) -> s.getStatus() == Student.Status.FULL_TIME;

		List<Student> jStudents = myFilterer(students, 
				(s) -> s.getStatus() == Student.Status.FULL_TIME);

		jStudents = myFilterer(students, 
				(s) -> s.getName().startsWith("M"));
	
		
		jStudents.forEach(RegApp::myLoggingMethod);
		
		
	}

	public class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	interface SomethingElse {
		public boolean someMethod(Student s);
	}
	
	
	interface Filtered {
		public boolean filter(Student s);
	}
	
	public class ByStatus implements Filtered
	{
		private Student.Status start;
		public ByStatus(Student.Status start) {
			this.start = start;
		}
		
		public boolean filter(Student s) {
			return s.getStatus() == start;
		}
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

	public List<Student> myFilterer(List<Student> students,  Predicate<Student> f) {
		List<Student> jStudents = new ArrayList<>();
		for(Student student : students) {
			if(f.test(student)) {
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
	

	public static void myLoggingMethod(Student s) {
		System.out.println(s.getName());
	}

	public class MyConsumer implements Consumer<Student> {
		public void accept(Student student) {
			System.out.println(student);
		}
	}
}
