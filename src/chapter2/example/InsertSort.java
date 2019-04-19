package chapter2.example;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class InsertSort {
    private InsertSort() {}

    private static boolean less(Object lo, Object hi, Comparator comparator) {
        return comparator.compare(lo, hi) < 0;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * 返回一个排序，返回的数据是索引位置
     * @param a
     * @return array
     */
    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--) {
                exch(index, j, j-1);
            }
        }
        return index;
    }

    /**
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    /**
     *
     * @param a the array to be sorted
     * @param lo left endpoint
     * @param hi right endpoint
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    /**
     *
     * @param a the array to be sorted
     * @param comparator the comparator specify the order
     */
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i =1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1], comparator); j--) {
                exch(a, j , j-1);
            }
        }
    }

    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        InsertSort.sort(args);
        show(args);
    }

}
