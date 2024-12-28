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

public class Solution {
    private int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return maxDepth;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = depth > maxDepth ? depth - 1 : maxDepth;
            return;
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
}