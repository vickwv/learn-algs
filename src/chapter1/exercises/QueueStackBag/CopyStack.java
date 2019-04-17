package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

/**
 * 1.3.12 编写一个可迭代的Stack用例，它含有一个静态的copy方法
 * @param <Item>
 */
public class CopyStack<Item> extends Stack<Item> {

    public static CopyStack<String> copy(Stack<String> stack)
    {
        Stack<String> temp = new CopyStack<>();
        Iterator iterator = stack.iterator();

        while (iterator.hasNext()) {
            temp.push(iterator.next().toString());
        }

        Iterator<String> tempIterator = temp.iterator();

        CopyStack<String> result = new CopyStack<>();
        while (tempIterator.hasNext()) {
            result.push(tempIterator.next());
        }

        return result;
    }

    public static void main(String[] args) {
        CopyStack<String> stack = new CopyStack<>();

        stack.push("bei");
        stack.push("an");
        stack.push("chi");
        stack.push("fen");
        stack.push("si");

        System.out.println("原栈输出");

        for (String string: stack) {
            System.out.println(string);
        }

        CopyStack<String> stack2 = CopyStack.copy(stack);
        System.out.println("copy print");

        for (String string: stack2) {
            System.out.println(string);
        }
    }
}