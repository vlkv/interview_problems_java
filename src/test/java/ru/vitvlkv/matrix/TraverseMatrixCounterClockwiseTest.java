package ru.vitvlkv.matrix;

import org.junit.Assert;
import org.junit.Test;

public class TraverseMatrixCounterClockwiseTest {

    @Test
    public void test1() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {2, 4, 5, 1},
            {7, 9, 6, 2},
            {3, 5, 2, 7},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(5, res);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(2, res);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(5, res);
    }


    @Test
    public void test4() {
        int[][] matrix = {
                {1, 2, 3, 4},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(4, res);
    }


    @Test
    public void test5() {
        int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(4, res);
    }

    @Test
    public void test6() {
        int[][] matrix = {
                {42},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(42, res);
    }

    @Test
    public void test7() {
        int[][] matrix = {
                {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
        };
        int res = TraverseMatrixCounterClockwise.traverseToLastElem(matrix);
        Assert.assertEquals(9, res);
    }
}