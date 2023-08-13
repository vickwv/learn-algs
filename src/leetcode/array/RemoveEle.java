package leetcode.array;

public class RemoveEle {
    public int solution1(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveEle t = new RemoveEle();
        t.solution1(new int[]{0,1,0,3,12}, 0);
    }
}
