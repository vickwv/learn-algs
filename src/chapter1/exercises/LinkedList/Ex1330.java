package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 编写一个函数，接受一条链表的首节点作为参数，将链表翻转并返回结果链表的首节点
 * 除了递归和迭代，还可以将链表插入栈中，然后再从栈中弹出。
 */
public class Ex1330<Item> implements Iterable<Item> {
    private int n; // number of elements

    private static class Node<Item> {
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

    public Node<Item> reverse(Node<Item> x) {
        Node<Item> first = x;
        Node<Item> reverse = null;
        while (first != null) {
            Node<Item> second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node<Item> reverseRecursive(Node<Item> first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node<Item> second = first.next;
        Node<Item> rest = reverseRecursive(second);
        second.next = first;
        first.next = null;
        return rest;
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

    public static void main(String[] args)
    {
        Ex1330<Integer> queue = new Ex1330<>();
        int i = 0;
        while (true) {
            queue.enqueue(i);
            i++;
            if (i == 10) {
                break;
            }
        }
        StdOut.println(queue.reverseRecursive(queue.first).item);
    }
}
