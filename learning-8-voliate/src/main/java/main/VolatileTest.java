package main;

/**
 * 
 * 可见性
 * 
 * 
 * 正常情况下，如果先执行change方法，再执行print方法，输出结果应该为b=3;a=3。
 * 相反，如果先执行的print方法，再执行change方法，结果应该是 b=2;a=1。
 * 如果在change方法a = 3;执行时，执行print，结果应该是 b=2;a=3。
 * 
 * 为什么会出现b=3;a=1这种结果呢？
 * 
 */
public class VolatileTest {
	int a = 1;
	int b = 2;

	public void change() {
		a = 3;
		b = a;
	}

	public void print() {
		System.out.println("b=" + b + ";a=" + a);
	}

	public static void main(String[] args) {
		int i = 10000;
		while (i-- > 0) {
			final VolatileTest test = new VolatileTest();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.change();
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.print();
				}
			}).start();

		}
	}
}
