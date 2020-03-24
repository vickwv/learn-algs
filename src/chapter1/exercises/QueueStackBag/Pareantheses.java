package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.Stack;

/**
 * 1.3.4 编写一个Stack 的用例，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整。
 * 例如对于[()]{[()()]()} 应该打印 true, 对于 [(])应该打印 false
 */
public class Pareantheses {
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();

        Boolean isMatch = false;

        String s = args[0];
        int N = s.length();

        for (int i = 0; i < N; i++) {
            String str = s.substring(i, i+1);
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stack.push(str);
            }

            if (str.equals(")") || str.equals("}") || str.equals("]")) {
                if (stack.isEmpty()) {
                    isMatch = false;
                    break;
                }
                String p = stack.pop();
                switch (p) {
                    case "(":
                        if (str.equals(")")) {
                            isMatch = true;
                        } else {
                            isMatch = false;
                        }
                        break;
                    case "{":
                        if (str.equals("}")) {
                            isMatch = true;
                        } else {
                            isMatch = false;
                        }
                        break;
                    case "[":
                        if (str.equals("]")) {
                            isMatch = true;
                        } else {
                            isMatch = false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.print(isMatch);
    }

}
