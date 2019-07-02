package chapter3.example;

/**
 * 顺序查询(基于无序链表)
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value>
{
    private Node first; // 链表首结点

    private class Node
    {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val)
    {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val; // 命中更新
                return;
            }
        }
        first = new Node(key, val, first); // 未命中，新建结点
    }
}
