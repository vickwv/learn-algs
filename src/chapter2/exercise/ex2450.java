package chapter2.exercise;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * 练习 2.4.5 将 E A S Y Q U E S T I O N顺序插入一个面向最大元素的堆中，给出结果
 */
public class ex2450 {
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>();
        for (int i = 0; i < args.length; i++) {
            pq.insert(args[i]);
        }
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}
