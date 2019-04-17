package chapter1.exercises.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  给出一段代码，删除链表的尾节点，其中链表的首节点为first
 */
public class Ex1319<Item> implements Iterable<Item>
{
    private int N;
    private Node<Item> first;
    private Node<Item> last;

    // helper linked list class
    private static class Node<Item> {
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
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
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

    /**
     * 删除尾节点
     * 如果节点只有一个，直接删除first
     * 否则遍历整个节点，找到倒数第二个，再删除。
     */
    public void removeLastNode()
    {
        if (first.next == null) {
            first = null;
        } else {
            Node<Item> current = first;
            Node<Item> secondLast = first;

            while (current.next != null) {
                secondLast = current;
                current = current.next;
            }

            secondLast.next.next = null;
            secondLast.next = null;
        }
    }
}
