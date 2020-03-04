package leetcode.array;

import java.util.Arrays;


/**
 *  合并两个排序后的数组
 *  Solution1: 直接插入数组，然后再排序
 *  Solution2: 利用两个数组已经排序的条件，双指针(头部)遍历两个数组，谁小谁就先插入新的数组
 *  Solution3: 双指针(尾部)遍历两个数组，谁大谁就先插入A
 */
public class SortMergeLcci {
    public void Solution1(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < A.length - m; i++) {
            A[i+m] = B[i];
        }
        Arrays.sort(A);
    }

    public void Solution2(int[] A, int m, int[] B, int n) {
        int pointA = 0, pointB = 0;
        int[] sorted = new int[m+n];
        int curr;
         while (pointA < m || pointB < n) {
             if (pointA == m) { // 数组A只遍历到m个，m后直接添加B数组
                 curr = B[pointB];
                 pointB++;
             } else if (pointB == n) { // 数组B只遍历到n个，n后直接添加A数组
                 curr = A[pointA];
                 pointA++;
             } else if (A[pointA] < B[pointB]) {
                 curr = A[pointA];
                 pointA++;
             } else {
                 curr = B[pointB];
                 pointB++;
             }
             sorted[pointA+pointB-1] = curr;
         }

        for (int i = 0; i < A.length; i++) {
            A[i] = sorted[i];
        }
    }

    public void Solution3(int[] A, int m, int[] B, int n) {
        int curr;
        int pa = m-1, pb = n-1;
        int tail = m+n-1;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                curr = B[pb--];
            } else if (pb == -1) {
                curr = A[pa--];
            } else if (A[pa] > B[pb]) {
                curr = A[pa--];
            } else {
                curr = B[pb--];
            }
            A[tail--] = curr;
        }
    }

    public static void main(String[] args) {
        SortMergeLcci sortMergeLcci = new SortMergeLcci();
        sortMergeLcci.Solution2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
