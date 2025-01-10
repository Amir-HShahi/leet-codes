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
    private int preorderCounter = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderCounter++]);
        int pivotIndex = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                pivotIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, start, pivotIndex - 1);
        root.right = buildTree(preorder, inorder, pivotIndex + 1, end);

        return root;
    }
}