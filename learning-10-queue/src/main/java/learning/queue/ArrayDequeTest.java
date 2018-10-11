package learning.queue;

import java.util.ArrayDeque;

/**
 * 双端队列
 * author：millet
 * create at 2018/10/9 11:23
 */
public class ArrayDequeTest {
    private static  ArrayDeque<Integer> arrayDeque = new ArrayDeque();
    public static void main(String[] args) {
        //是Queue的子接口，表示双端队列
        add();

        remove();

        get();

        queueOperate();

        stackOperate();

        other();
    }
    //添加元素
    private static void add(){
        arrayDeque.addFirst(1);//在数组前面添加元素
        arrayDeque.addLast(2);//在数组后面添加元素
        arrayDeque.offerFirst(3) ;//在数组前面添加元素，并返回是否添加成功
        arrayDeque.offerLast(4);// 在数组后天添加元素，并返回是否添加成功
    }

    //.删除元素
    private static void remove(){
       /* arrayDeque.removeFirst();//删除第一个元素，并返回删除元素的值,如果元素为null，将抛出异常
        arrayDeque.pollFirst();//删除第一个元素，并返回删除元素的值，如果元素为null，将返回null
        arrayDeque.removeLast();//删除最后一个元素，并返回删除元素的值，如果为null，将抛出异常
        arrayDeque.pollLast();//删除最后一个元素，并返回删除元素的值，如果为null，将返回null*/
        arrayDeque.addLast(1);//在数组后面添加元素
        arrayDeque.addLast(3);//在数组后面添加元素
        arrayDeque.removeFirstOccurrence(1) ;//删除第一次出现的指定元素
        System.out.println(arrayDeque.getFirst());
        arrayDeque.addLast(2);//在数组后面添加元素
        arrayDeque.removeLastOccurrence(2) ;//删除最后一次出现的指定元素
        System.out.println(arrayDeque.getLast());
    }
    //获取元素
    private static void get(){
        //获取第一个元素,如果没有将抛出异常
        System.out.println(arrayDeque.getFirst());

        // getLast() 获取最后一个元素，如果没有将抛出异常
        System.out.println(arrayDeque.getLast());
    }

    //队列操作
    private static void queueOperate(){
        arrayDeque.add(11) ;//在队列尾部添加一个元素
        arrayDeque.offer(22) ;//在队列尾部添加一个元素，并返回是否成功
        arrayDeque.remove();// 删除队列中第一个元素，并返回该元素的值，如果元素为null，将抛出异常(其实底层调用的是removeFirst())
        arrayDeque.poll() ;// 删除队列中第一个元素，并返回该元素的值,如果元素为null，将返回null(其实调用的是pollFirst())
        arrayDeque.element();// 获取第一个元素，如果没有将抛出异常
        arrayDeque.peek() ;//获取第一个元素，如果返回null

    }
    //栈操作
    private static void stackOperate(){
        arrayDeque.push(33) ;//栈顶添加一个元素
        arrayDeque.pop() ;//移除栈顶元素,如果栈顶没有元素将抛出异常
    }

    private static void other(){
        arrayDeque.size() ;//获取队列中元素个数
        arrayDeque.isEmpty() ;//判断队列是否为空
        arrayDeque.iterator() ;//迭代器，从前向后迭代
        arrayDeque.descendingIterator() ;//迭代器，从后向前迭代
        arrayDeque.contains(11);// 判断队列中是否存在该元素
        arrayDeque.toArray() ;//转成数组
        arrayDeque.clear();// 清空队列
        arrayDeque.clone() ;//克隆(复制)一个新的队列
    }
}
