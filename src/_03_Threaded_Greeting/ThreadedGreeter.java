package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	int noomber;

	public ThreadedGreeter(int num) {
		// TODO Auto-generated constructor stub
		this.noomber = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " +noomber);
		if (noomber < 50) {
			Thread t = new Thread(() -> new ThreadedGreeter(noomber+1).run());
			t.start();
		}
	}

}
