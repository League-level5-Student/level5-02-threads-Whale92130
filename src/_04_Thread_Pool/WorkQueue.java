package _04_Thread_Pool;

import java.util.ArrayDeque;

public class WorkQueue implements Runnable {
	ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();
	private Thread[] threads;
	private Boolean isRunning = true;

	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors() - 1;
		threads = new Thread[totalThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
			threads[i].start();
		}

	}

	public int getThreadCount() {
		return threads.length;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			System.out.println("Output from thread #" + Thread.currentThread().getId());
			synchronized (jobQueue) {
				try {
					jobQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void completeAllJobs() {
		while (!jobQueue.isEmpty()) {
			preformJob();
		}
	}

	public boolean preformJob() {
		Job j = null;
		synchronized (jobQueue) {
			if (!jobQueue.isEmpty()) {
				j = jobQueue.remove();
			}
		}
		if (j != null) {
			j.preform();
			return true;

		} else {
			return false;
		}
	}

	public void shutdown() {
		completeAllJobs();
		isRunning = false;
		synchronized (jobQueue) {
			jobQueue.notifyAll();
		}
	}

	public void addJob(Job j) {
		synchronized (jobQueue) {
			jobQueue.add(j);
			jobQueue.notify();
		}
	}

}
