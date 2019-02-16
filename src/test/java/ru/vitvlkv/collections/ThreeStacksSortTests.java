package ru.vitvlkv.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ThreeStacksSortTests {

    @Test
    public void threeStacksSort7ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 5, 1, 7, 3, 8, 4));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 8}, stack.toArray());
    }

    @Test
    public void threeStacksSort8ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 5, 1, 7, 3, 8, 4, 7));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8}, stack.toArray());
    }

    @Test
    public void threeStacksSort9ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 7, 3, 8, 4, 7));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8, 14}, stack.toArray());
    }

    @Test
    public void threeStacksSort10ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 11, 7, 3, 8, 4, 7));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8, 11, 14}, stack.toArray());
    }

    @Test
    public void threeStacksSort11ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 1, 11, 7, 3, 8, 4, 7));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 1, 2, 3, 4, 5, 7, 7, 8, 11, 14}, stack.toArray());
    }

    @Test
    public void threeStacksSort12ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 1, 11, 42, 7, 3, 8, 4, 7));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 1, 2, 3, 4, 5, 7, 7, 8, 11, 14, 42}, stack.toArray());
    }

    @Test
    public void threeStacksSortEmptyTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {}, stack.toArray());
    }

    @Test
    public void threeStacksSort1ElemTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(42));
        ThreeStacksSort.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {42}, stack.toArray());
    }
}
