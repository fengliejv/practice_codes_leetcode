package test;

public class MultiThread {

	public static void main(String[] args) {

		new Thread(new Thread1()).start();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable {
		@Override
		public void run() {
			
			synchronized (MultiThread.class) {
				System.out.println("enterthread1...");
				System.out.println("thread1is waiting");
				try {
					
					MultiThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread1is going on...");
				System.out.println("thread1is being over!");
			}
		}
	}

	private static class Thread2 implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (MultiThread.class) {
				System.out.println("enterthread2...");
				System.out
						.println("thread2notify other thread can release wait status..");
				MultiThread.class.notify();
				System.out.println("thread2is sleeping ten millisecond...");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread2is going on...");
				System.out.println("thread2is being over!");
			}
		}
	}
}
