package chapter1.exercises.Improve;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.32 Steque 一个以栈为目标的队列，是一种支持push/pop/enqueue操作的数据结构
 * @param <Item>
 */
public class Steque<Item> implements Iterable<Item> {
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first;
    private Node<Item> last;

    private int size() {
        return n;
    }

    private boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<Item>
    {
        private Node<Item> current;

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

    public void push(Item item) {
        Node<Item> push = new Node<>();
        push.item = item;

        if (isEmpty()) {
            first = push;
            last = push;
        } else {
            push.next = first;
            first = push;
        }
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        } else {
            Item pop = first.item;
            first = first.next;
            return pop;
        }
    }

    public void enqueue(Item item) {
        Node<Item> enqueue = new Node<>();
        enqueue.item = item;
        if (isEmpty()) {
            first = enqueue;
            last = enqueue;
        } else {
            last.next = enqueue;
            last = enqueue;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Steque<String> stringSteque1 = new Steque<>();
        stringSteque1.enqueue("我");
        stringSteque1.enqueue("的");
        stringSteque1.enqueue("名字");
        stringSteque1.enqueue("叫顶级程序员不穿女装");
        stringSteque1.enqueue("微博:https://m.weibo.cn/p/1005056186766482");

        stringSteque1.print();

        Steque<String> stringSteque2 = new Steque<>();
        stringSteque2.push("我");
        stringSteque2.push("的");
        stringSteque2.push("名字");
        stringSteque2.push("叫顶级程序员不穿女装");
        stringSteque2.push("微博:https://m.weibo.cn/p/1005056186766482");

        stringSteque2.print();

    }
}
