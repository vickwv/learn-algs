package chapter1.exercises.QueueStackBag;

import java.util.Stack;

public class Ex132 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String string = "test dsfs dfsdfsadf ";
        for (char item : string.toCharArray()) {
            stringStack.push(item + "");
        }

        while (!stringStack.empty()) {
            System.out.println(stringStack.pop() + "\n");
        }
    }
}