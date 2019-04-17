package chapter1.exercises.Algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.4.2 修改 ThreeSum 正确处理两个较大的int值相加可能溢出的情况
 */
public class ThreeSumFixOverflow
{
    public static int count(int[] a)
    {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i +1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] < Integer.MAX_VALUE-a[j] && a[i] > Integer.MIN_VALUE - a[j]) {
                        if (a[i] + a[j] + a[k] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args)
    {
        if (args.length <= 0) {
            StdOut.println("Please input params");
            System.exit(-1);
        }
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
