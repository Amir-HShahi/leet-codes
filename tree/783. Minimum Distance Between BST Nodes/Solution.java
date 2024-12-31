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
    private int minValue = 100000;
    private int previousNodeVal = -1;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minValue;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (previousNodeVal != -1) {
            minValue = Math.min(minValue, root.val - previousNodeVal);
        }
        previousNodeVal = root.val;
        inorder(root.right);
    }

}