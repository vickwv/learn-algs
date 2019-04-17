package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.27 编写一个方法 max(),接受一条链表的首节点作为参数，返回链表中最大的结点的值。假设所有的键都是正整数，如果链表为空返回0
 * 1.3.28 用递归的方法解决1.3.27
 *
 * 答：假设第一个元素为最大的，设它为A，接下来A与剩下的元素依次做比较，哪个比A大就把A的值改变
 */
public class Ex1327<Item> implements Iterable<Item> {
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

    public Integer Max()
    {
        if (!(first.item instanceof Integer)) {
            StdOut.println("类型异常");
            return 0;
        }
        Node<Integer> max = (Node<Integer>)first;
        Node<Integer> pointer = (Node<Integer>)first;

        while (pointer.item != null && pointer.next != null) {
            if (max.item.compareTo(pointer.next.item) <= 0) {
                max = pointer.next;
            }
            pointer = pointer.next;
        }

        return max.item;
    }

    // 递归求最大值
    public Integer RecursiveMax(Node<Integer> current)
    {
        if (current.item != null && current.next == null) {
            return current.item;
        }

        if (current.item.compareTo(current.next.item) > 0) {
            current.next = current.next.next;
            return RecursiveMax(current);
        } else {
            return RecursiveMax(current.next);
        }
    }

    public static void main(String[] args)
    {
        if (args.length == 0)  {
            StdOut.println("Please input param");
            return;
        }

        Ex1327<Integer> q = new Ex1327<>();
        for (String item: args) {
            q.enqueue(Integer.parseInt(item));
        }

        //q.printQueue();
        StdOut.println(q.RecursiveMax(q.first));
    }
}
