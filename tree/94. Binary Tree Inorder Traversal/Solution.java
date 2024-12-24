import java.util.ArrayList;
import java.util.List;

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
    ArrayList<Integer> list = new ArrayList<Integer>();

    private void inorderTraversalHandler(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalHandler(root.left);
        list.add(root.val);
        inorderTraversalHandler(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHandler(root);
        return this.list;
    }
}