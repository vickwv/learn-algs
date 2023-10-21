package leetcode.array;

/**
 * 209. 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class MinSubArrayLen {

    /**
     * 滑动窗口解决
     * @param target
     * @param nums
     * @return
     */
    public int solution(int target, int[] nums) {
        // 什么时候扩大窗口 total < target
        // 什么时候缩小窗口 total >= target
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;// 结果长度
        int total = 0;
        while (right < nums.length) {
            total += nums[right];
            while (total >= target) {
                res = Math.min(res, right - left + 1); // 要求长度而不是下标所以加1
                total -= nums[left];
                left++;
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
