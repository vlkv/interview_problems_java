package ru.vitvlkv.math;


/*
You are given n - positive integer number, that fits in 32bit signed integer.
Find out if n = a^p, where p > 1 and a > 0, a, p - both integers, or not.
 */
public class IsPower {

    public static boolean isPower(int n) {
        for (int a = 2; a < Math.sqrt(n); ++a) {
            int n2 = a;
            while (n2 < n) {
                n2 *= a;
                if (n2 == n) {
                    return true;
                }
            }
        }
        return false;
    }

}
