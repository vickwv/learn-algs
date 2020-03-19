package leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 */
public class IsValid {
    /**
     * 利用栈解决
     * 1. 遍历整个字符串，遇到左括号等就把对应的右括号压栈
     * 2. 遇到右括号就判断栈是否为空，或者出栈，判断栈值与遍历字符是否一致
     * 2. 如果栈为空，或者不一致，说明字符串无效
     * @param s
     * @return
     */
    public boolean Solution1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == '(') {
                stack.push(')');
            } else if (str == '[') {
                stack.push(']');
            } else if (str == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != str) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
