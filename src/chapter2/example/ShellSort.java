package chapter2.example;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * 希尔排序
 */
public class ShellSort
{
    private static boolean less(Comparator comparator, Object v, Object w)
    {
        return comparator.compare(v, w) < 0;
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

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -=h) {
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args)
    {
        if (args.length == 0) {
            StdOut.println("Please input params");
        }
        //String[] a = StdIn.readAllStrings();
        ShellSort.sort(args);
        show(args);
    }
}
