package ru.vitvlkv.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FindAllAnagramsOfS2InS1Test {

    @Test
    public void test() {
        String s1 = "DKFACBFGACDKLBCABDL";
        String s2="ABC";
        List<Integer> result = FindAllAnagramsOfS2InS1.solve(s1, s2);
        Assert.assertArrayEquals(new Integer[]{3, 13, 14}, result.toArray());
    }

    @Test
    public void test2() {
        String s1 = "DKFACBFGACDKLBCABDL";
        String s2="ABCB";
        List<Integer> result = FindAllAnagramsOfS2InS1.solve(s1, s2);
        Assert.assertArrayEquals(new Integer[]{13}, result.toArray());
    }

    @Test
    public void test3() {
        String s1 = "BABC";
        String s2="ABCB";
        List<Integer> result = FindAllAnagramsOfS2InS1.solve(s1, s2);
        Assert.assertArrayEquals(new Integer[]{0}, result.toArray());
    }

    @Test
    public void test4() {
        String s1 = "BABC";
        String s2="ABCBB";
        List<Integer> result = FindAllAnagramsOfS2InS1.solve(s1, s2);
        Assert.assertArrayEquals(new Integer[]{}, result.toArray());
    }
}
