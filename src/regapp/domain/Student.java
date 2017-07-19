package regapp.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {

	public enum Status {
		FULL_TIME(0), PART_TIME(1), HIBERNATING(2);
		
		private int value;
		Status(int val) {
			this.value = val;
		}
		
		public int getValue() {
			return value;
		}
		
		public String toString() {
			return name() + ":" + value;
		}
	};

	private int id;
	private String name;
	private Status status;
	
	private static AtomicInteger counter = new AtomicInteger(0);

	public Student() {
		super();
	}

	public Student(String name, String status) {
		this(name, Status.valueOf(status));
	}

	public Student(String name, Status status) {
		super();
		//this.id = counter++;
		this.id = counter.getAndIncrement();
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
	
}
