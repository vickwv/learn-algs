package leetcode.stack;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {
    protected Stack<Integer> origin;
    protected Stack<Integer> minStack;
    public MinStack() {
        origin = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        origin.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek()); // 最小栈只要存最小值就可以
        }
    }

    public void pop() {
        if (!origin.isEmpty()) {
            origin.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(!origin.isEmpty()){
            return origin.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.getMin();
    }
}
