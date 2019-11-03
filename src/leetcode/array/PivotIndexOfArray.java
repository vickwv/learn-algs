package leetcode.array;

import edu.princeton.cs.algs4.StdOut;

/**
 * 寻找数组的中心索引
 * 来源： https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 * 方法：前缀和
 * 算法：
 *
 * Total 是数组的和，当索引 i 是中心索引时，位于 i 左边数组元素的和 leftsum 满足 S - nums[i] - leftsum。
 * 我们只需要判断当前索引 i 是否满足 leftsum==Total-nums[i]-leftsum 并动态计算 leftsum 的值
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
            if (leftSum == total - leftSum - nums[j]) {
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
