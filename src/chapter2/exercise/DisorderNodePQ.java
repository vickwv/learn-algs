package chapter2.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 双向链表实现优先队列
 * @param <Item>
 */
public class DisorderNodePQ<Item extends Comparable<Item>> {
    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean less(Item i, Item j) {
        return i.compareTo(j) < 0;
    }

    public void insert(Item item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = null;

        if (this.isEmpty()) {
            first = last = temp;
        } else {
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
        N++;
    }

    public Item delMax() {
        if (this.isEmpty()) {
            return null;
        }

        Node max = first;
        Node compare = first.next;
        for (int i = 1; i < N; i++) {
            if (less(max.item, compare.item)) {
                max = compare;
            }
            if (compare.next != null) {
                compare = compare.next;
            }
        }
        Item maxValue = max.item;

        // 处理最大结点为首元素
        if (max.prev != null) {
            max.prev.next = max.next;
        } else  {
            first = max.next;
        }
        // 处理最大结点为尾结点
        if (max.next != null) {
            max.next.prev = max.prev;
        } else {
            last = max.prev;
        }
        max = null;
        N--;
        return maxValue;
    }

    public static void main(String[] args) {
        DisorderNodePQ<String> pq = new DisorderNodePQ<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("*") && !pq.isEmpty()) {
                String max = pq.delMax();
                StdOut.println("delete max:"+max+"\n");
            } else {
                pq.insert(args[i]);
                StdOut.println("insert one:"+args[i]+"\n");
            }
        }
    }
}
