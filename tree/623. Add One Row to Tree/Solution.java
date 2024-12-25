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
        if (root == null) {
            return root;
        }
        if (depth == 1) {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            return newNode;
        }
        root.left = addOneRow(root.left, val, depth--);
        root.right = addOneRow(root.right, val, depth--);
        return root;
    }
}