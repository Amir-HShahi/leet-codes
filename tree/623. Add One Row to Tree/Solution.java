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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) { // tree is empty
            return root;
        }
        if (depth == 1) { // At root level, so convert root
            return new TreeNode(val, root, null);
        }
        if (depth == 2) { // At root children, so convert children
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        // more depth
        root.left = addOneRow(root.left, val, depth - 1);
        root.right = addOneRow(root.right, val, depth - 1);
        return root;
    }
}