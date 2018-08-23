import org.junit.Test;

import java.util.*;

/**
 * 2 * @Author: ZhangYongXiang
 * 3 * @Date: 2018/8/18 16:20
 * 4
 */
public class CollectionUtils {

    /*集合 Collection 简介*/
    @Test
    public void collection() {
        Collection<String> collection1 = new ArrayList<>();//创建一个集合对象
        collection1.add("000");//添加对象到Collection集合中
        collection1.add("111");
        collection1.add("222");

        System.out.println("集合collection1的大小：" + collection1.size());
        System.out.println("集合collection1的内容：" + collection1);
        collection1.remove("000");//从集合collection1中移除掉 "000" 这个对象
        System.out.println("集合collection1移除 000 后的内容：" + collection1);

        System.out.println("集合collection1中是否包含000 ：" + collection1.contains("000"));
        System.out.println("集合collection1中是否包含111 ：" + collection1.contains("111"));

        Collection<String> collection2 = new ArrayList<>();
        collection2.addAll(collection1);//将collection1 集合中的元素全部都加到collection2中
        System.out.println("集合collection2的内容：" + collection2);
        collection2.clear();//清空集合 collection1 中的元素
        System.out.println("集合collection2是否为空 ：" + collection2.isEmpty());

        //将集合collection1转化为数组
        Object s[] = collection1.toArray();
        for (Object value : s) {
            System.out.println(value);
        }
    }

    /*迭代器 Iterator接口*/
    @Test
    public void iteratorDemo() {
        Collection collection = new ArrayList();
        collection.add("s1");
        collection.add("s2");
        collection.add("s3");
        Iterator iterator = collection.iterator();//得到一个迭代器
        while (iterator.hasNext()) {//遍历
            Object element = iterator.next();
            System.out.println("iterator = " + element);
        }
        if (collection.isEmpty())
            System.out.println("collection is Empty!");
        else
            System.out.println("collection is not Empty! size=" + collection.size());

        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {//移除元素
            Object element = iterator2.next();
            System.out.println("remove: " + element);
            iterator2.remove();
        }
        Iterator iterator3 = collection.iterator();
        if (!iterator3.hasNext()) {//察看是否还有元素
            System.out.println("没有元素了");
        }
        if (collection.isEmpty())
            System.out.println("collection is Empty!");
        //使用collection.isEmpty()方法来判断
//        Vector a = new Vector();

    }

    /*List接口*/
    /*实现原理*/
    /*Fail-Fast 快速失效策略*/
    /*扩容*/

    /*Set接口*/
    /*实现原理*/
    @Test
    public void hashSetDemo() {
        Set<String> set1 = new HashSet<>();
        if (set1.add("a")) {//添加成功
            System.out.println("1 add true");
        }
        if (set1.add("a")) {//添加失败
            System.out.println("2 add true");
        }
        set1.add("000");//添加对象到Set集合中
        set1.add("111");
        set1.add("222");
        System.out.println("集合set1的大小：" + set1.size());
        System.out.println("集合set1的内容：" + set1);

        set1.remove("000");//从集合set1中移除掉 "000" 这个对象
        System.out.println("集合set1移除 000 后的内容：" + set1);
        System.out.println("集合set1中是否包含000 ：" + set1.contains("000"));
        System.out.println("集合set1中是否包含111 ：" + set1.contains("111"));

        Set<String> set2 = new HashSet<String>();
        set2.add("111");
        set2.addAll(set1);//将set1 集合中的元素全部都加到set2中
        System.out.println("集合set2的内容：" + set2);

        set2.clear();//清空集合 set1 中的元素
        System.out.println("集合set2是否为空 ：" + set2.isEmpty());

        Iterator<String> iterator = set1.iterator();//得到一个迭代器
        while (iterator.hasNext()) {//遍历
            Object element = iterator.next();
            System.out.println("iterator = " + element);
        }

        //将集合set1转化为数组
        Object s[] = set1.toArray();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    @Test
    public void setSortExample() {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<Integer>();
        for (int i = 0; i < 5; i++) {
            //产生一个随机数，并将其放入Set中
            int s = (int) (Math.random() * 100);
            set1.add(s);
            set2.add(s);
            System.out.println("第 " + i + " 次随机数产生为：" + s);
        }
        System.out.println("未排序前HashSet：" + set1);
        System.out.println("未排序前LinkedHashSet：" + set2);
        //使用TreeSet来对另外的Set进行重构和排序
        Set<Integer> sortedSet = new TreeSet<>(set1);
        System.out.println("排序后 TreeSet ：" + sortedSet);
    }

    /*集合初始容量相关*/
    @Test
    public void defaultValuesTest() {
        final int count = 20 * 100000;
        List<Integer> list = new ArrayList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        System.out.println("没有设置ArrayList初始容量： " + (System.currentTimeMillis() - begin) + " ms");

        list = new ArrayList<>(count);
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        System.out.println("设置了ArrayList初始容量： " + (System.currentTimeMillis() - begin) + " ms");
    }

    /* Arrays 工具类*/
    @Test
    public void arrays() {
        int[] array = new int[5];
        //填充数组
        Arrays.fill(array, 5);
        System.out.println("填充数组：Arrays.fill(array, 5)：");
        output(array);


        //将数组的第2和第3个元素赋值为8
        Arrays.fill(array, 2, 4, 8);
        System.out.println("将数组的第2和第3个元素赋值为8：Arrays.fill(array, 2, 4, 8)：");
        output(array);
        int[] array1 = {7, 8, 3, 2, 12, 6, 3, 5, 4};
        //对数组的第2个到第6个进行排序进行排序
        Arrays.sort(array1, 2, 7);
        System.out.println("对数组的第2个到第6个元素进行排序进行排序：Arrays.sort(array,2,7)：");
        output(array);

        //对整个数组进行排序
        Arrays.sort(array1);
        System.out.println("对整个数组进行排序：Arrays.sort(array1)：");
        output(array);

        //比较数组元素是否相等
        System.out.println("比较数组元素是否相等:Arrays.equals(array, array1):" + "\n" + Arrays.equals(array, array1));
        int[] array2 = array1.clone();
        System.out.println("克隆后数组元素是否相等:Arrays.equals(array1, array2):" + "\n" + Arrays.equals(array1, array2));

        //使用二分搜索算法查找指定元素所在的下标（必须是排序好的，否则结果不正确）
        Arrays.sort(array1);
        System.out.println("元素3在array1中的位置：Arrays.binarySearch(array1, 3)：" + "\n" + Arrays.binarySearch(array1, 3));
        //如果不存在就返回负数
        System.out.println("元素9在array1中的位置：Arrays.binarySearch(array1, 9)：" + "\n" + Arrays.binarySearch(array1, 9));
    }

    private void output(int[] array) {
        if (array != null) {
            for (int anArray : array) {
                System.out.println(anArray + " ");
            }
        }

    }


    /* Collections 工具类*/
    @Test
    public void collections() {
        //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);

        Collections.reverse(numbers);
        System.out.println("翻转后集合中的数据:");
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);

        Collections.swap(numbers,0,5);
        System.out.println("交换0和5下标的数据后，集合中的数据:");
        System.out.println(numbers);

        Collections.rotate(numbers,2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);

        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
    }
}

