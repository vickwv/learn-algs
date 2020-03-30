package leetcode.map;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * Solution1：两个字符串排序，然后对比字符串是否相等
 * Solution2：
 *  1. 计算两个字符串每个字符出现次数，并进行比较。因为字母只有26个，所以只要一个26个字符的数组即可。(简单的map作为计数器)
 *  2. 利用字符的ASCII码来当作字符的key
 *  3. 一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
 *
 */
public class IsAnagram {
    public boolean Solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        Arrays.sort(tArr);
        Arrays.sort(sArr);
        return Arrays.equals(tArr, sArr);
    }

    public boolean Solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i)- 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
