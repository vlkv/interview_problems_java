package ru.vitvlkv.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 438. Find All Anagrams in a String
* https://leetcode.com/problems/find-all-anagrams-in-a-string/
* 
* For s1 = "DKFACBFGACDKLBCABDL" and s2="ABC"
*               +++  ++-  +++
*                          +++
* Result of algorithm should be: [3, 13, 14].
* The idea of optimal solution is to have a moving window of size s2.length()
* Increment counter for every char that is added to the window and
* decrement counter for every char that is removed from the window...
* */
public class FindAllAnagramsOfS2InS1 {

    // Time is linear O(s1.length())
    public static List<Integer> solve(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        if (s1.length() < s2.length()) {
            return result;
        }
        Map<Character, Integer> expectedCounts = newMap(s2, s2.length());
        Map<Character, Integer> actualCounts = newMap(s1, s2.length());
        if (isMatch(expectedCounts, actualCounts)) {
            result.add(0);
        }
        for (int i = s2.length(); i < s1.length(); ++i) {
            char newCh = s1.charAt(i);
            addCount(actualCounts, newCh, 1);

            char oldCh = s1.charAt(i - s2.length());
            addCount(actualCounts, oldCh, -1);

            if (isMatch(expectedCounts, actualCounts)) {
                result.add(i - s2.length() + 1);
            }
        }
        return result;
    }

    // Time is O(<distinct letters in s2>) = O(1)
    private static boolean isMatch(Map<Character, Integer> expected, Map<Character, Integer> actual) {
        for (Map.Entry<Character, Integer> e : expected.entrySet()) {
            if (!e.getValue().equals(actual.get(e.getKey()))) {
                return false;
            }
        }
        // NOTE: We don't care about actual keys that don't exist in expected
        return true;
    }

    private static void addCount(Map<Character, Integer> m, Character ch, int count) {
        Integer c = m.get(ch);
        if (c == null) {
            m.put(ch, count);
        } else {
            m.put(ch, c + count);
        }
    }

    private static Map<Character, Integer> newMap(String s, int stopIndexExclusive) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < stopIndexExclusive && i < s.length(); ++i) {
            char ch = s.charAt(i);
            result.compute(ch, (ch2, count) -> count == null ? 1 : count + 1);
        }
        return result;
    }
}
