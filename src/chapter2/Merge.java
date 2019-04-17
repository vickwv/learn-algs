package chapter2;

import edu.princeton.cs.algs4.StdOut;

public class Merge
{
    private static int count = 0;

    private Merge() {}

    private static boolean isSorted(Comparable[] a)
    {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    /**
     * 原地排序
     * 两个有序数组，从两个数组的首项开始比较，左边大于右边，取右边；右边比左边大，取左边。
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
        assert isSorted(a, lo, hi);
    }

    /**
     * 自顶向下（递归）
     * @param a
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (!less(a[mid], a[mid+1])) {
            merge(a, aux, lo, mid, hi);
            count++;
        }

//        StdOut.println("a("+lo+","+mid+")\n");
//        StdOut.println("a("+(mid+1)+","+hi+")\n");
        StdOut.println("m("+lo+","+mid+","+hi+")\n");
    }

    /**
     * 自底向上排序
     * @param a
     */
    private static void sortBu(Comparable[] a)
    {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = 2 * sz) {
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge(a, aux, lo, lo + sz -1, Math.min(lo+2*sz-1, N-1));
                StdOut.println("m("+lo+","+(lo+sz-1)+","+Math.min(lo+2*sz-1, N-1)+")\n");
                ++count;
            }
        }
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }

    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args)
    {
        if (args.length == 0) {
            StdOut.println("Please input params");
        }
        String[] a = args;
//        show(a);
//        StdOut.println("************************************");
        Merge.sort(a);
        StdOut.println("count:"+count);

//        show(a);
    }
}
