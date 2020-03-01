package leetcode.stack;

import java.util.LinkedList;

class MyStack {
    LinkedList queue = new LinkedList();
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        // 当queue.size == 1时 不需要反转队列
        for (int i = 1; i < queue.size(); i++) {
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
}