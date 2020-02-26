package leetcode.array;

/**
 * q: https://leetcode-cn.com/problems/container-with-most-water/submissions/
 * solution1: 枚举：left bar x, right bar x, (x-y)*height_diff O(N^2) (嵌套循环)
 * solution2: 左右边界i,j，同时向中间收敛 (左右夹逼)
 */
public class MaxArea {
    public int solution1(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int solution2(int[] height) {
        int max = 0;
        for (int left = 0, right = height.length-1; left < right;) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--]; //谁更小谁就挪动，如果里面有个更高的棒子，可能面积更大。
            max = Math.max(max, (right-left+1)*minHeight);
        }
        return max;
    }
}
