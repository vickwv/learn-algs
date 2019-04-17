package chapter1.exercises.Improve;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.33 Deque。一个双向队列(或者称为 deque)和栈或队列类似,但它同时支持在两端添加或删除元素。
 * Deque 能够存储一组元素并支持表 1.3.9 中的 API:
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    private Node<Item> first;
    private Node<Item> last;

    public Deque<Item> Deque()
    {
        return new Deque<>();
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return n;
    }

    public void pushLeft(Item item)
    {
        Node<Item> push = new Node<>();
        push.item = item;
        if (isEmpty()) {
            first = push;
            last = push;
        } else {
            last.next = push;
            push.prev = last;
            last = push;
        }
        n++;
    }

    public void pushRight(Item item)
    {
        Node<Item> push = new Node<>();
        push.item = item;
        if (isEmpty()) {
            first = push;
            last = push;
        } else {
            first.prev = push;
            push.next = first;
            first = push;
        }
        n++;
    }

    public Item popLeft()
    {
        if (isEmpty()) {
            return null;
        } else {
            Item pop = last.item;
            last = last.prev;
            last.next = null;
            n--;
            return pop;
        }
    }

    public Item popRight()
    {
        if (isEmpty()) {
            return null;
        } else {
            Item pop = first.item;
            first = first.next;
            first.prev = null;
            n--;
            return pop;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    private class DequeIterator implements Iterator<Item>
    {
        private Deque.Node<Item> current;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public void print() {
        if (!isEmpty()) {
            while (first != null) {
                StdOut.println(first.item + " ");
                if (first.next != null) {
                    first = first.next;
                } else {
                    first = null;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Deque<String> stringDeque = new Deque<>();

        stringDeque.pushLeft("你");
        stringDeque.pushLeft("好");
        stringDeque.pushLeft("吗");
        stringDeque.pushRight("de");
        stringDeque.pushRight("ai");
        stringDeque.pushRight("qin");

        stringDeque.print();
    }
}
