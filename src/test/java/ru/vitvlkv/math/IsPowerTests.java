package ru.vitvlkv.math;

import org.junit.Assert;
import org.junit.Test;

public class IsPowerTests {

    @Test
    public void test() {
        Assert.assertEquals(true, IsPower.isPower(27));
        Assert.assertEquals(false, IsPower.isPower(45));
        Assert.assertEquals(true, IsPower.isPower(256));
        Assert.assertEquals(true, IsPower.isPower(65536));


    }
}
