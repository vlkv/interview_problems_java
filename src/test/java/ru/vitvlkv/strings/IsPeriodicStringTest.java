package ru.vitvlkv.strings;

import org.junit.Assert;
import org.junit.Test;

public class IsPeriodicStringTest {

    @Test
    public void test1() {
        String p = IsPeriodicString.findRepetitivePattern("ababab");
        Assert.assertEquals("ab", p);
    }

    @Test
    public void test2() {
        String p = IsPeriodicString.findRepetitivePattern("abcabcabcabc");
        Assert.assertEquals("abc", p);
    }

    @Test
    public void test3() {
        String p = IsPeriodicString.findRepetitivePattern("xxxxxx");
        Assert.assertEquals("x", p);
    }

    @Test
    public void test4() {
        String p = IsPeriodicString.findRepetitivePattern("aabbaaabba");
        Assert.assertEquals("aabba", p);
    }

    @Test
    public void test5() {
        String p = IsPeriodicString.findRepetitivePattern("abcdabceabcdabce");
        Assert.assertEquals("abcdabce", p);
    }

    @Test
    public void test6NoPattern() {
        String p = IsPeriodicString.findRepetitivePattern("abcde");
        Assert.assertEquals("abcde", p);
    }

    @Test
    public void test7EmptyStr() {
        String p = IsPeriodicString.findRepetitivePattern("");
        Assert.assertEquals("", p);
    }


}
