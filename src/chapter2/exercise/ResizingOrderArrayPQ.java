package chapter2.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 有序数组实现优先队列
 * @param <Key>
 */
public class ResizingOrderArrayPQ<Key extends Comparable<Key>> {
    private Key[] pq = (Key[]) new Comparable[1];
    private int N;

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
        if (N == pq.length) {
            resize(2*pq.length);
        }

        if (this.isEmpty()) {
            pq[N++] = key;
        } else {
            pq[N++] = key;
            // 选择排序，最大元素在数组首个元素
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + 1; j < N; j++) {
                    if (less(j, min)) {
                        min = j;
                    }
                }
                exch(min, i);
            }
        }
    }

    public Key delMax() {
        Key max = pq[N-1];
        pq[N-1] = null;
        N--;
        return max;
    }

    public static void main(String[] args) {
        ResizingOrderArrayPQ<String> pq = new ResizingOrderArrayPQ<>();
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
