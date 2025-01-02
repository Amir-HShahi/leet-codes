import java.util.Stack;

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

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        initializeStack(root);
    }

    public int next() {
        return stack.pop().val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void initializeStack(TreeNode root) {
        if (root == null)
            return;
        initializeStack(root.right);
        stack.push(root);
        initializeStack(root.left);
    }
}