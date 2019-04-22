package chapter2.exercise;

import edu.princeton.cs.algs4.StdOut;

// 有序链表实现优先队列
public class OrderNodePQ<Item extends Comparable<Item>> {
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

        if (this.isEmpty()) {
            first = last = temp;
            N++;
        } else {
            Node current = first;
            while (current.item != null) {
                if (less(current.item, temp.item)) {
                    if (current.prev == null) {
                        current.prev = temp;
                        temp.next = current;
                        first = temp;
                        N++;
                        break;
                    } else if (current.next == null) {
                        current.next = temp;
                        temp.prev = current;
                        last = temp;
                        N++;
                        break;
                    } else {
                        current.prev.next = temp;
                        temp.prev = current.prev;
                        temp.next = current;
                        current.prev = temp;
                        N++;
                        break;
                    }
                } else if (current.item.equals(temp.item)) {
                    if (current.next != null) {
                        current.next.prev = temp;
                        temp.next = current.next;
                        temp.prev = current;
                        current.next = temp;
                    } else {
                        current.next = temp;
                        temp.prev = current;
                        last = temp;
                    }
                    N++;
                    break;
                } else {
                    if (current.next != null) {
                        current = current.next;
                    } else {
                        current.next = temp;
                        temp.prev = current;
                        last = temp;
                        N++;
                        break;
                    }
                }
            }
        }
    }

    public Item delMax() {
        if (this.isEmpty()) {
            return null;
        }

        Item max = first.item;
        if (first.next == null) {
            first = null;
        } else {
            first = first.next;
            first.prev = null;
        }

        N--;
        return max;
    }

    public static void main(String[] args) {
        OrderNodePQ<String> pq = new OrderNodePQ<>();
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
