package ru.vitvlkv.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ThreeStacksSortN2Tests {

    @Test
    public void ThreeStacksSortN27ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 5, 1, 7, 3, 8, 4));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 8}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN28ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 5, 1, 7, 3, 8, 4, 7));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN29ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 7, 3, 8, 4, 7));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8, 14}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN210ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 11, 7, 3, 8, 4, 7));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 7, 7, 8, 11, 14}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN211ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 1, 11, 7, 3, 8, 4, 7));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 1, 2, 3, 4, 5, 7, 7, 8, 11, 14}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN212ElemsTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 14, 5, 1, 1, 11, 42, 7, 3, 8, 4, 7));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {1, 1, 2, 3, 4, 5, 7, 7, 8, 11, 14, 42}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN2EmptyTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {}, stack.toArray());
    }

    @Test
    public void ThreeStacksSortN21ElemTest() {
        Deque<Integer> stack = new ArrayDeque<>(Arrays.asList(42));
        ThreeStacksSortN2.sortStack(stack);

        Assert.assertArrayEquals(new Integer[] {42}, stack.toArray());
    }
}
