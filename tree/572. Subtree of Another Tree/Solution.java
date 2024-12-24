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
    private boolean compareNodes(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }

        return first.val == second.val
                ? compareNodes(first.right, second.right) && compareNodes(first.left, second.left)
                : false;

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return compareNodes(root, subRoot);
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}