package chapter3.example;

/**
 * 开放地址散列表
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key, Value> {
    private int N; // 符号表中键值对的总数
    private int M;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST(int capacity)
    {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
        M = capacity;
        N = 0;
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity)
    {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        M    = temp.M;
    }

    public void put(Key key, Value val)
    {
        if (N >= M/2) resize(2*M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
}
