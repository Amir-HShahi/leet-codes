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

    private void postorderTraversalHandler(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalHandler(root.left);
        postorderTraversalHandler(root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalHandler(root);
        return this.list;
    }
}