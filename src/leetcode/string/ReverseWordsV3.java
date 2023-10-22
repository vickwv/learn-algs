package leetcode.string;

import java.util.Stack;

/**
 * 反转字符串中的单词 III
 */
public class ReverseWordsV3 {

    public String solution(String s) {
        Stack<Character> windows = new Stack<>();
        char[] sArr = s.toCharArray();
        int left = 0, right = 0, len = s.length();
        while (right < len) {
            char c = sArr[right];
            if (c == ' ') {
                while (left < right) {
                    sArr[left] = windows.pop();
                    left++;
                }
                left++;
            } else {
                windows.push(c);
            }
            right++;
        }
        while (left < right) {
            sArr[left] = windows.pop();
            left++;
        }
        return new String(sArr);
    }

    public static void main(String[] args) {
        ReverseWordsV3 reverseWordsV3 = new ReverseWordsV3();
        reverseWordsV3.solution("Let's take LeetCode contest");
    }
}
