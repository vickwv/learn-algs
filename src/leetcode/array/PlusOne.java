package leetcode.array;

/**
 * Leetcode 习题 加一
 * 链接： https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/772/
 * 题目：
 *      给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *      最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *      你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {
    /**
     * 这道题主要要点尾数加一厚是判断是否进位，有以下三种情况
     * a. 无进位。例如 123+1 = 114
     * b. 有进位无扩展。例如 129 + 1= 130
     * c. 有进位有扩展。 例如 999 + 1 = 1000
     *
     * @param digits int[]
     * @return int[]
     */
    public int[] plusOne(int[] digits) {
        if (digits.length <= 0) {
            return digits;
        } else {
            int len = digits.length;
            for (int i = len - 1; i >= 0 ; i--) {
                digits[i]++;
                digits[i] %=10; // 取余数判断是否进位
                if (digits[i] != 0) { // 无进位直接返回；否则继续循环加1进位
                    return digits;
                }
            }
            // 处理情况 c
            digits = new int[len+1];
            digits[0] = 1;
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(plusOne.plusOne(new int[]{4,9,9}));
    }
}
