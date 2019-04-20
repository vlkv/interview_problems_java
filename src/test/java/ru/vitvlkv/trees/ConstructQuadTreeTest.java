package ru.vitvlkv.trees;

import org.junit.Assert;
import org.junit.Test;

public class ConstructQuadTreeTest {

    @Test
    public void test1() {
        int[][] grid = new int[][] {
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}};

        ConstructQuadTree.Node root = ConstructQuadTree.construct(grid);
        Assert.assertNotNull(root); // TODO: need root.toString and assert with tree string representation
    }

}
