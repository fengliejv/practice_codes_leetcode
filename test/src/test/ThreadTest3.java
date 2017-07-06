package test;

public class ThreadTest3 {
	private static boolean bShouldMain = false;

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					synchronized (ThreadTest.class) {
						if (bShouldMain) {
							try {
								ThreadTest.class.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for (int j = 0; j < 10; j++) {
							System.out.println(Thread.currentThread().getName()
									+ "i=" + i + ",j=" + j);
						}
						bShouldMain = true;
						ThreadTest.class.notify();
					}
				}
			}
		}).start();
		for (int i = 0; i < 50; i++) {
			synchronized (ThreadTest.class) {
				if (!bShouldMain) {
					try {
						ThreadTest.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 0; j < 5; j++) {
					System.out.println(Thread.currentThread().getName() + "i="
							+ i + ",j=" + j);
				}
				bShouldMain = false;
				ThreadTest.class.notify();
			}
		}
	}
}
