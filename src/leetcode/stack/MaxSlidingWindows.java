package leetcode.stack;

import java.util.ArrayDeque;

/**
 * 最大滑动窗口
 */
public class MaxSlidingWindows {
    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public int[] Solution1(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        int num = nums.length;
        int[] result = new int[num-k+1];
        for (int i = 0; i < num-k+1; i++) {
            for (int j = i; j < i+k; j++) {
                maxValue = Math.max(maxValue, nums[j]);
            }
            result[i] = maxValue;
        }
        return result;
    }

    /**
     * 双端队列法
     * 维持一个由大到小排列的双端队列，队列的大小为k。
     * 过滤1：移除窗口大小意外的值
     * 过滤2：队尾的值小于nums[i]，则移除
     *
     * 遍历整个数组
     * 先将前k个值算出最大值，并写入队列
     * 只要i >= k-1 就将最大值写入result
     * 遍历过程中，执行过滤1，过滤2
     * 过滤完成后的值就是最大值。
     * @param nums
     * @param k
     * @return
     */
    public int[] Solution2(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length, rc =  0;
        int[] result = new int[n-k+1];
        //维持一个由大到小的双端队列，队列的大小为k
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 移除窗口以外的数字
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // 队尾的值小于nums[i]，则移除
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            //添加到队尾
            q.offer(i);
            // i >= 2意味着至少遍历了前k个数，并获取了最大值。
            if (i >= k - 1) {
                result[rc++] = nums[q.peek()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MaxSlidingWindows test = new MaxSlidingWindows();
        int[] testArray = new int[]{1,3,-1,-3,5,3,6,7};
        test.Solution2(testArray, 3);
    }
}
