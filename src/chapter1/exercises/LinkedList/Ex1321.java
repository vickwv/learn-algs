package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.21 编写一个方法 find().接受一条链表和一个字符串key作为参数。
 * 如果链表中的某个结点的item域的值为key, 则返回true,否则返回false
 */
public class Ex1321<Item> implements Iterable<Item> {
    private int n; // number of elements

    private class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first;
    private Node<Item> last;

    @Override
    public Iterator<Item> iterator()
    {
        return new ListIterator<>(first);
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

    public Boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return n;
    }

    public boolean find(String key)
    {
        Node<Item> current = first;

        while (current.item != null) {
            if (current.item.equals(key)) {
                return true;
            } else {
                if (current.next != null ) {
                    current = current.next;
                } else {
                    return false;
                }
            }
        }

        return false;
    }


    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
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

    public static void main(String[] args)
    {
        if (args.length == 0)  {
            StdOut.println("Please input param");
            return;
        }

        Ex1321<String> q = new Ex1321<>();
        for (String item: args) {
            q.enqueue(item);
        }

        q.printQueue();

        StdOut.println(q.find("key"));
    }

}
