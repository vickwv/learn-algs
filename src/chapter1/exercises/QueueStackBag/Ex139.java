package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.9 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式
 * 例如，给定输入：
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 *
 * 本题使用双栈法，
 * 忽略左括号，一个栈用于push 符号，一个栈用于 push 数字，遇到右括号就弹出两个数字一个符号，拼接成字符串再插入数字栈。
 * 最终数字栈仅仅只有一个值，再将该值顺序反转，即是结果
 */
public class Ex139 {
    public static void main(String[] args)
    {
        Stack<String> symbol = new Stack<>(); // 符号栈
        Stack<String> operand = new Stack<>(); // 数字栈

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("+") || args[i].equals("-") || args[i].equals("*") || args[i].equals("/")) {
                    symbol.push(args[i]);
                } else if (args[i].equals(")")) {
                    // )2+1(
                    String s = ")" + operand.pop() + symbol.pop() + operand.pop() + "(";
                    operand.push(s);
                } else {
                    operand.push(args[i]);
                }
            }
        }

        String str = operand.pop();

        String res = "";

        for (int i = str.length()-1; i >= 0; i--) {
            res += str.charAt(i);
        }

        StdOut.println(res);
    }
}
