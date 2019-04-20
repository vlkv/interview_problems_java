package ru.vitvlkv.trees;

// https://leetcode.com/problems/construct-quad-tree
public class ConstructQuadTree {
    // Definition for a QuadTree node.
    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
    public static Node construct(int[][] grid) {
        // The algorithm is:
        // * Split the grid into 4 parts
        // * Create Nodes for each part
        // * Check if all the 4 Nodes are leafs with the same value, merge them into one leaf root
        // * Otherwise create a root non-leaf Node
        // * Return root Node
        int rows = grid.length;
        int cols = grid[0].length;
        return construct(grid, 0, rows, 0, cols);
    }

    private static Node construct(int[][] grid, int rBeg, int rEnd, int cBeg, int cEnd) {
        int rows = rEnd - rBeg;
        int cols = cEnd - cBeg;
        if (rows == 1 && cols == 1) {
            return new Node(grid[rBeg][cBeg] != 0, true, null, null, null, null);
        }

        int rMid = (rBeg + rEnd) / 2;
        int cMid = (cBeg + cEnd) / 2;
        Node topLeft = construct(grid, rBeg, rMid, cBeg, cMid);
        Node topRight = construct(grid, rBeg, rMid, cMid, cEnd);
        Node bottomLeft = construct(grid, rMid, rEnd, cBeg, cMid);
        Node bottomRight = construct(grid, rMid, rEnd, cMid, cEnd);
        Node[] nodes = new Node[] {topLeft, topRight, bottomLeft, bottomRight};
        boolean areAllLeafs = nodes[0].isLeaf;
        boolean areSameValue = true;
        for (int i = 1; i < nodes.length; ++i) {
            areAllLeafs = areAllLeafs && nodes[i].isLeaf;
            areSameValue = areSameValue && nodes[0].val == nodes[i].val;
        }
        if (areAllLeafs && areSameValue) {
            return new Node(nodes[0].val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}


