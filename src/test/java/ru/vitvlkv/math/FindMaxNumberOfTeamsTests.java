package ru.vitvlkv.math;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxNumberOfTeamsTests {

    @Test
    public void test1() {
        int teamsCount = FindMaxNumberOfTeams.run(new int[] {2, 5, 4, 3, 1}, 3);
        Assert.assertEquals(5, teamsCount);
    }


}
