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

public class SecondBSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public SecondBSTIterator(TreeNode root) {
        addLeftTree(root);
    }

    public int next() {
        TreeNode key = stack.pop();
        addLeftTree(key.right);
        return key.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addLeftTree(TreeNode root) {
        if (root == null)
            return;
        stack.push(root);
        addLeftTree(root.left);
    }
}
