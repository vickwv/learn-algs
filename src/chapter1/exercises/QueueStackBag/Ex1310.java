package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个过滤器 InfixToPostfix 将算术表达式由中序转为后序表达式
 */
public class Ex1310 {
    /**
     * 中序转后序列或前序列
     * @param s string
     * @param isPre bool
     * @return string
     */
    public String InfixToPrefixOrPostfix(String[] s, Boolean isPre)
    {
        Stack<String> symbol = new Stack<>(); // 符号栈
        Stack<String> operand = new Stack<>(); // 数字栈
        if (s.length > 0) {
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("+") || s[i].equals("-") || s[i].equals("*") || s[i].equals("/")) {
                    symbol.push(s[i]);
                } else if (s[i].equals(")")) {
                    String tempSymbol = symbol.pop(); // 符号位
                    String operandRight = operand.pop(); // 右操作数
                    String operandLeft = operand.pop(); // 左操作数
                    String operandFinal = "";
                    // 这里拼接最终决定是前序还是后序,符号位前后决定
                    if (isPre) {
                        operandFinal =  tempSymbol + operandLeft + operandRight;
                    } else {
                        operandFinal =  tempSymbol + operandLeft + operandRight;
                    }

                    operand.push(operandFinal);
                } else if (s[i].equals("(")){
                    continue;
                } else {
                    operand.push(s[i]);
                }
            }
        }

        return operand.pop();
    }

    public static void main(String[] args)
    {
        Ex1310 oj = new Ex1310();
        String str = oj.InfixToPrefixOrPostfix(args, true);
        StdOut.println(str);
    }
}
