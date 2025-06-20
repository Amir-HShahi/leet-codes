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
        TreeNode lca = root;

        while (lca != null) {
            int val = root.val;
            if (p.val < val && q.val < val) {
                lca = lca.left;
            } else if (p.val > val && q.val > val) {
                lca = lca.right;
            } else {
                return lca;
            }
        }
        return lca;
    }
}