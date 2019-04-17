package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.24 编写一个方法 removeAfter(), 接受一个链表结点作为参数并删除该结点的后续结点
 * （如果参数结点或参数结点的后续结点为空则什么都不做）
 */
public class Ex1324<Item> implements Iterable<Item>
{
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

    public boolean removeAfter(Node<Item> node)
    {
        if (node == null || node.next == null) {
            return true;
        }

        while (node.next != null) {
            if (node.next.next != null) {
                node.next = node.next.next;
            } else {
                node.next = null;
            }
        }

        return true;
    }


    public static void main(String[] args)
    {
        if (args.length == 0)  {
            StdOut.println("Please input param");
            return;
        }

        Ex1324<String> q = new Ex1324<>();
        for (String item: args) {
            q.enqueue(item);
        }

        q.printQueue();

        StdOut.println(q.removeAfter(q.first));
        q.printQueue();
    }
}
