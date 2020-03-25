package leetcode.queue;

/**
 * 循环双端队列
 */
class MyCircularDeque {
    private int size;
    private int len;
    private Node head;
    private Node tail;

    private class Node {
        Integer val;
        Node next;
        Node prev;
    }


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        size = k;
        len = 0;
        tail = new Node();
        head = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        Node node = new Node();
        node.val = value;
        node.prev = head;
        node.next = head.next;
        node.prev.next = node;
        node.next.prev = node;
        len++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        Node node = new Node();
        node.val = value;
        node.next = tail;
        node.prev = tail.prev;
        node.next.prev = node;
        node.prev.next = node;
        len++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.isEmpty()) return false;
        head.next = head.next.next;
        head.next.prev = head;
        len--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.isEmpty()) return false;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        len--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.prev.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.len == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return this.size == this.len;
    }
}