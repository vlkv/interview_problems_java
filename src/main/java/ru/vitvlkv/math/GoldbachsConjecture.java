package ru.vitvlkv.math;

import java.util.ArrayList;

public class GoldbachsConjecture {

    public static ArrayList<Integer> primesum(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        // NOTE: We could use SortedSet<Integer> for primes...
        int[] primes = generatePrimes(n + 1);
        for (int i = 0; i < primes.length; ++i) {
            int p = primes[i];
            if (p == 0) {
                continue;
            }
            for (int j = i; j < primes.length; ++j) {
                int p2 = primes[j];
                if (p2 == 0) {
                    continue;
                }
                if (p2 == n - p) {
                    result.add(p);
                    result.add(p2);
                    return result;
                }
            }
        }
        throw new RuntimeException("Impossible");
    }

    private static int[] generatePrimes(int n) {
        int[] nums = new int[n];
        for (int i = 2; i < n; ++i) {
            nums[i] = i;
        }
        for (int i = 0; i < n; ++i) { // TODO: i < Math.sqrt(n) or i*i < n
            while (i < n && nums[i] == 0) i++;
            if (i >= n) {
                return nums;
            }
            for (int j = i * 2; j < n; j += i) {
                nums[j] = 0;
            }
        }
        return nums;
    }

}
