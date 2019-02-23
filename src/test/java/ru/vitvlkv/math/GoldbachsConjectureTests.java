package ru.vitvlkv.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GoldbachsConjectureTests {
    @Test
    public void test() {
        List<Integer> res = GoldbachsConjecture.primesum(4);
        Assert.assertArrayEquals(new Integer[]{2, 2}, res.toArray());
    }

}
