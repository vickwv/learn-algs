package leetcode.recurision;

import edu.princeton.cs.algs4.StdOut;

/**
 * leetcode 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * @url https://oi-wiki.org/math/quick-pow/
 * @source https://leetcode-cn.com/explore/orignial/card/recursion-i/259/complexity-analysis/1227/
 */
public class Pow {

    /**
     * 递归模式
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    public double myPow2(double x, int n)
    {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    /**
     * 将二进制位为1时对应的幂累乘到答案中
     * 序列中(除了第一个)任意一个元素就是前一个元素的平方
     * @param x
     * @param n
     * @return
     */
    public double binPow(double x, int n)
    {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        double res = 1;
        while (N > 0) {
            long tmp = N & 1;
            if (tmp == 1) {
                res = res * x;
            }
            x = x * x;
            N >>= 1;
        }
        return res;
    }

    public static void main(String[] args)
    {
        Pow pow = new Pow();
        double res = pow.binPow(2, -2147483648);
        StdOut.println(res);
    }
}
