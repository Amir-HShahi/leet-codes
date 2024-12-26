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

    private void preorderTraversalHandler(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalHandler(root.left);
        preorderTraversalHandler(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalHandler(root);
        return this.list;
    }
}