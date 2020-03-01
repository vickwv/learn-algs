package leetcode.array;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * Q: https://leetcode-cn.com/problems/3sum/
 * A1: 暴力求解，三层循环
 * A2: Hash表来记录 a, b, a+b=-c todo::未完待续
 * A3: 左右夹逼法
 */
public class ThreeSum {
    public List<List<Integer>> Solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length-2; k++) {
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            for (int i = k+1; i < nums.length-1; i++) {
                if ( i > k + 1 && nums[i] == nums[i - 1] ) continue;
                for (int j = i+1; j < nums.length; j++) {
                    if ( j > i + 1 && nums[j] == nums[j- 1] ) continue;
                    if ((nums[k] + nums[i] + nums[j]) == 0) {
                        result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    }
                }
            }
        }
        return result;
    }


    /**
     * 左右指针法
     * 前提：要先排序
     * 如何去重：前后两个值相同就跳过
     * @param nums
     * @return
     */
    public List<List<Integer>> Solution3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length-2; k++) {
            if (nums[k] > 0) continue;
            if (k > 0 && nums[k] == nums[k-1]) continue;
            int sum, i = k+1, j = nums.length-1;
            while (i < j) {
                sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i] , nums[j])));
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        StdOut.println(threeSum.Solution3(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
