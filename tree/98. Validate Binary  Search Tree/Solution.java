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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = true;
        if (root.left != null) {
            flag = root.left.val < root.val;
        }
        if (root.right != null) {
            flag = root.right.val > root.val;
        }

        return flag ? isValidBST(root.left) && isValidBST(root.right) : false;
    }
}