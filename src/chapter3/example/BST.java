package chapter3.example;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
        }
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Value get(Key key)
    {
        return this.get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if (x == null) {
            return null;
        } else {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return this.get(root.left, key);
            } else if (cmp > 0) {
                return this.get(root.right, key);
            } else {
                return x.val;
            }
        }
    }

    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val)
    {
        if (x == null) {
            return new Node(key, val, 1);
        } else {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, val);
            } else if (cmp > 0) {
                x.right = put(x.right, key, val);
            } else {
                x.val = val;
            }
            x.N = size(x.left) + size(x.right)+1;
            return x;
        }
    }

    public Key min()
    {
        return min(root).key;
    }

    private Node min(Node x)
    {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * 向下取整
     * @param x Node
     * @param key Key
     * @return Node
     */
    private Node floor(Node x, Key key)
    {
        if (x == null) {
            return null;
        } else {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp < 0) {
                return floor(x.left, key);
            }
            Node t = floor(x.right, key);
            if (t != null) {
                return t;
            } else  {
                return x;
            }
        }
    }

    // 查找排名为K的键
    public Key select(int t)
    {
        return select(root, t).key;
    }

    private Node select(Node x, int k)
    {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k)  return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else  return x;
    }

    // 返回给定键的排名
    public int rank(Key key)
    {
        return rank(key, root);
    }

    private int rank(Key key, Node x)
    {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    /**
     * 删除最小键
     */
    public void deleteMin()
    {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x)
    {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
