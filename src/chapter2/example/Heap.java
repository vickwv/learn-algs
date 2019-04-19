package chapter2.example;

import edu.princeton.cs.algs4.StdOut;

/**
 * 堆排序
 */
public class Heap {
    private Heap() {}

    /**
     * for 循环构造了堆（堆有序）
     * 然后 while 循环将最大的元素 a[1] 和 a[N] 交换并修复了堆
     * 如此重复直到堆变空
     * @param pq
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >=1; k--) {
            sink(pq, k, n);
        }

        while (n > 1) {
            exch(pq, 1, n--); // 删除最大元素，放入堆缩小后数组空出的位置
            sink(pq, 1, n);
        }
    }

    /**
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

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
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
        Heap.sort(a);
        show(a);
    }
}
