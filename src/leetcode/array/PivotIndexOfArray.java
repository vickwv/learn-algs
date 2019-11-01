package leetcode.array;

import edu.princeton.cs.algs4.StdOut;

/**
 * 寻找数据的中心索引
 * @url https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 */
public class PivotIndexOfArray {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j != 0) {
                leftSum += nums[j-1];
            }
            int rightSum = total - leftSum - nums[j];
            if (rightSum == leftSum) {
                return j;
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        PivotIndexOfArray test = new PivotIndexOfArray();
        int[] nums = {1, 7, 3, 6, 5, 6};
        StdOut.println(test.pivotIndex(nums));
    }
}
