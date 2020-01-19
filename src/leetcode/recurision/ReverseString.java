package leetcode.recurision;

import edu.princeton.cs.algs4.StdOut;

/**
 * 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
 */
public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }

    /**
     * 双指针法
     * @param s
     */
    public void reverseStringWithDoublePoint(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String str = "helloworld";
        char[] t = str.toCharArray();
        ReverseString test = new ReverseString();
        test.reverseStringWithDoublePoint(t);
        StdOut.println(String.valueOf(t));
    }
}
