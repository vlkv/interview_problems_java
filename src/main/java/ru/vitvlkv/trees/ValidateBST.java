/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, new int[2]);
    }

    private boolean isValid(TreeNode root, int[] minMax) {
        if (root == null) {
            return true;
        }
        int[] leftMinMax = new int[2];
        boolean leftIsValid = isValid(root.left, leftMinMax);
        if (!leftIsValid) {
            return false;
        }
        if (leftMinMax[1] > root.val) {
            return false;
        }
        int[] rightMinMax = new int[2];
        boolean rightIsValid = isValid(root.right, rightMinMax);
        if (!rightIsValid) {
            return false;
        }
        if (rightMinMax[0] < root.val) {
            return false;
        }
        boolean leftOK = root.left == null || root.left.val < root.val;
        if (!leftOK) {
            return false;
        }

        minMax[0] = root.left != null ? leftMinMax[0] : root.val;
        minMax[1] = root.right != null ? rightMinMax[1] : root.val;

        return root.right == null || root.right.val > root.val;
    }
}