package chapter3.example;

/**
 * 红黑二叉查找树
 * 基本思想：用标准的二叉查找树(2-结点)和一些额外的信息(替换3-结点)来表示2-3树
 * 树中的链接分为两个类型：
 *  红链接：将两个2-结点连接起来构成3-结点
 *  黑链接：2-3树中的普通的链接
 */
public class RedBackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node
    {
        Key key;
        Value val;
        Node left, right;
        int N;      // 这颗子树的结点总数
        boolean color; // 由其父结点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * 左旋转
     * 将用两个键中的较小者作为根结点变为将较大者作为根结点
     * @param h
     * @return
     */
    Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转
     * @param h
     * @return
     */
    Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
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
     * 颜色转换
     * 不会影响整颗树的黑色平衡性
     * @param h
     */
    void flipColors(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key ,val);
        root.color = BLACK;
    }

    /**
     * 插入算法
     * 如果右子结点是红色而左子结点时黑色，进行左旋转
     * 如果左子结点是红色的且它的左子结点也是红色的，进行右旋转
     * 如果左右子结点都是红色的，进行颜色交换
     * @param h
     * @param key
     * @param val
     * @return
     */
    private Node put(Node h, Key key, Value val)
    {
        if (h == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public static void main(String[] args) {
        RedBackBST<String, Integer> backBST = new RedBackBST<>();
        for (int i = 0; i < args.length; i++) {
            backBST.put(args[i], i);
        }
    }
}
