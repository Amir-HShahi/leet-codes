class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        int currVal, pVal = p.val, qVal = q.val;
        while (curr != null) {
            currVal = curr.val;

            if (pVal < currVal && qVal < currVal) {
                curr = curr.left;
            } else if (pVal > currVal && qVal > currVal) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}