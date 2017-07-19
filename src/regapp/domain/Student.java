package regapp.domain;

public class Student {

	public enum Status {
		FULL_TIME, PART_TIME, HIBERNATING 
	};

	private int id;
	private String name;
	private Status status;

	public Student() {
		super();
	}

	public Student(int id, String name, String status) {
		this(id, name, Status.valueOf(status));
	}

	public Student(int id, String name, Status status) {
		super();
		this.id = id;
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
