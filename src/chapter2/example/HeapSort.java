package chapter2.example;

import edu.princeton.cs.algs4.StdOut;

/**
 * 堆排序
 */
public class HeapSort {
    private HeapSort() {}

    /**
     * 基于最大堆的堆排序
     * for 循环构造了堆（堆有序）
     * 然后 while 循环将最大的元素 a[1] 和 a[N] 交换并修复了堆
     * 如此重复直到堆变空
     * @param pq
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >=1; k--) { // 从右到左用sink() 构造子堆，最后在位置为1上调用sink()方法
            sink(pq, k, n);             // 构造了一个堆有序的数组并使最大元素位于数组的开头，次大的元素在附近，而非构造函数结束的结尾
        }

        while (n > 1) { // 将最大的元素 a[1] 和 a[N] 交换并修复堆，如此重复直到堆变空
            exch(pq, 1, n--); // 将 exch() 和 less() 的实现中的索引减一即可得到和其他排序算法一致的实现(将a[0]至a[N-1]排序)
            sink(pq, 1, n);
        }
    }

    /**
     * 基于最小堆的堆排序
     * @param pq
     */
    public static void sortByGreater(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >=1; k--) { // 从右到左用sink() 构造子堆，最后在位置为1上调用sink()方法
            sinkByGreater(pq, k, n);             // 构造了一个堆有序的数组并使最小元素位于数组的开头，次小的元素在附近，而非构造函数结束的结尾
        }

        while (n > 1) { // 将最小的元素 a[1] 和 a[N] 交换并修复堆，如此重复直到堆变空
            exch(pq, 1, n--); // 将 exch() 和 less() 的实现中的索引减一即可得到和其他排序算法一致的实现(将a[0]至a[N-1]排序)
            sinkByGreater(pq, 1, n);
        }
    }


    /**
     * 下沉
     * @param pq 堆数组
     * @param k
     * @param n
     */
    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k < n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }


    private static void sinkByGreater(Comparable[] pq, int k, int n) {
        while (2*k < n) {
            int j = 2*k;
            if (j < n && greater(pq, j, j+1)) j++;
            if (!greater(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static boolean greater(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) > 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = args;
        HeapSort.sortByGreater(a);
        show(a);
    }
}
