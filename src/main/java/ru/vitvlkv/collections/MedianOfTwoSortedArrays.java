package ru.vitvlkv.collections;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

    public static double solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (m < n) {
            return solveALessOrEqualB(B, A);
        }
        return solveALessOrEqualB(A, B);
    }

    private static double solveALessOrEqualB(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        if (n == 0 && m == 0) {
            return Double.NaN;
        }
        if (n == 0) {
            int jMid = m / 2;
            if (m % 2 == 0) {
                return (B[jMid] + B[jMid - 1]) * 0.5;
            }
            return B[jMid];
        }

        int i, j;

        // Whole A elements are in the left half
        i = n - 1;
        j = (m - n) / 2;
        if (A[i] <= B[j]) {
            int maxOfLeft = j == 0 || A[i] > B[j - 1] ? A[i] : B[j - 1];
            int minOfRight = B[j];
            if (n + j > m - j) {
                return maxOfLeft;
            } else if (n + j < m - j) {
                return minOfRight;
            } else {
                return (maxOfLeft + minOfRight) * 0.5;
            }
        }

        // Whole A elements are in the right half
        i = 0;
        j = (n + m) / 2;
        if (B[j-1] <= A[i]) {
            int maxOfLeft = B[j - 1];
            int minOfRight = j >= m ? A[i] : A[i] < B[j] ? A[i] : B[j];
            if (j > n + m - j) {
                return maxOfLeft;
            } else if (j < n + m - j) {
                return minOfRight;
            } else {
                return (maxOfLeft + minOfRight) * 0.5;
            }
        }

        int iMin = 0;
        int iMax = n; // exclusive
        int jMin = 0;
        int jMax = m; // exclusive
        while (true) {
            j = (jMin + jMax) / 2;
            i = calcMatchedIndex(j, n, m);
            if (i >= 0 && i < n) {
                if (B[j - 1] > A[i]) {
                    // move j to the left
                    jMax = j + 1;
                } else if (A[i - 1] > B[j]) {
                    // move j to the right
                    jMin = j;
                } else {
                    return calcResult(A, B, i, j);
                }
            }

            i = (iMin + iMax) / 2;
            j = calcMatchedIndex(i, n, m);
            if (j >= 0 && j < m) {
                if (B[j - 1] > A[i]) {
                    // move i to the right
                    iMin = i;
                } else if (A[i - 1] > B[j]) {
                    // move i to the left
                    iMax = i + 1;
                } else {
                    return calcResult(A, B, i, j);
                }
            }
        }
    }

    private static int calcMatchedIndex(int i, int n, int m) {
        return (n + m - 2 * i) / 2;
    }

    private static double calcResult(int[] A, int[] B, int i, int j) {
        int n = A.length;
        int m = B.length;
        int maxOfLeft = A[i-1] > B[j-1] ? A[i-1] : B[j-1];
        int minOfRight = A[i] < B[j] ? A[i] : B[j];

        if (i + j > n - i + m - j) {
            return maxOfLeft;
        } else if (i + j < n - i + m - j) {
            return minOfRight;
        } else {
            return (maxOfLeft + minOfRight) * 0.5;
        }
    }
}
