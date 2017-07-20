package regapp.threads;

public class ThreadDemo {

	private static Object syncObject = new Object();

	public static void main(String[] args) {
		ThreadDemo td =new ThreadDemo();
		td.go();
	}
	
	public void go() {
		DataHolder dh = new DataHolder();
		MyWorker worker1 = new MyWorker("Worker 1", dh);
		Thread th = new Thread(worker1);

		MyWorker worker2 = new MyWorker("Worker 2", dh);
		Thread th2 = new Thread(worker2);

		th.start();
		th2.start();
		
		try {
			th.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("nextId = " + dh.getNextId());
	}
	
	public class MyWorker implements Runnable
	{
		private String name;
		private int sum;
		private DataHolder dh;

		public MyWorker(String name, DataHolder dh) {
			this.name = name;
			this.dh = dh;
		}
		public void run() {
			for(int i = 0; i < 1000; i++) {
				int id = dh.getNextId();
				
				//Do something with id
			}
		}
		
		public int getSum() {
			return sum;
		}
	}

	public class MyThread extends Thread
	{
		public MyThread(String name) {
			super(name);
		}

		public void run() {
			System.out.println("Hello from " + getName());
		}
	}
	
	class DataHolder
	{
		private int nextId;
		
		public int getNextId() {
			//stuff over here

			synchronized(this) {
				return nextId++;
			}
			
			//Lots more code over here
		}
	}
}
