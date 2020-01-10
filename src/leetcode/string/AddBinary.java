package leetcode.string;

import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

/**
 * 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * url: https://leetcode-cn.com/problems/add-binary/
 */
public class AddBinary {
    /**
     * 核心思路：模拟二进制计算进位
     *
     * 知识点: 字符串0、字符串1之间的ASCII码差值为1 所以'1'-'0'= INT(1)
     *
     * 遍历两个字符串，每次循环用进位值(第一次循环进位值为0)分别与两个数字相加(较短的字符串用0补)，求得结果：
     *  1. 结果会直接 mod 2存入 stack (2 mod 2 = 0, 3 mod 2 = 1)
     *  2. carray = sum/2，如果 carray == 1,说明下次计算需要进位了。
     *
     * @param a String
     * @param b String
     * @return String
     */
    public String addBinary(String a, String b) {
        int carray = 0; //进位默认为0，每次
        Stack<Integer> res = new Stack<>();
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >=0; i--,j--) {
            int sum = carray;
            sum += i >= 0 ? a.charAt(i) - '0' : 0; //如果i/j小于0，说明字符串长度不一致，直接返回0.
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.push(sum % 2); // mod 2，
            carray = sum / 2; //判断是否进位
        }
        if (carray == 1) {
            res.push(carray);
        }
        String bin = "";
        while (!res.empty()) {
            bin += res.pop().toString();
        }
        return bin;
    }

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        StdOut.println(obj.addBinary(new String("11"), new String("1")));
    }
}
