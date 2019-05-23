package com.ethanzyc.allinone.data.list;

/**
 * 手写一个数组集合
 * @author ethan
 * @date 2019/5/17 02:41
 */
public class MyArrayList<T> {
    /** array list 简单说就是内存地址在硬盘中是连续的数组 **/
    private T[] array;
    /** index相当于数组的指针，通过指针来表示数组的长度，以及定位添加的位置 **/
    private int index;

    /**
     * 数组集合无参构造函数，不指定容量就默认为10
     */
    public MyArrayList() {
        this(10);
    }

    /**
     * 数组集合指定长度构造函数
     * @param length
     */
    public MyArrayList(int length) {
        this.array = (T[]) new Object[length];
    }

    /**
     * 获取数组的长度，有多少值，size就是多少，不同于数组的容量
     * 其实是通过一个指针去控制
     * @return
     */
    public int size() {
        return index;
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 集合新增元素
     * @param t
     */
    public void add(T t) {
        add(t, index);
    }


    /**
     * 集合指定位置新增元素，
     * ##private##
     * @param t
     * @param index
     */
    public void add(T t, int index) {
        // 如果数组的长度等于数组的指针，就扩容
        if (array.length == size()) {
            int newLength = array.length * 2 - 1;
            enlargeList(newLength);
            System.out.println("扩容到了" + newLength);
        }
        // 如果指定的位置大于list的长度，就还是把这个值add到集合的末尾
        if (index > size()) {
            index = size();
        }
        // 如果插入的位置在他之前，就需要把他之后的元素都向后移一位，然后插入
        if (index < size()) {
            for (int i = size(); i > index-1 ; i--) {
                array[i] = array[i-1];
            }
        }
        array[index] = t;
        this.index++;

    }

    /**
     * 数组扩容
     * @param newSize
     */
    public void enlargeList(int newSize) {
        if (newSize < size()) {
            return;
        }
        T[] oldArr = array;
        array = (T[]) new Object[newSize];
        for (int i = 0; i < oldArr.length; i++) {
            array[i] = oldArr[i];
        }
    }

    /**
     * 获取下标为index的函数
     * @param index
     * @return
     */
    public T get(int index) {
        return array[index];
    }


    /**
     * 设置下表为 index 的值，并返回原来的值
     * @param index
     * @param newVal
     * @return
     */
    public T set(int index, T newVal) {
        if (index < 0 || index > size()) {
            throw  new IndexOutOfBoundsException();
        } else {
            T toReturn = array[index];
            array[index] = newVal;
            return toReturn;
        }
    }

    /**
     * 移除元素
     * 数组因为在内存中是连续的，所以删除的时候把这个元素的后一位前移一位都行
     * 这也是数组集合增删慢的原因
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw  new IndexOutOfBoundsException();
        } else {
            // 将后面每一位赋值到前一位
            T oldVal = array[index];

            for (int i = index; i < size()-1; i++) {
                array[i] = array[i+1];
            }

            this.index--;

            return oldVal;
        }
    }

    @SuppressWarnings("AlibabaRemoveCommentedCode")
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>(6);

        System.out.println(list.size());

        /* test1 start**/
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        println(list);
//        list.add(222,10);
//        println(list);
        /* test1 end */

        /* test2 start**/
//        list.add(1);
//        System.out.println(list.get(0));
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        println(list);
//        println(list);
//        Integer oldVal = list.set(3, 20);
//        System.out.printf("原来的值:%d", oldVal);
//        System.out.println();
//        println(list);
//        Integer remove = list.remove(1);
//        System.out.println(remove);
//        println(list);
        /* test2 end**/
    }

    private static void println(MyArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * 基础知识：测试数组复制
     * 1.a = new int[...] 会把这个a与这个数组对象的引用断开，重新指向一个新的内存地址，
     *   但是b与a之前的数组对象还是存在引用，所以a重新分配对象并不会影响到b
     * 2.a[?] = ? 改变的仍是a指向的内存地址中的数据，由于b也是指向这个内存地址，所以这样操作会影响到b
     * @param args
     */
    public static void testCopy(String[] args) {
        int[] a = new int[]{1,2,4};
        println(a);

        int[] b = a;

        println(a);
        println(b);

        a = new int[2];
        println(a);
        println(b);

        int[] c = a;

        println(b);
        println(c);

        a[0] = 101;
        println(b);
        println(c);


    }

    private static void println(int[] list) {
        for (int aList : list) {
            System.out.print(aList + " ");
        }
        System.out.println("");
    }
}
