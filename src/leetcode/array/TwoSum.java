package leetcode.array;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

/**
 * solution1：暴力双层循环，O(N^2)
 * solution2: HashMap 一层HashMap
 * solution3: HashMap 两层 HashMap
 */
public class TwoSum {
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

    public int[] solution3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{map.get(complement), i};
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        StdOut.println(t.solution3(new int[]{2,7,11,15}, 9));
    }
}
