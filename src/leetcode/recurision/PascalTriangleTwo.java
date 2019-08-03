package leetcode.recurision;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角2
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 思路：
 * 关键在于获取第N行，只需要取第N-1行的值即可。
 * 因此只需要保存一行值即可。这样就减少了空间单使用
 */
public class PascalTriangleTwo {
    protected List<List<Integer>> triangle  = new ArrayList<List<Integer>>();
    /**
     * 动态规划版本
     * @param rowIndex int
     * @return
     */
    public List<Integer> generate(int rowIndex) {
        List<Integer> k = new ArrayList<>();
        k.add(1);
        if (rowIndex == 0) {
            return k;
        }
        for (int rowNum = 1; rowNum < rowIndex+1; rowNum++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // 第一行永远为1

            for (int j = 1; j < rowNum; j++) {
                row.add(k.get(j-1) + k.get(j));
            }
            row.add(1);
            k = row;
            if (rowIndex + 1 - rowNum == 1) {
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        PascalTriangleTwo pascalTriangle = new PascalTriangleTwo();
        List<Integer> list = pascalTriangle.generate(1);
        StdOut.println(list.toString());
    }
}
