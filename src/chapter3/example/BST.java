package chapter3.example;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

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

    /**
     * 二叉查找树一个很重要的特性，就是查找简洁性
     * 查找一个键的递归算法
     * 1、如果树为空，则查找未命中
     * 2、如果查找的键和根结点的键相等，则查找命中。
     * 3、如果查找的键较小就选择左子树，较大则选择右子树
     *
     * 每次迭代后查找的区间就会减少一半，随着不断向下查找，当前结点所表示的子树的大小也在减小。当找到一个含有被查找的键的结点
     * 或者当前子树变为空时才会结束。
     * @param key
     * @return
     */
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

    /**
     * 二叉查找树重要特性就是插入实现的难度和查找差不多。
     * 算法：
     * 1. 如果树是空的，就返回一个含有该键值对的新结点
     * 2. 如果查找的键小于根结点，继续在左子树插入该键，否则在右子树插入该键
     * @param key
     * @param val
     */
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

    public Key max()
    {
        return max(root).key;
    }

    private Node max(Node x)
    {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
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

    /**
     * 查找排名为K的键(即树种正好有K个小于它的键)
     * 1、如果左子树中的结点t大于k,那么继续递归地在左子树查找排名为k的键
     * 2、如果t 等于 k,那么就返回根结点的键
     * 3、如果t小于k，就递归地在右子树查找排名为(k-t-1)的键
     * @param t
     * @return
     */
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

    /**
     * 返回给定键的排名
     * 是 select() 的逆方法
     * 1、如果给定的键和根结点相等，返回左子树的结点总数t
     * 2、如果给定的键小于根结点，返回该键在左子树的排名
     * 3、如果给定的键大于根节点，返回t+1(根结点)+在右子树的排名
     * @param key
     * @return
     */
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

    public void delete(Key key)
    {
        delete(root, key);
    }

    /**
     * 在删除x后用它的后继结点填补它单位置
     * 因为x有一个右子结点，因此它的后继结点就是其右子树的最小结点
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return  x.right;
            Node t = x; // 将指向即将被删除的结点的链接保存为t
            x = min(t.right); // 从要删除的结点右子树找出最小的结点，取代要删除的结点
            x.right = deleteMin(x.right); // 新的x的右子树要去除小于或等于它的结点
            x.left = t.left; // 新的x的左子树依然是原来的左子树
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private void print(Node x)
    {
        if (x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }

    public Iterable<Key> keys()
    {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi > 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args)
    {
        BST bst = new BST();
        for (int i = 0; i < args.length; i++) {
            bst.put(args[i], i);
        }
        bst.print(bst.root  );
    }
}
