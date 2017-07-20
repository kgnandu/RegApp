package regapp.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	private static Object syncObject = new Object();
	private static ExecutorService executor;
	public static void main(String[] args) {
		executor = Executors.newFixedThreadPool(10);
		ExecutorDemo td =new ExecutorDemo();
		td.go2();
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void go2() {
		DataHolder dh = new DataHolder();
		MyCallable worker1 = new MyCallable("Worker 1", dh);

		MyCallable worker2 = new MyCallable("Worker 2", dh);
		
		Future<Integer> f1 = executor.submit(worker1);
		Future<Integer> f2 = executor.submit(worker2);
		
		executor.submit(() -> 	{
			for(int i = 0; i < 1000; i++) {
				int id = dh.getNextId();
			}
			
			return 10;
		});
		
		
		try {
			int sum1 = f1.get();
			int sum2 = f2.get();

			System.out.println("final = " + sum1 + sum2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public class MyCallable implements Callable<Integer>
	{
		private String name;
		private int sum;
		private DataHolder dh;

		public MyCallable(String name, DataHolder dh) {
			this.name = name;
			this.dh = dh;
		}

		public Integer call() {
			for(int i = 0; i < 1000; i++) {
				sum += i;
			}
			
			return sum;
		}
	}
	
	public void go() {
		DataHolder dh = new DataHolder();
		MyWorker worker1 = new MyWorker("Worker 1", dh);

		MyWorker worker2 = new MyWorker("Worker 2", dh);
		
		Future<?> f1 = executor.submit(worker1);
		Future<?> f2 = executor.submit(worker2);
		
		
		try {
			f1.get();
			f2.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
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
