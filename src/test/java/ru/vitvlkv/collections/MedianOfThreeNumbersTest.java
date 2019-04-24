package ru.vitvlkv.collections;

import org.junit.Assert;
import org.junit.Test;

public class MedianOfThreeNumbersTest {
    @Test
    public void test1() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(1, 3, 5));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(3, 1, 5));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(1, 5, 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(5, 3, 1));
    }

    @Test
    public void test5() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(3, 5, 1));
    }

    @Test
    public void test6() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(5, 1, 3));
    }

    // With equal greater elems:

    @Test
    public void test7() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(1, 3, 3));
    }

    @Test
    public void test8() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(3, 1, 3));
    }

    @Test
    public void test9() {
        Assert.assertEquals(3, MedianOfThreeNumbers.median(3, 3, 1));
    }

    // With equal less elems:

    @Test
    public void test10() {
        Assert.assertEquals(1, MedianOfThreeNumbers.median(1, 1, 3));
    }

    @Test
    public void test11() {
        Assert.assertEquals(1, MedianOfThreeNumbers.median(1, 3, 1));
    }

    @Test
    public void test12() {
        Assert.assertEquals(1, MedianOfThreeNumbers.median(3, 1, 1));
    }

    // With all three equal elems:

    @Test
    public void test13() {
        Assert.assertEquals(1, MedianOfThreeNumbers.median(1, 1, 1));
    }

}
