package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.26 编写一个方法 remove(), 接受一条链表和一个字符串key作为参数，删除链表中所有item域为key的结点
 *
 */
public class Ex1326<Item> implements Iterable<Item> {

    private int n; // number of elements

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first;
    private Node<Item> last;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
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
            return item;
        }
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }


    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    /**
     * 打印队列
     */
    public void printQueue() {
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
     * 遍历链表，找到item = k的删除
     * 1. 头结点就等于k的，直接将头结点的下一个结点变为头结点
     * 2. 头结点不等于k的， 判断当前结点下一个结点是否等于k,是就删除，否则就把下一个结点变为当前结点
     * @param k
     */
    public void remove(Item k)
    {
        while (first != null && first.item.equals(k)) {
            first = first.next;
        }

        Node<Item> current = first;
        Node<Item> node;
        while (current != null && current.next != null) {
            node = current.next;
            if (node.item.equals(k)) {
                current.next = node.next;
            } else {
                current = node;
            }
        }
    }

    public static void main(String[] args)
    {
        if (args.length == 0)  {
            StdOut.println("Please input param");
            return;
        }

        Ex1326<String> q = new Ex1326<>();
        for (String item: args) {
            q.enqueue(item);
        }

        //q.printQueue();
        q.remove("3");
        q.printQueue();
    }
}
