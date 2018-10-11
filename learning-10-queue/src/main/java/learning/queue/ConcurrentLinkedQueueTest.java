package learning.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * author：millet
 * create at 2018/10/10 14:03
 */
public class ConcurrentLinkedQueueTest {
    //       它是一个基于链接节点的无界线程安全队列。
    //ConcurrentLinkedQueue是Queue的一个安全实现．Queue中元素按FIFO原则进行排序．采用CAS操作，来保证元素的一致性。

    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue();

    // cas 算法 https://blog.csdn.net/mmoren/article/details/79185862

    public static void main(String[] args) {
        //添加元素
        queue.add(1);
        queue.offer(2);

        //删除
        queue.remove(1);
        queue.poll();

        queue.peek();

        //遍历获取
        queue.size();
    }


}
