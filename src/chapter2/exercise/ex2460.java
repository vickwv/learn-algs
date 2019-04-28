package chapter2.exercise;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * 2.4.6
 * 按照练习 2.4.1 的规则,用序列 P R I O * R * * I * T * Y * * * Q U E * * * U * E 操
 * 作一个初始为空的面向最大元素的堆,给出每次操作后堆的内容。
 */
public class ex2460 {
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>(args.length);
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("*") && !pq.isEmpty()) {
                String max = pq.delMax();
                StdOut.println("delete max:" + max + "\n");
            } else {
                pq.insert(args[i]);
                StdOut.println("insert one:" + args[i] + "\n");
            }
        }
    }
}
