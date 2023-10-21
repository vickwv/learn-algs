package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角：https://leetcode.cn/problems/pascals-triangle/
 */
public class Triangle {

    public List<List<Integer>> solution(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = result.get(row - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < row; j++) {
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currRow.add(1);
            result.add(currRow);
        }

        return result;
    }
}
