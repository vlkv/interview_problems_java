package ru.vitvlkv.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* For s1 = "DKFACBFGACDKLBCABDL" and s2="ABC"
*               +++  ++-  +++
*                          +++
* Result of algorithm should be: [3, 13]
* */
public class FindAllAnagramsOfS2InS1 {

    public static List<Integer> solve(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        int matches = 0;
        Map<Character, Integer> s3 = newMap(s2);
        for (int i = 0; i < s1.length(); ++i) {
            char ch = s1.charAt(i);
            if (hasChar(s3, ch)) {
                matches += 1;
            } else if (matches > 0) {
                s3 = newMap(s2);
                matches = 0;
            }
            if (matches == s2.length()) {
                result.add(i - s2.length() + 1);
                s3 = newMap(s2);
                matches = 0;
            }
        }
        return result;
    }

    private static boolean hasChar(Map<Character, Integer> charCounts, char ch) {
        Integer count = charCounts.get(ch);
        if (count == null || count == 0) {
            return false;
        }
        charCounts.put(ch, count - 1);
        return true;
    }

    private static Map<Character, Integer> newMap(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            result.compute(ch, (ch2, count) -> count == null ? 1 : count + 1);
        }
        return result;
    }
}
