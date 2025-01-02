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
    private List<List<Integer>> pathSumLists = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DepthFirstSearch(root, targetSum, new ArrayList<>());
        return pathSumLists;
    }

    private void DepthFirstSearch(TreeNode root, int targetSum, List<Integer> tracker) {
        if (root == null)
            return;

        tracker.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            pathSumLists.add(new ArrayList<>(tracker));
            tracker.removeLast();
            return;
        }

        DepthFirstSearch(root.left, targetSum, tracker);
        DepthFirstSearch(root.right, targetSum, tracker);
        tracker.removeLast();
    }
}