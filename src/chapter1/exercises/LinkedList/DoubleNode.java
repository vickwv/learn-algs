package chapter1.exercises.LinkedList;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 1.3.31 实现一个嵌套类 DoubleNode 用来构造双向链表、其中每个结点都含有一个指向前驱元素的引用
 * 和一项指向后续元素的引用（如不存在则为Null)
 * @param <Item>
 */
public class DoubleNode<Item> implements Iterable<Item> {
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> prev;
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
        return null;
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

    /**
     * 表头插入
     * @param item
     */
    public void insertHeader(Item item) {
       if (isEmpty()) {
           Node<Item> temp = new Node<>();
           temp.item = item;
           first = temp;
           last = first;
       } else {
           Node<Item> insert = new Node<>();
           insert.item = item;
           insert.next = first;
           first.prev = insert;
           first = insert;
       }
       n++;
    }

    // 表尾插入
    public void insertFooter(Item item) {
        if (isEmpty()) {
            Node<Item> temp = new Node<>();
            temp.item = item;
            first = temp;
            last = first;
        } else {
            Node<Item> insert = new Node<>();
            insert.item = item;
            insert.prev = last;
            last.next = insert;
        }
        n++;
    }

    // 表头删除
    public void deleteHeader() {
      if (!isEmpty()) {
          first = first.next;
          first.prev = null;
      }
    }

    // 表尾删除
    public void deleteFooter() {
        if (!isEmpty()) {
            last = last.prev;
            last.next = null;
        }
    }


    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public Node<Item> findByNum(int num) {
        if (num == 1) {
            return first;
        }

        Node<Item> res = new Node<>();

        for (int i = 1; i <= num -1; i++) {
            res = first.next;
        }

        return res;
    }

    public Node<Item> randomNode(){
        int num = getRandomNumberInRange(1, size());
        StdOut.println("num:"+num);
        return findByNum(num);
    }

    public void insertByNodePrev(Item item) {
        Node<Item> r = randomNode();

        if (r != null) {
            Node<Item> insert = new Node<>();
            insert.item = item;

            if (r.equals(first)) {
                insert.next = first;
                first.prev = insert;
                first = insert;
            } else {
                Node<Item> p = r.prev;
                p.next = insert;
                insert.prev = p;
                insert.next = r;
            }
        }
    }

    public void insertByNodeNext(Item item) {
        Node<Item> r = randomNode();

        if (r != null) {
            Node<Item> n = r.next;
            Node<Item> itemNode = new Node<>();
            itemNode.next = n;
            itemNode.item = item;
            itemNode.prev = r;
            r.next = itemNode;
        }
    }

    public void delete(int num) {
        if (size() >= num) {
            Node<Item> itemNode = findByNum(num);
            if (itemNode != null) {
                if (num == 1) {
                    first = itemNode.next;
                } else {
                    itemNode.prev.next = itemNode.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        DoubleNode<String> doubleNode = new DoubleNode<>();
        doubleNode.insertHeader("test");
        doubleNode.insertHeader("test2");
        doubleNode.insertByNodePrev("test3");
        doubleNode.delete(1);
        doubleNode.print();
        return;
    }
}
