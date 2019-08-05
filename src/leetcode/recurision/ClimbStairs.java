package leetcode.recurision;

import java.util.HashMap;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数
 *
 *
 */
public class ClimbStairs {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int climbStairs(int n)
    {
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        int result;
        if (n <= 2) {
            result = n;
        } else {
            result = climbStairs(n-1) + climbStairs(n-2);
        }

        hashMap.put(n, result);
        return result;
    }

    /**
     * 暴力破解法
     * @param i int 当前阶梯
     * @param n int 目标阶梯
     * @return
     */
    public int climbStairs(int i, int n)
    {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climbStairs(i+1, n) + climbStairs(i+2, n);
    }

    /**
     * 动态规划法
     * 这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * 第i阶可以用以下两种方法得出
     *   1. 在(i-1)阶后向上爬一阶
     *   2. 在(i-2)阶后向上爬两阶
     * 所以到达第 i 阶的方法总数就是到第 (i−1) 阶和第 (i−2) 阶的方法数之和。
     *
     * 令 dp[i] 表示能到达第 i 阶的方法总数：
     *
     * dp[i]=dp[i−1]+dp[i−2]
     *
     * 补充：
     * 动态规划只能应用于有最优子结构的问题。
     * 最优子结构的意思是局部最优解能决定全局最优解（对有些问题这个要求并不能完全满足，故有时需要引入一定的近似）。简单地说，问题能够分解成子问题来解决。
     *
     * 适用情况:
     * 1.最优子结构性质。如果问题的最优解所包含的子问题的解也是最优的，我们就称该问题具有最优子结构性质（即满足最优化原理）。最优子结构性质为动态规划算法解决问题提供了重要线索。
     * 2.无后效性。即子问题的解一旦确定，就不再改变，不受在这之后、包含它的更大的问题的求解决策影响。
     * 3.子问题重叠性质。子问题重叠性质是指在用递归算法自顶向下对问题进行求解时，每次产生的子问题并不总是新问题，有些子问题会被重复计算多次。
     * 动态规划算法正是利用了这种子问题的重叠性质，对每一个子问题只计算一次，然后将其计算结果保存在一个表格中，当再次需要计算已经计算过的子问题时，只是在表格中简单地查看一下结果，从而获得较高的效率
     * @param n
     * @return
     */
    public int climbStairsWithDp(int n)
    {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i+2];
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(4));
    }
}
