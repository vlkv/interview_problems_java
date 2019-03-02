package ru.vitvlkv.strings;

/*
Find whether string S is periodic.
Periodic indicates S = nP.
e.g.
S = "ababab", then n = 3, and P = "ab"
S = "xxxxxx", then n = 1, and P = "x"
S = "aabbaaabba", then n = 2, and P = "aabba"

Given string S, find out the P (repetitive pattern) of S.

https://careercup.com/question?id=5734073855639552
*/
public class IsPeriodicString {

    /*
    Problem:
    pattern in the pattern:
    S = "abcdabceabcdabce" then n = 2, P = "abcdabce"

    Complexity O(s.length)?..
    */
    public static String findRepetitivePattern(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = 0;
        int pLength = 1;

        int i = 1;
        char[] arr = s.toCharArray();
        while (i < arr.length) {

            boolean patternMatched = true;
            for (int j = 0; j < pLength && i + j < arr.length; ++j) {
                int k = i + j;
                if (k >= arr.length || arr[j] != arr[k]) {
                    patternMatched = false;
                    break;
                }
            }
            if (patternMatched) {
                n++;
                i += pLength;
            } else {
                i += 1;
                pLength = i;
                n = 0;
            }
        }
        return String.copyValueOf(arr, 0, pLength);
    }

}
