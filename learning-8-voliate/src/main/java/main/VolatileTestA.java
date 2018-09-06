package main;

/**
 * 
 *  volatile防止重排序->内存屏障
 * 
 *  
 *  很容易想到这段代码的运行结果可能为(1,0)、(0,1)或(1,1)，因为线程one可以在线程two开始之前就执行完了，
 *  也有可能反之，甚至有可能二者的指令是同时或交替执行的。
 * 
 *  然而，这段代码的执行结果也可能是(0,0).
 *
 */
public class VolatileTestA {
	
	static int i;
	
	int x = 0, y = 0;
	int a = 0, b = 0;

//	volatile int x = 0;
//	volatile int y = 0;
//	volatile int a = 0;
//  volatile int b = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		while (true) {
			VolatileTestA p = new VolatileTestA();
			Thread one = new Thread(new Runnable() {
				public void run() {
					p.a = 1;
					p.x = p.b;
				}
			}, "A");

			Thread other = new Thread(new Runnable() {
				public void run() {
					p.b = 1;
					p.y = p.a;
				}
			}, "B");
			one.start();
			other.start();
			one.join();
			other.join();
			
			System.out.println(String.format("第{%s}次，(%s,%s) ", i++, p.x, p.y));
			
			if (p.x == 0 && p.y == 0) {
				System.out.println("exit (0,0)");
				break;
			}
		}
	}
	
	// 一个在项目里面见过的bug，判断某个bean里面的boolean是否为ture，若是true执行逻辑。
	class WrongExample {

	    int i = 0;
	    volatile boolean flag = false;

	    //Thread A
	    public void write(){
	        i = 2;              //1
	        flag = true;        //2
	    }

	    //Thread B
	    public void read(){
	        if(flag){                                   //3
	            System.out.println("---i = " + i);      //4
	        }
	    }
	    
	    public void main(String[] args) throws InterruptedException {
	    	WrongExample wrongExample = new WrongExample();
	    	Thread one = new Thread(new Runnable() {
				public void run() {
					wrongExample.write();
				}
			}, "A");

			Thread other = new Thread(new Runnable() {
				public void run() {
					wrongExample.read();
				}
			}, "B");
			one.start();
			other.start();
			one.join();
			other.join();
	    }
	    	
	}
}
