package leetcode.recurision;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows, 生成杨辉三角的前 numRows 行
 */
public class PascalTriangle {
    protected List<List<Integer>> triangle  = new ArrayList<List<Integer>>();
    /**
     * 动态规划版本
     * @param numRows int
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            row.add(1); // 第一行永远为1

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public List<List<Integer>> generateRecurision(int numRows) {
        if (numRows == 0) {
            return triangle;
        }

        generateRecurision(numRows - 1);
        List<Integer> list = new ArrayList<>();
        if (numRows == 1) {
            list.add(1);
        } else if (numRows == 2) {
            list.add(1);
            list.add(1);
        } else {
            for (int i = 1; i <= numRows; i++) {
                if (i == 1 || i == numRows) {
                    list.add(1);
                } else {
                    list.add(triangle.get(numRows-2).get(i-2) + triangle.get(numRows-2).get(i-1));
                }
            }
        }
        triangle.add(list);
        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> list = pascalTriangle.generateRecurision(5);
        for (int i = 0; i < list.size(); i++) {
            StdOut.println(list.get(i).toString());
        }
    }
}
