class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int minValue = 100000;
    private Integer previousNodeVal = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return minValue;
        }
        minDiffInBST(root.left);
        if (previousNodeVal != null) {
            minValue = Math.min(minValue, root.val - previousNodeVal);
        }
        previousNodeVal = root.val;
        minDiffInBST(root.right);

        return minValue;
    }

}