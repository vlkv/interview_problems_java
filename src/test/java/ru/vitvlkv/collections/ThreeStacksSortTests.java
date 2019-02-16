package ru.vitvlkv.collections;

import org.junit.Assert;
import org.junit.Test;
import ru.vitvlkv.collections.collections.ThreeStacksSort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ThreeStacksSortTests {

    @Test
    public void threeStacksSort8ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 5, 1, 7, 3, 8, 4, 7));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8}, stack.toArray());
    }

    @Test
    public void threeStacksSort7ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 5, 1, 7, 3, 8, 4));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 8}, stack.toArray());
    }


    @Test
    public void threeStacksSortEmptyTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {}, stack.toArray());
    }
}
