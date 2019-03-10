class TraverseMatrixCounterClockwiseTest {

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
}