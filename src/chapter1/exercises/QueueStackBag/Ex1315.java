package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.UUID;

/**
 * 编写一个Queue的用例，接受一个命令行参数K并打印出标准输入中的倒数第k个字符串
 *
 * 假设 Queue 有N>k个字符串，倒数第k个就是正数第n-k个
 * 遍历可取出
 */
public class Ex1315 extends Queue<String> {
    public String getKthString(int k)
    {
        if (this.isEmpty() || this.size() < k) {
            return "";
        }

        Iterator<String> iterator = this.iterator();

        int j = this.size() - k;

        for (int i = 0; i < j; i++) {
             if(iterator.hasNext()) {
                 if (i == j - 1) {
                     return iterator.next();
                 } else {
                     iterator.next();
                 }
             }
        }

        return "";
    }

    public static void main(String[] args)
    {
        if (args.length == 0) {
            StdOut.println("渣渣 请输入一个正数");
            return;
        }

        int k = Integer.parseInt(args[0]);

        Ex1315 queue = new Ex1315();

        for (int i = 0; i < k + 3; i++) {
            String str = UUID.randomUUID().toString();
            queue.enqueue(str);
            StdOut.println("Queue"+i+":"+str+"\n");
        }

        String result = queue.getKthString(k);
        StdOut.println("K:"+ result);

    }
}
