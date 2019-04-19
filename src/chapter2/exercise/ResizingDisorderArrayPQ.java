package chapter2.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 练习 2.4.3 无序数组实现堆
 */
public class ResizingDisorderArrayPQ<Key extends Comparable<Key>>{
    private Key[] pq = (Key[]) new Comparable[1]; //堆
    private int N = 0;

    private boolean isEmpty() {
        return N == 0;
    }

    private int size() {
        return N;
    }

    private void resize(int max) {
        Key[] temp = (Key[]) new Comparable[max];

        for (int i = 0; i < N; i ++) {
            temp[i] = pq[i];
        }

        pq = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public void insert(Key key) {
        if (N == pq.length) resize(2 * pq.length);
        pq[N++] = key;
    }

    public Key delMax() {
        Key max = pq[0];
        int index = 0;
        for (int i = 1; i < N; i++) {
            if (less(index, i)) {
                max = pq[i];
                index = i;
            }
        }
        exch(index, N-1);
        pq[N-1] = null;
        N--;
        return max;
    }

    public static void main(String[] args) {
        ResizingDisorderArrayPQ<String> pq = new ResizingDisorderArrayPQ<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("*") && !pq.isEmpty()) {
                String max = pq.delMax();
                StdOut.println("delete max:"+max+"\n");
            } else {
                pq.insert(args[i]);
                StdOut.println("insert one:"+args[i]+"\n");
            }
        }
    }

}
