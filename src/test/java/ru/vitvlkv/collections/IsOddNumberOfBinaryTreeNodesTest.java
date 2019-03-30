package ru.vitvlkv.collections;

import org.junit.Assert;
import org.junit.Test;
import ru.vitvlkv.collections.IsOddNumberOfBinaryTreeNodes.Tree;

import java.util.Arrays;

public class IsOddNumberOfBinaryTreeNodesTest {

    @Test
    public void test1() {
        Tree<Integer> t = new Tree<>();
        Arrays.stream(new int[]{12, 10, 25, 1, 3}).forEach(t::add);
        Assert.assertTrue(IsOddNumberOfBinaryTreeNodes.isOddNumberOfNodes(t));

    }

    @Test
    public void test2() {
        Tree<Integer> t = new Tree<>();
        Arrays.stream(new int[]{12, 10, 25, 1, 3, 7}).forEach(t::add);
        Assert.assertFalse(IsOddNumberOfBinaryTreeNodes.isOddNumberOfNodes(t));

    }

    @Test
    public void test3() {
        Tree<Integer> t = new Tree<>();
        Arrays.stream(new int[]{12, 10, 25, 1, 3, 7, 8}).forEach(t::add);
        Assert.assertTrue(IsOddNumberOfBinaryTreeNodes.isOddNumberOfNodes(t));

    }
}
