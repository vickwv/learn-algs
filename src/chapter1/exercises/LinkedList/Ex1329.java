package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * 1.3.29 用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非空
 * 则Last.next的值为first。只能使用一个Node类型的实例变量(last)
 */
public class Ex1329<Item> implements Iterable<Item> {
    private int n;
    private Node<Item> first;
    private Node<Item> last;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.next = null;
        last.item = item;
        if (isEmpty()) {
            first = last;
            last.next = first;
        } else {
            oldLast.next = last;
            last.next = first;
        }
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            last.next = first;
        }
        n--;
        return item;
    }

    public void printQueue(){
        Node<Item> current = first;
        while (current != null) {
            StdOut.println(current.item);
            if (current.next != null) {
                if (current.next == first) {
                    break;
                }
                current = current.next;
                StdOut.println("->");
            } else {
                current = null;
            }
        }
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

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
            if (current == first) {
                throw new NoSuchElementException();
            }
            return item;
        }
    }

    public static void main(String[] args)
    {
        Ex1329<String> queue = new Ex1329<>();
        int i = 0;
        while (true) {
            queue.enqueue(UUID.randomUUID().toString());
            i++;
            if (i == 10) {
                break;
            }
        }

        queue.printQueue();
    }
}
