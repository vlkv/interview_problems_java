package ru.vitvlkv.collections;

// Задан массив чисел отриц, нуль, положительных. Отсортирован
// Нужно вычислить массив квадратов, результат должен быть отсортирован
public class SortedSquares {
    public static int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }
        int firstNonNegIndex = 0;
        while (firstNonNegIndex < A.length && A[firstNonNegIndex] < 0) {
            ++firstNonNegIndex;
        }
        int iUp = firstNonNegIndex;
        int iDown = firstNonNegIndex - 1;
        int[] R = new int[A.length];
        for (int i = 0; i < R.length; ++i) {
            if (iDown >= 0 && iUp < A.length) {
                if (Math.abs(A[iDown]) < A[iUp]) {
                    R[i] = A[iDown] * A[iDown];
                    --iDown;
                } else {
                    R[i] = A[iUp] * A[iUp];
                    iUp++;
                }
            } else if (iDown >= 0) {
                R[i] = A[iDown] * A[iDown];
                --iDown;
            } else {
                R[i] = A[iUp] * A[iUp];
                ++iUp;
            }
        }
        
        
        return R;
    }
}