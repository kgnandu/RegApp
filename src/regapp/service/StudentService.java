package regapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import regapp.domain.Student;

public class StudentService {

	private List<Student> students = new ArrayList<>();
	
	public Student createStudent(String name, String statusStr) {

		Student.Status status = Student.Status.valueOf(statusStr);
		
		Student s = new Student(name, status);
		
		return createStudent(s);
	}

	public Student createStudent(Student student) {

		//insert into DB
		students.add(student);
		
		return student;
	}
	
	public Student getStudent(int id) {

		for(Student student : students) {
			if(student.getId() == id) {
				return student;
			}
		}

		return null;
		
	}
	
	public List<Student> getStudents() {
		List<Student> l2 = new ArrayList<Student>(students);
		
		return l2;
	}

}
