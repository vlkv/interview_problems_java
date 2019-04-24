package ru.vitvlkv.collections;

// https://leetcode.com/problems/move-zeroes
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int iEnd = nums.length;
        while (iEnd >= 0) {
            int i = iEnd - 1;
            while (i >= 0 && nums[i] != 0) {
                --i;
            }
            if (i < 0) {
                break;
            }

            for (int j = i + 1; j < iEnd; ++j) {
                nums[j - 1] = nums[j];
            }
            --iEnd;
            nums[iEnd] = 0;
        }
    }
}
