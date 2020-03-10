package leetcode.array;

/**
 * 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    /**
     * 快慢指针法
     *
     * i 慢指针，j 快指针，碰到不同的就把值向前放
     * 1. 如果nums[i] == nums[j]，则跳过重复项
     * 2. 如果nums[i] != nums[j]，跳过重复项的运行已经结束，因此我们必须把它nums[j]的值复制到 nums[i+1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     *
     * @param nums int[]
     * @return int
     */
    public int Solution1(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();
        duplicates.Solution1(new int[]{1, 2, 2});
    }
}
