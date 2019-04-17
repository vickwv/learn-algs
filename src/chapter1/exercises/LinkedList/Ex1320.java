package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.20 编写一个方法delete(), 接受一个Int参数k, 删除链表的第k个元素
 */
public class Ex1320<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;
    private Node<Item> last;

    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    /**
     * 删除某个元素
     * @param k int
     * @return boolean
     */
    public boolean delete(int k)
    {
        boolean res = false;

        if (this.size() < k) {
            return res;
        } else {
            Node<Item> itemNode = this.find(k);
            if (itemNode != null) {
                Node<Item> temp = itemNode.next.next;
                itemNode.next = null;
                itemNode.next = temp;
                res = true;
            }
        }

        return res;
    }

    /**
     * 打印队列
     */
    public void printQueue()
    {
        Node<Item> current = first;
        while (current != null) {
            StdOut.println(current.item);
            if (current.next == null) {
                current = null;
            } else {
                current = current.next;
            }
        }
    }


    /**
     * 寻找K
     * @param k int
     * @return Node
     */
    private Node<Item> find(int k)
    {
        Node<Item> current = first;
        for (int i = 0; i < k; i++) {
            if (current.next != null) {
                if (i == k-2 ) {
                    return current;
                }
                current = current.next;
            } else {
                return null;
            }
        }

        return null;
    }

    public static void main(String[] args)
    {
        if (args.length == 0)  {
            StdOut.println("Please input param");
            return;
        }

        Ex1320<String> q = new Ex1320<>();
        for (String item: args) {
            q.enqueue(item);
        }

        q.printQueue();
        int k = 3;

        if (q.delete(k)) {
            StdOut.println("delete success");
            q.printQueue();
        } else {
            StdOut.println("delete failed");
        }
    }

}
