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
        if ((root == null) // not found
                || (root == p) || (root == q)) // root is LCA, p or q is ancestor of other one
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q); // left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q); // right subtree

        if (left != null && right != null) { // one is in left subtree, another is in right subtree, it makes root LCA
            return root;
        }

        return left == null ? right : left; // lca has been found, both p and q has been in either right subtree or left
                                            // subtree
    }
}