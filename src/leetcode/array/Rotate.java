package leetcode.array;

/**
 * 旋转数组
 * Solution1:暴力循环法
 * Solution2: 反转所有数，再反转前k个数，再反转后i-k个数
 * Solution3: 原本数组里下标为 i 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
 */
public class Rotate {
    public void solution1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    public void solution2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int k, int i) {
        while (k < i) {
            int temp = nums[k];
            nums[k++] = nums[i];
            nums[i--] = temp;
        }
    }

    public void solution3(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate.solution1(arr, 3);
    }
}
