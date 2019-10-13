package leetcode.recurision;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：第K个语法符号
 *  在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *       给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * @url https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 */
public class KthGrammar {
    protected List<Integer> db = new ArrayList<>();

    protected List<Integer> generate(int N)
    {
        if (N == 1) {
            List<Integer> defaultRow = new ArrayList<>();
            defaultRow.add(0);
            db = defaultRow;
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
            db = tmp;
            return tmp;
        }
    }

    public int kthGrammar(int N, int K)
    {
        if (N < 0 || K < 0 || K > Math.pow(2, N-1)) {
            return 0;
        }
        this.generate(N);
        return this.db.get(K-1);
    }


    /**
     * Leetcode 暴力法
     * 处理每一行，但只保存最新一行
     *
     * 1. 利用了移位运算知识点，针对无符号整数，移位左移，移动一位，相当于乘2，移动右移，移动一位，则相当于除2
     * 2.
     * @param N int
     * @param K int
     * @return int
     */
    public int kthGrammarViolence(int N, int K)
    {
        int[] lastrow = new int[1 << N];
        for (int i = 1; i < N; ++i) {
            for (int j = (1 << (i-1)) - 1; j >= 0; --j) {
                lastrow[2*j] = lastrow[j];
                lastrow[2*j+1] = 1 - lastrow[j];
            }
        }
        return lastrow[K-1];
    }

    public int kthGrammarF(int N, int K)
    {
        if (N == 1) return 0;
        if (K % 2 == 0) {
           return kthGrammarF(N-1, K/2) == 0 ? 1 : 0;
        } else {
            return kthGrammarF(N-1, (K+1)/2) == 0 ? 0 : 1;
        }
    }

    public static void main(String[] args)
    {
        KthGrammar test = new KthGrammar();
        System.out.println(7/2);
    }
}
