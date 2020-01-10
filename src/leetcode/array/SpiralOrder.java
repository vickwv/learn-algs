package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @url https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralOrder {

    /**
     * 假设数组有 R 行C 列，seen[r][c] 表示第 r 行第 c 列的单元格之前已经被访问过了。
     * 当前所在位置为 (r, c)，前进方向是di。我们希望访问所有 R x C 个单元格。
     * 当我们遍历整个矩阵，下一步候选移动位置是 (cr, cc)。
     * 如果这个候选位置在矩阵范围内并且没有被访问过，那么它将会变成下一步移动的位置；
     * 否则，我们将前进方向顺时针旋转之后再计算下一步的移动位置
     *
     * @param matrix int[][]
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        // 假设矩阵在一个x-y坐标轴上
        int R = matrix.length; //行
        int C = matrix[0].length; //列
        int[] dr = {0, 1, 0, -1}; // 右(0,1) 下(1,0) 左(0,-1) 上(-1,0) 顺序访问
        int[] dc = {1, 0, -1, 0};
        boolean[][] seen = new boolean[R][C];
        int c = 0, r = 0, di = 0; // c, r是当前位置，di是前进方向
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < R*C; i++) {
            res.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            // 只要在边界内，不转向，直接按方向前进
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                c = cc;
                r = cr;
            } else {
                // 遇到边界转向
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        SpiralOrder test = new SpiralOrder();
        List<Integer> res = test.spiralOrder(matrix);
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
