package leetcode.stack;

import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

class MyStack {
    LinkedList queue = new LinkedList();
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        // 当queue.size == 1时 不需要反转队列
        int size = queue.size();
        // 假设有5个元素，将头部前4个移动到尾部
        for (int i = 0; i < size-1; i++) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (int) queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return (int) queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        StdOut.println(stack.pop());
    }
}