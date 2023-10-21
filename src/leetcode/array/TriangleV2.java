package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角2：https://leetcode.cn/problems/pascals-triangle-ii/description/
 */
public class TriangleV2 {

    public List<Integer> solution(int rowIndex) {
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        if (rowIndex <= 0) {
            return firstRow;
        }

        List<Integer> result = new ArrayList<>();
        for (int row = 1; row < rowIndex+1; row++) {
            result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < row; j++) {
                result.add(firstRow.get(j-1) + firstRow.get(j));
            }
            result.add(1);
            firstRow = result;
        }

        return result;
    }
}
