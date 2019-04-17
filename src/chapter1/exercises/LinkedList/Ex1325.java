package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * 1.3.25 编写一个方法 insertAfter(),　接受两个链表结点作为参数，将第二个结点插入链表并使之成为第一个结点的后续结点。
 */
public class Ex1325<Item> implements Iterable<Item> {

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

    private boolean findNode(Node<Item> itemNode)
    {
        Node<Item> current = first;

        while (current != null) {
            if (current.equals(itemNode)) {
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


    public boolean insertAfter(Node<Item> one, Node<Item> two) {
        if (one != null && two != null) {
            // 找到了第一个结点，直接插到第一个结点后，否则先将第一个结点插到尾结点
            if (findNode(one)) {
                two.next = one.next;
                one.next = two;
            } else {
                last.next = one;
                one.next = two;
                last = two;
            }
            return true;
        } else {
            return false;
        }
    }

    public Node<String> getNewNode()
    {
        Node<String> stringNode = new Node<>();
        stringNode.item = UUID.randomUUID().toString();
        return stringNode;
    }

    public static void main(String[] args)
    {
        if (args.length == 0)  {
            StdOut.println("Please input param");
            return;
        }

        Ex1325<String> q = new Ex1325<>();
        for (String item: args) {
            q.enqueue(item);
        }

        //q.printQueue();
        q.insertAfter(q.first, q.getNewNode());
        q.printQueue();
    }
}
