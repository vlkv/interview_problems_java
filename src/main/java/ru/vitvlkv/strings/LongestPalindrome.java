package ru.vitvlkv.strings;

// https://leetcode.com/problems/longest-palindrome/submissions/
public class LongestPalindrome {
}

/*
class Solution {
    public int longestPalindrome(String s) {
        //Map<Character, Integer> m = new HashMap<Character, Integer>();
        int size = Math.max('z'-'A', 'Z'-'a');
        int[] m = new int[size + 1];

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int j = ch - 'A';
            int count = m[j];
            m[j] = count + 1;
        }

        boolean oneOddAdded = false;
        int result = 0;
        for (int count : m) {
            result += (count / 2) * 2;
            if (count % 2 == 1 && !oneOddAdded) {
                result += 1;
                oneOddAdded = true;
            }
        }
        return result;
    }
}
 */