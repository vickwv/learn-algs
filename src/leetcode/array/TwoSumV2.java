package leetcode.array;

/**
 * 两数之和2-输入有序数组：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumV2 {

    /**
     * 双指针法
     * @param numbers
     * @param target
     * @return
     */
    public int[] solution(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * 二分搜索法
     * @param numbers
     * @param target
     * @return
     */
    public int[] solution2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, i + 1, numbers.length-1, complement);
            if (index != -1) {
                return new int[]{i+1, index+1};
            }
        }

        return new int[]{-1, -1};
    }

    private int binarySearch(int[] numbers, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
