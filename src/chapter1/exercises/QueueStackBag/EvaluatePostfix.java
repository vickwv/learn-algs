package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 *  1.3.11编写一段程序，从标准输入得到一个后序表达式
 */
public class EvaluatePostfix
{
    /**
     * 从右到左边遍历
     * 1. 如果是操作数直接压栈
     * 2. 如果是操作符，弹出两个操作数拼接。再压栈
     * 3. 重复1，2步骤即可
     * @param input
     * @return
     */
    public String PrefixToPostfix(String[] input)
    {
        if (input.length <= 0) {
            return "";
        } else {
            Stack<String> operand = new Stack<>();

            for (int i = input.length -1 ; i >= 0; i--) {
                if (input[i].equals("+") || input[i].equals("-") || input[i].equals("*") || input[i].equals("/")) {
                    String A = operand.pop();
                    String B = operand.pop();
                    operand.push(A+B+input[i]);
                } else {
                     operand.push(input[i]);
                }
            }

            return operand.peek();
        }
    }

    public static void main(String[] args)
    {
        EvaluatePostfix oj = new EvaluatePostfix();
        String str = oj.PrefixToPostfix(args);
        StdOut.println(str);
    }
}
