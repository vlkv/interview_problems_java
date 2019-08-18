package ru.vitvlkv.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SplitToUniqueSubSetsTest {

    @Test
    public void test1() {
        SplitToUniqueSubSets solver = new SplitToUniqueSubSets();
        String[] str = {"a", "b", "c", "d", "a", "b", "a", "z", "x", "z", "x", "a"};
        String[][] res = solver.split(str);
        // have to sort the res
        for (String[] strs : res) {
            Arrays.sort(strs);
        }
        Assert.assertArrayEquals(new String[][] {
            {"a", "b", "c", "d", "x", "z"},
            {"a", "b", "x", "z"},
            {"a"},
            {"a"}}, res);
    }
}
