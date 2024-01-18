package _04_Thread_Pool;

public class runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkQueue wq = new WorkQueue();
		System.out.println("Total threads: " + wq.getThreadCount());
		wq.shutdown();
	}

}
