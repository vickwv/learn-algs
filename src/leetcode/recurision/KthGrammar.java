package leetcode.recurision;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：第K个语法符号
 *  在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *       给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * @url https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 */
public class KthGrammar {
    protected List<List<Integer>> db  = new ArrayList<>();

    protected List<Integer> generate(int N)
    {
        if (N == 1) {
            List<Integer> defaultRow = new ArrayList<>();
            defaultRow.add(0);
            db.add(0, defaultRow);
            return defaultRow;
        } else {
            List<Integer> lastRow = generate(N-1);
            int size = lastRow.size();
            List<Integer> tmp = new ArrayList<>(lastRow);
            for (int i = 0; i < size; i++) {
                Integer value = lastRow.get(i);
                int index = i+size;
                if (value == 1) {
                    tmp.add(index, 0);
                } else {
                    tmp.add(index, 1);
                }
            }
            db.add(N-1, tmp);
            return tmp;
        }
    }

    public int kthGrammar(int N, int K)
    {
        this.generate(N);
        return this.db.get(N-1).get(K-1);
    }

    public static void main(String[] args)
    {
        KthGrammar test = new KthGrammar();
        System.out.println(test.kthGrammar(10, 10));
    }
}
