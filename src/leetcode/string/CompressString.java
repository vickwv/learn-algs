package leetcode.string;

/**
 * 字符串压缩
 * solution1: 双指针法
 */
public class CompressString {
    public String compressString(String S) {
        int len = S.length();
        int i = 0;
        StringBuilder str = new StringBuilder();
        while (i < len) {
            int j = i;
            while (j < len && S.charAt(j) == S.charAt(i)) j++;
            str.append(S.charAt(i));
            str.append(j-i);
            i = j;
        }
        String result = str.toString();
        return result.length() >= S.length() ? S : result;
    }
}
