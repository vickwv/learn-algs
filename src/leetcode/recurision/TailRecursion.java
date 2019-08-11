package leetcode.recurision;

/**
 * 尾递归优化
 * 缘由：由于递归调用在系统调用栈上产生了隐式额外空间，尾递归可以解决额外空间的问题。
 */
public class TailRecursion
{
    public static int helper_tail_recursion(int start, int []ls, int acc)
    {
        if (start >= ls.length) {
            return acc;
        }
        return helper_tail_recursion(start+1, ls, acc+ls[start]);
    }

    public static int sum_tail_recursion(int []ls)
    {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_tail_recursion(0, ls, 0);
    }

    public static int helper_non_tail_recursion(int start, int [] ls)
    {
        if (start >= ls.length) {
            return 0;
        }
        return ls[start] + helper_non_tail_recursion(start+1, ls);
    }

    public static int sum_non_tail_recursion(int []ls)
    {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_non_tail_recursion(0, ls);
    }
}
