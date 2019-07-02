package chapter3.example;

/**
 * 有序数组(二分查找)版本符号表
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int cap) {
        keys = (Key[]) new Comparable[cap]; // 保证键有序
        vals = (Value[]) new Object[cap];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        } else {
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0) {
                return vals[i];
            } else {
                return null;
            }
        }
    }

    // 返回表中小于给定键的数量
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int rank(Key key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid-1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    /**
     * 找到就更新，没找到就插入合适的位置
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j--) { // 将更大的键向后移动一格(从后向前移动)
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; // 将给定的键值插入
        vals[i] = val;
        N++;

    }

    private boolean isEmpty() {
        return N == 0;
    }
}
