package ru.vitvlkv.arrays;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class CountOfSmallerNumbersAfterSelfTest {

    private static int[] NUMS;
    private static Integer[] COUNTS;
    static {
        try {
            File file = new File(CountOfSmallerNumbersAfterSelfTest.class.getClassLoader()
                    .getResource("count_of_smaller_numbers_after_self.json").getFile());
            String dataJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(dataJson).getAsJsonObject();
            JsonArray numsArr = jsonObj.get("nums").getAsJsonArray();
            NUMS = new int[numsArr.size()];
            for (int i = 0; i < numsArr.size(); ++i) {
                NUMS[i] = numsArr.get(i).getAsInt();
            }

            JsonArray countsArr = jsonObj.get("counts").getAsJsonArray();
            COUNTS = new Integer[countsArr.size()];
            for (int i = 0; i < countsArr.size(); ++i) {
                COUNTS[i] = countsArr.get(i).getAsInt();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
//        try {
//            Thread.currentThread().sleep(20000);
//        } catch (InterruptedException ex) {}
    }

    @Test
    public void testMy() {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
        long start = System.nanoTime();
        Integer[] result = solution.countSmallerMy(NUMS).toArray(new Integer[0]);
        System.out.println("Time taken " + (System.nanoTime() - start) / 1000000 + " ms");
        Assert.assertArrayEquals(Arrays.toString(result), COUNTS, result);
    }

    @Test
    public void testOthers() {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
        long start = System.nanoTime();
        Integer[] result = solution.countSmallerOthers(NUMS).toArray(new Integer[0]);
        System.out.println("Time taken " + (System.nanoTime() - start) / 1000000 + " ms");
        Assert.assertArrayEquals(Arrays.toString(result), COUNTS, result);
    }

}
