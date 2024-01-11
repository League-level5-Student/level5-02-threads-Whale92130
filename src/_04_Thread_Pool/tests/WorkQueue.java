package _04_Thread_Pool.tests;

public class WorkQueue implements Runnable{
	private Thread[] threads;
	
	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors()-1;
		threads = new Thread[totalThreads];
		
		
	}
	public int getThreadCount() {
		return threads.length;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
