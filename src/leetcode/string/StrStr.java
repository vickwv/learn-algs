package leetcode.string;

import edu.princeton.cs.algs4.StdOut;

/**
 * url: https://leetcode-cn.com/problems/implement-strstr/
 * Implement StrStr
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class StrStr {
    /**
     * Cycle of violence
     * @param haystack String
     * @param needle String
     * @return int
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            if (haystack.substring(i, i+n).compareTo(needle) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr test = new StrStr();
        StdOut.println(test.strStr("aaaaa", "bba"));
    }
}
