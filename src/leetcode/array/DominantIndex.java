package leetcode.array;

/**
 *  至少是其他数字两倍的最大数
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * 来源： https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/771/
 */
public class DominantIndex {
    /**
     * 算法：
     * 1. 遍历拿到数组中最大的数字
     * 2. 再遍历数组判断是否为其他数组的两倍
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < 2*nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] test = {3, 6, 1, 0};
        DominantIndex dominantIndex = new DominantIndex();
        System.out.println(dominantIndex.dominantIndex(test));
    }
}
