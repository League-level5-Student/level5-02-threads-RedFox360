package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!taskQueue.isEmpty()) {
			Task task = taskQueue.remove();
			task.perform();
		}
	}
	
	public Worker(ConcurrentLinkedQueue<Task> taskQueue) {
		this.taskQueue = taskQueue;
	}
	


}
