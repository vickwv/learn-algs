package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  对角线遍历
 *  给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * @url https://leetcode-cn.com/problems/diagonal-traverse/
 */
public class FindDiagonalOrder {
    /**
     * 对角线迭代反转法
     * 1. 遍历每个对角线
     * 2. 在将元素添加到最终结果数组之前，我们只需要将奇数对角线反转即可。
     * 例如，从左边开始的第三个对角线是[3,7,11] ，在将这些元素添加到最终的结果数组之前，我们只需将它们颠倒过来，即[11,7,3]。
     * @param matrix int[][]
     * @return
     */
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
            int x = d < M ? 0 : d - M + 1; // 计算x轴的规律
            int y = d < M ? d : M - 1; // 计算y轴的规律
            while (x < N && y > -1) { //将单个对角线放进临时链表
                temp.add(matrix[x][y]);
                x++;
                y--;
            }

            // d 为奇数需要反转，[3,7,11] => [11,7,3]
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
