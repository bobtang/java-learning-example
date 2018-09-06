package main;

/**
 * 
 * volatile原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性
 * 
 */
public class VolatileTestB {
	volatile int i;

	public void addI() {
		i++;
	}

	public static void main(String[] args) throws InterruptedException {
		final VolatileTestB testB = new VolatileTestB();
		for (int n = 0; n < 10000; n++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					testB.addI();
				}
			}).start();
		}

		Thread.sleep(10000);//等待10秒，保证上面程序执行完成

		System.out.println(testB.i);
	}

}
