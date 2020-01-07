package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  对角线遍历
 *  给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * @url https://leetcode-cn.com/problems/diagonal-traverse/
 */
public class FindDiagonalOrder {
    //  对角线遍历暴力简单版本
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int N = matrix.length; // N代表有多少行
        int M = matrix[0].length; // M代表有多少列
        int[] result = new int[N*M];

        ArrayList<Integer> temp = new ArrayList<Integer>();
        int index = 0;
        for (int d = 0; d < N+M+1; d++) {
            temp.clear();
            int x = d < M ? 0 : d - M + 1;
            int y = d < M ? d : M - 1;
            while (x < N && y > -1) {
                temp.add(matrix[x][y]);
                x++;
                y--;
            }

            // d 为奇数需要反转
            if (d % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int i = 0; i < temp.size(); i++) {
                result[index++] = temp.get(i);
            }
        }
        return result;
    }

}
