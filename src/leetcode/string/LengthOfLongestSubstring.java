package leetcode.string;

import java.util.HashMap;

/**
 * 3.无重复字符的最长字串： https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public int solution(String s) {
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                windows.put(d, windows.get(d) -1);
                left++;
            }
            result = Math.max(right - left, result);
        }

        return result;
    }
}
