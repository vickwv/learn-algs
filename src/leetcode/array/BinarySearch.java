package leetcode.array;

/**
 * 二分搜索
 * https://leetcode.cn/problems/binary-search/
 */
public class BinarySearch {

    public int solution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
