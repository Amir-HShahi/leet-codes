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
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null)
            return true;

        if (leftRoot == null || rightRoot == null)
            return false;

        return (leftRoot.val == rightRoot.val) && isSymmetric(leftRoot.left, rightRoot.right)
                && isSymmetric(leftRoot.right, rightRoot.left);
    }
}