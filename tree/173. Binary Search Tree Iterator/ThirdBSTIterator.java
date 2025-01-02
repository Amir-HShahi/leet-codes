import java.util.ArrayList;

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

public class ThirdBSTIterator {
    private int index = 0;
    private ArrayList<TreeNode> inorderNodes = new ArrayList<TreeNode>();
    private int size;

    public ThirdBSTIterator(TreeNode root) {
        inorderInit(root);
        this.size = inorderNodes.size();
    }

    public int next() {
        return inorderNodes.get(index++).val;
    }

    public boolean hasNext() {
        return index < size;
    }

    private void inorderInit(TreeNode root) {
        if (root == null)
            return;

        inorderInit(root.left);
        inorderNodes.add(root);
        inorderInit(root.right);
    }
}
