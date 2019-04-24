package ru.vitvlkv.collections;

public class MedianOfThreeNumbers {
    public static int median(int a, int b, int c) {
        if (a < b) {
            if (b < c) {
                return b; // a, b, c
            } else if (a > c) {
                return a; // c, a, b
            }
        } else {
            if (a < c) {
                return a; // b, a, c
            } else if (b > c) {
                return b;  // c, b, a
            }
        }
        return c; // a, c, b OR b, c, a
    }
}
