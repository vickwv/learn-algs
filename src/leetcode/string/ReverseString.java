package leetcode.string;

public class ReverseString {

    public void Solution(String s) {
        char[] sArr = s.toCharArray();
        int len = sArr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            char temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            left++;
            right--;
        }
    }
}
