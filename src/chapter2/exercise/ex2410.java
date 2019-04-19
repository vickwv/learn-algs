package chapter2.exercise;

import chapter2.example.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * 用序列 P R I O * R * * I * T * Y * * * Q U E * * * U * E (字母表示插入元素,星号表
 * 示删除最大元素)操作一个初始为空的优先队列。给出每次删除最大元素返回的字符。
 */
public class ex2410 {
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>(args.length);
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("*") && !pq.isEmpty()) {
                String max = pq.delMax();
                StdOut.println("delete max:"+max+"\n");
            } else {
                pq.insert(args[i]);
                StdOut.println("insert one:"+args[i]+"\n");
            }
        }
    }
}
