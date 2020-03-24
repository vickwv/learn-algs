package leetcode.queue;

import java.util.Queue;

/**
 * 循环双端队列
 */
public class MyCircularDeque {
    private int N; // 双端队列长度
    private Node first;
    private Node last;
    private class Node
    {
        Integer item;
        Node next;
    }


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.N = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (first == null) {
            first.item = value;
            first.next = null;
        } else {
            Node tmp = first;

        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

    }

    /** Get the front item from the deque. */
    public int getFront() {

    }

    /** Get the last item from the deque. */
    public int getRear() {

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {

    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {

    }
}
