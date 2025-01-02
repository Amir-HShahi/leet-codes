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

public class SecondSolution {
    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;

    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = calculateHeight(root.left);
        if (leftTreeHeight == -1) {
            return -1;
        }
        int rightTreeHeight = calculateHeight(root.right);
        if (rightTreeHeight == -1 || Math.abs(rightTreeHeight- leftTreeHeight) > 1) {
            return -1;
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}