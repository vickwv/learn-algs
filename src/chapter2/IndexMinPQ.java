package chapter2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int maxN; // 队列最大容量
    private int n; // 索引优先队列大小
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int maxN) {
        if (maxN < 0) {
            throw new IllegalArgumentException();
        }

        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN +1];
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        for (int i = 0; i < maxN; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 是否存在索引为k的元素
     * @param k　索引
     * @return boolean
     * @throws IllegalArgumentException
     */
    public boolean contains(int k) {
        if (k < 0 || k >= maxN) throw new IllegalArgumentException();
        return qp[k] != -1;
    }

    public int size() {
        return n;
    }

    /**
     * 插入一个元素，将它和索引k相关联
     * @param k　an index
     * @param key an index value
     */
    public void insert(int k, Key key) {
        if (k < 0 || k >= maxN) throw new IllegalArgumentException();
        if (contains(k)) throw new IllegalArgumentException("index is already in the PQ");
        n++;
        qp[k] = n;
        pq[n] = k;
        keys[k] = key;
        swim(n);
    }

    /**
     * 返回最小的索引
     * @return
     */
    public int minIndex() {
        if (n == 0) throw new IllegalArgumentException();
        return pq[1];
    }

    /**
     * 返回最小的key
     * @return
     */
    public Key minKey() {
        if (n == 0) throw new IllegalArgumentException();
        return keys[pq[1]];
    }

    /**
     * 删除最小的
     * @return
     */
    public int delMin() {
        if (n == 0) throw new IllegalArgumentException();
        int min = pq[1];
        exch(1, n--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n+1] = -1;
        return min;
    }

    public void delete(int k) {
        if (k < 0 && k >= maxN) throw new IllegalArgumentException();
        if (!contains(k)) throw new NoSuchElementException("index is not in the pq");
        int index = qp[k];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    public Key keyof(int k) {
        if (k < 0 && k >= maxN) throw new IllegalArgumentException();
        if (!contains(k)) throw new NoSuchElementException("index is not in the pq");
        else return keys[k];
    }

    public void changeKey(int k, Key key) {
        if (k < 0 && k >= maxN) throw new IllegalArgumentException();
        if (!contains(k)) throw new NoSuchElementException("index is not in the pq");
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void change(int k, Key key) {
        changeKey(k, key);
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 某个结点比它的父结点更小
     * @param k an index
     */
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * 某个结点比它的两个子结点或子结点其中之一更大
     * @param k an index
     */
    private void sink(int k) {
        while (2*k < n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) {
                j++;
            }
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    private class HeapIterator implements Iterator<Integer> {
        private IndexMinPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMinPQ<>(pq.length-1);
            for (int i = 1; i < n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

        IndexMinPQ<String> pq = new IndexMinPQ<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        StdOut.println();

        while (!pq.isEmpty()) {
            int i = pq.delMin();
            StdOut.println(i + " " + strings[i]);
        }
    }
}
