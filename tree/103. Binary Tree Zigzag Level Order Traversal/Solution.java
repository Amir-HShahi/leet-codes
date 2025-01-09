import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

class Solution {
    private boolean isUsual = true;
    private List<List<Integer>> tracker = new ArrayList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return tracker;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> levelOrder = new ArrayList<Integer>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (isUsual) 
                    levelOrder.add(node.val);
                else 
                    levelOrder.addFirst(node.val);
                
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            isUsual = !isUsual;
            tracker.add(levelOrder);
        }
        return tracker;

    }
}