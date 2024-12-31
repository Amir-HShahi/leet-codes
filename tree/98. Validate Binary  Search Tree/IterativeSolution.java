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

public class IterativeSolution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode previousNode = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root.left);
                root = root.left;
            }

            root = stack.pop();

            if (previousNode != null && (root.val <= previousNode.val))
                return false;
            
            previousNode = root;
            root = root.right;    
        }
        return true;
    }
}
