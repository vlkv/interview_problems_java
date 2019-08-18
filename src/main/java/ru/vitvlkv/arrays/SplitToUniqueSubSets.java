package ru.vitvlkv.arrays;

import java.util.*;

public class SplitToUniqueSubSets {

    // O(n*n) time in the worst case, O(n) average?..
    // O(n) space for hash sets
    public String[][] split(String[] strs) {
        List<Set<String>> sets = new ArrayList<>();
        for (int i = 0; i < strs.length; ++i) {
            String str = strs[i];
            Set<String> set = findUnvisitedSet(sets, str);
            if (set == null) {
                Set<String> newSet = new HashSet<>();
                newSet.add(str);
                sets.add(newSet);
            } else {
                set.add(str);
            }
        }

        String[][] res = new String[sets.size()][];
        int i = 0;
        for (Set<String> set : sets) {
            res[i++] = set.stream().toArray(String[]::new);
        }
        return res;
    }

    private Set<String> findUnvisitedSet(List<Set<String>> sets, String str) {
        for (int i = 0; i < sets.size(); ++i) {
            Set<String> set = sets.get(i);
            if (!set.contains(str)) {
                return set;
            }
        }
        return null;
    }
}
