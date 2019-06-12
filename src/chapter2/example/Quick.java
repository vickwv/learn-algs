package chapter2.example;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序，原地切分版本。快排的根本主要取决于切分是否平衡
 */
public class Quick
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    /**
     * 三向分切快排
     * 将数组切分为三部分，分别对应小于，等于，大于切分元素的数组元素
     * @param a
     * @param lo
     * @param hi
     */
    private static void sortByThreeWay(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi; // lt < v的指针, i = v的指针, gt > v的指针
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++); // 小于 v, 将lt和i交换，lt和i加1
            else if (cmp > 0) exch(a, gt++, i); // 大于v, 将gt和i交换, gt加1
            else i++;// 等于ｖ,将i加１
        }
        sort(a, lo, lt-1);
        sort(a, gt + 1, hi);
    }

    // 对于小数组，快速排序比插入排序慢
    private static void sortByInsert(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo+5) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1; // 左右扫描指针
        Comparable v = a[lo]; // 切分元素
        while (true) {
            // 扫描左右，检查扫面是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break; // 从左向右扫描，遇到比v大的停下
            while (less(v, a[--j])) if (j == lo) break; // 从右向左扫描，遇到比v小的停下
            if (i >= j) {
                break;
            }
            exch(a, i, j); // 交换左右元素
        }
        // ij指针相遇，将左子数组最右侧的元素j，与切分元素交换。返回j
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j)
    {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args)
    {
        sort(args);
        show(args);
    }
}
