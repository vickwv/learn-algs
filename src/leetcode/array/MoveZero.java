package leetcode.array;

/**
 * question: https://leetcode-cn.com/problems/move-zeroes/
 *
 * solution 1：loop，count zero num，zero move backward, Non-zero elements move forward
 * solution 2：new array, loop，two point prev tail, zero move backward(tail), Non-zero move forward(prev)
 * solution 3：index： One-dimensional array coordinate transformation 一维数组坐标变换
 */
public class MoveZero {
    public void solutions3(int[] nums) {
        int j = 0; // j for non-zero values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) { // if i is not equal to j, Description to move a zero value backward
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    /**
     * 先把非零元素都放到前面来，最后再补0.
     * @param nums
     */
    public void solutions4(int[] nums) {
        int i = 0; // j for non-zero values
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    public void solution1(int[] nums) {
        int count = 0; // zero element nums
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (count > 0) { // if there is a zero value, non-zero value move forward, and zero value move backward
                nums[i-count] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public void solution2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                result[j] = 0;
                j--;
            } else {
                result[i] = nums[k];
                i++;
            }
        }
        nums = result;
        for (int f = 0; f < nums.length; f++) {
            System.out.println(nums[f]);
        }
    }

    public static void main(String[] args) {
        MoveZero t = new MoveZero();
        t.solution2(new int[]{0,1,0,3,12});
    }
}
