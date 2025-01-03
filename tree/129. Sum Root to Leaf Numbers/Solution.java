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

class Solution {
    private int sumNumbers = 0;

    public int sumNumbers(TreeNode root) {
        DepthFirstSearch(root);
        return sumNumbers;
    }

    private int tracker = 0;

    private void DepthFirstSearch(TreeNode root) {
        if (root == null)
            return;

        tracker = (tracker * 10) + root.val;
        if (isLeaf(root)) {
            sumNumbers += tracker;
            tracker = (tracker - root.val) / 10;
            return;
        }
        DepthFirstSearch(root.left);
        DepthFirstSearch(root.right);
        tracker = (tracker - root.val) / 10;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}