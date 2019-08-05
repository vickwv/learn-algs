package leetcode.recurision;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * 给定 N，计算 F(N)。
 *
 */
public class Fib {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int fib(int N)
    {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if (N <= 1) {
            result = N;
        } else {
            result = fib(N-1) + fib(N-2);
        }
        cache.put(N, result);
        return result;
    }

    public static void main(String[] args)
    {
        Fib f = new Fib();
        StdOut.println(f.fib(10));
    }
}
