class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class UnbalancedTreeException extends Exception {

}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        try {
            calculateHeight(root);
            return true;
        } catch (UnbalancedTreeException e) {
            return false;
        }

    }

    private int calculateHeight(TreeNode root) throws UnbalancedTreeException {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);

        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            throw new UnbalancedTreeException();
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}