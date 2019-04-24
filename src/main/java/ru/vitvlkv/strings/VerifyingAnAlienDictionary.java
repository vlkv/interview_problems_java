package ru.vitvlkv.strings;

// https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/
public class VerifyingAnAlienDictionary {
}


/*
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        int curr = 0;
        int next = 1;
        while (next < words.length) {
            if (isGreater(words[curr], words[next], order)) {
                return false;
            }
            ++curr;
            ++next;
        }
        return true;
    }

    private static boolean isGreater(String a, String b, String order) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            char ach = a.charAt(i);
            char bch = b.charAt(j);
            int ai = order.indexOf(ach);
            int bi = order.indexOf(bch);
            if (ai > bi) {
                return true;
            } else if (ai < bi) {
                return false;
            }
            ++i;
            ++j;
        }
        return a.length() > b.length();
    }
}
* */