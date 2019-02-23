package ru.vitvlkv.math;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class GoldbachsConjecture2 {

    public static ArrayList<Integer> primesum(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        SortedSet<Integer> primes = generatePrimes(n + 1);
        for (Integer p : primes) {
            if (primes.contains(n - p)) {
                result.add(p);
                result.add(n - p);
                return result;
            }
        }
        throw new RuntimeException("Impossible");
    }

    private static SortedSet<Integer> generatePrimes(int n) {
        SortedSet<Integer> result = new TreeSet<>();
        int[] nums = new int[n];
        for (int i = 2; i < n; ++i) {
            nums[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            while (i < n && nums[i] == 0) i++;
            if (i >= n) {
                return result;
            }
            result.add(i);
            for (int j = i; j < n; j += i) {
                nums[j] = 0;
            }
        }
        return result;
    }



}
