package leetcode.stack;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * url: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {
    /**
     * 暴力枚举法
     * 枚举左右边界
     * 再找左右边界里面最大的面积
     * @param heights
     * @return
     */
    public int Solution1(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length-1; i++) {
            for (int j = i; i < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = j; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxarea = Math.max(maxarea, minHeight*(j-i+1));
            }
        }
        return maxarea;
    }

    /**
     * 暴力优化法
     *  for i -> 0, n-1
     *      找到左右边界比heights[i](第一次出现)小的值 即遇到比heights[i]大的棒子就往左右两边遍历，直到碰到比heights[i]小为止
     *      area = height[i] * (right-left+1)
     * @param heights
     * @return
     */
    public int Solution2(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftBounder = i;
            while(leftBounder > 0 && heights[leftBounder-1] >= heights[i]) leftBounder--;
            int rightBounder = i;
            while(rightBounder >= 0 && rightBounder+1 < heights.length && heights[rightBounder+1] >= heights[i]) rightBounder++;
            maxarea = Math.max(maxarea, heights[i] * (rightBounder-leftBounder+1));
        }
        return maxarea;
    }


    /**
     * 栈方法
     * 维护一个栈，栈中元素从小到大排列，栈底到栈顶是从小到大排列的.
     * 声明一个只有-1的栈
     * 遍历整个数组
     * 只要栈顶元素为-1或者栈顶元素小于height[i]就要入栈
     * 否则就说明height[i]是栈顶元素的右边最小边界，栈顶的上一个元素是它的左边界，因此就可以求面积
     * 遍历完整个数组后，如此栈不为空，要清空栈，继续计算最大面积
     * @param heights
     * @return
     */
    public int Solution3(int[] heights) {
        int maxarea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxarea;
    }
}
